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
import java.util.Date;
import java.util.HashMap;

public abstract class Atividades {

    private String codigo;
    private String descricao;
    private LocalDate data;
    private double tempo;
    private Utilizador user;

    //Construtores//

    public Atividades(){
        this.codigo = "";
        this.descricao = "";
        this.data = LocalDate.parse("", DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
        this.tempo = 0.0;
        this.user = ;

    }

    public Atividades(String codigo2, String descricao2, LocalDate data2, double tempo2, Utilizador user2){
        this.codigo = codigo2;
        this.descricao = descricao2;
        this.data = data2;
        this.tempo = tempo2;
        this.user = user2;
    }

    public Atividades(Atividades ex){
        this.codigo = ex.getCodigo();
        this.descricao = ex.getDescricao();
        this.data = ex.getData();
        this.tempo = ex.getTempo();
        this.user = ex.getUser();
    }

    //GETTER'S & SETTER'S//

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public Utilizador getUser() {
        return user;
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    //MÉTODOS//

    public abstract double calorias();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividades atividade = (Atividades) o;
        return this.tempo == atividade.getTempo()
                && this.codigo.equals(atividade.getCodigo())
                &&  this.descricao.equals(atividade.getDescricao())
                && this.data.equals(atividade.getData());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
