package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramaEx1 {

    public static void main (String[] args) {

        Ex1 f = new Ex1();
        Scanner input = new Scanner(System.in);
        int n;

        // (a)
        System.out.println("Quantos inteiros quer ler?");
        n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i<n ; i++){
            System.out.println("Introduza um inteiro:");
            a[i] = input.nextInt();
        }

        //(b)
        System.out.println("O minimo de " + Arrays.toString(a) + " é " + f.minimo(a));

        int i1, i2;
        System.out.println("Introduza o índice 1: ");
        i1 = input.nextInt();
        System.out.println("Introduza o índice 2: ");
        i2 = input.nextInt();

        System.out.println("O array entre os índices " + i1 + " e" + i2 + "é: " + Arrays.toString(f.posicoesEntre(a,i1,i2)));


        // (c)
        int[] b = new int[n];

        for (int j = 0; j<n ; j++){
            System.out.println("Introduza um inteiro:");
            b[j] = input.nextInt();
        }

        System.out.println("O array com os elementos comundos de " + Arrays.toString(a) + " e" + Arrays.toString(b) +
                           "é: " + Arrays.toString(f.comunsEntre(a,b)));


    }
}
