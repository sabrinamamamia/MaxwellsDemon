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
	
	public maxwellsDemon() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800, 400);
		
		chamberPanel = new chamberPanel();
		add(chamberPanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		buttonPanel.setSize(new Dimension(this.getWidth(),this.getHeight()/4));
		add(buttonPanel, BorderLayout.SOUTH);
		

		JButton blueBallBtn = new JButton("Add Blue Particle");
		buttonPanel.add(blueBallBtn);
		
		JButton resetBtn = new JButton("Reset");
		buttonPanel.add(resetBtn);
		
		JButton redBallBtn = new JButton("Add Red Particle");
		buttonPanel.add(redBallBtn);
		
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
			}}
		);
		blueBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.add(new blueBall());
				chamberPanel.validate();
				chamberPanel.repaint();
			}}
		);

		resetBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				chamberPanel.removeAll();
				chamberPanel.repaint();
			}}
		);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		maxwellsDemon game = new maxwellsDemon();
	}
}
