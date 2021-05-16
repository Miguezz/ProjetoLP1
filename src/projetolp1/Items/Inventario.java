/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Batata
 */
public class Inventario implements Serializable{
    
    private ArrayList<Item> arrayItem = new ArrayList<Item>();
    
    public int add(Item z){
       if(z.getQuantidade() > 0){
        arrayItem.add(z);
        return 1;
       }else return -1;
       
    }
    
    public int remove(Item a){
    arrayItem.remove(a);
    return 1;
    }
    public int remove(int a){
        arrayItem.remove(a);    // essas funcoes ja existem no ArrayList, 
                                //mas podemos acessar elas pelo inventario assim
    return 1;  
    }
    
    public Item get(int a){
        return arrayItem.get(a);
    }
    
    public int set(int a, Item x){
        arrayItem.set(a,x);
    return 1;
    }
    
    
    public int find(Item x){
    for(int cont = 0; cont < arrayItem.size() ; cont++){ 		      
        if(arrayItem.get(cont).getClass().getName().equals(x.getClass().getName())) return cont;   
        }
    return -1;
    }
    
    
    
}
