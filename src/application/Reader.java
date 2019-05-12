 package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	int lessonIndex;
	ArrayList<Topic> javaTopics;
	int XP=0;
	String lastTopic,lastLesson;

	//pull scribbles from a file
	public Reader() {

		javaTopics = new ArrayList<Topic>();
		lessonIndex = 0; // offset for goToChosen topic increment call

		//Used for tracking last page viewed (displayed on topic menu)
		//scanner to read captainsLog.txt where last page viewed is written
		File captainsLog = new File("captainsLog.txt");
		try {
			Scanner darkly = new Scanner(captainsLog);
			String prevSession = darkly.nextLine();
			lastTopic = prevSession.substring(0, prevSession.indexOf("#"));
			lastLesson = prevSession.substring(prevSession.indexOf("#")+1);
			darkly.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found");
			e.printStackTrace();
		}

		//Used for tracking XP points earned (displayed on topic menu)
		//scanner to read xp.txt where xp points are written
		File xpFile = new File("xp.txt");
		try {
			Scanner s = new Scanner(xpFile);
			while (s.hasNextInt()) {
				int xpNow = s.nextInt();
				XP += xpNow;
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found");
			e.printStackTrace();
		}

		//Used for reading content, lessons, topics, questions
		File file = new File("ContentHash.txt");
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				//this is where we would read in the data and input here
				//for pulling as a loop insert that variable instead of "Basics"
				String row = scanner.nextLine();
				String[] column = row.split("#");
				Topic myTopic = new Topic("");
				Lesson myLesson = new Lesson("");

				//this is to avoid index out of bounds errors. both content and questions share these fields
				if (column.length >= 4) {
					String topic = column[1].trim();
					String lessonText = column[2];
					//check to see if topic exists inside javaTopics, if not then create new topic and add to arrayList
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
					//check to see if lesson already exists inside the Topic Object
					myLesson = myTopic.addLesson(lessonText.trim());
				}

				//content fields
				if (column[0].trim().equalsIgnoreCase("c") && column.length >= 5) {
					String content = column[4];
					Content myContent = new Content(content);
					myLesson.addContent(myContent);
				} else if (column.length >= 11) {
					//question fields
					String questionType = column[5].trim();
					String question = column[6];
					String correctAnswer = column[7];
					String wrongAnswer1 = column[8];
					String wrongAnswer2 = column[9];
					String wrongAnswer3 = column[10];
					Question myQuestion = new Question(questionType, question, correctAnswer, wrongAnswer1, wrongAnswer2,
							wrongAnswer3);
					myLesson.addQuestion(myQuestion);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - file not found");
			e.printStackTrace();
		}
	}

	//writes last page viewed to captainsLog
	public void recordLastPage(String prevTopic, String prevLesson) {
		lastTopic = prevTopic;
		lastLesson= prevLesson;
		try {
			FileWriter fw = new FileWriter("captainsLog.txt", false);
			fw.write(prevTopic + "#" + prevLesson);
			fw.close();

		}catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	//writes 10 on new line each time user answers a question correctly
	public void xp() {
		try {
			FileWriter fw = new FileWriter("xp.txt", true);
			fw.write("10\n");
			fw.close();
		}catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public String getLastTopic() {
		return lastTopic;
	}

	public String getLastLesson() {
		return lastLesson;
	}

	public ArrayList<Topic> topics() {
		return javaTopics;
	}

	public int getXP() {
		return XP;
	}

}