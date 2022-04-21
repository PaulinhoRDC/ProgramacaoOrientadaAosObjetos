package Fichas.Ficha6;

/*
A Corrida acrescenta informação sobre a distância percorrida, a altimetria ganha e o percurso efectuado (por simplificação
assuma que o percurso é uma string de caracteres. Existirá depois um método
que dada uma string destas cria um png).

CaloriasCorrida = distancia * pesoutilizador * tempo * idade/50

 */

public class Corrida extends Atividades{

    private double distPercorrida;
    private double altimetria;
    private String percurso;
    private Utilizador user;


    public Corrida(){
        super();
    }

    @Override
    public double calorias() {
        return distPercorrida * user.getPeso() * getTempo() * user.getDatanascimento();
    }


}
