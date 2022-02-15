import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//Classe "mestra"
public class Global {

    private Map<String, Equipa> equipas;
    private ArrayList<Jogo> jogos;
    private ArrayList<Jogo> jogosrealizados;

    public Global() {
        this.equipas = new LinkedHashMap<>();
        this.jogos = new ArrayList<>();
        this.jogosrealizados = new ArrayList<>();
    }

    public Global(Map<String, Equipa> equipas) {
        this.equipas = new LinkedHashMap<>(equipas);
        this.jogos = new ArrayList<>();
    }

    public Global(Map<String, Equipa> equipas,ArrayList<Jogo> jogos,ArrayList<Jogo> jogosrealizados) {
        this.equipas = new LinkedHashMap<>(equipas);
        this.jogos = new ArrayList<>(jogos);
        this.jogosrealizados = new ArrayList<>(jogosrealizados);
    }

    public Global(Global e) {
        this.equipas = e.getEquipas();
        this.jogos = e.getJogos();
        this.jogosrealizados = e.getJogosRealizados();
    }

    public Map<String, Equipa> getEquipas() {
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public ArrayList<Jogo> getJogos(){
        return this.jogos.stream().map(Jogo::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Jogo> getJogosRealizados(){
        return this.jogosrealizados.stream().map(Jogo::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setEquipas(Map<String, Equipa> e) {
        this.equipas = new LinkedHashMap<>(e);
    }

    public void setJogos(ArrayList<Jogo> e){ this.jogos = new ArrayList<>(e);}

    public void setJogosrealizados(ArrayList<Jogo> e){ this.jogosrealizados = new ArrayList<>(e);}

    public void addEquipa(Equipa e) throws ExcecaoPos {

        if (this.equipas.containsKey(e.getId())) throw new ExcecaoPos("Equipa ja registada");
        else
            this.equipas.putIfAbsent(e.getId(), e);
    }

    public void addJogo(Jogo e){
        if(!this.jogos.contains(e)){
            this.jogos.add(e);
        }
    }

    public void addJogoRealizado(Jogo e){
        this.jogosrealizados.add(e);
    }

    public void removeEquipa(Equipa e) throws ExcecaoPos {
        if (this.equipas.containsValue(e)) this.equipas.remove(e.getId(), e);
        else throw new ExcecaoPos("Equipa nao se encontra registada");
    }

    //Faz transferencias de jogadores entre equipas
    public void tranfere(Jogador jogador, Equipa sai, Equipa entra) throws ExcecaoPos{

        for(Equipa a : this.equipas.values()){
            ArrayList<String> numeroscamisola = entra.getEquipa().stream().map(Jogador::getId).collect(Collectors.toCollection(ArrayList::new));
            if(sai.equals(a)){
                jogador.sethabtit("");
                sai.removeJogador(jogador);
            }
            if(entra.equals(a)){
                if (numeroscamisola.contains(jogador.getId())){
                    String novoId = String.valueOf(newCodeNumberjogadoreq(entra));
                    jogador.setId(novoId);
                    entra.addJogador(jogador);
                }
                else {
                    entra.addJogador(jogador);
                }
            }
        }
    }

    private boolean contida (Equipa e) {
        return this.equipas.keySet().stream().anyMatch(a -> a.equals(e.getId()));
    }

    //Um jogo vai ser realizado e depois vai ser adicionado ao historico de jogos e vai guarda-lo no ficheiro
    public void simulaumjogo(Equipa casa, Equipa visita) throws ExcecaoPos, InterruptedException, IOException {

        if (contida(casa) && contida(visita)) {
            Jogo jogo = new Jogo(casa,visita,0,0);
            if(!this.jogos.contains(jogo)){
                addJogo(jogo);
            }
            jogo.simulajogo();
            addJogoRealizado(jogo);
            jogo.guardajogo();
        }
        else throw new ExcecaoPos("A equipa nao esta registada");
    }

    //Gera um codigo novo para uma Equipa! Cada Equipa tem um id diferente, nao ha Equipas com o mesmo id
    //Pomos todos os ids das Equipas numa lista e ordenamos essa lista! Pegamos no ultimo valor da lista e adicionamos 1! Esse valor vai ser o novo id
    public int newCodeNumberequipa(){
        if (this.equipas.size()==0){
            return 1;
        }
    else {
            List<Integer> l = this.equipas.keySet().stream()
                    .map(Integer::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
            if (l.isEmpty()) return 1;
            Integer i = l.get(0);
            int aux = i + 1;
            while (l.contains(aux)) aux++;
            return aux;
        }
    }

    //Gera um numero de camisola novo para um jogador! Cada jogador tem um numero diferente, nao ha jogadores com o mesmo numero numa equipa
    //Pomos todos os ids dos jogadores numa lista e ordenamos essa lista! Pegamos no ultimo valor da lista e adicionamos 1! Esse valor vai ser o novo id
    public int newCodeNumberjogadoreq(Equipa e){
        ArrayList<Jogador> todosjogadores = new ArrayList<>();

        ArrayList<Jogador> jequipa = e.getEquipa();
        todosjogadores.addAll(jequipa);


        List<String> mapjog = todosjogadores.stream().map(Jogador::getId).collect(Collectors.toList());

        List<Integer> l = mapjog.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
        if (l.isEmpty()) return 1;
        Integer i = l.get(0);
        int aux = i+1;
        while (l.contains(aux)) aux++;
        return aux;
    }

    public int newCodeNumberjogador(){
        ArrayList<Jogador> todosjogadores = new ArrayList<>();

        for(Equipa e : this.equipas.values()) {
            ArrayList<Jogador> jequipa = e.getEquipa();
            todosjogadores.addAll(jequipa);
        }


        List<String> mapjog = todosjogadores.stream().map(Jogador::getId).collect(Collectors.toList());

        List<Integer> l = mapjog.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
        if (l.isEmpty()) return 1;
        Integer i = l.get(0);
        int aux = i+1;
        while (l.contains(aux)) aux++;
        return aux;
    }



    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Equipa e : this.equipas.values()){
            sb.append("\n" + e.toStringSimples());
        }
        return sb.toString();
    }

    public String toStringEquipa(Equipa a){
        StringBuilder sb = new StringBuilder("               Equipa\n");

        if(this.equipas.containsValue(a)){
            sb.append("\n" + a.toString());
        }
        else{sb.append("A equipa nao foi encontrada"); }
        return sb.toString();
    }

    public String toStringjogadores(){
        StringBuilder sb = new StringBuilder("               Jogadores\n");
        ArrayList<Jogador> jog = new ArrayList<>();
        for(Equipa e : this.equipas.values()){
            jog.addAll(e.getEquipa());
            for(Jogador jo : jog){
                sb.append("\n" + jo.toString());
            }
        }

        return sb.toString();
    }

    public String jogosRegistados(){
        StringBuilder sb = new StringBuilder();
        sb.append("Jogos Registados: \n");
        for(Jogo jogo : this.jogos){
            sb.append("\nDia: " + jogo.getData() + "\nJogo: \n" + jogo.getcasa().getNome() + " vs " + jogo.getVisita().getNome() +"\n");
        }

        return sb.toString();
    }

    public String historicoJogos() {
        StringBuilder sb = new StringBuilder();
        if (this.jogosrealizados.size() > 0) {
            sb.append("Historico de Jogos: \n");
            for (Jogo jogo : this.jogosrealizados) {
                sb.append("\nDia: " + jogo.getData() + "\nJogo: \n" + jogo.getcasa().getNome() + " vs " + jogo.getVisita().getNome() +  "\nResultado: " + jogo.getGoloC() + "-" + jogo.getGoloF() + "\n\n");
            }
        } else {
            sb.append("\n\nAinda nao foram realizados jogos\n\n");
        }

        return sb.toString();
    }

    public void simulaJogoEspecifico(Equipa casa,Equipa fora, LocalDate data) throws ExcecaoPos, InterruptedException, IOException {
        int j = 0;
        Jogo aux = new Jogo();
        for (Jogo jogo : this.jogos){
            if (casa.equals(jogo.getcasa()) && fora.equals(jogo.getVisita()) && data.equals(jogo.getData())){
                jogo.simulajogo();
                addJogoRealizado(jogo);
                aux = jogo;
                jogo.guardajogo();
                j += 1;
            }
        }
        if (j==0){
            throw new ExcecaoPos("O jogo nao esta registado");
        }
        this.jogos.remove(aux);
    }

    public void simulaJogoEspecificoSP(Equipa casa,Equipa fora, LocalDate data) throws ExcecaoPos, InterruptedException, IOException {
        int j = 0;
        Jogo aux = new Jogo();
        for (Jogo jogo : this.jogos){
            if (casa.equals(jogo.getcasa()) && fora.equals(jogo.getVisita()) && data.equals(jogo.getData())){
                jogo.simulajogosemprint();
                addJogoRealizado(jogo);
                aux=jogo;
                jogo.guardajogo();
                j = 1;
            }
        }
        if (j==0){
            throw new ExcecaoPos("O jogo nao esta registado");
        }
        this.jogos.remove(aux);
    }

    public String resultadojogorealizado(Equipa casa, Equipa fora, LocalDate data){
        StringBuilder sb = new StringBuilder();
        for (Jogo jogo:this.jogosrealizados){
            if (casa.equals(jogo.getcasa()) && fora.equals(jogo.getVisita()) && data.equals(jogo.getData())){
                sb.append("Resultado: \n" + jogo.getcasa().getNome() + "-> " + jogo.getGoloC());
                sb.append("\n" + jogo.getVisita().getNome() + "-> " + jogo.getGoloF());
            }
        }
        return sb.toString();
    }

    public boolean existeNomeEquipa(String nome){
    return this.equipas.values().stream().anyMatch(a->a.getNome().equalsIgnoreCase(nome));
    }

    public boolean existeNome(String nome){
        return this.equipas.values().stream().anyMatch(a->a.getEquipa().stream().anyMatch(b->b.getNome().equalsIgnoreCase(nome)));
    }

    public Jogo identificaJogo(LocalDate data) throws ExcecaoPos {
        Jogo aux = new Jogo();
        int k = 0;
        for(Jogo jogo:this.jogos){
            if(data.equals(jogo.getData())){
                aux=jogo;
                k=1;
            }
        }
        if(k==0){
            throw new ExcecaoPos("O jogo nao esta registado");
        }
        return aux;
    }

    //Identifica uma equipa pelo nome
    public Equipa identificaEquipa(String nome) throws ExcecaoPos {
        Equipa res = new Equipa();
        for(Equipa e : this.equipas.values()){
            if(e.getNome().equalsIgnoreCase(nome)){
                res = e.clone();
            }
        }
        return res;
    }

    //Identifica um jogador numa equipa
    public Jogador identificaJogador(String nome, Equipa e){
       return e.identificaJogador(nome);
    }

    public Jogador identificaJogadorId(String id, Equipa e){
        return e.identificaJogadorId(id);
    }
    //Faz o update de uma equipa
    public void update(Equipa a){

        for(Equipa e: this.equipas.values()){
            if(e.getId().equals(a.getId())){
                e.update(a);
            }
        }
    }

    //Devolve todas as equipas que têm o mesmo nome
    public ArrayList<Equipa> equipasNomeIgual(String nome){
        return this.equipas.values().stream().filter(a->a.getNome().equalsIgnoreCase(nome)).map(Equipa::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    //Devolve todos os jogadores registados com o mesmo nome
    public ArrayList<Jogador> jogadoresNomeIgual(String nome){
        ArrayList<Jogador> todos = new ArrayList<>();
        this.equipas.values().stream().map(Equipa::getEquipa).forEach(todos::addAll);
        return todos.stream().filter(a->a.getNome().equalsIgnoreCase(nome)).collect(Collectors.toCollection(ArrayList::new));
    }

    //Devolve todos os jogadores com o mesmo nome numa equipa
    public ArrayList<Jogador> jogadoresNomeIgualNaEquipa(String nome, Equipa e){
        ArrayList<Jogador> todos = new ArrayList<>();
        for(Equipa k : this.equipas.values()){
            if(e.equals(k)){
                todos.addAll(e.getEquipa());
            }
        }
        return todos.stream().filter(a->a.getNome().equalsIgnoreCase(nome)).collect(Collectors.toCollection(ArrayList::new));
    }

    //Ordena as equipas por habilidade, das que tem mais habilidade para a que tem menos
    public List<Equipa> ordenaporhabilidade(){
        Comparator<Equipa> comp = (e1,e2) -> (int) e2.habgeral()-e1.habgeral();
        return this.equipas.values().stream().sorted(comp).collect(Collectors.toList());
    }

    public void simulaChampions(ArrayList<Equipa> equipas) throws ExcecaoPos, InterruptedException {
        Map<String,Equipa> equip = equipas.stream().collect(Collectors.toMap(e->e.getId(),e->e.clone()));
        Champions liga = new Champions(equip);
        liga.simulachampions();
    }

}
