package Fichas.Ficha3.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Telemovel {

    // Object variables -----------------------------------------------------

    private final String brand;
    private final String model;
    private final int displayX;
    private final int displayY;

    private List<String> messages;
    private List<String> apps;

    private int storageTotal;
    private int storageApps;
    private int storageMsg;

    // ----------------------------------------------------------------------

    // Construtor Vazio
    public Telemovel() {
        this.brand = "Apple";
        this.model = "iPhone 11";
        this.displayX = 828;
        this.displayY = 1792;

        this.messages = new ArrayList<>();
        this.apps = new ArrayList<>();

        this.storageTotal = 0x7f;
        this.storageApps = 0;
        this.storageMsg = 0;
    }

    // Construtor Parametrizado
    public Telemovel(String brand, String model, int displayX, int displayY,
                     ArrayList<String> messages, ArrayList<String> apps, int storageTotal,
                     int storageApps, int storageMsg) {
        this.brand = brand;
        this.model = model;
        this.displayX = displayX;
        this.displayY = displayY;

        this.messages = new ArrayList<>(messages);
        this.apps = new ArrayList<>(apps);

        this.storageTotal = storageTotal;
        this.storageApps = storageApps;
        this.storageMsg = storageMsg;
    }

    // Construtor de Cópia
    public Telemovel(Telemovel t) {
        this.brand = t.getBrand();
        this.model = t.getModel();
        this.displayX = t.getDisplayX();
        this.displayY = t.displayY;

        this.messages = t.messages;
        this.apps = t.apps;

        this.storageTotal = t.getStorageTotal();
        this.storageApps =  t.getStorageApps();
        this.storageMsg = t.getstorageMsg();
    }



    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getDisplayX() {
        return displayX;
    }

    public int getDisplayY() {
        return displayY;
    }


    public ArrayList<String> getMessages() {
        return new ArrayList<>(this.messages);
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = new ArrayList<>(messages);
    }

    public ArrayList<String> getApps() {
        return new ArrayList<>(this.apps);
    }

    public void setApps(ArrayList<String> apps) {
        this.apps = new ArrayList<>(apps);
    }

    public int getStorageTotal() {
        return storageTotal;
    }

    public void setStorageTotal(int storageTotal) {
        this.storageTotal = storageTotal;
    }

    public int getStorageApps() {
        return storageApps;
    }

    public void setStorageApps(int storageApps) {
        this.storageApps = storageApps;
    }

    public int getstorageMsg() {
        return storageMsg;
    }

    public void setstorageMsg(int storageMsg) {
        this.storageMsg = storageMsg;
    }


    // a)
    public boolean existeEspaco (int numeroBytes) {
        return (this.storageApps + this.storageMsg + numeroBytes < this.storageTotal);
    }

    // b)
    public void instalaApp (String nome, int tamanho) {
        this.apps.add(nome);
        this.storageApps += tamanho;

    }

    // c)
    public void recebeMsg(String msg, int tamanho) {
        this.messages.add(msg);
        this.storageMsg += tamanho;
    }

    // d)
    public double tamMedioApps() {
        return (double) this.storageApps / this.apps.size();
    }

    // e)
    public String maiorMsg() {
        int acc=0, max=0;
        String msg = null;

        for (String str : this.messages) {
            for (int j = 0; j < str.length(); j++) {
                acc++;
            }
            if (acc > max) {
                max = acc;
                msg = str;
            }
            acc = 0;
        }
        return msg;
    }


    // f)
    public void removeApp(String nome, int tamanho) {
        this.apps.remove(nome);
        this.storageApps -= tamanho;
    }

    @Override
    public Telemovel clone() {
        return new Telemovel(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return getDisplayX() == telemovel.getDisplayX() &&
                getDisplayY() == telemovel.getDisplayY() &&
                getStorageTotal() == telemovel.getStorageTotal() &&
                getStorageApps() == telemovel.getStorageApps() &&
                getstorageMsg() == telemovel.getstorageMsg() &&
                this.brand.equals(telemovel.getBrand()) &&
                this.model.equals(telemovel.getModel()) &&
                this.messages.equals(telemovel.getMessages()) &&
                this.apps.equals(telemovel.getApps());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getDisplayX(), getDisplayY(), getMessages(), getApps(), getStorageTotal(), getStorageApps(), getstorageMsg());
    }


    @Override
    public String toString() {
        return "Telemovel{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", messages=" + messages +
                ", apps=" + apps +
                ", storageTotal=" + storageTotal +
                ", storageApps=" + storageApps +
                ", storageMsg=" + storageMsg +
                '}';
    }
}


