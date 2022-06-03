package t2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<Boolean> getEEstatus1(List<Empregado> l){
        return l.stream().filter(e -> e instanceof Aluno)
                .map(a -> ((Aluno) a).epocaEspecial())
                .collect(Collectors.toList());
    }

    public static List<Boolean> getEEStatus2(List<Aluno> l){
        return l.stream().filter(a-> a instanceof Empregado)
                .map(e-> e.epocaEspecial())
                .collect(Collectors.toList());
    }

    public static List<Boolean> getEEstatus3(List<Empregado> l){
        return l.stream().map(e-> (Aluno)e)
                .map(a-> a.epocaEspecial())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Empregado> lemp = new ArrayList<>();
        lemp.add(new Funcionario());
        lemp.add(new AlunoTE());
        lemp.add(new Funcionario());
        lemp.add(new AlunoTE());
        lemp.add(new Funcionario());

        List<Aluno> lal = new ArrayList<>();
        lal.add(new AlunoTE());
        lal.add(new Aluno());
        lal.add(new AlunoTE());
        lal.add(new Aluno());

        System.out.println(getEEstatus1(lemp));
        System.out.println(getEEStatus2(lal));
        System.out.println(getEEstatus3(lemp));

    }
}
