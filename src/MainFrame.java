import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	Selection slcPanel;
	ExperimentType expPanel;
	FreeMode freeMode;
	VelocityPanel velocityPanel;
	GravityPanel gravityPanel;
	CollisionPanel collisionPanel;
	GraphPanel graphPanel;
	Help helpS;
	Table table;
	Table tableV, tableG, tableC;
	public MainFrame(){
		
		table = new Table(false, true);
		tableV = new Table(true, false, 1);
		tableG = new Table(true, true, 2);
		tableC = new Table(true, false, 3);
		slcPanel = new Selection();
		expPanel = new ExperimentType();
		freeMode = new FreeMode(table);
		velocityPanel = new VelocityPanel(tableV);
		gravityPanel = new GravityPanel(tableG);
		collisionPanel = new CollisionPanel(tableC);
		graphPanel = new GraphPanel();
		
		myButtons buttons = new myButtons(this, slcPanel, expPanel, freeMode, velocityPanel, gravityPanel, collisionPanel, graphPanel);
		
		slcPanel.setButtons(buttons.bXS, buttons.b_S, buttons.bFree, buttons.bExp, buttons.bHelpSelection);
		expPanel.setButtons(buttons.bXE, buttons.b_E, buttons.bHelpExperimentType, buttons.bBack, buttons.bVelocity, buttons.bGravity, buttons.bCollision);
		freeMode.setButtons(buttons.tiltF, buttons.speed, buttons.bXF, buttons.b_F, buttons.bHelpFree, buttons.bZoom, buttons.bSave, buttons.bLoad, buttons.bBackF, buttons.bPlay, buttons.bStop, 

buttons.bAddPuck, buttons.bTrajectoryF, buttons.bPrint, buttons.bGraph);
		velocityPanel.setButtons(buttons.timer, buttons.speedV, buttons.bXV, buttons.b_V, buttons.bHelpV, buttons.bZoomV, buttons.bSaveV, buttons.bLoadV, buttons.bBackV, buttons.bPlayV, 

buttons.bStopV, buttons.bTrajectoryV, buttons.bPrintV, buttons.bGraphV);
		gravityPanel.setButtons(buttons.timerG, buttons.tiltG, buttons.speedG, buttons.bXG, buttons.b_G, buttons.bHelpG, buttons.bZoomG, buttons.bSaveG, buttons.bLoadG, buttons.bBackG, 

buttons.bPlayG, buttons.bStopG, buttons.bTrajectoryG, buttons.bPrintG, buttons.bGraphG);
		collisionPanel.setButtons(buttons.timerC, buttons.speedC, buttons.bXC, buttons.b_C, buttons.bHelpC, buttons.bZoomC, buttons.bSaveC, buttons.bLoadC, buttons.bBackC, buttons.bPlayC, 

buttons.bStopC, buttons.bTrajectoryC, buttons.bRuler, buttons.bEraser, buttons.bPrintC, buttons.bGraphC);
		graphPanel.setButtons(buttons.bXGr, buttons.b_Gr, buttons.bHelpGr, buttons.bZoomGr, buttons.bBackGr, buttons.bPrintGr);
		
		
		setSize(new Dimension(700, 700));
		add(slcPanel);
		setDefaultCloseOperation(3);
		
		setFocusable(false);
	}
	
	public static void main(String [] Args){
		MainFrame frm = new MainFrame();
		
		frm.setUndecorated(true);
		frm.pack();
		
		frm.setVisible(true);
	}
}