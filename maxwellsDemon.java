package MaxwellsDemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Random;


public class maxwellsDemon extends JFrame{

	public static boolean mousePressed = false;
	
	JPanel chamberPanel; 	//2-part chamber
	JPanel buttonPanel;		//buttons
	JPanel tempPanel;		//temperature panel 
	
	public static int leftBlueCount = 0;
	public static int leftRedCount = 0;
	public static int rightBlueCount = 0;
	public static int rightRedCount = 0;
	
	public static JLabel leftTemp;
	public static JLabel rightTemp;
	
	
	int blueCount = 10;		//default number of balls
	int redCount = 10;
	int getblueCount() { return blueCount;}
	int getredCount() { return redCount;}
	
	public maxwellsDemon() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800, 400);
		
		chamberPanel = new chamberPanel();
		add(chamberPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 5));
		buttonPanel.setSize(new Dimension(this.getWidth(),this.getHeight()/4));
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton blueBallBtn = new JButton("Add Blue Particle");
		buttonPanel.add(blueBallBtn);
		
		JButton resetBtn = new JButton("Reset");
		buttonPanel.add(resetBtn);
		
		JButton redBallBtn = new JButton("Add Red Particle");
		buttonPanel.add(redBallBtn);
		
		tempPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 5));
		tempPanel.setSize(new Dimension(this.getWidth(),this.getHeight()/4));
		add(tempPanel, BorderLayout.NORTH);

		//average of the squares of the velocities (blue velocity = 2 cm/s)
		//JLabel blueTemp = new JLabel("Temperature:" + Double.toString(Math.sqrt(2)/blueCount));
		leftTemp = new JLabel("Temperature: ");
		tempPanel.add(leftTemp);

		//average of the squares of the velocities (red velocity = 2 cm/s)
		//JLabel redTemp = new JLabel("Temperature:" + Double.toString(Math.sqrt(6)/redCount));
		rightTemp = new JLabel("Temperature: ");
		tempPanel.add(rightTemp);

		for (int i = 0; i < 10; i++)
		{
			chamberPanel.add(new redBall());
			chamberPanel.add(new blueBall());
			leftBlueCount++;
			rightRedCount++;
		}
		
		redBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.add(new redBall());
				chamberPanel.validate();
				chamberPanel.repaint();
				rightRedCount++;
				
//				redCount++;
//				System.out.println((Math.pow(6,2)*redCount)/redCount);
				//redTemp.setText("Temperature:" + Double.toString((Math.pow(6,2)*redCount)/redCount));
			}}
		);
		blueBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.add(new blueBall());
				chamberPanel.validate();
				chamberPanel.repaint();
				leftBlueCount++;
				
//				blueCount++;
//				blueTemp.setText("Temperature:" + Double.toString((Math.pow(2,2)*blueCount)/blueCount));
			}}
		);

		resetBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.removeAll();
				chamberPanel.repaint();
//				blueCount = 0;
//				redCount = 0;
				tempPanel.validate();
				
				leftBlueCount = 0;
				leftRedCount = 0;
				rightBlueCount = 0;
				rightRedCount = 0;
				
				leftTemp.setText("Temperature:" + Double.toString(0));
				rightTemp.setText("Temperature:" + Double.toString(0));
				
			}}
		);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		maxwellsDemon game = new maxwellsDemon();
	}
	

}
