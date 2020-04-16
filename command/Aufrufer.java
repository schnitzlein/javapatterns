import java.util.ArrayList;
import java.util.List;

public class Aufrufer {
	private List<Befehl> commands = new ArrayList<Befehl>();
	private List<Befehl> undo_commands = new ArrayList<Befehl>();
	
	int size = 0;
	
	//Konstruktor
	public Aufrufer(){
	  //Gibt es keine Befehle, dann sind die Listen leer und der redo bzw. undo button ist disabled
		if (commands.isEmpty()){
			//keine cmds bisher
		}
	}
	
	
	//rueckgaengig-Mechanismus
	public void undo(){
	 if (!commands.isEmpty()){
		 size = commands.size()-1;
			Befehl last = commands.get(size);
		//fuer redo verschiebe auf undo_commands stapel
			undo_commands.add(last);
		//loesche letzten Befehl
			commands.remove(size);	 
	 }	
	}
	
	//rueckgaengig gemachten Befehle
	public void redo(){
	  if (!undo_commands.isEmpty()){
	    size = undo_commands.size()-1;
	    Befehl last = undo_commands.get(size);
	    commands.add(last);
	    undo_commands.remove(size);
	  } else {
		  System.out.println("Keine Befehle zum redo vorhanden!");
	  }
	}
	
	//packe Befehl in die commands Liste
	public void doSth(Befehl neu){
	  commands.add(neu);
	  //System.out.println("neu "+commands.size());
	}
	
	
	//show last
	public Befehl showLast(){
		//System.out.println("last "+commands.size());
	  Befehl last = commands.get(commands.size()-1);
	  
		return last;
	}
	
	public boolean isCmdsLeer(){
		return commands.isEmpty();
	}
	
	public boolean isRedoCmdsLeer(){
		return undo_commands.isEmpty();
	}
	
	public int getCmdsSize(){
		return commands.size();
	}
	
	public void deleteCmds(){
		commands.clear();
	}
	
	public void deleteUndoCmds(){
		undo_commands.clear();
	}
	
	public void printHistory(){
	  KonkreterBefehl tmp = null;
	    System.out.println("Color History ");
		for( int i=0; i< commands.size(); i++ ){
		 tmp = (KonkreterBefehl)commands.get(i);
		 System.out.println("index: "+i+" cmd is "+tmp.cmdName()+" with "+tmp.getColor().toString());
	    }
	}
}
