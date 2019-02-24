import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class UI {
	
	public UI() {
		JFrame frame = new JFrame();
		
		Board board = new Board();
		BufferedImage boardImage = board.getImage();
		
		JLabel boardLabel = new JLabel(new ImageIcon(boardImage));
		
		frame.getContentPane().add(boardLabel);
		
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Boggle by Team 12");
		//frame.setResizable(false);
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
