package Fichas.Ficha6;

/*

Todas as actividades, independentemente da sua natureza, possuem informação sobre:
    • um código único que a permite identificar
    • a descrição da actividade (e.g. "corrida matinal", "pilates semanal", etc.)
    • a data da sua realização
    • o tempo (em minutos) que demorou

 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Atividade {
    private int cod;
    private String desc;
    private String data;
    private int tempo;

    public Atividade(){
        this.cod = 0;
        this.desc = "";
        this.data = "";
        this.tempo = 0;
    }
    public Atividade(int cod, String desc, String data, int tempo){
        this.cod = cod;
        this.desc = desc;
        this.data = data;
        this.tempo = tempo;
    }

    public Atividade(Atividade a){
        this.cod = a.getCod();
        this.desc = a.getDesc();
        this.data = a.getData();
        this.tempo = a.getTempo();
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || o.getClass() != this.getClass()){
            return false;
        }
        Atividade a = (Atividade) o;
        return (this.cod == a.getCod() &&
                this.desc == a.getDesc() &&
                this.data == a.getData() &&
                this.tempo == a.getTempo ());
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "cod=" + cod +
                ", desc='" + desc + '\'' +
                ", data='" + data + '\'' +
                ", tempo=" + tempo +
                '}';
    }

    public abstract Atividade clone();

    public abstract double calorias(Utilizador u);
}
