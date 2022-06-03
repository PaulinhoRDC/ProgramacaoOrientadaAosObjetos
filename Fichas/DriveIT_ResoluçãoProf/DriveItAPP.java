
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

public class DriveItAPP {
    
  private DriveItPL8 model = new DriveItPL8();
  
  private Menu menuPrincipal, menuVeiculos; // etc...
  
  public static void main(String[] args) {
    new DriveItAPP().run();    
  }
   
  
  private DriveItAPP() {
  
    String[] opcoesmenu1 = {"Gestão de Veiculos", 
                            "Alterar nome Empresa"};
    String[] opcoesmenu2 = {"Adicionar Veiculo", 
                            "Listar Veiculo", 
                            "Remover Veiculo"};
     
    this.menuPrincipal = new Menu(opcoesmenu1);
    this.menuVeiculos = new Menu(opcoesmenu2);
    
    /**
     * carregar o estado
     */
    
      /*
        try
        {
             this.model = DriveItPL8.carregaEstado("DriveItOBJ.dat");
        }
        catch (java.lang.ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch (java.io.IOException fnfe)
        {
            fnfe.printStackTrace();
        }
    */
  }
  
  
  private void run() {
    do {
      this.menuPrincipal.executa();
      switch (this.menuPrincipal.getOpcao()) {
        case 1: System.out.println("Entrei no Gestão de Veiculos");
                gestaoMenuVeiculos();
                break;
        case 2: System.out.println("Entrei em Alterar nome Empresa");
                // método de tratamento...
                break;
      }
      
    
    } while( this.menuPrincipal.getOpcao() != 0);
    /**
     * gravar o estado do programa quando escolhe sair.
     */
    try {
        
       this.model.guardaEstado("DriveItOBJ.dat");   
    }
      
    catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Não consegui gravar os dados...!");
    }
    catch (java.io.IOException fnfe) {
            System.out.println("Não consegui gravar os dados...!");
    }
    
    System.out.println("Adeus, até breve!!");
  }
  
  
  private void gestaoMenuVeiculos() {
    do {
      this.menuVeiculos.executa();
      //.... fazer coisas!
        
    } while (this.menuVeiculos.getOpcao() != 0);
      
  }
  
}
