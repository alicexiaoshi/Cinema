package cinema;

import static org.junit.Assert.*;

import org.junit.Test;

public class readDBTest extends readDB{

	@Test
	public void test() {
		String screen = whichScreen("BEAUTY AND THE BEAST","10:30");
		/*to test whether the selected film and time belongs to the screen3*/
		assertEquals(screen,"screen3");
		
		/*to test whether the selected time is before the right now time*/
		boolean isBefore = checkTicketTime("10:30");
		assertEquals(isBefore,false);
		
		/*to test whether the selected seat is used*/
		boolean isUsed = checkSeat("screen1","A-5");
		assertEquals(isUsed,false);
	}

}
