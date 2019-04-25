package application;

public class Content extends TextScribbles{
	private String text;

	public Content(String lesson, String text) {
		super(lesson);
		this.text = text;
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
