package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TopicTest {

	@Test
	void testTopic() {
		Topic t = new Topic("Basics");
		assertEquals(t.getTopic(), "Basics");
	}
	
	@Test
	void testTopicDifferent() {
		Topic t2 = new Topic("Basics");
		Topic t3 = new Topic("Basic");
		assertNotEquals(t2.getTopic(), t3.getTopic());
	}
	
	@Test
	void testTopicSame() {
		Topic t4 = new Topic("Basics");
		Topic t3 = new Topic("Basics");
		assertEquals(t4.getTopic(), t3.getTopic());
	}

}
