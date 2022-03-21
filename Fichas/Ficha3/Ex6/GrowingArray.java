package Fichas.Ficha3.Ex6;

import java.util.Arrays;

public class GrowingArray {

    private Carro [] carros;
    private int size;
    private static int inicialSize = 4;



    public GrowingArray clone (){
        GrowingArray ret = new GrowingArray(this.carros.length);
        for (int i = 0; i < this.size(); i++){
            ret.add(carros[i]);
        }
        return ret;
    }


    public boolean equals (GrowingArray o){
        if (o == this)
            return true;
        if (!(o instanceof GrowingArray))
            return false;

        int i = 0;
        for (i = 0; i < this.size; i++){
            if (!(this.carros[i].equals(o.carros[i])))
                return false;
        }

        return true;
    }

    public String toString(){
        String out = "";
        int i = 0;
        for (i = 0; i < this.size; i++){
            out = out + "\n" + carros[i];
        }
        return "{   carros = " + out + "\npos = " + this.size + "    }";
    }


    public GrowingArray (int capacidade){
        carros = new Carro[capacidade];
        size = 0;
    }

    public GrowingArray (){
        this(inicialSize);
    }


    public Carro get (int indice){
        if (indice <= size)
            return carros[indice].clone();
        else return null;
    }

    private void aumentaArr (){
        if ((size) >= carros.length){
            int novaCapacidade = carros.length * 2;
            carros = Arrays.copyOf(carros, novaCapacidade);
        }

    }

    public void add(Carro c){
        aumentaArr();
        carros[size] = c.clone();
        size ++;
    }


    public void add(int indice, Carro c){
        if (indice <= size){
            aumentaArr();
            System.arraycopy(this.carros, indice, this.carros, indice+1, this.size-indice);
            this.carros[indice] = c.clone();
            this.size++;
        }

    }

    public void set(int indice, Carro c){
        if (indice <= size){
            this.carros[indice] = c.clone();
        }
    }

    public Carro remove(int indice){
        if (indice <= size){
            Carro c = this.carros[indice];

            int deslocamento = this.size - indice - 1;
            if(deslocamento > 0)
                System.arraycopy(this.carros, indice+1, this.carros, indice, deslocamento);
            this.size --;
            this.carros[this.size] = null;
            return c.clone();
        }
        return null;
    }


    public boolean remove(Carro c){
        if (c!= null){
            boolean encontrado = false;
            for (int i = 0; i < this.size && !encontrado; i++)
                if(c.equals(this.carros[i])){
                    encontrado = true;
                    remove(i);
                }
            return encontrado;
        }
        else
            return false;
    }

    public int size(){
        return this.size;
    }

    public int indexOf(Carro c){
        int pos = -1;
        if (c != null){
            boolean encontrado = false;
            for (int i = 0; i < this.size && !encontrado; i++)
                if (c.equals(this.carros[i])) {
                    encontrado = true;
                    pos = i;
                }
        }
        return pos;
    }

    public boolean contains(Carro c){
        return indexOf(c) >= 0;
    }

    public boolean isEmpty () {
        return this.size == 0;
    }




}





