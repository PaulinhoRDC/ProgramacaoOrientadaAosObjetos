package Fichas.Ficha5.Ex2;

import java.util.Collections;

public class TestaTurmaAlunos {
    public static void main(String[] args) {
        TurmaAlunos t = new TurmaAlunos(Collections.EMPTY_MAP, "LCC Ano 2", "POO");
        System.out.println(t.toString());

        Aluno a = new Aluno("Tiago", 15 ,"1","LCC");
        t.insereAluno(a);
        a = new Aluno("Joao", 15 ,"2","LCC");
        t.insereAluno(a);
        a = new Aluno("Pedro", 15 ,"3","LCC");
        t.insereAluno(a);
        System.out.println(t.toString());

        System.out.println(t.alunosOrdemAlfabetica().toString());
        System.out.println(t.alunosOrdemDecrescenteNumero().toString());
        System.out.println(t.getAluno("1"));
    }
}
