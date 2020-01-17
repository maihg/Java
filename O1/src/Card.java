/* Klasse som ble oppgitt sammen med oppgaveteksten
   Unntak: getColor() som ble lagd som en hjelpemetode
 */
public class Card {
    private final char SUIT;
    private final int FACE;

    // Initalizes with SUIT ('S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs) and FACE (1=ace, 2, ... , 10, 11=knight, 12=queen, 13=king)
    public Card(char suit, int face) {
        this.SUIT = suit;
        this.FACE = face;
    }

    // Returnerer fargen på kortet (svart/rød)
    public String getColor(){
        if(this.SUIT == 'S' || this.SUIT == 'C') {
            return "Svart";
        }else{
              return "Rød";
        }
    }

    // Get-methods
    public char getSUIT() {
        return SUIT;
    }

    public int getFACE() {
        return FACE;
    }

    @Override
    public String toString() {
        return String.format("%s%s", SUIT, FACE);
    }
}

