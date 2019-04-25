package application;

public class Question extends TextScribbles {
	private String question, answer, wrong1, wrong2, wrong3;

//views will track number of times a question is scene, Correctedness is an integer either positive or negative based on User performance on this question.

	private int views, correctedness;

/**
 * Constructor: 	
 * @param question
 * @param answer
 * @param wrong1
 * @param wrong2
 * @param wrong3
 * @param lesson
 */
public Question(String question, String answer, String wrong1, String wrong2, String wrong3, String lesson) {
		super(lesson);
		this.question = question;
		this.answer = answer;
		this.wrong1 = wrong1;
		this.wrong2 = wrong2;
		this.wrong3 = wrong3;
		
		views = 0;
		correctedness = 0;
		
	}
public String checkAnswer (String userAnswer) {
	if (answer.equals(userAnswer)) {
		correctedness++;
		return "Awesomesauce!";
	}
	else {
		correctedness--;
		return "Oh Noes!!! Try again! Ganbatte! Fighting!!! Buena Suerte! Bon Chance! Good Luck!!";
	}
}

public void gotCorrect(boolean b) {
	if (b) {
		correctedness++;
	}else {
		correctedness--;
	}
	
	System.out.println("something" + correctedness);
}

	public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public int getCorrectedness() {
	return correctedness;
}
public void setCorrectedness(int correctedness) {
	this.correctedness = correctedness;
}
	public String getQuestion() {
		views++;
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getWrong1() {
		return wrong1;
	}

	public void setWrong1(String wrong1) {
		this.wrong1 = wrong1;
	}

	public String getWrong2() {
		return wrong2;
	}

	public void setWrong2(String wrong2) {
		this.wrong2 = wrong2;
	}

	public String getWrong3() {
		return wrong3;
	}

	public void setWrong3(String wrong3) {
		this.wrong3 = wrong3;
	}
	
}
