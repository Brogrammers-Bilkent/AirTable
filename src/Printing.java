import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.*;


class Printing implements Printable{
	
	ArrayList<Puck> pucks;
	
	public Printing (ArrayList<Puck> pucks)
	{
		this.pucks = pucks;
	}
	
	public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        
//        g.drawString("Hello world!", 100, 100);

		for (Puck puck : pucks)
		{
			ArrayList<Dot> dots = puck.getTrajectory().getDots();
			
			g.setColor (puck.getTrajectory().getColor());
			for (Dot dot : dots)
				g.fillOval ((int)dot.getLocation().getX() - 2, (int)dot.getLocation().getY() - 2, 3, 3);

		}
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}


 
//    public static void main(String args[]) {
//  
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//        JFrame f = new JFrame("Hello World Printer");
//        f.addWindowListener(new WindowAdapter() {
//           public void windowClosing(WindowEvent e) {System.exit(0);}
//        });
//        JButton printButton = new JButton("Print Hello World");
//        printButton.addActionListener(new HelloWorldPrinter());
//        f.add("Center", printButton);
//        f.pack();
//        f.setVisible(true);
//    }
//}
