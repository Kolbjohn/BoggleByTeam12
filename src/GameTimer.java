import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameTimer extends JPanel implements ActionListener{
	
	private JLabel timerLabel;
	int timeRemaining;
	
	public GameTimer(int timeRemaining) {
		this.timeRemaining = timeRemaining;
		
		timerLabel = new JLabel("3:00");
		timerLabel.setOpaque(true);
		timerLabel.setBackground(Color.WHITE);
		timerLabel.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 3, Color.BLACK));
		timerLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		timerLabel.setForeground(Color.BLUE);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(timerLabel);
		
		Timer timer = new Timer(1000, this);
		//timer.setInitialDelay(1);
		timer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timeRemaining--;
		timerLabel.setText(Integer.toString(timeRemaining/60) + ":" + Integer.toString(timeRemaining - ((timeRemaining/60) * 60)));
	}

}
