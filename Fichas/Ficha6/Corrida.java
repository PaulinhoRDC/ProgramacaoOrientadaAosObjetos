package Fichas.Ficha6;

/*
A Corrida acrescenta informação sobre a distância percorrida, a altimetria ganha e o percurso efectuado (por simplificação
assuma que o percurso é uma string de caracteres. Existirá depois um método
que dada uma string destas cria um png).

CaloriasCorrida = distancia * pesoutilizador * tempo * idade/50

 */

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Corrida extends Atividade implements FazMetros, Serializable {

    private int distancia;
    private int altimetria;
    private String percurso;

    private static int pontosMetro;                 // VARIÁVEL DE CLASSE, PARA DAR OS MESMOS PONTOS POR METRO SEMPRE

    public Corrida(){
        super();
        this.distancia = 0;
        this.altimetria = 0;
        this.percurso = "";
    }

    public Corrida(int cod, String desc, String data, int tempo, int distancia, int altimetria, String percurso){
        super(cod, desc, data, tempo);
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.percurso = percurso;
    }

    public Corrida(Corrida a){
        super(a);
        this.distancia = a.getDistancia();
        this.altimetria = a.getAltimetria();
        this.percurso = a.getPercurso();
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getAltimetria() {
        return altimetria;
    }

    public void setAltimetria(int altimetria) {
        this.altimetria = altimetria;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corrida corrida = (Corrida) o;
        return distancia == corrida.distancia && altimetria == corrida.altimetria && Objects.equals(percurso, corrida.percurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distancia, altimetria, percurso);
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "distancia=" + distancia +
                ", altimetria=" + altimetria +
                ", percurso='" + percurso + '\'' +
                '}';
    }

    public Atividade clone(){
        return new Corrida(this);
    }


    public double calorias(Utilizador user){
        long idade = ChronoUnit.YEARS.between(LocalDate.now(), user.getDataNascimento());
        return (double)this.distancia*user.getPeso()*getTempo()*idade/50;
    };


    // FASE 3 // Métodos que têm de ser implementados, devido à interface FazMetros
    //2. Actualize as classes Corrida e Canoagem de modo a que implementem a interface.

    @Override
    public void setPontosMetro(int pontos) {
        pontosMetro = pontos;
    }

    @Override
    public int getPontosMetro() {
        return pontosMetro;
    }

    @Override
    public double pontos() {
        return pontosMetro * this.altimetria*1.5;
    }
}

