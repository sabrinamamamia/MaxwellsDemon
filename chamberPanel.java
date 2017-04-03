package maxwellsDemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class chamberPanel extends JPanel{

	chamberPanel() {
		OverlayLayout2 overlay = new OverlayLayout2(this);
		this.setLayout(overlay);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void paint( Graphics g )
	{
		super.paint(g); // call to JFrame paint()   
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight()+50);
	}
	
}
