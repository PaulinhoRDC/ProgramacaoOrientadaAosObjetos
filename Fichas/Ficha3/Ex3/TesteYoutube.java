package Fichas.Ficha3.Ex3;

public class TesteYoutube {

    public static void main (String [] args) {
        Youtube y = new Youtube();
        System.out.println(y.toString());

        // a)
        y.insertComment("Bom tutorial.");
        y.insertComment("Podia ter falado mais.");
        y.insertComment("Não percebi a última parte.");
        System.out.println(y.toString());

        // b)
        // long dias = y.daysAfter();
        // System.out.println("b) " + dias);
    }

}
