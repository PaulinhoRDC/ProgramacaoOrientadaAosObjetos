import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parse(Global tudo) throws ExcecaoPos {
        Champions liga = new Champions();
        List<String> linhas = lerFicheiro("\\Users\\paulinhordc\\Desktop\\Projeto\\src\\logsV2.txt");
        Equipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa" -> {
                    String id = String.valueOf(tudo.newCodeNumberequipa());
                    Equipa e = Equipa.parse(linhaPartida[1], id);
                    tudo.addEquipa(e);
                    ultima = e;
                }
                case "Guarda-Redes" -> {
                    j = Redes.parse(linhaPartida[1]);
                    if (ultima == null) throw new ExcecaoPos("err"); //we need to insert the player into the team
                    ultima.addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Defesa" -> {
                    j = Defesa.parse(linhaPartida[1]);
                    if (ultima == null) throw new ExcecaoPos("err"); //we need to insert the player into the team
                    ultima.addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Medio" -> {
                    j = Medio.parse(linhaPartida[1]);
                    if (ultima == null) throw new ExcecaoPos("err"); //we need to insert the player into the team
                    ultima.addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Lateral" -> {
                    j = Lateral.parse(linhaPartida[1]);
                    if (ultima == null) throw new ExcecaoPos("err"); //we need to insert the player into the team
                    ultima.addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Avancado" -> {
                    j = Avancado.parse(linhaPartida[1]);
                    if (ultima == null) throw new ExcecaoPos("err"); //we need to insert the player into the team
                    ultima.addJogador(j); //if no team was parsed previously, file is not well-formed
                }
                case "Jogo" -> {
                    Jogo jo = Jogo.parse(linhaPartida[1], tudo);
                    tudo.addJogoRealizado(jo);
                }
                default -> throw new ExcecaoPos("err");
            }
        }
        //debug
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


}
