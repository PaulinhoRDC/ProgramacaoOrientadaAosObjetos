package Fichas.Ficha6AnoPassado;

import java.util.List;

public class VeiculoOcasiao extends Veiculo {
    private boolean emDesconto;

    // CONSTRUTORES //

    public VeiculoOcasiao() {
        super();
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm, double precoTeoricoPorKm, List<Integer> classificacoes, boolean emDesconto) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes);
        this.emDesconto = emDesconto;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, boolean emDesconto) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms);
        this.emDesconto = emDesconto;
    }

    public VeiculoOcasiao(String id, String marca, String modelo, int ano, double velMediaPorKm,
                          double precoTeoricoPorKm, List<Integer> classificacoes, double kms, double kmsUltimo, boolean emDesconto) {
        super(id, marca, modelo, ano, velMediaPorKm, precoTeoricoPorKm, classificacoes, kms, kmsUltimo);
        this.emDesconto = emDesconto;
    }

    public VeiculoOcasiao(VeiculoOcasiao v) {
        super(v);
        this.emDesconto = v.emDesconto;
    }

    // GETTER'S & SETTER'S //

    public boolean isEmDesconto() {
        return this.emDesconto;
    }

    public void setEmDesconto(boolean emDesconto) {
        this.emDesconto = emDesconto;
    }

    // MÉTODO DA CLASSE VEÍCULO //

    public double getCustoPorKm() {
        return (emDesconto ? custoPorKm() * 0.75 : custoPorKm());
    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //

    public VeiculoOcasiao clone() {
        return new VeiculoOcasiao(this);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Veículo Ocasião {\n");
        sb.append(super.toString());
        sb.append("\tEm desconto = ").append(emDesconto).append('\n');
        sb.append("}");
        return sb.toString();
    }
}
