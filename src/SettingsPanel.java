import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SettingsPanel extends JPanel implements ActionListener, ChangeListener{

	JTextField mass, speed;
	
	JSlider elasticity, direction, speedV;
	
	JButton magnetic, ok, cancel, delete;
	
	Puck puck;
	
	Table table;
	
	boolean isMagnetic;
	
	BufferedImage img;
	ImageIcon  img1, img2, img3;
	int type;
	
	int massValue = 0, speedValue = 0, elasticityValue = 0, directionValue = 0, speedValueNext = 0;
	public SettingsPanel(Table table, Puck puck, int type){
		this.puck = puck;
		this.table = table;
		this.type = type;
		try {
			img = ImageIO.read(new File("collselection.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img1 = new ImageIcon("magneticButton.png");
		img2 = new ImageIcon("magneticsiz.png");
		
		if (type == 3 || type == 0){
			try {
				img = ImageIO.read(new File("collselection.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			img1 = new ImageIcon("magneticButton.png");
			img2 = new ImageIcon("magneticsiz.png");
			mass = new JTextField();
			speed = new JTextField();
			elasticity = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
			direction = new JSlider(JSlider.HORIZONTAL, 0, 359, 1);
	
			magnetic = new JButton(img1);
			ok = new JButton();
			cancel = new JButton();
			delete = new JButton();
			
			mass.addActionListener(this);
			speed.addActionListener(this);
			elasticity.addChangeListener(this);
			direction.addChangeListener(this);
			magnetic.addActionListener(this);
			ok.addActionListener(this);
			cancel.addActionListener(this);
			delete.addActionListener(this);
			
			mass.setBounds(111, 22, 50, 25);
			speed.setBounds(111, 50, 50, 25);
			elasticity.setValue(2);
			elasticity.setBounds(105, 90, 110, 5);
			elasticity.setMajorTickSpacing(100);
			elasticity.setMinorTickSpacing(25);
			direction.setValue(2);
			direction.setBounds(105, 115, 110, 5);
			direction.setMajorTickSpacing(100);
			direction.setMinorTickSpacing(25);
			magnetic.setBounds(120, 140, 20, 20);
			ok.setBounds(25, 140, 100, 40);
			cancel.setBounds(150, 280, 100, 40);
			delete.setBounds(275, 280, 50, 40);
			
			add(mass);
			add(speed);
			add(elasticity);
			add(direction);
			add(magnetic);
			add(ok);
			add(cancel);
			add(delete);
		}
		else if( type == 2){
			try {
				img = ImageIO.read(new File("gravityselection.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			mass = new JTextField();
			speed = new JTextField();
			
			direction = new JSlider(JSlider.HORIZONTAL, 0, 4, 1);
	
			
			ok = new JButton();
			cancel = new JButton();
			
			
			mass.addActionListener(this);
			
			speed.addActionListener(this);
			direction.addChangeListener(this);
			
			ok.addActionListener(this);
			cancel.addActionListener(this);
			
			
			mass.setBounds(111, 22, 50, 25);
			speed.setBounds(111, 50, 100, 25);
			
			direction.setValue(2);
			direction.setBounds(105, 115, 110, 5);
			direction.setMajorTickSpacing(100);
			direction.setMinorTickSpacing(25);
			
			ok.setBounds(25, 140, 100, 40);
			cancel.setBounds(150, 280, 100, 40);
			
			
			add(mass);
			add(speed);
			
			add(direction);
			add(ok);
			add(cancel);

		}
		else if( type == 1){
			try {
				img = ImageIO.read(new File("velocityselection.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			mass = new JTextField();
			speedV = new JSlider(JSlider.HORIZONTAL, 0, 70, 10);
			
			direction = new JSlider(JSlider.HORIZONTAL, 0, 360, 1);
	
			img1 = new ImageIcon("okbutton.png");
			img2 = new ImageIcon("cancelbutton.png");
			ok = new JButton(img1);
			cancel = new JButton(img2);
		
			
			mass.addActionListener(this);
			
			
			direction.addChangeListener(this);
			speedV.addChangeListener(this);
			
			ok.addActionListener(this);
			cancel.addActionListener(this);
			
			
			mass.setBounds(114, 47, 50, 25);
			speedV.setBounds(108, 86, 112, 5);
			speedV.setValue(3);
			speedV.setMajorTickSpacing(80);
			speedV.setMinorTickSpacing(10);
			direction.setValue(2);
			direction.setBounds(105, 115, 114, 5);
			direction.setMajorTickSpacing(100);
			direction.setMinorTickSpacing(25);
			
			ok.setBounds(42, 140, img1.getIconWidth(), img1.getIconHeight());
			cancel.setBounds(130, 140, img2.getIconWidth(), img2.getIconHeight());
	
			add(mass);
			add(speedV);
			
			add(direction);
			add(ok);
			add(cancel);
	
		}
		setOpaque(false);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mass){
			massValue = Integer.parseInt(mass.getText());
		}
		else if (e.getSource() == speed){
			speedValue = Integer.parseInt(speed.getText());
		}
		
		else if (e.getSource() == magnetic){
			if (puck.getIsMagnetic()){
				isMagnetic = false;
			}
			else{
				isMagnetic = true;
			}
		}
		else if (e.getSource() == ok){
			if (type == 3 || type == 0){
				System.out.println("UUUFFF");
				puck.setMass(massValue);
				puck.getVelocity().setXY(speedValue * Math.cos(Math.toRadians(-directionValue))
						, speedValue * Math.sin(Math.toRadians(-directionValue)));
				puck.setIsMagnetic(isMagnetic);
				puck.setElasticity(elasticityValue);
				table.remove(this);
				table.repaint();
			}
			else if (type == 1){
				System.out.println("ello");
				puck.setMass(massValue);
				System.out.println(speedValue);
				puck.getVelocity().setXY(speedValue * Math.cos(Math.toRadians(-directionValue))
						, speedValue * Math.sin(Math.toRadians(-directionValue)));
				table.remove(this);
				table.repaint();
			}
			else if (type == 2){
				System.out.println("anam");
				puck.setMass(massValue);
				puck.getVelocity().setXY(speedValue * Math.cos(Math.toRadians(-directionValue))
						, speedValue * Math.sin(Math.toRadians(-directionValue)));
				table.remove(this);
				table.repaint();
			}
		
		}
		else if (e.getSource() == cancel){
			table.remove(this);
			table.repaint();
		}
		else{
			table.getPucks().remove(puck);
			table.remove(this);
			table.repaint();
		}

	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == elasticity){
			elasticityValue = elasticity.getValue();
		}
		else if (e.getSource() == direction){
			directionValue = direction.getValue();
			System.out.println(directionValue);
		}
		else if (e.getSource() == speedV){
			System.out.println(speedValue);
			speedValue = speedV.getValue();

		}
	}
	
}
