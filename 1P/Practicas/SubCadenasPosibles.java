import java.util.*;
public class SubCadenasPosibles{
	public static void main(String[] args) {
		Scanner leer= new Scanner(System.in);
			int tamano=args.length;
			int reduccion=tamano+1;
			int inicio=-1;
			System.out.println("1 - Izquierda a Derecha  |  2 - Derecha a -Izquierda");
       		int opcion=leer.nextInt();
		switch(opcion){
			case 1:
                 for (int x=0;x<tamano ;x++ ) {
			 	  inicio++;
			 	  System.out.println();
			 	for (int y=inicio;y<args.length ;y++ ) {
			 		System.out.print(args[y]);
			 	}
			 	
			 }
			break;
			case 2:
			 for (int x=0;x<tamano ;x++ ) {
			 	  reduccion--;
			 	  System.out.println();
			 	for (int y=0;y<reduccion ;y++ ) {
			 		System.out.print(args[y]);
			 	}
			 	
			 }
			break;
		}
	}
}