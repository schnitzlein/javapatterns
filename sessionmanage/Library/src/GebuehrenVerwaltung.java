import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;



public class GebuehrenVerwaltung 
    extends JFrame 
    implements ActionListener, ListDataListener {

  private static final long serialVersionUID = 1L;
  private DefaultListModel<Gebuehr> listModel = new DefaultListModel<Gebuehr>();
  private JList<Gebuehr> list = new JList<Gebuehr>();
  private JLabel betragLabel = new JLabel("Gesamtbetrag: 0.0");

  private JPanel listPanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  
  private JButton button1 = new JButton("Neue Beschaedigung");
  private JButton button2 = new JButton("Neue Fernleihe");
  private JButton button21 = new JButton("Neues Saeumnis");
  private JButton button22 = new JButton("Neue Benachrichtigungsgebuehr"); //neu
  private JButton button3 = new JButton("Aendern");
  private JButton button31 = new JButton("Suchen");
  private JButton button4 = new JButton("Loeschen");
  
  Gebuehr gebuehr = null;
  
  public GebuehrenVerwaltung() {
    Container contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(1, 2));
    
    
    listPanel.setLayout(new GridLayout(1, 1));
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setModel(listModel);
    listPanel.add(new JScrollPane(list));
    contentPane.add(listPanel);
    
    
    buttonPanel.setLayout(new GridLayout(8, 1)); //neu
    
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    buttonPanel.add(button21);
    buttonPanel.add(button22); //neu
    buttonPanel.add(button3);
    buttonPanel.add(button31);
    buttonPanel.add(button4);
    
    betragLabel.setHorizontalAlignment(JLabel.CENTER);
    listModel.addListDataListener(this);
    buttonPanel.add(betragLabel);
    contentPane.add(buttonPanel);

    button1.addActionListener(this);
    button2.addActionListener(this);
    button21.addActionListener(this);
    button22.addActionListener(this);//neu
    button3.addActionListener(this);
    button31.addActionListener(this);
    button4.addActionListener(this);
    
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //neu

    setTitle("Gebuehrenverwaltung");
    setSize(800, 250);
    setLocation(100, 100);
    setVisible(true);
  }


  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("Neue Beschaedigung")) {
      gebuehr = new Gebuehr(this, 1);
      if (!gebuehr.istAbgebrochen()) {
        listModel.addElement(gebuehr);
      }
    } else if (command.equals("Neue Fernleihe")) {
      gebuehr = new Gebuehr(this, 2);
      if (!gebuehr.istAbgebrochen()) {
        listModel.addElement(gebuehr);
      }
    } else if (command.equals("Neues Saeumnis")) {
      gebuehr = new Gebuehr(this, 3);
      if (!gebuehr.istAbgebrochen()) {
        listModel.addElement(gebuehr);
      } 
    } else if (command.equals("Neue Benachrichtigungsgebuehr")) { //neu
          gebuehr = new Gebuehr(this, 4);
          if (!gebuehr.istAbgebrochen()) {
            listModel.addElement(gebuehr);
          }
      
    } else if (command.equals("Aendern")) {
      int index = list.getSelectedIndex();
      if (index >= 0) {
        gebuehr = (Gebuehr)listModel.elementAt(index);
        gebuehr.setVisible(true);
        listModel.remove(index);
        listModel.add(index, gebuehr);
      } else {
        JOptionPane.showMessageDialog
          (this, "Keine Gebuehr ausgewaehlt.", "", JOptionPane.ERROR_MESSAGE);
      }

    } else if (command.equals("Suchen")) {
      String search = JOptionPane.showInputDialog
        ("Bitte geben Sie den Sie den Suchstring ein");
      for (int i = 0; i < listModel.size(); i++) {
        if (((Gebuehr)listModel.get(i)).getTitel().indexOf(search) >= 0) {
          list.setSelectedIndex(i);
          return;
        }
      }
      list.removeSelectionInterval
        (list.getSelectedIndex(), list.getSelectedIndex());

    } else if (command.equals("Loeschen")) {
      int index = list.getSelectedIndex();
      if (index >= 0) {
        listModel.remove(index);
      } else {
        JOptionPane.showMessageDialog
          (this, "Keine Gebuehr ausgewaehlt.", "", JOptionPane.ERROR_MESSAGE);
      }
    } 
  }

  
  public void contentsChanged(ListDataEvent event) {
    float betrag = 0.0f;
    for (int i = 0; i < listModel.getSize(); i++) {
      betrag += ((Gebuehr)listModel.getElementAt(i)).getBetrag();
    }
    betragLabel.setText("Gesamtbetrag: " + betrag);
  }

  
  public void intervalAdded(ListDataEvent event) {
    float betrag = 0.0f;
    for (int i = 0; i < listModel.getSize(); i++) {
      betrag += ((Gebuehr)listModel.getElementAt(i)).getBetrag();
    }
    betragLabel.setText("Gesamtbetrag: " + betrag);
  }

  
  public void intervalRemoved(ListDataEvent event) {
    float betrag = 0.0f;
    for (int i = 0; i < listModel.getSize(); i++) {
      betrag += ((Gebuehr)listModel.getElementAt(i)).getBetrag();
    }
    betragLabel.setText("Gesamtbetrag: " + betrag);
  }


  public static void main (String[] args) {
    new GebuehrenVerwaltung();
  }

}
