package Fichas.Ficha6AnoPassado;

import java.util.List;

public class VeiculoPremium extends Veiculo implements BonificaKms{
    private double taxaDeLuxo;
    private int pontosPorKm;

    // CONSTRUTORES //

    public VeiculoPremium() {
        super();
        this.taxaDeLuxo = 0;
        this.pontosPorKm = 0;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo, double taxaDeLuxo, int pontosPorKm) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosPorKm = pontosPorKm;
    }

    public VeiculoPremium(VeiculoPremium v) {
        super(v);
        this.taxaDeLuxo = v.taxaDeLuxo;
        this.pontosPorKm = v.pontosPorKm;
    }

    // GETTER'S & SETTER'S //

    public double getTaxaDeLuxo() {
        return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double taxaDeLuxo) {
        this.taxaDeLuxo = taxaDeLuxo;
    }

    // MÉTODOS DA INTERFACE BonificaKms //

    public int getPontosPorKm() {
        return this.pontosPorKm;
    }

    public void setPontosPorKm(int pontosPorKm) {
        this.pontosPorKm = pontosPorKm;
    }

    // MÉTODO DA CLASSE VEÍCULO //

    public double getCustoPorKm() {
        return custoPorKm() * this.taxaDeLuxo;
    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //

    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Veículo Premium {\n");
        sb.append(super.toString());
        sb.append("\tTaxa De Luxo = ").append(taxaDeLuxo).append('\n');
        sb.append("\tPontos Por Km = ").append(pontosPorKm).append('\n');
        sb.append("}");
        return sb.toString();
    }

}
