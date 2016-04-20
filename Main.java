import java.util.Scanner;

public class Main {

  Scanner input = new Scanner(System.in);
  Game juegoPoker;

  public Main(){
    juegoPoker = new Game();
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
      System.out.println("(input) Ingrese la cantidad de Jugadores:");
      int i = input.nextInt();
      if ((i>1) && (i<8)) {
        juegoPoker.setNumPlayers(i);
        System.out.println("(result) Se han definido "+i+" Jugadores:");
      } else {
        System.out.println("(alert) La cantidad válida de jugadores es entre 2 y 7");
      }
    }else if (opc == 2) {
      juegoPoker.shuffleCards();
      System.out.println("(result) Las cartas se han barajado");
    }else if (opc == 3) {
      if (juegoPoker.getNumPlayers() != 0)
        System.out.println("n.n");
      else
        System.out.println("(alert) Defina primero la cantidad de jugadores");
    }else if (opc == 4) {
      System.out.println("Seleccionó "+opc);
    }else if (opc == 5) {
      System.out.println("Seleccionó "+opc);
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
