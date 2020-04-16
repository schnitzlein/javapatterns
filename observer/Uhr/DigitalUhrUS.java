package Uhr;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.GridLayout;

//VIEW2

public class DigitalUhrUS extends JFrame implements IObserver {
	   // fuer Uhr Program und GUI
	   private JLabel label = new JLabel(""); 
	   SimpleDateFormat sdfmt = new SimpleDateFormat();
	   private Font font = new Font("Verdana", Font.PLAIN, 20);
	
	   protected UhrVerwalter myUhr = null;
	 
	 //Konstruktor of JFrame
	   public DigitalUhrUS(String uhrFormat){
		   setTitle("US Zeit des Tages Uhr");
		    
		    sdfmt.applyPattern(uhrFormat);
		    
		    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		    this.setLayout( new GridLayout(2,2) );
		    this.setSize(200,120);
		    label.setFont(font);
		    
		    this.add(label);	
		    this.setVisible(true);
	  }
	   
	   
	   public void setzeSubjekt(UhrVerwalter s) {
	     if (this.myUhr != null)
	       this.myUhr.delete(this);
	 
	     this.myUhr = s;
	 
	     if (this.myUhr != null)
	       this.myUhr.register(this);
	   }
	 
	   public void update() {
	     //System.out.println(this.myUhr.gibZustand());

		 label.setText(sdfmt.format(myUhr.getDate()).toString());
	   } 
	
}