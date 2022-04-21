package Fichas.Ficha6;

/*
                        Utilizadores
Para cada utilizador guarda-se a seguinte informação pessoal:
    • email, que é a chave do utilizador;
    • password;
    • nome;
    • género;
    • altura;
    • peso;
    • data de nascimento;
    • desporto favorito - que é o desporto em que pratica mais actividades;

    Além desta informação, que deve poder ser editada, o utilizador regista também
a informação das actividades que realizou;

 */

import java.time.LocalDate;
import java.util.Date;

public class Utilizador extends Atividades{

    private String email;
    private String password;
    private String nome;
    private String genero;
    private double altura;
    private double peso;
    private LocalDate datanascimento;
    private String favorito;

    // informação das atividades que realizou

    //GETTER'S & SETTER'S//


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

}
