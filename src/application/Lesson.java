package application;

import java.util.ArrayList;

public class Lesson {
	private ArrayList<TextScribbles> text;
	private String myLesson;
public Lesson (String myLes) {
	//each question is one page
			text = new ArrayList<TextScribbles>();
			myLesson = myLes;
}

public ArrayList<TextScribbles> getText() {
	return text;
}

public void setText(ArrayList<TextScribbles> text) {
	this.text = text;
}



/**
 * 
 * @param question
 * @param answer
 * @param wrong1
 * @param wrong2
 * @param wrong3
 * @param lesson -- not sure why i put this here
 */
public void addQuestion(String question, String answer, String wrong1, String wrong2, String wrong3) {
	text.add(new Question(question, answer, wrong1, wrong2, wrong3));
	
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
