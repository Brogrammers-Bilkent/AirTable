import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class CollisionPanel extends JPanel implements KeyListener{
	JButton bEraser, bRuler, bXC, b_C, bHelpC, bZoomC, bSaveC, bLoadC, bBackC, bPlayC, bStopC, bTrajectoryC, bPrintC, bGraphC;
	
	JTextField timerC;
	
	JSlider speedC;
	
	BufferedImage img;
	
	Help helpC;
	
	Table table;
	
	public CollisionPanel(Table table){
		
	
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.table = table;
		table.addKeyListener(this);
		add(table);
		table.setBounds(20, 90, 762, 445);
		table.addPuck (new Puck (table, new Vector (200, 200), 100, new Vector (2, -2)));
		table.addPuck (new Puck (table, new Vector (150, 150), 100, new Vector (2, -3)));
		table.setSimulationSpeed(1);
		//table.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (img != null){
			g.drawImage(img, 0, 0, null);

		}

	}
	
	public void setImage (String imageName){
		try {
			img = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}
	public void setButtons(JTextField timerC, JSlider speedC, JButton bXC, JButton b_C, JButton bHelpC, JButton bZoomC, JButton bSaveC, JButton bLoadC, JButton bBackC, JButton bPlayC, JButton bStopC, JButton bTrajectoryC, JButton bRuler, JButton bEraser, JButton bPrintC, JButton bGraphC){
		this.b_C = b_C;
		this.bHelpC = bHelpC;
		this.bXC = bXC;
		this.bZoomC = bZoomC;
		this.bSaveC = bSaveC;
		this.bLoadC = bLoadC;
		this.bBackC = bBackC;
		this.bPlayC = bPlayC;
		this.bStopC = bStopC;
		this.speedC = speedC;
		this.bTrajectoryC = bTrajectoryC;
		this.timerC = timerC;
		this.bEraser = bEraser;
		this.bRuler = bRuler;
		this.bGraphC = bGraphC;
		this.bPrintC = bPrintC;
		
		add(speedC);
		add(b_C);
		add(bHelpC);
		add(bXC);
		add(bZoomC);
		add(bSaveC);
		add(bLoadC);
		add(bBackC);
		add(bPlayC);
		add(bStopC);
		add(bTrajectoryC);
		add(timerC);
		add(bEraser);
		add(bRuler);
		add(bPrintC);
		add(bGraphC);
	}
	public void keyPressed( KeyEvent e)
	{
		if (e.getKeyCode() == e.VK_T)
		{	
			if (table.getTrajectoriesVisibility())
			{
				bTrajectoryC.setIcon(new ImageIcon("withoutTick.png"));
			}
			
			else 
			{
				bTrajectoryC.setIcon(new ImageIcon("tick.png"));
			}
			
			table.setTrajectoriesVisibility(!table.getTrajectory().getVisibility());
			table.repaint();
		}
		
		else if (e.getKeyCode() == e.VK_RIGHT)
		{
			speedC.setValue(speedC.getValue() + 1);
		}
		
		else if (e.getKeyCode() == e.VK_LEFT)
		{
			speedC.setValue(speedC.getValue() - 1);
		}
		
		else if (e.getKeyCode() == e.VK_ENTER)
		{
			if( !table.getTimer().isRunning())
			{
				table.start();
				bPlayC.setIcon(new ImageIcon("pause2.png"));
				table.setRelocatable(false);
			}
			else
			{
				table.stop();
				bPlayC.setIcon(new ImageIcon("play.png"));
				table.setRelocatable(true);
			}	
		}
		
		else if (e.getKeyCode() == e.VK_P)
		{
			table.stop();
			table.print();
		}
		
		
	}
	
	public void keyReleased( KeyEvent e)
	{
		
	}
	
	public void keyTyped( KeyEvent e)
	{
		
	}
	
	public void keyEntered( KeyEvent e)
	{
		
	}

}
