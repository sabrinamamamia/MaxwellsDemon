package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class maxwellsDemon extends JPanel{
	
public maxwellsDemon() {

}

public void paint( Graphics g )
{
   super.paint(g); // call to JFrame paint()
   
   g.drawLine(300, 0, 300, 1000);  // xy xy from upper left   
}

public static void main(String[] args) {
     
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("maxwellsDemon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new maxwellsDemon();
    OverlayLayout2 overlay = new OverlayLayout2(panel);
    panel.setLayout(overlay);
    
    for (int i=0; i <= 10; i++) {
    	panel.add(new redBall());
    	panel.add(new blueBall());
    }
    
    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    frame.setSize(600, 400);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
