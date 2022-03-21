package Fichas.Ficha3.Ex6;



public class TesteStand {

    //mandar para stand
    //maximo de 4
    //depois implementar growing array
    public static void main (String [] args){


        //alguns carros
        Carro audi = new Carro("Audi", "A4", 1998, 0.05, 140000.0, 0.052, 224.5, 0.046, 0.01, false);
        Carro jaguar = new Carro("Jaguar", "F-TYPE", 2015, 0.09, (double) 20000, 0.086, (double) 100, 0.094, 0.02, false);
        Carro fiat = new Carro("Fiat", "500", 1995, 0.045, 200000.0, 0.046, 300.0, 0.06, 0.005, false);
        Carro toyota = new Carro("Toyota", "Yatis", 2010, 0.05, 65000.0, 0.055, 120.3, 0.046, 0.01, false);
        Carro tesla = new Carro("Tesla", "Model 3", 2018, 0.00, 10000.0, 0.00, 400.0, 0.00, 0.00, false);
        Carro audi2 = new Carro(audi); //testar equals
        Carro ups = new Carro ();



        //testar classe carro e stand
/*
        System.out.println(audi.getMarca() + audi.getModelo());
        System.out.println(jaguar);
        System.out.println(audi.equals(audi2));
        audi2.setAno(2000);
        System.out.println(audi2.getAno());
        System.out.println(audi.equals(audi2));

        System.out.println(fiat);
        fiat.setEstado(true);
        fiat.avancaCarro(200, 20);
        System.out.println(fiat);
        fiat.avancaCarro(2500, 50);
        System.out.println(fiat);
        fiat.travaCarro(1000);
        System.out.println(fiat + "\n");
 */
        Carro [] cars = new Carro[4];
        cars[0] = audi;
        cars[1] = audi2;
        cars[2] = jaguar;
        cars[3] = tesla;
 /*
        Stand ribeiro = new Stand(cars,4);
        System.out.print("RIBEIRO = " + ribeiro);
        Stand rocha = new Stand(ribeiro);
        cars[2] = fiat;
        rocha.setCarros(cars);
        System.out.println("\n\n" + "ROCHA = " + rocha + "\n\n" + "RIBEIRO = " + ribeiro + "\n\n" + rocha.equals(ribeiro));
        ribeiro = rocha.clone();
        System.out.println("\n\n" + "ROCHA = " + rocha + "\n\n" + "RIBEIRO = " + ribeiro + "\n\n" + rocha.equals(ribeiro));
*/

        Stand ribeiro = new Stand();
        ribeiro.carrosArr.add(fiat);
        System.out.print("\nRIBEIRO = " + ribeiro);
        ribeiro.carrosArr.add(0, audi);
        System.out.print("\nRIBEIRO = " + ribeiro);
        System.out.println("\n" + ribeiro.carrosArr.contains(audi));
        ribeiro.carrosArr.remove(audi);
        System.out.print("\nRIBEIRO = " + ribeiro);
        ribeiro.carrosArr.remove(0);
        System.out.print("\nRIBEIRO = " + ribeiro);
        ribeiro.carrosArr.add(ups);
        System.out.print("\nRIBEIRO = " + ribeiro);

    }


}
