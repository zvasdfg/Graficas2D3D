
import java.awt.*;
import javax.swing.*;
public class VisorDeImagenes extends JFrame{
	public JScrollPane panel;
	public Pantalla pantalla;

	public VisorDeImagenes(String archivo){
     super("Visor De Imagenes");

     Image img = Toolkit.getDefaultToolkit().getImage(archivo);
     pantalla = new Pantalla(img);
     panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     getContentPane().add(panel);
     panel.setViewportView(pantalla);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(200,200);
     setVisible(true);
	}
   public static void main(String[] args) {
   new VisorDeImagenes("C:/Users/isaac/Documents/CETI/6to/Graficas 2D3D/1P/Practicas/batman.png");
   }
}