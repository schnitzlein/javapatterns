package kaffeeladen;

import java.util.List;

public class DeCaf implements IKaffee{

	String name = "DeCaf";
	double preis = 1.00;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	//add KaffeeElemente
		@Override
		public void add(IKaffee kaffeeElement){
		  this.kaffeeListe.add(kaffeeElement);
		}

		@Override
		public double getPreis() {
			return preis;
		}

		@Override
		public List<IKaffee> getkListe() {
			return this.kaffeeListe;
		}

}
