package application;

public class Content extends TextScribbles{
	private String text;

	public Content(String text) {
		super();
		this.text = text;
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
