package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LessonTest {

	@Test
	void testLesson() {
		Lesson l = new Lesson("Intro");
		assertEquals(l.getLesson(), "Intro");
	}
	
	@Test
	void testLessonDifferent() {
		Lesson l2 = new Lesson("Arrays");
		Lesson l3 = new Lesson("Loops");
		assertNotEquals(l2.getLesson(), l3.getLesson());
	}
	
	@Test
	void testLessonSame() {
		Lesson l4 = new Lesson("Loops");
		Lesson l3 = new Lesson("Loops");
		assertEquals(l4.getLesson(), l3.getLesson());
	}


}
