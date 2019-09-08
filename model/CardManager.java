package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * manages the shuffling and distributing of the cards
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public class CardManager {
	
	private Stack<Card> cardDeck;
	
	public CardManager(ArrayList<Player> players, CardBoard cardBoard) {
		
		cardDeck = DeckFactory.createDeck();
		
		Collections.shuffle(cardDeck);
		
		spreadOut(players);
		
		transferDeck(cardBoard);
	}
	
	/**
	 * @param players
	 * distributes the cards to all the players
	 */
	private void spreadOut(ArrayList<Player> players) {
		
		for (Player player : players) {
			for (int i = 0; i < 7; i ++) {
				player.getCard(cardDeck.pop());
			}
		}
	}
	
	/**
	 * 
	 * @param cardBoard
	 * transfers the cards from the card board and the card deck
	 */
	private void transferDeck(CardBoard cardBoard) {
		
		cardBoard.transferDeck(cardDeck);
	}
}