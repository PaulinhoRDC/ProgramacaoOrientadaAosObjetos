package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramaEx5 {

    public static void main(String[] args) {
        /*
        5. Crie um programa que leia Strings para um array. De seguida, implemente os seguintes métodos:

            (a) determinar o array com as Strings existentes (sem repetições)
            (b) determinar a maior String inserida;
            (c) determinar um array com as Strings que aparecem mais de uma vez;
            (d) determinar quantas vezes uma determinada String ocorre no array.
         */

        Ex5 f = new Ex5();
        Scanner input = new Scanner(System.in);
        int n;

        // Criar o array //

        System.out.println("Quantas strings quer no array?");
        int tamanho = input.nextInt();
        String[] a = new String[tamanho];

        for (int i=0; i<tamanho; i++){
            System.out.println("Digite sua string: ");
            a[i]=input.next();
        }

        //(a)
        System.out.println("Array final: " + Arrays.toString(f.semRep(a)));

        //(b)
        System.out.println("A maior String é: " + f.maiorStr(a));

        //(c)
        System.out.println("Strings que aparecem mais vezes: " + Arrays.toString(f.stringsReps(a)));

        //(d)

        System.out.println("Que String deseja verificar?");
        String verificar = input.next();
        System.out.println("A String " + verificar + " aparece: " + (f.quantasReps(a, verificar)) + "vezes.");


    }
}
