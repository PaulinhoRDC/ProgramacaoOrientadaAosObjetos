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

/**
 * Write a description of class DriveItPL8 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

package Fichas.DriveIT_ResoluçãoProf;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;



public class DriveItPL8 implements Serializable{
    
   /**
    * variáveis classe
    */ 
    
   // NomeComparador -> Comparador 
   private static Map<String, Comparator<Veiculo>> comps = new HashMap<>();
   
   public static void addComparador(String nomeComparador, Comparator<Veiculo> cv) {
       comps.put(nomeComparador,cv);
   }
   
   public static Comparator<Veiculo> getComparador(String nomeComparador) {
       return comps.get(nomeComparador);    
   }
   
   /**
    * variáveis instância
    */ 
   
   
   private String nome;
   private Map<String, Veiculo> viaturas;
   
   public DriveItPL8() {
     this.nome = "";
     this.viaturas = new HashMap();
   }
   
   
   public DriveItPL8(String nome, Map<String,Veiculo> viaturas) {
     this.nome = nome;
     this.viaturas = viaturas.entrySet().stream()
                            .collect(Collectors.toMap(e -> e.getKey(),
                                                       e -> e.getValue().clone()));
                             
   }
   
   public DriveItPL8(DriveItPL8 d) {
     this(d.getNome(), d.getViaturas());  
         
   }
   
   
   public String getNome() {
     return this.nome;    
   }
   
   
   public void setNome(String s) {
     this.nome = s;    
   }
   
   public Map<String,Veiculo> getViaturas() {
       return this.viaturas.entrySet().stream()
               .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone()));
   }

   public void setViaturas(Map<String, Veiculo> viaturas) {
       this.viaturas= viaturas.entrySet().stream()
               .collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().clone()));
       
   }
    

   /**
    * equals, toString, clone
    */
   
   public DriveItPL8 clone() {
     return new DriveItPL8(this);
   }
   
   
   public String toString() {
   
     StringBuilder sb = new StringBuilder();
     sb.append("Nome Empresa: "); sb.append(this.nome);
     sb.append("\n");
     sb.append("Viaturas: "); sb.append("\n");
     for(Veiculo v: this.viaturas.values()) {
       sb.append(v.toString());
       sb.append("\n");
     }     
     return sb.toString();
   }
   
   
   /**
    * a)
    */
   
   public boolean existeVeiculo(String cod) {
     //return this.viaturas.keySet().contains(cod);
     return this.viaturas.containsKey(cod);
     
   }
   
   /**
    * b)
    */
   
   public int quantos() {
     return this.viaturas.size();  
       
   }
   
   
   /**
    * c)
    */
   
   public int quantos(String marca) {
     return (int)this.viaturas.values().stream().filter(v -> v.getMarca().equals(marca)).count();    
       
   }
   
   /**
    * d)
    * 
    * Método muito perigoso. 
    * Se cod não existir "devolve" uma excepção.
    * 
    */
   
   public Veiculo getVeiculo(String cod) throws VeiculoNaoExistenteException {
     if (this.viaturas.containsKey(cod))
       
       return this.viaturas.get(cod).clone();
     else
       throw new VeiculoNaoExistenteException(cod);
              
   }
   
   /**
    * e) 
    * 
    * Temos de adicionar sinalização de erro caso a matricula exista!!
    */
   
   public void adiciona(Veiculo v) throws VeiculoExistenteException {
     if (this.viaturas.containsKey(v.getMatricula()))
       throw new VeiculoExistenteException(v.getMatricula());
     else   
       this.viaturas.putIfAbsent(v.getMatricula(),v.clone());    
   }
   
   /**
    * f)
    */
   
   public List<Veiculo> getVeiculos() {
     return this.viaturas.values().stream().map(Veiculo::clone).collect(Collectors.toList());  
       
   }
   
   /**
    * g)
    */
   
   public void adiciona(Set<Veiculo> vs) throws VeiculoExistenteException {
     for(Veiculo v: vs)
       adiciona(v);
   }
   
   /**
    * h)
    */
   
   public void registarAluguer(String codVeiculo, int numKms) {
     if (this.viaturas.containsKey(codVeiculo))
       this.viaturas.get(codVeiculo).addViagem(numKms);
   }
   
   /**
    * i)
    * 
    */
   
   public void classificarVeiculo(String cod, int classificacao) {
      if (this.viaturas.containsKey(cod))
       this.viaturas.get(cod).addClassificacao(classificacao);  
   }
   
   /**
    * j)
    * 
    * Temos de alterar este código para prever que o veiculo possa não existir.
    * Neste momento custo é zero, caso o cod não exista.
    */
   public int custoRealKm(String cod) {
     int custo = 0;  
     if (this.viaturas.containsKey(cod))  
       custo = (int)this.viaturas.get(cod).custoRealKM();
     return custo;  
   }
   
   
   /**
    * Calcular o Veiculo com o custo real KM mais baixo
    * Se dois veiculos tiverem o mesmo custo por km ordena-se por ordem alfabética da
    * matrícula.
    * 
    */
   
   
   public Veiculo veiculoMaisBarato() {
     
       Comparator<Veiculo> cv = (v1,v2) -> (v1.custoRealKM() != v2.custoRealKM() ?
          (int)(v1.custoRealKM() - v2.custoRealKM()): v1.getMatricula().compareTo(v2.getMatricula()));
        
       return this.viaturas.values().stream().sorted(cv).findFirst().get().clone(); 
       
       
   }
   
   /**
    * Calcular o veículo menos utilizado, isto é, com mais kms
    * Se tiverem o mesmo número de kms, então deve volver o alfabeticamente 
    * "maior".
    * 
    */
   
   public Veiculo veiculoMaisUtilizado() {
      Comparator<Veiculo> cv = (v1,v2) -> (v1.getKms()!=v2.getKms())?(v2.getKms() - v1.getKms()):
                                          v2.getMatricula().compareTo(v1.getMatricula()); 
                                          
      return this.viaturas.values().stream()
                                   .sorted(cv)
                                   .findFirst()
                                   .get()
                                   .clone();
      
    }
    
    
    public void colocaEmpresaEmPromocao() {
      for(Veiculo v : this.viaturas.values())
        if( v instanceof VeiculoOcasiaoNovo)
            ((VeiculoOcasiaoNovo) v).setPromocao(true);
    }
    
    
    /**
     * Fase 2, 2a)
     */
    
    public Set<Veiculo> ordenarVeiculos() {
      TreeSet<Veiculo> res = new TreeSet<>();
      
      for(Veiculo v: this.viaturas.values())
        res.add(v.clone());
        
      return res;
      
        
    }
    
    /**
     * Fase 2, 2b)
     * 
     */
    
    public List<Veiculo> ordenarVeiculosL() {
      return this.viaturas.values().stream().map(Veiculo::clone)
                                   .sorted()
                                   .collect(Collectors.toList());
    }
    
    
    /**
     * 
     * Devolver um Map que associa a cada Marca de Veiculo a lista dos Veiculos dessa marca,
     * ordenados por ordem alfabética de modelo.
     * 
     * Marca -> List<Veiculo>, lista ordenado por ordem alfabética crescente de modelo
     */
    
    public Map<String, List<Veiculo>> porMarca_Modelo() {
        Comparator<Veiculo> cv = (v1,v2) -> (v1.getModelo().compareTo(v2.getModelo()));
        
        return this.viaturas.values().stream()
                                     .map(Veiculo::clone)
                                     .sorted(cv)
                                     .collect(Collectors.groupingBy(Veiculo::getMarca));
        
    }
    
    
    
    public Map<String, List<Veiculo>> porMarca_Modelov2() {
        
      Comparator<Veiculo> cv = (v1,v2) -> (v1.getModelo().compareTo(v2.getModelo()));  
      Map<String, List<Veiculo>> res = new HashMap();
      
      for(Veiculo v: this.viaturas.values()) {
        String marca = v.getMarca();
        res.putIfAbsent(marca, new ArrayList<>());
        res.get(marca).add(v.clone());
      }
        
      for(List<Veiculo> l: res.values())
         l.sort(cv);
        
      return res;   
    }    
    
    /**
     * passar o identificador do comparador por parâmetro
     */
    
    public Map<String, List<Veiculo>> porMarca_Modelov3(String nomeComparador) {
        
      Map<String, List<Veiculo>> res = new HashMap();
      
      for(Veiculo v: this.viaturas.values()) {
        String marca = v.getMarca();
        res.putIfAbsent(marca, new ArrayList<>());
        res.get(marca).add(v.clone());
      }
        
      for(List<Veiculo> l: res.values())
         l.sort(getComparador(nomeComparador));  // comps.get(nomeComparador)             (-)
                                                 // DriveItPL8.comps.get(nomeComparador)  (--)
        
      return res;   
    }    
    
    
    /**
     * Fase 2, 2e)
     */
    
    public Iterator<Veiculo> ordenarVeiculo(String nomeComparador) {
        List<Veiculo> res;

        res = this.viaturas.values().stream()
                                    .map(Veiculo::clone)
                                    .sorted(getComparador(nomeComparador))
                                    .collect(Collectors.toList());
        
        return res.iterator();
    }
    
    /**
     * Fase 3, 3
     */
    public List<BonificaKms> daoPontos() {
      return this.viaturas.values().stream().
                        filter(v -> v instanceof BonificaKms).
                        map(v -> (BonificaKms) v).   // v ´é antes do cast do tipo Veiculo
                        collect(Collectors.toList());

     
    }
    
        
   /**
    * Fase 4, gravar em ficheiro de texto
    */
    
   public void escreveFicheiroTexto(String nomeFicheiro) throws FileNotFoundException {
     PrintWriter fich = new PrintWriter(nomeFicheiro);
     fich.println(this.toString());
     
     /*
      * fich.println("Nome da Empresa: " + this.nome);
      * fich.println("Viaturas: ");
      * for(Veiculo v: this.viaturas.values())
      *   fich.println(v.toString());
      * 
      * 
      */
     
     fich.flush();
     fich.close();
       
   }
    
   
   /**
    * Fase 4, gravar em ficheiro de objectos
    */
    
   public void guardaEstado(String nomeFicheiro) throws FileNotFoundException, IOException {
     FileOutputStream fos = new FileOutputStream(nomeFicheiro);
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     
     oos.writeObject(comps); // gravar o map, variável de classe, de comparadores
     oos.writeObject(this);  // deve implementar Serializable
     
     oos.flush();
     oos.close();
       
   }
   
   
   /**
    * Fase 4, ler de ficheiro de objectos
    */
   
   
   public static DriveItPL8 carregaEstado(String nomeFicheiro) throws FileNotFoundException, IOException, 
                                                       ClassNotFoundException {
                                                           
  
                                                        
     FileInputStream fis = new FileInputStream(nomeFicheiro);
     ObjectInputStream ois = new ObjectInputStream(fis);
     
     // primeiro ler o objecto com os comparadores e
     // actualizar a variável de classe
     DriveItPL8.comps = (Map<String, Comparator<Veiculo>>) ois.readObject();
     
     // ler a instância de DriveItPL8 que foi gravada
     DriveItPL8 newDriveIt = (DriveItPL8) ois.readObject();
     
     return newDriveIt;
} 
   
}




