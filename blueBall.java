package MaxwellsDemon;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.Random;

public class blueBall extends JComponent {
//public class blueBall extends JComponent implements MouseListener {
	
	//Panel height and width
	int width;
	int height;
	
	////Wall coordinates (2 lines)
//	int x1, x2, y1, y2;	
//	int x3, x4, y3, y4;
	 
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
	
//		addMouseListener(this);
		
		Thread thread = new Thread() {
			public void run() {
				
				Random rand = new Random();
				blue_X += rand.nextInt(299)+1;
				blue_Y += rand.nextInt(400)+1;
				
				while (true) {
					
					width = getWidth();
					height = getHeight();
					
//					x1 = getWidth()/2;
//					y1 = 0;
//					x2 = getWidth()/2;
//					y2 = getHeight()/2;
//					x3 = getWidth()/2;
//					y3 = getHeight()/2;
//					x4 = getWidth()/2;
//					y4 = getHeight()+50;

					
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
					
//					//Right wall - line 1
//					  if (blue_X + radius > x1 && blue_Y - radius < y1) {
//					  blue_dx = -blue_dx;
//					  blue_X = x1 - radius;
//					}
//					  
//					//Right wall - line 2
//					  if (blue_X + radius > x1 && blue_Y - radius < y3) {
//					  blue_dx = -blue_dx;
//					  blue_X = x1 - radius;
//					}
					
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
	
//	@Override
//	public void mousePressed(MouseEvent e) {
//		x1 = this.getWidth()/2;
//		y1 = 0;
//		x2 = this.getWidth()/2;
//		y2 = this.getHeight()/3;
//		x3 = this.getWidth()/2;
//		y3 = this.getHeight() - this.getHeight()/3;
//		x4 = this.getWidth()/2;
//		y4 = this.getHeight();
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		x1 = this.getWidth()/2;
//		y1 = 0;
//		x2 = this.getWidth()/2;
//		y2 = this.getHeight()/2;
//		x3 = this.getWidth()/2;
//		y3 = this.getHeight()/2;
//		x4 = this.getWidth()/2;
//		y4 = this.getHeight()+50;
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {}
//	@Override
//	public void mouseEntered(MouseEvent e) {}
//	@Override
//	public void mouseExited(MouseEvent e) {}
//	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)(blue_X-radius), (int)(blue_Y-radius), (int)diameter, (int)diameter);
	}
}
