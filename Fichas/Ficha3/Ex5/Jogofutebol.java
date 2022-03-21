package Fichas.Ficha3.Ex5;

public class Jogofutebol {

    private enum Estado {
        PORINICAR,
        DECORRER,
        TERMINADO
    }
    private Estado estado;

    private int golosVisitado, golosVisitante;
    public Jogofutebol () {
        this(Estado.PORINICAR);
    }
    public Jogofutebol (Estado e) {
        this.estado = e;
    }
    public Jogofutebol(Jogofutebol j) {
        this.estado = j.estado;
        this.golosVisitado = j.golosVisitado;
        this.golosVisitante = j.golosVisitante;
    }

    public void startGame () {
        if (this.estado == Estado.PORINICAR) {
            this.estado = Estado.DECORRER;
            this.golosVisitado = this.golosVisitante = 0;
        }
    }

    public void endGame () {
        if (this.estado == Estado.DECORRER)
            this.estado = Estado.TERMINADO;
    }

    public void goloVisitado () {
        if (this.estado == Estado.DECORRER)
            this.golosVisitado += 1;
        else
            System.out.println("O jogo tem de ser iniciado antes de se poder marcar golos.");
    }

    public void goloVisitante () {
        if (this.estado == Estado.DECORRER)
            this.golosVisitante += 1;
        else
            System.out.println("O jogo tem de ser iniciado antes de se poder marcar golos.");
    }

    public String resultadoAtual () {
        return "Visitante: " + this.golosVisitante + " Visitado: " + this.golosVisitado;
    }

    public String toString () {
        return "Estado: " + this.estado + " " + this.resultadoAtual();
    }

    public Jogofutebol clone () {
        return new Jogofutebol(this);
    }

    public boolean equals (Object f) {
        if (this == f)
            return true;
        if (f == null || (this.getClass() != f.getClass()))
            return false;
        Jogofutebol j = (Jogofutebol) f;
        return (this.estado == j.estado && this.golosVisitante == j.golosVisitante
                && this.golosVisitado == j.golosVisitado);
    }


}
