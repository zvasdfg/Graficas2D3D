import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

 class TiposLineas extends JFrame {
	private BufferedImage buffer;
	private Graphics graPixel;
	public JPanel myJPanel;
	public int[] masc = new int [4];
	public TiposLineas(){
		super("Tipos de Linea");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJPanel =new JPanel();
		add(myJPanel);
		setVisible(true);
		buffer =new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
		graPixel = (Graphics2D) buffer.createGraphics();		
	}
	public void paint(Graphics g1){
		setmask(1,1,1,1);
		tipoLinea(0,50,500,50,Color.BLACK,masc);
		setmask(1,1,1,0);
		tipoLinea(0,100,500,100,Color.BLACK,masc);
		setmask(1,1,0,1);
		tipoLinea(0,150,500,150,Color.BLACK,masc);
		setmask(1,1,0,0);
		tipoLinea(0,200,500,200,Color.BLACK,masc);
		setmask(1,0,1,1);
		tipoLinea(0,250,500,250,Color.BLACK,masc);
		setmask(1,0,1,0);
		tipoLinea(0,300,500,300,Color.BLACK,masc);
		setmask(1,0,0,1);
		tipoLinea(0,350,500,350,Color.BLACK,masc);
		setmask(1,0,0,0);
		tipoLinea(0,400,500,400,Color.BLACK,masc);
	}
	public void drawPixel(int x, int y, Color c){
		buffer.setRGB(0,0,c.getRGB());
		this.getGraphics().drawImage(buffer,x,y,this);
	}

	public void setmask(int v1,int v2,int v3,int v4)
	{
		masc[0]=v1;
		masc[1]=v2;
		masc[2]=v3;
		masc[3]=v4;
	}
 	private void tipoLinea(float x1, float y1, float x2, float y2, Color c, int[] masc) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float steps; 
        int cont = 0;
        if (Math.abs(dx) > Math.abs(dy))
            steps = Math.abs(dx);
        else steps = Math.abs(dy);
        float xinc = dx / steps;
        float yinc = dy / steps;
        float x = x1, y = y1;
        drawPixel(Math.round(x), Math.round(y), c);
        for (int k = 1; k <= steps; k++){
            x += xinc;
            y += yinc;
            if(cont == masc.length) 
            	cont = 0;
            if (masc[cont] == 1) 
            	drawPixel(Math.round(x), Math.round(y), c);
            cont++;
        }
    }   
	public static void main(String[] args) {
		 new TiposLineas();
	};
}

