import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
//Classe que simula os jogos! Ainda falta um metodo para simular o jogo sem escrever na consola! Para apresentar somente o resultado
//Nesta classe simulamos so um jogo entre duas equipas e chamamos a interface Probjogos onde estabelecemos randoms em que temos em consideraçao as habilidades dos jogadores
public class Jogo implements Probabilidades {

    private LocalDate data;
    private Equipa casa;
    private Equipa visita;
    private int goloC;
    private int goloF;
    private Map<String,Jogador> subscasa;
    private Map<String,Jogador> subsfora;

    public Jogo() {
        this.data = LocalDate.now();
        this.casa = new Equipa();
        this.visita = new Equipa();
        this.goloC = 0;
        this.goloF = 0;
        this.subscasa = new LinkedHashMap<>();
        this.subsfora = new LinkedHashMap<>();
    }

    public Jogo(Equipa a, Equipa b, int c, int f){
        this.data = LocalDate.now();
        this.casa = a.clone();
        this.visita = b.clone();
        this.goloC = c;
        this.goloF = f;
        this.subscasa = new LinkedHashMap<>();
        this.subsfora = new LinkedHashMap<>();
    }

    public Jogo(LocalDate data, Equipa a, Equipa b, int gc, int gf, Map<String,Jogador>subscasa, Map<String,Jogador> subsfora) {
        this.data = data;
        this.casa = a.clone();
        this.visita = b.clone();
        this.goloC = gc;
        this.goloF = gf;
        this.subscasa = new LinkedHashMap<>(subscasa);
        this.subsfora = new LinkedHashMap<>(subsfora);
    }

    public Jogo(Jogo a) {
        this.data = a.getData();
        this.casa = a.getcasa();
        this.visita = a.getVisita();
        this.goloC = a.getGoloC();
        this.goloF = a.getGoloF();
        this.subscasa = a.getsubsCasa();
        this.subsfora = a.getsubsFora();
    }

    public LocalDate getData(){
        return this.data;
    }

    public Equipa getcasa() {
        return new Equipa(this.casa);
    }

    public Equipa getVisita() {
        return new Equipa(this.visita);
    }

    public int getGoloC() {
        return this.goloC;
    }

    public int getGoloF() {
        return this.goloF;
    }

    public Map<String,Jogador> getsubsCasa(){
        return this.subscasa.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), e->e.getValue().clone()));
    }

    public Map<String,Jogador> getsubsFora(){
        return this.subsfora.entrySet().stream().collect(Collectors.toMap(k->k.getKey(), e->e.getValue().clone()));
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setCasa(Equipa a) {
        this.casa = a;
    }

    public void setVisita(Equipa a) {
        this.visita = a;
    }

    public void setGoloC(int gc) {
        this.goloC = gc;
    }

    public void setGoloF(int gf) {
        this.goloF = gf;
    }

    public void setSubscasa(Map<String,Jogador> jogs) throws ExcecaoPos {
        boolean pode = true;
        for(String s : jogs.keySet()){
            if (!(this.casa.getTitulares().contains(this.casa.identificaJogadorId(s)) || this.casa.getEquipa().contains(jogs.get(s)))){
                pode = false;
                throw new ExcecaoPos("Substituicao invalida");
            }
        }
        if (jogs.size() % 2 == 0 && jogs.size()<=6 && pode) {
            this.subscasa = jogs.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e -> e.getValue().clone()));
        }
        else{
            throw new ExcecaoPos("Erro");
        }
    }

    public void setSubsfora(Map<String,Jogador> jogs) throws ExcecaoPos {
        boolean pode = true;
        for(String s : jogs.keySet()){
            if (!(this.visita.getTitulares().contains(this.visita.identificaJogadorId(s)) || this.visita.getEquipa().contains(jogs.get(s)))){
                pode = false;
                throw new ExcecaoPos("Substituicao invalida");
            }
        }
        if (jogs.size() % 2 == 0 && jogs.size()<=6 && pode) {
            this.subsfora = jogs.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e -> e.getValue().clone()));
        }
        else{
            throw new ExcecaoPos("Erro");
        }
    }

    //Substituições casa/fora
    public void addsubscasa(Jogador e, Jogador s) throws ExcecaoPos {

        if(!(this.casa.getTitulares().contains(e) || this.casa.getEquipa().contains(s))){
            throw new ExcecaoPos("Impossivel adicionar substituicao");
        } else{
            if (!this.subscasa.containsValue(e) && !this.subscasa.containsValue(s) && this.subscasa.size() <= 4) {
                this.subscasa.put(s.getId(), e.clone());
            } else {
                throw new ExcecaoPos("Substituicao impossivel");
            }
        }
    }

    public void addsubsfora(Jogador e, Jogador s) throws ExcecaoPos {
        if(!(this.visita.getTitulares().contains(e) || this.visita.getEquipa().contains(s))){
            throw new ExcecaoPos("Impossivel adicionar substituicao");
        } else {
            if (!this.subsfora.containsValue(e) && !this.subsfora.containsValue(s) && this.subsfora.size() <= 4) {
                this.subsfora.put(s.getId(), e.clone());
            } else {
                throw new ExcecaoPos("Substituicao impossivel");
            }
        }
    }

    //Efetua a substituição, recebendo um tempo, quando o tempo gerado é igual a este valor, realiza-se sub.
    private void fazsubstituicoes(int time,ArrayList<Integer>temposubscasa,ArrayList<Integer>temposubsfora) throws ExcecaoPos {
        for(Integer p : temposubscasa) {
            if (time==p){
                if(this.subscasa.size()>0){
                Jogador sai = this.casa.identificaJogadorId(this.subscasa.keySet().stream().findFirst().get());
                Jogador entra = this.subscasa.get(sai.getId());
                this.casa.substitui(entra,sai);
                this.subscasa.remove(sai.getId());
                System.out.println("\nA substituicao foi concluida sem problemas. " + this.casa.getNome() + "\nSai: " + sai.getNome() + "\nEntra: " + entra.getNome() );
                }
            }
        }

        for(Integer p : temposubsfora){
            if (time==p){
                if(this.subsfora.size()>0) {
                    Jogador sai = this.visita.identificaJogadorId(this.subsfora.keySet().stream().findFirst().get());
                    Jogador entra = this.subsfora.get(sai.getId());
                    this.visita.substitui(entra, sai);
                    this.subsfora.remove(sai.getId());
                    System.out.println("\nA substituicao foi concluida sem problemas " + this.visita.getNome() + "\nSai: " + sai.getNome() + "\nEntra: " + entra.getNome());
                }
            }
        }
    }

    //Metodo em que simulamos o jogo!
    //A bola começa na equipa da casa e as habilidades dos medios sao comparadas, caso estas sejam maiores que os da equipa adversaria, entao é feito um ataque
    //Caso contrario, a equipa adversaria faz um ataque

    public void simulajogo() throws ExcecaoPos, InterruptedException {
        Map<String,Jogador> antescasa = getsubsCasa();
        Map<String,Jogador> antesfora = getsubsFora();

        int i = 0;
        ArrayList<Integer> temposubscasa = new ArrayList<>();
        ArrayList<Integer> temposubsfora = new ArrayList<>();
        System.out.println(this.casa.getNome() + " vs " + this.visita.getNome());

        if(this.subscasa.size()>0) {
            for (int k = 0; k <= (this.subscasa.size() / 2) + 1; k++) {
                int tempo = rand.nextInt(85);
                if (tempo > 5) {
                    temposubscasa.add(tempo);
                } else tempo = rand.nextInt(85);
            }
        }

        if(this.subsfora.size()>0) {
            for (int k = 0; k <= (this.subsfora.size() / 2) + 1; k++) {
                int tempo = rand.nextInt(85);
                if (tempo > 5) {
                    temposubsfora.add(tempo);
                } else tempo = rand.nextInt(85);
            }
        }

        if(this.casa.getTitulares().size() == 11 && this.visita.getTitulares().size() == 11) {
            for (int time = 0; time <= 45; time++) {

                fazsubstituicoes(time,temposubscasa,temposubsfora);
                System.out.println("\nJogo a decorrer \nminuto: "+ time);
                time = time +1;
                    while (time <= 5) {
                        Thread.sleep(2000);
                        fazsubstituicoes(time,temposubscasa,temposubsfora);
                        System.out.println("\nJogo a decorrer \nminuto: " + time);
                        time++;
                    }
                        //comparação falada em cima (habilidades médias)
                    if (probabilidadeMeio(this.casa.habmedio()) > probabilidadeMeio(this.visita.habmedio())) {
                        System.out.println("A equipa " + this.casa.getNome() + " esta a atacar");
                        i = simulaataque(time, this.casa, this.visita) + time;

                    } else {
                        System.out.println("A equipa " + this.visita.getNome() + " esta a atacar");
                        i = simulaataque(time, this.visita, this.casa) + time;
                    }
                        while (time>1 && time != i && time < 45){
                            Thread.sleep(2000);
                            fazsubstituicoes(time,temposubscasa,temposubsfora);
                            time++;
                            System.out.print("\nminuto: " + (time));
                }
            }

            // Segunda parte (análogo)
            System.out.println("\nComeca agora a segunda parte do jogo.\nEquipa " + this.casa.getNome() +": " + this.goloC + "\nEquipa " + this.visita.getNome() +":"  + this.goloF);

            for (int time=46; time<=90;time ++){
                fazsubstituicoes(time,temposubscasa,temposubsfora);
                System.out.println("\nJogo a decorrer \nminuto: "+ time);
                    //Na primeira parte a bola vai começar na equipa da casa
                    while (time <= 49) {
                        Thread.sleep(2000);
                        fazsubstituicoes(time,temposubscasa,temposubsfora);
                        System.out.println("\nJogo a decorrer  \nminuto: " + time);
                        time++;
                        }
                        if (probabilidadeMeio(this.visita.habmedio()) > probabilidadeMeio(this.casa.habmedio())) {
                            System.out.println("A equipa " + this.visita.getNome() + " esta a atacar");
                            i = simulaataque(time, this.visita, this.casa) + time;

                        } else {
                            System.out.println("A equipa " + this.casa.getNome() + " esta a atacar");
                            i = simulaataque(time, this.casa, this.visita) + time;


                        }
                        Thread.sleep(2000);
                        while (time>45 && time != i && time < 45) {
                            Thread.sleep(2000);
                            fazsubstituicoes(time,temposubscasa,temposubsfora);
                            time++;
                            System.out.print("\nMinuto: " + (time));
                        }
                }
            System.out.println("\nEquipa " + this.casa.getNome() +": " + this.goloC + "\nEquipa " + this.visita.getNome() +":"  + this.goloF);

            this.subsfora = antesfora.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
            this.subscasa = antescasa.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        }
        else throw new ExcecaoPos("Quantidade de jogadores titulares errada");
        }

    //Os ataques podem ser feitos atraves do centro do campo ou atraves dos laterais
    //É retornado um inteiro, sendo este o tempo que o ataque vai demorar!
    //Este inteiro é um random limitado com o tempo que achamos conveniente para cada açao!
    public int simulaataque (int time, Equipa ataca, Equipa defende) throws InterruptedException, ExcecaoPos {
        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }

        //se a equipa que está a atacar tiver mais habilidade nos laterais entao ha mais probabilidade de fazer o ataque pelos laterais
        int lat = rand.nextInt(ataca.hablateral());
        int frente = rand.nextInt(ataca.habfrente());

        if (lat-15>frente){
            minutos += simulacanto(time+minutos,ataca,defende);
        }
        else {
            if (probabilidadeMarcar(ataca.habfrente()) > probabilidadeDefender(defende.habdefesa())) {
                System.out.println("Os avançados (" + ataca.getNome() + ") progredem e ganham espaço no campo");
                minutos += rand.nextInt(4);
                if (probabilidadeMarcar(ataca.habfrente()) > probabilidadeRedes(defende.habredes())) {
                    Jogador remata = selecionaavancado(ataca);
                    double remate = remata.getRemate();
                    if (rand.nextInt((int) remate) < remate - 7) {

                        System.out.println("A equipa " + ataca.getNome() + " marcou!");
                        System.out.println( remata.getNome() + "foi o jogador que consegui obter o golo!");
                        marca = true;
                        if (ataca.equals(this.visita)) {
                            this.goloF++;
                        } else {
                            this.goloC++;
                        }
                        minutos += rand.nextInt(6);
                    } else {
                        System.out.println("Infelizmente para a equipa " + ataca.getNome() + "a bola foi ao poste.");
                        int proboutroataque = rand.nextInt(ataca.habmedio());
                        if (proboutroataque > ataca.habmedio()-8){
                            minutos += simulaataque(minutos+time, ataca,defende);
                        }
                        else{
                            minutos += simulaataque(minutos+time, defende,ataca);
                        }
                        minutos += rand.nextInt(6);
                    }
                } else {
                    System.out.println("O " + selecionaguardaredes(defende).getNome() + "realizou uma otima defesa!");
                    minutos += rand.nextInt(3);
                }
            } else {
                minutos += rand.nextInt(3);
                System.out.println("Os defesas (" + defende.getNome() + ") recuperam a bola.");
                int bolafora = rand.nextInt(100);
                if (bolafora > 80){
                   minutos += simulabolafora(time+minutos,ataca,defende);
                }
            }
        }

        //caso o lance dê golo
        if (marca){
            System.out.println("Bola ao centro para a equipa " + defende.getNome());
            minutos += 3 + simulaataque(time+minutos,defende,ataca);
        }
        return minutos;
    }

    //Tipo de ataque pela lateral, a tatica usada foi "igual" à simulaataque()
    public int simulacanto(int time, Equipa fazocanto, Equipa defende) throws InterruptedException, ExcecaoPos {

        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }

        if(probabilidadeLateral(fazocanto.hablateral()) > probabilidadeLateral(defende.hablateral())){
            minutos += rand.nextInt(4);
            System.out.println("Os laterais (" + fazocanto.getNome() + ") conseguem passar pelos seus adversarios");
            if(probabilidadeMarcar(fazocanto.habfrente()) > probabilidadeDefender(defende.habdefesa())){
                double cabeceamento=0;

                Jogador cabeceia = selecionaavancado(fazocanto);
                cabeceamento = cabeceia.getCabeca();

                System.out.println("Otimo cruzamento!!!");
                Thread.sleep(100);
                if(rand.nextInt((int)cabeceamento)+(15) < cabeceamento){

                    System.out.println("A equipa " + fazocanto.getNome()+ " marcou!");
                    System.out.println("Fantastico cabeceamento de " + cabeceia.getNome());
                    marca = true;
                    if(fazocanto.equals(this.visita)) {
                        this.goloF++;
                    }
                    else{
                        this.goloC ++;
                    }
                    minutos += rand.nextInt(6);}

                else {System.out.println("A bola foi ao poste infelizmente, bela jogada da equipa " + fazocanto.getNome());
                    minutos += rand.nextInt(6);
                }
            } else {System.out.println("O " + selecionaguardaredes(defende).getNome() + " realizou uma otima defesa!");minutos += rand.nextInt(3); }

        }
        else {
            System.out.println("Bem tirada pelos laterais da equipa " + defende.getNome());
            //minutos += rand.nextInt(3);
            minutos += 0;
            simulacanto(time+minutos, defende,fazocanto);
        }

        if (marca){
            System.out.println("Bola ao centro para a equipa: " + defende.getNome());
            minutos += 3 + simulaataque(time+minutos,defende,fazocanto);
        }
        return minutos;
    }

    //Implementaçao feita para simular bolas fora do campo!
    public int simulabolafora(int time,Equipa ataca,Equipa defende) throws InterruptedException, ExcecaoPos {

        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }
        System.out.println("\nA equipa " + ataca.getNome() + " vai realizar um lancamento lateral");
        if (ataca.hablateral()+ataca.habmedio() > defende.hablateral()+defende.habmedio()){
            System.out.println("Fantastico lancamento da equipa " + ataca.getNome());
            minutos += simulaataque(time+minutos,ataca,defende);

        }
        else{
            minutos += simulaataque(time+minutos, defende, ataca);
        }
        return minutos;
    }

    //Metodo retorna o guarda redes que defende
    public Jogador selecionaguardaredes(Equipa e) throws ExcecaoPos {

        Jogador redes = new Redes();
        for (Jogador j:e.getTitulares()){
            if(j.getPosicao().getposTit().equals(Base.REDES)){
                redes=j;
            }
        }
        return redes;
    }

    //Metodo retorna o avancado que marca
    public Jogador selecionaavancado(Equipa e){
        Random rand = new Random();
        int i = (int) ((e.getTitulares().stream().filter(k->k.getposicaostr().equals(Base.AVANCADO)).count())-1);
        ArrayList<Jogador> avancados = e.getTitulares().stream().filter(k->k.getPosicao().getposTit().equals(Base.AVANCADO)).collect(Collectors.toCollection(ArrayList::new));
        int selecionado = rand.nextInt(i);
        return avancados.get(selecionado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo umJogo = (Jogo) o;
        return goloC == umJogo.goloC && goloF == umJogo.goloF && Objects.equals(data, umJogo.data) && Objects.equals(casa, umJogo.casa) && Objects.equals(visita, umJogo.visita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, casa, visita, goloC, goloF);
    }

    public static Jogo parse(String input, Global a) throws ExcecaoPos {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        ArrayList<Jogador> jc = new ArrayList<>();
        ArrayList<Jogador> jf = new ArrayList<>();
        Map<String,Jogador> sc = new LinkedHashMap<>();
        Map<String,Jogador> sf = new LinkedHashMap<>();
        Equipa casa = a.identificaEquipa(campos[0]);
        Equipa fora = a.identificaEquipa(campos[1]);
        for (int i = 5; i < 16; i++){
            if(!casa.getTitulares().contains( a.identificaJogadorId(campos[i],casa))) {
                jc.add(a.identificaJogadorId(campos[i], casa));
            }
        }
        casa.setTitulares(jc);
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            Jogador entra = a.identificaJogadorId(sub[1],casa);
            sc.put(sub[0],entra.clone());

        }

        for (int i = 19; i < 30; i++){
            if(!fora.getTitulares().contains( a.identificaJogadorId(campos[i],fora))) {
                jf.add(a.identificaJogadorId(campos[i], fora));
            }
        }
        fora.setTitulares(jf);
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            Jogador entra = a.identificaJogadorId(sub[1],fora);
            sf.put(sub[0],entra.clone());;
        }

        return new Jogo(LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),casa,fora,Integer.parseInt(campos[2]),Integer.parseInt(campos[3]),sc,sf);
    }




    private void fazsubstituicoessemprint(int time,ArrayList<Integer>temposubscasa,ArrayList<Integer>temposubsfora) throws ExcecaoPos {
        for(Integer p : temposubscasa) {
            if (time==p){
                if(this.subscasa.size() > 0) {
                    Jogador sai = this.casa.identificaJogadorId(this.subscasa.keySet().stream().findFirst().get());
                    Jogador entra = this.subscasa.get(sai.getId());
                    this.casa.substitui(entra, sai);
                    this.subscasa.remove(sai.getId());
                }
            }
        }

        for(Integer p : temposubsfora){
            if (time==p) {
                if (this.subsfora.size() > 0) {
                    Jogador sai = this.visita.identificaJogadorId(this.subsfora.keySet().stream().findFirst().get());
                    Jogador entra = subsfora.get(sai.getId());
                    this.visita.substitui(entra, sai);
                    this.subsfora.remove(sai.getId());
                }
            }
        }
    }

    //Metodo em que simulamos o jogo!
    //A bola começa na equipa da casa e as habilidades dos medios sao comparadas, caso estas sejam maiores que os da equipa adversaria, entao é feito um ataque
    //Caso contrario, a equipa adversaria faz um ataque
    public void simulajogosemprint() throws ExcecaoPos, InterruptedException {
        Map<String,Jogador> antescasa = getsubsCasa();
        Map<String,Jogador> antesfora = getsubsFora();
        int i = 0;
        ArrayList<Integer> temposubscasa = new ArrayList<>();
        ArrayList<Integer> temposubsfora = new ArrayList<>();

        for (int k=0; k<=(subscasa.size()/2)+1;k++){
            int tempo = rand.nextInt(85);
            if (tempo>5) {
                temposubscasa.add(tempo);
            }
            else tempo=rand.nextInt(85);
        }

        for (int k=0; k<=(subsfora.size()/2)+1;k++) {
            int tempo = rand.nextInt(85);
            if (tempo > 5) {
                temposubsfora.add(tempo);
            }
            else tempo = rand.nextInt(85);
        }

        if(this.casa.getTitulares().size() == 11 && this.visita.getTitulares().size() == 11) {
            for (int time = 0; time <= 45; time++) {
                fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                while (time <= 5) {
                    fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                    time++;
                }

                if (probabilidadeMeio(this.casa.habmedio()) > probabilidadeMeio(this.visita.habmedio())) {
                    i = simulaataquesemprint(time, this.casa, this.visita) + time;

                } else {
                    i = simulaataquesemprint(time, this.visita, this.casa) + time;
                }
                while (time != i && time < 45){
                    fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                    time++;
                }

            }


            for (int time=46; time<=90;time ++){
                fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                //Na primeira parte a bola vai começar na equipa da casa
                while (time <= 49) {
                    fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                    time++;
                }
                if (probabilidadeMeio(this.visita.habmedio()) > probabilidadeMeio(this.casa.habmedio())) {
                    i = simulaataquesemprint(time, this.visita, this.casa) + time;

                } else {
                    i = simulaataquesemprint(time, this.casa, this.visita) + time;


                }
                while (time != i && time < 45) {
                    fazsubstituicoessemprint(time,temposubscasa,temposubsfora);
                    time++;
                }
            }
            this.subsfora = antesfora.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
            this.subscasa = antescasa.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        }
        else throw new ExcecaoPos("Quantidade de jogadores titulares errada");
    }

    //Os ataques podem ser feitos atraves do centro do campo ou atraves dos laterais
    //É retornado um inteiro, sendo este o tempo que o ataque vai demorar!
    //Este inteiro é um random limitado com o tempo que achamos conveniente para cada açao!
    public int simulaataquesemprint (int time, Equipa ataca, Equipa defende) throws InterruptedException {
        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }

        //se a equipa que esta a atacar tiver mais habilidade nos laterais entao ha mais probabilidade de fazer o ataque pelos laterais
        int lat = rand.nextInt(ataca.hablateral());
        int frente = rand.nextInt(ataca.habfrente());

        if (lat-15>frente){
            minutos += simulacantosemprint(time+minutos,ataca,defende);
        }
        else {
            if (probabilidadeMarcar(ataca.habfrente()) > probabilidadeDefender(defende.habdefesa())) {
                minutos += rand.nextInt(4);
                if (probabilidadeMarcar(ataca.habfrente()) > probabilidadeRedes(defende.habredes())) {
                    Jogador remata = selecionaavancado(ataca);
                    double remate = remata.getRemate();
                    if (rand.nextInt((int) remate) < remate - 7) {
                        marca = true;
                        if (ataca.equals(this.visita)) {
                            this.goloF++;
                        } else {
                            this.goloC++;
                        }
                        minutos += rand.nextInt(6);
                    } else {
                        int proboutroataque = rand.nextInt(ataca.habmedio());
                        if (proboutroataque > ataca.habmedio()-8){
                            minutos += simulaataquesemprint(minutos+time, ataca,defende);
                        }
                        else{
                            minutos += simulaataquesemprint(minutos+time, defende,ataca);
                        }
                        minutos += rand.nextInt(6);
                    }
                } else {
                    minutos += rand.nextInt(3);
                }
            } else {
                minutos += rand.nextInt(3);
                int bolafora = rand.nextInt(100);
                if (bolafora > 80){
                    minutos += simulabolaforasemprint(time+minutos,ataca,defende);
                }
            }
        }


        if (marca){
            minutos += 3 + simulaataquesemprint(time+minutos,defende,ataca);
        }
        return minutos;
    }

    //Tipo de ataque pela lateral, a tatica usada foi "igual" à simulaataque()
    public int simulacantosemprint(int time, Equipa fazocanto, Equipa defende) throws InterruptedException {

        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }

        if(probabilidadeLateral(fazocanto.hablateral()) > probabilidadeLateral(defende.hablateral())){
            minutos += rand.nextInt(4);
            if(probabilidadeMarcar(fazocanto.habfrente()) > probabilidadeDefender(defende.habdefesa())){
                double cabeceamento=0;
                Jogador cabeceia = selecionaavancado(fazocanto);
                cabeceamento = cabeceia.getCabeca();
                if(rand.nextInt((int)cabeceamento)+(15) < cabeceamento){
                    marca = true;
                    if(fazocanto.equals(this.visita)) {
                        this.goloF++;
                    }
                    else{
                        this.goloC ++;
                    }
                    minutos += rand.nextInt(6);}

                else {
                    minutos += rand.nextInt(6);
                }
            }
        }
        else {
            minutos += rand.nextInt(3);
            simulacantosemprint(time+minutos, defende,fazocanto);
        }

        if (marca){
            minutos += 3 + simulaataquesemprint(time+minutos,defende,fazocanto);
        }
        return minutos;
    }

    //Implementaçao feita para simular bolas fora do campo! Ainda so implementada para quando o guarda redes manda para fora
    public int simulabolaforasemprint(int time,Equipa ataca,Equipa defende) throws InterruptedException {

        int minutos = 0;
        Random rand = new Random();
        boolean marca = false;

        if (time>45){
            time = time/2;
        }
        if (ataca.hablateral()+ataca.habmedio() > defende.hablateral()+defende.habmedio()){
            minutos += simulaataquesemprint(time+minutos,ataca,defende);

        }
        else{
            minutos += simulaataquesemprint(time+minutos, defende, ataca);
        }
        return minutos;
    }

    public void guardajogo() throws IOException {
        StringBuilder sc = new StringBuilder();
        int i = 0;
        int j = 0;
        for (String s : this.subscasa.keySet()){
            sc.append(s + "->" + this.subscasa.get(s).getId());
            i += 1;
            if(i<this.subscasa.size()) sc.append(",");
        }

        StringBuilder sf = new StringBuilder();
        for (String s : this.subsfora.keySet()){
            sf.append( s + "->" + this.subsfora.get(s).getId());
            j += 1;
            if(j<this.subsfora.size()) sf.append(",");
        }

        StringBuilder jogadorescasa = new StringBuilder();
        for(Jogador k : this.casa.getTitulares()){
            jogadorescasa.append(k.getId());
            jogadorescasa.append(",");
        }

        StringBuilder jogadoresfora = new StringBuilder();
        for(Jogador y : this.visita.getTitulares()){
            jogadoresfora.append(y.getId());
            if (!y.equals(this.visita.getTitulares().get(this.visita.getTitulares().size()-1))) jogadoresfora.append(",");
        }

        BufferedWriter escritor = new BufferedWriter(new FileWriter("\\Users\\paulinhordc\\Desktop\\Projeto\\src\\logsV2.txt",true));
        escritor.write("\nJogo:" + getcasa().getNome() + "," + getVisita().getNome() + "," + getGoloC() + "," + getGoloF() + "," + getData() +"," +
                jogadorescasa + sc + "," + jogadoresfora + "," + sf
        );
        escritor.flush();
        escritor.close();
    }
}