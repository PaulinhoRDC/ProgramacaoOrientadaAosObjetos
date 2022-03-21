package Fichas.Ficha3.Ex1;

import Fichas.Ficha3.Ponto;

public class TesteColCirculos {

    public static void main(String[] args){
        ColCirculos cc = new ColCirculos();

        for(int i=1; i<10;i++){
            cc.addCirculo( new Circulo2( new Ponto(i,i), i));
        }

        System.out.println("Coleção: " + cc);
        ColCirculos cc1 = cc.clone();
        System.out.println("Coleção clone: " + cc1);

        System.out.println("cc equals cc1: " + cc.equals(cc1));

        for(int i=1; i<10;i++){
            Circulo2 cp = new Circulo2( new Ponto(i,i) ,i);
            System.out.println(" colecao contains: " + cp + " " + cc.existeCirculo(cp));
        }

    }
}
