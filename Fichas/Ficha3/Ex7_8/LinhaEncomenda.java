package Fichas.Ficha3.Ex7_8;

import java.util.Objects;

public class LinhaEncomenda {

    /*

     Referência produto, que é uma String com o código que internamente se atribui ao produto
     Descrição do produto
     Preço do produto antes de impostos
     Quantidade encomendada
     Regime de imposto que se aplica ao produto -> é um valor em percentagem (ex: 6%, 13%, 23%, etc.)
     Valor (em percentagem) do desconto comercial em relação ao preço antes de impostos

     */

        private String codigo;
        private String descricao;
        private int preco;
        private int quantidade;
        private float imposto;
        private int desconto ;

        public LinhaEncomenda() {
            this.codigo = " ";
            this.descricao = " ";
            this.preco = 0;
            this.quantidade = 0;
            this.imposto = 0.0f;
            this.desconto = 0;
        }

        public LinhaEncomenda(String codigo, String descricao, int preco, int quantidade, float imposto, int desconto) {
            this.codigo = codigo;
            this.descricao = descricao;
            this.preco = preco;
            this.quantidade = quantidade;
            this.imposto = imposto;
            this.desconto = desconto;
        }

        public LinhaEncomenda(LinhaEncomenda e) {
            this.codigo = e.getCodigo();
            this.descricao = e.getDescricao();
            this.preco = e.getPreco();
            this.quantidade = e.getQuantidade();
            this.imposto = e.getImposto();
            this.desconto = e.getDesconto();
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getPreco() {
            return preco;
        }

        public void setPreco(int preco) {
            this.preco = preco;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public float getImposto() {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LinhaEncomenda that = (LinhaEncomenda) o;
            return preco == that.preco && quantidade == that.quantidade && imposto == that.imposto && desconto == that.desconto && Objects.equals(codigo, that.codigo) && Objects.equals(descricao, that.descricao);
        }

        @Override
        public String toString() {
            return "LinhaEncomenda{" +
                    "codigo='" + codigo + '\'' +
                    ", descricao='" + descricao + '\'' +
                    ", preco=" + preco +
                    ", quantidade=" + quantidade +
                    ", imposto=" + imposto +
                    ", desconto=" + desconto +
                    '}';
        }

        // b)
        public double calculaValorLinhaEnc() {
            int precoComDesconto = this.preco - (this.preco * this.desconto)/100;
            return precoComDesconto + (precoComDesconto * this.imposto);
        }

        // c)
        public double calculaValorDesconto() {
            int precoComDesconto = this.preco - (this.preco * this.desconto)/100;
            return this.preco - precoComDesconto;
        }
}
