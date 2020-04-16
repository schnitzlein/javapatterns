package obsPattern;

import java.util.ArrayList;
import java.util.List;

import kaffeeladen.Product;

public class ConcreteObservable implements IObservable{

	ConcreteObserver myObserver = null;
	
	
	@Override
	public void addObserver(IObserver obs) {
		myObserver = (ConcreteObserver)obs;
	}

	@Override
	public void removeObserver(IObserver obs) {
		if (this.myObserver.equals(obs) && myObserver != null){
		  myObserver = null;
		}
		
	}

	//benachrichtig die Observer, laesst sie anhand der Produkte eine Rechnung erstellen
	@Override
	public void notifyObservers() {
	  myObserver.update();	
	}
  
}
