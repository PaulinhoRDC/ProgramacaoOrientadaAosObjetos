package t2021;

public class AlunoTE extends Aluno implements Empregado{
    public boolean epocaEspecial(){
        return true;
    }
    public String getEmpregador(){
        return "Externo";
    }
}
