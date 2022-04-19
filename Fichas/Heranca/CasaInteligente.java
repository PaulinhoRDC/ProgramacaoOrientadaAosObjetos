package Fichas.Heranca;

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

import java.util.*;
import java.util.stream.Collectors;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente {
   
    private String morada;
    private Map<String, SmartDevice> devices; // Identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        // initialise instance variables
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        // initialise instance variables
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap<>();

    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }
    
    public boolean existsDevice(String id) {
        return devices.containsKey(id);
    }
    
    public void addDevice(SmartDevice s) {
        this.devices.put(s.getId(),s.clone());
    }

    // Ainda não passa os testes
    public SmartDevice getDevice(String s) {
        if(!this.devices.containsKey(s)) return null;
        else return this.devices.get(s).clone();
    }
    
    public void setOn(String s, boolean b) {
        this.devices.get(s).setOn(b);
    }
    
    public void setAllOn(boolean b) {
        for(SmartDevice e : this.devices.values()) {
            e.setOn(b);
        }
    }
    
    public void addRoom(String s) {
        this.locations.put(s,new ArrayList<>());
    }

    public boolean hasRoom(String s) {
        /*
        for(String e : this.locations.keySet()) {
            return e.equals(s);
        }
        return false;
         */

        return this.locations.keySet().stream().anyMatch(k -> k.equals(s));
    }
    
    public void addToRoom (String s1, String s2) {

        this.locations.get(s1).add(s2);
    }
    
    public boolean roomHasDevice (String s1, String s2) {

        //return this.locations.get(s1).contains(s2);

        return this.locations.get(s1).stream().anyMatch(k -> k.equals(s2));
    }
    
}
