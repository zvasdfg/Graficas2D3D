package ventana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static javafx.scene.paint.Color.color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	 private BufferedImage buffer;
	 private Graphics graPixel;  
	 public JPanel JPanel;
	    
	    public Ventana() {
	        super("Linea");
	        setSize(500,500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel =new JPanel();
	        add(JPanel);
	        setVisible(true);
	        buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);
	    }
	   
	    public static void main(String[] args) {
	        new Ventana();
	    }
	    
	    public void paint (Graphics g){
	       
	       drawLinePixel(0,240,500,240);
               drawLinePixel(500,260,0,260);
               drawLinePixel(400,100,100,400);
               drawLinePixel(500,0,0,500);
               drawLinePixel(240,0,240,500);
               drawLinePixel(260,500,260,0);
               paintPixel(250,250,Color.RED);
	    }
	    
	    public void paintPixel(int x, int y, Color c){
	        buffer.setRGB(0, 0, c.getRGB());
	        this.getGraphics().drawImage(buffer, x, y, this);
	    }
	    public void drawLinePixel(int x1, int y1,int x2, int y2){
	        if(x1==x2){
	        	if(y1 < y2 ){
		            for(int y=y1; y<y2; y++){
		                int x = x1;
		                paintPixel(x,y,Color.BLACK);
		            	}
	            }else {
		        	for(int y=y1; y>y2; y--){
		                int x = x1;
		                paintPixel(x,y,Color.BLACK);
		            } 
	            } 
	        }else if (y1==y2 || x1 == y2 || x1==y1) {
	            int dx=x2-x1, dy=y2-y1;
	            int m=dy/dx, b=y1-m*x1;
	            if(x1 < x2 || x1 < y2 || x1==y1){
		            for(int x=x1; x<x2; x++){
		                float y = m*x+b;
		                paintPixel(x,Math.round(y), Color.BLACK);
		            }
		       }else {
		            for(int x=x1; x>x2; x--){
		                float y = m*x+b;
		                paintPixel(x,Math.round(y), Color.BLACK);
		            }
	           }
	        }
	    }
}