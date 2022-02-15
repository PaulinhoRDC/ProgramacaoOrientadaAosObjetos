import java.util.Objects;

//Classe "pai" da classe equipa e jogador, uma vez que estas duas vao ter um id e um nome
public abstract class Base {

    public static final String REDES = "Guarda-Redes";
    public static final String DEFESA = "Defesa";
    public static final String MEDIO = "Medio";
    public static final String AVANCADO= "Avancado";
    public static final String LATERAL = "Lateral";

    private String nome;
    private String id;

    public Base(){
        this.nome = new String();
        this.id = new String();
    }
    public Base(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public Base (Base a){
        this.nome= a.getNome();
        this.id = a.getId();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws ExcecaoPos {
        this.nome = nome;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base b = (Base) o;
        return Objects.equals(nome, b.nome) && Objects.equals(id, b.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id);
    }

    @Override
    public String toString() {
        return  nome;
    }

    public int compareTo(Object o){
        Base a = (Base) o;
        return this.id.compareTo(a.getId());
    }
}
