import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameScreen extends JPanel implements ActionListener {
	
	
	private static final int DELAY = 10;
	boolean moveUp = false;
	boolean moveDown = false;
	boolean moveRight = false;
	boolean moveLeft = false;
	
	int x_position;
	int y_position;
	Timer timer;
	Image pac;
	
	public GameScreen() {
		setBackground(Color.black);
		setSize(500, 500);
		pac =(new ImageIcon("pac.png")).getImage();
		x_position = 250;
		y_position = 250;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void move() {
		if(moveUp) {
			y_position++;
		}
		
		if(moveDown) {
			y_position--;
		}
		
		if(moveRight){
			x_position++;
		}
		
		if(moveLeft){
			x_position++;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(pac, x_position, y_position, this);
		
		g.setColor(Color.YELLOW);
		g.fillOval(x_position + 80, y_position+15, 20, 20);
		
		Toolkit.getDefaultToolkit().sync();

	}
	
	public void checkCollisions() {
		
	}
	
	//move, check for collisions, make a wall, create dots for the pac to eat, if all dots are eaten next game, create ghosts,
	public void gameSetUp() {
		//make a wall, create dots for the pac to eat,
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}
	
	private class Mover extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {
				moveLeft = true;
				moveRight = false;
				moveDown = false;
				moveUp = false;
			}
			
			if(key == KeyEvent.VK_RIGHT) {
				moveLeft = false;
				moveRight = true;
				moveDown = false;
				moveUp = false;
			}
			
			if(key == KeyEvent.VK_UP) {
				moveLeft = false;
				moveRight = false;
				moveDown = false;
				moveUp = true;
			}
			
			if(key == KeyEvent.VK_DOWN) {
				moveLeft = false;
				moveRight = false;
				moveDown = true;
				moveUp = false;
			}
		}
		
	}
}
