package Game;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Data.Board;
import Data.Dictionary;

import UI.UI;

public class Game {
	private static Board board;
	private Dictionary dictionary;
	private static int score;
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

	private void animate() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					board.randomize();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {}
				}
				
				UI.timer.startTimer();
			}
			
		}).start();
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

	public static void endGame() {
		board.clearHighlights();
		if (UI.isEnglish) {
			JOptionPane.showMessageDialog(null, "Game Over! Your score: " + score, "Game Over", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Spiel ist aus! Ihre Punktzahl: " + score, "Game Over", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void startGame() {
		animate();
		score = 0;
		wordList.clear();
		currentWord = "";
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
					this.wordList.add(0, currentWord);
				}
			}
		}
		currentWord = "";
		board.clearHighlights();
	}

	public int getScore() {
		return Game.score;
	}

	public String getLatestWord(){
		return wordList.size() < 1 ? "-" : wordList.get(0);
	}
}
