package Fichas.DriveIT_ResoluçãoProf;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.*;

public class DriveIt {
    private String nome;
    private Map<String, Veiculo> viaturas;

    public DriveIt() {
        this.nome = "";
        this.viaturas = new HashMap();
    }

    public DriveIt(String nome, Map<String, Veiculo> viaturas) {
        this.nome = nome;
        this.viaturas = viaturas.entrySet()
                                .stream()
                                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    public DriveIt(DriveIt o){
        this(o.getNome(), o.getViaturas());
    }

    public DriveIt(String nome) {
        this.nome = nome;
        this.viaturas = new HashMap();
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Veiculo> getViaturas() {
        return viaturas.entrySet()
                       .stream()
                       .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    public void setViaturas(Map<String, Veiculo> viaturas) {
        this.viaturas = viaturas.values()
                                .stream()
                                .collect(Collectors.toMap(Veiculo::getMatricula, Veiculo::clone));
    }


    @Override
    public String toString() {
        return "DriveIt{" +
                "nome='" + nome + "\n" +
                ", viaturas=" + viaturas +
                "}";
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        DriveIt d = (DriveIt) o;
        return this.nome.equals(d.getNome()) && this.viaturas.equals(d.getViaturas());
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

    /**
     * (a)
     */
    public boolean existeVeiculo(String cod){
        return viaturas.containsKey(cod);
    }

    /**
     * (b)
     */
    public int quantos(){
        return viaturas.size();
    }

    /**
     * (c)
     */
    public int quantos(String marca){
        return (int) viaturas.values().stream().filter(v->v.getMarca().equals(marca)).count();
    }

    /**
     * (d)
     */
    public Veiculo getVeiculo(String cod){
        return viaturas.get(cod).clone();
    }

    /**
     * (e)
     */
    public void adiciona(Veiculo v){
        viaturas.putIfAbsent(v.getMatricula(), v.clone());
    }

    /**
     * (f)
     */
    public List<Veiculo> getVeiculos(){
        return viaturas.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }

    /**
     * (g)
     */
    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v: vs) {
            this.adiciona(v);
        }
    }

    /**
     * (h)
     */
    public void registarAluguer(String codVeiculo, int numKms){
        if(viaturas.containsKey(codVeiculo)){
            viaturas.get(codVeiculo).addViagem(numKms);
        }

    }

    /**
     * (i)
     */
    public void classificarVeiculo(String cod, int classificacao){
        if(viaturas.containsKey(cod)){
            viaturas.get(cod).addClassificacao(classificacao);
        }
    }
    
    /**
     * (j)
     */
    public  int custoRealKm(String cod) {
        int custo = 0;
        if(viaturas.containsKey(cod)) {
           custo = (int)viaturas.get(cod).custoRealKM();
        }
        return custo;
    }


    public Veiculo veiculoMaisBarato(){
        //Comparator<Veiculo> cv = (v1, v2)->(v1.custoRealKM()!=v2.custoRealKM())? (int)(v1.custoRealKM()-v2.custoRealKM()):v1.getMatricula().compareTo(v2.getMatricula());
        return  this.viaturas.values().stream().map(Veiculo::clone)
                .sorted((v1, v2)->(v1.custoRealKM()!=v2.custoRealKM())? (int)(v1.custoRealKM()-v2.custoRealKM()):v1.getMatricula().compareTo(v2.getMatricula()))
                .findFirst().get().clone();
    }

    public Veiculo veiculoMenosUtilizado(){
        Comparator<Veiculo> cv = (v1, v2) -> (v1.getKms()!=v2.getKms())? (int)(v1.getKms()-v2.getKms()):v1.getMatricula().compareTo(v2.getMatricula());
        return this.viaturas.values().stream().map(v-> v.clone()).sorted(cv).findFirst().get().clone();
    }

    //public void adiciona(Set<Veiculo> vs){
    //    vs.stream().forEach(v-> viaturas.putIfAbsent(v.getMatricula(), v.clone()));
    //}

  
}
