package Fichas.Ficha6;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Fitness {

    //COMPARATOR//

    private static final Map<String, Comparator<Utilizador>> comparadores = new HashMap<>();

    public static Comparator<Utilizador> getComparador(String criterio) {
        return comparadores.get(criterio);
    }

    public static void addComparador(String criterio, Comparator<Utilizador> comparador) {
        comparadores.put(criterio, comparador);
    }

    /////////////

    private Map<String, Utilizador> utilizadores;

    // CONSTRUTORES //
    public Fitness(){
        this.utilizadores = new TreeMap<>();
    }

    public Fitness(Map<String, Utilizador> nUtilizadores){
        this.utilizadores = new TreeMap<>();

        for(Utilizador a:nUtilizadores.values())
        {
            this.utilizadores.put(a.getEmail(),a.clone());
        }
    }

    public Fitness(Fitness u){
        this.utilizadores = u.getUtilizadores();
    }


    // GETTER'S & SETTER'S //

    public Map<String, Utilizador> getUtilizadores() {
        return new TreeMap<>(this.utilizadores);
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new TreeMap<>(this.utilizadores);
    }

    // MÉTODOS FASE 1 //

    // (a) Verificar a existência de um utilizador, dado o seu código.
    public boolean existeUtilizador(String email){
        return this.utilizadores.containsKey(email);
    }

    //(b) Devolver a quantidade de utilizadores existentes na aplicação de fitenss
    public int quantos(){
        return (int) this.utilizadores.values().stream().count();
    }

    public int quantos2() { return this.utilizadores.size(); }

    //(c) Devolver o número total de actividades desportivas, de um dado tipo, efectuadas por um utilizador.
    public int quantos(String actividade, String email) throws UserNotExistException{
        if (!utilizadores.containsKey(email)){
            throw new UserNotExistException("User " + email + " não existe.");
        }

        return (int) this.utilizadores.get(email).getAtividades().size();
    }

    //(d) Devolver a informação de um utilizador, dado o seu código.
    public Utilizador getUtilizador(String email) throws UserNotExistException {
        if (!utilizadores.containsKey(email)){
            throw new UserNotExistException("User " + email + " não existe.");
        }

        return this.utilizadores.get(email).clone();
    }

    //(e) Adicionar uma actividade ao registo de um utilizador.
    public void adiciona(String email, Atividade act){
        this.utilizadores.get(email).getAtividades().add(act);
    }

    //(f) Devolver uma lista contendo a cópia de todos as actividades existentes na aplicação.
    public List<Atividade> getAllActividades(){
        List<Atividade> res = new ArrayList<>();

        this.utilizadores.values().stream().map(Utilizador::getAtividades).forEach(x -> res.addAll(x));

        return res;
    }

    //(g) Adicionar a informação de um conjunto de actividades de um utilizador
    // e que foram feitas numa outra aplicação e que passam agora a fazer parte do Fitness.
      public void adiciona(String email, Set<Atividade> activs){
        Utilizador u = this.utilizadores.get(email);
        activs.forEach(a-> u.adicionaAtividade(a));
      }

    //(h) Indicar o número total de minutos que foram dispendidos por um utilizador em actividades de fitness
    public int tempoTotalUtilizador(String email){
        return this.utilizadores.get(email).getAtividades().stream().mapToInt(Atividade::getTempo).sum();
    }

    //(i) Devolver a actividade com maior dispêndio de calorias
//    public Atividade actividadeMaisExigente(){
//
//
//    }

    //(j) Obter o utilizador com maior dispêndio de calorias
//    public Utilizador utilizadorMaisActivo(){
//
//    }

    //(k) Actualizar, para todos os utilizadores, a informação relativa ao seu desporto favorito,
    //fazendo com que seja verdade que este é o desporto em que registam mais actividades.
//    public void actualizaDesportoFav(){
//
//    }


    // MÉTODOS FASE 2 //

    // (a) Obter um Set<Utilizador>, ordenado de acordo com a ordem natural dos utilizadores
    //(assuma que a ordem natural dos utilizadores é em primeiro lugar a ordem crescente do seu consumo de calorias e que o segundo factor de comparação é ordem alfabética do nome)

    /*
    public Set<Utilizador> ordenarUtilizadores(){
        // >0 se a1 > a2
        // ==0 se a1 = a2
        // <0 se a1 > a2
        Comparator<Utilizador> c = Comparator.comparing(Utilizador::getNome);

        TreeSet<Utilizador> t = new TreeSet<>(c);

        for(Utilizador a: this.utilizadores.values())
        {
            t.add(a.clone());
        }
        return t;
    }
     */

    public Set<Utilizador> ordenarUtilizadoresSet() {
        return this.utilizadores.values().stream()
                .map(Utilizador::clone)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    //(b) Faça o mesmo que na alínea anterior, mas agora para a assinatura:

    public List<Utilizador> ordenarUtilizadoresList() {
        return this.utilizadores.values().stream()
                .sorted()
                .map(Utilizador::clone)
                .collect(Collectors.toList());
    }

    // (c) Obter um Set<Utilizador>, ordenado de acordo com o comparador fornecido:

    public Set<Utilizador> ordenarUtilizadores(Comparator<Utilizador> c) {
        return this.utilizadores.values().stream()
                .sorted(c)
                .map(Utilizador::clone)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    //(e) Obter um iterador de Utilizador, ordenado de acordo com o critério indicado:

    public Iterator<Utilizador> ordenarUtilizador(String criterio) {
        Comparator<Utilizador> comparator = comparadores.get(criterio);
        if(comparator == null) return null;
        return this.utilizadores.values().stream()
                .sorted(comparator)
                .iterator();
    }

    //(f) Obter um Map em que se associa a cada actividade os seus top 3
    //utilizadores com mais dispêndio de calorias nesta atividade, ordenados
    //de forma decrescente por calorias.
    //A chave do Map será o nome da classe da actividade.
    //public Map<String, List<Utilizador>> podiumPorActiv()



    // MÉTODOS FASE 3 //

    //3. Acrescente, na classe Fitness, um método para obter a lista das actividades
    //efectuadas e que atribuem pontos.
    public List<FazMetros> daoPontos(){
        return getAllActividades()
                .stream()
                .filter(a -> a instanceof FazMetros)
                .map(a -> (FazMetros) a)
                .collect(Collectors.toList());    }


    // MÉTODOS FASE 4 //
    // Deverá ser possível exportar toda a informação relativa a utilizadores e actividades,
    //representada em memória pela classe Fitness. Implemente assim as
    //seguintes funcionalidades:
    //  1. Exportar a informação de todas as actividades de um utilizador para um ficheiro CSV
    //  2. Gravar e carregar a instância de Fitness num (e de um) ficheiro de objectos.

    public void grava2(String filename) throws FileNotFoundException, IOException{
        ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(filename));

        os.writeObject(this);
    }

    public void grava(String filename) {        // outra maneira //
        try {
            ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(filename));
            os.writeObject(this);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Fitness carrega (String filename){        // método de classe , NÃO PODE MANIPULAR VARIÁVEIS DE INSTÂNCIA
        Fitness f = null;
        ObjectInputStream is = null;

        try{
            is = new ObjectInputStream(new FileInputStream(filename));
            f = (Fitness) is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            f = new Fitness();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            f = new Fitness();
        }

        return f;
    }





    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fitness fitness = (Fitness) o;
        return Objects.equals(utilizadores, fitness.utilizadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilizadores);
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "utilizadores=" + utilizadores +
                '}';
    }

    public Fitness clone()
    {
        return  new Fitness(this);
    }

}


