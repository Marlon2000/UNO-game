package model;
import java.util.Stack;

/**
 * the discardpile and the drawpile are here created
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public class CardBoard {
	private Stack<Card> discardPile;
	private Stack<Card> drawPile;
	
	public CardBoard() {
		// Creates Stacks for the discard and the draw Pile
		discardPile = new Stack<Card>();
		drawPile = new Stack<Card>();
	}
	
	/**
	 * 
	 * @param deck
	 * places a card from the draw Pile to the discard pile upwards
	 * 
	 */
	public void transferDeck(Stack<Card> deck) {
		
		drawPile = deck;
		discardPile.addElement(drawPile.pop());
	}
	
	/**
	 * 
	 * @param card
	 * when sb lays down a card the Pill will have one card more
	 */
	public void layCard(Card card) {
		
		discardPile.addElement(card);
	}
	
	/**
	 * 
	 * @return the top card of the draw pile
	 */
	public Card drawCard() {
		
		return drawPile.pop();
	}
	
	/**
	 * 
	 * @return the last card from the discard pile
	 */
	public Card getTopCard() {
		
		return discardPile.lastElement();
	}
}