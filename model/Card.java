package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author marlon weiss
 * @date 06.07.2019
 * @version v2.3
 *
 */
public class Card {
	
	private Number cardNumber;
	private Color cardColor;
	private Image image;
	
	public Card(Number cardNumber, Color cardColor) {
		
		this.cardNumber = cardNumber;
		this.cardColor = cardColor;
		
		// reads in the image file of a single card
		try {
			image = ImageIO.read(new File("src/Img/"+ cardColor + "_" + cardNumber.getNumber() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return number of the card
	 */
	public Number getCardNumber() {
		
		return cardNumber;
	}

	/**
	 * 
	 * @return color of the card
	 */
	public Color getCardColor() {
		
		return cardColor;
	}
	
	public Image getImage() {
		
		return image;
	}

	public void setImage(Image image) {
		
		this.image = image;
	}
	
	/**
	 * returns the card in a String
	 */
	@Override
	public String toString() {
		
		return cardNumber.getNumber() + "of" + cardColor.getColor();
	}
}