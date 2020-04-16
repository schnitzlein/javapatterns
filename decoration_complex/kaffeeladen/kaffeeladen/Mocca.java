package kaffeeladen;

import java.util.List;

public class Mocca implements IKaffee{
    String name = "Mocca";
    double preis = 1.20;
	 
	

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
