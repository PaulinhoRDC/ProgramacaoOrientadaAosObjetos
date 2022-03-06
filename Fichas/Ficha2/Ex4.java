package Fichas.Ficha2;

import java.util.Arrays;

public class Ex4 {

   //  (a) método que ordene um array de inteiros por ordem crescente;

    public int[] ordena(int[] a){
        Arrays.sort(a);                         // faz a ordenação do array
        return a;
    }

   //(b) método que implemente a procura binária de um elemento num array de inteiros;

    public int procuraBinaria(int[] a, int v){
        return Arrays.binarySearch(ordena(a), v);      // devolve a posição onde se colocaria, caso nao haja o valor
    }
}
