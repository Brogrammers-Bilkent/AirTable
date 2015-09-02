import java.util.*;
import java.awt.*;

/**
 * Dot Class
 *
 *
 * Hamed Mohammadi
 * Version 1.00 2014/4/28
 */


public class Dot
{
	// Properties
	private Vector speed;
	private Vector location;
	private long time;
	
	// Constructor
    public Dot (Vector location, Vector speed, long time)
    {
    	this.location = location;
    	this.speed = speed;
    	this.time = time;
    }
    
    // Methods
    public Vector getLocation()
    {
    	return location;
    }
    
    public Vector getSpeed()
    {
    	return speed;
    }
    
    public void setTime( long time) 
    {
    	this.time = time;
    }
    
    public long getTime() 
    {
    	return time;
    }
    
    public String toString()
    {
    	return "X: " + location.getX() + " ** Y: " + location.getY() + "\n";
    }
    
}