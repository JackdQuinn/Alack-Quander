package application;

import java.util.ArrayList;

public class Topic {
	private String lesson;//no memory, what dis?
	
	private ArrayList<TextScribbles> text;


	/**
	 * 
	 * @param question
	 * @param answer
	 * @param wrong1
	 * @param wrong2
	 * @param wrong3
	 * @param lesson -- not sure why i put this here
	 */
	public void addQuestion(String question, String answer, String wrong1, String wrong2, String wrong3, String lesson) {
		text.add(new Question(question, answer, wrong1, wrong2, wrong3, lesson));
		
	}
	
	public void addQuestion(Question q) {
		text.add(q);
		
	}
	public void addContent(Content c) {
		text.add(c);
	}

	public Topic(String lesson) {// perhaps a better name might be content I think I got lost by not commenting my code
		super();
		//each Topic is one Java lesson eg Loops, Conditionals, Git etc...
		this.lesson = lesson;
		
		//each question is one page
		text = new ArrayList<TextScribbles>();
		
	}

		public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public ArrayList<TextScribbles> getText() {
		return text;
	}

	public void setText(ArrayList<TextScribbles> text) {
		this.text = text;
	}
	
	//kill bugs
	public String toString() {
		String whatEverYouWannaCallIt="";
		
		for (TextScribbles scribbles : text)
		{
			whatEverYouWannaCallIt+= scribbles.getLesson();
		}
		
		
		return whatEverYouWannaCallIt;
	}
}
