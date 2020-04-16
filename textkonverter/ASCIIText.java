package textkonverter;

import javax.swing.text.html.HTMLEditorKit;

//Product
public class ASCIIText{
	
	String myText = "";
	
	/*
	 * Der Konverter soll aufgerufen werden mit java convert <Eingabedatei> <Ausgabedatei>. Eingabedatei
     * und Ausgabedatei können eines der Formate RTF, HTML und LATEX haben. Das Format der
     * Dateien erkennt der Konverter an der Dateinamensendung .rtf, .html oder .tex. Der Konverter liest
     * die Eingabedatei ein, konvertiert sie in das Format der Ausgabedatei, und gibt sie in die Ausgabedatei
     * aus. Dabei sollen auch die Zeichenformatierungen fett, kursiv und unterstrichen berücksichtigt
     * werden, nicht aber Kombinationen dieser Formatierungen. 
	 */
	//gets the ascii character
	public void append(char c){ //Implement the code here 
	  myText = myText + c;
	}
	
	public String getASCIIText(){
		return myText;
	}
	
	/*public static void main(String[] args){
		ASCIIText aT = new ASCIIText();
		
		aT.append('b');
		aT.append('b');
		aT.append('b');
		aT.append('b');
		aT.append('b');
		aT.append('b');
		System.out.println(aT.myText);
	}*/
}
