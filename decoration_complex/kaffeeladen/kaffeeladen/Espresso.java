package kaffeeladen;

import java.util.List;

public class Espresso implements IKaffee{
  String name = "Espresso";
  double preis = 1.50;
  
  @Override
  public String getName() {
	return name;
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

	@Override
	public void setName(String name) {
		this.name = name;
	}
  
  
}
