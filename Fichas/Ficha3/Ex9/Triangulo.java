package Fichas.Ficha3.Ex9;

import Fichas.Ficha3.Ponto;

public class Triangulo {
    // Variáveis de instância //
    private Ponto a;
    private Ponto b;
    private Ponto c;

    // Construtores //
    public Triangulo() {
        this.a = new Ponto();
        this.b = new Ponto();
        this.c = new Ponto();
    }

    public Triangulo(Ponto a, Ponto b, Ponto c) {
        this.a = a.clone();
        this.b = b.clone();
        this.c = c.clone();
    }

    public Triangulo(Triangulo triangulo) {
        this.a = triangulo.getA().clone();
        this.b = triangulo.getB().clone();
        this.c = triangulo.getC().clone();
    }

    // (a) métodos de acesso e alteração das variáveis de instância

    public Ponto getA() {
        return this.a;
    }

    public void setA(Ponto a) {
        this.a = a.clone();
    }

    public Ponto getB() {
        return this.b;
    }

    public void setB(Ponto b) {
        this.b = b.clone();
    }

    public Ponto getC() {
        return this.c;
    }

    public void setC(Ponto c) {
        this.c = c.clone();
    }

    public double dist(Ponto p1, Ponto p2) {
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }

    public double[] getSides() {
        double[] sides = {dist(this.a,this.b),dist(this.b,this.c),dist(this.a,this.c)};
        return sides;
    }

    // (b) método que calcula a área do triângulo, public double calculaAreaTriangulo()
    public double calculaAreaTriangulo() {                                                          // base * altura / 2
        double[] sides = getSides();
        double s = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
    }

    // (c) método que calcula o perímetro do triângulo, public double calculaPerimetroTriangulo()
    public double calculaPerimetroTriangulo() {                                                     // soma dos lados
        double[] sides = getSides();
        return sides[0] + sides[1] + sides[2];
    }

    // (d) método que calcula a altura do triângulo, definido como sendo a distância no eixo dos y entre o ponto com menor coordenada em y e o ponto com maior coordenada.
    public double calculaAltura() {
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        double[] ys = {this.a.getY(), this.b.getY(), this.c.getY()};
        for(double y : ys) {
            if(y < minY) minY = y;
            if(y > maxY) maxY = y;
        }
        return maxY - minY;
    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM TER //

    public String toString() {
        final StringBuffer sb = new StringBuffer("Triangulo {");            // Aqui, toString usa StringBuffer
        sb.append("\na=").append(a.toString());
        sb.append("\nb=").append(b.toString());
        sb.append("\nc=").append(c.toString());
        sb.append("\n}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return this.a.equals(triangulo.a) &&
                this.b.equals(triangulo.b) &&
                this.c.equals(triangulo.c);
    }

    public Triangulo clone() {
        return new Triangulo(this);
    }
}
