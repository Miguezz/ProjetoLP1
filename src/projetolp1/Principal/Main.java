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
				User u = new User();
				u.setName("Jogador 1");
        Personagem p = new Personagem("Teste 1", 1, 0);
				u.PersonagensCriados.add(p);
				u.Party.add(p);
				ArrayList<Object> usuarios = new ArrayList<Object>();
				usuarios.add(u);
        //Personagem p2 = new Personagem("Teste 2", 3, 2);
        //System.out.println(p);
        //User x = new User();
        //x.inventario.add(new PedacoDePano());
        //p.getEquipamento().setGlobal(x.inventario.get(0), x.inventario);
        //p2.getClasse().habDano(p2, p);
        //
        //
        //p.getRaca().HabUtility(p);
        //System.out.println(p);
				salvarArquivo(u, "usuario1.txt");
				User u2 = carregarArquivo("usuario1.txt");
				System.out.println(u2);
				u2.listarParty();
		} 
} 
