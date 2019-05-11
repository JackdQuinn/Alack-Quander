package application;

public abstract class TextRaw {

	/*
	 * This method takes in raw text and recognizes \n to make it display multiple lines
	 */
	public TextRaw() {
		super();
	}
	
	/** 
	 * @param toMakeOver is the big ugly block of strings not recognizing the newline symbol
	 * @return the new string that displays multiple lines
	 */
	public  String fixText(String toMakeOver) {
		while (toMakeOver.indexOf("\\n") >=0 ) {
			int index = toMakeOver.indexOf("\\n");
			toMakeOver = toMakeOver.substring(0, index) +"\n" + toMakeOver.substring(index+2);
		}
		return toMakeOver;
	}

}
