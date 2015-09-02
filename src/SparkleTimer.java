import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

/**
 * SparkleTimer Class
 *
 *
 * Hamed Mohammadi
 * Version 1.00 2014/4/28
 */


public class SparkleTimer
{

    // Properties
    private ArrayList<Puck> pucks;
    private Timer timer;
    private double simulationSpeed;
    private int period;
    private long startTime;
    private boolean isFirst;
    
    // Constructors
    public SparkleTimer ()
    {
    	this (null, 500, 1);
    	startTime = System.currentTimeMillis();
    	isFirst = true;
    }
    
    public SparkleTimer (ArrayList<Puck> pucks, int period, double simulationSpeed)
    {
    	this.pucks = pucks;
    	this.period = period / 5;
    	this.simulationSpeed = simulationSpeed;
   		isFirst = true;
    	startTime = System.currentTimeMillis();
    	timer = new Timer (0, new Listener());
    	updateTimer();
    }
    
    public SparkleTimer (ArrayList<Puck> pucks)
    {
    	this (pucks, 500, 1);
    }
    
    // Methods
    public int getPeriod()
    {
    	return period;
    }
    
    public void setPeriod (int period)
    {
    	this.period = period;
    	updateTimer();
    }
    
    public void start()
    {
    	timer.start();
    }
    
    public void stop()
    {
    	timer.stop();
    }
    
    public double getSimulationSpeed()
    {
    	return simulationSpeed;
    }
    
    public void setSimulationSpeed (double simulationSpeed)
    {
    	this.simulationSpeed = simulationSpeed;
    	updateTimer();
    }
    
    public void updateTimer()
    {
    	timer.setDelay ((int)(period / simulationSpeed));
    }
    
    public class Listener implements ActionListener
	{  
	    // ActionListener
	    @Override
	    public void actionPerformed (ActionEvent e)
	    {
	    	if (isFirst)
	    		startTime = System.currentTimeMillis();
	    		
	    	for (Puck puck : pucks)
	    	{	    		
	    		Dot current = new Dot (new Vector (puck.getPosition()), new Vector (puck.getVelocity()), System.currentTimeMillis() - startTime);
	    		puck.getTrajectory().addDot (current);
	  			
	  			System.out.println(current.getTime() + "  " + current.getSpeed().length());
	  			
	    	}
	    	
	    	isFirst = false;
	    }
	}
}

