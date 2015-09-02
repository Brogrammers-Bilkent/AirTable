/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Safa
 */
public class IntroPanel extends JPanel
{
    // Properties
	private int PERÝOD = 12;
	
	private ArrayList<IntroPuck> pucks;
	private Timer timer;
	//private double friction;
	//private SparkleTimer st;
	private double simulationSpeed;
	private boolean haveFriction, finished;
	//private Trajectory trajectory;
        //BufferedImage img = null;
        //private ArrayList<BufferedImage> img;
        private BufferedImage f;
        private BufferedImage h;
        private BufferedImage sf;
        private BufferedImage y;
        private BufferedImage z;

	
	public IntroPanel ()
	{
		simulationSpeed = 1;
		//friction = 1;
		//this.haveFriction = haveFriction;
		pucks = new ArrayList<IntroPuck>();
		setPreferredSize (new Dimension (600, 500));
		//trajectory = new Trajectory(false);
		timer = new Timer (0,new Listener());
		//st = new SparkleTimer (pucks, 500, simulationSpeed);
		timer.setDelay ((int)(PERÝOD / simulationSpeed));
                finished = false;
                f = null;
                h = null;
                sf = null;
                y = null;
                z = null;
                try {
			f = ImageIO.read(new File("f.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			h = ImageIO.read(new File("h.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			sf = ImageIO.read(new File("s.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			y = ImageIO.read(new File("y.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			z = ImageIO.read(new File("z.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                /*try {
			img = ImageIO.read(new File("1A.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void addPuck (IntroPuck puck)
	{
		pucks.add (puck);
	}
	
	public void start()
	{
		timer.start();
                this.addPuck (new IntroPuck (this, new Vector (150, 250), new Vector (20, 0)));
                this.addPuck (new IntroPuck (this, new Vector (450, 250), new Vector (-20, 0)));

		//st.start();
	}
	
	public void stop()
	{
		timer.stop();
		//st.stop();
	}
	
	public boolean getHaveFriction()
	{
		return haveFriction;
	}
	
	public void setHaveFriction( boolean haveFriction)
	{
		this.haveFriction = haveFriction;
	}
	
	public void setSimulationSpeed (double s)
	{
		if( s <= 4 && s >= 0.25)
		{
			this.simulationSpeed = s;
			System.out.println(s);
			//st.setSimulationSpeed (s);
			timer.setDelay ((int)(PERÝOD / s));
		}
	}
	
	/*public double getFriction()
	{
		return friction;
	}*/
	
	/*public void setTrajectoriesVisibility ( boolean visibility)
	{
		trajectory.setVisibility(visibility);
	}*/
	
	public void movePuck()
	{
		for (IntroPuck puck : pucks)
		{
			puck.move();
			
			for (int i = pucks.indexOf (puck) + 1; i < pucks.size(); i++)
			{
				puck.collide (pucks.get(i));
			}
		}
		
		repaint();
	}
	
	@Override
	public void paintComponent (Graphics g)
	{	
                //if (img != null){
		//	g.drawImage(img, 0, 0, null);
		//}	
		g.setColor (Color.white);
		g.fillRect (0, 0, this.getWidth(), this.getHeight());
		
		/*if ( trajectory.getVisibility())
		{
			for (Puck puck : pucks)
			{
				ArrayList<Dot> dots = puck.getTrajectory().getDots();
				
				g.setColor (puck.getTrajectory().getColor());
				for (Dot dot : dots)
					g.fillOval ((int)dot.getLocation().getX() - 2, (int)dot.getLocation().getY() - 2, 3, 3);
	
			}
		}*/
		
		for (IntroPuck puck : pucks)
		{
			Vector p = puck.getPosition();
			int r = puck.getRadius();
                        int c = puck.getCounter();
                        String s = "BROGRAMMERS";
                        int t = c;
                        g.setFont(new Font("SERIF", 3, 30));
                        if( c <= s.length())
                        {
                            if( c < 3)
                                g.drawString(s.substring(0, c), 300-11*c, 240);
                            else
                                g.drawString(s.substring(0, c), 300-11*c, 260);
                            t = c;
                        }
                        else
                        {
                            g.setFont(new Font("SERIF", 3, 3*c));
                            g.drawString(s, 300-12*c, 260);
                        }    
                        if( c < 3)
                        {  
                            g.setColor (Color.BLACK);
                            g.drawOval((int)p.getX() - r, (int)p.getY() - r, r, r);
                            g.drawImage( z, 100, 0, null);
                        }
                        else if( c >= 3 && c < 6)
                        {
                            g.setColor (Color.BLACK);
                            g.drawOval ((int)p.getX() - r, (int)p.getY() - r, r * 2, r * 2);
                            if( c < 5)
                                g.drawImage( y, 300, 0, null);
                            else
                                g.drawImage( sf, 0, 300, null);
                        }
                        else if( c >=6 && c < 9)
                        {
                            g.setColor (Color.RED);
                            g.fillOval((int)p.getX() - r, (int)p.getY() - r, r * 2, r * 2);
                            if( c < 7)
                                g.drawImage( sf, 0, 300, null);
                            else
                                g.drawImage( f, 200, 300, null);
                        }
                        else if( c >=9 && c < 12)
                        {
                            g.setColor (Color.BLUE);
                            g.fillOval((int)p.getX() - r, (int)p.getY() - r, r * 2, r * 2);
                            g.drawImage( h, 400, 300, null);
                            if( c > 10)
                            {
                                g.drawImage( z, 100, 0, null);
                                g.drawImage( y, 300, 0, null);
                                g.drawImage( sf, 0, 300, null);
                                g.drawImage( f, 200, 300, null);
                            }
                        }
                        else if( c >= 12)
                        {
                            g.setColor(Color.LIGHT_GRAY);
                            g.fillOval((int)p.getX() - r, (int)p.getY() - r, 40-2*c, 40-2*c);
                            g.drawImage( h, 400, 300, null);
                            g.drawImage( z, 100, 0, null);
                            g.drawImage( y, 300, 0, null);
                            g.drawImage( sf, 0, 300, null);
                            g.drawImage( f, 200, 300, null);
                            
                        }
		}
                
		
	}

	
	/*public void print()
	{
		Printing printTrajectories = new Printing( pucks);
			
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable (printTrajectories);
        boolean ready = job.printDialog();
        if (ready) 
        {
            try 
            {
                 job.print();
            } catch (PrinterException ex) {
          
            }
        }
	}*/
	
	public class Listener implements ActionListener
	{
	    @Override
	    public void actionPerformed (ActionEvent e)
	    {            
                    movePuck();
                    if( pucks.get(0).getCounter() > 20)
                    {
                        IntroPanel.this.stop();
                        remove(IntroPanel.this);
                        revalidate();
                        IntroPanel.this.updateFinished();
                        
                        if( IntroPanel.this.isFinished())
                            System.out.println("ello");
                    }
            }
	}
        
	public void updateFinished()
        {
            this.finished = true;
        }
        
        public boolean isFinished()
        {
            return this.finished;
        }

	/*public void keyPressed( KeyEvent e)
	{
		if (e.getKeyCode() == e.VK_T)
		{
			setTrajectoriesVisibility(!trajectory.getVisibility());
		}
		
		else if (e.getKeyCode() == e.VK_RIGHT)
		{
			setSimulationSpeed( simulationSpeed * 2);
		}
		
		else if (e.getKeyCode() == e.VK_LEFT)
		{
			setSimulationSpeed( simulationSpeed / 2);
		}
		
		else if (e.getKeyCode() == e.VK_ENTER)
		{
			if( !timer.isRunning())
			{
				start();
			}
			else
			{
				stop();
			}	
		}
		
		else if (e.getKeyCode() == e.VK_P)
		{
			stop();
			print();
		}
                
                else if (e.getKeyCode() == e.VK_R )
                {
                    trajectory.reset();
                }
                
	}
	
    @Override
	public void keyReleased( KeyEvent e)
	{
		
	}
	
    @Override
	public void keyTyped( KeyEvent e)
	{
		
	}*/
        

}
