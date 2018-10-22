import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircunferenciaBressenham extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;
	public static void main(String[] args) {
		new CircunferenciaBressenham();
	}
	
	public CircunferenciaBressenham(){
		super("Circunferencia Bresenham");
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
		int x = -radio, y = 0, err = 2-2*radio; /* II. Quadrant */
		do
		{
                    Thread.sleep(1); 
		drawPixel(xc-x, yc+y, Color.BLACK);
                    Thread.sleep(1);
		drawPixel(xc-y, yc-x,  Color.YELLOW);
                    Thread.sleep(1);
		drawPixel(xc+x, yc-y,  Color.BLACK); 
                    Thread.sleep(1); 
		drawPixel(xc+y, yc+x,  Color.YELLOW);
		radio = err;
		if
		(radio > x) err += ++x*2+1; 
		if
		(radio <= y) err += ++y*2+1; 
                }
		while
		(x < 0);
	}
}
