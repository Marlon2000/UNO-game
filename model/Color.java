package model;

/**
 * blueprint of a single card
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public enum Color {
	
	RED("red", 1),
	YELLOW("yellow", 2),
	GREEN("green", 3),
	BLUE("blue", 4);

	private final String colorText;
	private final int sortingValue;

	private Color(String colorText, int sortingValue) {
		
		this.colorText = colorText;
		this.sortingValue = sortingValue;
	}

	/**
	 * 
	 * @return colorText of a card
	 */
	public String getColor() {
		
		return colorText;
	}
	
	public int getSortingValue() {
		
		return sortingValue;
	}
}