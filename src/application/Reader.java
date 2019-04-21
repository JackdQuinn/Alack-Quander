package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;


public class Reader {
	
	private HashMap<Integer, ReaderData> readerData;
	
	public Reader() {
		File file = new File("Content.txt");
		readerData = new HashMap <Integer, ReaderData>();
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			int index = 1;
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				String [] column = row.split("|");
				String topic = column[0];
				String lesson = column[1];
				String title = column[2];
				String page = column[3];
				String content= column[4];
				String questionType = column[5];
				String question = column[6];
				String correctAnswer = column[7];
				String wrongAnswer1 = column[8];
				String wrongAnswer2 = column [9];
				String wrongAnswer3 = column[10];
				String FIB1 = column[11];
				String FIB2 = column[12];
				ReaderData rd = new ReaderData(topic, lesson, title, page, content, questionType, 
						question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, FIB1, FIB2);
				readerData.put(index, rd);	
				index++;
			}
		scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retrieveContent() {
		HashMap <String, String> content = new HashMap <>();
		for (int target : readerData.keySet()) {
			ReaderData r = readerData.get(target);
			String title = r.getTitle();
			String topic = r.getTopic();
			String lesson = r.getLesson();
		}
	}
	
	public static void main(String[] args) {
		Reader r = new Reader();
		r.retrieveContent();
	}
}