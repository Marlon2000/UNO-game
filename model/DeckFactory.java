package model;
import java.util.Stack;

/**
 * builds up all the decks and provides the logic
 * 
 * @author marlon weiss
 *
 */
public class DeckFactory {
	
	public static Stack<Card> createDeck() {
		
		Stack<Card> deck;
		
		deck = new Stack<Card>();
		
		for (Color color : Color.values()) {
			for (Number number : Number.values()) {
				deck.add(new Card(number, color));
			}
		}
		
		return deck;
	}
}