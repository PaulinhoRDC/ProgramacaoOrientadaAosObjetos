package Fichas.Ficha2;

import java.time.LocalDate;
import java.util.Scanner;

public class ProgramaEx3 {
    public static void main(String[] args){

        /*
        3. Crie um programa que mantenha um array de objectos LocalDate (com representação de datas, cf. Ficha1).
        Escreva os seguintes métodos:
                (a) inserir uma nova data, public void insereData(LocalDate data)
                (b) dada uma data, determinar a data do array que está mais próxima
                (em termos de proximidade de calendário), public LocalDate dataMaisProxima(LocalDate data)
                (c) devolver uma String com todas as datas do array, public String toString()
         */

        Ex3 f = new Ex3();
        Scanner input = new Scanner(System.in);

        //(a)
        f.insereData();
        System.out.println("resultado: " + f.toString());

        for (int i = 0; i < 10; i++)
            f.insereData();

        //(b)
        LocalDate res = f.dataMaisProxima(LocalDate.now());
        System.out.println("Data a compararar: " + LocalDate.now().toString());
        System.out.println("Data Mais Próxima: " + res.toString());

        //(c)

        System.out.println(f.toString());

    }
}

