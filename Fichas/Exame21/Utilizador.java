package Fichas.Exame21;

import java.util.List;

public class Utilizador implements InterfaceExemplo {
    private String id;
    private String nome;
    private List<Podcast> subscricoes; //podcasts a q o user está subscrito
    private Episodio isPlaying; //boleano que assinala se o user esta a reproduzir conteudo

    public Utilizador(String id, String nome, List<Podcast> subscricoes) {
        this.id = id;
        this.nome = nome;
        this.subscricoes = subscricoes;
        this.isPlaying = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Podcast> getSubscricoes() {
        return subscricoes;
    }

    public void setSubscricoes(List<Podcast> subscricoes) {
        this.subscricoes = subscricoes;
    }

    public Episodio getIsPlaying() { return isPlaying; }

    public void setIsPlaying(Episodio playing) { isPlaying = playing; }

    @Override
    public String toString() {
        return "Exame2021.Utilizador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", subscricoes=" + subscricoes +
                '}';
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio)
            throws AlreadyPlayingException {
        if (!(isPlaying == null)) throw new AlreadyPlayingException();
        else {
            for (Podcast p : subscricoes) {
                if (p.getId().equals(idPodCast)) setIsPlaying(p.getEpisodio(nomeEpisodio));
            }
        }
    }


    @Override
    public void play(String id) {
        System.out.println("The id "+id+" is currently playing.\n");
        run();
    }

    @Override
    public boolean run() {
        return true;
    }


}
