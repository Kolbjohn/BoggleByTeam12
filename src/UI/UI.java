package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import Data.GameTimer;
import Game.Game;

public class UI {
	
	public static boolean isEnglish;
	
	public UI() {
		//creating frame
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setSize(906, 935);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Boggle by Team 12");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//getting language
		int option = JOptionPane.showOptionDialog(frame, "Please select your language.\nBitte wählen Sie Ihre Sprache.", "Language Select",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"English", "Deutsch"}, null);
		if (option == -1) {
			System.exit(0);
		} else if (option == 0){
			isEnglish = true;
		} else {
			isEnglish = false;
		}
		
		Game game = new Game(frame);
		GameTimer timer = new GameTimer(180);
		
		//creating scrolling label
		JLabel wordListLabel = new JLabel();
		wordListLabel.setText("");
		wordListLabel.setOpaque(true);
		wordListLabel.setBackground(Color.WHITE);
		wordListLabel.setVerticalAlignment(JLabel.TOP);
		wordListLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		JScrollPane scrollPanel = new JScrollPane(wordListLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, Color.BLACK));
		scrollPanel.setBounds(0, 0, 200, 700);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(40);

		//creating score label
		JLabel scoreLabel;
		if (isEnglish) {
			scoreLabel = new JLabel("<html><center>Score: 0<br><u>Latest Word</u><br>-</center></html>");
		} else {
			scoreLabel = new JLabel("<html><center>Ergebnis: 0<br><u>Letztes Wort</u><br>-</center></html>");
		}
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		scoreLabel.setForeground(Color.BLUE);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 2, 5, 5, Color.BLACK));

		//creating button
		JButton button = new JButton("Start");
		button.setFocusable(false);
		button.setFont(new Font("Arial", Font.PLAIN, 50));
		button.setForeground(Color.BLUE);
		button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) { //button functionality	
				if (GameTimer.isRunning()) {
					game.submitWord();
				} else {
					game.startGame();
					if (isEnglish) {
						button.setText("Submit");
					} else {
						button.setText("Einreichen");
					}
					timer.startTimer();
				}
				
				if (isEnglish) {
					scoreLabel.setText("<html><center>Score: "+game.getScore()+"<br><u>Latest Word</u><br>"+game.getLatestWord()+"</center></html>");
				} else {
					scoreLabel.setText("<html><center>Ergebnis: "+game.getScore()+"<br><u>Letztes Wort</u><br>"+game.getLatestWord()+"</center></html>");
				}
				wordListLabel.setText(game.getFormattedList());
			}
		});
		
		//creating bottom panel to hold bottom 3 UI elements
		JPanel bottom = new JPanel(new GridLayout(1, 3, 0, 0));
		bottom.add(timer);
		bottom.add(scoreLabel);
		bottom.add(button);
		bottom.setBounds(0, 700, 900, 200);
		
		//adding elements to frame
		frame.getContentPane().add(scrollPanel);
		frame.getContentPane().add(bottom);
		
		//starting frame
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new UI();
            }
        });
	}
}
