package Fichas.Exame21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Podcast {
    String id;                 //identificador do podcast
    List<Episodio> episodios; //lista de episodios

    public Podcast(String id,List<Episodio> episodios) {
        this.id = id;
        this.episodios = episodios;
    }

    public Podcast(Podcast obj) {
        this.id = obj.getId();
        this.episodios = obj.getEpisodios();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Episodio> getEpisodios() {
        return this.episodios.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = new ArrayList<>(episodios);;
    }

    public Episodio getEpisodio(String idEpisodio) {
        return episodios.stream().filter(ep -> ep.getNome().equals(idEpisodio))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Exame2021.Podcast{" +
                "id='" + id + '\'' +
                ", episodios=\n" + episodios +
                "}";
    }

    public Podcast clone() {
        return new Podcast(this);
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj== null || obj.getClass()!=this.getClass()) return false;
        Podcast p = (Podcast) obj;
        return p.getId().equals(this.getId()) &&
                p.getEpisodios().equals(this.getEpisodios());
    }
}