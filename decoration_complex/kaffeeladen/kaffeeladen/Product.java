package kaffeeladen;

import obsPattern.ConcreteObservable;
import obsPattern.ConcreteObserver;
import obsPattern.IObservable;
import obsPattern.IObserver;

//Modell

public class Product extends ConcreteObservable{
	  IKaffee einKaffeeProdukt;
	  
	  public Product(IKaffee k){
		  einKaffeeProdukt = k;
	  }
	  
	  public IKaffee getProdukt(){
		  return einKaffeeProdukt;  
	  }
	  
	}