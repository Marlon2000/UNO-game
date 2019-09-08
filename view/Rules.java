package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/** This class displays the rules
@Author:   Marlon Loretz
@Date:     29.06.19
@Version:  V1.0
*/

public class Rules extends JFrame{
	
	private String rule = "Ziel des Spiels:\r\n" + 
			"Das Ziel beim klassischen UNO ist es als Erster Spieler 500 Punkte zu erzielen. \r\n" + 
			"Pro Runde erhält der Spieler Punkte, welcher als Erster alle seine Karten auf der Hand ablegt. \r\n" + 
			"Punkte gibt es für alle Karten, die die übrigen Mitspieler noch auf der Hand halten (siehe Punkte).\r\n" + 
			"\r\n" + 
			"Spielvorbereitung:\r\n" + 
			"Die Karten werden gemischt und jeder Spieler erhält 7 Karten, die er auf die Hand nimmt. \r\n" + 
			"Die verbleibenden Karten werden verdeckt in die Mitte gelegt und bilden den Kartenstapel. \r\n" + 
			"Vom Kartenstapel wird die oberste Karte aufgedeckt und daneben gelegt. Dieser Stapel bildet den Ablegestapel. \r\n" + 
			"Ein Spieler wird ausgelost der die Runde beginnt.\r\n" + 
			"\r\n" + 
			"Spielverlauf:\r\n" + 
			"Der erste Spiele legt eine Karte von seiner Hand auf den Ablegestapel. \r\n" + 
			"Dabei gilt: Eine Karte kann nur auf eine Karte der gleichen Farbe oder der gleichen Zahl gelegt werden. \r\n" + 
			"Die schwarzen Karten sind spezielle Aktionskarten mit besonderen Regeln (siehe Aktionskarten). \r\n" + 
			"Kann ein Spieler keine passende Karte legen, so muss er eine Strafkarte vom verdeckten Stapel ziehen. \r\n" + 
			"Diese Karte kann er sofort wieder ausspielen, sofern diese passt. \r\n" + 
			"Hat er keine passende Karte ist der nächste Spieler an der Reihe. \r\n" + 
			"Wer die vorletzte Karte ablegt, muss „UNO!“ (das bedeutet “Eins”) rufen und signalisiert damit, \r\n" + 
			"dass er nur noch eine Karte auf der Hand hat. Vergisst ein Spieler das und ein anderer bekommt\r\n" + 
			" es rechtzeitig mit (bevor der nächste Spieler eine Karte gezogen oder abgeworfen hat) \r\n" + 
			" so muss er 2 Strafkarten ziehen. Die Runde gewinnt derjenige, welcher die letzte Karte abgelegt hat.\r\n" + 
			" \r\n" + 
			"Die Punkte werden addiert und eine neue Runde wird gespielt";
	
	JTextArea rules = new JTextArea(rule);
	
	public Rules() {
		
		RulesGui();
	}
	
	/**
	 * This Method creates the corresponding gui
	 */
	public void RulesGui() {

//ContentPane
		getContentPane().add(rules, BorderLayout.CENTER);

//GUI
		setTitle("Regeln");
		setSize(650, 450);
		setVisible(true);
		
		
	
	}

}