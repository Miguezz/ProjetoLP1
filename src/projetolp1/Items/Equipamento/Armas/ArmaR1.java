package projetolp1.Items.Equipamento.Armas;

class ArmaR1 extends Arma {
/**
 *
 * @author Mingre Dingre
 */
    public ArmaR1(int qtdMaos){
      super(1/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
    }
  
    ArmaR1(String nome, String desc,int qtdMaos){
    super(nome, desc, 1/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
  }
  
}