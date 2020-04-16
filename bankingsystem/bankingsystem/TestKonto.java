package bankingsystem;

import java.util.List;

public class TestKonto {
  public static void main(String[] args){
     try {
       DefaultKonto test = new DefaultKonto("John Connor", 1337.0, 100.0);
     
    boolean wasLos;
        wasLos = test.einzahlen("Sarah Connor", 500.0);
        wasLos = test.auszahlen("Terminator", 2000.0);
      
        List<Buchung> n1 = test.gibBuchungen();
        
        if(!n1.isEmpty()) for(int i=0; i< n1.size();i++) {System.out.println(n1.get(i).gibInfoText()+" Betrag "+n1.get(i).betrag); }
        
        System.out.println("aktiv: "+test.aktiv+" gesperrt: "+test.gesperrt);    
        System.out.println("Kontoinhaber: "+test.kontoinhaber+" Kontostand: "+test.gibKontostand()+" Dispo: "+test.gibVerfuegungsrahmen());
        System.out.println("auszahlen war "+wasLos);
        
        if(!wasLos) System.out.println("auszahlen fehlgeschlagen");
        
        //test.kontostand += 2000.0;
        //System.out.println("manuell Geld "+test.kontostand);
         } catch (Exception e){
       System.out.println("kabooom");  
     }
    }
}
