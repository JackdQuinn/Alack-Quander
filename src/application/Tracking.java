package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracking {
	
	private String file = "xp.txt";
	private ArrayList<Integer> xpPoints = new ArrayList<Integer>();

	/**
	 * Every time a use chooses the correct answer, XP points increment by incrementXP
	 * We do this by recording incrementXP in a file called "xp.txt" 
	 * which we will then read in the getPoints method
	 * @param incrementXP
	 */
	public void write(int incrementXP) {
		File out = new File(file);
		try( PrintWriter pw = new PrintWriter(out) ) {
			String xpS = Integer.toString(incrementXP);
			System.out.println(xpS);
			pw.println(xpS);
			pw.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write File.");
		}
	}
	
	public String read() {
		File f = new File(file);
		String xpS = null;
		try {
			Scanner s = new Scanner(f);
			while(s.hasNextInt()) {
				String xpString = s.nextLine();
				int xpAsInt = Integer.parseInt(xpString);
				xpPoints.add(xpAsInt);
			}
			int totalPoints = 0;
			for (Integer xpPoint : xpPoints) {
				totalPoints += xpPoint;
			}
			System.out.println(totalPoints);
			xpS = Integer.toString(totalPoints);
			System.out.println(xpS);
			s.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return xpS;
	}
	
//	public String getXP() {
//		int xp = 0;
//		for(int xpPoint : xpPoints) {
//			System.out.println(xpPoint);
//			xp = xpPoint;
//			xp++;
//		}
//		String xpS = Integer.toString(xp);
//		System.out.println(xpS);
//		return xpS;
//	}

}
	

	


