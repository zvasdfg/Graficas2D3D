import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lados8 extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;
	public static void main(String[] args) {
		new Lados8();
	}
	
	public Lados8(){
		super("Simetria 8 Lados");
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
	
	public void drawCicle(int r, int xc, int yc) throws InterruptedException{
		 int x,y;
		  double yr;
		  x = 0;
		  y = r;
		  yr = r;
		  drawPixel(xc+x,yc+y,Color.BLACK);
		  while (x < yr){
		    x = x + 1;
		    yr = Math.sqrt(r*r-x*x);
		    y = (int)Math.round(yr);
                    Thread.sleep(2);                  
		    drawPixel(xc+x,yc+y,Color.BLACK);
                    Thread.sleep(2);                                        
		    drawPixel(xc-x,yc+y,Color.YELLOW);
                    Thread.sleep(2);
		    drawPixel(xc+x,yc-y,Color.YELLOW);
                    Thread.sleep(2);
		    drawPixel(xc-x,yc-y,Color.BLACK);
                    Thread.sleep(2);
		    drawPixel(xc+y,yc+x,Color.YELLOW);
                    Thread.sleep(2);
		    drawPixel(xc-y,yc+x,Color.BLACK);
                    Thread.sleep(2);
		    drawPixel(xc+y,yc-x,Color.BLACK);
                    Thread.sleep(2);
		    drawPixel(xc-y,yc-x,Color.YELLOW);
		  }
	}
}
