import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Clock extends JFrame {

  public Clock() {
    ClockPanel container = new ClockPanel();
    add(container, BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new Clock();
  }
}

class ClockPanel extends JPanel implements Runnable {
  Thread t = new Thread(this);

 //Posiciones (X,Y) De las Manecillas
  int segunderoX, segunderoy, minuteroX, minuteroY, horarioX, horarioY;
//Tamaño del Reloj
  int tamX = 500;
  int tamY = 500;
//Tamaño de las Manecillas
  int tamSegundero = tamX / 2 - 50;
  int tamMinutero = tamX / 2 - 70;
  int tamHorario = tamX / 2 - 100;

//Distancia desde el Centro para los puntos
  int distanciaDesdeCentro = tamX / 2 - 40;
//Tamaño de los Puntos
  public int PuntoGrande = 10;
  public int PuntoChico = 5;
  
  public ClockPanel() {
    setPreferredSize(new Dimension(tamX, tamY));
    setLayout(null);
    t.start();
  }

  public void run(){
    while(true){
      try{
        int SegundoActual = Calendar.getInstance().get(Calendar.SECOND);
        int MinutoActual = Calendar.getInstance().get(Calendar.MINUTE);
        int HoraActual = Calendar.getInstance().get(Calendar.HOUR);

        segunderoX = minToLocation(SegundoActual, tamSegundero).x;
        segunderoy = minToLocation(SegundoActual, tamSegundero).y;
        minuteroX = minToLocation(MinutoActual, tamMinutero).x;
        minuteroY = minToLocation(MinutoActual, tamMinutero).y;
        horarioX = minToLocation(HoraActual*5, tamHorario).x;
        horarioY = minToLocation(HoraActual*5, tamHorario).y;
        repaint();
        Thread.sleep(1000);
      } catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
  
  protected void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g2.clearRect(0, 0, getWidth(), getHeight());
    // Dibujar Puntos
    for (int i = 0; i < 60; i++) {
      
      Point coordenadas = minToLocation(i, distanciaDesdeCentro);
      g2.setColor(Color.DARK_GRAY);
      
      if (i % 5 == 0) {
        g2.fillOval(coordenadas.x - (PuntoGrande / 2),coordenadas.y - (PuntoGrande / 2),PuntoGrande,PuntoGrande);
      } else {
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(coordenadas.x - (PuntoChico / 2),coordenadas.y - (PuntoChico / 2),PuntoChico,PuntoChico);
      }
    }
    // Manecillas
    g2.setColor(Color.black);
    g2.setStroke(new BasicStroke( 10 ));
    g2.drawLine(segunderoX-1, segunderoy-1/2, segunderoX, segunderoy);
    g2.setStroke(new BasicStroke( 2 ));
    //g2.drawLine(tamX/2, tamY/2, segunderoX, segunderoy);
    g2.setStroke(new BasicStroke( 15 ));
    g2.drawLine(minuteroX -1 , minuteroY-1 / 2, minuteroX, minuteroY);
    g2.setStroke(new BasicStroke( 4 ));
   // g2.drawLine(tamX/2, tamY/2, minuteroX, minuteroY);
    g2.setStroke(new BasicStroke( 18 ));
    g2.setColor(Color.RED);
    g2.drawLine(horarioX-1, horarioY-1 / 2, horarioX, horarioY);
    g2.setStroke(new BasicStroke( 8 ));
    //g2.drawLine(tamX/2, tamY/2, horarioX, horarioY);
    //g2.fillOval((tamX/2)-10,(tamY/2)-10,20,20);
  }
  private Point minToLocation(int timeStep, int radius) {
    double t = 2 * Math.PI * (timeStep-15) / 60;
    int x = (int)(tamX / 2 + radius * Math.cos(t));
    int y = (int)(tamY / 2 + radius * Math.sin(t));
    return new Point(x, y);
  }    
}