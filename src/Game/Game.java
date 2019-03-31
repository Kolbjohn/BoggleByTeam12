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
		dictionary = new Dictionary();
		score = 0;
		currentWord = "";
		wordList = new ArrayList<>();
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

	public String getFormattedList() {
		StringBuilder formattedList = new StringBuilder("<html>");
		if(wordList.size() >= 1) {
			for (int i = 0; i < wordList.size() - 1; i++) {
				formattedList.append(wordList.get(i) + "<br>");
			}
			formattedList.append(wordList.get(wordList.size() - 1) + "</html>");
		}
		return formattedList.toString();
	}

	public static void startGame() {

	}

	public void submitWord() {
		if(!wordList.contains(currentWord)) {
			int length = currentWord.length();
			if (length >= 3) {
				if (this.dictionary.checkWord(currentWord)) {
					switch (length) {
						case 3:
							score += 1;
							break;
						case 4:
							score += 1;
							break;
						case 5:
							score += 2;
							break;
						case 6:
							score += 3;
							break;
						case 7:
							score += 5;
							break;
						default:
							score += 11;
							break;
					}
					this.wordList.add(currentWord);
				}
			}
		}
		currentWord = "";
	}
	
	//test function
	public static void clearHighlights() {
		board.clearHighlights();
	}

	public int getScore() {
		return this.score;
	}

	public String getLatestWord(){
		return wordList.size() < 1 ? "-" : wordList.get(wordList.size()-1);
	}
}
