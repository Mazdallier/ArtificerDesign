package ad.Genis231.Resources;

import ad.Genis231.Refrence.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookReader {
	Scanner scanner;
	InputStream stream;
	ArrayList<String> list = new ArrayList<String>();
	
	public BookReader(String name) {
		ResourceLocation stuff = new ResourceLocation(Ref.Resource_FOLDER, "SkillBook/" + name + ".artificer");
		
		File file = new File("mods/desc/" + name + ".artificer");
		
		if (file.exists()) {
			try {
				this.scanner = new Scanner(file);
			}
			catch (FileNotFoundException e) {
				System.out.println("Scanner failed to initalize");
			}
			
		} else
			try {
				stream = Ref.getResource(stuff);
				this.scanner = new Scanner(stream);
			}
			catch (NullPointerException e) {
				System.out.println("Scanner failed to initalize");
			}
			catch (IOException e) {
				System.out.println("File: '" + name + ".artificer" + "' Dose not Exist");
			}
		
	}
	
	public ArrayList<String> getText() {
		if (scanner == null) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("This has no File to be read! :P");
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
