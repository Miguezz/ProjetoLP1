package projetolp1.Items.Equipamento.Armas;

class ArmaR1 extends Arma {

  ArmaR1(String nome, String desc, int qtdMaos){
    super(nome, desc, 1/*Range*/, danoArma, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }

}