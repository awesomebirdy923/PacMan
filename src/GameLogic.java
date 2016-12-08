import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLogic extends Canvas implements Runnable, KeyListener{

	private Pacman pacman;
	private boolean[] keys;
	
	public GameLogic(){
		pacman = new Pacman(400/2, 400/2, 40, 42, "pac 3.png");
		keys = new boolean[100];
		setBackground(Color.black);
		setVisible(true);
		new Thread(this).start();
		addKeyListener(this);
	}

	public void paint(Graphics g){
		super.paint(g);
		pacman.paint(g);
		if(keys[0]){
			pacman.setyPos(pacman.getyPos()-1);
		} else if(keys[1]){
			pacman.setyPos(pacman.getyPos()+1);
		} else if(keys[2]){
			pacman.setxPos(pacman.getxPos()+1);
		} else if(keys[3]){
			pacman.setxPos(pacman.getxPos()-1);
		}
		
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == e.VK_UP){
			keys[0] = true;
		} else if(e.getKeyCode() == e.VK_DOWN){
			keys[1] = true;
		}else if(e.getKeyCode() == e.VK_RIGHT){
			keys[2] = true;
		}else if(e.getKeyCode() == e.VK_LEFT){
			keys[3] = true;
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == e.VK_UP){
			keys[0] = false;
		} else if(e.getKeyCode() == e.VK_DOWN){
			keys[1] = false;
		}else if(e.getKeyCode() == e.VK_RIGHT){
			keys[2] = false;
		}else if(e.getKeyCode() == e.VK_LEFT){
			keys[3] = false;
		}
	}
	
}
