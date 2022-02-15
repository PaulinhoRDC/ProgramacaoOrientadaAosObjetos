import java.rmi.MarshalledObject;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


//Ainda em desenvolvimento, possivelmente pode nao constar no projeto final mas tem como objetivo simular uma liga
public class Champions {
    Map<String,Equipa> equipas;
    Map<LocalDate,Jogo> jogos;

    public Champions() {
        this.equipas = new LinkedHashMap<>();
        this.jogos = new LinkedHashMap<>();
    }

    public Champions(Map<String,Equipa> equipas){
        this.equipas = new LinkedHashMap<>(equipas);
        this.jogos = outrocalendario();
    }

    public Champions(Map<String,Equipa> equipas,Map<LocalDate,Jogo> jogos){
        this.equipas = new LinkedHashMap<>(equipas);
        this.jogos = new LinkedHashMap<>(jogos);
    }

    public Champions (Champions e){
        this.equipas = e.getEquipas();
        this.jogos = e.getJogos();
    }

    public Map<String,Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public Map<LocalDate,Jogo> getJogos(){
        return this.jogos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue()));
    }

    public void setEquipas (Map<String, Equipa> eq){
        this.equipas = eq.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue()));
    }

    public void setJogos(Map<LocalDate,Jogo> jogos){
        this.jogos = jogos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void addJogo(Jogo j){
        this.equipas.putIfAbsent(j.getcasa().getId(),j.getcasa().clone());
        this.equipas.putIfAbsent(j.getVisita().getId(),j.getVisita().clone());
        this.jogos.putIfAbsent(j.getData(),j);
    }

    public Map<LocalDate,Jogo> outrocalendario(){
        Map<LocalDate,Jogo> ret = new LinkedHashMap<>();
        List<Equipa> eq = this.equipas.values().stream().map(Equipa::clone).collect(Collectors.toList());
        Collections.shuffle(eq);
        LocalDate agora = LocalDate.now();
        for(int i=0;i<eq.size();i++) {
            Equipa a = eq.get(i);
            for (int n=0; n<eq.size(); n++) {
                Equipa b = eq.get(n);
                if(!a.equals(b)) {
                    Jogo jogo = new Jogo(a, b, 0, 0);
                    ret.put(agora,jogo);
                    agora = agora.plusWeeks(1);
                }
                agora = agora.plusWeeks(1);
            }
        }
        return ret;
    }

    public void calendario(){

        List<Equipa> eq = this.equipas.values().stream().map(Equipa::clone).collect(Collectors.toList());
        Collections.shuffle(eq);
        LocalDate agora = LocalDate.now();
        for(int i=0;i<eq.size();i++) {
            Equipa a = eq.get(i);
            for (int n=0; n<eq.size(); n++) {
                Equipa b = eq.get(n);
                if(!a.equals(b)) {
                    Jogo jogo = new Jogo(a, b, 0, 0);
                    this.jogos.put(agora,jogo);
                    agora = agora.plusWeeks(1);
                }
                agora = agora.plusWeeks(1);
            }
        }
    }

    public List<Equipa> ordenaequipasporpontos(List<Equipa> eq) {
        Comparator<Equipa> comp = (e1, e2) -> (int) e2.getpontos() - e1.getpontos();
        return eq.stream().sorted(comp).collect(Collectors.toList());
    }

    public void simulachampions() throws ExcecaoPos, InterruptedException {
        StringBuilder sb = new StringBuilder();
        Equipa vencedora = new Equipa();
        List<Equipa> eq = new ArrayList<>();
        calendario();

        for(LocalDate data: this.jogos.keySet()){
            System.out.println(data+"\n\n");
            Jogo jogo = this.jogos.get(data);
            Equipa a = this.equipas.get(jogo.getcasa().getId());
            Equipa b = this.equipas.get(jogo.getVisita().getId());
            System.out.println(a.getNome() +" vs " + b.getNome());
            jogo.simulajogo();

            if (jogo.getGoloC() == jogo.getGoloF()) {a.pontos(1); b.pontos(1);}else{
                if (jogo.getGoloC() > jogo.getGoloF()) {a.pontos(3);}else{
                    if (jogo.getGoloC() < jogo.getGoloF()) {b.pontos(3);}}}

        }

            List<Equipa> porpontos = ordenaequipasporpontos(this.equipas.values().stream().collect(Collectors.toList()));
            vencedora = porpontos.get(0);
            int x= vencedora.getpontos();
            for(Equipa e : eq){
                e.setPontos(0);
            }

            System.out.println("A equipa que vencou a champions foi: " + vencedora.getNome());
        }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Calendario de jogos: \n");
        for(LocalDate data : this.jogos.keySet()){
            sb.append("\nDia: " + data + "\nJogo: " + this.jogos.get(data).getcasa().getNome() +" vs " + this.jogos.get(data).getVisita().getNome());
        }
        return sb.toString();
    }

    public String todosOsJogos(){
        StringBuilder sb = new StringBuilder();
        for (Jogo jogo : this.jogos.values()){
            sb.append("\nDia: " + jogo.getData() + "\nJogo: \n" + jogo.getcasa().getNome() + " vs " + jogo.getVisita().getNome() + "\nResultado: " + jogo.getGoloC() + "-" + jogo.getGoloC() + "\n\n");
        }
        return sb.toString();
    }

}
