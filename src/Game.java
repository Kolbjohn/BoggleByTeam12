import java.util.ArrayList;

import javax.swing.JFrame;

public class Game {
	private Board board;
	private Dictionary dictionary;
	private int score;
	private GameTimer timer;
	private String currentWord;
	private ArrayList<String> wordList;
	
	public Game(JFrame frame) {
		board = new Board(frame);
	}
	
	public static void addLetter(String letter) {
		
	}
	
	private void animate() {
		
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
	
	public void submitWord(String word) {
		
	}
	
}
