import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameTimer extends JLabel implements ActionListener{
	
	private static Timer timer;
	private int timeRemaining;
	
	public GameTimer(int timeRemaining) {
		this.timeRemaining = timeRemaining;
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 3, Color.BLACK));
		this.setFont(new Font("Arial", Font.PLAIN, 50));
		this.setForeground(Color.BLUE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 100));
		
		if (timeRemaining - ((timeRemaining/60) * 60) < 10) {
			this.setText(Integer.toString(timeRemaining/60) + ":0" + Integer.toString(timeRemaining - ((timeRemaining/60) * 60)));
		} else {
			this.setText(Integer.toString(timeRemaining/60) + ":" + Integer.toString(timeRemaining - ((timeRemaining/60) * 60)));
		}
		
		timer = new Timer(1000, this);
		timer.setInitialDelay(0);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (timeRemaining == 0) {
			this.setText("<html>GAME<br>OVER</html>");
			this.setForeground(Color.RED);
			timer.stop();
			Game.clearHighlights();
		} else {
			timeRemaining--;
			if (timeRemaining - ((timeRemaining/60) * 60) < 10) {
				this.setText(Integer.toString(timeRemaining/60) + ":0" + Integer.toString(timeRemaining - ((timeRemaining/60) * 60)));
			} else {
				this.setText(Integer.toString(timeRemaining/60) + ":" + Integer.toString(timeRemaining - ((timeRemaining/60) * 60)));
			}
		}
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public static boolean isRunning() {
		return timer.isRunning();
	}

}
