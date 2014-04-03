package ad.Genis231.SkillBooks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class BookReader {
	Scanner scanner;
	ArrayList<String> list = new ArrayList<String>();
	
	public BookReader(String name) {
		try {
			InputStream file = this.getClass().getResourceAsStream(name + ".artificer");
			this.scanner = new Scanner(file);
		}
		catch (NullPointerException e) {
			System.out.println("File '" + name + ".artificer" + "' Dose not Exist");
		}
		
	}
	
	public ArrayList<String> getText() {
		if (scanner == null) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("This has no Description! :P");
			return temp;
		}
		FontRenderer font = Minecraft.getMinecraft().fontRenderer;
		String total = "";
		String part;
		
		while (scanner.hasNext()) {
			part = scanner.next();
			
			if (part.contains("[n]")) {
				list.add(total);
				total = "";
				list.add("");
				continue;
			}
			
			if (font.getStringWidth(total + part + " ") < 188)
				total += part + " ";
			else {
				list.add(total);
				total = part + " ";
			}
		}
		list.add(total);
		
		scanner.close();
		return list;
		
	}
}
