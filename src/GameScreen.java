import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GameScreen extends JPanel implements ActionListener {
	
	
	boolean moveUp = false;
	boolean moveDown = false;
	boolean moveRight = false;
	boolean moveLeft = false;
	
	int x_position;
	int y_position;
	Image pac;
	
	public GameScreen() {
		setBackground(Color.black);
		setSize(500, 500);
		pac =(new ImageIcon("pac.png")).getImage();
		x_position = 250;
		y_position = 250;
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

	}
	
	public void checkCollisions() {
		
	}
	
	//move, check for collisions, make a wall, create dots for the pac to eat, if all dots are eaten next game, create ghosts,
	public void gameSetUp() {
		//make a wall, create dots for the pac to eat,
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
