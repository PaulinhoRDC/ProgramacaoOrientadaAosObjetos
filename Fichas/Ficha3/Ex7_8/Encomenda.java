package Fichas.Ficha3.Ex7_8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Encomenda extends LinhaEncomenda {
    private String nome;
    private int nif;
    private String morada;
    private String nrEnc;
    private LocalDate dataEnc;
    //private LinhaEncomenda[] linhaEnc;
    private List<LinhaEncomenda> linhaEnc;


    public Encomenda() {
        this.nome = " ";
        this.nif = 0;
        this.morada = " ";
        this.nrEnc = " ";
    }

    public Encomenda(String nome, int nif, String morada, String nrEnc, LocalDate dataEnc, /* LinhaEncomenda[] */ List<LinhaEncomenda> linhaEnc) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.nrEnc = nrEnc;
        this.dataEnc = dataEnc;
        this.linhaEnc = linhaEnc;
    }

    public Encomenda(Encomenda e) {
        this.nome = e.getNome();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.nrEnc = e.getNrEnc();
        this.linhaEnc = e.getLinhaEnc();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNrEnc() {
        return nrEnc;
    }

    public void setNrEnc(String nrEnc) {
        this.nrEnc = nrEnc;
    }

    public LocalDate getDataEnc() {
        return dataEnc;
    }

    public void setDataEnc(LocalDate dataEnc) {
        this.dataEnc = dataEnc;
    }

    public /* LinhaEncomenda[] */ List<LinhaEncomenda> getLinhaEnc() { // VERIFICAR
        return linhaEnc;
    }

    public void setLinhaEnc(/* LinhaEncomenda[] */ List<LinhaEncomenda> linhaEnc) { // VERIFICAR
        this.linhaEnc = linhaEnc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Encomenda encomenda = (Encomenda) o;
        return nif == encomenda.nif && Objects.equals(nome, encomenda.nome) && Objects.equals(morada, encomenda.morada) && Objects.equals(nrEnc, encomenda.nrEnc) && Objects.equals(dataEnc, encomenda.dataEnc) /* && Arrays.equals(linhaEnc, encomenda.linhaEnc) */;
    }


    // b)
    public double calculaValorTotal() {
        double soma = 0;
        for(LinhaEncomenda linhas : linhaEnc) {
            soma += linhas.calculaValorLinhaEnc();
        }
        return soma;
    }

    // c)
    public double calculaValorDesconto() {
        double soma = 0;
        for(LinhaEncomenda linhas : linhaEnc) {
            soma += linhas.calculaValorDesconto();
        }
        return soma;
    }

    // d)
    public int numeroTotalProdutos() {
        int total = 0;
        for(LinhaEncomenda linhas : linhaEnc) {
            total += linhas.getQuantidade();
        }
        return total;
    }

    // e)
    public boolean existeProdutorEncomenda(String refProduto) { // VERIFICAR
        for(LinhaEncomenda linhas : linhaEnc) {
            if(Objects.equals(refProduto, linhas.getCodigo())) return true;
        }
        return false;
    }

    // f)
    public void adicionaLinha(LinhaEncomenda linha) {
        LinhaEncomenda[] ar = this.getLinhaEnc().toArray(new LinhaEncomenda[0]);
        LinhaEncomenda[] novo = new LinhaEncomenda[ar.length+1];
        System.arraycopy(ar,0,novo,0,ar.length);
        novo[ar.length] = new LinhaEncomenda(linha);
        this.setLinhaEnc(List.of(novo));
    }

    // g)
    public void removeProduto(String codProd){
        LinhaEncomenda[] ar = this.getLinhaEnc().toArray(new LinhaEncomenda[0]);
        LinhaEncomenda[] novo = new LinhaEncomenda[ar.length-1];
        int j=0;
        for(int i = 0; i < ar.length; i++){
            if(!ar[i].getCodigo().equals(codProd)){
                novo[j] = ar[i];
                j++;
            }
        }
        System.arraycopy(novo, 0, ar, 0, novo.length);
    }
}

