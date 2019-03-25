import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DieLabelFactory {
	
	private static Font font = new Font("Arial", Font.PLAIN, 150);

	public static JLabel createDieLabel(int die) {
		JLabel label = new JLabel();
		
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if (label.getBackground() == Color.WHITE) {
					label.setBackground(Color.LIGHT_GRAY);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (label.getBackground() == Color.LIGHT_GRAY) {
					label.setBackground(Color.WHITE);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (label.getBackground() != Color.GREEN)
					label.setBackground(Color.GREEN);
				else
					label.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
        });
		
		//switch case for each die number
		switch (die) {
		case 0:
			label.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
			label.setBounds(200, 0, 175, 175);
			label.setText("B");
			break;
		case 1:
			label.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			label.setBounds(375, 0, 175, 175);
			label.setText("O");
			break;
		case 2:
			label.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			label.setBounds(550, 0, 175, 175);
			label.setText("G");
			break;
		case 3:
			label.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK));
			label.setBounds(725, 0, 175, 175);
			label.setText("G");
			break;
		case 4:
			label.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			label.setBounds(200, 175, 175, 175);
			label.setText("L");
			break;
		case 5:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(375, 175, 175, 175);
			label.setText("E");
			break;
		case 6:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(550, 175, 175, 175);
			label.setText("B");
			break;
		case 7:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(725, 175, 175, 175);
			label.setText("Y");
			break;
		case 8:
			label.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			label.setBounds(200, 350, 175, 175);
			label.setText("T");
			break;
		case 9:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(375, 350, 175, 175);
			label.setText("E");
			break;
		case 10:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(550, 350, 175, 175);
			label.setText("A");
			break;
		case 11:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(725, 350, 175, 175);
			label.setText("M");
			break;
		case 12:
			label.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK));
			label.setBounds(200, 525, 175, 175);
			label.setText("1");
			break;
		case 13:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(375, 525, 175, 175);
			label.setText("2");
			break;
		case 14:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(550, 525, 175, 175);
			label.setText("!");
			break;
		case 15:
			label.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.BLACK));
			label.setBounds(725, 525, 175, 175);
			label.setFont(new Font("Arial", Font.PLAIN, 125));
			label.setText("Qu");
			break;
		}
		
		return label;
	}
	
}
