package projetolp1.Misc;


import java.util.Random;

public class Rand{

private static Random Aleatorio = new Random(System.currentTimeMillis());

public static int New(){
  return Aleatorio.nextInt();
}

}