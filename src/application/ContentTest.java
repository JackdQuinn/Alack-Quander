package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContentTest {
	
	Content c = new Content("ALEXANDRA\nJACK");
	
	@Test
	void testContent() {
		assertEquals(c.getText(),"ALEXANDRA\nJACK");
	}

	

}
