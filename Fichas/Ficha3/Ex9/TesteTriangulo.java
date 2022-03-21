package Fichas.Ficha3.Ex9;

import Fichas.Ficha3.Ponto;

public class TesteTriangulo {

    public static void main (String [] args) {

        Ponto a = new Ponto(0, 0);
        Ponto b = new Ponto(0, 3);
        Ponto c = new Ponto(4, 0);

        // a.setX(-5);
        Triangulo triangulo1 = new Triangulo(a, b, c);
        // a.setX(-5);                                          //Aqui ja nao atualiza o valor

        System.out.println("Triângulo definido pelos pontos (0,0), (0,3) e (4,0).");
        System.out.println(triangulo1.toString() + "\n");
        System.out.println("Área do triângulo = " + triangulo1.calculaAreaTriangulo());
        System.out.println("Perímetro do triângulo = " + triangulo1.calculaPerimetroTriangulo());
        System.out.println("Altura do triângulo = " + triangulo1.calculaAltura());

        Triangulo triangulo2 = triangulo1.clone();
        if (!triangulo1.equals(triangulo2))
            System.out.println("Something is wrong with the equals or the clone functions.");

    }
}
