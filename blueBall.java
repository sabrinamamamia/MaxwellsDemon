package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class blueBall extends JComponent {
	
	//Box height and width
	int width;
	int height;
	 
	//Ball size
	float radius = 20; 
	float diameter = radius * 2;
	 
	//Center of balls
	Random rand = new Random();
	int  blue_randX = rand.nextInt(299) + 100;
	int  blue_randY = rand.nextInt(20) + 1;
	
	float blue_X = radius + blue_randX;
	float blue_Y = radius + blue_randY;
	 
	//Direction (Speed)
	//blue: slow
	float blue_dx = 2;
	float blue_dy = 2;
	
	public blueBall() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					width = getWidth();
					height = getHeight();

					blue_X = blue_X + blue_dx;
					blue_Y = blue_Y + blue_dy;

					//*Bounce off wall cases for blue ball (same logic)*//
					if (blue_X - radius < 0) {
					  blue_dx = -blue_dx; 
					  blue_X = radius; 
					}

					  if (blue_X + radius > width) {
					  blue_dx = -blue_dx;
					  blue_X = width - radius;
					}
					  
					if (blue_Y - radius < 0) {
					  blue_dy = -blue_dy;
					  blue_Y = radius;
					} 

					else if (blue_Y + radius > height) {
					  blue_dy = -blue_dy;
					  blue_Y = height - radius;
					}
					
					repaint();
					
					try {
						Thread.sleep(50);
		            } catch (InterruptedException ex) {
		            }
				}
			}
		};
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)(blue_X-radius), (int)(blue_Y-radius), (int)diameter, (int)diameter);
	}
}
