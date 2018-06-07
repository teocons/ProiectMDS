import java.util.*;
public class WFile {
	private Formatter file;
	private String fileName;
	
	public WFile(String s) {
		fileName = s;
	}
	
	public void open() {
		try {
			file = new Formatter(fileName);
		}
		catch(Exception e) {
			System.out.println("Error reading Highscore file!");
		}
	}
	
	public void addScore(int var) {
		file.format("%d%n", var);
	}
	
	public void close() {
		file.close();
	}
	
}