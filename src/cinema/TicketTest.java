package cinema;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {

	@Test
	public void test() {
		Ticket t = new Ticket();
		String id = t.generateID();
		/*check whether the length of id is 8*, if 9 is written here, test would be wrong*/
		assertEquals(8,id.length());
	}

}
