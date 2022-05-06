package Fichas.Ficha6;

/*
A actividade de Canoagem, tem informação adicional respeitante à embarcação
utilizada (uma String - e.g. "K2", "K4"), ao valor em km/h do vento, à
direção deste, à distância percorrida e ao número de voltas à pista.

CaloriasCanoagem = distancia * ventocontra * tempo * idade/4

 */

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Canoagem extends Atividade implements FazMetros, Serializable {

    private String embarcacao;
    private int vento;
    private String direcao;
    private int distancia;
    private int voltas;

    private static int pontosMetro;                 // VARIÁVEL DE CLASSE, PARA DAR OS MESMOS PONTOS POR METRO SEMPRE

    public Canoagem(){
        super();
        this.embarcacao = "";
        this.vento = 0;
        this.direcao = "";
        this.distancia = 0;
        this.voltas = 0;
    }

    public Canoagem(int cod, String desc, String data, int tempo, String embarcacao, int vento, String direcao, int distancia, int voltas){
        super(cod, desc, data, tempo);
        this.embarcacao = embarcacao;
        this.vento = vento;
        this.direcao = direcao;
        this.distancia = distancia;
        this.voltas = voltas;
    }

    public Canoagem(Canoagem a){
        super(a);
        this.embarcacao = a.getEmbarcacao();
        this.vento = a.getVento();
        this.direcao = a.getDirecao();
        this.distancia = a.getDistancia();
        this.voltas = a.getVoltas();
    }

    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public int getVento() {
        return vento;
    }

    public void setVento(int vento) {
        this.vento = vento;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canoagem canoagem = (Canoagem) o;
        return vento == canoagem.vento && distancia == canoagem.distancia && voltas == canoagem.voltas && Objects.equals(embarcacao, canoagem.embarcacao) && Objects.equals(direcao, canoagem.direcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(embarcacao, vento, direcao, distancia, voltas);
    }

    @Override
    public String toString() {
        return "Canoagem{" +
                "embarcacao='" + embarcacao + '\'' +
                ", vento=" + vento +
                ", direcao='" + direcao + '\'' +
                ", distancia=" + distancia +
                ", voltas=" + voltas +
                '}';
    }

    public Atividade clone(){
        return new Canoagem(this);
    }

    public double calorias(Utilizador user){
        long idade = ChronoUnit.YEARS.between(LocalDate.now(), user.getDataNascimento());
        return (double)this.distancia*this.vento*getTempo()*idade/4;
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
        return pontosMetro * this.vento*1.5;
    }

}
