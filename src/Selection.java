import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Selection extends JPanel {
	JButton bFree, bExp, bXS, b_S, bHelp;
	BufferedImage img = null;
	public Selection(){
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("sBac.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (img != null){
			g.drawImage(img, 0, 0, null);
		}
	}
	
	public void setButtons(JButton bXS, JButton b_S, JButton bFree, JButton bExp, JButton bHelp){
		this.bFree = bFree;
		this.bExp = bExp;
		this.bXS = bXS;
		this.b_S = b_S;
		this.bHelp = bHelp;
		
		add(bFree);
		add(b_S);
		add(bExp);
		add(bXS);
		add(bHelp);
		
	}


}
