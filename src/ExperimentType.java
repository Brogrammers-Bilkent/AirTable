import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ExperimentType extends JPanel{
	static boolean helpOn = false;
	JButton bX, b_E, bHelp, bBack, bVelocity, bGravity, bCollision;
	BufferedImage img;
	static JFrame frm;
	static Help help;
	static boolean isHelpOn = false;
	public ExperimentType(){
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("ExpTypeBac.png"));
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
	
	public void setButtons(JButton bX, JButton b_E, JButton bHelp, JButton bBack, JButton bVelocity, JButton bGravity, JButton bCollision){
		this.bX = bX;
		this.b_E = b_E;
		this.bHelp = bHelp;
		this.bBack = bBack;
		this.bVelocity = bVelocity;
		this.bGravity = bGravity;
		this.bCollision = bCollision;
		
		add(bVelocity);
		add(bGravity);
		add(bCollision);
		
		add(b_E);
		add(bX);
		add(bHelp);
		
		add(bBack);
	}
	
	
}
