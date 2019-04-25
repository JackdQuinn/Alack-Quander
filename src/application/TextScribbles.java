package application;

public abstract class TextScribbles {
	private String lesson;

	public TextScribbles(String lesson) {
		super();
		this.lesson = lesson;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

}
