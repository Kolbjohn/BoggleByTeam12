package Data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;

import UI.UI;

public class Board {
	
	private ArrayList<Die> dice;
	private DieLabel[] dieLabels;
	private int[][] letterOrder;
	
	public Board(JFrame frame) {
		dieLabels = new DieLabel[16];
		
		for (int i = 0; i < dieLabels.length; i++) {
			dieLabels[i] = new DieLabel(i);
			frame.getContentPane().add(dieLabels[i]);
		}
		
		dice = new ArrayList<Die>();
		
		if (UI.isEnglish) {
			dice.add(new Die(new String[] {"R", "I", "F", "O", "B", "X"}));
			dice.add(new Die(new String[] {"H", "M", "S", "R", "A", "O"}));
			dice.add(new Die(new String[] {"Qu", "B", "M", "J", "O", "A"}));
			dice.add(new Die(new String[] {"E", "Z", "A", "V", "N", "D"}));
			dice.add(new Die(new String[] {"I", "F", "E", "H", "E", "Y"}));
			dice.add(new Die(new String[] {"L", "U", "P", "E", "T", "S"}));
			dice.add(new Die(new String[] {"E", "H", "I", "S", "P", "N"}));
			dice.add(new Die(new String[] {"R", "A", "L", "E", "S", "C"}));
			dice.add(new Die(new String[] {"D", "E", "N", "O", "W", "S"}));
			dice.add(new Die(new String[] {"A", "C", "I", "T", "O", "A"}));
			dice.add(new Die(new String[] {"V", "E", "T", "I", "G", "N"}));
			dice.add(new Die(new String[] {"U", "W", "I", "L", "R", "G"}));
			dice.add(new Die(new String[] {"U", "T", "O", "K", "N", "D"}));
			dice.add(new Die(new String[] {"Y", "L", "G", "K", "U", "E"}));
			dice.add(new Die(new String[] {"B", "A", "L", "I", "Y", "T"}));
			dice.add(new Die(new String[] {"P", "A", "C", "E", "M", "D"}));
		} else {
			dice.add(new Die(new String[] {"T", "D", "S", "N", "O", "E"}));
			dice.add(new Die(new String[] {"L", "R", "B", "T", "A", "I"}));
			dice.add(new Die(new String[] {"L", "A", "R", "E", "S", "C"}));
			dice.add(new Die(new String[] {"I", "O", "A", "A", "T", "E"}));
			dice.add(new Die(new String[] {"A", "B", "O", "J", "Q", "M"}));
			dice.add(new Die(new String[] {"X", "R", "I", "F", "O", "A"}));
			dice.add(new Die(new String[] {"O", "I", "A", "S", "M", "R"}));
			dice.add(new Die(new String[] {"I", "N", "E", "R", "H", "S"}));
			dice.add(new Die(new String[] {"I", "N", "E", "G", "V", "T"}));
			dice.add(new Die(new String[] {"S", "U", "T", "E", "P", "L"}));
			dice.add(new Die(new String[] {"E", "C", "A", "P", "M", "D"}));
			dice.add(new Die(new String[] {"R", "U", "E", "I", "L", "W"}));
			dice.add(new Die(new String[] {"U", "T", "O", "K", "E", "N"}));
			dice.add(new Die(new String[] {"L", "G", "N", "Y", "E", "U"}));
			dice.add(new Die(new String[] {"H", "E", "F", "S", "I", "E"}));
			dice.add(new Die(new String[] {"A", "Z", "E", "V", "N", "D"}));
		}
		
		letterOrder = new int[4][4];
		for (int i = 0; i < letterOrder.length; i++) {
			for (int j = 0; j < letterOrder[i].length; j++) {
				letterOrder[i][j] = 0;
			}
		}
	}
	
	public void randomize() {
		Collections.shuffle(dice);
		
		for (int i = 0; i < dieLabels.length; i++) {
			String text = dice.get(i).randomize();
			if (text.equals("Qu")) {
				dieLabels[i].setFont(DieLabel.quFont);
			} else {
				dieLabels[i].setFont(DieLabel.font);
			}
			dieLabels[i].setText(text);
		}
	}
	
	public void clearHighlights() {
		for (JLabel dieLabel : dieLabels) {
			dieLabel.setBackground(Color.WHITE);
		}
		
		for (int i = 0; i < letterOrder.length; i++) {
			for (int j = 0; j < letterOrder[i].length; j++) {
				letterOrder[i][j] = 0;
			}
		}
	}
	
	public boolean isValid(int x, int y) {
		int currentLetter = getMax() + 1;
		letterOrder[x][y] = currentLetter;
		
		if (currentLetter == 1) {
			return true;
		}
		
		int[] prevIndices = getIndices(currentLetter - 1);
		if (Math.abs(x - prevIndices[0]) > 1 || Math.abs(y - prevIndices[1]) > 1) {
			return false;
		}
		
		//if move is diagonal
		if (Math.abs(x - prevIndices[0]) == 1 && Math.abs(y - prevIndices[1]) == 1) {
			if (letterOrder[x][prevIndices[1]] != 0 && letterOrder[prevIndices[0]][y] != 0) {
				return false;
			}
		}
	
		return true;
	}
	
	private int getMax() {
		int max = 0;
		
		for (int i = 0; i < letterOrder.length; i++) {
			for (int j = 0; j < letterOrder[i].length; j++) {
				if (letterOrder[i][j] > max)
					max = letterOrder[i][j];
			}
		}
		
		return max;
	}
	
	private int[] getIndices(int letter) {
		for (int i = 0; i < letterOrder.length; i++) {
			for (int j = 0; j < letterOrder[i].length; j++) {
				if (letterOrder[i][j] == letter) {
					return new int[] {i, j};
				}
			}
		}
		
		return null;
	}
 }
