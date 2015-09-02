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

public class FreeMode extends JPanel implements KeyListener{
	JButton bXF, b_F, bHelp, bZoom, bSave, bLoad, bBackF, bPlay, bStop, bAddPuck, bTrajectory, bGraph, bPrint;
	
	JTextField tilt;
	
	JSlider speed;
	
	BufferedImage img;
	
	Help help;
	
	Table table;
	
	JTextField tiltF;
	
	public FreeMode(Table table){
		
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		try {
			img = ImageIO.read(new File("4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.table = table;
		table.addKeyListener(this);
		add(table);
//		table.addMouseListener(table);
		table.setBounds(20, 90, 762, 445);
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
	
	public void setButtons(JTextField tiltF, JSlider speed, JButton bXF, JButton b_F,JButton bHelp,JButton bZoom,JButton bSave,JButton bLoad,JButton bBackF,JButton bPlay,JButton bStop,JButton bAddPuck, JButton bTrajectory, JButton bPrint, JButton bGraph){
		this.b_F = b_F;
		this.bHelp = bHelp;
		this.bXF = bXF;
		this.bZoom = bZoom;
		this.bSave = bSave;
		this.bLoad = bLoad;
		this.bBackF = bBackF;
		this.bPlay = bPlay;
		this.bStop = bStop;
		this.bAddPuck = bAddPuck;
		this.speed = speed;
		this.bTrajectory = bTrajectory;
		this.tiltF = tiltF;
		this.bPrint = bPrint;
		this.bGraph = bGraph;
		
		add(speed);
		add(b_F);
		add(bHelp);
		add(bXF);
		add(bZoom);
		add(bSave);
		add(bLoad);
		add(bBackF);
		add(bPlay);
		add(bStop);
		add(bAddPuck);
		add(bTrajectory);
		add(tiltF);
		add(bPrint);
		add(bGraph);
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
			speed.setValue(speed.getValue() + 1);
		}
		
		else if (e.getKeyCode() == e.VK_LEFT)
		{
			speed.setValue(speed.getValue() - 1);
		}
		
		else if (e.getKeyCode() == e.VK_UP)
		{
			if (table.getTiltable() && table.getTiltAngle() < 90)
			{
				table.setTiltAngle( table.getTiltAngle() + 5);
				
				tiltF.setText(table.getTiltAngle() + "");
			}
		}
		
		else if (e.getKeyCode() == e.VK_DOWN)
		{
			if (table.getTiltable() && table.getTiltAngle() > 0)
			{
				table.setTiltAngle( table.getTiltAngle() - 5);
				
				tiltF.setText(table.getTiltAngle() + "");
			}
		}
		
		else if (e.getKeyCode() == e.VK_ENTER)
		{
			if( !table.getTimer().isRunning())
			{
				table.start();
				bPlay.setIcon(new ImageIcon("pause2.png"));
				table.setRelocatable(false);
			}
			else
			{
				table.stop();
				bPlay.setIcon(new ImageIcon("play.png"));
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

}
