package projetolp1.Items.Equipamento.Armas;
/**
 *
 * @author Mingre Dingre
 */
class ArmaR3 extends Arma {

  ArmaR3(int qtdMaos){
    super(1/*Range*/, 2 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
  }
  
    ArmaR3(String nome, String desc,int qtdMaos){
    super(nome, desc, 2/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/, 6);
  }
}
