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

public class GravityPanel extends JPanel implements KeyListener{
	JButton bXG, b_G, bHelpG, bZoomG, bSaveG, bLoadG, bBackG, bPlayG, bStopG, bTrajectoryG,
	bPrintG, bGraphG;
	
	JTextField tiltG, timerG;
	
	JSlider speedG;
	
	BufferedImage img;
	
	Help helpG;
	
	Table table;
	
	public GravityPanel(Table table){
		
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.table = table;
		table.addKeyListener(this);
		add(table);
		table.setBounds(20, 90, 762, 445);
		table.addPuck (new Puck (table, new Vector (200, 200), 100, new Vector (0, 0)));
		//table.addPuck (new Puck (table, new Vector (150, 150), 100, new Vector (2, -3)));
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
	public void setButtons(JTextField timerG, JTextField tiltG, JSlider speedG, JButton bXG, JButton b_G, JButton bHelpG, JButton bZoomG, JButton bSaveG, JButton bLoadG, JButton bBackG, JButton bPlayG, JButton bStopG, JButton bTrajectoryG, JButton bPrintG, JButton bGraphG){
		this.b_G = b_G;
		this.bHelpG = bHelpG;
		this.bXG = bXG;
		this.bZoomG = bZoomG;
		this.bSaveG = bSaveG;
		this.bLoadG = bLoadG;
		this.bBackG = bBackG;
		this.bPlayG = bPlayG;
		this.bStopG = bStopG;
		this.speedG = speedG;
		this.bTrajectoryG = bTrajectoryG;
		this.tiltG = tiltG;
		this.timerG = timerG;
		this.bGraphG = bGraphG;
		this.bPrintG = bPrintG;
		
		
		add(speedG);
		add(b_G);
		add(bHelpG);
		add(bXG);
		add(bZoomG);
		add(bSaveG);
		add(bLoadG);
		add(bBackG);
		add(bPlayG);
		add(bStopG);
		add(bTrajectoryG);
		add(tiltG);
		add(timerG);
		add(bGraphG);
		add(bPrintG);

	}
	public void keyPressed( KeyEvent e)
	{
		if (e.getKeyCode() == e.VK_T)
		{
			if (table.getTrajectoriesVisibility())
			{
				bTrajectoryG.setIcon(new ImageIcon("withoutTick.png"));
			}
			
			else 
			{
				bTrajectoryG.setIcon(new ImageIcon("tick.png"));
			}
			
			table.setTrajectoriesVisibility(!table.getTrajectory().getVisibility());
			table.repaint();
		}
		
		else if (e.getKeyCode() == e.VK_RIGHT)
		{
			speedG.setValue(speedG.getValue() + 1);
		}
		
		else if (e.getKeyCode() == e.VK_LEFT)
		{
			speedG.setValue(speedG.getValue() - 1);
		}
		
		else if (e.getKeyCode() == e.VK_UP)
		{
			if (table.getTiltable() && table.getTiltAngle() < 90)
			{
				table.setTiltAngle( table.getTiltAngle() + 5);
				
				tiltG.setText(table.getTiltAngle() + "");
			}
		}
		
		else if (e.getKeyCode() == e.VK_DOWN)
		{
			if (table.getTiltable() && table.getTiltAngle() > 0)
			{
				table.setTiltAngle( table.getTiltAngle() - 5);
				
				tiltG.setText(table.getTiltAngle() + "");
			}
		}
		
		else if (e.getKeyCode() == e.VK_ENTER)
		{
			if( !table.getTimer().isRunning())
			{
				table.start();
				bPlayG.setIcon(new ImageIcon("pause2.png"));
				table.setRelocatable(false);
			}
			else
			{
				table.stop();
				bPlayG.setIcon(new ImageIcon("play.png"));
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
