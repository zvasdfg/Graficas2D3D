package figuras;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

 class Figuras extends JFrame {
	private BufferedImage buffer;
	private Graphics graPixel;
	public JPanel myJPanel;
	public Figuras(){
		super("Figuras");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJPanel =new JPanel();
		add(myJPanel);
		setVisible(true);
		buffer =new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
		graPixel = (Graphics2D) buffer.createGraphics();		
	}
	public void paint(Graphics g1){
		bressLinea(1,250,250,1,Color.RED);
		//bressLinea(500,0,250,500,Color.black);
		//bressLinea(0,40,500,40,Color.black);
		rectangulo(10,40,490,490,Color.RED);
		rectangulo(20,50,480,480,Color.black);
		//elipse(300,300,70,100);
		//elipse(300,300,50,90);
		//elipse(300,300,30,80);
		//elipse(300,300,10,70);
		for(int crs=10;crs<100;crs+=10)
			circPmedio(600,600,crs);
	}
	public void drawPixel(int x,int y, Color c){
		buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer,x,y, this);
	}
	public void bressLinea(int x1, int y1,int x2, int y2, Color c){
		buffer.setRGB(0,0,c.getRGB());
		this.getGraphics().drawImage(buffer,x1,y1,this);
		int a,b,pk,aux,yk=y1,xk=x1;
		if(Math.abs(x2-x1)>Math.abs(y2-y1))
		{
			a=2*Math.abs(y2-y1);
			b=(2*Math.abs(y2-y1))-(2*Math.abs(x2-x1));
			pk=(2*Math.abs(y2-y1))-(Math.abs(x2-x1));
			if(x2<x1)
			{
				aux=x2;
				x2=x1;
				x1=aux;
			}
			for(xk=x1;xk<x2;xk++)
			{
				if(pk<0)
				{
					this.getGraphics().drawImage(buffer,xk,yk,this);
					pk+=a;
				}
				else
				{
					if(y2>y1)
						this.getGraphics().drawImage(buffer,xk,++yk,this);
					else
						this.getGraphics().drawImage(buffer,xk,--yk,this);
					pk+=b;
				}
			}
		}
		else if(Math.abs(x2-x1)<Math.abs(y2-y1))
		{
			a=2*Math.abs(x2-x1);
			b=(2*Math.abs(x2-x1))-(2*Math.abs(y2-y1));
			pk=(2*Math.abs(x2-x1))-(Math.abs(y2-y1));
			if(y2<y1)
			{
				aux=y2;
				y2=y1;
				y1=aux;
			}
			for(yk=y1;yk<y2;yk++)
			{
				if(pk<0)
				{
					this.getGraphics().drawImage(buffer,xk,yk,this);
					pk+=a;
				}
				else
				{
					if(x2>x1)
						this.getGraphics().drawImage(buffer,++xk,yk,this);
					else
						this.getGraphics().drawImage(buffer,--xk,yk,this);
					pk+=b;
				}
			}
		}
	}
	public void rectangulo(int x1, int y1,int x2, int y2, Color c){
		bressLinea(x1,y1,x2,y1,c);//linea x1,y1,x2,y1
		bressLinea(x2,y1,x2,y2,c);//linea x2,y1,x2,y2
		bressLinea(x1,y2,x2,y2,c);//linea x1,y2,x2,y2
		bressLinea(x1,y1,x1,y2,c);//linea x1,y1,x1,y2
	}
	public void circPmedio(int xc, int yc,double radio){
		double pk,x,y;
		x = 0;
		y = radio;
		drawPixel((int)Math.round(x),(int)Math.round(y),Color.black);
		pk=(double)5/4-radio;
		for(x=0;x<y;x++)
		{
                    try {
                        if (pk < 0)
                            pk = pk + 2*x + 1;
                        else {
                            y = y - 1;
                            pk = pk + 2*(x - y) + 1;
                        }
                        drawPixel((int)Math.round(xc+x),(int)Math.round(yc+y),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(xc-x),(int)Math.round(yc+y),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(xc+x),(int)Math.round(yc-y),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(xc-x),(int)Math.round(yc-y),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(yc+y),(int)Math.round(xc+x),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(yc-y),(int)Math.round(xc+x),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(yc+y),(int)Math.round(xc-x),Color.black);
                        Thread.sleep(1);
                        drawPixel((int)Math.round(yc-y),(int)Math.round(xc-x),Color.black);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Figuras.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
	}
	public void elipse(int xc, int yc, int ry, int rx){
	 int x, y, p, px, py;
	 int rx2, ry2, tworx2, twory2;
	 ry2 = ry*ry;
	 rx2 = rx*rx;
	 twory2 = 2 * ry2;
	 tworx2 = 2 * rx2;
	/* regi�n 1 */
	 x = 0;
	 y = ry;
	 drawPixel(x+xc,y+yc,Color.black);
	 p = (int)Math.round(ry2 - rx2*ry + 0.25*rx2);
	 px = 0;
	 py = tworx2*y;
	 while (px < py) { /* se cicla hasta trazar la regi�n 1 */
	   x = x + 1;
	   px = px + twory2;
	   if (p < 0)
	     p = p + ry2 + px;
	   else {
	     y = y - 1;
	     py = py - tworx2;
	     p = p + ry2 + px - py;
	   }
	   drawPixel(x+xc,y+yc,Color.black);
	   drawPixel(-x+xc,y+yc,Color.black);
	   drawPixel(x+xc,-y+yc,Color.black);
	   drawPixel(-x+xc,-y+yc,Color.black);
	 }
	/* regi�n 2 */
	 p = (int)Math.round(ry2*(x+0.5)*(x+0.5) + rx2*(y-1)*(y-1) - rx2*ry2);
	 px = 0;
	 py = tworx2*y;
	 while (y > 0) { /* se cicla hasta trazar la regi�n 2 */
	   y = y - 1;
	   py = py - tworx2;
	   if (p > 0)
	     p = p + rx2 - py;
	   else {
	     x = x + 1;
	     px = px + twory2;
	     p = p + rx2 + py + px;
	   }
	   drawPixel(x+xc,y+yc,Color.black);
	   drawPixel(-x+xc,y+yc,Color.black);
	   drawPixel(x+xc,-y+yc,Color.black);
	   drawPixel(-x+xc,-y+yc,Color.black);
	 }
}
	public static void main(String[] args) {
		new Figuras();
	};
}