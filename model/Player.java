package model;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A player of the game
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public class Player {
	
	private int currentCard;
	private String name;
	private CardBoard cardBoard;
	private String status;
	private ArrayList<Card> cards;
	private static ArrayList<Player> allPlayers;

	/**
	 * constructs a player with an empty hand
	 * 
	 * @param name
	 */
	public Player(String name, CardBoard cardBoard) {
		
		currentCard = 0;
		this.name = name;
		this.cardBoard = cardBoard;
		cards = new ArrayList<Card>();
		allPlayers = new ArrayList<Player>();
		
		status = "waiting";
	}
	
	/**
	 * switches the status as soon as it's the player's turn
	 */
	public void start() {
		
		myTurn();
	}
	
	/**
	 * initalizes the status
	 */
	private void myTurn() {
		
		status = "playing";
		sortCards();
	}
	
	/**
	 * sorts the cards by their values
	 */
	private void sortCards() {
		
		boolean changed;
		
		changed = true;
		
		while (changed) {
			changed = false;
			
			for (int i = 0; i < cards.size() - 1; i ++) {
				if (cards.get(i).getCardColor().getSortingValue() > cards.get(i + 1).getCardColor().getSortingValue()) {
					Collections.swap(cards, i, i + 1);
					changed = true;
				}
			}
		}
		
		changed = true;
		
		while (changed) {
			changed = false;
			
			for (int i = 0; i < cards.size() - 1; i ++) {
				if (cards.get(i).getCardNumber().getNumber() > cards.get(i + 1).getCardNumber().getNumber() && cards.get(i).getCardColor() == cards.get(i + 1).getCardColor()) {
					Collections.swap(cards, i, i + 1);
					changed = true;
				}
			}
		}
	}
	
	/**
	 * method used to  switch between cards
	 */
	public void nextPlayerCard() {
		
		if (currentCard != cards.size() - 1) {
			currentCard ++;
		} else {
			currentCard = 0;
		}
	}
	
	/**
	 * method used to  switch between cards
	 */
	public void prePlayerCard() {
		
		if (currentCard != 0) {
			currentCard --;
		} else {
			currentCard = cards.size() - 1;
		}
	}
	
	/**
	 * 
	 * @return the current card
	 */
	public int getCurrentCard() {
		
		return currentCard;
	}
	
	public void layCard(Card card) {
		
		if (checkCard(card)) {
			cards.remove(card);
			cardBoard.layCard(card);
			
			currentCard = 0;
			nextPlayer();
		}
	}
	
	public Player getWinner() {
		
		for (Player player : allPlayers) {
			if (player.getStatus().equals("winner")) {
				return player;
			}
		}
		
		return null;
	}
	
	/**
	 * draws a card for a player
	 */
	public void drawCard() {
		
		if (isAllowedToDrawCard()) {
			Card drawnCard;
			
			drawnCard = cardBoard.drawCard();
			
			if (checkCard(drawnCard)) {
				layCard(drawnCard);
			} else {
				cards.add(drawnCard);
				nextPlayer();
			}
		}
	}
	
	/**
	 * 
	 * @param card
	 * add a card to cards
	 */
	public void getCard(Card card) {
		
		cards.add(card);
	}
	
	/**
	 * 
	 * @return current player
	 */
	public static Player getCurrent() {
		
		for (int i = 0; i < allPlayers.size(); i ++) {
			if (allPlayers.get(i).getStatus() != null) {
				if (allPlayers.get(i).getStatus().equals("playing")) {
					return allPlayers.get(i);
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return all players
	 */
	public static ArrayList<Player> getAllPlayers() {
		
		return allPlayers;
	}
	
	/**
	 * 
	 * @return the card board
	 */
	public CardBoard getCardBoard() {
		
		return cardBoard;
	}
	
	/**
	 * the next players turn
	 */
	private void nextPlayer() {
		
		if (getID() != 3) {
			allPlayers.get(getID() + 1).myTurn();
		} else {
			allPlayers.get(0).myTurn();
		}
		
		if (cards.size() == 0) {
			status = "winner";
		} else {
			status = "waiting";
		}
	}
	
	/**
	 * 
	 * @return player + number
	 */
	public int getID() {
		
		for (int i = 0; i < allPlayers.size(); i ++) {
			if (allPlayers.get(i) == this) {
				return i;
			}
		}
		
		return 0;
	}
	
	/**
	 * 
	 * @return player allowed to draw a card so he can take one
	 */
	private boolean isAllowedToDrawCard() {
		
		for (int i = 0; i < cards.size(); i ++) {
			if (checkCard(cards.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param card
	 * @return if card matches true else false
	 * checks if cards are matching
	 */
	private boolean checkCard(Card card) {
		
		if (card.getCardColor() == cardBoard.getTopCard().getCardColor() || card.getCardNumber() == cardBoard.getTopCard().getCardNumber()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * players are setted up
	 * 
	 * @param allPlayers
	 */
	public void setAllPlayers(ArrayList<Player> allPlayers) {
		
		Player.allPlayers = allPlayers;
	}

	/**
	 * 
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the status
	 */
	public String getStatus() {
		
		return status;
	}

	/**
	 * 
	 * @return hand of the player
	 */
	public ArrayList<Card> getCards() {
		
		return cards;
	}
}