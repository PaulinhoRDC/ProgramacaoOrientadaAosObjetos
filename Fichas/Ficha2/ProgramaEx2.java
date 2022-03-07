package Fichas.Ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramaEx2 {
    public static void main(String[] args) {

        /*
        2. Considerando que temos uma pauta de 5 alunos e que todos os alunos tem notas a 5 unidades curriculares, define-se o array int[5][5] notasTurma
        (Alunos X UnidadesCurriculares). Crie um programa que permita:

         */


        Ex2 f = new Ex2();
        Scanner input = new Scanner(System.in);

        //(a) ler as notas dos alunos e actualiza o array da pauta;

        int[][] notas = new int[5][5];
        int[] notasAluno = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Insira as notas do aluno " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                notasAluno[j] = input.nextInt();
            }
            notas = f.lerAt(notas, i, notasAluno);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Notas do aluno " + (i + 1) + ": " + Arrays.toString(notas[i]));
        }

        //(b) calcular a soma das notas a uma determinada unidade curricular;

        int verificaruc;
        int somaNotas=0;

        System.out.println("Qual unidade curricular deseja: ");
        verificaruc = input.nextInt();

        for (int i = 0; i < 5; i++){
            somaNotas += notas[i][verificaruc - 1];
        }

        System.out.println("A soma das notas é: " + somaNotas);

        //(c) calcular a média das notas de um aluno (fornecendo o índice da sua posição no array);

        int somaNotasAluno=0;
        int verificaraluno;

        System.out.println("Qual aluno deseja verificar: ");
        verificaraluno = input.nextInt();

        for (int i=0;i<5;i++){
            somaNotasAluno += notas[verificaraluno - 1 ][i];
        }

       System.out.println("A média do aluno " + verificaraluno + " é " + (somaNotasAluno/5) );

        //(d) calcular a méia das notas de uma unidade curricular, dado o índice da unidade curricular;

        


    }
}
