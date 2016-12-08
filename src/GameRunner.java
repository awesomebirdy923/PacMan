import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameRunner {
private JFrame frame;
private GameLogic logic;
private static final int WIDTH = 800;
private static final int HEIGHT = 800;

public GameRunner(){
	frame = new JFrame();
	logic = new GameLogic();
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(logic);
	((Component)logic).setFocusable(true);
	frame.setVisible(true);
}

public static void main(String[] args){
	new GameRunner();
}
}
