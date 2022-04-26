package Fichas.Ficha4.Ex2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Encomenda {

    private String nomeCliente;
    private int nif;
    private String moradaCliente;
    private int nEnc;
    private LocalDate dataHora;
    private List<LinhaEncomenda> linhasEnc;

    // Empty constructor
    public Encomenda () {
        this.nomeCliente = "n/a";
        this.nif = 0;
        this.moradaCliente = "n/a";
        this.nEnc = 0;
        this.dataHora = LocalDate.now();
        this.linhasEnc = new ArrayList<>();
    }

    // Full variable constructor
    public Encomenda (String nomeCliente, int nif, String moradaCliente,
                      int nEnc, LocalDate dataHora, ArrayList<LinhaEncomenda> linhasEnc) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.moradaCliente = moradaCliente;
        this.nEnc = nEnc;
        this.dataHora = dataHora;
        this.linhasEnc = linhasEnc;
    }

    // Clone constructor
    public Encomenda (Encomenda e) {
        this.nomeCliente = e.nomeCliente;
        this.nif = e.nif;
        this.moradaCliente = e.moradaCliente;
        this.nEnc = e.nEnc;
        this.dataHora = e.dataHora;
        setLinhasEnc(e.getLinhasEnc());
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMoradaCliente() {
        return moradaCliente;
    }

    public void setMoradaCliente(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    public int getnEnc() {
        return nEnc;
    }

    public void setnEnc(int nEnc) {
        this.nEnc = nEnc;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public ArrayList<LinhaEncomenda> getLinhasEnc() {
        ArrayList<LinhaEncomenda> cp = new ArrayList<>();
        for (LinhaEncomenda linha : this.linhasEnc) {
            cp.add(linha.clone());
        }
        return cp;
    }

    public void setLinhasEnc(ArrayList<LinhaEncomenda> le) {
        this.linhasEnc = new ArrayList<>();
        for (LinhaEncomenda l : le) {
            this.linhasEnc.add(l.clone());
        }
    }

    // b) ------------------------------------------------------------------
    // ii)
    public double calculaValorTotal1() {
        double total=0;

        for (LinhaEncomenda linhaEnc : this.linhasEnc) {
            total += linhaEnc.calculaValorLinhaEnc();
        }

        return total;
    }

    // > Iterador interno <
    public double calculaValorTotal2() {
        return this.linhasEnc.stream().mapToDouble(LinhaEncomenda :: calculaValorLinhaEnc).sum();
    }

    // iii)
    public double calculaValorDesconto1() {
        double desconto = 0;

        for (LinhaEncomenda linhaEnc : this.linhasEnc) {
            desconto += linhaEnc.calculaValorDesconto();
        }

        return desconto;
    }

    // > Iterador interno <
    public double calculaValorDesconto2() {
        return this.linhasEnc.stream().mapToDouble(LinhaEncomenda :: calculaValorDesconto).sum();
    }

    // iv)
    public int numeroTotalProdutos1() {
        int qt=0;

        for (LinhaEncomenda linhaEnc : this.linhasEnc) {
            qt += linhaEnc.getQuantidade();
        }

        return qt;
    }

    // > Iterador interno <
    public int numeroTotalProdutos2() {
        return this.linhasEnc.stream().mapToInt(LinhaEncomenda :: getQuantidade).sum();
    }


    // v)
    public boolean existeProdutoEncomenda1(String refProduto) {

        for (LinhaEncomenda linhaEnc : this.linhasEnc) {
            if (linhaEnc.getReferencia().equals(refProduto)) return true;
        }
        return false;
    }

    // > Iterador interno <
    public boolean existeProdutoEncomenda2(String refProduto) {
        return this.linhasEnc.stream().anyMatch(le -> le.getReferencia().equals(refProduto));
    }

    // vi)
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhasEnc.add(linha.clone());
    }

    // vii)
    public void removeProduto1(String codProd) {

        for (LinhaEncomenda linhaEnc : this.linhasEnc) {
            if (linhaEnc.getReferencia().equals(codProd)) {
                this.linhasEnc.remove(linhaEnc);
                break;
            }
        }
    }

    // > Iterador interno <
    public void removeProduto2(String codProd) {
        this.linhasEnc.removeIf(le -> le.getReferencia().equals(codProd));
    }

    //----------------------------------------------------------------------
    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", nif=" + nif +
                ", moradaCliente='" + moradaCliente + '\'' +
                ", nEnc=" + nEnc +
                ", dataHora=" + dataHora +
                ", linhasEnc=" + linhasEnc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getNif() == encomenda.getNif() &&
                getnEnc() == encomenda.getnEnc() &&
                Objects.equals(getNomeCliente(), encomenda.getNomeCliente()) &&
                Objects.equals(getMoradaCliente(), encomenda.getMoradaCliente()) &&
                Objects.equals(getDataHora(), encomenda.getDataHora()) &&
                Objects.equals(getLinhasEnc(), encomenda.getLinhasEnc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomeCliente(), getNif(), getMoradaCliente(), getnEnc(), getDataHora(), getLinhasEnc());
    }
}
