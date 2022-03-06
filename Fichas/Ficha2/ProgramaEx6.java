package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramaEx6 {

    public static void main(String[] args) {

        /*
        6. Considere que se representam matrizes de inteiros como arrays bidimensionais.
           Efectue as seguintes operações:
                (a) crie um método para ler uma matriz;
                (b) crie um método que implemente a soma de matrizes e devolva a matriz resultado;
                (c) crie um método que determine se duas matrizes são iguais;
                (d) crie um método que determine a matriz oposta de uma matriz (nota:
                chama-se matriz oposta de A a matriz -A, cuja soma com A resulta na matriz nula).
         */

        Ex6 f = new Ex6();

        //(a)
        System.out.println("Ler uma matriz");
        int [][] matriz = f.lerMatriz();
        f.toString(matriz);

        //(b)
        System.out.println("Efetuar a soma de duas matrizes");
        int [][] m1 = f.lerMatriz();
        int [][] m2 = f.lerMatriz();
        int [][] soma = f.somaMatrizes(m1, m2);
        System.out.println("Soma: ");
        f.toString(soma);

        //(c)
        System.out.println("Verificar se duas matrizes são iguais");
        int [][] m3 = f.lerMatriz();
        int [][] m4 = f.lerMatriz();
        Boolean iguais = f.matrizesIguais(m3 ,m4);
        System.out.println("Resultado de comparação: " + iguais);

        //(d)
        System.out.println("Calcular a matriz oposta");
        int [][] m = f.lerMatriz();
        int [][] res = f.matrizOposta(m);
        System.out.println("Matriz oposta: ");
        f.toString(res);

    }
}
