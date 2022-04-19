package Fichas.Ficha5.Ex1;

import java.util.List;

public class main_1 {

        public static void main (String [] args) {

            Parque p = new Parque();
            Lugar l1 = new Lugar("62-BP-86", "Paulo Costa", 30, true);
            Lugar l2 = new Lugar( "AC-66-RI", "Maria Teixeira", 10, false);
            Lugar l3 = new Lugar("24-VX-64", "Rui", 35, true);

            System.out.println("ToString de parque vazio: " + p.toString());

            /********************* Test Facilities *********************/

            //ii
            p.setNome("Parque Estacionamento de Braga");
            p.newOccupation(l1);
            p.newOccupation(l2);
            p.newOccupation(l3);

            System.out.println("\nii. " + p.toString());

            //i
            List<String> matriculas = p.getAllMatriculas();
            System.out.println("\ni. " + matriculas);

            //iii.
            p.removeLugar("42-99-OT");
            System.out.println("\niii. " + p.toString());

            //iv)
            p.setTempo("98-GS-86", 35);
            System.out.println("\niv. " + p.toString());

            //v.
            int min1 = p.allMin1();
            int min2 = p.allMin2();

            System.out.println("\nv. 1_versão: " + min1 + " | 2_versão: " + min2);

            //vi.
            List<String> timedMatriculas = p.timedMatriculas2(10);
            System.out.println("\nvi. " + timedMatriculas);

            //vii.
            boolean b = p.hasLugar("42-99-OT");
            System.out.println("\nvii. Existe a matrícula 42-99-OT? " + b);

            //viii.
            List<Lugar> lugares = p.getAllLugares();
            System.out.println("\nviii. " + lugares);

            //ix.
            Lugar l = p.getLugarInfo("98-GS-86");
            System.out.println("\nix. " + l);

        }
}

