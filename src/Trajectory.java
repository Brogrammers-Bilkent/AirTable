import java.util.ArrayList;
import java.awt.*;

/**
 * Trajectory Class
 *
 *
 * Hamed Mohammadi
 * Version 1.00 2014/4/28
 */


public class Trajectory {

	// Properties
	static boolean visibility;
	
	ArrayList<Dot> dots;
	Color color;
		
	// Constructor
    public Trajectory( boolean visibility)
    {
    	this (Color.black, visibility);
    }
    
    public Trajectory()
    {
    	this.color = Color.black;
    	dots = new ArrayList<Dot>();
    }
    
    public Trajectory (Color color, boolean visibility)
    {
    	this.color = color;
    	dots = new ArrayList<Dot>();
    	this.visibility = visibility;
    }

    // Methods
    public void addDot (Dot dot)
    {
    	dots.add (dot);
    }
    
    public ArrayList<Dot> getDots()
    {
    	return dots;
    }
    
    public Color getColor()
    {
    	return color;
    }
    
    public void setColor (Color color)
    {
    	this.color = color;
    }
    
    public boolean getVisibility()
    {
    	return visibility;
    }
    
    public void setVisibility( boolean visibility)
    {
    	this.visibility = visibility;
    }
    
    public String toString()
    {
    	//g.setColor (color);
    	String result = "";
    	
    	for (Dot dot : dots)
    		result += dot;
    		//g.drawOval ((int)dot.getLocation().getX() - 1, (int)dot.getLocation().getY() - 1, 2, 2);
    	
    	result += "********************";
    	return result;
    }
    
}