package Fichas.Ficha3.Ex7_8;

import Fichas.Ficha3.Ex7_8.LinhaEncomenda;

public class TesteLinhaEncomenda {
    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("1","Monitor",100,1,0.23f,5);

        System.out.println(l1.calculaValorLinhaEnc());
        System.out.println(l1.calculaValorDesconto());
        System.out.println();
    }

}

