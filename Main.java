import java.util.Scanner;

public class Main {

  Scanner input;
  Game juegoPoker;

  public Main(){
    juegoPoker = new Game();
    input = new Scanner(System.in);
  }

  private void definirJugadores () {
    if (juegoPoker.getNumPlayers()==0) {
      System.out.println("(input) Ingrese la cantidad de Jugadores:");
      int i = input.nextInt();

      if ((i>1) && (i<8)) {
        juegoPoker.setNumPlayers(i);
        System.out.println("(result) Se han definido "+i+" Jugadores:");
      } else {
        System.out.println("(error) La cantidad válida de jugadores es entre 2 y 7");
      }
    } else {
      System.out.println("(alert) Ya se ha definido previamente "+juegoPoker.getNumPlayers()+" Jugadores:");
    }
  }

  private void repartirCartas () {
    if (juegoPoker.getNumPlayers() != 0){
      if (juegoPoker.getDeck().sizeDeck() == 52) {
        juegoPoker.distributeCards();
        System.out.println("(result) Las cartas se han repartido");
      } else {
        System.out.println("(result) Las cartas ya se han repartido previamente");
      }
    }
    else
      System.out.println("(alert) Defina primero la cantidad de jugadores");
  }

  private void realizarApuestas () {
    if (juegoPoker.getNumPlayers()>1){
      if (juegoPoker.verifyBets()==0){
        juegoPoker.requestBets();
        System.out.println("(result) Se han realizado las apuestas");
      } else {
        System.out.println("(alert) Se han realizado las apuestas previamente en "+juegoPoker.verifyBets());
      }
    } else {
      System.out.println("(alert) Realice primero los pasos 1 a 3");
    }
  }

  private void menuJuego (){
    String text = "";
    text += "|              Menú Juego               |\n";
    text += "| Ingrese una opción:                   |\n";
    text += "| 1 Definir Cantidad de Jugadores       |\n";
    text += "| 2 Barajar Cartas                      |\n";
    text += "| 3 Repartir Cartas                     |\n";
    text += "| 4 Realizar Apuestas                   |\n";
    text += "| 5 Destapar Cartas                     |\n";

    System.out.println(text);
    int opc = input.nextInt();

    if (opc == 1) {
      definirJugadores();
    }else if (opc == 2) {
      juegoPoker.shuffleCards();
      System.out.println("(result) Las cartas se han barajado");
    }else if (opc == 3) {
      repartirCartas();
    }else if (opc == 4) {
      realizarApuestas();
    }else if (opc == 5) {
      System.out.println("Prueba:");
      juegoPoker.destaparCartas();
      System.out.println("restan "+juegoPoker.getDeck().sizeDeck()+" cartas");
    }
  }

  public void mostrarMenu(){
    int seguir;
    do {
      menuJuego();
      System.out.println("(exit?) Ingrese 0 para SALIR del juego Poker");
      seguir = input.nextInt();
    }while (seguir!=0);
  }

  public static void main(String[] args) {
    Main xyz = new Main();
    xyz.mostrarMenu();
  }
}
