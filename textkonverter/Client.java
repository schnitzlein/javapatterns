package textkonverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.text.rtf.RTFEditorKit;



//Client
public class Client{
	String text = "";
	
	public void createASCIIText(Document doc){
		ASCIIConverter asciiBuilder = new ASCIIConverter();
		RTFReader rtfReader = new RTFReader(asciiBuilder);
		rtfReader.parseRTF(doc);
		ASCIIText asciiText = asciiBuilder.getResult();
		text = asciiText.getASCIIText();
	}
	
	public String getText(){
		return text;
	}
	
	
	public static void main(String args[]){
		//Client client=new Client();
		//Document doc=new Document();
		//client.createASCIIText(doc);
		
		
		
		String eingabe = "ue_swt_07.rtf";
		String ausgabe = "example.rtf";
		
		FileReader fr;
		try {
			fr = new FileReader("D:\\eclipse\\workspace\\SWT-UE-07\\ue_swt_07.rtf");
			BufferedReader br = new BufferedReader(fr);

			    String line = "";

			    while(line != null)
			    {
			      line = br.readLine();
			      System.out.println(line);
			    }
			    

			    br.close();
			    fr.close();
		} catch (IOException e) {
		  System.out.println("Fehler beim Datei lesen.");
		}
		
		
		/*FileWriter fw;
		try {
			fw = new FileWriter(ausgabe);
			 BufferedWriter bw = new BufferedWriter(fw);

			    bw.write("test test test");
			    bw.write("tset tset tset");
			    bw.write(client.getText());

			    bw.close();
			    fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		  System.out.println("Fehler bei Datei erstellen.");
		}*/
	   
		
		
		
		System.out.println("This is an example of Builder Pattern");
		
		
		
	}
}