package application;

public class ReaderData {

	private String topic;
	private String lesson;
	private String title;
	private String page;
	private String content;
	private String questionType;
	private String question;
	private String correctAnswer;
	private String wrongAnswer1;
	private String wrongAnswer2;
	private String wrongAnswer3;
	private String FIB1;
	private String FIB2;
	
	
	public ReaderData (String topic, String lesson, String title, String page, String content, String questionType, String question,
			String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String FIB1,
			String FIB2) {
		this.topic = topic;
		this.lesson = lesson;
		this.title = title;
		this.page = page;
		this.questionType = questionType;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
		this.FIB1 = FIB1;
		this.FIB2 = FIB2;
		
	}
			
	
	
	
	public String getTopic() {
		return topic;
	}
	public String getLesson() {
		return lesson;
	}
	public String getTitle() {
		return title;
	}
	public String getPage() {
		return page;
	}
	public String getContent() {
		return content;
	}
	public String getQuestion() {
		return question;
	}
	public String getQuestionType() {
		return questionType;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public String getWrongAnswer1() {
		return wrongAnswer1;
	}
	public String getWrongAnswer2() {
		return wrongAnswer2;
	}
	public String getWrongAnswer3() {
		return wrongAnswer3;
	}
	public String getFIB1() {
		return FIB1;
	}
	public String getFIB2() {
		return FIB2;
	}
	
	
	
	
	
	
	
}
