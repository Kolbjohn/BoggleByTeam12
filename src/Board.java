import java.awt.Color;
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
		
		g2d.dispose();
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
