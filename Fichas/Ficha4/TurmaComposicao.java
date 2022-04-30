package Fichas.Ficha4;

import java.util.*;
import java.util.stream.Collectors;

public class TurmaComposicao {

    private String designacao;
    private List<Aluno> alunos;

    // CONSTRUTORES //

    public TurmaComposicao(){
        this.designacao = "";
        this.alunos = new ArrayList<>();
    }

    public TurmaComposicao(String designacao, List<Aluno> alunos) {
        this.designacao = designacao;

        // 1ª FORMA DE SE FAZER
        this.alunos = new ArrayList<>(alunos.size());
        for (Aluno a :alunos){
            this.alunos.add(a.clone());
        }
    }

    public TurmaComposicao(TurmaComposicao outra){
        this.designacao = outra.getDesignacao();
        this.alunos = outra.getAlunos();
    }

    // GETTER'S & SETTER'S //

    public void setDesignacao(String designacao){
        this.designacao = designacao;
    }

    public void setAlunos(List<Aluno> alunos){
        // 2ª FORMA DE SE FAZER
        this.alunos = alunos.stream().map(Aluno::clone).collect(Collectors.toList());

        // DE IGUAL FORMA:
        // this.alunos = alunos.stream().map(a -> a.clone()).collect(Collectors.toList());
        // Funcionaria, como uma função "anónima"
    }

    public String getDesignacao(){
        return this.designacao;
    }

    public List<Aluno> getAlunos(){
        // 3ª FORMA DE SE FAZER
        List<Aluno> res = new ArrayList<>();
        for(Iterator<Aluno> i = this.alunos.iterator() ; i.hasNext() ; ){     // o último step é vazio, porque a condição de ciclo, já necessita que haja elemento seguinte!
            Aluno a = i.next();
            res.add(a.clone());
        }
        return res;
    }

    // MÉTODOS //

    public void addAluno(Aluno a){
        this.alunos.add(a.clone());
    }

    public boolean existeAluno(Aluno a){
        return this.alunos.contains(a);
    }

    public boolean existeAluno(String nome){
        return this.alunos.stream().anyMatch(a -> a.getNome().equals(nome));
    }

    public boolean existeAlunoNum(String num){                                   // Temos de alterar nome do método, porque o tipo de argumento recebido é o mesmo do método anterior, se fosse diferente já não seria necessário alterar o nome!
        return this.alunos.stream().filter(a -> a.getNumero().equals(num)).count() != 0;
    }

    public Set<Aluno> alunosOrdemAlfabetica(){

        Set<Aluno> res = new TreeSet<>(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno o1, Aluno o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });


        // Set <Aluno> res = new TreeSet<>((o1,o2) -> (o1.getNome().compareTo(o2.getNome())));             // função lambda

        for(Aluno a: this.alunos){
            res.add(a.clone());
        }
        return res;
    }

    public Set<Aluno> alunosOrdemAlfabetica1(){
        return this.alunos.stream().map(Aluno::clone)
                          .sorted((((o1, o2) -> o1.getNome().compareTo(o2.getNome()))))
                          .limit(3).collect(Collectors.toSet());
    }

    public Set<Aluno> alunosPorOrdem(Comparator c){
        return this.alunos.stream().map(Aluno::clone).collect(Collectors.toCollection(() -> new TreeSet<Aluno>(c)));
    }

    // MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //
    @Override
    public String toString() {
        return "TurmaComposicao{" +
                "designacao='" + designacao + '\'' +
                ", alunos=" + alunos +
                '}';
    }

    public TurmaComposicao clone (){
        return new TurmaComposicao(this);
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || o.getClass()!= this.getClass()){
            return false;
        }

        TurmaComposicao t = (TurmaComposicao) o;
        return t.designacao.equals(this.designacao) && t.getAlunos().equals(this.alunos);
    }
}
