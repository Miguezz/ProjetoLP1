/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;
import projetolp1.Items.Equipamento.PedacoDePano;
import projetolp1.Principal.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 


    public static void main(String[] args) {
        Mapas m = new Mapas(7, 7);
        User u = new User();
        u.setName("Jogador 1");
        User u2 = new User();
        u.setName("Jogador 2");
        Personagem p = new Personagem("Personagem 1", 0, 0);
        Personagem p2 = new Personagem("Personagem 2", 1, 1);
        Personagem p3 = new Personagem("Personagem 3", 2, 2);
        Personagem p4 = new Personagem("Personagem 4", 3, 3);
        Personagem p5 = new Personagem("Personagem 5", 4, 4);
        
        Personagem p6 = new Personagem("Personagem 6", 5, 5);
        Personagem p7 = new Personagem("Personagem 7", 1, 5);
        Personagem p8 = new Personagem("Personagem 8", 2, 4);
        Personagem p9 = new Personagem("Personagem 9", 3, 6);
        Personagem p10 = new Personagem("Personagem 10", 1, 3);
        
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
        
        u2.getPersonagensCriados().add(p6);
        u2.getPersonagensCriados().add(p7);
        u2.getPersonagensCriados().add(p8);
        u2.getPersonagensCriados().add(p9);
        u2.getPersonagensCriados().add(p10);
        u2.getParty().add(p6);
        u2.getParty().add(p7);
        u2.getParty().add(p8);
        u2.getParty().add(p9);
        u2.getParty().add(p10);
        
        m.insertOcupanteBloco(p, 0, 0);
        m.insertOcupanteBloco(p2, 1, 0);
        m.insertOcupanteBloco(p3, 2, 0);
        m.insertOcupanteBloco(p4, 3, 0);
        m.insertOcupanteBloco(p5, 4, 0);
        
        m.insertOcupanteBloco(p6, 6, 6);
        m.insertOcupanteBloco(p7, 6, 5);
        m.insertOcupanteBloco(p8, 6, 4);
        m.insertOcupanteBloco(p9, 6, 3);
        m.insertOcupanteBloco(p10, 6, 2);
        
        m.printMapa();
        System.out.println("");
        
        p.movimentarPersonagem(m, 1, 2);
        p2.movimentarPersonagem(m, 2, 2);
        
        p6.movimentarPersonagem(m, 4, 3);
        p6.movimentarPersonagem(m, 2, 3);
        p6.movimentarPersonagem(m, 1, 3);
        p7.movimentarPersonagem(m, 4, 2);
        
        System.out.println(p);
        System.out.println("");
        System.out.println(p2);
        System.out.println("");
        System.out.println(p6);
        System.out.println("");
        System.out.println(p7);
        
        Espada e = new Espada();
        
        p.getEquipamento().setGlobal(e, u.getInventario());
        p.atacar(m, p6);
        System.out.println("P atacou P6 com uma espada");
        System.out.println("P6 atacou P com uma habilidade");
        p6.usarhabilidade(1, m, p);    
        System.out.println(p);
        System.out.println("");
        System.out.println(p6);
        
        p.endOfTurn();
        p6.endOfTurn();
        
        System.out.println(p);
        System.out.println("");
        System.out.println(p6);

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
