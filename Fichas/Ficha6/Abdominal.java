package Fichas.Ficha6;

/*
A actividade de Abdominais tem informação sobre o tipo de abdominal e
número de repetições.

CaloriasAbdominais = tempo * repeticoes * 3/5

 */

import java.util.Objects;

public class Abdominal extends Atividade {
    private String tipo;
    private int repeticoes;

    public Abdominal(){
        super();
        this.tipo = "";
        this.repeticoes = 0;
    }

    public Abdominal(int cod, String desc, String data, int tempo, String tipo, int repeticoes){
        super(cod, desc, data, tempo);
        this.tipo = tipo;
        this.repeticoes = repeticoes;
    }

    public Abdominal(Abdominal a){
        super(a);
        this.tipo = a.getTipo();
        this.repeticoes = a.getRepeticoes();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abdominal abdominal = (Abdominal) o;
        return repeticoes == abdominal.repeticoes && Objects.equals(tipo, abdominal.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, repeticoes);
    }

    @Override
    public String toString() {
        return "Abdominal{" +
                "tipo='" + tipo + '\'' +
                ", repeticoes=" + repeticoes +
                '}';
    }

    public double calorias(Utilizador user){
        return (double)getTempo()*this.repeticoes*3/5;
    };
    public Atividade clone(){
        return new Abdominal(this);
    }
}

