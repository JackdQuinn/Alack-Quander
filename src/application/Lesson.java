package application;

import java.util.ArrayList;

public class Lesson {
	
	private ArrayList<TextRaw> text;
	private String myLesson;
	
	public Lesson (String myLes) {
	//each question is one page
		text = new ArrayList<TextRaw>();
		myLesson = myLes;
	}
	
	public ArrayList<TextRaw> getText() {
		return text;
	}
	
	public void setText(ArrayList<TextRaw> text) {
		this.text = text;
	}

	/**
	 * @param questionType - either multiple choice or fill in the blank
	 * @param question - string that is the question
	 * @param answer - one of 4 choices is the correct answer
	 * @param wrong1 - 1 of 3 incorrect answers
	 * @param wrong2 - 2 of 3 incorrect answers
	 * @param wrong3 - 3 of 3 incorrect answers
	 */
	public void addQuestion(String questionType, String question, String answer, String wrong1, String wrong2, String wrong3) {
		text.add(new Question(questionType, question, answer, wrong1, wrong2, wrong3));
	}
	
	public void addQuestion(Question q) {
		text.add(q);
	}
	
	public void addContent(Content c) {
		text.add(c);
	}
	
	public String getLesson() {
		return myLesson;
	}


}
