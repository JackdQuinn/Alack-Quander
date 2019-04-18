package application;

import java.util.ArrayList;

public class Topic {
	private String subject;
	
	private ArrayList<Question> CFU;
	
	public void addQuestion(String question, String answer, String wrong1, String wrong2, String wrong3) {
		CFU.add(new Question(question, answer, wrong1, wrong2, wrong3));
		
	}

	public Topic(String subject) {
		super();
		this.subject = subject;
		CFU = new ArrayList<Question>();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ArrayList<Question> getCFU() {
		return CFU;
	}

	public void setCFU(ArrayList<Question> cFU) {
		CFU = cFU;
	}
	
	

}
