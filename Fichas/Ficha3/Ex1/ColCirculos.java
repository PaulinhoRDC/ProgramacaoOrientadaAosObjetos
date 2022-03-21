package Fichas.Ficha3.Ex1;

import java.util.ArrayList;
import java.util.List;

public class ColCirculos {

    private List<Circulo2> circulos;

    public ColCirculos(){
        circulos = new ArrayList<>();
    }

    public ColCirculos(List<Circulo2> circulos){
        this.circulos =new ArrayList<>(circulos.size());

        for(Circulo2 c : circulos){
            this.circulos.add(c.clone());
        }
    }

    public ColCirculos (ColCirculos c){
        this.circulos = c.getCirculos();
    }

    public List<Circulo2> getCirculos(){
        List<Circulo2> res = new ArrayList<>();
        for(Circulo2 c: this.circulos){
            res.add(c.clone());
        }
        return res;
    }

    public void setCirculos(List<Circulo2> circulos){
        this.circulos = new ArrayList<>();
        for(int i=0; i<circulos.size(); i++){
            Circulo2 c = circulos.get(i);
            this.circulos.add(c.clone());
        }
    }

    public int numeroCirculos(){
        return this.circulos.size();
    }

    public boolean existeCirculo(Circulo2 c){
        return this.circulos.contains(c);
    }

    public boolean addCirculo(Circulo2 c){
        return this.circulos.add(c.clone());
    }

    public boolean removeCirculo(Circulo2 c){
        return this.circulos.remove(c);
    }


    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if( o == null || this.getClass() != o.getClass()){
            return false;
        }

        ColCirculos cc = (ColCirculos) o;
        return this.circulos.equals(cc.getCirculos());

        //  return this.raio == c.getRaio() && c.getCentro().equals(this.centro);
    }

    public String toString(){
        return "ColCirculos" + "circulos= " + this.circulos + "}";
    }
    // ou toStrung com o StringBuilder e ir fazendo append

    public ColCirculos clone(){
        return new ColCirculos(this);
    }


}
