package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	
	int lessonIndex;
	ArrayList<Topic> javaTopics;
	
	//pull scribbles from a file
	public Reader() {
		javaTopics = new ArrayList<Topic>();
		lessonIndex = 0; // offset for goToChosen topic increment call

		File file = new File("ContentHash.txt");

		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				// this is where we would read in the data and input here
				// for pulling as a loop insert that variable instead of "Basics"
				String row = scanner.nextLine();
				String[] column = row.split("#");
				Topic myTopic = new Topic("");
				Lesson myLesson = new Lesson("");

				//this is to avoid index out of bounds errors
				// both content and questions share these fields
				if (column.length >= 4) {
					// grab the topic from the file.
					String topic = column[1].trim();
					String lessonText = column[2];
					// check to see if topic already exists inside javaTopics, if not create a new
					// topic and add to arrayList
					boolean exists = false;
					for (Topic thisTopic : javaTopics) {
						if (thisTopic.getTopic().equalsIgnoreCase(topic)) {
							exists = true;
							myTopic = thisTopic;
						}
					}

					if (exists == false) {
						myTopic = new Topic(topic.trim());
						javaTopics.add(myTopic);

					}

					// check to see if lesson already exists inside the Topic Object
					myLesson = myTopic.addLesson(lessonText.trim());
					String type = column[0];
					String module = column[1];
					String page = column[3];
				}
				
				// content fields
				if (column[0].trim().equalsIgnoreCase("c") && column.length >= 5) {
					String content = column[4];
					//System.out.println(content);
					Content myContent = new Content(content);
					myLesson.addContent(myContent);
					// System.out.println("c");
				} else if (column.length >= 11) {
					// question fields
					String questionType = column[5];
					String question = column[6];
					//System.out.println(question);
					String correctAnswer = column[7];
					String wrongAnswer1 = column[8];
					String wrongAnswer2 = column[9];
					String wrongAnswer3 = column[10];
					Question myQuestion = new Question(question, correctAnswer, wrongAnswer1, wrongAnswer2,
							wrongAnswer3);
					myLesson.addQuestion(myQuestion);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList topics() {
		return javaTopics;
		
	}

}
	

