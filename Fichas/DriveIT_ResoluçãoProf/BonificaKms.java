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
 * Interface de atribuição de pontos de fidelidade.
 * X pontos por Km.
 *
 * @author anr
 * @version 20210505
 */
public interface BonificaKms {
    
    //Definir o valor de pontos a atribuir por cada km.
    public void setPontos(int pontos);
    //Obter o valor de pontos que se está a a atribuir por cada km.
    public int getPontos();
    //Obter o valor de pontos que um determinado veículo já acumulou.
    public int getPontosAcumulados();
}
