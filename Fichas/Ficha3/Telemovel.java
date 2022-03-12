package Fichas.Ficha3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;


public class Telemovel {
    private String marca;
    private String modelo;
    private int resX;
    private int resY;
    private ArrayList<String> msgA = new ArrayList<>();
    private int fotosA;
    private int apsA;
    private int espacoTotal;
    private int nrFotos;
    private int apsInstall;
    private ArrayList<String> apsInstallNome = new ArrayList<>();


    public Telemovel() {
        this.marca = " ";
        this.modelo = " ";
        this.resX = 0;
        this.resY = 0;
        this.msgA = new ArrayList<>();
        this.fotosA = 0;
        this.apsA = 0;
        this.espacoTotal = 0;
        this.nrFotos = 0;
        this.apsInstall = 0;
        this.apsInstallNome = new ArrayList<>();
    }

    public Telemovel(String marca, String modelo, int resX, int resY, String msgA, int fotosA, int apsA, int espacoTotal, int nrFotos, int apsInstall, String apsInstallNome) {
        this.marca = marca;
        this.modelo = modelo;
        this.resX = resX;
        this.resY = resY;
        this.msgA.add(msgA);
        this.fotosA = fotosA;
        this.apsA = apsA;
        this.espacoTotal = espacoTotal;
        this.nrFotos = nrFotos;
        this.apsInstall = apsInstall;
        this.apsInstallNome.add(apsInstallNome);
    }

    public Telemovel(Telemovel umTele) {
        this.marca = umTele.getMarca();
        this.modelo = umTele.getModelo();
        this.resY = umTele.getResY();
        this.resX = umTele.getResX();
        this.msgA = umTele.getMsgA();
        this.fotosA = umTele.getFotosA();
        this.apsA = umTele.getApsA();
        this.espacoTotal = umTele.getEspacoTotal();
        this.nrFotos = umTele.getNrFotos();
        this.apsInstall = umTele.getApsInstall();

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getResX() {
        return resX;
    }

    public void setResX(int resX) {
        this.resX = resX;
    }

    public int getResY() {
        return resY;
    }

    public void setResY(int resY) {
        this.resY = resY;
    }

    public ArrayList<String> getMsgA() {
        return msgA;
    }

    public void setMsgA(String msgA) {
        this.msgA.add(msgA);
    }

    public int getFotosA() {
        return fotosA;
    }

    public void setFotosA(int fotosA) {
        this.fotosA = fotosA;
    }

    public int getApsA() {
        return apsA;
    }

    public void setApsA(int apsA) {
        this.apsA = apsA;
    }

    public int getEspacoTotal() {
        return espacoTotal;
    }

    public void setEspacoTotal(int espacoTotal) {
        this.espacoTotal = espacoTotal;
    }

    public int getNrFotos() {
        return nrFotos;
    }

    public void setNrFotos(int nrFotos) {
        this.nrFotos = nrFotos;
    }

    public int getApsInstall() {
        return apsInstall;
    }

    public void setApsInstall(int apsInstall) {
        this.apsInstall = apsInstall;
    }

    public ArrayList<String> getApsInstallNome() {
        return apsInstallNome;
    }

    public void setApsInstallNome(String apsInstallNome) {
        this.apsInstallNome.add(apsInstallNome);
    }

    public String toString() {
        return "Telemovel: " + this.getMarca() + " " + this.getModelo() + "\nRes: " + this.getResX() + "x" + this.getResY()
                + "\nDimensoes: " + this.getFotosA() + " " + this.getApsA()
                + "\nEspaço total: " + this.getEspacoTotal()
                + "\nNr fotos: " + this.getNrFotos() + " Nr Apps: " + this.getApsInstall()
                + "\nNome aps Instaladas: " + this.getApsInstallNome().toString()
                + "\nMsg em sistema: " + this.getMsgA().toString();
    }

    // a)
    public boolean existeEspaco(int numeroBytes) {
        int espacoOcup = this.getApsA() + this.getFotosA();

        return ( (this.getEspacoTotal() - espacoOcup) < numeroBytes);
    }

    // b)
    public void instalaApp(String nome, int tamanho) {
        if(existeEspaco(tamanho)) {
            this.setApsInstallNome(nome);
            this.setApsInstall(this.getApsInstall() + 1);
            this.setEspacoTotal(this.getEspacoTotal() + tamanho);
        }
    }

    // c)
    public void recebeMsg(String msg) {
        this.setMsgA(msg);
    }

    // d)
    double tamMedioApps() {                         //tamanho médio das aplicações //verificar

        double nr = this.getApsInstall();
        double total = this.getApsA();

        double media = nr/total;

        return media;
    }

    // e)
    public String maiorMsg() {

        String max = msgA.stream().max(comparing(String::length)).get();

        //ou
        String max1 = Collections.max(msgA, Comparator.comparing(String::length));
        return max1;
    }

    // f)
    public void removeApp(String nome,int tamanho) {
        this.getApsInstallNome().remove(nome);
        this.setApsInstall(this.getApsInstall() - 1);
        this.setEspacoTotal(this.getEspacoTotal() - tamanho);
    }
}

