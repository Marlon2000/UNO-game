package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Player;

/**
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable {
	
	/**
	 * constructs the mainframe, where all the paint components come in
	 */
	Window(){
		super("Uno");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Painter.init(getGraphics(),this);
		
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent evt){
				switch(evt.getKeyCode()){
					case KeyEvent.VK_LEFT:
						Player.getCurrent().prePlayerCard();
						break;
					case KeyEvent.VK_RIGHT:
						Player.getCurrent().nextPlayerCard();
						break;
					case KeyEvent.VK_UP:
						Player.getCurrent().prePlayerCard();
						break;
					case KeyEvent.VK_DOWN:
						Player.getCurrent().nextPlayerCard();
						break;
					case KeyEvent.VK_T:
						Player.getCurrent().drawCard();
						break;
					case KeyEvent.VK_SPACE:
						Player.getCurrent().layCard(Player.getCurrent().getCards().get(Player.getCurrent().getCurrentCard()));
						break;
				}
			}
		});
		Thread t = new Thread(this);
		t.start();
	}
	
	/**
	 * method to decide whether one player got zero cards left and so won the game
	 */
	@Override
	public void run() {
		
		while(Player.getCurrent().getWinner() == null) {
			try {
				Thread.sleep(30);
				Painter.paintGame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// pops up a screen with the winner mentioned
		JOptionPane.showMessageDialog(null, Player.getCurrent().getName() + " won!", "Game finished", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}	
}