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
import java.util.Objects;

public class Utilizador {
    private String email;
    private String password;
    private String nome;
    private String genero;
    private int altura;
    private int peso;
    private LocalDate dataNascimento;
    private int desportoFavorito;

    public Utilizador(){
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.peso = 0;
        this.dataNascimento = LocalDate.EPOCH;
        this.desportoFavorito = 0;
    }

    public Utilizador(String email, String password, String nome, String genero, int altura, int peso, LocalDate dataNascimento, int desportoFavorito){
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.desportoFavorito = desportoFavorito;
    }

    public Utilizador(Utilizador a){
        this.email = a.getEmail();
        this.password = a.getPassword();
        this.nome = a.getNome();
        this.genero = a.getGenero();
        this.altura = a.getAltura();
        this.peso = a.getPeso();
        this.dataNascimento = a.dataNascimento;
        this.desportoFavorito = a.desportoFavorito;
    }

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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getDesportoFavorito() {
        return desportoFavorito;
    }

    public void setDesportoFavorito(int desportoFavorito) {
        this.desportoFavorito = desportoFavorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return altura == that.altura && peso == that.peso && desportoFavorito == that.desportoFavorito && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(nome, that.nome) && Objects.equals(genero, that.genero) && Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nome, genero, altura, peso, dataNascimento, desportoFavorito);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", dataNascimento=" + dataNascimento +
                ", desportoFavorito=" + desportoFavorito +
                '}';
    }
}
