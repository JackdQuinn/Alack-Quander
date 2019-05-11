package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudyBuddyTester {

	@Test
	void testLesson() {
		Screens screen = new Screens();
		Topic t = new Topic("Intro");
		Topic myTopic = t;
		Lesson l = new Lesson("Hello World");
		Lesson myLesson = l;
		//screen.getToTheNextScreen(myTopic, myLesson, prevScene);
		
	//assertEquals(f1.getNumerator(), 19);
		
	}
	

}
