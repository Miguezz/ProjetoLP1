package projetolp1;

class ArmaR1 extends Arma {

  ArmaR1(String nome, String desc, int qtdMaos){
    super(nome, desc, 1/*Range*/, danoArma, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }

}