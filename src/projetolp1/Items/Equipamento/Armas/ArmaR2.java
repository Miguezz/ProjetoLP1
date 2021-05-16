package projetolp1.Items.Equipamento.Armas;

class ArmaR2 extends Arma {
/**
 *
 * @author Mingre Dingre
 */
  ArmaR2(int qtdMaos){
    super(1/*Range*/, 2 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
  }
  
    ArmaR2(String nome, String desc,int qtdMaos){
    super(nome, desc, 2/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
  }
  
}

class lanca extends ArmaR2 {
    
    lanca() {
        super(1);
    }
    
}
