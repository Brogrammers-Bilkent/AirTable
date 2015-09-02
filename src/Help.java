import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Help extends JPanel {
	int win = 0;
	BufferedImage img = null;
	public Help (int window){
		win = window;
		if (window == 1){
			try {
				img = ImageIO.read(new File("help1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(516, 50, 300, 200);
		}
		else if (window == 2){
			try {
				img = ImageIO.read(new File("help2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(500, 50, 300, 200);
			
		}
		else if (window == 3){
			try {
				img = ImageIO.read(new File("freemodehelp.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(400, 0, 300, 200);
			
		}
		else if (window == 4){
			try {
				img = ImageIO.read(new File("velocityhelp.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(400, 0, 300, 200);
			
		}
		else if (window == 5){
			try {
				img = ImageIO.read(new File("gravityhelp.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(400, 0, 300, 200);
			
		}
		else if (window == 6){
			try {
				img = ImageIO.read(new File("collisionhelp.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setBounds(400, 0, 300, 200);
			
		}
		setOpaque(false);
		setVisible(true);
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (img != null)
			g.drawImage(img, 0,0,null);
	}
}
