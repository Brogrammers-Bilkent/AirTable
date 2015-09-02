import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Image;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.filechooser.FileNameExtensionFilter;

public class myButtons implements ActionListener, ChangeListener{
	JButton bXS, bXE, bXF, bXV, b_V, b_F, b_E, b_S, bHelpV, bHelpFree, bHelpSelection,
	bHelpExperimentType, bBack, bBackV, bBackF, bSave, bSaveV, bLoad, bLoadV, bVelocity,
	bGravity, bCollision, bFree, bExp, bZoom, bZoomV, bPlay, bPlayV, bStop, bStopV,
	bAddPuck, bTrajectoryF, bTrajectoryV, bXG, b_G, bHelpG, bBackG, bSaveG, bLoadG, bZoomG,
	bPlayG, bStopG, bTrajectoryG, bXC, b_C, bHelpC, bBackC, bSaveC, bLoadC, bZoomC, 
	bPlayC, bStopC, bTrajectoryC, bRuler, bEraser, bXGr, b_Gr, bHelpGr, bBackGr, bZoomGr,
	bPrintGr, bGraphG, bPrintG, bGraphGr, bPrint, bGraph, bPrintV, bGraphV, bPrintC,
	bGraphC;
	
	JTextField tiltF, timer, tiltG, timerG, timerC;
	
	JSlider speed, speedV, speedG, speedC;
	
	Table currentTable;
	
	JFileChooser saver;
	
	FirstPage first;
	Selection slc;
	ExperimentType expT;
	JFrame frm;
	JPanel selectionPanel, experimentTypePanel;
	VelocityPanel velocityPanel;
	GravityPanel gravityPanel;
	FreeMode freeMode;
	CollisionPanel collisionPanel;
	GraphPanel graphPanel;
	
	Help help1, help2, helpF, helpG, helpV, helpC, helpGr;
	boolean isHelpSelectionOn, isHelpExperimentTypeOn, isHelpFreeModeOn, isHelpVOn, isHelpGOn, isHelpCOn;
	boolean isRulerOn;
	
	ArrayList<JPanel> panels;
	ImageIcon img10;
	ImageIcon img17;
	ImageIcon img16;
	ImageIcon img18;
	ImageIcon img19;
	
	Toolkit toolkit;
	Image cursorImage;
	Point cursorHotSpot; 
	Cursor zoomCursor;
	 
	public myButtons(JFrame frm, JPanel selectionPanel, JPanel experimentTypePanel, FreeMode freeMode, VelocityPanel velocityPanel, GravityPanel gravityPanel, CollisionPanel collisionPanel, GraphPanel graphPanel){
		
		this.frm = frm;
		this.selectionPanel = selectionPanel;
		this.experimentTypePanel = experimentTypePanel;
		this.freeMode = (FreeMode) freeMode;
		this.velocityPanel = (VelocityPanel) velocityPanel;
		this.gravityPanel = (GravityPanel) gravityPanel;
		this.collisionPanel = (CollisionPanel) collisionPanel;
		this.graphPanel = (GraphPanel) graphPanel;
		
		toolkit = freeMode.table.getToolkit();	
		cursorImage = toolkit.getImage("zoom1.png");
		cursorHotSpot = new Point( 1, 1);
		zoomCursor = toolkit.createCustomCursor( cursorImage, cursorHotSpot, "ZoomCursor");
		
		saver = new JFileChooser();
		
		help1 = new Help(1);
		help2 = new Help(2);
		helpF = new Help(3);
		helpV = new Help(4);
		helpG = new Help(5);
		helpC = new Help(6);
		helpGr = new Help(7);
		
		
		panels = new ArrayList<JPanel>();
		
		panels.add(selectionPanel);
		
		tiltF = new JTextField("0");
		timer = new JTextField();
		tiltG = new JTextField("0");
		timerG = new JTextField();
		timerC = new JTextField();
		
		speed = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
		speedV = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
		speedG = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
		speedC = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
		
		speed.setValue(2);
		speedV.setValue(2);
		speedG.setValue(2);
		speedC.setValue(2);		
		
		isHelpSelectionOn = false;
		isHelpExperimentTypeOn = false;
		isHelpFreeModeOn = false;
		isHelpVOn = false;
		isHelpGOn = false;
		isHelpCOn = false;
		isRulerOn = false;
		
		ImageIcon img1 = new ImageIcon("Untitled-1.png");
		ImageIcon img2 = new ImageIcon("Untitled-2.png");
		ImageIcon img3 = new ImageIcon("bX.png");
		ImageIcon img4 = new ImageIcon("bQues.png");
		ImageIcon img5 = new ImageIcon("bIcon.png");
		ImageIcon img6 = new ImageIcon("Velocity.png");
		ImageIcon img7 = new ImageIcon("Gravity.png");
		ImageIcon img8 = new ImageIcon("Collision.png");
		ImageIcon img9 = new ImageIcon("Back.png");
		img10 = new ImageIcon("play.png");
		ImageIcon img11 = new ImageIcon("pause.png");
		ImageIcon img12 = new ImageIcon("addPuck.png");
		ImageIcon img13 = new ImageIcon("save.png");
		ImageIcon img14 = new ImageIcon("load.png");
		ImageIcon img15 = new ImageIcon("zoom.png");
		img16 = new ImageIcon("tick.png");
		img17 = new ImageIcon("withoutTick.png");
		img18 = new ImageIcon("ruler.png");
		img19 = new ImageIcon("eraser.png");
		ImageIcon img20 = new ImageIcon("printer.png");
		ImageIcon img21 = new ImageIcon("graph.png");
		
		bFree = new JButton(img1);
		bExp = new JButton(img2);
		bXS = new JButton(img3);
		bXE = new JButton(img3);
		bXF = new JButton(img3);
		bXV = new JButton(img3);
		bXG = new JButton(img3);
		bXC = new JButton(img3);
		bXGr = new JButton(img3);
		bHelpSelection = new JButton(img4);
		bHelpExperimentType = new JButton(img4);
		bHelpFree = new JButton(img4);
		bHelpV = new JButton(img4);
		bHelpG = new JButton(img4);
		bHelpC = new JButton(img4);
		bHelpGr = new JButton(img4);
		b_E = new JButton(img5);
		b_S = new JButton(img5);
		b_F = new JButton(img5);
		b_V = new JButton(img5);
		b_G = new JButton(img5);
		b_C = new JButton(img5);
		b_Gr = new JButton(img5);
		bVelocity = new JButton(img6);
		bGravity = new JButton(img7);
		bCollision = new JButton(img8);
		bBack = new JButton(img9);
		bBackF = new JButton(img9);
		bBackV = new JButton(img9);
		bBackG = new JButton(img9);
		bBackC = new JButton(img9);
		bBackGr = new JButton(img9);
		bZoom = new JButton(img15);
		bZoomV = new JButton(img15);
		bZoomG = new JButton(img15);
		bZoomC = new JButton(img15);
		bZoomGr = new JButton(img15);
		bSave = new JButton(img13);
		bSaveV = new JButton(img13);
		bSaveG = new JButton(img13);
		bSaveC = new JButton(img13);
		bLoad = new JButton(img14);
		bLoadV = new JButton(img14);
		bLoadG = new JButton(img14);
		bLoadC = new JButton(img14);
		bPlay = new JButton(img10);
		bPlayV = new JButton(img10);
		bPlayG = new JButton(img10);
		bPlayC = new JButton(img10);
		bStop = new JButton(img11);
		bStopV = new JButton(img11);
		bStopG = new JButton(img11);
		bStopC = new JButton(img11);
		bAddPuck = new JButton(img12);
		bTrajectoryF = new JButton(img17);
		bTrajectoryV = new JButton(img17);
		bTrajectoryG = new JButton(img17);
		bTrajectoryC = new JButton(img17);
		bRuler = new JButton(img12);
		bEraser = new JButton(img19);
		bPrintGr = new JButton(img20);
		bPrintG = new JButton(img20);
		bGraphG = new JButton(img21);
		bGraphGr = new JButton(img21);
		bPrint = new JButton(img20);
		bGraph = new JButton(img21);
		bPrintV = new JButton(img20);
		bGraphV = new JButton(img21);
		bPrintC = new JButton(img20);
		bGraphC = new JButton(img21);
		
		tiltF.setFont(new Font("Serif", 3, 20));
		timer.setFont(new Font("Serif", 3, 20));
		tiltG.setFont(new Font("Serif", 3, 20));
		timerG.setFont(new Font("Serif", 3, 20));
		timerC.setFont(new Font("Serif", 3, 20));
		
		tiltF.setText( 0 + "");
		timer.setText( 500 + "");
		tiltG.setText( 0 + "");
		timerG.setText( 500 + "");
		timerC.setText( 500 + "");
		
		bFree.setBounds(96, 185, img1.getIconWidth() + 4, img1.getIconHeight() + 4);
		bExp.setBounds(435, 185, img2.getIconWidth() + 4, img2.getIconHeight() + 4);
		bXS.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		bXE.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		bXF.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		bXV.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		bXG.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		bXGr.setBounds(751, 14, img3.getIconWidth(), img3.getIconHeight());
		bXC.setBounds(752, 13, img3.getIconWidth(), img3.getIconHeight());
		b_E.setBounds(680, 13, img5.getIconWidth(), img5.getIconHeight());
		b_S.setBounds(680, 13, img5.getIconWidth(), img5.getIconHeight());
		b_F.setBounds(715, 13, img5.getIconWidth(), img5.getIconHeight());
		b_V.setBounds(715, 13, img5.getIconWidth(), img5.getIconHeight());
		b_G.setBounds(715, 13, img5.getIconWidth(), img5.getIconHeight());
		b_Gr.setBounds(714, 14, img5.getIconWidth(), img5.getIconHeight());
		b_C.setBounds(715, 13, img5.getIconWidth(), img5.getIconHeight());
		bHelpSelection.setBounds(716, 13, img4.getIconWidth(), img4.getIconHeight());
		bHelpFree.setBounds(653, 13, img4.getIconWidth(), img4.getIconHeight());
		bHelpExperimentType.setBounds(716, 13, img4.getIconWidth(), img4.getIconHeight());
		bHelpV.setBounds(653, 13, img4.getIconWidth(), img4.getIconHeight());
		bHelpG.setBounds(653, 13, img4.getIconWidth(), img4.getIconHeight());
		bHelpGr.setBounds(653, 14, img4.getIconWidth(), img4.getIconHeight());
		bHelpC.setBounds(653, 13, img4.getIconWidth(), img4.getIconHeight());
		bVelocity.setBounds(45, 193, img6.getIconWidth() + 4, img6.getIconHeight() + 4);
		bGravity.setBounds(282, 193, img7.getIconWidth() + 4, img7.getIconHeight() + 4);
		bCollision.setBounds(522, 193, img8.getIconWidth() + 4, img8.getIconHeight() + 4);
		bBack.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bBackV.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bBackF.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bBackG.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bBackGr.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bBackC.setBounds(19,20, img9.getIconWidth(), img9.getIconHeight());
		bZoom.setBounds(617,13,img15.getIconWidth(),img15.getIconHeight());
		bZoomV.setBounds(617,13,img15.getIconWidth(),img15.getIconHeight());
		bZoomG.setBounds(617,13,img15.getIconWidth(),img15.getIconHeight());
		bZoomGr.setBounds(617,14,img15.getIconWidth(),img15.getIconHeight());
		bZoomC.setBounds(617,13,img15.getIconWidth(),img15.getIconHeight());
		bSave.setBounds(130,22, img13.getIconWidth(), img13.getIconHeight());
		bSaveV.setBounds(130,22, img13.getIconWidth(), img13.getIconHeight());
		bSaveG.setBounds(130,22, img13.getIconWidth(), img13.getIconHeight());
		bSaveC.setBounds(130,22, img13.getIconWidth(), img13.getIconHeight());
		bLoad.setBounds(80, 22, img14.getIconWidth(), img14.getIconHeight() + 5);
		bLoadV.setBounds(80, 22, img14.getIconWidth(), img14.getIconHeight() + 5);
		bLoadG.setBounds(80, 22, img14.getIconWidth(), img14.getIconHeight() + 5);
		bLoadC.setBounds(80, 22, img14.getIconWidth(), img14.getIconHeight() + 5);
		bPlay.setBounds(90, 538, img10.getIconWidth(), img10.getIconHeight());
		bStop.setBounds(142, 538, img11.getIconWidth(), img11.getIconHeight());
		bPlayV.setBounds(90, 538, img10.getIconWidth(), img10.getIconHeight());
		bStopV.setBounds(142, 538, img11.getIconWidth(), img11.getIconHeight());
		bPlayG.setBounds(90, 538, img10.getIconWidth(), img10.getIconHeight());
		bStopG.setBounds(142, 538, img11.getIconWidth(), img11.getIconHeight());
		bPlayC.setBounds(90, 538, img10.getIconWidth(), img10.getIconHeight());
		bStopC.setBounds(142, 538, img11.getIconWidth(), img11.getIconHeight());
		bAddPuck.setBounds(686,539,49,49);
		bTrajectoryF.setBounds(589, 543, 46, 46);
		bTrajectoryV.setBounds(533, 542, 46, 46);
		bTrajectoryG.setBounds(533, 542, 46, 46);
		bTrajectoryC.setBounds(533, 542, 46, 46);
		bRuler.setBounds(242, 539, 58, 53);
		bEraser.setBounds(331, 539, img19.getIconWidth(), img19.getIconHeight());
		bPrintG.setBounds(40, 538, img20.getIconWidth(), img20.getIconHeight());
		bGraphG.setBounds(192, 538, img21.getIconWidth(), img21.getIconHeight());
		bPrintC.setBounds(40, 538, img20.getIconWidth(), img20.getIconHeight());
		bGraphV.setBounds(192, 538, img21.getIconWidth(), img21.getIconHeight());
		bPrint.setBounds(40, 538, img20.getIconWidth(), img20.getIconHeight());
		bGraph.setBounds(192, 538, img21.getIconWidth(), img21.getIconHeight());
		bPrintV.setBounds(40, 538, img20.getIconWidth(), img20.getIconHeight());
		bGraphC.setBounds(192, 538, img21.getIconWidth(), img21.getIconHeight());
		
		
		tiltF.setBounds(409, 548, 30, 30);
		timer.setBounds(678, 550, 49, 29);
		tiltG.setBounds(354, 548, 30, 30);
		timerG.setBounds(678, 550, 49, 29);
		timerC.setBounds(678, 550, 49, 29);
		speed.setBounds(67, 585, 145, 6);
		speedG.setBounds(67, 585, 145, 6);
		speedV.setBounds(67, 585, 145, 6);
		speedC.setBounds(67, 585, 145, 6);
		
		speed.setMajorTickSpacing(100);
		speed.setMinorTickSpacing(25);
		speed.addChangeListener(this);
		speedV.setMajorTickSpacing(100);
		speedV.setMinorTickSpacing(25);
		speedV.addChangeListener(this);
		speedG.setMajorTickSpacing(100);
		speedG.setMinorTickSpacing(25);
		speedG.addChangeListener(this);
		speedC.setMajorTickSpacing(100);
		speedC.setMinorTickSpacing(25);
		speedC.addChangeListener(this);
		
		bFree.addActionListener(this);
		bXS.addActionListener(this);
		bXE.addActionListener(this);
		bXF.addActionListener(this);
		bXV.addActionListener(this);
		bXG.addActionListener(this);
		bXC.addActionListener(this);
		bXGr.addActionListener(this);
		b_E.addActionListener(this);
		b_S.addActionListener(this);
		b_F.addActionListener(this);
		b_V.addActionListener(this);
		b_G.addActionListener(this);
		b_C.addActionListener(this);
		b_Gr.addActionListener(this);
		bHelpSelection.addActionListener(this);
		bHelpExperimentType.addActionListener(this);
		bHelpFree.addActionListener(this);
		bHelpV.addActionListener(this);
		bHelpG.addActionListener(this);
		bHelpGr.addActionListener(this);
		bHelpC.addActionListener(this);
		bExp.addActionListener(this);
		bVelocity.addActionListener(this);
		bGravity.addActionListener(this);
		bCollision.addActionListener(this);
		bBack.addActionListener(this);
		bBackF.addActionListener(this);
		bBackV.addActionListener(this);
		bBackG.addActionListener(this);
		bBackGr.addActionListener(this);
		bBackC.addActionListener(this);
		bZoom.addActionListener(this);
		bZoomV.addActionListener(this);
		bZoomG.addActionListener(this);
		bZoomGr.addActionListener(this);
		bZoomC.addActionListener(this);
		bSave.addActionListener(this);
		bSaveV.addActionListener(this);
		bSaveG.addActionListener(this);
		bSaveC.addActionListener(this);
		bLoad.addActionListener(this);
		bLoadV.addActionListener(this);
		bLoadG.addActionListener(this);
		bLoadC.addActionListener(this);
		bPlay.addActionListener(this);
		bPlayV.addActionListener(this);
		bPlayG.addActionListener(this);
		bPlayC.addActionListener(this);
		bStop.addActionListener(this);
		bStopV.addActionListener(this);
		bStopG.addActionListener(this);
		bStopC.addActionListener(this);
		bAddPuck.addActionListener(this);
		bTrajectoryF.addActionListener(this);
		bTrajectoryV.addActionListener(this);
		bTrajectoryG.addActionListener(this);
		bTrajectoryC.addActionListener(this);
		tiltF.addActionListener(this);
		timer.addActionListener(this);
		tiltG.addActionListener(this);
		timerG.addActionListener(this);
		timerC.addActionListener(this);
		bRuler.addActionListener(this);
		bEraser.addActionListener(this);
		bPrintG.addActionListener(this);
		bGraphG.addActionListener(this);
		bPrint.addActionListener(this);
		bGraph.addActionListener(this);
		bPrintV.addActionListener(this);
		bGraphV.addActionListener(this);
		bPrintC.addActionListener(this);
		bGraphC.addActionListener(this);
		
		bStop.setFocusable(false);
		bStopV.setFocusable(false);
		bStopG.setFocusable(false);
		bStopC.setFocusable(false);
		bPlay.setFocusable(false);
		bPlayG.setFocusable(false);
		bPlayC.setFocusable(false);
		bPlayV.setFocusable(false);
		bAddPuck.setFocusable(false);
		bBack.setFocusable(false);
		bBackF.setFocusable(false);
		bBackG.setFocusable(false);
		bBackC.setFocusable(false);
		bLoad.setFocusable(false);
		bLoadG.setFocusable(false);
		bLoadC.setFocusable(false);
		bSave.setFocusable(false);
		bSaveG.setFocusable(false);
		bSaveC.setFocusable(false);
		bHelpSelection.setFocusable(false);
		bHelpExperimentType.setFocusable(false);
		bHelpSelection.setFocusable(false);
		bHelpFree.setFocusable(false);
		bHelpG.setFocusable(false);
		bHelpV.setFocusable(false);
		bHelpC.setFocusable(false);
		bZoom.setFocusable(false);
		bZoomV.setFocusable(false);
		bZoomG.setFocusable(false);
		bZoomC.setFocusable(false);
		speed.setFocusable(false);
		speedV.setFocusable(false);
		speedG.setFocusable(false);
		speedC.setFocusable(false);
		bTrajectoryF.setFocusable(false);
		bTrajectoryV.setFocusable(false);
		bTrajectoryG.setFocusable(false);
		bTrajectoryC.setFocusable(false);
		bEraser.setFocusable(false);
		bRuler.setFocusable(false);
		bGraphG.setFocusable(false);
		bPrintG.setFocusable(false);
		bGraphG.setVisible(true);
		bPrintC.setVisible(true);
		bGraphC.setFocusable(false);
		bPrintC.setFocusable(false);
		bGraphC.setVisible(true);
		bPrintC.setVisible(true);
		bGraphV.setFocusable(false);
		bPrintV.setFocusable(false);
		bGraphV.setVisible(true);
		bPrintV.setVisible(true);
		bGraph.setFocusable(false);
		bPrint.setFocusable(false);
		bGraph.setVisible(true);
		bPrint.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bXS || e.getSource() == bXE || e.getSource() == bXF || e.getSource() == bXV || e.getSource() == bXG || e.getSource() == bXC || e.getSource() == bXGr){
			System.exit(0);
		}
		else if (e.getSource() == b_E || e.getSource() == b_S || e.getSource() == b_F || e.getSource() == b_V || e.getSource() == b_G || e.getSource() == b_C || e.getSource() == b_Gr){
			frm.setState(Frame.ICONIFIED);
		}
		else if (e.getSource() == bHelpSelection){
			if (!isHelpSelectionOn){
				selectionPanel.add(help1);
				isHelpSelectionOn = true;
			}
			else{
				selectionPanel.remove(help1);
				isHelpSelectionOn = false;
			}
			frm.repaint();
		}
		else if (e.getSource() == bHelpExperimentType){
			if (!isHelpExperimentTypeOn){
				experimentTypePanel.add(help2);
				isHelpExperimentTypeOn = true;
			}
			else{
				experimentTypePanel.remove(help2);
				isHelpExperimentTypeOn = false;
			}
			frm.repaint();
		}
		else if (e.getSource() == bHelpFree){
			if (!isHelpFreeModeOn){
				freeMode.table.add(helpF);
				isHelpFreeModeOn = true;
			}
			else{
				freeMode.table.remove(helpF);
				isHelpFreeModeOn = false;
			}
			frm.repaint();
		}
		else if (e.getSource() == bHelpV){
			if (!isHelpVOn){
				velocityPanel.table.add(helpV);
				isHelpVOn = true;
			}
			else{
				velocityPanel.table.remove(helpV);
				isHelpVOn = false;
			}
			frm.repaint();
		}
		else if (e.getSource() == bHelpG){
			if (!isHelpGOn){
				gravityPanel.table.add(helpG);
				isHelpGOn = true;
			}
			else{
				gravityPanel.table.remove(helpG);
				isHelpGOn = false;
			}
			frm.repaint();
		}
		else if (e.getSource() == bHelpC){
			if (!isHelpCOn){
				collisionPanel.table.add(helpC);
				isHelpCOn = true;
			}
			else{
				collisionPanel.table.remove(helpC);
				isHelpCOn = false;
			}
			frm.repaint();
		}
		
		else if (e.getSource() == bZoom)
		{
			
			if (!freeMode.table.getZoomSelected())
			{
				freeMode.table.setZoomSelected(true);
				freeMode.table.setCursor(zoomCursor);
			}
			
			else
			{
				freeMode.table.setZoomSelected(false);
				freeMode.table.setCursor(Cursor.getDefaultCursor());	
			}
	
		}
		
		else if (e.getSource() == bZoomV)
		{
			if (!velocityPanel.table.getZoomSelected())
			{
				velocityPanel.table.setZoomSelected(true);
				velocityPanel.table.setCursor(zoomCursor);
			}
			
			else
			{
				velocityPanel.table.setZoomSelected(false);
				velocityPanel.table.setCursor(Cursor.getDefaultCursor()); 
			}
		}
		
		else if (e.getSource() == bZoomG)
		{
			if (!gravityPanel.table.getZoomSelected())
			{
				gravityPanel.table.setZoomSelected(true);
				gravityPanel.table.setCursor(zoomCursor);
			}
			
			else
			{
				gravityPanel.table.setZoomSelected(false);
				gravityPanel.table.setCursor(Cursor.getDefaultCursor()); 
			}
		}
		
		else if (e.getSource() == bZoomC)
		{
			if (!collisionPanel.table.getZoomSelected())
			{
				collisionPanel.table.setZoomSelected(true);
				collisionPanel.table.setCursor(zoomCursor);
			}
			
			else
			{
				collisionPanel.table.setZoomSelected(false);
				collisionPanel.table.setCursor(Cursor.getDefaultCursor()); 
			}
		}
		
		else if (e.getSource() == bExp){
			panels.add(experimentTypePanel);
			frm.remove(selectionPanel);
			frm.add(panels.get(1));
			frm.revalidate();
			frm.repaint();
		}
		else if (e.getSource() == bVelocity){
			panels.add(velocityPanel);
			frm.remove(experimentTypePanel);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
			currentTable = velocityPanel.table;
		}
		else if (e.getSource() == bGravity){
			panels.add(gravityPanel);
			frm.remove(experimentTypePanel);
			frm.add(gravityPanel);
			frm.revalidate();
			frm.repaint();
			currentTable = gravityPanel.table;
		}
		else if (e.getSource() == bCollision){
			panels.add(collisionPanel);
			frm.remove(experimentTypePanel);
			frm.add(collisionPanel);
			frm.revalidate();
			frm.repaint();
			currentTable = collisionPanel.table;
		}
		else if (e.getSource() == bBack || e.getSource() == bBackF || e.getSource() == bBackV || e.getSource() == bBackG || e.getSource() == bBackC || e.getSource() == bBackGr){
			frm.remove(panels.get(panels.size() - 1));
			panels.remove(panels.get(panels.size() - 1));
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
			
			speed.setValue(2);
			speedV.setValue(2);
			speedG.setValue(2);
			speedC.setValue(2);
			
			collisionPanel.table.setTrajectoriesVisibility(false);
			gravityPanel.table.setTrajectoriesVisibility(false);
			velocityPanel.table.setTrajectoriesVisibility(false);
			freeMode.table.setTrajectoriesVisibility(false);
			
			tiltF.setText(0 + "");
			tiltF.postActionEvent();
			timer.setText(500 + "");
			timer.postActionEvent();
			tiltG.setText(0 + "");
			tiltG.postActionEvent();
			timerG.setText(500 + "");
			timerG.postActionEvent();
			timerC.setText(500 + "");
			timerC.postActionEvent();
			
			
			
			bPlay.setIcon(new ImageIcon("play.png"));	
			
			bPlayV.setIcon(new ImageIcon("play.png"));
			
			bPlayG.setIcon(new ImageIcon("play.png"));
			
			bPlayC.setIcon(new ImageIcon("play.png"));
			
			try {
				freeMode.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				velocityPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				gravityPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				collisionPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			freeMode.table.setZoomSelected(false);
			velocityPanel.table.setZoomSelected(false);
			gravityPanel.table.setZoomSelected(false);
			collisionPanel.table.setZoomSelected(false);
		}
		else if (e.getSource() == bFree){
			
			panels.add(freeMode);
			frm.remove(selectionPanel);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
			currentTable = freeMode.table;
		}
		else if (e.getSource() == bPlay){
			if (!freeMode.table.getTimer().isRunning()){
				freeMode.table.start();
				bPlay.setIcon(new ImageIcon("pause2.png"));
				freeMode.table.setRelocatable(false);
				bGraph.setVisible(false);
				bPrint.setVisible(false);
				
			}
			else{
				freeMode.table.stop();
				bPlay.setIcon(new ImageIcon("play.png"));
				freeMode.table.setRelocatable(true);
				bGraph.setVisible(true);
				bPrint.setVisible(true);
				
			}
				
		}
		else if (e.getSource() == bPlayV){
			if (!velocityPanel.table.getTimer().isRunning()){
				//lka
				velocityPanel.table.start();
				bPlayV.setIcon(new ImageIcon("pause2.png"));
				velocityPanel.table.setRelocatable(false);
				bGraphV.setVisible(false);
				bPrintV.setVisible(false);
				
			}
			else{
				velocityPanel.table.stop();
				bPlayV.setIcon(new ImageIcon("play.png"));
				velocityPanel.table.setRelocatable(true);
				bGraphV.setVisible(true);
				bPrintV.setVisible(true);
				
			}
		}
		else if (e.getSource() == bPlayG){
			if (!gravityPanel.table.getTimer().isRunning()){
				gravityPanel.table.start();
				bPlayG.setIcon(new ImageIcon("pause2.png"));
				gravityPanel.table.setRelocatable(false);
				bGraphG.setVisible(false);
				bPrintG.setVisible(false);
				
			}
			else{
				gravityPanel.table.stop();
				bPlayG.setIcon(new ImageIcon("play.png"));
				gravityPanel.table.setRelocatable(true);
				bGraphG.setVisible(true);
				bPrintG.setVisible(true);
				

			}
		}
		else if (e.getSource() == bPlayC){
			if (!collisionPanel.table.getTimer().isRunning()){
				collisionPanel.table.start();
				bPlayC.setIcon(new ImageIcon("pause2.png"));
				collisionPanel.table.setRelocatable(false);
				bGraphC.setVisible(false);
				bPrintC.setVisible(false);
				isRulerOn = false;
				
			}
			else{
				collisionPanel.table.stop();
				bPlayC.setIcon(new ImageIcon("play.png"));
				collisionPanel.table.setRelocatable(true);
				bGraphC.setVisible(true);
				bPrintC.setVisible(true);
				
			}
		}
		else if(e.getSource() == bStop){
			try {
				freeMode.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bPlay.setIcon(new ImageIcon("play.png"));
			freeMode.table.setRelocatable(true);
		}
		else if (e.getSource() == bStopV){
			try {
				velocityPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bPlayV.setIcon(new ImageIcon("play.png"));
			velocityPanel.table.setRelocatable(true);
		}
		//lka
		else if (e.getSource() == bStopG){
			try {
				gravityPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bPlayG.setIcon(new ImageIcon("play.png"));
			gravityPanel.table.setRelocatable(true);
			bPrintGr.setVisible(true);
			bGraphG.setVisible(true);
		}
		else if (e.getSource() == bStopC){
			panels.add(graphPanel);
			frm.remove(collisionPanel);
			frm.add(graphPanel);
			collisionPanel.table.setRelocatable(true);
			frm.revalidate();
			frm.repaint();
		}
	
		else if(e.getSource() == bAddPuck){
			freeMode.table.setRelocatable(true);
			freeMode.table.setCanAdd(true);
			
		}
		
		else if (e.getSource() == bSave){
			freeMode.table.stop();
			String directory = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory);
			saver.showSaveDialog(freeMode.table);
			File target = saver.getSelectedFile();
			
			if(target != null){
				try {
		            FileWriter fw = new FileWriter(target);
		            
		            if(freeMode.table.getPucks() != null)
			           	for(int i = 0; i<freeMode.table.getPucks().size(); i++){
							fw.write(freeMode.table.getPucks().get(i).write());
							fw.write(String.format("%n"));	
						}
					
					fw.close();
					
					target.renameTo( new File( target.getParentFile(), target.getName() + ".atf"));
		        } catch (IOException iox) {
		            iox.printStackTrace();
	        					
				}
			}
		}
		
		else if (e.getSource() == bLoad){
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ATF & ATV & ATG & ATC  Files", "atf", "atv", "atg", "atc");
			freeMode.table.stop();
			String directory1 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory1);
			saver.setFileFilter(filter);
			saver.showOpenDialog(freeMode.table);
			File target1 = saver.getSelectedFile();
			
			if (target1 != null){
			
				freeMode.table.restartLoad();
				speed.setValue(2);
			
				try{
					BufferedReader reader = new BufferedReader(new FileReader(target1));
					String input = "";
					input = reader.readLine();
					while(input != null)
					{
						
						freeMode.table.addPuck(new Puck(input, freeMode.table));
						input = reader.readLine();
					}
				}
				catch(Exception g){}
			}
			
			System.out.println("Loaded");
			
			freeMode.table.repaint();
			
		}
	//lka
		else if (e.getSource() == bSaveV){
			velocityPanel.table.stop();
			String directory2 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory2);
			saver.showSaveDialog(velocityPanel.table);
			File target2 = saver.getSelectedFile();
			
			if(target2 != null){
		        try {
		            FileWriter fw = new FileWriter(target2);
		            
		            if(velocityPanel.table.getPucks() != null)
			           	for(int i = 0; i<velocityPanel.table.getPucks().size(); i++){
							fw.write(velocityPanel.table.getPucks().get(i).write());
							fw.write(String.format("%n"));	
						}
					
					fw.close();
					
					target2.renameTo( new File( target2.getParentFile(), target2.getName() + ".atv"));
		        } catch (IOException iox) {
		            iox.printStackTrace();
	        					
		        	}
			
				}
			}
		else if (e.getSource() == bLoadV){
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ATV & ATG  Files","atv", "atg");
			velocityPanel.table.stop();
			String directory1 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory1);
			saver.setFileFilter(filter);
			saver.showOpenDialog(velocityPanel.table);
			File target1 = saver.getSelectedFile();
			
			if (target1 != null){
				
				velocityPanel.table.restartLoad();
				speed.setValue(2);
				
				try{
					BufferedReader reader = new BufferedReader(new FileReader(target1));
					String input = "";
					input = reader.readLine();
					while(input != null)
					{
						
						velocityPanel.table.addPuck(new Puck(input, freeMode.table));
						input = reader.readLine();
					}
				}
				catch(Exception g){}
			}
			
			System.out.println("Loaded");
			
			velocityPanel.table.repaint();
			
		}
		else if (e.getSource() == bSaveG){
			gravityPanel.table.stop();
			String directory2 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory2);
			saver.showSaveDialog(gravityPanel.table);
			File target2 = saver.getSelectedFile();
			//target2.renameTo( new File( target2.getParentFile(), target2.getName() + "atg"));
			if(target2 != null){
		        try {
		            FileWriter fw = new FileWriter(target2);
		            
		            if(gravityPanel.table.getPucks() != null)
			           	for(int i = 0; i<gravityPanel.table.getPucks().size(); i++){
							fw.write(gravityPanel.table.getPucks().get(i).write());
							fw.write(String.format("%n"));	
						}
					
					fw.close();
					
					target2.renameTo( new File( target2.getParentFile(), target2.getName() + ".atg"));
		        } catch (IOException iox) {
		            iox.printStackTrace();
	        					
		        	}
			
				}

			}
		else if (e.getSource() == bLoadG){
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ATV & ATG Files","atv", "atg");
			gravityPanel.table.stop();
			String directory1 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory1);
			saver.setFileFilter(filter);
			saver.showOpenDialog(gravityPanel.table);
			File target1 = saver.getSelectedFile();
							
			if (target1 != null){
				
			gravityPanel.table.restartLoad();
			speed.setValue(2);
				
				try{
					BufferedReader reader = new BufferedReader(new FileReader(target1));
					String input = "";
					input = reader.readLine();
					while(input != null)
					{
						
						gravityPanel.table.addPuck(new Puck(input, gravityPanel.table));
						input = reader.readLine();
					}
				}
				catch(Exception g){}
			}
			
			System.out.println("Loaded");
			
			gravityPanel.table.repaint();
			
		}
		else if (e.getSource() == bSaveC){
			//FileNameExtensionFilter filter = new FileNameExtensionFilter("ATC Files","atc");
			collisionPanel.table.stop();
			String directory2 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory2);
			//saver.setFileFilter(filter);
			saver.showSaveDialog(collisionPanel.table);
			File target2 = saver.getSelectedFile();
			
			if(target2 != null){
		        try {
		            FileWriter fw = new FileWriter(target2);
		            
		            if(collisionPanel.table.getPucks() != null)
			           	for(int i = 0; i<collisionPanel.table.getPucks().size(); i++){
							fw.write(collisionPanel.table.getPucks().get(i).write());
							fw.write(String.format("%n"));	
						}
					
					fw.close();
					target2.renameTo( new File( target2.getParentFile(), target2.getName() + ".atc"));
		        } catch (IOException iox) {
		            iox.printStackTrace();
	        					
		        	}
			
				}
			}
		else if (e.getSource() == bLoadC){
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ATC Files","atc");
			collisionPanel.table.stop();
			String directory1 = "C:\\Users\\User\\workspace\\AirTableSim";
			saver = new JFileChooser(directory1);
			saver.setFileFilter(filter);
			saver.showOpenDialog(collisionPanel.table);
			File target1 = saver.getSelectedFile();
			
			if (target1 != null){
				
				collisionPanel.table.restartLoad();
				speed.setValue(2);
				
				try{
					BufferedReader reader = new BufferedReader(new FileReader(target1));
					String input = "";
					input = reader.readLine();
					while(input != null)
					{
						
						collisionPanel.table.addPuck(new Puck(input, collisionPanel.table));
						input = reader.readLine();
					}
				}
				catch(Exception g){}
			}
			
			System.out.println("Loaded");
			
			collisionPanel.table.repaint();
			
		}
		else if (e.getSource() == bTrajectoryF  && currentTable.equals(freeMode.table)){
			if (freeMode.table.getTrajectoriesVisibility())
			{
				bTrajectoryF.setIcon(img17);
			}
			
			else 
			{
				bTrajectoryF.setIcon(img16);
			}	
				
			freeMode.table.setTrajectoriesVisibility(!freeMode.table.getTrajectoriesVisibility());
			freeMode.table.repaint();
		}
		
		else if (e.getSource() == bTrajectoryV && currentTable.equals(velocityPanel.table)){
			
			if (velocityPanel.table.getTrajectoriesVisibility())
			{
				bTrajectoryV.setIcon(img17);
			}
			
			else 
			{
				bTrajectoryV.setIcon(img16);
			}	
			
			velocityPanel.table.setTrajectoriesVisibility(!velocityPanel.table.getTrajectoriesVisibility());
			velocityPanel.table.repaint();
		}
		
		else if (e.getSource() == bTrajectoryG && currentTable.equals(gravityPanel.table)){
			
			if (gravityPanel.table.getTrajectoriesVisibility())
			{
				bTrajectoryG.setIcon(img17);
			}
			
			else 
			{
				bTrajectoryG.setIcon(img16);
			}	
			
			gravityPanel.table.setTrajectoriesVisibility(!gravityPanel.table.getTrajectoriesVisibility());
			gravityPanel.table.repaint();
		}
		
		else if (e.getSource() == bTrajectoryC && currentTable.equals(collisionPanel.table)){
		
			if (collisionPanel.table.getTrajectoriesVisibility())
			{
				bTrajectoryC.setIcon(img17);
			}
			
			else 
			{
				bTrajectoryC.setIcon(img16);
			}	
		
			collisionPanel.table.setTrajectoriesVisibility(!collisionPanel.table.getTrajectoriesVisibility());
			collisionPanel.table.repaint();
		}
	
		else if (e.getSource() == tiltF){
			freeMode.table.setTiltAngle(Integer.parseInt(tiltF.getText()));
			freeMode.table.requestFocusInWindow();
		}
		else if (e.getSource() == timer){
			velocityPanel.table.setSparkleTimer(Integer.parseInt(timer.getText()));
			velocityPanel.table.requestFocusInWindow();
		}
		else if (e.getSource() == tiltG){
			gravityPanel.table.setTiltAngle(Integer.parseInt(tiltG.getText()));
			gravityPanel.table.requestFocusInWindow();
		}
		else if (e.getSource() == timerG){
			gravityPanel.table.setSparkleTimer(Integer.parseInt(timerG.getText()));
			gravityPanel.table.requestFocusInWindow();
		}
		else if (e.getSource() == timerC){
			collisionPanel.table.setSparkleTimer(Integer.parseInt(timerC.getText()));
			collisionPanel.table.requestFocusInWindow();
		}
		else if (e.getSource() == bEraser){
			try {
				collisionPanel.table.restart();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bPlayC.setIcon(img10);
		}
		else if (e.getSource() == bRuler){
			if (!isRulerOn){
				collisionPanel.table.setCanAdd(true);
			}
			else{
				//lol
				collisionPanel.table.setIsRulerActive(true);
				collisionPanel.table.setCanAdd(false);
				
			}
				
		}
		else if (e.getSource() == bPrintG){
			gravityPanel.table.print();
		}
		else if (e.getSource() == bGraphG){
			graphPanel.addGraph( gravityPanel.table, 1);
			panels.add(graphPanel);
			frm.remove(gravityPanel);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
		}
		else if (e.getSource() == bPrint){
			freeMode.table.print();
		}
		else if (e.getSource() == bGraph){
			graphPanel.addGraph( freeMode.table, 1);
			panels.add(graphPanel);
			frm.remove(freeMode);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
		}
		else if (e.getSource() == bPrintC){
			collisionPanel.table.print();
		}
		else if (e.getSource() == bGraphC){
			graphPanel.addGraph( collisionPanel.table, 1);
			panels.add(graphPanel);
			frm.remove(collisionPanel);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
		}
		else if (e.getSource() == bPrintV){
			velocityPanel.table.print();
		}
		else if (e.getSource() == bGraphV){
			graphPanel.addGraph( velocityPanel.table, 1);
			panels.add(graphPanel);
			frm.remove(velocityPanel);
			frm.add(panels.get(panels.size() - 1));
			frm.revalidate();
			frm.repaint();
		}		
	}
		// RatMan!!!
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == speed){
			if (speed.getValue() == 0)
				freeMode.table.setSimulationSpeed(0.25);
			else if (speed.getValue() == 1)
				freeMode.table.setSimulationSpeed(0.5);
			else if (speed.getValue() == 2)
				freeMode.table.setSimulationSpeed(1);
			else if (speed.getValue() == 3)
				freeMode.table.setSimulationSpeed(2);
			else if (speed.getValue() == 4)
				freeMode.table.setSimulationSpeed(4);
			System.out.println(speed.getValue());
		}
		else if (e.getSource() == speedV){
			if (speedV.getValue() == 0)
				velocityPanel.table.setSimulationSpeed(0.25);
			else if (speedV.getValue() == 1)
				velocityPanel.table.setSimulationSpeed(0.5);
			else if (speedV.getValue() == 2)
				velocityPanel.table.setSimulationSpeed(1);
			else if (speedV.getValue() == 3)
				velocityPanel.table.setSimulationSpeed(2);
			else if (speedV.getValue() == 4)
				velocityPanel.table.setSimulationSpeed(4);
			System.out.println(speedV.getValue());
		}
		else if (e.getSource() == speedG){
			if (speedG.getValue() == 0)
				gravityPanel.table.setSimulationSpeed(0.25);
			else if (speedG.getValue() == 1)
				gravityPanel.table.setSimulationSpeed(0.5);
			else if (speedG.getValue() == 2)
				gravityPanel.table.setSimulationSpeed(1);
			else if (speedG.getValue() == 3)
				gravityPanel.table.setSimulationSpeed(2);
			else if (speedG.getValue() == 4)
				gravityPanel.table.setSimulationSpeed(4);
			System.out.println(speedG.getValue());
		}
		else if (e.getSource() == speedC){
			if (speedC.getValue() == 0)
				collisionPanel.table.setSimulationSpeed(0.25);
			else if (speedC.getValue() == 1)
				collisionPanel.table.setSimulationSpeed(0.5);
			else if (speedC.getValue() == 2)
				collisionPanel.table.setSimulationSpeed(1);
			else if (speedC.getValue() == 3)
				collisionPanel.table.setSimulationSpeed(2);
			else if (speedC.getValue() == 4)
				collisionPanel.table.setSimulationSpeed(4);
			System.out.println(speedC.getValue());
		}
	}
	
}
