package Fichas.Ficha3.Ex1;

public class Circulo {// extends Ponto2 {

    private double x;
    private double y;
    private double raio;

    public Circulo(){
        x = 0;
        y = 0;
        raio = 0;
    }

    public Circulo(double cx, double cy, double craio){
        x = cx;
        y = cy;
        raio = craio;
    }

    public Circulo(Circulo outro){
        x = outro.getX();
        y = outro.getY();
        raio = outro.getRaio();

    }

    // (d) Setters

    // (a) método que devolve o valor da variável x, public double getX()
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // (b) método que devolve o valor da variável y, public double getY()
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // (c) método que devolve o valor da variável raio, public double getRaio()
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }


    // (e) método que altera o posicionamento do círculo, public void alteraCentro(double x, double y)
    public void alteraCentro(double x , double y){
        this.x = x;
        this.y = y;
    }

    // (f) método que calcula a área do círculo, public double calculaArea()
    public double calculaArea(){
        return Math.PI*Math.pow(raio,2);  // PI * raio^2
    }

    // (g) método que calcula o perímetro do círculo, public double calculaPerimetro()
    public double calculaPerimetro(){
        return 2*Math.PI*raio;            //2 * PI * raio
    }


    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER

    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if( o == null || this.getClass() != o.getClass()){
            return false;
        }

        Circulo c = (Circulo) o;
        if ( this.y == c.getY() && this.x == c.getX() && this.raio == c.getRaio()){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Círculo{" + "x=" + this.x + ", y=" + this.y + ", raio=" + this.raio + "}";
    }

    public Circulo clone(){
        return new Circulo(this);
    }
}
