import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class UI {
	
	public UI() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		Board board = new Board();
		BufferedImage boardImage = board.getImage();
		
		JLabel boardLabel = new JLabel(new ImageIcon(boardImage));
		boardLabel.setBounds(200, 0, 700, 700);
		
		JLabel wordListLabel = new JLabel();
		wordListLabel.setOpaque(true);
		wordListLabel.setBackground(Color.WHITE);
		wordListLabel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, Color.BLACK));
		wordListLabel.setBounds(0, 0, 200, 700);
		
		JLabel timerLabel = new JLabel();
		timerLabel.setOpaque(true);
		timerLabel.setBackground(Color.WHITE);
		timerLabel.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 3, Color.BLACK));
		
		JLabel scoreLabel = new JLabel();
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 2, 5, 5, Color.BLACK));
		
		JButton button = new JButton();
		button.setFocusable(false);
		
		JPanel bottom = new JPanel(new GridLayout(1, 3, 0, 0));
		bottom.add(timerLabel);
		bottom.add(scoreLabel);
		bottom.add(button);
		bottom.setBounds(0, 700, 900, 200);
		
		frame.getContentPane().add(wordListLabel);
		frame.getContentPane().add(boardLabel);
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
