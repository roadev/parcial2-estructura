import java.util.Scanner;
import java.util.Arrays;

public class Player {

	private Card[] hand;
	private int bet;
	private int valorJugada;

	public Player() {
		hand = new Card[5];
		valorJugada = 0;
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

	public int getValorJugada () {
		return valorJugada;
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
				valorJugada = 10;
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
				valorJugada = 9;
				i=4;
			}
		}
		return esEC;
	}

	public boolean poquer () {
		boolean esPoquer = false;
		int valorReferencia = hand[0].getValue();
		int valorActual = 0;

		for (int i = 1; i < 5; i++) {
			valorActual = hand[i].getValue();
			if (valorActual != valorReferencia) {
				if (i == 1)
					valorReferencia = valorActual;
				else if (i < 4) {
					esPoquer = false;
					i = 4;
				}
			} else {
				// (i==1) || (i==2)) || (i==3)
				esPoquer = true;
				valorJugada = 8;
			}
		}
		return esPoquer;
	}

	public boolean hayTrioCartas (Card[] array) {
		boolean trio = false;
		int valorReferencia = array[0].getValue();
		int valorActual = 0;
		int iguales = 1;

		for (int i = 1; i < array.length; i++) {
			valorActual = array[i].getValue();
			if (valorActual == valorReferencia) {
				if (iguales < 3) {
					trio = true;
					iguales++;
					if (iguales == 3)
						i = (array.length) - 1;
				} else {
					trio = false;
					i = (array.length) - 1;
				}
			} else {
				if (i > 2) {
					trio = false;
					i = (array.length) - 1;
				}
			}
		}
		return trio;
	}

	public boolean hayParCartas (Card[] array) {
		boolean par = false;
		int valorReferencia = array[0].getValue();
		int valorActual = 0;
		int iguales = 1;

		for (int i = 1; i < array.length; i++) {
			valorActual = array[i].getValue();
			if (valorActual == valorReferencia) {
				//
			} else {
				//
			}
		}
		return par;
	}

	public String decirJugada () {

		if (escaleraReal())
			return "Escalera Real";
		else if (escaleraColor())
			return "Escalera Color";
		else if (poquer())
			return "Poquer";
		else {
			valorJugada = 1;
			return "Carta Alta";
		}

	}
}