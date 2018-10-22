import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bresenham extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;

	public static void main(String[] args) {
		new Bresenham();
	}
	public Bresenham(){
		super("LINEA BRESENHAM");
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
	
	public void drawLine(int x1, int x2, int y1, int y2) throws InterruptedException{
            int d = 0;
            int dy = Math.abs(y2 - y1);
            int dx = Math.abs(x2 - x1); 
            int dy2 = dy;
            int dx2 = dx; 
            int ix = x1 < x2 ? 1 : -1;
            int iy = y1 < y2 ? 1 : -1;
 
        if (dy <= dx) {
            for (int i=0; i<=x2; i++) {
            	Thread.sleep(1);
            	drawPixel(x1, y1, Color.BLACK);
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (int i=0; i<=y2; i++) {
            	Thread.sleep(1);
                drawPixel(x1, y1, Color.BLACK);
                y1 += iy;
                d += dx2;
                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        } 
	}

}

