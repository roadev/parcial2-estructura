import java.util.Scanner;
import java.util.ArrayList;

public class Game {

  private Scanner input;
  private int numPlayers;
  private ArrayList<Player> players;
  private Deck baraja;

  public Game() {
    numPlayers = 0;
    players = new ArrayList<Player>();
    baraja = new Deck();
    input = new Scanner(System.in);
  }

  public void setNumPlayers(int numPlayers) {
  	this.numPlayers = numPlayers;

  	for (int i = 0; i < numPlayers; i++)
  		players.add(new Player());
  }

  public int getNumPlayers() {
  	return numPlayers;
  }

  public Deck getDeck() {
    return baraja;
  }

  public void shuffleCards () {
  	baraja.shuffleCards();
  }

  public void distributeCards () {
  	int actualPlayer = 0;

  	do {
  		Card[] handAux = baraja.deleteSubList();
      Player jugador = players.get(actualPlayer);
  		jugador.setHand(handAux);
  		actualPlayer += 1;
  	} while (actualPlayer < numPlayers);
  }

  public boolean retirar (int i) {
    boolean retira = false;
    System.out.println("(input) Jugador "+(i+1)+" escriba 0 para retirarse");
    int x = input.nextInt();

    if (x == 0) {
      retira = true;
      Card[] regresan = players.get(i).getHand();
      baraja.insertSubList(regresan);
    }
    return retira;
  }

  public void requestBets () {
    int i = 0;
    boolean nuevoIntento = false;
    int actualBet = 0;
    int anteriorBet = 0;

    do {
      do {
        System.out.println("(input) Ingrese su apuesta Jugador "+(i+1)+":");
        actualBet = input.nextInt();

        if (actualBet < 1) {//apuesta menor a 1
          System.out.println("(error) Jugador "+(i+1)+" La apuesta debe ser mayor a 0");
          nuevoIntento = !retirar(i);
        } else {//apuesta positiva
          if (i > 0) {//a partir del 2do jugador
            anteriorBet = players.get(0).getBet();
            if (anteriorBet != 0) {//si hay apuesta anteriormente
              if (actualBet == anteriorBet) //si coinciden las apuestas
                nuevoIntento = false;
              else { //si no coinciden las apuestas
                System.out.println("(error) Jugador "+(i+1)+" La apuesta ya se estableció en "+anteriorBet);
                nuevoIntento = !retirar(i);
              }
            } else {//si no hay apuesta anteriormente
              nuevoIntento = false;
            }
          }
        }
      } while (nuevoIntento);

      players.get(i).setBet(actualBet); //guarda la apuesta del jugador
      i += 1;

    } while (i < numPlayers);
  }

  public int verifyBets () {
    int bet = 0;
    try {
      bet = players.get(0).getBet();
    } catch (Exception e) {
      System.out.println("(error) No hay Jugadores");
    }
    return bet;
  }

  public void destaparCartas () {
    //Mostrar Cartas de todos los jugadores
    for (int i = 0; i < numPlayers; i++) {
      int apuesta = players.get(i).getBet();
      if(apuesta != 0) {
        System.out.println("Jugador " + (i+1) + ":\n" + players.get(i).printHand());
        System.out.println(players.get(i).decirJugada());
      }
      else
        System.out.println("Jugador " + (i+1) + ": retirado");
    }

    //Decidir Ganador
    compararJugadas();
  }

  public void compararJugadas () {
    ArrayList<Player> ganadoresParciales = new ArrayList<Player>();
    ArrayList<Integer> posParciales = new ArrayList<Integer>();
    int jugadaBase = players.get(0).getValorJugada();
    int valJugada = 0;
    ganadoresParciales.add(players.get(0));
    posParciales.add(0);

    //Decidir Ganador(es)
    for (int i = 1; i < numPlayers; i++) {
      valJugada = players.get(i).getValorJugada();

      if (valJugada == jugadaBase) {
        ganadoresParciales.add(players.get(i));
        posParciales.add(i);
      }
      else if (valJugada > jugadaBase) {
        ganadoresParciales.clear();
        posParciales.clear();
        ganadoresParciales.add(players.get(i));
        posParciales.add(i);
      }
    }

    //Imprimir Ganador(es)
    System.out.println("\nGanador(es):");
    for (int i = 0; i < ganadoresParciales.size(); i++) {
      System.out.println("\tJugador " + (posParciales.get(i)+1));
    }
  }

}
