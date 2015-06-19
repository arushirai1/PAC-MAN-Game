import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu implements ActionListener {

	JLabel menuImageLabel;
	JFrame frame;
	JButton startButton, infoButton, exitButton;
	JPanel menuImagePanel, menuButtonsPanel;
	BufferedImage image;

	public Menu() {
		frame = new JFrame();
		menuImagePanel = new JPanel();
		menuButtonsPanel = new JPanel();
		addMenuElements();
	}

	public void addMenuElements() {
		frame.setTitle("Pac Man Game Main Menu");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addButtons();
		//addImage();
		
		frame.add(menuImagePanel, BorderLayout.NORTH);
		frame.add(menuButtonsPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	public void addButtons() {
		startButton = new JButton("Start");
		infoButton = new JButton("Info");
		exitButton = new JButton("Exit");
		
		menuButtonsPanel.setLayout(new GridLayout(1,3));
		menuButtonsPanel.add(startButton);
		menuButtonsPanel.add(infoButton);
		menuButtonsPanel.add(exitButton);
		
		//adding above buttons to ActionListeneer
		startButton.addActionListener(this);
		infoButton.addActionListener(this);
		exitButton.addActionListener(this);
	}
	public void addImage(Graphics g) {
		try {
			image = ImageIO.read(this.getClass().getResource("menuImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuImageLabel = new JLabel(new ImageIcon(image));
		menuImagePanel.add(menuImageLabel);
		menuImagePanel.validate();
		menuImagePanel.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == exitButton) {
			frame.setVisible(false);
			frame.dispose();
		}
		
		else if (event.getSource() == infoButton) {
			menuImagePanel.add(new TextArea("Use the arrow keys to manuover Pacman around the maze. \n" +
					"Complete the level by eating all the dots. Avoid the monsters, \n" +
					"if they catch you you will lose a life. Eat the big power dots, \n" +
					"and the monsters will temporarily turn blue, meaning that you \n" +
					"can now eat them."));
			frame.validate(); 
			frame.repaint(); 
		}
		
		else if (event.getSource() == startButton) {
			frame.remove(menuButtonsPanel);
			frame.remove(menuImagePanel);
			frame.validate();
			frame.repaint();
			
			frame.add(new GameScreen());
			frame.validate();
			frame.repaint();
		}
	}
	

}
