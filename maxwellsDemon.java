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
		JLabel blueTemp = new JLabel("Temperature: " + Double.toString((Math.sqrt(2)*blueCount)/blueCount));
		tempPanel.add(blueTemp);

		//average of the squares of the velocities (red velocity = 2 cm/s)
		//JLabel redTemp = new JLabel("Temperature:" + Double.toString(Math.sqrt(6)/redCount));
		JLabel redTemp = new JLabel("Temperature: " + Double.toString((Math.sqrt(6)*redCount)/redCount));
		tempPanel.add(redTemp);

		for (int i = 0; i < 10; i++)
		{
			chamberPanel.add(new redBall());
			chamberPanel.add(new blueBall());
		}
		
		redBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.add(new redBall());
				chamberPanel.validate();
				chamberPanel.repaint();
				redCount++;
				System.out.println((Math.pow(6,2)*redCount)/redCount);
				redTemp.setText("Temperature:" + Double.toString((Math.pow(6,2)*redCount)/redCount));
			}}
		);
		blueBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.add(new blueBall());
				chamberPanel.validate();
				chamberPanel.repaint();
				blueCount++;
				blueTemp.setText("Temperature:" + Double.toString((Math.pow(2,2)*blueCount)/blueCount));
			}}
		);

		resetBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.removeAll();
				chamberPanel.repaint();
				blueCount = 0;
				redCount = 0;
				tempPanel.validate();
				blueTemp.setText("Temperature:" + Double.toString(0));
				redTemp.setText("Temperature:" + Double.toString(0));
				
			}}
		);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		maxwellsDemon game = new maxwellsDemon();
	}
}
