package maxwellsDemon;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class maxwellsDemon extends JPanel{

public maxwellsDemon() {
	
}

public static void main(String[] args) {
     
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("maxwellsDemon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    
    JPanel panel = new JPanel();
    OverlayLayout2 overlay = new OverlayLayout2(panel);
    panel.setLayout(overlay);
    
	Random rand = new Random();
    
	//rand.nextInt(20) + 1)
    panel.add(new redBall(100, 50));
    panel.add(new redBall(20, 100));
    panel.add(new blueBall());
    panel.setVisible(true);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
