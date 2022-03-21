package Fichas.Ficha3.Ex2;

public class TesteTelemovel {

    public static void main (String [] args) {

        Telemovel t = new Telemovel();
        System.out.println(t.toString());

        // a)
        boolean b1 = t.existeEspaco((byte) 1);
        System.out.println("a) " + b1);

        // b)
        t.instalaApp("Instagram", (byte) 9);
        t.instalaApp("Twitter", (byte) 3);
        t.instalaApp("Tinder", (byte) 15);
        t.instalaApp("Chess.com", (byte) 3);

        System.out.println(t.toString());

        // c)
        t.recebeMsg("Hey.", (byte) 0.3);
        t.recebeMsg("Amanhã é para sair?", (byte) 1);
        t.recebeMsg("Sim, vamos onde?", (byte) 0.9);
        System.out.println(t.toString());

        // d)
        double d = t.tamMedioApps();
        System.out.println("d) " + d);

        // e)
        String s1 = t.maiorMsg();
        System.out.println("e) " + s1);

        // f)
        t.removeApp("Instagram", 9);
        System.out.println(t.toString());
    }
}

