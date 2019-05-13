package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTest extends Question {

	public QuestionTest(String questionType, String question, String answer, String wrong1, String wrong2,
			String wrong3) {
		super(questionType, question, answer, wrong1, wrong2, wrong3);
	}

	Question q = new Question("MC", "Which way is up?", "answer", "wrong1", "wrong1", "wrong1");

	Question q = new Question("MC", "Which way is up?", "answer", "wrong1", "wrong1", "wrong1");

	@Test
	void testGetQuestion() {
		System.out.println(q.getQuestion());
		assertEquals(q.getQuestion(),"Which way is up?");

	}

	@Test
	void testGetAnswer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWrong1() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWrong2() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWrong3() {
		fail("Not yet implemented");
	}

}
