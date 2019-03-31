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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import Data.Dictionary;
import Data.GameTimer;
import Game.Game;

public class UI {
	
	public UI() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		Game game = new Game(frame);
		GameTimer timer = new GameTimer(180);
		
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

		JLabel scoreLabel = new JLabel("<html><center>Score: 0<br><u>Latest Word</u><br>-</center></html>");
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		scoreLabel.setForeground(Color.BLUE);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 2, 5, 5, Color.BLACK));

		JButton button = new JButton("Start");
		button.setFocusable(false);
		button.setFont(new Font("Arial", Font.PLAIN, 50));
		button.setForeground(Color.BLUE);
		button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (timer.isRunning()) {
					game.clearHighlights();
					game.submitWord();
					scoreLabel.setText("<html><center>Score: "+game.getScore()+"<br><u>Latest Word</u><br>"+game.getLatestWord()+"</center></html>");
					wordListLabel.setText(game.getFormattedList());
				} else {
					game.animate();
					button.setText("Submit");
					timer.startTimer();
				}
			}
		});
		
		JPanel bottom = new JPanel(new GridLayout(1, 3, 0, 0));
		bottom.add(timer);
		bottom.add(scoreLabel);
		bottom.add(button);
		bottom.setBounds(0, 700, 900, 200);
		
		frame.getContentPane().add(scrollPanel);
		frame.getContentPane().add(bottom);
		
		frame.setSize(906, 935);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Boggle by Team 12");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
