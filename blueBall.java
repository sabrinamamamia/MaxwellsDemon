package MaxwellsDemon;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.Random;

public class blueBall extends JComponent {
	
	//Panel height and width
	float width;
	float height;
	 
	//Ball size
	float radius = 8; 
	float diameter = radius * 2;
	
	float blue_X = radius;
	float blue_Y = radius;
	 
	//Direction (Speed): slow
	float blue_dx = 2;
	float blue_dy = 2;
	
	boolean otherSide = false;
	
	public blueBall() {
		Thread thread = new Thread() {
			public void run() {
				
				Random rand = new Random();
				blue_X += rand.nextInt(299)+1;
				blue_Y += rand.nextInt(400)+1;
				
				while (true) {
					
					width = getWidth();
					height = getHeight();

					if (width == 0 || height == 0) {
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
					
					//Middle wall 
					if (blue_X + radius > width/2 && otherSide == false) {
						if (maxwellsDemon.mousePressed == false ||
							(blue_Y < height/3 || blue_Y > height-height/3)){
							blue_dx = -blue_dx;
							blue_X = width/2 - radius;
						}
						else 
						{
							otherSide = true;
						}
					}
					
					//Middle wall - other side
					if (blue_X - radius < width/2 && otherSide == true) {
						if (maxwellsDemon.mousePressed == false ||
							(blue_Y < height/3 || blue_Y > height-height/3)){
							blue_dx = -blue_dx;
							blue_X = width/2 + radius;
						}
						else 
						{
							otherSide = false;
						}
					}
										
					//Right wall
					  if (blue_X + radius > width) {
						  blue_dx = -blue_dx;
						  blue_X = width - radius;
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
