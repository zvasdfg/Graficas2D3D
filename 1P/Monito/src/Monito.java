import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Monito extends JFrame{
	public Monito(){
		super("Monito Graficas 2D 3D");
		this.setSize(200,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
	   
           //carita
           g.drawArc(35, 30, 80,80, 0, 360);
           g.drawArc(50, 70, 50, 30, 180, 180);
           g.fillOval(65,70,5, 5);
           g.fillOval(80, 70, 5, 5);
           //cuerpo
           g.drawLine(75,110,75,200);
           //brazos
           g.drawLine(75,120,45,160);
           g.drawLine(75,120,105,160);
          //piernitas
           g.drawLine(75,200,45,240);
           g.drawLine(75,200,105,240);
	}
        public static void main(String[] args){
            new Monito();
           
        }
}