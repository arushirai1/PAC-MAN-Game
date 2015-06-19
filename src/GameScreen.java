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
		pac =(new ImageIcon("pac.png")).getImage();
		x_position = (int)Math.random()*500;
		y_position = (int)Math.random()*500;
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
		g.drawOval(x_position, y_position, 30, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
