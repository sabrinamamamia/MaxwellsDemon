package MaxwellsDemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class chamberPanel extends JPanel implements MouseListener{
	int x1, x2, y1, y2;	//coordinates of the wall (2 lines)
	int x3, x4, y3, y4;
	
	chamberPanel() {
		OverlayLayout2 overlay = new OverlayLayout2(this);
		this.setLayout(overlay);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = this.getWidth()/2;
		y1 = 0;
		x2 = this.getWidth()/2;
		y2 = this.getHeight()/3;
		x3 = this.getWidth()/2;
		y3 = this.getHeight() - this.getHeight()/3;
		x4 = this.getWidth()/2;
		y4 = this.getHeight();
		maxwellsDemon.mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x1 = this.getWidth()/2;
		y1 = 0;
		x2 = this.getWidth()/2;
		y2 = this.getHeight()/2;
		x3 = this.getWidth()/2;
		y3 = this.getHeight()/2;
		x4 = this.getWidth()/2;
		y4 = this.getHeight()+50;
		maxwellsDemon.mousePressed = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void paint( Graphics g )
	{
		//Draw two lines down the middle
		if (x1 == 0) {
			x1 = this.getWidth()/2;
			y1 = 0;
			x2 = this.getWidth()/2;
			y2 = this.getHeight()/2;
			x3 = this.getWidth()/2;
			y3 = this.getHeight()/2;
			x4 = this.getWidth()/2;
			y4 = this.getHeight()+100;
		}
		
		super.paint(g); // call to JFrame paint()   
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x3, y3, x4, y4);
	}
	
}
