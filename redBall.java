package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class redBall extends JComponent {
	
	//Box height and width
	int width;
	int height;
	 
	//Ball size
	float radius = 10; 
	float diameter = radius * 2;

	float red_X = 0;
	float red_Y = 0;
	
	//Direction (Speed)
	//red: fast
	float red_dx = 5;
	float red_dy = 5;

	public redBall(int randX, int randY) {
		Thread thread = new Thread() {
			public void run() {

				red_X += randX;
				red_Y += randY;
				
//				  System.out.println("red_X and red_Y outside loop");
//				  System.out.println("red_X =" + red_X);
//				  System.out.println("red_Y =" + red_Y);
				
				while (true) {
					width = getWidth();
					height = getHeight();

//					 System.out.println("width =" + width);
//					 System.out.println("height =" + height);
					
					red_X += red_dx;
					red_Y += red_dy;
					
//					 System.out.println("red_X/red_Y + red_dx/red_dy");
//					 System.out.println("red_X =" + red_X);
//					 System.out.println("red_Y =" + red_Y);

					//*Bounce off wall cases for red ball*//
					//Ball hits left wall
					//Set speed to 0 and X to radius, containing it within the panel
					if (red_X - radius < 0) {
					  red_dx = -red_dx; 
					  red_X = radius; 
					  
//					  System.out.println("red_X - radius < 0");
//					  System.out.println("red_dx =" + red_dx);
//					  System.out.println("red_X =" + red_X);
					}

					//Ball hits right wall 
					//Set speed to 0 and X to width - radius
					  if (red_X + radius > width) {
					  red_dx = -red_dx;
					  red_X = width - radius;
					  
//					  System.out.println("red_X + radius > width");
//					  System.out.println("red_dx =" + red_dx);
//					  System.out.println("red_X =" + red_X);
					  
					}
					  
					  
					//Ball hits top wall
					//Set speed to 0 and Y to radius
					if (red_Y - radius < 0) {
					  red_dy = -red_dy;
					  red_Y = radius;
					  
					  System.out.println("red_Y - radius < 0");
					  System.out.println("red_dx =" + red_dx);
					  System.out.println("red_X =" + red_X);
					  
					} 

					//Ball hits bottom wall
					//Set speed to 0 and Y to radius
					else if (red_Y + radius > height) {
					  red_dy = -red_dy;
					  red_Y = height - radius;
					  
					  System.out.println("red_Y + radius > height");
					  System.out.println("red_dx =" + red_dx);
					  System.out.println("red_X =" + red_X);
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
