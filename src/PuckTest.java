import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
/**
 * @(#)PuckTest.java
 *
 * PuckTest application
 *
 * @author 
 * @version 1.00 2014/4/29
 */
 
public class PuckTest
{
    public static Table panel;
    
    public static void main(String[] args)
    {
    	panel = new Table( false, true);
    	
    	panel.addPuck (new Puck (panel, new Vector (350, 440), 100, new Vector (0, 0)));
    	panel.addPuck (new Puck (panel, new Vector (200, 440), 100, new Vector (2, -2)));
//    	panel.addPuck (new Puck (panel, new Vector (120, 300), 600, new Vector (-2, 3)));
//    	panel.addPuck (new Puck (panel, new Vector (50, 40), 120, new Vector (-4, 2)));
//    	panel.addPuck (new Puck (panel, new Vector (300, 290), 800, new Vector (-2, 1)));
//    	panel.addPuck (new Puck (panel, new Vector (220, 180), 700, new Vector (5, 2)));
    	
    	JFrame frame = new JFrame ("Test");
    	frame.add (panel);
    	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	frame.pack();
    	//frame.addKeyListener (panel);
    	frame.setVisible (true);
    	
    	panel.setSimulationSpeed (1);    	

    }
}
