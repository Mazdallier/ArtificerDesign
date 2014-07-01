package ad.Genis231.Resources;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.minecraft.util.ResourceLocation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ad.Genis231.Refrence.Ref;

public class XMLReader {
	HashMap<String, String> map = new HashMap<String, String>();
	ArrayList<HashMap<String, String>> nodes = new ArrayList<HashMap<String, String>>();
	String parent = "Object";
	String[] keys = { "name", "tab", "posX", "posY", "gridX", "gridY", "desc", "page" };
	String[] objects = { "Name", "Map", "Desc", "Page" };
	
	public ArrayList<HashMap<String, String>> getNodes() {
		return nodes;
	}
	
	public void initXML(String file) {
		try {
			ResourceLocation stuff = new ResourceLocation(Ref.Resource_FOLDER, "SkillBook/" + file);
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(Ref.getResource(stuff));
			doc.getDocumentElement().normalize();
			
			NodeList listOfNodes = doc.getElementsByTagName(parent);
			for (int i = 0; i < listOfNodes.getLength(); i++) {
				Node currentNode = listOfNodes.item(i);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					map.put(keys[0], readNode(currentNode, objects[0]).getNodeValue().trim());
					
					String[] tempDim = (readNode(currentNode, objects[1]).getNodeValue().trim()).split(" ");
					
					map.put(keys[1], tempDim[0]); // Tab
					map.put(keys[2], tempDim[1]); // PosX
					map.put(keys[3], tempDim[2]); // PosY
					map.put(keys[4], tempDim[3]); // GridX
					map.put(keys[5], tempDim[4]); // GridY
					
					map.put(keys[6], readNode(currentNode, objects[2]).getNodeValue().trim());
					map.put(keys[7], readNode(currentNode, objects[3]).getNodeValue().trim());
					
					nodes.add((HashMap<String, String>) map.clone());
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File: '" + file + "' does not exist");
		}
		catch (NullPointerException e) {
			System.out.println("One of the Objects is empty or dose not exist!! fix it fucker");
		}
		catch (Exception e) {
			System.out.println("Had Trouble parseing file: " + file);
			e.printStackTrace();
		}
	}
	
	private Node readNode(Node currentNode, String node) {
		Element nodeElement = (Element) currentNode;
		
		NodeList mappingList = nodeElement.getElementsByTagName(node);
		Element mappingElement = (Element) mappingList.item(0);
		
		NodeList mappingText = mappingElement.getChildNodes();
		return (Node) mappingText.item(0);
	}
}
