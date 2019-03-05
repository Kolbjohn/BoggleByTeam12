import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Board {
	private int IMG_SIZE = 700;
	private int LINE_SIZE = 5;
	
	private BufferedImage image;
	
	public Board() {
		image = new BufferedImage(IMG_SIZE, IMG_SIZE, BufferedImage.TYPE_INT_RGB);
		int height = image.getHeight();
		int width = image.getWidth();
		
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
		g2d.setColor(Color.BLACK);
		
		g2d.fillRect(0, 0, width, LINE_SIZE);
		g2d.fillRect(0, height - LINE_SIZE, width, LINE_SIZE);
		g2d.fillRect(0, 0, LINE_SIZE, height);
		g2d.fillRect(width - LINE_SIZE, 0, LINE_SIZE, height);
		
		g2d.fillRect(width / 4 - (LINE_SIZE / 2), 0, LINE_SIZE, height);
		g2d.fillRect(width / 2 - (LINE_SIZE / 2), 0, LINE_SIZE, height);
		g2d.fillRect((int)(width * .75) - (LINE_SIZE / 2), 0, LINE_SIZE, height);
		
		g2d.fillRect(0, height / 4 - (LINE_SIZE / 2), width, LINE_SIZE);
		g2d.fillRect(0, height / 2 - (LINE_SIZE / 2), width, LINE_SIZE);
		g2d.fillRect(0, (int)(height * .75) - (LINE_SIZE / 2), width, LINE_SIZE);
		
		g2d.setFont(new Font("Arial", Font.PLAIN, 150));
		g2d.drawString("B", 40, 140);
		g2d.drawString("O", 200, 140);
		g2d.drawString("G", 380, 140);
		g2d.drawString("G", 550, 140);
		g2d.drawString("L", 50, 320);
		g2d.drawString("E", 210, 320);
		g2d.drawString("B", 380, 320);
		g2d.drawString("Y", 550, 320);
		g2d.drawString("T", 40, 500);
		g2d.drawString("E", 210, 500);
		g2d.drawString("A", 380, 500);
		g2d.drawString("M", 550, 500);
		g2d.drawString("1", 50, 670);
		g2d.drawString("2", 220, 670);
		g2d.drawString("!", 410, 670);
		g2d.drawString("!", 580, 670);
		
		g2d.dispose();
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
