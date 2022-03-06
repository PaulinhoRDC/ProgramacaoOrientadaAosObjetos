package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;


public class Ex6 {

    private Scanner sc = new Scanner(System.in);

    public void toString (int [][] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(Arrays.toString(a[i]));
    }

    public int [][] lerMatriz() {
        System.out.println("Quantas linhas na matriz: ");
        int linhas = sc.nextInt();
        System.out.println("Quantas colunas na matriz: ");
        int colunas = sc.nextInt();
        int [][] matriz = new int [linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            System.out.println("Insere a linha " + i + " (i.e. 1 2 3): ");
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }

    public int [][] somaMatrizes (int [][] a, int [][] b) {
        int [][] res = new int [a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    public Boolean matrizesIguais (int [][] a, int [][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int [][] matrizOposta (int [][] a) {
        int [][] aux = new int [a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                aux[i][j] = -a[i][j];
            }
        }
        return aux;
    }
}

