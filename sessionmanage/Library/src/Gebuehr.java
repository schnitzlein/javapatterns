import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




public class Gebuehr extends JDialog implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  private int art = 0;
  
  private String titel = "";
  private boolean abgebrochen = false;
  
  private float betrag = 0.0f;
  private int seitenZahl = 0; 
  private int wochenZahl = 0;
  
  private String benachrichtigungsAuswahl = "eMail"; //neu
  private String comboBoxListe[] = {"eMail", "Brief","Telefon"}; //  neu
  
  private JTextField titelTF = new JTextField(15);
  private JTextField zahlTF = new JTextField(15);
  private JPanel inputPanel1 = new JPanel();
  private JPanel inputPanel2 = new JPanel();
  private JPanel bp = new JPanel();    
  private JButton ok = new JButton("OK");
  private JButton cancel = new JButton("Abbrechen");
  private JComboBox<String> cmbo = new JComboBox<String>(comboBoxListe); //neu

  public Gebuehr(JFrame owner, int art) {
    super(owner, "Gebuehr aendern");
    this.art = art;
    
    getContentPane().setLayout(new FlowLayout());
    
   
    inputPanel1.setLayout(new GridLayout(1, 2));
    inputPanel1.add(new JLabel("Titel"));
    inputPanel1.add(titelTF);
    getContentPane().add(inputPanel1);
    
    
    inputPanel2.setLayout(new GridLayout(1, 3));
    switch (art) {
      case 1: inputPanel2.add(new JLabel("Betrag"));
              break;
      case 2: inputPanel2.add(new JLabel("Seitenzahl"));
              break;
      case 3: inputPanel2.add(new JLabel("Wochenzahl"));
              break;
      case 4: inputPanel2.add(new JLabel("Benachrichtigungsart")); inputPanel2.add(cmbo); //this.titelTF.setText("test");
      break;
    } 
    inputPanel2.add(zahlTF);
    getContentPane().add(inputPanel2);

    bp.add(ok);
    bp.add(cancel);
    getContentPane().add(bp);
   
    cmbo.addActionListener(this);
    ok.addActionListener(this);
    cancel.addActionListener(this);
    
    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

    setSize(400, 120);
    setLocation(100, 350);
    setModal(true);
    setVisible(true);
  }


  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    
    
      benachrichtigungsAuswahl = (String)cmbo.getSelectedItem();
      if (art == 4) {zahlTF.setText(Float.toString(getBetrag()));} //neu
  
    
    if (command.equals("OK")) {
      titel = titelTF.getText();
      boolean exceptionCaught = false; 
      try {
        switch (art) {
          case 1: betrag = Float.parseFloat(zahlTF.getText());
                  break;
          case 2: seitenZahl = Integer.parseInt(zahlTF.getText());
                  break;
          case 3: wochenZahl = Integer.parseInt(zahlTF.getText());
                  break;
          case 4: benachrichtigungsAuswahl = (String)cmbo.getSelectedItem();
                  break;
         
        }
      } catch (Exception exception) {
        exceptionCaught = true;
      }
      
      if (!exceptionCaught) {
        abgebrochen = false;
        setVisible(false);
      } else {
        JOptionPane.showMessageDialog(
          this, 
          "Bitte eine gueltige Zahl angeben.", 
          "",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }

    if (command.equals("Abbrechen")) {
      abgebrochen = true;
      setVisible(false);
    }
  }


  public boolean istAbgebrochen() {
    return abgebrochen;
  }


  public String getTitel() {
    return titel;
  }
  

  public float getBetrag() {
    switch (art) {
      case 1: return betrag;
      case 2: if (seitenZahl > 20) {
                return 1.5f + 0.15f * seitenZahl;
              } else {
                return 1.5f;
              }
      case 3: if (wochenZahl == 1) {
                return 1.0f;
              } 
              if (wochenZahl == 2) {
                return 2.0f;
              }
              if (wochenZahl <= 5) {
                return 2.0f + 2.5f * wochenZahl;
              }
              return 15.0f;
      case 4: 
    	  if (benachrichtigungsAuswahl.equals("eMail")){
    	    return 0.5f;
          }
    	  if (benachrichtigungsAuswahl.equals("Brief")){
      	    return 1.0f;
          }
    	  if (benachrichtigungsAuswahl.equals("Telefon")){
        	    return 2.0f;
          }
    }
    return 0.0f;
  }
  

  public String toString() {
    switch (art) {
      case 1: return "Beschaedigung: " + titel;
      case 2: return "Fernleihe: " + titel + ", " + seitenZahl + " Seiten";
      case 3: return "Saeumnis: " + titel + ", " + wochenZahl + " Wochen";
      case 4: return "Benachrichtigung: " + titel + ", per " + this.benachrichtigungsAuswahl;
    }
    return "";
  }
  
}
