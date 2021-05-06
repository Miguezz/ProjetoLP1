package projetolp1.Items.Equipamento.Armas;

class ArmaR1 extends Arma {

  ArmaR1(int qtdMaos){
    super(1/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }

  
  
  
  
  
  
}


class Espada extends ArmaR1 {
    
    Espada() {
        super(1);
    }
    
}

class Machado extends ArmaR1 {
    
    Machado(){
        super(1);
    }
}