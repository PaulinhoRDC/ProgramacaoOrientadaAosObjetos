package Fichas.Ficha3;

public class LinhaEncomenda {

    /*

     Referência produto, que é uma String com o código que internamente se atribui ao produto
     Descrição do produto
     Preço do produto antes de impostos
     Quantidade encomendada
     Regime de imposto que se aplica ao produto -> é um valor em percentagem (ex: 6%, 13%, 23%, etc.)
     Valor (em percentagem) do desconto comercial em relação ao preço antes de impostos

     */

    private String ref;
    private String descr;
    private int preco;
    private int quant;
    private int imposto;
    private int desconto;



    public LinhaEncomenda(){
        ref = " ";
        descr = " ";
        preco = 0;
        quant = 0;
        imposto = 0;
        desconto = 0;

    }

    public LinhaEncomenda(String codigo, String descricao, int preco, int quantidade, int imposto, int desconto){
        this.ref = codigo;       // podia ser ref = codigo, pois ia manter ambiguidade
        this.descr = descricao;
        this.preco = preco;
        this.quant = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public LinhaEncomenda(LinhaEncomenda outra){

    }

    // Getter && Setter 's //


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getImposto() {
        return imposto;
    }

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}
