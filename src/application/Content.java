package application;

/**
 * This class is extends TextRaw
 * Takes in content from the ContentHash file and "fixes" the text to display multiple lines
 */
public class Content extends TextRaw{
	
	private String text;

	public Content(String text) {
		super();
		this.text = fixText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
