package Fichas.Ficha2;

public class Ex1 {

    // (a) ler inteiros para um array e depois determinar o valor mínimo desse array.

    public int minimo(int[] a){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i<a.length; i++) {
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    // (b) ler um array de inteiros e dois índices e determinar o array com os valores entre esses índices.

    public int[] posicoesEntre (int[] a, int i1, int i2){
        if ( i1 > 0 && i1 < a.length && i2 > 0 && i2 < a.length && i1<i2){

            int[] res = new int[i2-i1+1];
            System.arraycopy(a,i1,res,0,i2-i1+1);
            return res;
        }
        else{
            return null;
        }
    }

    // (c) ler dois arrays de inteiros e determinar o array com os elementos comuns aos dois arrays.

    public int[] comunsEntre (int[] a, int[]b){

        int[] c= new int[Math.max(a.length, b.length)]; //new int[a.length];
        int pos=0, pos2=0;

        for (int f=0; f<a.length;f++){
            for (int i : b) {
                if (a[f] == i) {
                    c[pos] = a[f];
                    pos++;
                    break;
                }
            }
        }
        return c;
    }

}
