package Fichas.Ficha2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramaEx4 {
    public static void main (String[] args) {

        Ex4 f = new Ex4();
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Quantos inteiros quer ler?");
        n = input.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            System.out.println("Introduza um inteiro:");
            a[i] = input.nextInt();
        }

        System.out.println("O array " + a + " " + Arrays.toString(a) + " ordenado é: " + Arrays.toString(f.ordena(a)));
                    // Verificamos que ao imprimir o a, mostra a posição de memória e não o conteúdo do array


        int v;
        System.out.println("Qual o valor que pretende procurar?");
        v = input.nextInt();
        int p = f.procuraBinaria(a,v);
        System.out.println(" O valor está na posição: " + p);
    }

}
