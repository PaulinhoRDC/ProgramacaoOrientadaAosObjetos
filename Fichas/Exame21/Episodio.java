package Fichas.Exame21;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Episodio {
    private String nome;
    private LocalTime duracao;
    private int classificacao; //dada pelos seus ouvintes (valor de 0..100)
    private List<String> conteudo; //corresponde ao texto que é dito quando se reproduz o episodio
    private int numeroVezesTocada; //qts vezes é que o podcast foi ouvido
    private LocalDateTime ultimaVez; //regista quando foi reproduzido ultima vez

    public Episodio(String nome, LocalTime duracao, int classificacao, List<String> conteudo, int numeroVezesTocada, LocalDateTime ultimaVez) {
        this.nome = nome;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.conteudo = conteudo;
        this.numeroVezesTocada = numeroVezesTocada;
        this.ultimaVez = ultimaVez;
    }

    public Episodio(Episodio episodio) {
        this.nome = getNome();
        this.duracao = getDuracao();
        this.classificacao = getClassificacao();
        this.conteudo = getConteudo();
        this.numeroVezesTocada = getNumeroVezesTocada();
        this.ultimaVez = getUltimaVez();
    }

    public String getNome() {
        return nome;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public List<String> getConteudo() {
        return conteudo;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public LocalDateTime getUltimaVez() {
        return ultimaVez;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public void setUltimaVez(LocalDateTime ultimaVez) {
        this.ultimaVez = ultimaVez;
    }

    @Override
    public String toString() {
        return "Exame2021.Episodio{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", classificacao=" + classificacao +
                ", conteudo=" + conteudo +
                ", numeroVezesTocada=" + numeroVezesTocada +
                ", ultimaVez=" + ultimaVez +
                "}\n";
    }

    public Episodio clone() {
        return new Episodio(this);
    }



}
