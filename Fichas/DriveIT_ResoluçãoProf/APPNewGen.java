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


/**
 * Classe APPNewGen - APP New Generation, que utiliza as classes dos menús com
 * handlers de comportamento (View) e a classe que implementa a TextUI (Controller).
 */


public class APPNewGen {
  
  public static void main(String[] args) {
    new TextUI().run();    // coloca o delegate em execução
  }
    
}