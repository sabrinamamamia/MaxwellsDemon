package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class blueBall extends JComponent {
	
	//Panel height and width
	int width;
	int height;
	 
	//Ball size
	float radius = 8; 
	float diameter = radius * 2;
	
	float blue_X = radius;
	float blue_Y = radius;
	 
	//Direction (Speed)
	//blue: slow
	float blue_dx = 2;
	float blue_dy = 2;
	
	public blueBall() {
		
		Thread thread = new Thread() {
			public void run() {
				
				Random rand = new Random();
				blue_X += rand.nextInt(299)+1;
				blue_Y += rand.nextInt(400)+1;
				
				while (true) {
					
					width = getWidth();
					height = getHeight();
					
					if (width == 0 && height ==0) {
						width = 600;
						height = 400;
					}

					blue_X += blue_dx;
					blue_Y += blue_dy;
					
					//Left wall
					if (blue_X - radius < 0) {
					  blue_dx = -blue_dx; 
					  blue_X = radius; 
					}
					
					//Right wall
					  if (blue_X + radius > width/2) {
					  blue_dx = -blue_dx;
					  blue_X = width/2 - radius;
					}
					
					 //Bottom wall
					if (blue_Y - radius < 0) {
					  blue_dy = -blue_dy;
					  blue_Y = radius;
					} 
					
					//Top wall
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
