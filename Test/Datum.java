import java.text.DateFormat;
import java.lang.Character;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datum {

	Calendar untereGrenze;
	Calendar obereGrenze;
	Calendar neu;
	Date     time; 
	DateFormat formatter = new SimpleDateFormat();
	
	
	public Datum(int tag, int monat, int jahr){
		
		untereGrenze = Calendar.getInstance();
		untereGrenze.set(1900, 0, 1);
		
		obereGrenze = Calendar.getInstance();
		obereGrenze.set(2099, 11, 31);
		
		neu = Calendar.getInstance();
		
		//selber chekcen und abfangen
	 if ((tag <32 && tag > 0) && (monat > -1 && monat < 12) && (jahr >= 1900 && jahr <= 2099)){
		//hier krachts wenn es einfach so geschrieben wird
		neu.set(jahr, monat-1, tag);

		time = neu.getTime();
		System.out.println("eingegebenes Datum "+ formatter.format( time ) );
		
		formatter = new SimpleDateFormat("EEEE, [dd].[MM].[yyyy]");
		System.out.println(""+formatter.format(time));
		
	 }	else {
		 neu = null;
		 System.out.println("ACHTUNG: ausserhalb des erlaubten Bereiches!"); 
		 try {
			this.finalize();
		 } catch (Throwable e) {
			System.out.println(e.getLocalizedMessage());	
		 }
	 }
		
	    /*if (neu.getTime().before(untereGrenze.getTime())) {
			System.out.println("ACHTUNG: kleiner als untere Grenze!");  System.exit(-1);//this = null;
		}
		if (neu.getTime().after(obereGrenze.getTime())){
			System.out.println("ACHTUNG: groesser als obere Grenze!"); return;
		}*/
		
		//time = untereGrenze.getTime();
		//System.out.println("untere Grenze " + formatter.format( time ) );
		
		//time = obereGrenze.getTime();
		//System.out.println("obere Grenze  " +  formatter.format( time ) );
		
	}
	
	public void setDatum(int tag, int monat, int jahr){ 
		if ((tag <32 && tag > 0) && (monat > -1 && monat < 12) && (jahr >= 1900 && jahr <= 2099)){
		  //hier krachts wenn es einfach so geschrieben wird
		  neu.set(jahr, monat-1, tag);
		}	else {
		  System.out.println("ACHTUNG: ausserhalb des erlaubten Bereiches!");
		  return;
		}
		
		/*if (tmp.getTime().before(untereGrenze.getTime())) {
			System.out.println("ACHTUNG: kleiner als untere Grenze!"); return;
		}
		if (tmp.getTime().after(obereGrenze.getTime())){
			System.out.println("ACHTUNG: groesser als obere Grenze!"); return;
		}*/
	}
	
	public void addDays(int days){
		neu.add(Calendar.DATE, days);
	}
	
	//als positive Zahl angeben, wird dann subtrahiert
    public void subtractDays(int days){
    	neu.add(Calendar.DATE, -days);
	}
    
    public boolean checkEggCode(String code){
      
    	
    	if (code.length() == 10 && isDigitZeroToThree(code) && isBigAlpha(code) && isNum(code)) return true;
    	else {
    		return false;	
    	}
    		
    }
    
    public boolean isNum(String code){
    	String tmp = code.substring(3);
    	
    	for(int i=0;i<tmp.length();i++){
    		if( Character.isDigit(tmp.charAt(i)) == false ) return false;
    	}
    	
    	
    	return true;
    }
    
    public boolean isBigAlpha(String code){
    	boolean a1 = Character.isUpperCase(code.charAt(1));
    	boolean a2 = Character.isUpperCase(code.charAt(2));
    	
    	if (a1 == true && a2 == true) return true;
    	else return false;
    }
    
    public boolean isDigitZeroToThree(String code){
    	if (code.charAt(0) == '0' || code.charAt(0) == '1' || code.charAt(0) == '2' || code.charAt(0) == '3'){
    		return true;
    	}else return false;
    }
    
	//String - Format ("Wochentag, Tag[tt].Monat[mm].Jahr[jjjj]"),
	public String toString(){
		formatter = new SimpleDateFormat("EEEE, [dd].[MM].[yyyy]");
		return ""+formatter.format(neu.getTime());	
	}
	
	public Date toDate(){
		return neu.getTime();
	}
	
	public boolean isSchaltjahr(){
		return new GregorianCalendar().isLeapYear(neu.get(Calendar.YEAR));
	}
	
	public static void main(String args[]){
	  Datum meinDatum =	new Datum(23, 4 , 2014);
	  
	  System.out.println("erstellt am: "+meinDatum.toString());
	  System.out.println("Schaltjahr: "+meinDatum.isSchaltjahr());
	  
	  //System.out.println("Ist gueltiger Eiercode: "+meinDatum.checkEggCode("0AB1234567"));
	  //System.out.println("Ist ungueltiger Eiercode: "+meinDatum.checkEggCode("4AB1234567")); //abaendern
	  
	  
	  meinDatum.addDays(1);
	  System.out.println(meinDatum.toString());
	  meinDatum.subtractDays(1);
	  System.out.println(meinDatum.toString());
	  
	  System.out.println("test");
	  meinDatum.setDatum(25, 06, 2014);
	  meinDatum.addDays(Integer.MAX_VALUE);
	  meinDatum.addDays(Integer.MIN_VALUE);
	  System.out.println(meinDatum.toString());
	  Datum d4 = new Datum('a',12,34);
	  //System.out.println(d4.toString()); //null pointer
	  meinDatum.addDays('a');
	  System.out.println(meinDatum.toString());
	  meinDatum.setDatum(01, 01, 1900);
	  System.out.println(meinDatum.toString());
	  meinDatum.setDatum(30,11,2099);
	  System.out.println(meinDatum.toString());
	}
}

/*
 nach Tag, Monat und Jahr im Zeitraum vom 01.01.1900 bis 31.12.2099 ermöglichen. Dabei soll
die Klasse folgende Funktionalität bereitstellen:
•  Erzeugen eines Objektes mit den Parametern (Tag, Monat, Jahr),
•  Neu Setzen eines Datums mit den selben Parametern,
•  Auslesen des aktuellen Datums im String - Format ("Wochentag, Tag[tt].Monat[mm].Jahr[jjjj]"),
•  Feststellen, ob Datum zu einem Schaltjahr gehört,
•  Datumsarithmetiken (Addition und Subtraktion).
Eclipse-Installation um das Plugin EclEmma
http://www.tondering.dk/claus/calendar.html
http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html

*/