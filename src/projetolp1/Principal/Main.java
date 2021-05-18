/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;
import projetolp1.Items.Equipamento.*;
import projetolp1.Principal.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import projetolp1.Items.Consumiveis.PotionMana;
import projetolp1.Mapa.Mapas;
import projetolp1.Items.Equipamento.Armas.*;
/**
 *
 * @author FelipeBrasileiro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
        public static void salvarArquivo(User u, String nomeArquivo){
            File arq = new File(nomeArquivo);
            try {
                arq.delete();
                arq.createNewFile();

                ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
                objOutput.writeObject(u);
                objOutput.close();

            } catch(IOException erro) {
                System.out.printf("Erro: %s", erro.getMessage());
            }
        }	

    public static User carregarArquivo(String nomeArquivo){
        File arq = new File(nomeArquivo);
        User user = new User();
        try {
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                user = (User)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
                        System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
                        System.out.printf("Erro: %s", erro2.getMessage());
        }
        return user;
    }
 

    public static void usarTodasHabilidades(Personagem p, Mapas m, Personagem t1, Personagem t2, Personagem t3, Personagem t4, PotionMana pm){
        p.atacar(m, t1);
        System.out.println(t1);
        System.out.println();
        System.out.println("-----------------");
        p.usarhabilidade(1, m, t1);
        System.out.println();
        System.out.println("-----------------");
        pm.efeito(p);
        p.usarhabilidade(2, m, t2);
        System.out.println();
        System.out.println("-----------------");
        pm.efeito(p);
        pm.efeito(p);
        p.usarhabilidade(3, m, t3);
        System.out.println();
        System.out.println("-----------------");
        pm.efeito(p);
        pm.efeito(p);
        pm.efeito(p);
        p.usarhabilidade(4, m, t4);
        System.out.println();
        System.out.println("-----------------");
    }
    
    
    
    public static void main(String[] args) {
        Mapas m = new Mapas(7, 7); // Iniciando o mapa 7x7
        // Criando usuario
        User u = new User();
        u.setName("Jogador 1"); 
        
        User u2 = new User();
        u2.setName("Testes");
        // Criando personagens
        Personagem p = new Personagem("Laponico Alquimista", 0, 0);
        Personagem p2 = new Personagem("Anao Assassino", 1, 1);
        Personagem p3 = new Personagem("Dragonborn Bruxo", 2, 2);
        Personagem p4 = new Personagem("Elfo Cacador", 3, 3);
        Personagem p5 = new Personagem("Orc Cavaleiro", 4, 4);
        Personagem p6 = new Personagem("Tiefling Feiticeiro", 5, 5);
        Personagem p7 = new Personagem("Laponico Sacerdote", 6, 0);
        
        Personagem bonecoTestes = new Personagem("Boneco Testes", 4, 9);
        bonecoTestes.setVidaMaxima(10000);
        
        // Atribuindo os personagens ao usuario
        u.getPersonagensCriados().add(p);
        u.getPersonagensCriados().add(p2);
        u.getPersonagensCriados().add(p3);
        u.getPersonagensCriados().add(p4);
        u.getPersonagensCriados().add(p5);
        u.getParty().add(p);
        u.getParty().add(p2);
        u.getParty().add(p3);
        u.getParty().add(p4);
        u.getParty().add(p5);
        u.getPersonagensCriados().add(p6);
        u.getPersonagensCriados().add(p7);
        u.getParty().add(p6);
        u.getParty().add(p7);
        
        u2.getPersonagensCriados().add(bonecoTestes);
        u2.getParty().add(bonecoTestes);
        
        // Inserindo os personagens no mapa (x, y)
        m.insertOcupanteBloco(p, 0, 0);  // 0
        m.insertOcupanteBloco(p2, 2, 3); // 1
        m.insertOcupanteBloco(p3, 3, 4); // 2
        m.insertOcupanteBloco(p4, 3, 2); // 3 
        m.insertOcupanteBloco(p5, 4, 3); // 4
        m.insertOcupanteBloco(p6, 4, 2); // 5
        m.insertOcupanteBloco(p7, 4, 4); // 0
        
        m.insertOcupanteBloco(bonecoTestes, 3, 3);
        
        m.printMapa();
        System.out.println("");
        // Movimentacao dos personagens
        // Por enquanto cada um so pode mover em uma area de 3x3 a partir da posicao atual
        p.movimentarPersonagem(m, 1, 1);
        System.out.println("");
        p.movimentarPersonagem(m, 2, 2);
        System.out.println("");
        p.movimentarPersonagem(m, 3, 3); // Nao funciona pq vai ficar em cima de outro Personagem
        
        Espada e = new Espada();
        p.getEquipamento().setGlobal(e, u.getInventario());
        System.out.println("Equipando espada no " + p.getNome());
        Runa r = new Runa();
        p.getEquipamento().setGlobal(r, u.getInventario());
//        Espada e = new Espada();
//        p.getEquipamento().setGlobal(e, u.getInventario());
//        System.out.println("Equipando espada no " + p.getNome());
        PotionMana pm = new PotionMana(100, u.getInventario());
        
//        ArmaduraMetalica am = new ArmaduraMetalica();
//        p.getEquipamento().setGlobal(am, u2.getInventario());
        
        usarTodasHabilidades(p, m, bonecoTestes, p, p, bonecoTestes, pm);// "Laponico Alquimista",
        usarTodasHabilidades(p2, m, bonecoTestes, p2, p2, bonecoTestes, pm);// "Anao Assassino"
        usarTodasHabilidades(p3, m, bonecoTestes, p3, bonecoTestes, bonecoTestes, pm);// "Dragonborn Bruxo"
        usarTodasHabilidades(p4, m, bonecoTestes, p4, p4, bonecoTestes, pm);// "Elfo Cacador"
        usarTodasHabilidades(p5, m, bonecoTestes, p5, p5, bonecoTestes, pm);// "Orc Cavaleiro"
        usarTodasHabilidades(p6, m, bonecoTestes, p6, p6, bonecoTestes, pm);// "Tiefling Feiticeiro"
        usarTodasHabilidades(p7, m, bonecoTestes, p7, p7, bonecoTestes, pm);// "Laponico Sacerdote"


//        u.Party.add(p);
//        ArrayList<Object> usuarios = new ArrayList<Object>();
//        usuarios.add(u);
//        //Personagem p2 = new Personagem("Teste 2", 3, 2);
//        //System.out.println(p);
//        //User x = new User();
//        //x.inventario.add(new PedacoDePano());
//        //p.getEquipamento().setGlobal(x.inventario.get(0), x.inventario);
//        //p2.getClasse().habDano(p2, p);
//        //
//        //
//        //p.getRaca().HabUtility(p);
//        //System.out.println(p);
//        salvarArquivo(u, "usuario1.txt");
//        User u2 = carregarArquivo("usuario1.txt");
//        System.out.println(u2);
//        u2.listarParty();
         
         
    } 
} 
