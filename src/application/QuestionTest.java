package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuestionTest {

	Question q = new Question("MC", "Which way is up?", "answer", "wrong1", "wrong2", "wrong3");
	Question q2 = new Question("MC", "Blah", "B", "L", "A", "H");
	
	@Test
	void testGetQuestionType() {
		assertEquals(q.getQuestionType(),"MC");
	}
	
	@Test
	void testGetQuestion() {
		assertEquals(q.getQuestion(),"Which way is up?");
	}

	@Test
	void testGetAnswer() {
		assertEquals(q.getAnswer(),"answer");
	}

	@Test
	void testGetWrong1() {
		assertEquals(q.getWrong1(),"wrong1");
	}

	@Test
	void testGetWrong2() {
		assertEquals(q.getWrong2(),"wrong2");
	}

	@Test
	void testGetWrong3() {
		assertEquals(q.getWrong3(),"wrong3");
	}
	
	@Test
	void testQuestionTypes() {
		assertEquals(q.getQuestionType(),q2.getQuestionType());
	}

}
