import java.util.Scanner;

public class Player {

	private Card[] hand;
	private int bet;

	public Player() {
		hand = new Card[5];
		bet = 0;
	}

	public void setHand (Card[] hand) {
		this.hand = hand;
	}

	public Card[] getHand () {
		return hand;
	}

	public String printHand () {
		String handStr = "";
		for (int i=0; i<5; i++) {
			handStr += hand[i].getSymbol() + " ";
		}
		return handStr;
	}

	public void setBet (int bet) {
		this.bet = bet;
	}

	public int getBet () {
		return bet;
	}
}