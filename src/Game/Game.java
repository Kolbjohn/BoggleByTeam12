package Game;

import java.util.ArrayList;

import javax.swing.JFrame;

import Data.Board;
import Data.Dictionary;
import Data.GameTimer;

public class Game {
	private static Board board; //currently static for testing
	private int score;
	private GameTimer timer;
	private String currentWord;
	private ArrayList<String> wordList;
	
	public Game(JFrame frame) {
		board = new Board(frame);
		Dictionary.generateDictionary();
		wordList = new ArrayList<>();
		score = 0;
	}
	
	public static void addLetter(String letter) {
		
	}
	
	//should be private
	public void animate() {
		board.randomize();
	}
	
	public String getFormattedList() {
		StringBuilder formattedList = new StringBuilder("<html>");
		if(wordList.size() > 0) {
			for (int i = 0; i < wordList.size() - 1; i++) {
				formattedList.append(wordList.get(i) + "<br>");
			}
			formattedList.append(wordList.get(wordList.size() - 1) + "</html>");
		}
		return formattedList.toString();
	}

	public static void startGame() {
		
	}

	public int getScore(){
		return this.score;
	}

	public String getLatestWord(){
		return this.wordList.size() < 1 ? "-" : this.wordList.get(this.wordList.size()-1);
	}
	
	public void submitWord() {
		int length = this.currentWord == null ? 0 : this.currentWord.length();
		if(length >= 3){
			if(Dictionary.checkWord(this.currentWord)){
				switch (length) {
					case 3 : { score += 1; break; }
					case 4 : { score += 1; break; }
					case 5 : { score += 2; break; }
					case 6 : { score += 3; break; }
					case 7 : { score += 5; break; }
					default : { score += 11; break; }
				}
				this.wordList.add(this.currentWord);
			}
		}
		currentWord = "";
	}
	
	//test function
	public static void clearHighlights() {
		board.clearHighlights();
	}
	
}
