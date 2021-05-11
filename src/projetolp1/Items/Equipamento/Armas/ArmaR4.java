package projetolp1.Items.Equipamento.Armas;
/**
 *
 * @author Mingre Dingre
 */
class ArmaR4 extends Arma {
  
  ArmaR4(int qtdMaos){
    super(1/*Range*/, 2 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }
  
    ArmaR4(String nome, String desc,int qtdMaos){
    super(nome, desc, 2/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }
  
   class Arco extends ArmaR4 {
    
    Arco() {
        super(2);
    }
    
}


}