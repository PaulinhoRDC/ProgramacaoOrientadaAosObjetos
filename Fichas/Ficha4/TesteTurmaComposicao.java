package Fichas.Ficha4;

import java.util.List;
import java.util.Set;

public class TesteTurmaComposicao {

    public static void main(String [] args){
        TurmaComposicao t = new TurmaComposicao();
        t.setDesignacao("Uma turma");

        for(int j = 0; j<2; j++){
            for(int i = 9 ; i > 0; i--){
                t.addAluno(
                            new Aluno(String.valueOf(i), i, String.valueOf(i), "um curso")
                          );
            }
        }

        List<Aluno> la = t.getAlunos();
        System.out.println("turma " +la.size() + " " + la + "\n");

        Set<Aluno> sa = t.alunosOrdemAlfabetica();
        System.out.println("turma " +sa.size() + " " + sa + "\n");

        System.out.println("3 alunos " + t.alunosOrdemAlfabetica1());

    }
}
