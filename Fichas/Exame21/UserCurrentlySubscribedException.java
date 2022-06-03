package Fichas.Exame21;

public class UserCurrentlySubscribedException extends Exception {
    public UserCurrentlySubscribedException() {
        super();
        System.out.println("Não é possivel remover o podcast pois há utilizador(es) subscritos\n");
    }
}
