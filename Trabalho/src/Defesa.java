import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Defesa extends Jogador {

    public Defesa() throws ExcecaoPos {
        super();
        super.setPosicao(new Posicao(Posicao.DEFESA));
    }

    public Defesa(String id,String nome, ArrayList<Equipa> a
            ,int v, int r,int d, int i, int c, int remate, int p) throws ExcecaoPos {
        super(id,nome,new Posicao(Posicao.DEFESA),v,r,d,i,c,remate,p,a);
        super.sethab(calculahabilidade(v,r,d,i,c,remate,p));
    }
    public Defesa(String id,String nome
            ,int v, int r,int d, int i, int c, int remate, int p) throws ExcecaoPos {
        super(id,nome,new Posicao(Posicao.DEFESA),v,r,d,i,c,remate,p);
        super.sethab(calculahabilidade(v,r,d,i,c,remate,p));
    }

    public Defesa(Defesa e) {
        super(e);
    }

    public int calculahabilidade(int v, int r,int d, int i, int c, int remate, int p){
        return (int) (0.15 * v + 0.15 * r + 0.17 * d +  0.15 * i
                + 0.15 * c + 0.08 * remate + 0.15 * p);
    }

    public Defesa clone(){
        return new Defesa(this);
    }

    public void guarda() throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter("\\Users\\paulinhordc\\Desktop\\Projeto\\src\\logsV2.txt",true));
        escritor.write("\nDefesa:");
        escritor.flush();
        super.guarda();
        escritor.flush();
        escritor.close();
    }

    public boolean equals(Defesa e){
        return super.equals(e);
    }

    public static Defesa parse(String input) throws ExcecaoPos {
        String[] campos = input.split(",");
        Defesa res = new Defesa(campos[1], campos[0],
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
        return res;
    }
}