package Fichas.Ficha5.Ex1;

/*

1. Desenvolva uma classe Lugar que represente a informação básica de um
lugar de estacionamento, existente num dado parque. Sobre cada lugar
pretende ter-se a seguinte informação:
                                            /** Matricula do veiculo estacionado
                                            private String matricula ;
                                            /** Nome do proprietario
                                            private String nome ;
                                            /** Tempo atribuido ao lugar , em minutos
                                            private int minutos ;
                                            /** Indica se lugar é permanente , ou de aluguer
                                            private boolean permanente ;

 */

import java.util.Objects;

public class Lugar {

    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente ;

    //CONSTRUTORES//
    public Lugar(){
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = false;
    }

    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar (Lugar lugar){
        this.matricula = lugar.getMatricula();
        this.nome = lugar.getNome();
        this.minutos = lugar.getMinutos();
        this.permanente = lugar.isPermanente();
    }

    //GETTER'S & SETTER'S//

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER//

    @Override
    public Lugar clone() {
        return new Lugar(this);
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", minutos=" + minutos +
                ", permanente=" + permanente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lugar lugar = (Lugar) o;
        return minutos == lugar.minutos && permanente == lugar.permanente && Objects.equals(matricula, lugar.matricula) && Objects.equals(nome, lugar.nome);
    }

}
