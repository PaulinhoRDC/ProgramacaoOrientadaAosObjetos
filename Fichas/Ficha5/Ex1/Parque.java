package Fichas.Ficha5.Ex1;

/*
Crie em seguida uma classe Parque contendo o nome do parque em questão
e uma representação dos lugares do parque, associando a cada matricula,
a informação do lugar associado.

(b) Para além dos construtores e métodos usuais, a classe Parque deverá
definir ainda os seguintes métodos de instância:

 */

import java.util.*;
import java.util.stream.Collectors;

public class Parque {

    private String nome;
    private Map<String, Lugar> lugarParque;

    //CONSTRUTORES//
    public Parque() {
        this.nome = "";
        this.lugarParque = new HashMap<>();
    }

    public Parque(String nome, Map<String, Lugar> lugarParque) {
        this.nome = nome;
        setLugarParque(lugarParque);
    }

    public Parque (Parque p) {
        this.nome = p.getNome();
        this.lugarParque = p.getLugarParque();
    }

    //GETTER'S & SETTER'S//

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Lugar> getLugarParque() {
        return new HashMap<>(this.lugarParque);
    }

    public void setLugarParque(Map<String, Lugar> lugarParque) {
        this.lugarParque = new HashMap<>(this.lugarParque);
    }

    //B)
    //i) -> Método que devolve todas as matriculas dos lugares ocupados;
    public List<String> getAllMatriculas() {
        return new ArrayList<>(this.lugarParque.keySet());
    }

    //ii) -> Método que regista uma nova ocupação de lugar;
    public void newOccupation (Lugar lugar) {
        this.lugarParque.putIfAbsent(lugar.getMatricula(), lugar.clone());
    }

    //iii) -> Método que remove o lugar de dada matricula;
    public void removeLugar (String matricula) {
        this.lugarParque.remove(matricula);
    }

    //iv) -> Método que altera o tempo disponível de um lugar, para uma dada matricula;
    public void setTempo (String matricula, int tempo) {
        if (!hasLugar(matricula)) return;
        this.lugarParque.get(matricula).setMinutos(tempo);
    }

    ////vii) -> Método que verifica existe lugar atribuído a uma dada matrícula;
    public boolean hasLugar (String matricula) {
        return this.lugarParque.containsKey(matricula);
    }

    //v) -> Método que devolve a quantidade total de minutos atribuídos. Implemente com iterador interno e iterador externo;
                                //Iterador interno
    public int allMin1 () {
        return this.lugarParque.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

                                //Iterador externo
    public int allMin2() {
        int acc=0;

        for (Lugar l: this.lugarParque.values()) {
            acc += l.getMinutos();
        }
        return acc;
    }

    //vi) -> Método que cria uma lista com as matriculas com tempo atribuído > x, em que o lugar seja permanente.
    // Implemente com iterador interno e iterador externo;

    //Iterador interno -> ?
    //public List<String> timedMatriculas1 (int time) {}

    //Iterador externo
    public List<String> timedMatriculas2 (int time) {
        List <String> matriculas = new ArrayList<>();

        for (Map.Entry<String, Lugar> set: this.lugarParque.entrySet()) {
            if(set.getValue().getMinutos()>time && set.getValue().isPermanente()) {
                matriculas.add(set.getKey());
            }
        }
        return matriculas;
    }

    //viii) -> Método que devolve uma cópia dos lugares;
    public List<Lugar> getAllLugares() {
        return this.lugarParque.values().stream().map(Lugar::clone).collect(Collectors.toList());
    }

    /* -> ou
     * List<Lugar> lugares = new ArrayList<>();
     * for (Lugar l : this.lugarParque.values()){
     *   lugares.add(l.clone());
     * }
     * return lugares;
     */

    //ix) -> Método que devolve a informação de um lugar para uma dada matricula;
    public Lugar getLugarInfo(String matricula) {
        if (!hasLugar(matricula)) return null;
        return this.lugarParque.get(matricula).clone();
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER

    @Override
    public Parque clone() {
        return new Parque(this);
    }

    @Override
    public String toString() {
        return "Parque{" +
                "nome='" + nome + '\'' +
                ", lugarParque=" + lugarParque +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parque parque = (Parque) o;
        return Objects.equals(nome, parque.nome) && Objects.equals(lugarParque, parque.lugarParque);
    }


}
