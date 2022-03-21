package Fichas.Ficha3.Ex6;

import java.util.ArrayList;



public class Stand {

    public GrowingArray carrosArr;



    // construtores

    public Stand() {
        this.carrosArr = new GrowingArray();
    }

    public Stand(Stand s) {
        for (int i = 0; i < s.carrosArr.size(); i++){
            this.carrosArr.add(s.carrosArr.get(i));
        }
    }

    public Stand(Carro[] carros) {
        for (int i = 0; i < carros.length; i++) {
            this.carrosArr.add(carros[i]);
        }
    }

    // set e get
    public Carro[] getCarros() {
        Carro [] ret = new Carro[this.carrosArr.size()];
        for (int i = 0; i < this.carrosArr.size(); i++){
            ret[i] = this.carrosArr.get(i);
        }
        return ret;
    }

    public void setCarros(Carro[] carros) {
        ArrayList<Carro> novo = new ArrayList<Carro>(carros.length);
        for (int i = 0; i < carros.length; i++) {
            novo.add(carros[i]);
        }
    }

    public int getSize() {
        return this.carrosArr.size();
    }



    // equals
    public boolean equals(Stand o) {
        if (o == this)
            return true;
        if (!(o instanceof Stand)) {
            return false;
        }


        if (!(this.carrosArr.equals(o.carrosArr)))
            return false;

        return true;
    }

    // to string
    public String toString() {
        return this.carrosArr.toString();
    }

    // clone
    public Stand clone() {
        return new Stand(this);
    }

}
