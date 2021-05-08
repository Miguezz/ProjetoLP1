package projetolp1.Items.Equipamento.Armas;

class ArmaR1 extends Arma {
/**
 *
 * @author Mingre Dingre
 */
  ArmaR1(int qtdMaos){
    super(1/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }
  
    ArmaR1(String nome, String desc,int qtdMaos){
    super(nome, desc, 1/*Range*/, 1 /*Dano*/, qtdMaos, qtdMaos*1.5/*modQtdMaos*/);
  }
  
}
///Todas as armas estão sem descrição, exceto a faca inicial, pois n foi decidido como será o dano delas e os atributos especiais das mesmas. bom dia
class FacaInicial extends ArmaR1 {
    
    FacaInicial() {
        super("Faca Inicial", "Faca que todos os jogadores usam no inicio do jogo, nao possui nada de especial. Equipa em todas as classes.", 1);
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

class Adaga extends ArmaR1 {
    
    Adaga(){
        super(1);
    }
}

class AdagaMagica extends ArmaR1 {
    
    AdagaMagica(){
        super("Adaga Magica", "", 1);
    }
}

class EspadaLonga extends ArmaR1 {
    
    EspadaLonga() {
        super("Espada Longa","",2);
    }
    
}

class MachadoPesado extends ArmaR1 {
    
    MachadoPesado() {
        super("Machado Pesado","",2);
    }
    
}