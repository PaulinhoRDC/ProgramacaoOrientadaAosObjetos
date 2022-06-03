/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

/**
 * Write a description of class TesteDriveIt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
package Fichas.DriveIT_ResoluçãoProf;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.Serializable;


public class DriveItMain {
    public static final int N = 5;
    public static void main(String[] args){
        DriveItPL8 d = new DriveItPL8();
        List<Integer> classif = new ArrayList();
        
        d.setNome("Empresa de Aluguer PL8");
        
        /**
         * Inicializar com veiculos
         */
        
        VeiculoPremium vp1 = new VeiculoPremium("ford", "puma", "AA-01-AA", 2020, 65.0, 1.5, classif, 20, 0, 1);
        VeiculoPremium vp2 = new VeiculoPremium("seat", "leon", "AB-01-AA", 2020, 55.0, 2.5, classif, 200, 0, 1.5);
        VeiculoPremium vp3 = new VeiculoPremium("ferrari", "tigre", "AC-01-AA", 2020, 45.0, 3.5, classif, 2000, 0, 10);
        VeiculoPremium vp4 = new VeiculoPremium("fiat", "pardal", "AD-01-AA", 2020, 35.0, 5.5, classif, 20000, 0, 1);
        VeiculoPremium vp5 = new VeiculoPremium("toyota", "chita", "AE-01-AA", 2020, 25.0, 4.5, classif, 200000, 0, 2);
        VeiculoPremium vp6 = new VeiculoPremium("opel", "cobra", "AF-01-AA", 2020, 15.0, 6.5, classif, 2000000, 0, 1.1);
        
        AutocarroInteligente ai1 = new AutocarroInteligente("volvo", "grande", "XA-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 50);
        AutocarroInteligente ai2 = new AutocarroInteligente("saab", "eco", "XB-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 80);
        AutocarroInteligente ai3 = new AutocarroInteligente("man", "strong", "XC-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 40);
        AutocarroInteligente ai4 = new AutocarroInteligente("renault", "mobile", "XD-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 90);
        AutocarroInteligente ai5 = new AutocarroInteligente("volvo", "charter", "XE-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 90);
        AutocarroInteligente ai6 = new AutocarroInteligente("mercedes", "limousine", "XF-01-AA", 2010, 55.0, 2.5, classif, 20, 0, 100, 50);
        
        VeiculoOcasiaoNovo von1 = new VeiculoOcasiaoNovo("kia", "sabre", "MA-01-AA", 2020, 35.0, 5, classif, 2000, 0,false);
        VeiculoOcasiaoNovo von2 = new VeiculoOcasiaoNovo("mazda", "punhal", "MB-01-AA", 2021, 45.0, 2.5, classif, 11120, 0,true);
        VeiculoOcasiaoNovo von3 = new VeiculoOcasiaoNovo("hyundai", "colt", "MC-01-AA", 2000, 55.0, 4.5, classif, 22220, 0,false);
        VeiculoOcasiaoNovo von4 = new VeiculoOcasiaoNovo("suzuki", "flecha", "MD-01-AA", 2000, 65.0, 1.5, classif, 15520, 0,true);
        
        /**
         * adicionar veículos ao DriveIt
         * 
         */
        
        try {
        d.adiciona(vp1);
        }
        catch(VeiculoExistenteException e) {
          System.out.println("Matricula " + e.getMessage() + " já existe!");  
        }
        try
        {
    
        d.adiciona(vp2);
        }
        catch (VeiculoExistenteException vee)
        {
            vee.printStackTrace();
        }
        try {
        d.adiciona(vp3);
        d.adiciona(vp4);
        d.adiciona(vp5);
        d.adiciona(vp6);
        d.adiciona(ai1);
        d.adiciona(ai2);d.adiciona(ai3);d.adiciona(ai4);d.adiciona(ai5);d.adiciona(ai6);
        d.adiciona(von1);
        d.adiciona(von2);
        d.adiciona(von3);
        d.adiciona(von4);
        
        }
        catch(VeiculoExistenteException e) {
          System.out.println("Matricula " + e.getMessage() + " já existe!");  
        }
        
        
        System.out.println(d.toString());
        
        /**
         * invocar o daoPontos
         */

        System.out.println("Imprimir todos os BonificaKms");
        
        List<BonificaKms> todosOsqueDaoPontos = d.daoPontos();
        for(BonificaKms v: todosOsqueDaoPontos)
          System.out.println(v.toString());
        
        
        
        
        /**
         * outras invocações de métodos
         */
       
        
        /**
         * Os comparators, bem como outras interfaces funcionais, quando escritos sob a forma de expressões
         * lambda não são serializáveis, isto é, não podem ser gravados com recurso a ObjectOutputStream.
         * 
         * No caso dos comparators uma alternativa é criar o comparator numa classe, que implemente 
         * Comparator<T> e Serializable.
         * Para outras expressões lambda podemos criar uma interface que herde da interface que a expressão
         * lambda representa e de Serializable.
         * 
         * Podemos também utilizar o cast abaixo apresentado para declarar que a expressão lambda também pode ser
         * vista como um Serializable.
         * 
         */
        
        Comparator<Veiculo> cv = (Comparator<Veiculo> & Serializable)(v1,v2) -> 
                                                      (v1.getModelo().compareTo(v2.getModelo())); 
        DriveItPL8.addComparador("ordemCrescenteModelo",cv);
        
        Comparator<Veiculo> cv1 = (Comparator<Veiculo> & Serializable) (v1,v2) -> 
                                          ((v1.getKms()!=v2.getKms())?(v2.getKms() - v1.getKms()):
                                          v2.getMatricula().compareTo(v1.getMatricula())); 
        
        DriveItPL8.addComparador("ordemDecrescenteKmsMatricula", cv1);
        
        
        
        try
        {
            Veiculo v = d.getVeiculo("matricula");
        }
        catch (VeiculoNaoExistenteException vnee)
        {
            //vnee.printStackTrace();
            System.out.println("A matricula " + vnee.getMessage() + " não existe");
        }
            
        
        
        
        /**
         * gravar em ficheiro texto
         */
         
        try {
          d.escreveFicheiroTexto("DriveItTXT.txt");
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
    
        
        /**
         * gravar em modo objecto
         */
        
        try {
          d.guardaEstado("DriveItOBJ.dat");  
            
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch (java.io.IOException fnfe) 
        {
            fnfe.printStackTrace();

            }
        /*
        DriveItPL8 novo = new DriveItPL8();
        try
        {
             novo = DriveItPL8.carregaEstado("DriveItOBJ.dat");
        }
        catch (java.lang.ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch (java.io.IOException fnfe)
        {
            fnfe.printStackTrace();
        }
        
        System.out.println("Objecto carregado de ficheiro de objectos!!");
        System.out.println(novo.toString());
        */
        
    }
}
