import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Polar extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;
	public static void main(String[] args) {
		new Polar();
	}
	public Polar(){
		super("Coordenadas Polares");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJPanel =new JPanel();
	    add(myJPanel);
	    setVisible(true);
	    buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);
	}
	public void paint (Graphics g){
		try {
			drawCicle(150,200,200,1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void drawPixel(int x, int y, Color c){
		buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
	}
	public void drawCicle(int r, int xc, int yc, int d) throws InterruptedException{
	     double theta = Math.toRadians(0);
	        int x = r;
	        int y = 0;
	        while (theta <= 2*Math.PI) {	     
                    Thread.sleep(1);
	            this.drawPixel(x + xc, y + yc, Color.BLACK);
	            theta=theta+Math.toRadians(0.5);
	            double xd = r * Math.cos(theta);
	            x = (int) Math.round(xd);
	            double yd = r * Math.sin(theta);
	            y = (int) yd;
	        }
	}
}
