package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**This class is suposed to guide a new player and show him how the game works
@Author:   Marlon Loretz
@Date:     05.06.19
@Version:  V1.0
*/

public class Manual extends JFrame{
	
	private String description = "Anleitung:\r\n" + 
			"Dieses Spiel ist für 4 Leute gedacht. Trommeln Sie ihre Freunde zusammen und spielen Sie zusammen eine Runde UNO \r\n" + 
			"\r\n" + 
			"Als Erstes wählt jeder Spieler einen Namen und eine Farbe aus. Der Name wird immer dann angezeigt, wenn dieser am Zug ist. \r\n" + 
			"Mit dem Knopf *Regeln* können Sie die Spielregeln ansehen. Die sind wichtig und sollten durchgelesen werden.\r\n" + 
			"Auch die Farbe wird dann angezeigt wenn der Spieler am Zug ist. Wenn jeder eine Namen hat, kann man mit dem Knopf *Spiel starten* beginnen.\r\n" + 
			"\r\n" + 
			"Jeder Spieler hat nun seine Hand vor ihm. Mit den Pfeiltasten können Sie in ihrer Hand herumnavigieren. \r\n" + 
			"Wenn Sie eine Karte setzen wollen, machen Sie dass mit der Leertaste. Fals Sie eine Karte ziehen müssen, drücken Sie T.\r\n" + 
			"Wenn ihre Karte nicht spielbar ist, wird diese blokiert. Derjenige der zuerst keine Karten mehr hat gewinnt.\r\n" + 
			"Falls Sie nur noch eine Karte haben, müssen Sie dass signalisieren, indem Sie auf den *UNO* Knopf drücken.\r\n" + 
			"Wenn Sie nicht auf diesen Knopf drücken, haben die anderen Spieler die Möglichkeit zu reklamieren, indem Sie\r\n" + 
			"auf den *UNO-Reklamieren* Knopf drücken. \r\n" + 
			"\r\n" + 
			"Es gewinnt derjenige der am Ende am meisten Punkte hat. Den Punktestand kann man nach jeder Runde auf dem Scoreboard sehen.";
	
	JTextArea manual = new JTextArea(description);

	public Manual() {
		ManualGui();
	}
	
	/**
	 * This methode builds the gui up
	 */
	public void ManualGui() {

//ContentPane
		
		getContentPane().add(manual, BorderLayout.CENTER);

//GUI
		setTitle("Regeln");
		setSize(820, 300);
		setVisible(true);
	}
}