package MaxwellsDemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Random;

public class maxwellsDemon extends JPanel{


	public maxwellsDemon() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("maxwellsDemon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = this;
		OverlayLayout2 overlay = new OverlayLayout2(panel);
		panel.setLayout(overlay);

		JButton redBallBtn = new JButton("RED");
		panel.add(redBallBtn);
		
		
		JButton blueBallBtn = new JButton("BLUE");
		panel.add(blueBallBtn);
		
		
		
		redBallBtn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						panel.add(new redBall());
						panel.validate();
						panel.repaint();
					}}
				);
		
		blueBallBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.add(new blueBall());
				panel.validate();
				
			}}
		);



//		for (int i=0; i <= 10; i++) {
//			panel.add(new redBall());
//			panel.add(new blueBall());
//		}

		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.setSize(600, 400);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	public void paint( Graphics g )
	{
		super.paint(g); // call to JFrame paint()

		g.drawLine(300, 0, 300, 1000);  // xy xy from upper left   
	}
	


	public static void main(String[] args) {
		maxwellsDemon game = new maxwellsDemon();
		
	}
}
