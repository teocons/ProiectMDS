<<<<<<< HEAD
import java.io.*;
import java.util.*;



public class RFile {
	
	private Scanner scanner;
	private String fileName;
	
	public RFile(String s) {
		fileName = s;
	}
	
	public void open() {
		try {
			scanner = new Scanner(new File(fileName));
		}
		catch(Exception e) {
			System.out.println("Error reading file");
		}
	}
	
	public Boolean hasNext() {
		return scanner.hasNext();
	}
	
	public String read() {
		return scanner.next();
	}
	
	public void close() {
		scanner.close();
	}
	
}
=======
import java.io.*;
import java.util.*;



public class RFile {
	
	private Scanner scanner;
	private String fileName;
	
	public RFile(String s) {
		fileName = s;
	}
	
	public void open() {
		try {
			scanner = new Scanner(new File(fileName));
		}
		catch(Exception e) {
			System.out.println("Error reading file");
		}
	}
	
	public Boolean hasNext() {
		return scanner.hasNext();
	}
	
	public String read() {
		return scanner.next();
	}
	
	public void close() {
		scanner.close();
	}
	
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
