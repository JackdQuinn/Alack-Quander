package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Tracking {
	
	public void getPoints(int incrementXP) {
		
		File out = new File("xp.txt");
		try( PrintWriter pw = new PrintWriter(out) ) {
			String xpS = Integer.toString(incrementXP);
			pw.println(xpS);
			pw.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write File.");
		}
	}
}
	


