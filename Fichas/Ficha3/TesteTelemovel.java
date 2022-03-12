package Fichas.Ficha3;

public class TesteTelemovel {

    public static void main(String[] args) {
        Telemovel t1 = new Telemovel("Iphone", "12 Pro", 2532,1170," ",100,100,20,0,0," ");
        System.out.println("--- Tele novo info: ---");
        System.out.println(t1.toString());
        System.out.println();

        t1.instalaApp("Tiktok",10);
        t1.instalaApp("Insta",10);
        t1.instalaApp("Youtube",10);
        t1.recebeMsg("Ola tudo bem?");
        t1.recebeMsg("DINIS É GAY");
        System.out.println(t1.toString());

        double res = t1.tamMedioApps();
        System.out.println(res);

        String mairmsg = t1.maiorMsg();
        System.out.println("Maior msg é: " + mairmsg);

        t1.removeApp("Youtube",10);
        System.out.println(t1.toString());
    }
}

