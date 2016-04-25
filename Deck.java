import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;

public class Deck {

	private ArrayList<Card> cards;

	public Deck(){
		cards = new ArrayList<Card>();
		inicialize();
	}

	private void createCard (String symbol, String aux, int value) {
		Card card = new Card(symbol, aux, value);
    cards.add(card);
	}

	private void inicialize () {
		String str = "";
		int codePoint = 0;
		String symbol = "";

		String aux = "";
		//ciclo de las filas - símbolo/valor de la carta
		for (int c2 = 1, value = 1; c2 <= 0xE; c2++, value++) {
			//iteración para los palos
			// A -> picas, B -> corazones, C -> diamantes, D -> Trébol
			for (int c1 = 0xA; c1 <= 0xD; c1++) {
				if (c2 != 0xC) {
					str = String.format("1F0%X%X", c1, c2);
					codePoint = Integer.parseInt(str, 16);
					symbol = String.format("%c", codePoint);
					//testeando los palos con hexadecimales
					/*if(c1==0xA)
						aux="picas";
					else if (c1==0xB)
						aux="corazones";
					else if (c1==0xC)
						aux="diamantes";
					else if (c1==0xD)
						aux="trébol";
					System.out.println(aux+" ~ symbol="+symbol+" ("+value+")");*/

					cards.add(new Card (symbol, str, value));
				} else {
					value = 11;
				}
			}
			//System.out.println();
		}

		for (int i=0;i<5;i++)
			cards.get(i).setValue(14);
	}

	public void shuffleCards () {
		Collections.shuffle(cards);
	}

	public int sizeDeck () {
		return cards.size();
	}

	public Card[] deleteSubList() {
		Card[] subList = new Card[5];
		int pos = 0;
		do{
			subList[pos]=cards.get(pos);
			cards.remove(pos);
			pos++;
		} while (pos<5);

		return subList;
	}

	public void insertSubList(Card[] returnSublist) {
		int pos = 0;
		Card[] arrayCards = returnSublist;

		do{
			cards.add(arrayCards[pos]);
			pos++;
		} while (pos<5);
	}
}
