package view;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.Card;
import model.Player;

/**
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public class Painter {
	// sets up the graphics
	private static Graphics g;
	private static Window window;
	private static Point[]p = {
			new Point(395,450),
			new Point(130,295),
			new Point(395,150),
			new Point(670,295)
	};
	// all the png images which are used to draw
	private static Image fdc, help, player1, player2, player3, player4;
	private static BufferedImage buffer;
	
	/**
	 * reads all the images of the painter class in and sets them in a window
	 * @param g
	 * @param w
	 */
	static void init(Graphics g, Window w){
		buffer =new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		
		Painter.g = buffer.createGraphics();
		Painter.window = w;
		try {
			fdc = ImageIO.read(new File("src/Img/back_side.png"));
			help = ImageIO.read(new File("src/Img/help.png"));
			player1 = ImageIO.read(new File("src/Img/player1.png"));
			player2 = ImageIO.read(new File("src/Img/player2.png"));
			player3 = ImageIO.read(new File("src/Img/player3.png"));
			player4 = ImageIO.read(new File("src/Img/player4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sets up the whole image components in the window frame
	 */
	public static void paintGame() {
		try {
			fdc = ImageIO.read(new File("src/Img/back_side.png"));
			help = ImageIO.read(new File("src/Img/help.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		g.fillRect(0, 0, 800, 600);
		paintPlayerCards();
		paintBoardCards();
		paintDecks();
		Point point = p[Player.getCurrent().getID()] ;
		g.setColor(new java.awt.Color(1f,1f,1f));
		g.fillOval(point.x, point.y, 20, 20);
		g.drawImage(help, 590, 30, window);
		g.drawImage(player1, 720, 500, window);
		g.drawImage(player2, 723, 520, window);
		g.drawImage(player3, 723, 540, window);
		g.drawImage(player4, 723, 560, window);
		update();
	}
	
	/**
	 * method used to draw the card images of the players in the frame and set their location in the frame
	 */
	private static void paintDecks() {
		
		ArrayList<Integer> indices;
		
		indices = new ArrayList<Integer>();
		
		for (int i = 0; i < Player.getAllPlayers().size(); i ++) {
			if (Player.getAllPlayers().get(i).getStatus().equals("waiting")) {
				indices.add(i);
			}
		}
		
		if (indices.size() > 0) {
			int x =  Player.getAllPlayers().get(indices.get(0)).getCards().size();
			int a = 0;
			for(int i = 0;i<x;i++){
				g.drawImage(fdc, 50, (600-(a*10)-47)/2, 57, 85, window);
				a++;
			}
		}
		
		if (indices.size() > 1) {
			int x =  Player.getAllPlayers().get(indices.get(1)).getCards().size();
			int a = 0;
			for(int i = 0;i<x;i++){
				g.drawImage(fdc, ((800-(10*x)-47)/2+(a*10)), 50, 57, 85, window);
				a++;
			}
		}
		
		if (indices.size() > 2) {
			int x =  Player.getAllPlayers().get(indices.get(2)).getCards().size();
			int a = 0;
			for(int i = 0;i<x;i++){
				g.drawImage(fdc, 700, (600-(a*10)-47)/2, 57, 85, window);
				a++;
			}
		}
		
	}
	
	/**
	 * method used to display the discard pile
	 */
	private static void paintBoardCards() {
		
		g.drawImage(fdc, 50, 50, 57, 85, window);
		g.drawImage(Player.getCurrent().getCardBoard().getTopCard().getImage(), (800-57)/2, (600-85)/2, 57, 85, window);
		
	}
	private static void paintPlayerCards() {
		int x =  Player.getCurrent().getCards().size();
		int a = 0;
		for(int i = 0; i<Player.getCurrent().getCards().size();i++){
			Card c = Player.getCurrent().getCards().get(i);
			if(i!=Player.getCurrent().getCurrentCard()) {
				g.drawImage(c.getImage(), ((800-(30*x)-27)/2+(a*30)), 500, 57, 85, window);
			}
			else {
				g.drawImage(c.getImage(), ((800-(30*x)-27)/2+(a*30)), 490, 57, 85, window);
			}
				
			a++;
		}
	}
	
	/**
	 * updates the gui itself with the added images
	 */
	private static void update() {
		window.getGraphics().drawImage(buffer, 0, 0, window);
	}
}