/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Kopp Feb 18, 2017
 */
public class TweetGen {
	public static void main(String[] args) throws IOException {
		//File bewertungen = new File("ressources/bewertungen.txt");
		File headlines = new File("ressources/headlines.txt");
		FileReader fr = new FileReader(headlines);
		BufferedReader br = new BufferedReader(fr);
		List<String> headlineArray = new ArrayList<String>();
		String line = "";
		while ((line = br.readLine()) != null) {
			headlineArray.add(line);
		}
		for (String string : headlineArray) {
			System.out.println(string);
		}
		br.close();

	}
}
