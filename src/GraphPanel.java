import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GraphPanel extends JPanel{
	JButton bXGr, b_Gr, bHelpGr, bZoomGr, bBackGr, bPrintGr;
	
	BufferedImage img;
	
	Help help;
	
	Graph graph;	
		
	Table table;	
		
	ArrayList<Trajectory> trajectories;	
	
	public GraphPanel(){
		
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
	
		try {
			img = ImageIO.read(new File("9.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (img != null){
			g.drawImage(img, 0, 0, null);
		}
		
		drawBareGraph(g);
		
		if ( graph != null)
		{
			graph.draw(g);
		}
	}
	
	public void addGraph(Table table, int type)
	{
		trajectories = new ArrayList<Trajectory>();
		
		for ( Puck puck : table.getPucks())
		{
			trajectories.add( puck.getTrajectory());
		}
		
		graph = new Graph( trajectories, type);
		
	}
	
	public void drawBareGraph(Graphics g)
	{
		g.drawLine(50,550,750,550);
		g.drawLine(50,550,50,120);
		g.drawLine(50,120,55,125);
		g.drawLine(50,120,45,125);
		g.drawLine(745,555,750,550);
		g.drawLine(745,545,750,550);
	}
	
	public void setButtons(JButton bXGr, JButton b_Gr, JButton bHelpGr, JButton bZoomGr, JButton bBackGr, JButton bPrintGr){
		this.bXGr = bXGr;
		this.b_Gr = b_Gr;
		this.bHelpGr = bHelpGr;
		this.bZoomGr = bZoomGr;
		this.bBackGr = bBackGr;
		this.bPrintGr = bPrintGr;
		
		add(bXGr);
		add(b_Gr);
		add(bHelpGr);
		add(bZoomGr);
		add(bBackGr);
		add(bPrintGr);
	}
}
