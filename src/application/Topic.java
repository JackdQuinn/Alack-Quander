package application;

import java.util.ArrayList;

public class Topic {
	
	private ArrayList<Lesson> lessons;
	private String myTopic;
	
	public Topic(String myT) {
		super();
		//each Topic is one Java lesson eg Loops, Conditionals, Git etc...
		lessons = new ArrayList<Lesson>();
		myTopic = myT;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public String getTopic() {
		return myTopic;
	}

	public void setMyTopic(String myTopic) {
		this.myTopic = myTopic;
	}

	//check to see if lessonText already exists inside lessons, if not then create new Lesson and add to arraylist
	public Lesson addLesson(String lessonText) {
	Lesson myLesson;
	myLesson = new Lesson(lessonText);
	boolean exists = false;
	
	for (Lesson thisLesson : lessons) {
		if (thisLesson.getLesson().equalsIgnoreCase(lessonText)) {
			myLesson = thisLesson;
			exists = true;
		}
	}
	if(!exists) {
		lessons.add(myLesson);
	}
	return myLesson;
	}
		
}
