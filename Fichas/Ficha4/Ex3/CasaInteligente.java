package Fichas.Ficha4.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CasaInteligente {

    private ArrayList<Lampada> lamps;

    public CasaInteligente() {
        this.lamps = new ArrayList<>();
    }

    public CasaInteligente(List<Lampada> lamps) {
        setLamps(lamps);
    }

    public List<Lampada> getLamps() {
        return this.lamps.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public void setLamps(List<Lampada> lamps) {
        this.lamps = new ArrayList<>();
        for(Lampada l: lamps){
            this.lamps.add(l.clone());
        }
    }

    //OUTROS MÉTODOS//

    //i. public void addLampada(Lampada l), que adiciona mais uma lâmpada à casa

    public void addLampada(Lampada l){
        this.lamps.add(l.clone());
    }

    //ii. public void ligaLampadaNormal(int index), que liga no modo de consumo máximo a lâmpada que está na posição indicada

    public void ligaLampadaNormal(int index){
        this.lamps.get(index).lampON();
    }

    //iii. public void ligaLampadaEco(int index), que liga no modo de consumo económico a lâmpada que está na posição indicada

    public void ligaLampadaEco(int index){
        this.lamps.get(index).lampECO();
    }

    //iv. public int qtEmEco(), que determina quantas lâmpadas é que estão ligadas em modo económico.

    public int qtEmEco(){
        return (int) this.lamps.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).count();
    }

    /*


v. public void removeLampada(int index), que remove a
lâmpada da posição passada como parâmetro
vi. public void ligaTodasEco() e public void
ligaTodasMax(), que liga todas as lâmpadas da casa
respectivamente em modo Eco e em modo de consumo máximo
vii. public double consumoTotal(), que determina o consumo
total da casa
viii. public Lampada maisGastadora(), que determina a lâmpada
que mais consumiu até à data
ix. public Set<Lampada> podiumEconomia(), que devolve as
três lâmpadas mais económicas da casa
x. public void reset(), que efectua o

     */
}
