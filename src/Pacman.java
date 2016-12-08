import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Pacman extends Shape{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private URL url;
	private BufferedImage img;
	private String fileName; 
	
	public Pacman(int xPos, int yPos, int width, int height, String fileName){
		super(xPos, yPos, width, height);
		this.fileName = fileName;
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		url = getClass().getResource(fileName);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g2d.drawImage(img, getxPos(), getyPos(), getWidth(), getHeight(), null);
	}
}
