import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;


public class MyProgressBar extends JPanel {
	private JProgressBar bar;
	
	public MyProgressBar(){
		//setLayout(null);
		bar = new JProgressBar();
		bar.setUI(new MyProgressUI());
		bar.setForeground(Color.BLUE);
		bar.setIndeterminate(true);
		this.add(bar);
		setBackground(Color.WHITE);
	}
	
	public class MyProgressUI extends BasicProgressBarUI{
		private Rectangle r = new Rectangle();
		
		private void paintIndeterminate(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			r = getBox(r);
			g.setColor(progressBar.getForeground());
			g.fillOval(r.x, r.y, r.width, r.height);
		}
	}
}
