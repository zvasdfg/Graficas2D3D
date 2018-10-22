import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PuntoMedio extends JFrame{
    private BufferedImage buffer;
    private Graphics graPixel;
    public JPanel myJPanel;
    public PuntoMedio(){
        super("Bresenham Linea");
            setSize(500,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myJPanel =new JPanel();
	    add(myJPanel);
	    setVisible(true);
	    buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);     
    }
    
    public void paint (Graphics g){
        try {
            drawLine(250,0,0,500);
            drawLine(0,500,0,500);
            drawLine(250,250,0,500);
            drawLine(0,500,250,250);
        } catch (InterruptedException e) {
		e.printStackTrace();
		}
    }
    public void drawPixel(int x, int y, Color c){
	buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    
    public void drawLine(int x1, int y1,int x2, int y2) throws InterruptedException {
        int x, y, dx, dy, pk, A, B, pxlx, pxly;
        dx = (x2 - x1);
        dy = (y2 - y1);
        if (dy < 0) { 
          dy = -dy; 
          pxly = -1; 
        } 
        else {
          pxly = 1;
        }
        if (dx < 0) {  
          dx = -dx;  
          pxlx = -1; 
        } else {
          pxlx = 1;
        }

        x = x1;
        y = y1;
        drawPixel(x1,y1,Color.BLACK);
        
        if(dx>dy){
          pk = 2*dy - dx;
          A = 2*dy;
          B = 2*(dy-dx);
          while (x != x2){
            x = x + pxlx;
            if (pk < 0){
              pk = pk + A;
            } else {
              y = y + pxly + 1/2;
              pk = pk + B;
            }
            drawPixel(x,y,Color.BLACK);
          }
        } else {
          pk = 2*dx - dy;
          A = 2*dx;
          B = 2*(dx-dy);
          while (y != y2){
            y = y + pxly + 1/2;
            if (pk < 0){
              pk = pk + A;
            } else {
              x = x + pxlx;
              pk = pk + B;
            }
            Thread.sleep(1);                              
            drawPixel(x,y,Color.BLACK);
          }
        }
    }

    public static void main(String[] args) {
        new PuntoMedio();
    }
    
}

