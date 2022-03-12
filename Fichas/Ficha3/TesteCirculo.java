package Fichas.Ficha3;

import Fichas.Ficha2.Ex1;

import java.util.Scanner;

public class TesteCirculo {

    public static void main(String[] args) {

        Circulo c1 = new Circulo();
        System.out.println(c1);

        System.out.println("C1: Área: " + c1.calculaArea() + " Perimetro: " + c1.calculaPerimetro());


        Circulo c2 = new Circulo(1,1,1);
        System.out.println(c2);

        System.out.println("C2: Área: " + c2.calculaArea() + " Perimetro: " + c2.calculaPerimetro());


        System.out.println("C1 equals C2 ? " + c1.equals(c2));

        c1.setRaio(1);
        c1.setX(1);
        c1.setY(1);

        System.out.println("C1 equals C2 ? " + c1.equals(c2));

        System.out.println("C1 equals C1.clone() ? " + c1.equals(c1.clone()));
        System.out.println("C1 == C1.clone ? " + (c1 == c1.clone()));




    }
}
