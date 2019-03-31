package Game;

import java.util.ArrayList;

import javax.swing.JFrame;

import Data.Board;
import Data.Dictionary;
import Data.GameTimer;

public class Game {
	private static Board board; //currently static for testing
	private Dictionary dictionary;
	private int score;
	private GameTimer timer;
	private static String currentWord;
	private ArrayList<String> wordList;
	
	public Game(JFrame frame) {
		board = new Board(frame);
		
		currentWord = "";
	}
	
	public static void addLetter(int position, String letter) {
		currentWord += letter.toLowerCase();
		
		if (!board.isValid(position / 4, position % 4)) {
			board.clearHighlights();
			currentWord = "";
		}
	}
	
	//should be private
	public void animate() {
		board.randomize();
	}
	
	private String getFormattedList() {
		StringBuilder formattedList = new StringBuilder("<html>");
		for (int i = 0; i < wordList.size() - 1; i++) {
			formattedList.append(wordList.get(i) + "<br>");
		}
		formattedList.append(wordList.get(wordList.size() - 1) + "</html>");
		
		return formattedList.toString();
	}

	public static void startGame() {
		
	}
	
	public void submitWord() {
		
	}
	
	//test function
	public static void clearHighlights() {
		board.clearHighlights();
	}
	
}
