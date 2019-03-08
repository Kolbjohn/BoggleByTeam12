import javax.swing.JFrame;
import javax.swing.JLabel;

public class Board {
	
	private JLabel[] dice;
	
	public Board(JFrame frame) {
		dice = new JLabel[16];
		
		for (int i = 0; i < dice.length; i++) {
			dice[i] = DieLabelFactory.createDieLabel(i);
			frame.getContentPane().add(dice[i]);
		}
	}
}
