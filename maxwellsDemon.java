package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class maxwellsDemon extends JPanel{

//Box height and width
int width;
int height;
 
//Ball size
float radius = 20; 
float diameter = radius * 2;
 
//Center of balls

Random rand = new Random();
int  red_randX = rand.nextInt(50) + 1;
int  red_randY = rand.nextInt(20) + 1;
int  blue_randX = rand.nextInt(299) + 100;
int  blue_randY = rand.nextInt(20) + 1;

float red_X = radius + red_randX;
float red_Y = radius + red_randY;
float blue_X = radius + blue_randX;
float blue_Y = radius + blue_randY;
 
//Direction (Speed)
//red: fast
float red_dx = 5;
float red_dy = 5;

//blue: slow
float blue_dx = 2;
float blue_dy = 2;

public maxwellsDemon() {
	Thread thread = new Thread() {
		public void run() {
			while (true) {
				width = getWidth();
				height = getHeight();
				
				red_X = red_X + red_dx;
				red_Y = red_Y + red_dy;
				blue_X = blue_X + blue_dx;
				blue_Y = blue_Y + blue_dy;
				
				//*Bounce off wall cases for red ball*//
				//Ball hits left wall
				//Set speed to 0 and X to radius, containing it within the panel
				if (red_X - radius < 0) {
				  red_dx = -red_dx; 
				  red_X = radius; 
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
	    g.setColor(Color.RED);
	    g.fillOval((int)(red_X-radius), (int)(red_Y-radius), (int)diameter, (int)diameter);
  }



//public void paintComponent(Graphics g) {
//    super.paintComponent(g);
//    g.setColor(Color.BLUE);
//    g.fillOval((int)(blue_X-radius), (int)(blue_Y-radius), (int)diameter, (int)diameter);
//  }

public static void main(String[] args) {
     
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("maxwellsDemon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(600, 200);
    
   
    
    JPanel pane = new JPanel(new BorderLayout());
    pane.setSize(300, 100);
    pane.add(new maxwellsDemon());
    pane.add(new maxwellsDemon());
    
    frame.setContentPane(pane);
    frame.setVisible(true);
  }
}
