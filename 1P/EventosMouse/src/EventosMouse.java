import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventosMouse  extends JFrame implements MouseListener {
	 public JLabel label;
	 public EventosMouse( )
	    {
	        setTitle( "Eventos De Mouse" );
	        setResizable(false);
	        //setLocationRelativeTo(null); 
	        setVisible(true); 
	        setSize(200, 200 );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        label = new JLabel();
	        label.setBounds(200,200, 600, 600);
	        label.addMouseListener(this); 
	        add(label);
                 label.setForeground(Color.BLACK);
		}
	 public void mouseClicked(MouseEvent evento) {
	      label.setText("Presionado");
	      
	  
	 }
	 public void mouseEntered(MouseEvent evento) {
	      label.setText("En Foco" );
	  }

    @Override
    public void mousePressed(MouseEvent e) {
	  
        if (e.getButton()==1){ 
	     label.setText("Click Izquierdo");
	   }
	  else if (e.getButton()==3){
	     label.setText("Click Derecho");
          }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
         label.setText("Released");
    }

    @Override
    public void mouseExited(MouseEvent e) {
         label.setText("Fuera de Foco");
    }
    public static void main(String[] args) {
	     new  EventosMouse();
	   }

}
	   