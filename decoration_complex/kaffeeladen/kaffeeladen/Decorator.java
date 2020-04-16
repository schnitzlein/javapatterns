package kaffeeladen;

import java.util.List;

public class Decorator implements IKaffee{

	//FIXME: Eigentlich muss der Decorator kein IKaffee sein, der IKaffee könnte eigenitlich einen Decorator hinzufuegen und liste und haben und 
	
	private String name = "Dekorierer";
	private IKaffee meinKaffee;          //meinKaffee ist der Kaffee an den die Zutaten gebunden werden
	
	//Deprecated: Idee wird nicht mehr verwendet, jetzt anders rum
	//neuen Kaffee hinzufuegen, Zutaten sind auch "Kaffee"
	//ein Item wird an ein KaffeeElem gebunden
    /*public Decorator(IKaffee einKaffee){
        meinKaffee = einKaffee;
    }*/

	//get Item Name
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public void setItem(String itemName){
		name = itemName;
	}
	
	//add KaffeeElemente, wird von Decorator nicht verwendet
		@Override
		public void add(IKaffee kaffeeElement){
		  this.kaffeeListe.add(kaffeeElement);
		}

		@Override
		public double getPreis() {
			return 0.0;  //ein dekorator hat kein preis, erst seine unterelemente
		}

		@Override
		public List<IKaffee> getkListe() {
			return this.kaffeeListe;
		}

}
