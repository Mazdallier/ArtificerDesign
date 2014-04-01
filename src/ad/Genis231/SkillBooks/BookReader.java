package ad.Genis231.SkillBooks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookReader {
	Scanner scanner;
	ArrayList<String> list = new ArrayList<String>();
	
	public BookReader(String name) {
		InputStream temp = this.getClass().getResourceAsStream(name + ".txt");
		
		if (temp == null) {
			System.out.println("File is derped");
			return;
		}
		
		scanner = new Scanner(temp);
		
		if (scanner == null) {
			System.out.println("scanner is derped");
			return;
		}
	}
	
	public ArrayList<String> getText() {
		if (scanner == null) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("This has no Description! :P");
			return temp;
		}
		
		while (scanner.hasNextLine()) {
			String total = scanner.nextLine();
				list.add(total);
		}
		
		scanner.close();
		return list;
		
	}
}
