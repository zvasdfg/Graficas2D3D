import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuntoMedio extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;
	public static void main(String[] args) {
		new PuntoMedio();
	}
	
	public PuntoMedio(){
		super("Circunferencia Punto Medio");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJPanel =new JPanel();
	    add(myJPanel);
	    setVisible(true);
	    buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);
	}
	
	public void paint (Graphics g){
		try {
			drawCicle(100,250,250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void drawPixel(int x,int y, Color c){
		buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer,x,y, this);
	}
	
	public void drawCicle(int radio, int xc, int yc) throws InterruptedException{
		double pk,x,y;
		x = 0;
		y = radio;
		drawPixel((int)Math.round(x),(int)Math.round(y),Color.BLACK);
		pk=(double)5/4-radio;
		for(x=0;x<y;x++)
		{
		    if (pk < 0)
		      pk = pk + 2*x + 1;
		    else {
		      y = y - 1;
		      pk = pk + 2*(x - y) + 1;
		    }
                    Thread.sleep(1);                                        
		    drawPixel((int)Math.round(xc+x),(int)Math.round(yc+y),Color.BLACK);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc-x),(int)Math.round(yc+y),Color.BLACK);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc+x),(int)Math.round(yc-y),Color.YELLOW);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc-x),(int)Math.round(yc-y),Color.YELLOW);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc-y),(int)Math.round(yc+x),Color.BLACK);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc+y),(int)Math.round(yc+x),Color.BLACK);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc+y),(int)Math.round(yc-x),Color.YELLOW);
                    Thread.sleep(1); 
		    drawPixel((int)Math.round(xc-y),(int)Math.round(yc-x),Color.YELLOW);
		}
		
	}	

}
