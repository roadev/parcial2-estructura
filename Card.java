import java.lang.Comparable;

public class Card implements Comparable<Card>{
  
  private String symbol;
  private String strValue;
  private int value;
  
  public Card(String symbol, String strValue, int value) {
  	if ((symbol == null) || (strValue == null) || (value == 0))
  		throw new NullPointerException();
  	this.symbol=symbol;
    this.value=value;
    this.strValue=strValue;
  }

  public String getStrValue() {
    return strValue;
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