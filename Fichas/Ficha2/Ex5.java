package Fichas.Ficha2;

import java.util.Arrays;

public class Ex5 {

    //(a)
    public String [] semRep (String [] array) {

        int tam = array.length;
        String[] aux = new String [tam];

        for (int i = 0; i < tam; i++) {
            for (int j = i+1; j < tam; j++) {
                if (array[i].equals(array[j])) {
                    for (int k = j; k < tam-1; k++) {
                        array[k] = array[k+1];
                    }
                    tam--;
                }
            }
        }
        for (int i = 0; i < tam; i++) {
            aux[i] = array[i];
        }                                                       // PORQUE APARECE UM NULL????

        return aux;
    }

    //(b)
    public String maiorStr (String[] a){
        int max=-1, ind=0;

        for(int i=0;i<a.length;i++){
            if (a[i].length()>max){
                max= a[i].length();
                ind= i;
            }
        }
        return a[ind];
    }

    //(c)
    public String [] stringsReps (String [] a) {

        String [] aux = new String [a.length];
        int res = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i].equals(a[j])) {
                    Boolean presente = false;
                    //Verifica se o elemento repetido ja foi ou nao inserido no array aux.
                    for (String elem : aux) {
                        if (a[i].equals(elem)) {
                            presente = true;
                        }
                    }
                    if (!presente) {                    // BUG //
                        aux[res] = a[i];
                        res++;
                    }
                }
            }
        }
        //Coloca o array final dentro de um array com o tamanho correto
        //Desta forma nao temos um array com tamanho 50 para apenas conter 10 elementos.
        String [] reps = new String[res];
        System.arraycopy(aux, 0, reps, 0, res);
        return reps;
    }

    public int quantasReps (String [] a, String string) {
        int res = 0;
        for (String elem : a) {
            if (string.equals(elem))
                res++;
        }
        return res;
    }
}
