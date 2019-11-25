package jpd.hallt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	private File file;
	private Scanner scanner;
	
	public FileReader(File file) {
		this.file = file;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getNextLine() {
		return scanner.nextLine();
	}
	
	public boolean hasNext() {
		if (scanner.hasNextLine()) {
			return true;
		}
		return false;
	}
}
