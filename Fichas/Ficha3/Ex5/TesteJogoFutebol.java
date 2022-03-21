package Fichas.Ficha3.Ex5;

public class TesteJogoFutebol {

    public static void main(String[] args) {
        Jogofutebol j = new Jogofutebol();
        Jogofutebol j2 = j.clone();
        j.startGame();
        j.goloVisitado();
        String res = j.resultadoAtual();
        System.out.println(res);
        j.goloVisitante();
        res = j.resultadoAtual();
        System.out.println(res);
        String wtf = j.toString();
        System.out.println(wtf);
        System.out.println("Iguais: " + j.equals(j2));
        j.endGame();
    }

}
