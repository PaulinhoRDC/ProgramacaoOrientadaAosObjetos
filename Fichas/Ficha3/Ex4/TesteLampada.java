package Fichas.Ficha3.Ex4;

public class TesteLampada {

    public static void testaLampada () {
        Lampada l = new Lampada();
        l.lampON();
        System.out.println("Lâmpada ligada");
        System.out.println("Estado da lâmpada: " + l.getEstadoOn() + "\n");

        double consumo = l.totalConsumo();
        System.out.println("Consumo ate agora: " + consumo );
        l.lampOFF();
        System.out.println("Estado da lâmpada: " + l.getEstadoOn() );
        double total = l.periodoConsumo();
        double consumo2 = l.totalConsumo();
        System.out.println("Gasto no total: " + total);
        System.out.println("Consumo 2 ate agora: " + consumo2 +"\n");

        Lampada l2 = l.clone();
        l2.lampOFF();
        System.out.println("Estado da lâmpada 2: " + l.getEstadoOn());
        double total2 = l2.periodoConsumo();
        System.out.println("Gasto no total: " + total2 +"\n");

        String lamp = l.toString();
        String lamp2 = l2.toString();
        System.out.println(lamp);
        System.out.println(lamp2);
    }

    public static void main(String[] args) {
        testaLampada();
    }

}
