package Fichas.Ficha5.Ex5;

/*
5. Pretende-se criar uma classe para representar grafos dirigidos. Para tal,
foi decidido utilizar uma lista de adjacência que associa, a cada vértice, os
vértices que podem ser visitados a partir dele. Foi já definida a seguinte
estrutura base:
                            import java . util .Set;
                            import java . util .Map;
                            import java . util . HashMap ;

                            public class Grafo {
                            // variáveis de instância
                            private Map < Integer , Set < Integer >> adj ; // " lista " de adjacência
                            }
*/

import java.util.*;
import java.util.stream.Collectors;

public class Grafo {

    private Map<Integer, Set<Integer>> adj;

    //CONSTRUTORES//
    // i) Os construtores Grafo() e Grafo(Map<Integer, Set<Integer>> adj).
    public Grafo() {
        this.adj = new HashMap<>();
    }

    public Grafo(Map<Integer, Set<Integer>> adj) {
        this.adj = adj.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> new HashSet<>(e.getValue())));
    }

    //ii. void addArco(Integer vOrig, Integer vDest) – método que adiciona um arco ao grafo.
    //Note que todos os vértices do grafo devem ter uma entrada na lista de adjacência; que eventualmente poderá ser vazia.
    void addArco(Integer vOrig, Integer vDest){
        this.adj.putIfAbsent(vOrig, new HashSet<>());
        this.adj.putIfAbsent(vDest, new HashSet<>());
        this.adj.get(vOrig).add(vDest);
    }

    //iii. boolean isSink(Integer v) –> método que determina se um vértice é um sink
    //(não existem arcos a sair dele, ou seja, está-lhe associado um conjunto vazio de vértices na “lista” de adjacência).

    public boolean isSink(Integer v) {
        return this.adj.containsKey(v) && this.adj.get(v).isEmpty();
    }

    //iv. boolean isSource(Integer v) –> método que determina se um vértice é um source (não existem arcos a entrar nele).
    public boolean isSource(Integer v) {
        return this.adj.containsKey(v) && !this.adj.values().stream().anyMatch(e -> e.contains(v));
    }

    //v. int size() –> método que calcula o tamanho do grafo (o tamanho de um grafo com n vértices e m arcos é n + m).
    public int size() {
        return this.adj.size() + this.adj.values().stream().mapToInt(Set::size).sum();
    }

    //vi. boolean haCaminho(Integer vOrig, Integer vDest) –> método que determina se existe um caminho entre os dois vértices passados como parâmetro.
    //Tenha em consideração que poderão existir ciclos no grafo.
    public boolean haCaminho(Integer orig, Integer dest) {
        return this.adj.containsKey(orig)
                && (orig.equals(dest) || this.adj.get(orig).stream().anyMatch(e -> haCaminho(e, dest)));
    }

    //vii. List<String> getCaminho(Integer vOrig, Integer vDest) –> método que calcula o caminho entre dois vértices.
    //O método deverá devolver null caso não exista caminho.
    public List<Integer> getCaminho(Integer vOrig, Integer vDest) {
        if(!this.adj.containsKey(vOrig)) return null;
        if(vOrig.equals(vDest)) {
            List<Integer> l = new ArrayList<>();
            l.add(vOrig);
            return l;
        }
        for(Integer n : this.adj.get(vOrig)) {
            if(haCaminho(n, vDest)) {
                List<Integer> l = getCaminho(n, vDest);
                l.add(0, vOrig);
                return l;
            }
        }
        return null;
    }

    //viii. Set<Map.Entry<Integer, Integer>> fanOut (IntegeR v) –> método que calcula o conjunto de todos os arcos que saem de um vértice.
    public Set<Map.Entry<Integer, Integer>> fanOut(Integer v) {
        return this.adj.get(v).stream().map(e -> new AbstractMap.SimpleEntry<>(v, e)).collect(Collectors.toSet());
    }

    //ix. Set<Map.Entry<Integer, Integer>> fanIn(Integer v) –> método que calcula o conjunto de todos os arcos que entram num vértice.
    public Set<Map.Entry<Integer, Integer>> fanIn(Integer vDest) {
        return this.adj.entrySet().stream().filter(e -> e.getValue().contains(vDest)).map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), vDest)).collect(Collectors.toSet());
    }

    //x. boolean subGrafo(Grafo g) –> método que determina se o grafo é subgrafo de g (todos os seus vértices e arcos são vértices/arcos de g).
    public boolean subGrafo(Grafo g) {
        return g.adj.keySet().containsAll(this.adj.keySet()) && g.adj.entrySet().stream()
                .allMatch(e -> !this.adj.containsKey(e.getKey()) || e.getValue().containsAll(this.adj.get(e.getKey())));
    }

}
