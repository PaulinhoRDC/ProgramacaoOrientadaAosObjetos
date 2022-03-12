package Fichas.Ficha3;

public class Lampada {

    private boolean modo;
    private boolean estadoOn;    // saber se ela já está ligada ou desligada
    private double consumo;
    private long tempoOn;         // milisegundos torna mais fácil a medição do tempo passado
    private double totalConsumo;
    private double periodoConsummo;

    public Lampada(){
        this.modo = false;
        this.estadoOn = false;
        this.consumo = 0;
        this.tempoOn = 0;
        this.totalConsumo = 0;
        this.periodoConsummo = 0;
    }

    public Lampada(double consumo){
        this.modo = false;
        this.estadoOn = false;
        this.consumo = consumo;
        this.tempoOn = 0;
        this.totalConsumo = 0;
        this.periodoConsummo = 0;
    }

    public Lampada(Lampada outra){
        this.modo = outra.getModo();
        this.estadoOn = outra.getEstadoOn();
        this.consumo = outra.getConsumo();
        this.tempoOn = outra.getTempoOn();
        this.totalConsumo = outra.getTotalConsumo();
        this.periodoConsummo = outra.getPeriodoConsummo();
    }

    // Getter && Setter 's //


    public boolean getModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }

    public boolean getEstadoOn() {
        return estadoOn;
    }

    public void setEstadoOn(boolean estadoOn) {
        this.estadoOn = estadoOn;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public long getTempoOn() {
        return tempoOn;
    }

    public void setTempoOn(long tempoOn) {
        this.tempoOn = tempoOn;
    }

    public double getTotalConsumo() {
        return totalConsumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public double getPeriodoConsummo() {
        return periodoConsummo;
    }

    public void setPeriodoConsummo(double periodoConsummo) {
        this.periodoConsummo = periodoConsummo;
    }

    public void lampON(){

        if (estadoOn)
            return;

        this.modo = false;
        this.tempoOn = System.currentTimeMillis();
        estadoOn = true;                                // this.estadoOn = true;
    }

    public void lampECO(){

        if(estadoOn)
            return;

        this.modo = true;
        this.tempoOn = System.currentTimeMillis();
        estadoOn = true;                                // this.estadoOn = true;

    }

    public void lampOFF(){

        if(estadoOn == false)
            return;

        long now = System.currentTimeMillis();
        long periodo = now - tempoOn;

        totalConsumo += periodo*consumo;
        periodoConsummo += periodo*consumo;
        estadoOn = false;
    }

    public double totalConsumo(){
        return totalConsumo;
    }

    public double periodoConsumo(){
        return periodoConsummo;
    }

    public void reset (){
        this.lampOFF();
        this.periodoConsummo = 0;
    }




}
