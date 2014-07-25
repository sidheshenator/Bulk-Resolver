package com.sidheshenator.bulkIPResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {

	
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

			String sCurrentLine;
			BufferedReader br = null;
			File inputFile = new File("C://tmpBRMod2.txt");
			File bpuReport = new File("C://BRMod2.txt");
			File geoLocationFile = new File("..\\..\\..\\..\\res\\GeoLiteCity.dat");
			FileWriter writer2 = new FileWriter(bpuReport);
			String newLineSeperator = System.getProperty("line.separator");
			br = new BufferedReader(new FileReader(inputFile));

			while ((sCurrentLine = br.readLine()) != null) {
				Pattern pattern = Pattern.compile("\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}");
				Matcher matcher = pattern.matcher(sCurrentLine);
				while (matcher.find())
				{
					IPObject obj = new IPObject();
					obj.setIP(matcher.group());
				    System.out.println("Pinging "+obj.getIP()+"...");
				    
				    Utility.IPResolver(obj);
				    Utility.getGeoLocation(obj, geoLocationFile);
				    Utility.getMachineType(obj);
				    writer2.write(obj.toString());
				    writer2.flush();
				}
				writer2.write(newLineSeperator);
		    	writer2.flush();
			}
			writer2.close();
			br.close();
			inputFile.delete();
			openNotepad("C://BRMod2.txt");
			System.out.println("Task completed.\nFile- C://BRMod2.txt is generated.\n\nPress enter to exit.");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			sc.close();
			return;
 
		} catch (IOException e) {
			File newFile = new File("C://tmpBRMod2.txt");
			try {
				newFile.createNewFile();
				FileWriter writer1 = new FileWriter(newFile); 
				String newLineSeperator = System.getProperty("line.separator");
			    writer1.write("Paste the text in this file and save the changes."+newLineSeperator+newLineSeperator); 
			    writer1.flush();
			    writer1.close();
			    openNotepad("C://tmpBRMod2.txt");
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
