import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.image.*;
import java.awt.print.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class Table extends JPanel implements MouseMotionListener, MouseListener
{
	
	// Properties
	private int PERIOD = 12;
	private double GRAVITY = 9.8;
	
	private ArrayList<Puck> pucks;
        private ArrayList<BufferedImage> imgs;
        private ArrayList<Color> clrs;
	private Timer timer;
	private double friction;
	private SparkleTimer st;
	private double simulationSpeed;
	private boolean haveFriction;
	private Trajectory trajectory;
	private boolean tiltable;
	private int tiltAngle;
	private boolean canAdd;
	private boolean isRulerActive;
	private Puck addingPuck;
	private JLabel distance;
	private double firstX = 0, firstY = 0, secX = 0, secY = 0;
	private boolean mouseTouchesPuck;
	private boolean relocatable;
	private Puck movingPuck, selectedPuck;
	private boolean zoomSelected;
	private int zoomReferenceX;
	private int zoomReferenceY;
	private int scale;
	private SettingsPanel settingsPanel;
	int type = 0;
        private BufferedImage p1;
        private BufferedImage p2;
        private BufferedImage p3;
        private BufferedImage p4;
        private BufferedImage p5;
        private BufferedImage p6;
        private BufferedImage p7;
        private BufferedImage p8;
        private BufferedImage p9;
        private BufferedImage p10;
        
        
	
	public Table ( Boolean haveFriction, Boolean tiltable) 
	{
		//distance = new JLabel();
		type = 0;
		mouseTouchesPuck = false;
		relocatable = true;
		simulationSpeed = 1;
		friction = 1;
		tiltAngle = 0;
		zoomSelected = false;
		zoomReferenceX = 0;
		zoomReferenceY = 0;
		scale = 1;
                
                // adding different colors to make different trajectories more colrful
                clrs = new ArrayList<Color>();
                
                clrs.add( new Color(0, 136, 136));//1
                clrs.add( new Color(140, 0, 140));//2
                clrs.add( new Color(136, 136, 0));//3
                clrs.add( new Color(127, 0, 0));//4
                clrs.add( new Color(0, 136, 0));//5
                clrs.add( new Color(0, 0, 136));//6
                clrs.add( new Color(196, 124, 0));//7
                clrs.add( new Color(155, 193, 126));//8
                clrs.add( new Color(118, 104, 163));//9
                clrs.add( new Color(160, 126, 101));//10 //end of adding colors
                
                
                // Adding puck images to imgs arraylist
                imgs = new ArrayList<BufferedImage>();
                
                p1 = null;
                p2 = null;
                p3 = null;
                p4 = null;
                p5 = null;
                p6 = null;
                p7 = null;
                p8 = null;
                p9 = null;
                p10 = null;
                
                try {
			p1 = ImageIO.read(new File("puck-1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p2 = ImageIO.read(new File("puck-2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p3 = ImageIO.read(new File("puck-3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p4 = ImageIO.read(new File("puck-4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p5 = ImageIO.read(new File("puck-5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p6 = ImageIO.read(new File("puck-6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p7 = ImageIO.read(new File("puck-7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p8 = ImageIO.read(new File("puck-8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p9 = ImageIO.read(new File("puck-9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p10 = ImageIO.read(new File("puck-10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                
                imgs.add(p1);
                imgs.add(p2);
                imgs.add(p3);
                imgs.add(p4);
                imgs.add(p5);
                imgs.add(p6);
                imgs.add(p7);
                imgs.add(p8);
                imgs.add(p9);
                imgs.add(p10);// end of images adding
                
		this.haveFriction = haveFriction;
		this.tiltable = tiltable;
		this.canAdd = false;
		this.isRulerActive = false;
		pucks = new ArrayList<Puck>();
		setPreferredSize (new Dimension (600, 500));
		trajectory = new Trajectory(false);
		timer = new Timer (PERIOD, new Listener());
		st = new SparkleTimer (pucks, 500, simulationSpeed);
		timer.setDelay ((int)(PERIOD / simulationSpeed));
		
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		setFocusable(true);		
		
		addMouseMotionListener(this);
		addMouseListener(this);
		//add(distance);
	}
	
	public Table ( Boolean haveFriction, Boolean tiltable, int type1)
	{
		//distance = new JLabel();
		mouseTouchesPuck = false;
		relocatable = true;
		type = type1;
		simulationSpeed = 1;
		friction = 1;
		tiltAngle = 0;
		zoomSelected = false;
		scale = 1;
		zoomReferenceX = 0;
		zoomReferenceY = 0;
		this.haveFriction = haveFriction;
		this.tiltable = tiltable;
		this.canAdd = false;
		this.isRulerActive = false;
		imgs = new ArrayList<BufferedImage>();
                
                p1 = null;
                p2 = null;
                p3 = null;
                p4 = null;
                p5 = null;
                p6 = null;
                p7 = null;
                p8 = null;
                p9 = null;
                p10 = null;
                
                try {
			p1 = ImageIO.read(new File("puck-1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p2 = ImageIO.read(new File("puck-2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p3 = ImageIO.read(new File("puck-3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p4 = ImageIO.read(new File("puck-4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p5 = ImageIO.read(new File("puck-5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p6 = ImageIO.read(new File("puck-6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p7 = ImageIO.read(new File("puck-7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p8 = ImageIO.read(new File("puck-8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p9 = ImageIO.read(new File("puck-9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                try {
			p10 = ImageIO.read(new File("puck-10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                
                imgs.add(p1);
                imgs.add(p2);
                imgs.add(p3);
                imgs.add(p4);
                imgs.add(p5);
                imgs.add(p6);
                imgs.add(p7);
                imgs.add(p8);
                imgs.add(p9);
                imgs.add(p10);
                
                // adding different colors to make different trajectories more colrful
                clrs = new ArrayList<Color>();
                
                clrs.add( new Color(0, 136, 136));//1
                clrs.add( new Color(140, 0, 140));//2
                clrs.add( new Color(136, 136, 0));//3
                clrs.add( new Color(127, 0, 0));//4
                clrs.add( new Color(0, 136, 0));//5
                clrs.add( new Color(0, 0, 136));//6
                clrs.add( new Color(196, 124, 0));//7
                clrs.add( new Color(155, 193, 126));//8
                clrs.add( new Color(118, 104, 163));//9
                clrs.add( new Color(160, 126, 101));//10 //end of adding colors
                
		setFocusable( true);
		//addingPuck = null;
		pucks = new ArrayList<Puck>();
		setPreferredSize (new Dimension (600, 500));
		trajectory = new Trajectory(false);
		timer = new Timer (PERIOD, new Listener());
		st = new SparkleTimer (pucks, 500, simulationSpeed);
		timer.setDelay ((int)(PERIOD / simulationSpeed));
//		if (type == 1)
//		{
//			addPuck(new Puck(this, new Vector (200, 200), 100, new Vector (2, 0)));
//		}
//		else if (type == 2){
//			addPuck(new Puck(this, new Vector (200, 200), 100, new Vector (2, -2)));
//			addPuck(new Puck(this, new Vector (400, 400), 100, new Vector (0, -2)));
//		}
		addMouseMotionListener(this);
		addMouseListener(this);
		//add(distance);
	}
	
	public void setIsRulerActive(boolean activity){
		isRulerActive = activity;
	}
	public void addPuck (Puck puck)
	{
		pucks.add (puck);
	}
	
	public void setRelocatable(boolean relocatable){
		this.relocatable = relocatable;
	}
	public void start()
	{
		timer.start();
		st.start();
	}
	
	public void stop()
	{
		timer.stop();
		st.stop();
	}
	
	public boolean getHaveFriction()
	{
		return haveFriction;
	}
	
	public void setHaveFriction( boolean haveFriction)
	{
		this.haveFriction = haveFriction;
	}
	
	public double getSimulationSpeed(){
		return simulationSpeed;
	}
	public double getGravity()
	{
		return GRAVITY;
	}	
	
	public Trajectory getTrajectory(){
		return trajectory;
	}
		
	public boolean getTiltable(){
		return tiltable;
	}
	
	public Timer getTimer(){
		return timer;
	}
	public int getTiltAngle()
	{
		return tiltAngle;
	}
		
	public void setTiltAngle( int tiltAngle)
	{
		this.tiltAngle = tiltAngle;
	}	
		
	public void setCanAdd( boolean canAdd)
	{
		this.canAdd = canAdd;
	}	
		
	public void restart() throws FileNotFoundException{
		stop();
		pucks = new ArrayList<Puck>();
		st = new SparkleTimer(pucks, 500, 1);
		System.out.println("hi");
		if (type == 1){
			System.out.println("ello");
			pucks.add(new Puck(this, new Vector(200, 200), 100, new Vector( 2, 0)));
		}
		else if (type == 2){
			pucks.add(new Puck(this, new Vector(400, 400), 100, new Vector( 0, 0)));
		}
		else if (type == 3)
		{
			pucks.add(new Puck(this, new Vector(200, 200), 100, new Vector( 2, -2)));
			pucks.add(new Puck(this, new Vector(400, 400), 100, new Vector( 0, -2)));
		}
		repaint();
	}
	
	public void restartLoad(){
		stop();
		
		pucks = new ArrayList<Puck>();
		st = new SparkleTimer(pucks, 500, 1);
		System.out.println("hi");
		repaint();
	}
	public int getDelay()
	{
		return timer.getDelay();
	}	
	
	public void setSimulationSpeed (double s)
	{
		if( s <= 4 && s >= 0.25)
		{
			this.simulationSpeed = s;
			System.out.println(s);
			st.setSimulationSpeed (s);
			timer.setDelay ((int)(PERIOD / s));
		}
	}
	
	public double getFriction()
	{
		return friction;
	}
	
	public void setTrajectoriesVisibility ( boolean visibility)
	{
		trajectory.setVisibility(visibility);
	}
	
	public boolean getTrajectoriesVisibility ()
	{
		return trajectory.getVisibility();
	}
	
	public void setSparkleTimer(int value){
		st.setPeriod(value);
	}
	
	public boolean getZoomSelected()
	{
		return zoomSelected;
	}
	
	public void setZoomSelected( boolean zoomSelected)
	{
		this.zoomSelected = zoomSelected;
	}
	
	public void movePuck() throws FileNotFoundException, IOException
	{
		for (Puck puck : pucks)
		{
			puck.move();
			
			repaint();
			
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
		super.paintComponent(g);
		g.drawImage( imgs.get(0), 0, 0, null);
		if ( scale != 1)
		{
			Graphics2D g2 = (Graphics2D) g;
		
			g2.translate( zoomReferenceX, zoomReferenceY);
			g2.scale(scale, scale);
			g2.translate(-zoomReferenceX, -zoomReferenceY);
		}
		
		g.setColor (Color.white);
		g.fillRect (0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.blue);		
		if ( addingPuck != null)
		{
			g.fillOval( (int)addingPuck.getPosition().getX() - addingPuck.getRadius(), (int)addingPuck.getPosition().getY() - addingPuck.getRadius(), 2 * addingPuck.getRadius(), 2 * addingPuck.getRadius());
		}
		
		if ( trajectory.getVisibility())
		{
			for (int i = 0; i < pucks.size(); i++)
			{
				ArrayList<Dot> dots = pucks.get(i).getTrajectory().getDots();
				
				g.setColor (clrs.get(i));
				for (Dot dot : dots)
					g.fillOval ((int)dot.getLocation().getX() - 2, (int)dot.getLocation().getY() - 2, 3, 3);
	
			}
		}
		
		g.setColor (Color.blue);
		for (int i = 0; i < pucks.size(); i++)
		{
			Vector p = pucks.get(i).getPosition();
			int r = pucks.get(i).getRadius();
			//g.fillOval ((int)p.getX() - r, (int)p.getY() - r, r * 2, r * 2);
                        g.drawImage( imgs.get(i), (int)p.getX() - r, (int)p.getY() - r, null);
		}
		g.drawLine((int)firstX, (int)firstY, (int)secX, (int)secY);
		
		
	
	}
	
	public void print()
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
	}
	
	public class Listener implements ActionListener
	{
	    @Override
	    public void actionPerformed (ActionEvent e)
	    {
                try {
                    movePuck();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                }
		}
	}
	
	public ArrayList<Puck> getPucks(){
		return pucks;
	}
	
	
	public void mouseDragged( MouseEvent m)
	{

	}

	public void mouseMoved( MouseEvent m)
	{
		if ( canAdd)
		{
                addingPuck = new Puck ( this , new Vector( m.getX(), m.getY()), 100, new Vector( 1, 0));
   //		relocatable = true;
		}
		else if (mouseTouchesPuck){
			
			movingPuck.setPosition(m.getX(), m.getY());
		}
		repaint();
	}	
	
	public void mousePressed( MouseEvent m)
	{
		
	}
	
	public void mouseReleased( MouseEvent m)
	{
		
	}
	
	public void mouseClicked( MouseEvent m)
	{
		relocatable = true;
		if (m.getButton() == m.BUTTON3){
			for (Puck xPuck : pucks){
				//canAdd = false;
				if (xPuck.touchesMouse(m.getX(), m.getY())){
					System.out.println("ananzaaa");
					selectedPuck = xPuck;
					settingsPanel = new SettingsPanel(this, selectedPuck, type);
					settingsPanel.setBounds(200, 200, 300, 300);
					this.add(settingsPanel);
					repaint();
					break;
				}
			}
			
			
		}
		
		else  if (isRulerActive){
			
			
			for (Puck xPuck : pucks){
				for (Trajectory trajectory : xPuck.getTrajectories()){
					for (Dot dot : trajectory.dots){
						if (m.getButton() == 1 && m.getX() == dot.getLocation().getX() && m.getY() == dot.getLocation().getY()){
							firstX = dot.getLocation().getX();
							firstY = dot.getLocation().getY();
						}
						else if (m.getButton() == 3 && m.getX() == dot.getLocation().getX() && m.getY() == dot.getLocation().getY()){
							secX = dot.getLocation().getX();
							secY = dot.getLocation().getY();
						}
					}
					
				}
				
			}
			
			distance = new JLabel(Math.sqrt(Math.pow(firstX - secX, 2) + Math.pow(firstY, secY)) + "");
			distance.setLocation((int)(firstX + secX)/2, (int)(firstY + secY)/2);
			
		}
		else if (relocatable){
			System.out.println("giriyo");
			for (Puck xPuck : pucks){
				//canAdd = false;
				if (m.getButton() == 1 && xPuck.touchesMouse(m.getX(), m.getY()) && !mouseTouchesPuck){
					mouseTouchesPuck = true;
					movingPuck = xPuck;
					
				}
				else if (m.getButton() == 1 && xPuck.touchesMouse(m.getX(), m.getY()) && !movingPuck.touchesWalls()){
					int touches = 0;

					for (Puck xpuck : pucks)
						if (xpuck.touches(movingPuck)){
							touches++;
						}
					if (touches <= 1){
						mouseTouchesPuck = false;
						movingPuck = null;
					}
				}
			}
		}
		
		if ( canAdd )
		{
			relocatable = false;
			//mouseTouchesPuck = false;
			System.out.println("Uy AHA!");
			boolean touches = false;
			for (Puck xpuck : pucks)
				if (xpuck.touches(addingPuck)){
					touches = true;
					break;
				}
			if (!touches && !addingPuck.touchesWalls())
			{
				//relocatable = false;
				canAdd = false;
				addPuck(addingPuck);
				addingPuck = null;
			}	
		
		}
		
		if ( zoomSelected && m.getButton() == m.BUTTON1 )
		{
			if ( scale < 4)
			{
				zoomReferenceX = m.getX();
				zoomReferenceY = m.getY();
				
				scale *= 2;
				
				System.out.println("Zoom In");
			}
			
		}
		
		else if ( zoomSelected && m.getButton() == m.BUTTON3 )
		{
			if ( scale > 1)
			{
				zoomReferenceX = m.getX();
				zoomReferenceY = m.getY();
				
				scale /= 2;
				System.out.println("Zoom out");
			}
			
		}
		
		repaint();
	}
	
	
	public void mouseEntered( MouseEvent m)
	{
		requestFocusInWindow();
	}
	
	public void mouseExited( MouseEvent m)
	{
		
	}
	
	
	
	
}
