package ad.Genis231.SkillBooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import ad.Genis231.Gui.Resources.RenderIcons;

public class BookReader {
	Scanner scanner;
	ArrayList<String> list = new ArrayList<String>();
	
	public BookReader(String name) {
		File file = new File("mods/desc/" + name + ".artificer");
		
		if (file.exists()) {
			try {
				this.scanner = new Scanner(file);
			}
			catch (FileNotFoundException e) {
				System.out.println("ROAR!!!!");
			}
			
		} else
			try {
				InputStream stream = this.getClass().getResourceAsStream(name + ".artificer");
				this.scanner = new Scanner(stream);
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
			
			if (part.contains("[tab]")) {
				total += "   ";
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
