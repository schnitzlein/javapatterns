
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame implements ActionListener{
  //FIXME: Liste nur bis Stelle 1 gehen oder undo redo anpassen
  //aus undo kann ab Listen Stelle 0 nicht wieder redo gemacht werden, Zugriff auf 0 verhindern und eine pos weniger
  //wäre quick and dirty
	
  Klient k = new Klient(0); 
  Aufrufer a = new Aufrufer();
  
  
  private Color color = new Color(255, 255, 255);
  Random random = new Random(); 
  private JTextField textf = new JTextField();
  private JButton b1 = new JButton("change Color");
  private JButton b2 = new JButton("redo");
  private JButton b3 = new JButton("undo");
  private JButton b4 = new JButton("print History");
  //private JButton b5 = new JButton("choose Color");
  //private JColorChooser jc = new JColorChooser();
  //Farben (RGB) 
  int r = 255; 
  int g = 255; 
  int b = 255; 
   

  
  public Color randomColor(){
   random = new Random();
   
   r = random.nextInt(255); 
   g = random.nextInt(255); 
   b = random.nextInt(255); 
     
    return new Color(r, g, b); 
  }
  
  
  public GUI(){
  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  
  int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    this.setLocation(x, y);
    this.setTitle("Command Pattern");
  
  this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JPanel buttons = new JPanel(new GridLayout(1,5));
    this.setLayout( new GridLayout(2,1) );
    this.setSize(230,130); //pack wird verwendet faellt also weg
    
    
    b2.setEnabled(false);
    b3.setEnabled(false);
    
    this.add(textf);
    
    this.add(buttons);
    buttons.add(b1);
    buttons.add(b2);
    buttons.add(b3);
    buttons.add(b4);
    //buttons.add(b5);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    //b5.addActionListener(this);
    
    k.getEmpfaenger().setzeEmpfaenger(textf);
    
    /*KonkreterBefehl first_cmd = new KonkreterBefehl(k.myEmpfaenger.getObject(),this.k.myEmpfaenger);
  first_cmd.setColor(new Color(255,255,255));
  a.doSth(first_cmd);*/
    
    
    this.setVisible(true);
    this.pack();
  }//Konstruktor
  
  
  
  public static void main(String[] args){
    new GUI();
  }



  @Override
  public void actionPerformed(ActionEvent ae) {
  //change Color
  if (ae.getActionCommand().equals("change Color")){
    //Change Color and add this change Color command bzw. neuen erzeugen
      color = randomColor();
    //textf.setBackground(color);
    textf.setText(color.toString());
        
      //
    //Befehl in Aufrufer commands pushen
    //
    KonkreterBefehl neu_cmd = new KonkreterBefehl(k.myEmpfaenger.getObject(),this.k.myEmpfaenger);
    neu_cmd.setColor(color);
      a.doSth(neu_cmd);
      a.deleteUndoCmds();  //eigenitlich uncool schränkt ein das ich nachdem ein neuer befehl kam ich nicht weiter zurück kann
      //
      //Befehl in Aufrufer commands pushen
      //
      
      //
      // Kram mit Liste
      //
      try {
      a.showLast().commandAction();
    } catch (Exception e) {
      System.out.println("Befehl konnte nicht geladen oder verarbeitet werden.");
      e.printStackTrace();
    }
      
      b3.setEnabled(true);   //undo an
      b2.setEnabled(false);  //redo aus
  }//change Color
  
  //redo
  if (ae.getActionCommand().equals("redo")){
    a.redo();
    try {
      a.showLast().commandAction();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (a.isRedoCmdsLeer()) b2.setEnabled(false);
    
  }//redo
  //undo
  if (ae.getActionCommand().equals("undo")){
    //

    if (a.getCmdsSize() == 1){
      textf.setBackground(new Color(255,255,255));
      textf.setText(textf.getBackground().toString());
      b3.setEnabled(false);
      b2.setEnabled(false);
      a.deleteCmds();
    } else {
      a.undo();
      b2.setEnabled(true);
      try {
        a.showLast().commandAction();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
  }//undo
  
  /*if (ae.getActionCommand().equals("choose Color")){
	 JDialog jd = new JDialog();
	 jd.setSize(500,400);
	 jd.getContentPane().add(jc);
	 jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 jd.setVisible(true);
	 
  }*/
  
  if (ae.getActionCommand().equals("print History")){
	  a.printHistory();
  }
  
  }//actionPerformed
  
}//GUI
