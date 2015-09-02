import java.util.ArrayList;
import java.awt.Graphics;
/**
 * Graph Class
 *
 *
 * Hamed Mohammadi
 * Version 1.00 2014/4/28
 */


public class Graph {

	// Properties
	final int TIME_SPEED = 1;
	final int TIME_ENERGY = 2;
	final int TIME_MOMENTUM = 3;
	
	private ArrayList<Trajectory> trajectories;
	private long scale;
	private int type;
    private Dot previous;
    private Dot current;
 
    
    // Constructor
    public Graph (ArrayList<Trajectory> trajectories, int type)
    {
    	this.trajectories = trajectories;
    	scale = 1;
    	this.type = type;
    }
    
    public Graph (ArrayList<Trajectory> trajectories)
    {
    	this (trajectories, 1);
    }
    
    // Methods
    public long getScale()
    {
    	return scale;
    }
    
    public void setScale (long scale)
    {
    	this.scale = scale;
    }
    
    public int getType()
    {
    	return type;
    }
    
    public void setType (int type)
    {
    	this.type = type;
    }
    
    public void draw(Graphics g)
    {
    	for (int t = 0; t < trajectories.size(); t++)
    	{
    		if ( trajectories.get(t).dots.size() != 0)
    		{
    			previous = trajectories.get(t).dots.get(0);
    			scale = trajectories.get(t).dots.get(trajectories.get(t).dots.size() - 1).getTime();
	    		g.setColor(trajectories.get(t).getColor());
	    		
	    		for (int d = 1; d < trajectories.get(t).dots.size(); d++)
	    		{	
	    			current = trajectories.get(t).dots.get(d);
	    			g.drawLine( (int)(previous.getTime() * 680 /(scale)) + 50, 550 - (int)(previous.getSpeed().length() * 10), (int)(current.getTime() * 680 /(scale)) + 50, 550 - (int)(current.getSpeed().length() * 10));
	    			previous = trajectories.get(t).dots.get(d);
	    		}
    		}
    	}
    }
    
    public ArrayList<Trajectory> getTrajectories()
    {
    	return trajectories;
    }
}