package kaffeeladen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import obsPattern.ConcreteObserver;

//VIEW

public class GUI extends JFrame implements ActionListener {

	//ConcreteObservable bestellung = new ConcreteObservable();
	ConcreteObserver operator = new ConcreteObserver();
	
	Application a = new Application();
	
	private JButton b1 = new JButton("Neu");
	private JButton b2 = new JButton("Neue Zutat");
	private JButton b3 = new JButton("bezahlen");
	private JLabel platzhalter = new JLabel();
	private JButton platzhalter2 = new JButton("doppelte Menge");
	private JButton b4 = new JButton("Capuccino");
	private JButton b5 = new JButton("Latte Machiaccto");
	private JButton b6 = new JButton("doppelter Espresso");
	
	
	private JTextArea textArea = new JTextArea(5, 20);
	private JComboBox<String> cmb = new JComboBox<String>();
	private JComboBox<String> cmbZutat = new JComboBox<String>();
    
	
	public GUI(){
	  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	  int w = this.getSize().width;
	  int h = this.getSize().height;
	  int x = (dim.width-w)/2;
	  int y = (dim.height-h)/2;
	  this.setLocation(x, y);
      this.setTitle("Decoration Pattern");
	  this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  this.setSize(800,300);
	  
	  // *** //
	    
	  operator.setProduktListe(a.getList1());
	  
	  
	  // *** //
	  
	  platzhalter2.setEnabled(false);
	  
	  cmb.addItem("Kaffee");
	  cmb.addItem("Espresso");
	  cmb.addItem("Mocca");
	  
	//TODO: ComboBox von der Bestellung generieren lassen, abhängig von IKaffee
	  cmbZutat.addItem("Milch");
	  cmbZutat.addItem("Milchschaum"); //nur wenn keine Sahne
	  cmbZutat.addItem("Sahne");  //nur wenn kein Milchschaum
	  cmbZutat.addItem("Eis"); //nicht bei Espresso
	  cmbZutat.addItem("Zucker");
	  cmbZutat.addItem("Schokostreusel");
	  
	  textArea.setEditable(false);
	  JScrollPane scrollPane = new JScrollPane(textArea);
	  
	  platzhalter.setSize(40, 50);
	  
	  BorderLayout b = new BorderLayout();
	  b.setVgap(5);
	  
	  this.setLayout( b );
	  
	  JPanel buttons = new JPanel(new GridLayout(2,4));
	  
	  this.add(buttons, BorderLayout.NORTH);  
	  buttons.add(b1);
	  buttons.add(b2);
	  buttons.add(b3);   b3.setEnabled(false);
	  buttons.add(platzhalter);buttons.add(platzhalter2);
	  buttons.add(cmb);     cmb.setEnabled(true);
	  buttons.add(cmbZutat); cmbZutat.setEnabled(false);
	  buttons.add(b4);
	  buttons.add(b5);
	  buttons.add(b6);
	  
	  JPanel textA = new JPanel(new GridLayout());
	  textA.setBorder(BorderFactory.createLineBorder(Color.black));
	  
	  this.add(textA, BorderLayout.CENTER);
	  textA.add(scrollPane); 
		    
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  b5.addActionListener(this);
	  b6.addActionListener(this);
	  platzhalter2.addActionListener(this);
	  cmb.addActionListener(this);
	  cmbZutat.addActionListener(this);
		   
	    
	  
	  this.setVisible(true);
	  //this.pack();
	}//Konstruktor
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	  if (ae.getActionCommand().equals("Neu")){	
		
		cmb.setEnabled(true); b4.setEnabled(true); b5.setEnabled(true); b6.setEnabled(true);
		platzhalter2.setEnabled(false);
		a.getProduct().getProdukt().getkListe().clear();
		textArea.setText("");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	  }	
	  if (ae.getActionCommand().equals("Neue Zutat")){
		  cmbZutat.setEnabled(true);
	  }
	  // Kaffee Sorte Auswahl Menue
	  if (ae.getSource().equals(cmb)){
		  JComboBox tmp = (JComboBox)ae.getSource();
	      String coffeeName = (String)tmp.getSelectedItem();
	      double geld = a.getProduct().getProdukt().getPreis();
	      
	      textArea.append(coffeeName +"   "+geld+ "\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
	      cmb.setEnabled(false); b3.setEnabled(true); platzhalter2.setEnabled(true); b4.setEnabled(false); b5.setEnabled(false); b6.setEnabled(false);
	      
	      switch (cmb.getSelectedIndex()){
	        case 0: a.makeProduct(new Kaffee());
	          break;
	        case 1: a.makeProduct(new Espresso());
	          break;
	        case 2: a.makeProduct(new Mocca());
	      }
	    a.getProduct().addObserver(operator);     
	  }
	  
	  if (ae.getSource().equals(cmbZutat)){
		  
		  JComboBox tmp = (JComboBox)ae.getSource();
	      String coffeeItem = (String)tmp.getSelectedItem();
	      
	      cmbZutat.setEnabled(false);
	      
	      //FIXME: Reihenfolgenkonsistenz
	       switch (cmbZutat.getSelectedIndex()){
	        case 0: a.getProduct().getProdukt().add(new Milch()); 
	          break;
	        case 1: 
	        	for (int i=0;i<a.getProduct().getProdukt().getkListe().size();i++){
	        	  if (a.getProduct().getProdukt().getkListe().get(i).getName().equals("Sahne") ){
	        		  javax.swing.JOptionPane.showMessageDialog(this, "Sorry das koennen wir nicht machen.");
		        	  System.out.println("Sorry das koennen wir nicht machen. Geschaeftsbedingungen."); return;  
	        	  }//if
	        	}//for
	        	//else
	        	  a.getProduct().getProdukt().add(new Milchschaum());  
	          
	          break;
	        case 2:
	        	for (int i=0;i<a.getProduct().getProdukt().getkListe().size();i++){
		        	  if (a.getProduct().getProdukt().getkListe().get(i).getName().equals("Milchschaum") ){
		        		  javax.swing.JOptionPane.showMessageDialog(this, "Sorry das koennen wir nicht machen.");
			        	  System.out.println("Sorry das koennen wir nicht machen. Geschaeftsbedingungen."); return;  
		        	  }//if
		        }//for
		        //else
		        a.getProduct().getProdukt().add(new Sahne());  
		      
	          break;
	          
	        case 3:
	
	          if (a.getProduct().getProdukt().getName().equals("Espresso")){
	        	  javax.swing.JOptionPane.showMessageDialog(this, "Sorry das koennen wir nicht machen.");  
			    System.out.println("Sorry das koennen wir nicht in Espresso machen. Geschaeftsbedingungen."); return;
			  } else {
			    a.getProduct().getProdukt().add(new Eis());  
			  }
	        break;
	        
	        case 4:
				a.getProduct().getProdukt().add(new Zucker());  
		    break;
		    
	        case 5:
		     if (a.getProduct().getProdukt().getkListe().equals(new Sahne())){
		    	 a.getProduct().getProdukt().add(new Schokostreusel());  
		     } else {
		    	 javax.swing.JOptionPane.showMessageDialog(this, "Sorry das koennen wir nicht machen.");
		    	 System.out.println("Sorry das koennen wir nicht ohne Sahne machen. Geschaeftsbedingungen."); return;
		     }
	      }
	     
	     int last = a.getProduct().getProdukt().getkListe().size()-1;
	     double geld = a.getProduct().getProdukt().getkListe().get(last).getPreis();
		 textArea.append(coffeeItem + " "+geld+"\n");
		 textArea.setCaretPosition(textArea.getDocument().getLength());
		 a.getProduct().notifyObservers();
	  }
	  
	  if (ae.getActionCommand().equals("bezahlen")){	
		  
		  //operator.update();
		  
		  String out = Double.toString(a.Rechnung(a.getProduct().getProdukt().getkListe()));
		  
		  textArea.append("kostet: "+ out + " EU\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
	  }
	  if (ae.getActionCommand().equals("Capuccino")){
          a.makeCappucino();
		  
		  double geld = a.getProduct().getProdukt().getPreis();
		  String coffeeName = a.getProduct().getProdukt().getName();
		  
		  textArea.append(coffeeName+" "+geld +"\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
		  for ( IKaffee k : a.getProduct().getProdukt().getkListe()){
			  textArea.append(k.getName()+ " "+k.getPreis()+"\n");
			  
		  }
	      
		  a.getProduct().addObserver(operator);
	      cmb.setEnabled(false); b3.setEnabled(true); b4.setEnabled(false); b5.setEnabled(false); b6.setEnabled(false);
	  }
      if (ae.getActionCommand().equals("Latte Machiaccto")){
    	  a.makeLatteMacciato();
		  
		  double geld = a.getProduct().getProdukt().getPreis();
		  String coffeeName = a.getProduct().getProdukt().getName();
		  
		  textArea.append(coffeeName+" "+geld +"\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
		  for ( IKaffee k : a.getProduct().getProdukt().getkListe()){
			  textArea.append(k.getName()+ " "+k.getPreis()+"\n");
			  
		  }
	      
	      cmb.setEnabled(false); b3.setEnabled(true); b4.setEnabled(false); b5.setEnabled(false); b6.setEnabled(false); 
	      a.getProduct().addObserver(operator);  
	  }
      if (ae.getActionCommand().equals("doppelter Espresso")){
    	  a.makeDoppelterEspresso();
		  
		  double geld = a.getProduct().getProdukt().getPreis();
		  String coffeeName = a.getProduct().getProdukt().getName();
		  
		  textArea.append(coffeeName+" "+geld +"\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
		  for ( IKaffee k : a.getProduct().getProdukt().getkListe()){
			  textArea.append(k.getName()+ " "+k.getPreis()+"\n");
			  
		  }
	      
		  a.getProduct().addObserver(operator);
	      cmb.setEnabled(false); b3.setEnabled(true); b4.setEnabled(false); b5.setEnabled(false); b6.setEnabled(false);
	  }
      
      if (ae.getActionCommand().equals("doppelte Menge")){
          
    	  double sum = a.Rechnung(a.getProduct().getProdukt().getkListe())*1.7;
    	  String out = Double.toString(sum);
		  
		  textArea.append("kostet: "+ out + " EU\n");
	      textArea.setCaretPosition(textArea.getDocument().getLength());
      }
      
	}//actionPerformed
	

	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUI myWindow = new GUI();

	}


}
