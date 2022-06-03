package Fichas.Exame21;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilizadorPremium extends Utilizador implements InterfaceExemplo  {
    private List<Episodio> waitingList;

    public UtilizadorPremium(String id, String nome, List<Podcast> subscricoes) {
        super(id, nome, subscricoes);
        this.waitingList = new ArrayList<>();
    }

    public List<Episodio> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<Episodio> waitingList) {
        this.waitingList = waitingList;
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio) throws AlreadyPlayingException {

        Podcast p = super.getSubscricoes().stream().filter(a->a.getId().equals(idPodCast)).findFirst().orElse(null);

        if (super.getIsPlaying()==null) {
            super.setIsPlaying(p.getEpisodio(nomeEpisodio));
        }
        else {
            waitingList.add(p.getEpisodio(nomeEpisodio));
        }
    }

    public void gravaInfoEpisodiosParaTocarMaisTarde(String fich) throws IOException {
        FileWriter fw = new FileWriter(fich+".txt");
        fw.append(super.getNome()+"\n");
        for (Episodio ep : waitingList) {
            fw.append(ep.getNome()+" - ");
            fw.append(ep.getDuracao().toString()+"\n");
        }
        fw.flush();
        fw.close();
    }

    public boolean testInstance() {
        if (this instanceof InterfaceExemplo) return true;
        else return false;
    }

}
