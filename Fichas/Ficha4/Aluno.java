package Fichas.Ficha4;

public class Aluno {

    private String nome;
    private int nota;
    private String numero;
    private String curso;

    public Aluno(){
        this.nome = "";
        this.nota = 0 ;
        this.numero = "";
        this.curso = "";
    }
    public Aluno(String nome, int nota, String numero, String curso) {
        this.nome = nome;
        this.nota = nota;
        this.numero = numero;
        this.curso = curso;
    }

    public Aluno(Aluno a){
        this.nome = a.getNome();
        this.nota = a.getNota();
        this.numero = a.getNumero();
        this.curso = a.getCurso();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || o.getClass()!= this.getClass()){
            return false;
        }

        Aluno a = (Aluno) o;
        return ( this.numero == a.getNumero() && this.nome == a.getNome() && this.curso == a.getCurso() && this.nota == a.getNota());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", numero='" + numero + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public Aluno clone(){
        return new Aluno(this);
    }
}
