package Fichas.Ficha4.Ex2;

public class TesteEncomenda {

    public static void main (String [] args) {
        Encomenda c = new Encomenda();
        LinhaEncomenda l1 = new LinhaEncomenda();
        LinhaEncomenda l2 = new LinhaEncomenda();

        c.setNomeCliente("Mariana");
        c.setNif(253111111);
        c.setMoradaCliente("Rua x, n_porta x, andar x");
        c.setnEnc(1);

        l1.setReferencia("3643/017/250");
        l1.setDescricao("Jeans Mid Rise Cropped Flare, Branco");
        l1.setPreco(19.95);
        l1.setQuantidade(1);
        l1.setImposto(0.23);
        l1.setDesconto(0.2);
        c.adicionaLinha(l1);

        l2.setReferencia("8197/053/400");
        l2.setDescricao("Jeans Hi Rise Sculpt, Azul");
        l2.setPreco(19.95);
        l2.setQuantidade(1);
        l2.setImposto(0.23);
        l2.setDesconto(0.1);
        c.adicionaLinha(l2);

        System.out.println(c.toString());

        // b)
        // ii)
        double total1 = c.calculaValorTotal1();
        System.out.println("ii) " + total1);

        double total2 = c.calculaValorTotal2();
        System.out.println("ii) " + total2);

        // iii)
        double desconto1 = c.calculaValorDesconto1();
        System.out.println("iii) " + desconto1);

        double desconto2 = c.calculaValorDesconto2();
        System.out.println("iii) " + desconto2);

        // iv)
        int nProd1 = c.numeroTotalProdutos1();
        System.out.println("iv) " + nProd1);

        int nProd2 = c.numeroTotalProdutos2();
        System.out.println("iv) " + nProd2);

        // v)
        boolean b1 = c.existeProdutoEncomenda1("3643/017/000");
        System.out.println("v) Ref: 3643/017/000 " + b1);

        boolean b2 = c.existeProdutoEncomenda2("3643/017/250");
        System.out.println("v) Ref: 3643/017/000 " + b2);

        // vi)
        c.removeProduto1("3643/017/250");
        System.out.println("vi) " + c.toString());

        c.removeProduto2("8197/053/400");
        System.out.println("vi) " + c.toString());

    }
}
