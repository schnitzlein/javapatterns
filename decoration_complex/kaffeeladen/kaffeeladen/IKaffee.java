package kaffeeladen;

import java.util.ArrayList;
import java.util.List;


public interface IKaffee {
  
  
  List<IKaffee> kaffeeListe = new ArrayList<IKaffee>();
  
  public String getName();
  public void setName(String name);
  public double getPreis();
  public List<IKaffee> getkListe();
  public void add(IKaffee kaffeeElement);
	
}
