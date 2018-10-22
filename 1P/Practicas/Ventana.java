import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ventana extends Frame{
	public Ventana(){
		super("Ventana");
		 setSize(500,600);
		 setVisible(true);
	         addWindowListener(new WindowAdapter() {
                 public void windowClosing(WindowEvent e) {
     						System.exit(0);
   						}
					 });
	}

	public static void main(String[] args) {
		new Ventana();
	}
}