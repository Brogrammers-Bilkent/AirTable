/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safa
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @(#)Puck.java
 *
 *
 * @author 
 * @version 1.00 2014/4/29
 */


public class IntroPuck {

	// Properties
	private final double FRICTION = 0.005;
	private Vector velocity, position;
	private int mass, elasticity, radius, collisionCounter;
	//private ArrayList<Trajectory> trajectories;
	private boolean isMagnetic;
	//private Table table;
	private double xSpeed, ySpeed;
	//private Trajectory trajectory;
        private IntroPanel introPanel;
	
	// Constructor
    public IntroPuck ( IntroPanel introPanel, Vector position, /*int mass*/ Vector velocity)
    {
    	//this.table = table;
    	this.position = position;
    	this.mass = 100;
    	this.velocity = velocity;
    	radius = 40;
        this.collisionCounter = 0;
    	//trajectories = new ArrayList<Trajectory>();
    	isMagnetic = false;
    	elasticity = 100;
    	updateSpeed();
    	//trajectory = new Trajectory();
        this.introPanel = introPanel;
    }
    
    /*public Puck (Table table, Vector position)
    {
    	this (table, position, 100, new Vector (10, 10));
    }*/
    
    // Methods
    public boolean getIsMagnetic()
    {
    	return isMagnetic;
    }
    
    /*public void setIsMagnetic( boolean isMagnetic)
    {
    	this.isMagnetic = isMagnetic;
    	
    	if (isMagnetic)
    	{
    		setElasticity(100);
    	}
    }*/
    
    /*public void setElasticity( int elasticity)
    {
    	this.elasticity = elasticity;
    }*/
    
    /*public int getElasticity()
    {
    	return elasticity;
    }*/
    
    public Vector getPosition()
    {
    	return position;
    }
    
    public int getRadius()
    {
    	return radius;
    }
    
    /*public Trajectory getTrajectory()
    {
    	return trajectory;
    }*/
    
    public void setVelocity (Vector velocity)
    {
    	this.velocity = velocity;
    	updateSpeed();
    }
    
    public Vector getVelocity()
    {
    	return velocity;
    }
    
    public boolean touches (IntroPuck puck)
    {
    	if (Vector.subtract (position, puck.position).length() <= radius + puck.radius)
    		return true;
    	else
    		return false;
    }
    
    public boolean touchesWalls ()
    {
    	if (position.getX() <= radius || position.getX() >= introPanel.getWidth() - radius
    		|| position.getY() <= radius || position.getY() >= introPanel.getHeight() - radius)
    		return true;
    	else
    		return false;
    }
    
    public void move()
    {
    	double dx, dy;
    	dx = xSpeed + position.getX();
    	dy = ySpeed + position.getY();
    	
    	position.setXY (dx, dy);
    	
    	/*if (introPanel.getHaveFriction())
    	{
    		System.out.println (table.getTiltAngle());
    		velocity = Vector.add (velocity, Vector.add (velocity.getUnit().scale (-1 * FRICTION * table.getGravity() * Math.cos( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000), new Vector (1, 0).scale(table.getGravity() * Math.sin( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000))); 
    		System.out.println (Vector.add (velocity.getUnit().scale (-1 * FRICTION * table.getGravity() * Math.cos( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000), new Vector (1, 0).scale(table.getGravity() * Math.sin( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000)));
    		System.out.println (velocity );
    	}
    	else
    	{
    		velocity = Vector.add (velocity, new Vector (1, 0).scale(introPanel.getGravity() * Math.sin( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000));
    		//System.out.println (new Vector (1, 0).scale(introPanel.getGravity() * Math.sin( Math.toRadians(table.getTiltAngle())) * table.getDelay() / 1000));
    	}*/
    	
    	updateSpeed();
    	    	
    	if (this.touchesWalls())
    	{
    		if (position.getX() <= radius || position.getX() >= introPanel.getWidth() - radius)
    		{
    			velocity.setXY (velocity.getX() * ((100.0 + elasticity) / 200.0) * (-1), velocity.getY());
    			while (touchesWalls())
    				position.setXY (position.getX() - xSpeed * 0.1, position.getY() - ySpeed * 0.1);
    		}
    		else
    		{
    			velocity.setXY (velocity.getX(), velocity.getY() * (-1) * ((100.0 + elasticity) / 200.0));
    			while (touchesWalls())
    				position.setXY (position.getX() - xSpeed * 0.1, position.getY() - ySpeed * 0.1);
    		}
    		
    		updateSpeed();
    	}
    	
    }
    
    public void updateSpeed()
    {
    	xSpeed = velocity.getX();
    	ySpeed = velocity.getY();
    }
    
    public void collide (IntroPuck puck)
    {
		if (!touches (puck))
			return;
		
		// Variables
		Vector n, un, ut, v1, v2, v1n, v1t, v2n, v2t, v1nAfter, v2nAfter, v1tAfter, v2tAfter;
		double v1n_m, v2n_m, v1t_m, v2t_m, v1nAfter_m, v2nAfter_m;
		
		// Move Away		
		while (touches (puck))
		{
			position.setXY (position.getX() - xSpeed * 0.1, position.getY() - ySpeed * 0.1);
			puck.position.setXY (puck.position.getX() - puck.xSpeed * 0.1, puck.position.getY() - puck.ySpeed * 0.1);
		}

		n = new Vector (puck.position.getX() - position.getX()
							, puck.position.getY() - position.getY());
		un = n.getUnit();
		ut = new Vector (un.getY() * (-1), un.getX());
		v1 = this.velocity;
		v2 = puck.velocity;
		
		v1n_m = un.dotProduct (v1);
		v1t_m = ut.dotProduct (v1);
		
		v2n_m = un.dotProduct (v2);
		v2t_m = ut.dotProduct (v2);
		
		v1nAfter_m = (v1n_m * (mass - puck.mass) + 2 * puck.mass * v2n_m)
					 / (mass + puck.mass) * ((elasticity + puck.elasticity) / 200.0);
		v2nAfter_m = (v2n_m * (puck.mass - mass) + 2 * mass * v1n_m) 
					 / (mass + puck.mass) * ((elasticity + puck.elasticity) / 200.0);
		
		v1nAfter = un.scalarProduct (v1nAfter_m);
		v2nAfter = un.scalarProduct (v2nAfter_m);
		v1tAfter = ut.scalarProduct (v1t_m);
		v2tAfter = ut.scalarProduct (v2t_m);
		
		this.setVelocity (Vector.add (v1nAfter, v1tAfter));
		puck.setVelocity (Vector.add (v2nAfter, v2tAfter));
		
                this.incrementCounter();
                puck.incrementCounter();
                
    }
    
    public void incrementCounter()
    {
        this.collisionCounter++;           
    }
    
    public int getCounter()
    {
        return this.collisionCounter;
    }

}
