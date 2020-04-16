package deko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import deko.DecoratorAfter.*;



public class Gui extends JFrame implements ActionListener {

	boolean ersterklick = false;
	boolean ereignis = false;
	Color rot = new Color(20,20,20);
	Color andere = new Color(140,140,140);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color = new Color(255, 255, 255);
	JButton b0 = new JButton("0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	
	JButton move = new JButton("move");
	JButton attack = new JButton("attack");
	JButton endturn = new JButton("endturn");
	
	JTextArea textArea = new JTextArea(5, 20);
	
	//listenblah
	  private List<JButton> blist = new ArrayList<JButton>();
	  
		private List<I> list1 = new ArrayList<I>();

		public List<I> getList1() {
			return list1;
		}
		public void setList1(List<I> list1) {
			this.list1 = list1;
		}
		public void addI(I einI){ list1.add(einI);	}
		public void removeI(I einI){ list1.remove(einI); }
		public void modifiI(I einI, I modI){ 
			int index = list1.indexOf(einI);
			list1.add(index, modI);
		
}
		
		public Gui(){
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			  
			int w = this.getSize().width;
			int h = this.getSize().height;
			int x = (dim.width-w)/2;
			int y = (dim.height-h)/2;
			this.setLocation(x-150, y-150);
			this.setTitle("Strategy Example");
			  
			blist.add(b0);blist.add(b1);blist.add(b2);blist.add(b3);blist.add(b4);
			blist.add(b5);blist.add(b6);blist.add(b7);blist.add(b8);
			
			
			this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			JPanel playground = new JPanel(new GridLayout(3,3));
			JPanel control = new JPanel(new GridLayout(3,4));
			    
			this.setLayout( new BorderLayout() );
			this.setSize(300,300); //pack wird verwendet faellt also weg
			  
			  this.add(playground, BorderLayout.CENTER);
			  this.add(control, BorderLayout.EAST);
			  playground.setBorder(BorderFactory.createLineBorder(Color.black));
			  control.setBorder(BorderFactory.createLineBorder(Color.black));
			  
			  playground.add(b0);
			  playground.add(b1);
			  playground.add(b2);
			  playground.add(b3);
			  playground.add(b4);
			  playground.add(b5);
			  playground.add(b6);
			  playground.add(b7);
			  playground.add(b8);
	
			  control.add(move);
			  control.add(attack);
			  control.add(endturn);
			  
			  this.add(textArea, BorderLayout.SOUTH);
			  textArea.setBorder(BorderFactory.createLineBorder(Color.black));
			  
			  b0.addActionListener(this);
			  b1.addActionListener(this);
			  b2.addActionListener(this);
			  b3.addActionListener(this);
			  b4.addActionListener(this);
			  b5.addActionListener(this);
			  b6.addActionListener(this);
			  b7.addActionListener(this);
			  b8.addActionListener(this);
			  
			  move.addActionListener(this);
			  
			  this.setVisible(true);
			  //this.pack();
		}
		
	
	public static void main( String[] args ) {
		   I[] array = { new X( new SpielFigur() ), new Y( new X( new SpielFigur() ) ),
		                 new Z( new Y( new X( new SpielFigur() ) ) ), 
		                 new B( new SpielFigur())};
		   for (int i=0; i < array.length; i++) {
		      array[i].doIt();
		      System.out.print( "  " );
		   }
		   
		   array[1].LevelUp(); array[1].LevelUp();
		   //ohne rueckgabe halt ausgabe aufrufen
		   array[1].doIt();
		   System.out.print( " Level = "+array[1].checkLevel());
		  
		   
Gui g = new Gui();

       //Filter anfrage: http://stackoverflow.com/questions/122105/what-is-the-best-way-to-filter-a-java-collection
//für SpielFigur >
//TODO: cmd pattern, zuerst JButton mit Farbe versehen bei klick und so

//cmds daher: einheiten bewegen -> jeder typ / selektierter typ, von wo, nach wo
//cmd kämpfen ... quasi bewegen -> schauen "meine" vs. "andere"
//cmd bauen / forschen / ausbilden
//cmd mehere pro zug möglich nicht die selben, nicht anhand befehlsid sondern inahlt des befehlsmusters+ort.. ?

//planet: sklavenplanet -> produziert krieger
//planet: mine/tempel -> bildet aus / waffen / forschung ?? menü
//planet: ... bonus mit sternentor
//planet sonst immer nur benachbarte felder angreifen hmm

//spielfigur: sklave produziert mineralien
//spielfigur: krieger (unerfahren, erfahren, veteran) bewaffnung nötig
//spielfigur: priester kann (waffen bauen / forschen)
        
		   
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == move){
			textArea.setText("klicke an von wo nach wo.");
			ereignis = true;
			//ereignis wurde ausgelöst
		}
		
		if (ereignis){
			if(  blist.contains(e.getSource()) ){       
				 for(int i=0;i<blist.size();i++){
					 if( e.getSource() == blist.get(i)){
						 textArea.setText("JButton" + i + " wurde geklickt.");
						 //textArea.setCaretPosition(textArea.getDocument().getLength());
						 blist.get(i).setBackground(rot); this.ersterklick = true;
					 }
				 }}
		}
		
		if ( ereignis && ersterklick){
			if(  blist.contains(e.getSource()) ){       
				 for(int i=0;i<blist.size();i++){
					 if( e.getSource() == blist.get(i)){
						 textArea.setText("JButton" + i + " wurde geklickt.");
						 //textArea.setCaretPosition(textArea.getDocument().getLength());
						 blist.get(i).setBackground(this.andere); 
						 this.ersterklick = false; this.ereignis = false;
					 }
				 }}
		}
		
		
	} 

	
}