import java.net.*;
import java.io.*;

import javax.swing.InputVerifier;

public class MyHTMLReader {
	public static void main(String[] args) throws Exception {

		// URL oracle = new URL("http://www.oracle.com/");
		URL oracle = new URL("http://shrib.com/SSnwjY6Q");
		String startTag = "<textarea ";
		String endTag = "</textarea>";
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		StringBuilder result = new StringBuilder();
		String inputLine;
		int textAreaOpened = 0;
		int indexStart = -1;
		int indexEnd = -1;
		int line = 0;
		int lineStart = 0;
		int lineEnd = 0;
		while ((inputLine = in.readLine()) != null) {
			if (indexStart==-1){
				indexStart = inputLine.indexOf(startTag);
				lineStart = line;
			}
			if (inputLine.indexOf(endTag)!=-1) {
				indexEnd = inputLine.indexOf(endTag);				
				lineEnd = line;
			}
			line++;
		}

		line = 0;
		in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		int desde = 0;
		int hasta = 0;
		while ((inputLine = in.readLine()) != null) {			
			if (line>=lineStart && line<=lineEnd){
				desde = 0;
				hasta = inputLine.length();
				if (line==lineStart) {
					desde = inputLine.indexOf(">") + 1;
				} 
				if (line==lineEnd) {
					hasta = inputLine.lastIndexOf("</textarea>");
				} 

				result.append(inputLine.substring(desde, hasta));
			}
			line ++;
		}
		System.out.println(result);
		System.out.println(indexStart + "-" + lineStart);
		System.out.println(indexEnd + "-" + lineEnd);
		
		in.close();
	}
}