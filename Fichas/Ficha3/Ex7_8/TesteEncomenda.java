package Fichas.Ficha3.Ex7_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteEncomenda {
    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("1","Monitor",100,1,0.23f,5);
        LinhaEncomenda l2 = new LinhaEncomenda("2","rato",100,1,0.23f,5);
        // LinhaEncomenda[] linha = {l1,l2};
        List<LinhaEncomenda> linha = new ArrayList<LinhaEncomenda>(Collections.singleton(l1));   //VERIFICAR

        Encomenda e1 = new Encomenda("Miguel",233910595,"Rua da Eira Velha","Enc1", LocalDate.now(),linha);

        System.out.println(e1.calculaValorTotal());
        System.out.println(e1.calculaValorDesconto());
        System.out.println(e1.numeroTotalProdutos());
        System.out.println(e1.existeProdutorEncomenda("1"));
        System.out.println(e1.existeProdutorEncomenda("10"));
    }
}

