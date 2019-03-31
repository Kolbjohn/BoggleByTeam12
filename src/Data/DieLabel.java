package Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Game.Game;

@SuppressWarnings("serial")
public class DieLabel extends JLabel implements MouseListener{
	public static final Font font = new Font("Arial", Font.PLAIN, 150);
	public static final Font quFont = new Font("Arial", Font.PLAIN, 120);
	
	private int position;
	
	public DieLabel(int die) {
		
		this.position = die;
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setFont(font);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		
		//switch case for each die number
		switch (die) {
		case 0:
			this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
			this.setBounds(200, 0, 175, 175);
			this.setText("B");
			break;
		case 1:
			this.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			this.setBounds(375, 0, 175, 175);
			this.setText("O");
			break;
		case 2:
			this.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			this.setBounds(550, 0, 175, 175);
			this.setText("G");
			break;
		case 3:
			this.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			this.setBounds(725, 0, 175, 175);
			this.setText("G");
			break;
		case 4:
			this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			this.setBounds(200, 175, 175, 175);
			this.setText("L");
			break;
		case 5:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(375, 175, 175, 175);
			this.setText("E");
			break;
		case 6:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(550, 175, 175, 175);
			this.setText("B");
			break;
		case 7:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(725, 175, 175, 175);
			this.setText("Y");
			break;
		case 8:
			this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			this.setBounds(200, 350, 175, 175);
			this.setText("T");
			break;
		case 9:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(375, 350, 175, 175);
			this.setText("E");
			break;
		case 10:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(550, 350, 175, 175);
			this.setText("A");
			break;
		case 11:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(725, 350, 175, 175);
			this.setText("M");
			break;
		case 12:
			this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			this.setBounds(200, 525, 175, 175);
			this.setText("1");
			break;
		case 13:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(375, 525, 175, 175);
			this.setText("2");
			break;
		case 14:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(550, 525, 175, 175);
			this.setText("!");
			break;
		case 15:
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			this.setBounds(725, 525, 175, 175);
			this.setText("!");
			break;
		}
		
		addMouseListener(this);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (GameTimer.isRunning() && this.getBackground() == Color.WHITE) {
			this.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {
		if (GameTimer.isRunning() && this.getBackground() == Color.LIGHT_GRAY) {
			this.setBackground(Color.WHITE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (GameTimer.isRunning() && this.getBackground() != Color.GREEN) {
			this.setBackground(Color.GREEN);
			Game.addLetter(position, this.getText());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
