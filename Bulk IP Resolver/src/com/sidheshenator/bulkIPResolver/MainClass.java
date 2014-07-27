package com.sidheshenator.bulkIPResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {


	private static Map<String, IPObject> m;

	private static IPObject initializeIPObject(String IP, Map<String, IPObject> m)
	{
		
		if(m.containsKey(IP))
			return (IPObject)m.get(IP);
		
		else
		{
			File geoLocationFile = new File(".\\.\\.\\.\\res\\GeoLiteCity.dat");
			IPObject obj = new IPObject();
			
			obj.setIP(IP);
			Utility.IPResolver(obj);
		    Utility.getGeoLocation(obj, geoLocationFile);
	
		    m.put(IP, obj);
			return obj;
		}
		
		
	}
	
	private static void openNotepad(String fileToBeOpen) {
		try {
			Runtime.getRuntime().exec("notepad " + fileToBeOpen);
			return;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			String sCurrentLine, IP;
			BufferedReader br = null;
			File inputFile = new File("tmpBRMod2.txt");
			File bpuReport = new File("BRMod2.txt");
			FileWriter writer = new FileWriter(bpuReport);
			String newLineSeperator = System.getProperty("line.separator");
			br = new BufferedReader(new FileReader(inputFile));
			m = new HashMap<String, IPObject>();
			
			while ((sCurrentLine = br.readLine()) != null) {
				Pattern pattern = Pattern.compile("\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}");
				Matcher matcher = pattern.matcher(sCurrentLine);
				while (matcher.find())
				{
				    IP = matcher.group();
					System.out.println("Resolving "+IP+"...");
					
					IPObject obj = initializeIPObject(IP, m);
				    
					writer.write(obj.toString());
				    writer.write(newLineSeperator);
				    writer.flush();
				}
			}
			writer.close();
			br.close();
			inputFile.delete();
			openNotepad("BRMod2.txt");
			System.out.println("Task completed.\nFile- BRMod2.txt is generated.\n\nPress enter to exit.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			sc.close();
			return;
 
		} catch (IOException e) {
			File newFile = new File("tmpBRMod2.txt");
			try {
				newFile.createNewFile();
				FileWriter writer1 = new FileWriter(newFile); 
				String newLineSeperator = System.getProperty("line.separator");
			    writer1.write("Paste the text in this file and save the changes."+newLineSeperator+newLineSeperator); 
			    writer1.flush();
			    writer1.close();
			    openNotepad("tmpBRMod2.txt");
			    System.out.println("Run the program again.");
			    return;
				}
				catch (IOException e1) {
				System.out.println("Unable to create the file.");
				}
			return;
		}
		
	}
		

}
