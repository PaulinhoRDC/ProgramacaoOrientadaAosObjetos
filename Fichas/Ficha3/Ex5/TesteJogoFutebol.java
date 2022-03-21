package Fichas.Ficha3.Ex5;

public class TesteJogoFutebol {

    public static void main(String[] args) {
        Jogofutebol j = new Jogofutebol();
        Jogofutebol j2 = j.clone();
        System.out.println("Podemos verificar que sem chamarmos métodos no jogo 1, este é igual ao jogo 2!");
        System.out.println("Iguais: " + j.equals(j2));

        System.out.println("\nVamos começar a evoluir no jogo 1!");
        j.startGame();
        j.goloVisitado();
        String res = j.resultadoAtual();
        System.out.println(res);

        j.goloVisitante();
        res = j.resultadoAtual();
        System.out.println(res);


        String jogo1 = j.toString();
        System.out.println(jogo1);

        j.endGame();
        System.out.println(j);

        System.out.println("\nPodemos agora verificar se os jogos, continuam a ser iguais! " );
        System.out.println("Iguais: " + j.equals(j2));
        j.endGame();
    }

}
