package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tracking {
	
	private String file = "xp.txt";
	
	/**
	 * Every time a use chooses the correct answer, XP points increment by incrementXP
	 * We do this by recording incrementXP in a file called "xp.txt" 
	 * @param incrementXP
	 */
	public void writeScore(String incrementXP) {
		File out = new File(file);
		String xp = incrementXP;

		try {
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(xp);
			pw.flush();
			pw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write File.");
		}
		
	}
}
	

	


