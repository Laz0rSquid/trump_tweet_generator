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
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Marcus Kopp Feb 18, 2017
 */
public class TweetGen {
//	private ArrayList<String> arrList = new ArrayList<String>();
	
	private static String headlinesPath = "resources/headlines.txt";
	
	public static void main(String[] args) throws IOException {
		System.out.println(makeTweet());
	}
	
	/**
	 * Concatenates the selected elements from all lists and returns the tweet
	 * @return
	 * @throws IOException
	 */
	public static String makeTweet() throws IOException {
		return getElementFrom(headlinesPath);
	}
	
	/**
	 * helper method for calling readFile() and chooseElement()
	 * @param path
	 * @return element from arrList as String
	 * @throws IOException
	 */
	public static String getElementFrom(String path) throws IOException {
		ArrayList<String> list = readFile(path);
		String element = chooseElement(list);
		return element;
	}
	
	/**
	 * Method for reading a text file line by line, and concatenating the lines into an ArrayList
	 * @param path
	 * @return ArrayList of txt file
	 * @throws IOException
	 */
	public static ArrayList<String> readFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		List<String> list = new ArrayList<String>();
		String line = "";
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();
		return (ArrayList<String>) list;
	}
	
	/**
	 * Returns a random element of an ArrayList as String
	 * @param arrList
	 * @return String
	 */
	public static String chooseElement(ArrayList<String> arrList) {
		/**
		 * creates a random integer between zero and the size of arrList
		 */
		int random = ThreadLocalRandom.current().nextInt(0, arrList.size());
		return arrList.get(random);
	}
}

