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

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author Marcus Kopp Feb 18, 2017
 * v.1.0
 */
public class TweetGen extends Application {
//	private ArrayList<String> arrList = new ArrayList<String>();
	
	private static String headlinesPath = "resources/headlines.txt";
	private static String bewertungenPath = "resources/bewertungen.txt";
	private static String aussagePath = "resources/aussage.txt";
	private static String kommentarePath = "resources/kommentare.txt";
	
	@FXML
	private Label label = new Label();

	@FXML
	public void buttonPressed(){
		try {
			label.setWrapText(true);
			label.setMaxWidth(400);
			label.setText(makeTweet());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/main/main.fxml"));
			Scene scene = new Scene(root,500,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(makeTweet());
		launch(args);
		
		
		
	}
	
	/**
	 * Concatenates the selected elements from all lists and returns the tweet
	 * @return
	 * @throws IOException
	 */
	public static String makeTweet() throws IOException {
		String tweet = getElementFrom(headlinesPath)
				+ " " + getElementFrom(bewertungenPath)
				+ " " + getElementFrom(aussagePath)
				+ " " + getElementFrom(kommentarePath);
		if (tweet.length() <= 140) {
			return tweet;
		} else {
			return makeTweet();
		}
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

