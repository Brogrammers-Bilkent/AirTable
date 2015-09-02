import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class FirstPage extends JPanel{
	static MyProgressBar progress;
	int x = 0;
	BufferedImage img = null;
	IntroPanel introPanel;
	
	public FirstPage(){
		setLayout(null);
		setPreferredSize(new Dimension(700, 700));
		try {
			img = ImageIO.read(new File("simplebackground.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		introPanel = new IntroPanel();
		//introPanel.setBounds(x, y, width, height);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (img != null){
			g.drawImage(img, 0, 0, null);
		}	
	}
	
}
