package Fichas.Ficha3.Ex1;

import Fichas.Ficha3.Ponto;

public class Circulo2 extends Ponto {

    private double raio;
    private Ponto centro;

    public Circulo2(){
        this.raio = 0;
        this.centro = new Ponto();
    }

    public Circulo2(Ponto centro, double raio){
        this.raio = raio;
        this.centro = centro.clone();            // Ponto que vem de fora, guardamos referência para esse objeto
                                                 // desta forma, só eu tenho acesso a esta referência
    }

    public Circulo2(Circulo2 c) {
        this.centro = c.getCentro();
        this.raio = c.getRaio();
    }

        // GETTERS & SETTERS //

    public void setCentro(Ponto centro) {
        this.centro = centro.clone();
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Ponto getCentro() {
        return this.centro.clone();
    }

    public double getRaio() {
        return raio;
    }

    public double calculaArea(){
        return Math.PI*Math.pow(raio,2);  // PI * raio^2
    }

    public double calculaPerimetro(){
        return 2*Math.PI*raio;            //2 * PI * raio
    }



    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if( o == null || this.getClass() != o.getClass()){
            return false;
        }

        Circulo2 c = (Circulo2) o;
        if ( this.raio == c.getRaio() && c.getCentro().equals(this.centro)){
            return true;
        } else {
            return false;
        }

        //  return this.raio == c.getRaio() && c.getCentro().equals(this.centro);
    }

    public String toString(){
        return "Círculo{" + "centro= " + this.centro + ", raio=" + this.raio + "}";
    }
    // ou toStrung com o StringBuilder e ir fazendo append

    public Circulo2 clone(){
        return new Circulo2(this);
    }

    public void alteraCentro(Ponto centro){
        this.centro = centro;
    }


}

