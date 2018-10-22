import java.util.regex.*;
public class Hex2IP{
	public static void main(String[] args) {
		String op=args[0];
		String cadena=args[1];

		
		switch(op){
			case "-hex":
        	Pattern pat=Pattern.compile("[A-F0-9]*");
        	Matcher mat=pat.matcher(cadena);
        	String comparador[]=new String[4];
        	if (mat.matches()&&cadena.length()==8) {
        		int y=0;
        		for (int x=0;x<4;x++ ) {
        			comparador[x]=cadena.substring(y,y+2);
        			y=y+2;
        		}
        		
        		for (int x=0;x<4 ;x++ ) {
        			int num= Integer.parseInt(comparador[0],16);
        			int num2=Integer.parseInt(comparador[3],16);
        	//if(num<255 && num2!=0)
        		System.out.print(Integer.parseInt(comparador[x],16)+".");
        //	else {
        			//System.out.println("Error No puede ser convertida");
        		//	break;
        		 // }

        		}
        	  }
        	 else
        	 	System.out.println("Error Quiza es mayor a 8 o una letra no es valida");
			break;
			case "-ip":
			String ipv=args[1];
			String hex = "";
			int decimal;
			boolean imp=true;
			String[] PartirCadena = ipv.split("[.,]");
			if (PartirCadena.length < 4) {
			System.out.println("Error");
			}
			
			for (int i = 0; i < 4; i++) {
			 decimal = Integer.parseInt(PartirCadena[i]);

			 if (decimal>256||decimal<0) {
			 	imp=false;
			 	System.out.println("Error no valido");
               
			 	
			 }
			 else{
			 if(decimal>1)
			 hex +=Integer.toHexString(decimal);
			 else
			 	hex +="0"+Integer.toHexString(decimal);
              }
          }
          if (imp==true) {
          	 System.out.print(hex);
          }
		
		
			break;

			
		}
	}
}