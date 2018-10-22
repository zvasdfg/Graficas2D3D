import java.util.*;
public class Parametros{
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int [] vector=new int[args.length];
		for (int x=0;x<args.length ;x++ ) {
			vector[x]=Integer.parseInt(args[x]);
		}
		Arrays.sort(vector);
		for (int i=vector.length-1;i>=0 ;i-- ) {
			System.out.print(vector[i]+" ");
		}
	}
}