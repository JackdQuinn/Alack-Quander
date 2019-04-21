package application;

import java.util.ArrayList;

public class Topic {
	private String subject;
	
	private ArrayList<Question> cFU;
	private ArrayList<String> content;
	
	public void addQuestion(String question, String answer, String wrong1, String wrong2, String wrong3) {
		cFU.add(new Question(question, answer, wrong1, wrong2, wrong3));
		
	}

	public Topic(String subject) {
		super();
		//each Topic is one Java subject eg Loops, Conditionals, Git etc...
		this.subject = subject;
		
		//each question is one page
		cFU = new ArrayList<Question>();
		
		//each string is one page of content
		content = new ArrayList<String>();
	}

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ArrayList<Question> getCFU() {
		return cFU;
	}

	public void setCFU(ArrayList<Question> cFU) {
		this.cFU = cFU;
	}
	
	

}
