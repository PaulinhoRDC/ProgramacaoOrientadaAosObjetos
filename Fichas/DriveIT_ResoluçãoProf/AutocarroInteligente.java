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

package Fichas.DriveIT_ResoluçãoProf;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class AutocarroInteligente here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AutocarroInteligente extends Veiculo implements BonificaKms {
  private int lotacao; //lotação máxima do autocarro
  private int ocupacao; //ocupação actual do autocarro
  
  /**
   * variáveis necessárias para a implementação de BonificaKms
   */
  private int pontosKm;
  private int pontosAcumulados;
  
  
  /*
   * Construtores, outros métodos
   * get,set
   */
  
  public AutocarroInteligente() {
    super();
    this.lotacao = 0;
    this.ocupacao = 0;
  }
  
  public AutocarroInteligente(String marca, String modelo, String matricula,
                   int ano, double velocidademedia, double precokm,
                   List<Integer> classificacao,
                   int kms, int kmsUltimo, int lotacao, int ocupacao) {
                       
    super(marca, modelo, matricula, ano, velocidademedia, precokm, classificacao, kms, kmsUltimo);
    this.lotacao = lotacao;
    this.ocupacao = ocupacao;
  }
  
  
  public AutocarroInteligente(AutocarroInteligente vp) {
    super(vp);
    this.ocupacao = vp.getOcupacao();
    this.lotacao = vp.getLotacao();
  }
   
  
  public int getOcupacao() {
    return this.ocupacao;    
  }
  
  public int getLotacao() {
    return this.lotacao;    
  }
  
  
  
  
  /**
   * Implementação método polimórfico
   * custoRealKM
   */
  
  public double custoRealKM() {
    double ratio = lotacao/ocupacao; //ratio de ocupação  
    double factor;
    
    if (ratio < 0.6) 
      factor = 0.5;
    else
      factor = 0.75;
      
    return getPrecokm()*factor;      
  }
 
  
  /**
   * clone, equals, toString
   */
  
  public AutocarroInteligente clone() {
    return new AutocarroInteligente(this);    
  }
  
  
  public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        AutocarroInteligente v = (AutocarroInteligente) o;
        return super.equals(v) && this.ocupacao == v.getOcupacao() && this.lotacao == v.getLotacao();
  }
  
  public String toString() {
        return super.toString() + " Ocupacão: "+ this.ocupacao + " Lotação: "+ this.lotacao;
  }  
      
  //Definir o valor de pontos a atribuir por cada km.
    public void setPontos(int pontos) {
       this.pontosKm = pontos;
    }
    //Obter o valor de pontos que se está a a atribuir por cada km.
    public int getPontos() {
      return this.pontosKm;   
    }
    //Obter o valor de pontos que um determinado veículo já acumulou.
    public int getPontosAcumulados() {
      return this.pontosAcumulados;   
    }
  
  
   /**
    * Reescrever o método addViagem, para que actualize o acumulador
    * de pontos.
    */ 
    
   public void addViagem(int nkms) {
     super.addViagem(nkms);
     this.pontosAcumulados += nkms*this.pontosKm;
       
   } 
    
    
}
