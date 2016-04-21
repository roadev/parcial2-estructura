import java.lang.Comparable;

public class Card implements Comparable<Card>{
  
  private String symbol;
  private int value;
  
  public Card(String symbol, int value) {
  	if ((symbol == null) || (value == 0))
  		throw new NullPointerException();
  	this.symbol=symbol;
  	this.value=value;
  }

  public String getSymbol() {
  	return symbol;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int i) {
    value=i;
  }

  public int compareTo(Card c){
  	int resultado=0;

  	if (this.value < c.value) {
  		resultado = -1;
  	} else if (this.value > c.value) {
  		resultado = 1;
  	} else {
  		resultado = 0;
  	}

  	return resultado;
  }
}