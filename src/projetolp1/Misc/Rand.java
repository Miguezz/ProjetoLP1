package projetolp1.Misc;


import java.util.Random;
import java.io.Serializable;
public class Rand implements Serializable{

private static Random Aleatorio = new Random(System.currentTimeMillis());

	public static int New(){
		return Aleatorio.nextInt();
	}

}
