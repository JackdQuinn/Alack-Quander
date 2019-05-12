package application;

/**
 * This class is extending TextRaw
 * Takes in questions from the ContentHash file and "fixes" the text to display multiple lines
 */
public class Question extends TextRaw {
	
	private String questionType, question, answer, wrong1, wrong2, wrong3;

	/**
	 * Constructor: 	
	 * @param questionType - FIB vs MC
	 * @param question
	 * @param answer
	 * @param wrong1
	 * @param wrong2
	 * @param wrong3
	 * @param lesson
	 */
	public Question(String questionType, String question, String answer, String wrong1, String wrong2, String wrong3) {
		super();
		this.question = fixText(question);
		this.answer = fixText(answer);
		this.wrong1 = fixText(wrong1);
		this.wrong2 = fixText(wrong2);
		this.wrong3 = fixText(wrong3);
		this.questionType = fixText(questionType);
	}
	
	
	//getters and setters
	
	public String getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	public String getQuestion() {
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

