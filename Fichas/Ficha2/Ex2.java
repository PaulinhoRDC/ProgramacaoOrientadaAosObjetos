package Fichas.Ficha2;

public class Ex2 {

    //(a)
    public int[][] lerAt(int[][] notas, int aluno, int[] notasAluno) {

        for(int j=0;j<5;j++){
            notas[aluno][j] = notasAluno[j];
        }
        return notas;
    }
}
