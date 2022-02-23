package Fichas.Ficha1.ExerciciosII;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //Iniciar Scanner para leitura
        Scanner sc = new Scanner(System.in);

        //Criar objeto da classe que implementa os métodos
        ExerciciosII f1 = new ExerciciosII();

        String resp;   // para saber se quer fazer mais perguntas

        do {

            System.out.println("Qual o exercício que deseja realizar? \n");
            int exercicio = sc.nextInt();
            switch (exercicio) {

                case 1:
                    //Pergunta 1
                    System.out.println("-- Pergunta 1 -- \n");
                    System.out.println();
                    System.out.println("Insira a temperatura em celsius: ");
                    double temp = sc.nextDouble();
                    System.out.println("A temperatura em Farenheit é: " + f1.celsiusParaFarenheit(temp));
                    System.out.println();

                    break;

                case 2:
                    //Pergunta 2
                    System.out.println("-- Pergunta 2 -- ");
                    System.out.println();
                    System.out.println("Insira o primeiro inteiro: ");
                    int a = sc.nextInt();
                    System.out.println("Insira o segundo inteiro: ");
                    int b = sc.nextInt();
                    System.out.println("O maior inteiro é: " + f1.maximoNumeros(a, b));
                    System.out.println();

                    break;

                case 3:
                    //Pergunta 3
                    System.out.println("-- Pergunta 3 -- ");
                    System.out.println();
                    System.out.println("Insira o nome e saldo: ");
                    String nome = sc.nextLine();
                    double saldo = sc.nextDouble();
                    String str = f1.criaDescricaoConta(nome, saldo);
                    System.out.println("Resposta =" + str);

                    break;

                case 4:
                    //pergunta 4
                    System.out.println("-- Pergunta 4 -- ");
                    System.out.println();
                    System.out.println("Insira quantidade em euros: ");
                    double valor = sc.nextDouble();
                    System.out.println("Insira taxa de conversao: ");
                    double taxa = sc.nextDouble();
                    System.out.println("Conversão: " + " Em Euros -> " + valor + " Em Libras -> " + f1.eurosParaLibras(valor, taxa));

                    break;

                case 5:
                    //pergunta 5
                    System.out.println("-- Pergunta 5 -- ");
                    System.out.println();
                    System.out.println("Insira primeiro inteiro: ");
                    int aa = sc.nextInt();
                    System.out.println("Insira segundo inteiro: ");
                    int bb = sc.nextInt();
                    f1.cincum(aa, bb);

                    break;

                case 6:
                    //pergunta 6
                    System.out.println("-- Pergunta 5 -- ");
                    System.out.println();
                    System.out.println("Insira o numero: ");
                    int number = sc.nextInt();
                    System.out.println("O factorial é: " + f1.factorial(number));

                case 7:
                    //pergunta 7
                    System.out.println("-- Pergunta 7 -- ");
                    System.out.println();
                    System.out.println("O factorial demorou: " + f1.tempoGasto());

            }

            System.out.println("Quer realizar mais algum exercício? [S/n]");
            resp = sc.next();
        } while (resp.charAt(0) != 'n');

        sc.close();
        System.out.println("!!!ADEUS!!!");


    }
}
