import java.util.Scanner;
import java.util.Arrays;

public class Player {

	private Card[] hand;
	private int bet;

	public Player() {
		hand = new Card[5];
		bet = 0;
	}

	public void setHand (Card[] hand) {
		Card[] copyHand = hand;
		Arrays.sort(copyHand);
		this.hand = copyHand;
	}

	public Card[] getHand () {
		return hand;
	}

	public void setBet (int bet) {
		this.bet = bet;
	}

	public int getBet () {
		return bet;
	}

	public String printHand () {
		String handStr = "";
		for (int i=0; i<5; i++) {
			handStr += hand[i].getSymbol() + " ";
		}
		return handStr;
	}

	public boolean escaleraReal () {
		boolean esER = false;
		String paloAnterior = hand[0].getStrValue().substring(3,4);
		String paloActual = "";

		for (int i=1; i<5; i++) {
			paloActual=hand[i].getStrValue().substring(3,4);
			if (paloActual != paloAnterior) {
				esER = false;
				i=4;
			} else {
				if (hand[0].getValue() == 10)
				esER = true;
				i=4;
			}
		}
		return esER;
	}

	public boolean escaleraColor () {
		boolean esEC = false;
		String paloAnterior = hand[0].getStrValue().substring(3,4);
		String paloActual = "";

		for (int i=1; i<5; i++) {
			paloActual=hand[i].getStrValue().substring(3,4);
			if (paloActual != paloAnterior) {
				esEC = false;
				i=4;
			} else {	
				if (hand[0].getValue() != 10)
				esEC = true;
				i=4;
			}
		}
		return esEC;
	}

	public String decirJugada () {
		String jugada="";

		if (escaleraReal())
			jugada = "Escalera Real";
		else if (escaleraColor())
			jugada = "Escalera Color";
		else
			jugada = "Carta Alta";

		return jugada;
	}
}