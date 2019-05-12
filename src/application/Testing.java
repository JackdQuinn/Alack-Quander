package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class StudyBuddyTester {
	
	
	@Test
	void testLesson() {
		Topic currentTopic = new Topic("Basics");
		ArrayList<Lesson> lessons = currentTopic.getLessons();
		Lesson temp = lessons.get(1);
		System.out.println(temp.getLesson());
		
		assertEquals(l1, "Hello World");
	}
	

}
