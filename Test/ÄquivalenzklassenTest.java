import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;



public class ÄquivalenzklassenTest {

	Datum d1 = new Datum(25,6,2014);
	
	@Test
	public void testDatum() {
		assertNotNull("testet ob Datum nicht null ist", new Datum(25,6,2014));
		//assertNotNull("testet ob Datum nicht null ist", new Datum('a',12,34)); //Buchstaben werden erkannt als Int :(
		//d1 = new Datum(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
		//assertNull("testet ob Datum null ist", d1);
	}

	@Test
	public void testSetDatum() {
		d1.setDatum(25, 6, 2014);
		//assertEquals("testet setDatum", d1, new Datum(25,6,2014));
		assertEquals("testet setDatum", d1.toString(), new Datum(25,6,2014).toString());
		d1.setDatum(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		d1.setDatum(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		//assertEquals("testet setDatum", d1.toString(), new Datum(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE).toString());
	}

	@Test
	public void testAddDays() {
		d1.addDays(1);
		assertEquals("testet AddDays", d1.toString(), new Datum(26,6,2014).toString());
	}

	@Test
	public void testSubtractDays() {
		d1.subtractDays(1);
		assertEquals("testet SubtractDays", d1.toString(), new Datum(24,6,2014).toString());
	}

	@Test
	public void testToString() {
		assertEquals("testet toString", "Dienstag, [01].[02].[2000]",new Datum(1,2,2000).toString());
	}

	@Test
	public void testToDate() {
		Calendar cal;
		cal = Calendar.getInstance();
		
		//assertSame("testet toDate", (Date)cal.getTime() , (Date)new Datum(26,6,2014).toDate());
	}

	@Test
	public void testIsSchaltjahr() {
		assertTrue("testet auf Schaltjahr", new Datum(1,1,1904).isSchaltjahr());
		assertFalse("testet auf Schaltjahr", new Datum(1,1,1907).isSchaltjahr());
	}

}
