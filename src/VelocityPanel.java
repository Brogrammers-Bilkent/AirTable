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


public class VelocityPanel extends JPanel implements KeyListener{
	JButton bPrintV, bGraphV, bXV, b_V, bHelpV, bZoomV, bSaveV, bLoadV, bBackV, bPlayV, bStopV, bTrajectory;
	
	JTextField timer;
	
	JSlider speedV;
	
	BufferedImage img;
	
	Help help;
	
	Table table;

	public VelocityPanel(Table table){
		//this.table = table;
		//table = new Table(false, false, 1);
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.table = table;
		table.addKeyListener(this);
		add(table);
		table.setBounds(20, 90, 762, 445);
		table.addPuck (new Puck (table, new Vector (200, 200), 100, new Vector (2, -2)));
	//	table.addPuck (new Puck (table, new Vector (150, 150), 100, new Vector (2, -3)));
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
	
	public void setButtons(JTextField timer, JSlider speedV, JButton bXV, JButton b_V,JButton bHelpV,JButton bZoomV,JButton bSaveV,JButton bLoadV,JButton bBackV,JButton bPlayV,JButton bStopV, JButton bTrajectory, JButton bPrintV, JButton bGraphV){
		this.b_V = b_V;
		this.bHelpV = bHelpV;
		this.bXV = bXV;
		this.bZoomV = bZoomV;
		this.bSaveV = bSaveV;
		this.bLoadV = bLoadV;
		this.bBackV = bBackV;
		this.bPlayV = bPlayV;
		this.bStopV = bStopV;
		this.bTrajectory = bTrajectory;
		this.speedV = speedV;
		this.timer = timer;
		this.bPrintV = bPrintV;
		this.bGraphV = bGraphV;
		
		add(speedV);
		add(b_V);
		add(bHelpV);
		add(bXV);
		add(bZoomV);
		add(bSaveV);
		add(bLoadV);
		add(bBackV);
		add(bPlayV);
		add(bStopV);
		add(bTrajectory);
		add(timer);
		add(bPrintV);
		add(bGraphV);
	}
	public void keyPressed( KeyEvent e)
	{
		if (e.getKeyCode() == e.VK_T)
		{
			if (table.getTrajectoriesVisibility())
			{
				bTrajectory.setIcon(new ImageIcon("withoutTick.png"));
			}
			
			else 
			{
				bTrajectory.setIcon(new ImageIcon("tick.png"));
			}
			
			table.setTrajectoriesVisibility(!table.getTrajectory().getVisibility());
			table.repaint();
		}
		
		else if (e.getKeyCode() == e.VK_RIGHT)
		{
			speedV.setValue(speedV.getValue() + 1);
		}
		
		else if (e.getKeyCode() == e.VK_LEFT)
		{
			speedV.setValue(speedV.getValue() - 1);
		}
		
		else if (e.getKeyCode() == e.VK_ENTER)
		{
			if( !table.getTimer().isRunning())
			{
				table.start();
				bPlayV.setIcon(new ImageIcon("pause2.png"));
				table.setRelocatable(false);
			}
			else
			{
				table.stop();
				bPlayV.setIcon(new ImageIcon("play.png"));
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
