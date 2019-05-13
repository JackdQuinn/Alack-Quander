package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContentTest {
	
	Content c = new Content("ALEXANDRA\nJACK");
	Content a1 = new Content("AO");
	Content a2 = new Content("AO");
	
	@Test
	void testContent() {
		assertEquals(c.getText(),"ALEXANDRA\nJACK");
	}
	
	@Test
	void testContentSame() {
		assertEquals(a1.getText(),a2.getText());
	}
	
}
