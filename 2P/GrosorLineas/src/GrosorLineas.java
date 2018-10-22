import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrosorLineas extends JFrame {
	 private BufferedImage buffer;
	 public JPanel myJPanel;

	public static void main(String[] args) {
		new GrosorLineas();
	}
	
	public GrosorLineas(){
		super("GROSOR DE LINEAS");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJPanel =new JPanel();
	    add(myJPanel);
	    setVisible(true);
	    buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);
	}
	public void paint (Graphics g){
		try {
			drawLine(0,100,500,100);
			drawLine(0,150,500,150);
			
			drawLine(0,200,500,200);
			drawLine(0,250,500,250);
			
			drawLine(0,300,500,300);
			drawLine(0,350,500,350);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawPixel(int x, int y, Color c){
		buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
	}
	
	
	public void drawLine(int x1, int y1, int x2, int y2) throws InterruptedException{
		int dx= x2 - x1, dy= y2 - y1;
		int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
		float Xinc = dx / (float) steps;
	    float Yinc = dy / (float) steps;
	    int X = x1;
	    int Y = y1;
	    for (int i = 0; i <= steps; i++)
	    {
	    	 drawPixel(X,Y,Color.red);
	    	if(dy > dx) { drawPixel(X+1,Y,Color.red);}
	    	else if (dx < dy) {
	    		 drawPixel(X,Y+1,Color.red);
	    	}else if (dx == dy){
	    		 drawPixel(X,Y+1,Color.red);
	    	}else if (x2==y1){
	    		drawPixel(X+1,Y,Color.red);
	    	}else {
	    		drawPixel(X+1,Y,Color.red);
	    	}
	        //System.out.println("Esto vale: " + Xinc + " Xinc");
	        X += Xinc;           // increment in x at each step
	        //System.out.println("Esto vale: " + X + " X");
	        //System.out.println("Esto vale: " + Yinc + " Yinc");
	        Y += Yinc;           // increment in y at each step
	        //System.out.println("Esto vale: " + Y + " Y");
	        //Thread.sleep(50); // for visualization of line-
	    }
	}

}
