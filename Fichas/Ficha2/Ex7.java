package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7 {

    public int[] geraEuroMilhoes() {
        int[] res = new int[7];
        int i;
        for (i = 0; i < 5; i++) //posições 0 - 4: Numeros
            res[i] = (int) (Math.random() * 50) + 1;
        for (; i < 7; i++) //posições 5-6: Estrelas.
            res[i] = (int) (Math.random() * 9) + 1;
        return res;
    }

    public void jogarEuroMilhoes() {
        Scanner sc = new Scanner(System.in);
        int i=0,j=0;
        int[] numeros = new int[5];
        int[] estrelas = new int[2];
        System.out.println("Introduz 5 numeros (1-50): ");
        for (int elem : numeros) {
            elem = sc.nextInt();
            if (elem > 50 || elem < 1) {
                System.out.println("Número inválido, tenta de novo: ");
                elem = sc.nextInt();
            }
            numeros[i]=elem;
            i++;
        }
        System.out.println("Insere duas estrelas (1-9): ");
        for (int elem1 : estrelas) {
            elem1 = sc.nextInt();
            if (elem1 > 9 || elem1 < 1) {
                System.out.println("Número inválido, tenta de novo: ");
                elem1 = sc.nextInt();
            }
            estrelas[j]=elem1;
            j++;
        }
        check_respostas(numeros, estrelas);
    }

    public void check_respostas(int[] numeros, int[] estrelas) {
        int[] resposta = new int[7];
        resposta = geraEuroMilhoes();
        System.out.println("A chave é: " + Arrays.toString(resposta));

        int countNum = 0, countStar = 0;
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 5; i2++) {
                if (numeros[i] == resposta[i2]) {
                    countNum++;
                }
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int k = 5; k < 7; k++) {
                if (estrelas[j] == resposta[k]) {
                    countStar++;
                }
            }
        }

            System.out.println(Arrays.toString(numeros));
            System.out.println(Arrays.toString(estrelas));
            if (countNum == 5 && countStar == 2) {
                System.out.println("Parabéns! Ganhaste :)");
            } else {
                System.out.println("Acertaste " + countNum + " números e " + countStar + " estrelas.");
            }
    }
}
