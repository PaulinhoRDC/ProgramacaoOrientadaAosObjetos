package Fichas.Ficha5.Ex2;

import java.util.*;

public class TurmaAlunos {                                  //ESTRATÉGIA DE COMPOSIÇÃO

    private Map<String, Aluno> alunos;
    private String nomeTurma;
    private String codUC;

    //CONSTRUTORES//
    // i. métodos usuais da classe TurmaAlunos, nomeadamente construtores, getters e setters, equals, toString, clone
    public TurmaAlunos(){
        this.alunos = new HashMap<>();
        //this.alunos = new TreeMap<>();                TAMBÉM PODERIA SER!

        this.nomeTurma = "N/A";
        this.codUC = "N/A";
    }

    public TurmaAlunos(Map <String, Aluno> nAlunos, String nNomeTurma, String ncodUC){
        //setAlunos(nAlunos);

        this.nomeTurma = nNomeTurma;
        this.codUC = ncodUC;

        this.alunos = new HashMap<>();  //vazio, para agora iterarmos por todos os elementos de nAlunos e colonar as suas informações para dentro deste novo HashMap();

        for(Aluno a: nAlunos.values()){
            String chave = a.getNumero();
            this.alunos.put(chave, a.clone());
        }
    }

    public TurmaAlunos(TurmaAlunos t){
        this.alunos = t.getAlunos();
        this.codUC = t.getCodUC();
        this.nomeTurma = t.getNomeTurma();
    }

    //GETTER & SETTER'S//
    public Map<String, Aluno> getAlunos() {
        Map<String, Aluno> r = new HashMap<>();

        for(Map.Entry<String, Aluno> e : this.alunos.entrySet()){
            String chave = e.getKey();
            Aluno valor = e.getValue();

            r.put(chave, valor.clone());                // r.put ( e.getKey(), e.getValue().clone());
        }

        return r;

        //return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public void setAlunos(Map<String, Aluno> nAlunos) {
        this.alunos = new HashMap<>();

        for(String k : this.alunos.keySet()){
            this.alunos.put(k, nAlunos.get(k).clone());
        }

        //this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getCodUC() {
        return codUC;
    }

    public void setCodUC(String codUC) {
        this.codUC = codUC;
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER//

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;

        TurmaAlunos t = (TurmaAlunos) o;
        return (this.alunos.equals(t.getAlunos())
                && this.nomeTurma.equals(t.getNomeTurma())
                && this.codUC.equals(t.getCodUC())
                );
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nome da Turma: ").append(this.nomeTurma).append("\n")
                .append("Codigo da UC: ").append(this.codUC).append("\n");

        for(Aluno a : this.alunos.values()){
            sb.append(a.toString()).append("\n");
        }

        return sb.toString();
    }

    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    //OUTROS MÉTODOS//

    // ii. adicionar um novo aluno à turma, public void insereAluno(Aluno a)
    public void insereAluno(Aluno a){
        this.alunos.put(a.getNumero() , a.clone());
    }

    //iii. dado um código de aluno devolver a instância de Aluno associada, public Aluno getAluno(String codAluno)
    public Aluno getAluno(String codAluno){

        //this.alunos.get(codAluno).clone();     //assim dava problema, caso não existisse o aluno que procuramos
        //PRECISAMOS ANTES, DE VERIFICAR SE REALMENTE EXISTE ESTE ALUNO

        //if(!this.alunos.containsKey(codAluno)) return null;
        //else return this.alunos.get(codAluno).clone();

        return this.alunos.getOrDefault(codAluno, null).clone();
    }

    //iv. remover um aluno dado o seu código, public void removeAluno(String codAluno)
    public void removeAluno(String codAluno){
        this.alunos.remove(codAluno);                  //  aqui não precisamos de verificar se existe ou não, para o remove não interessa
    }

    //v. devolver a informação de todos os números de aluno existentes, public Set<String> todosOsCodigos()
    public Set<String> todosOsCodigos(){
        return this.alunos.keySet();                //keySet devolve todas as chaves
    }

    //vi. devolver a informação de quantos alunos existem na turma, public int qtsAlunos()
    public int qtsAlunos(){
        return this.alunos.size();
    }

    //vii. devolver os alunos ordenados por ordem alfabética do seu nome, public Collection<Aluno> alunosOrdemAlfabetica()
    public Collection<Aluno> alunosOrdemAlfabetica(){
        TreeSet<Aluno> t = new TreeSet<>();

        for(Aluno a: this.alunos.values()){             // iterar pelos alunos
            t.add(a.clone());
        }
        return t;

        //CompareTo do Aluno ja organiza por nome
        //        return this.alunos.values().stream().sorted().collect(Collectors.toList());
    }

    //viii. devolver os alunos ordenados por ordem decrescente do seu número, public Set<Aluno> alunosOrdemDescrescenteNumero()
    //(assume-se que não existem números repetidos, daí ser viável devolver um Set sem correr o risco de a comparação eliminar resultados).
    public Set<Aluno> alunosOrdemDecrescenteNumero(){
        Comparator<Aluno> c = (a1,a2) -> a2.getNumero().compareTo(a1.getNumero());
        //Trocamos a ordem do a2 e a1, para que seja de facto, ordem decrescente.

        TreeSet<Aluno> t = new TreeSet<>(c);

        for(Aluno a: this.alunos.values()){             // iterar pelos alunos
            t.add(a.clone());
        }
        return t;

        //         this.alunos.values().forEach(a -> s.add(a.clone()));      , em vez do ciclo for
    }
}
