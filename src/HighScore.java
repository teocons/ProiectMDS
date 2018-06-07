<<<<<<< HEAD

public class HighScore {
	private int[] score = new int[10];
	private RFile readFile;
	private WFile writeFile;
	private String lineRead;
	
	public HighScore(Handler handler) {
		for(int i = 0; i < 10; ++i) {
			score[i] = 3;
		}
		readFile = handler.getGame().getReadFile();
		writeFile = handler.getGame().getWriteFile();
	}
	
	public void readFile() {
		readFile.open();
		int i = 0;
		while(readFile.hasNext()) {
			lineRead = readFile.read();
			score[i] = Integer.parseInt(lineRead);
			++i;
		}
		readFile.close();
	}
	
	public void writeFile() {
		writeFile.open();
		
		System.out.println("pl");
		for(int i = 0; i < 10; ++i) {
			writeFile.addScore(score[i]);
		}
		writeFile.close();
		
		System.out.println("pl");
	}
	
	public String show() {
		String afis = new String();
		String afisLine = new String();
		
		for(int i = 0; i < 10; ++i) {
			if(score[i] == 0) {
				break;
			}
			else {
				afisLine = Integer.toString(i + 1);
				afisLine += ". ";
				afisLine += Integer.toString(score[i]);
				afisLine += "-";
				afis += afisLine;
			}
		}
		
		return afis;
	}
	
	public void addScore(int val) {
		int adaugPoz = 10;
		for(int i = 0; i < 10; ++i) {
			if(val < score[i]) {
				adaugPoz = i;
				break;
			}
		}
		
		if(adaugPoz < 10) {
			for(int i = 8; i >= adaugPoz; --i) {
				score[i + 1] = score[i];
			}
			score[adaugPoz] = val;
		}
	}
}
=======

public class HighScore {
	private int[] score = new int[10];
	private RFile readFile;
	private WFile writeFile;
	private String lineRead;
	
	public HighScore(Handler handler) {
		for(int i = 0; i < 10; ++i) {
			score[i] = 3;
		}
		readFile = handler.getGame().getReadFile();
		writeFile = handler.getGame().getWriteFile();
	}
	
	public void readFile() {
		readFile.open();
		int i = 0;
		while(readFile.hasNext()) {
			lineRead = readFile.read();
			score[i] = Integer.parseInt(lineRead);
			++i;
		}
		readFile.close();
	}
	
	public void writeFile() {
		writeFile.open();
		
		System.out.println("pl");
		for(int i = 0; i < 10; ++i) {
			writeFile.addScore(score[i]);
		}
		writeFile.close();
		
		System.out.println("pl");
	}
	
	public String show() {
		String afis = new String();
		String afisLine = new String();
		
		for(int i = 0; i < 10; ++i) {
			if(score[i] == 0) {
				break;
			}
			else {
				afisLine = Integer.toString(i + 1);
				afisLine += ". ";
				afisLine += Integer.toString(score[i]);
				afisLine += "-";
				afis += afisLine;
			}
		}
		
		return afis;
	}
	
	public void addScore(int val) {
		int adaugPoz = 10;
		for(int i = 0; i < 10; ++i) {
			if(val < score[i]) {
				adaugPoz = i;
				break;
			}
		}
		
		if(adaugPoz < 10) {
			for(int i = 8; i >= adaugPoz; --i) {
				score[i + 1] = score[i];
			}
			score[adaugPoz] = val;
		}
	}
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
