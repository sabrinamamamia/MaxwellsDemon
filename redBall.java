package MaxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class redBall extends JComponent {
	
	//Panel height and width
	int width;
	int height;
	 
	//Ball size
	float radius = 8; 
	float diameter = radius * 2;

	float red_X = radius;
	float red_Y = radius;
	
	//Direction (Speed)
	//red: fast
	float red_dx = 6;
	float red_dy = 6;

	public redBall() {
		Thread thread = new Thread() {
			public void run() {
				
				Random rand = new Random();
				red_X += rand.nextInt(600)+299;
				red_Y += rand.nextInt(400)+1;
				
				while (true) {
					
					width = getWidth();
					height = getHeight();
					
					//width and height initially set to 0 because
					//components have no width or height until they've been rendered.
					//for this case, manually set width and height
					
					if (width == 0 && height ==0) {
						width = 600;
						height = 400;
					}
					
					red_X += red_dx;
					red_Y += red_dy;
				
					//Ball hits left wall
					//Set speed to 0 and X to radius, containing it within the panel
					if (red_X - radius < width/2) {
					  red_dx = -red_dx; 
					  red_X = width/2 + radius; 

					}

					//Ball hits right wall 
					//Set speed to 0 and X to width - radius
					  if (red_X + radius > width) {
					  red_dx = -red_dx;
					  red_X = width - radius;
					  
					}
					  
					//Ball hits top wall
					//Set speed to 0 and Y to radius
					if (red_Y - radius < 0) {
					  red_dy = -red_dy;
					  red_Y = radius;
					  
					} 

					//Ball hits bottom wall
					//Set speed to 0 and Y to radius
					else if (red_Y + radius > height) {
					  red_dy = -red_dy;
					  red_Y = height - radius;
					  
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
	    g.setColor(Color.RED);
	    g.fillOval((int)(red_X-radius), (int)(red_Y-radius), (int)diameter, (int)diameter);
  }
	
}
