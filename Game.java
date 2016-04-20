import java.util.Scanner;
import java.util.ArrayList;

public class Game {

  private int numPlayers;
  private ArrayList<Player> players;
  private Deck baraja;
  
  public Game() {
    numPlayers = 0;
    players = new ArrayList<Player>();
    baraja = new Deck();
  }

  public void setNumPlayers(int numPlayers) {
  	this.numPlayers = numPlayers;

  	for (int i=0; i<numPlayers; i++) {
  		Player jugador = new Player();
  		players.add(jugador);
  	}
  }

  public int getNumPlayers() {
  	return numPlayers;
  }

  public void shuffleCards () {
  	baraja.shuffleCards();
  }

  public void distributeCards () {
  	int actualPos = 0;
  	int actualPlayer = 1;
  	int limit = (numPlayers-1)*5;

  	do {
  		ArrayList<Card> handAux = baraja.getSubList(actualPos, actualPos+4);
  		Player jugador = players.get(actualPlayer-1);
  		jugador.setHand(handAux);
  		actualPos += 5;
  		actualPlayer += 1;
  	} while (actualPos <= limit);
  }

}
