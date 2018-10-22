public class NumeroAleatorio{
      public static void main(String arg[] ) {
		int random1,random2;
		random1=(int)(Math.random()*100);
		random2=(int)(Math.random()*100);
                System.out.println("El numero mayor es  "+ Math.max(random1,random2) +" De "+random1+" y "+ random2);
	}
}
