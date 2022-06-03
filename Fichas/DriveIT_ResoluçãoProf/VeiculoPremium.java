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
import java.util.*;

/**
 * Write a description of class VeiculoPremium here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VeiculoPremium extends Veiculo implements BonificaKms {
  private double taxaLuxo; // se for 1 não tem taxa. Acima de 1 é multiplicativo
  /**
   * variáveis necessárias para a implementação de BonificaKms
   */
  private int pontosKm;
  private int pontosAcumulados;

  /**
   * Construtores
   */
  
  public VeiculoPremium() {
    super();
    this.taxaLuxo = 0.0;
  }
  
  public VeiculoPremium(String marca, String modelo, String matricula,
                   int ano, double velocidademedia, double precokm,
                   List<Integer> classificacao,
                   int kms, int kmsUltimo, double taxaLuxo) {
                       
    super(marca, modelo, matricula, ano, velocidademedia, precokm, classificacao, kms, kmsUltimo);
    this.taxaLuxo = taxaLuxo;
  }
  
  
  public VeiculoPremium(VeiculoPremium vp) {
    super(vp);
    this.taxaLuxo = vp.getTaxaLuxo();
  }
   
  
  
  
  public double getTaxaLuxo() {
    return this.taxaLuxo;
  }
  
  /**
   * Implementação método polimórfico
   * custoRealKM.
   */
  
  public double custoRealKM() {
     return getPrecokm() * this.taxaLuxo;  //super.precoKm * this.taxaLuxo; --> Não FAzER
  }

  
  /**
   * clone, equals, toString
   */
  
  public VeiculoPremium clone() {
    return new VeiculoPremium(this);    
  }
  
  
  public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoPremium v = (VeiculoPremium) o;
        return super.equals(v) && this.taxaLuxo == v.getTaxaLuxo();
  }
  
  public String toString() {
        return super.toString() + " Taxa Luxo: "+ this.taxaLuxo + " ";
  }  
      
  
   /**
   * Implementação métodos interface
   * 
   */
  
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
