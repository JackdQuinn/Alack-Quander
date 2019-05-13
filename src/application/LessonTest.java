package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LessonTest {

	@Test
	void testLesson() {
		Lesson l = new Lesson("Intro");
		assertEquals(l.getLesson(), "Intro");
	}

}
