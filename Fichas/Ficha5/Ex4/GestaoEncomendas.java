package Fichas.Ficha5.Ex4;

import Fichas.Ficha5.Ex2.Aluno;
import Fichas.Ficha5.Ex2.TurmaAlunos;

import java.util.*;

public class GestaoEncomendas {

    private Map<Integer,Encomenda> encomendas;

    public GestaoEncomendas(){
        this.encomendas = new HashMap<>();
    }

    public GestaoEncomendas(Map<Integer,Encomenda> nEncomendas){
        this.encomendas = new HashMap<>();

        for(Encomenda a : nEncomendas.values()){
            this.encomendas.put(a.getNEnc(), a.clone());
        }
    }

    public GestaoEncomendas(GestaoEncomendas e){
        this.encomendas = e.getEncomendas();
    }

    public Map<Integer, Encomenda> getEncomendas() {
        Map<Integer, Encomenda> r = new HashMap<>();

        for(Map.Entry<Integer, Encomenda> e : this.encomendas.entrySet()){
            Integer chave = e.getKey();
            Encomenda valor = e.getValue();

            r.put(chave, valor.clone());                // r.put ( e.getKey(), e.getValue().clone());
        }
        return r;
    }

    public void setEncomendas(Map<Integer, Encomenda> e) {
        this.encomendas = new HashMap<>();

        for(Integer k : this.encomendas.keySet()){
            this.encomendas.put(k, e.get(k).clone());
        }
    }

    //OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM CONTER//

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;

        GestaoEncomendas t = (GestaoEncomendas) o;
        return (this.encomendas.equals(t.getEncomendas()));
    }

    @Override
    public String toString() {
        return "GestaoEncomendas{" +
                "getEncomendas=" + getEncomendas() +
                ", encomendas=" + encomendas +
                '}';
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    //OUTROS MÉTODOS//

    //i. método que determina os códigos de encomenda existentes, public Set<Integer> todosCodigosEnc()
    public Set<Integer> todosCodigosEnc(){
        return this.encomendas.keySet();
    }

    //ii. método que adiciona mais uma encomenda ao sistema, public void addEncomenda(Encomenda enc)
    public void addEncomenda(Encomenda enc){
        this.encomendas.put(enc.getNEnc(), enc.clone());
    }

    //iii. método que dado um código de encomenda devolve a informação respectiva, public Encomenda getEncomenda(Integer codEnc)
    public Encomenda getEncomenda(Integer codEnc){
        if(!this.encomendas.containsKey(codEnc)) return null;
        else{
            return this.encomendas.get(codEnc).clone();
        }
    }

    //iv. método que remove uma encomenda dado o seu código, public void removeEncomenda(Integer codEnc)
    public void removeEncomenda(Integer codEnc){
        this.encomendas.remove(codEnc);
    }

    //v. método que determina a encomenda (identificada pelo código) com mais produtos encomendados, public Integer encomendaComMaisProdutos()
    public Integer encomendaComMaisProdutos() {
            Comparator<Encomenda> c = (a1, a2) -> a2.numeroTotalProdutos() - a1.numeroTotalProdutos();

            TreeSet<Encomenda> t = new TreeSet<>(c);

            for(Encomenda e : this.encomendas.values()) {
                t.add(e); //Nao precisamos de clone porque vamos devolver apenas um inteiro
            }

            Encomenda r = t.first();

            return r.getNEnc();

            // Usando streams
            //return this.encomendas.values().stream().sorted(c).map(e -> e.getNEnc()).findFirst().orElse(-1);

    }

    public Integer encomendaComMaisProdutos2() {
        Comparator<Encomenda> c = (a1,a2) -> a2.numeroTotalProdutos() - a1.numeroTotalProdutos();

        TreeSet<Encomenda> t = new TreeSet<>(c);

        for(Encomenda e : this.encomendas.values()) {
            t.add(e); //Nao precisamos de clone porque vamos devolver apenas um inteiro
        }

        Encomenda r = t.first();

        return r.getNEnc();

        // Usando streams
        //return this.encomendas.values().stream().sorted(c).map(e -> e.getNEnc()).findFirst().orElse(-1);

    }

    //vi. método que determina todas as encomendas em que um determinado produto, identificado pelo código, está presente, public Set<Integer> encomendasComProduto(String codProd)
    public Set<Integer> encomendasComProduto(String codProd){

        return new TreeSet<>();
    }


    /*

        vii. método que determina todas as encomendas com data posterior
        a uma data fornecida como parâmetro, public
        Set<Intteger> encomendasAposData(LocalDate d)
        viii. método que devolve uma ordenação, por ordem decrescente
        de valor de encomenda, de todas as encomendas do sistema,
        public Set<Encomenda> encomendasValorDecrescente()
        ix. método que calcula um map em que associa cada código de
        produto à lista das encomendas em que foi referida, public
        Map<String,List<Integer>> encomendasDeProduto()
     */
}
