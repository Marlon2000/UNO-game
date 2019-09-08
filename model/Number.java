package model;

/**
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public enum Number {
	
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8), 
	NINE(9);

	private final int numberValue;

	private Number(int numberValue) {
		
		this.numberValue = numberValue;
	}

	/**
	 * 
	 * @return value of a card
	 */
	public int getNumber() {
		
		return numberValue;
	}
}