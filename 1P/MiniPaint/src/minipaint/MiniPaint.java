package minipaint;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MiniPaint extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{



    private ButtonGroup modos;
    private JPanel area;
    private JLabel status;
    private Image buffer;
    private Image temporal;

    private final int PUNTOS=1;
    private final int LINEAS=2;
    private final int RECTANGULOS=3;
    private final int CIRCULOS=4;
    private int modo;
    private int x,y;


    public MiniPaint  () {
        super("MiniPaint");
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo= new JMenu("Archivo");

        JMenuItem opcionNuevo = new JMenuItem("Nuevo", 'N');
        opcionNuevo.addActionListener(this);
        opcionNuevo.setActionCommand("Nuevo");
        menuArchivo.add(opcionNuevo);

        menuArchivo.addSeparator();

        JMenuItem opcionSalir = new JMenuItem("Salir",'S');
        opcionSalir.addActionListener(this);
        opcionSalir.setActionCommand("Salir");
        menuArchivo.add(opcionSalir);

        menuBar.add(menuArchivo);

        modos = new ButtonGroup();
        //Opcion Puntos
        JMenu menuModo = new JMenu("Modo");
        JRadioButtonMenuItem opcionPuntos = new 
        JRadioButtonMenuItem("Puntos",true);
        opcionPuntos.addActionListener(this);
        opcionPuntos.setActionCommand("Puntos");
        menuModo.add(opcionPuntos);

        modos.add(opcionPuntos);
        //OPcion Lineas
        JRadioButtonMenuItem opcionLineas = new 
        JRadioButtonMenuItem("Lineas");
        opcionLineas.addActionListener(this);
        opcionLineas.setActionCommand("Lineas");
        menuModo.add(opcionLineas);
        modos.add(opcionLineas);

        //Opcion Rectangulo

        JRadioButtonMenuItem opcionRectangulos = new
        JRadioButtonMenuItem("Rectangulos");
        opcionRectangulos.addActionListener(this);
        opcionRectangulos.setActionCommand("Rectangulos");
        menuModo.add(opcionRectangulos);
        modos.add(opcionRectangulos);

        //Opcion Circulos

        JRadioButtonMenuItem opcionCirculos = new
        JRadioButtonMenuItem("Circulos");
        opcionCirculos.addActionListener(this);
        opcionCirculos.setActionCommand("Circulos");
        menuModo.add(opcionCirculos);
        menuBar.add(menuModo);

        area = new JPanel();
        area.addMouseListener(this);
        area.addMouseMotionListener(this);
        status = new JLabel("Status",JLabel.LEFT);
        //ASIGNAR BARRA MENUS   
        setJMenuBar(menuBar);
        //Agregar zona Grafica
        getContentPane().add(area,BorderLayout.CENTER);
        //Agregar barra de estado.
        getContentPane().add(status,BorderLayout.SOUTH);
        modo = PUNTOS;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
        buffer = area.createImage(area.getWidth(),area.getHeight());
    }

    public void actionPerformed( ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals("Nuevo")){
area.getGraphics().clearRect(0,0,area.getWidth(), area.getHeight());
         }else
         if(comando.equals("Salir")){
             if(JOptionPane.showConfirmDialog(this,"En verdad desea Salir","Confirmacion",JOptionPane.YES_NO_OPTION)==
             JOptionPane.YES_OPTION){
                dispose();
                System.exit(0);
             }
         }else 
         if (comando.equals("Puntos")) {
             modo=PUNTOS;   
         }else
         if (comando.equals("Lineas")) {
             modo=LINEAS;
         }
         else if (comando.equals("Circulos"))
         {
             modo=CIRCULOS;
         }
        else
         {
             modo=RECTANGULOS;
         }
                

    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e){
        x=e.getX();
        y=e.getY();
        temporal= area.createImage(area.getWidth(),area.getHeight());
        temporal.getGraphics().drawImage(buffer,0,0,this);

    }
    public void mouseReleased(MouseEvent e) {
        buffer.getGraphics().drawImage(buffer,0,0,this);
    }
    public void mouseEntered(MouseEvent e){

        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
        
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = temporal.getGraphics();
        switch (modo) {
            case PUNTOS:
                g.fillRect(e.getX(),e.getY(),5,5);
                 area.getGraphics().drawImage(temporal,0,0,this);
                break;
            case LINEAS:
                g.drawImage(buffer,0,0,area);
                g.drawLine(x,y,e.getX(),e.getY());
                area.getGraphics().drawImage(temporal,0,0,this);
                break;
            case RECTANGULOS:
                 g.drawImage(buffer,0,0,area);
                g.drawRect(x,y,e.getX()-x,e.getY()-y);
                area.getGraphics().drawImage(temporal,0,0,this);
                break;
                case CIRCULOS:
                 g.drawImage(buffer,0,0,area);
                g.drawOval(x,y,e.getX()-x,e.getY()-y);
                area.getGraphics().drawImage(temporal,0,0,this);
                break;
            default:
                break;
        }
    }
    public void mouseMoved(MouseEvent e){
        status.setText("x="+e.getX()+ ",y="+e.getY());

    }
    public static void main(String[] args) {
        new MiniPaint();
    }
}

