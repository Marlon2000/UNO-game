package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CardBoard;
import model.CardManager;
import model.Player;

/**
 * This Class is a gui class whos purpose it is to display the startingscreen.
 * It has many buttons to click on including the start oder the exit button.
   @Author:   Marlon Loretz
   @Date:     29.06.19
   @Version:  V2.3
*/

public class Startmenu extends JFrame{
	
	
	private JLabel name = new JLabel("Name");
	private JLabel nr = new JLabel("Nr.");
	private JLabel color = new JLabel("Farbe");
		
	private JLabel player1 = new JLabel("Spieler 1");
	private JLabel player2 = new JLabel("Spieler 2");
	private JLabel player3 = new JLabel("Spieler 3");
	private JLabel player4 = new JLabel("Spieler 4");
	
	private JTextField name1 = new JTextField(30);
	private JTextField name2 = new JTextField(30);
	private JTextField name3 = new JTextField(30);
	private JTextField name4 = new JTextField(30);
	
	public String namePlayer1;
	public String namePlayer2;
	public String namePlayer3;
	public String namePlayer4;
	
	public String getColor1;
	public String getColor2;
	public String getColor3;
	public String getColor4;
	
	private String[] Farben = {"Grün", "Blau", "Rot", "Gelb"};
	
	private JComboBox color1 = new JComboBox(Farben);
	private JComboBox color2 = new JComboBox(Farben);
	private JComboBox color3 = new JComboBox(Farben);
	private JComboBox color4 = new JComboBox(Farben);
	
	private JButton start = new JButton("Start");
	private JButton exit = new JButton("Schliessen");
	private JButton rules = new JButton("Regeln");
	private JButton manual = new JButton("Benutzerhandbuch");
	
	
	public Startmenu() {
		
		startmenu();
		
	}

	/**
	 * 	This methode creates all the needed panels for the gui and adds them to the ContentPane.
	 *  It is also responsible for the Listeners
	 */
	public void startmenu() {
		
//Panels
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(1, 4));
		buttonpanel.add(exit);
		buttonpanel.add(rules);
		buttonpanel.add(manual);
		buttonpanel.add(start);
		
		
		JPanel titlepanel = new JPanel();
		titlepanel.setLayout(new GridLayout(1, 3));
		titlepanel.add(nr);
		titlepanel.add(name);
		titlepanel.add(color);
		
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridLayout(4,3));
		
		mainpanel.add(player1);
		mainpanel.add(name1);
		mainpanel.add(color1);
		
		mainpanel.add(player2);
		mainpanel.add(name2);
		mainpanel.add(color2);
		
		mainpanel.add(player3);
		mainpanel.add(name3);
		mainpanel.add(color3);
		
		mainpanel.add(player4);
		mainpanel.add(name4);
		mainpanel.add(color4);
		
//ContentPane
		
		getContentPane().add(titlepanel, BorderLayout.NORTH);
		getContentPane().add(mainpanel, BorderLayout.CENTER);
		getContentPane().add(buttonpanel, BorderLayout.SOUTH);
	
//GUI
		setSize(600, 400);
		setVisible(true);
		setTitle("Startmenü");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Listener
		
		ActionListener manuallistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Manual manual = new Manual();
			}
			
		};
		manual.addActionListener(manuallistener);
		
		ActionListener exitlistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
			
		};
		exit.addActionListener(exitlistener);
		
		
		ActionListener settingslistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				Rules rules = new Rules();
				
			}
		};
		rules.addActionListener(settingslistener);
		
		
		ActionListener startlistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				namePlayer1 = name1.getText();
				namePlayer2 = name2.getText();
				namePlayer3 = name3.getText();
				namePlayer4 = name4.getText();
				
				getColor1 = (String)color1.getSelectedItem();
				getColor2 = (String)color2.getSelectedItem();
				getColor3 = (String)color3.getSelectedItem();
				getColor4 = (String)color4.getSelectedItem();
				
				CardBoard cardBoard;
				ArrayList<Player> players;
				
				cardBoard = new CardBoard();
				
				players = new ArrayList<Player>();
				
				for (int i = 0; i < 4; i ++) {
					players.add(new Player("Player " + (i + 1), cardBoard));
				}
				
				for (int i = 0; i < 4; i ++) {
					players.get(i).setAllPlayers(players);
				}
				
				new CardManager(players, cardBoard);
				
				players.get(0).start();
				
				new Window();
				
			}
		};
		start.addActionListener(startlistener);	

	}

}
