import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private Random generator = new Random();

    // Konstruktør - initierer cards og fyller lista med alle kortene
    public Deck(){
        cards = new ArrayList<>();
        createDeck();
    }

    private void createDeck(){
        String suit = "SHDC";
        for(int i = 0; i < suit.length(); i++){
            for(int j = 1; j <= 13; j++){
                cards.add(new Card(suit.charAt(i), j));
            }
        }

    }

    // Plukker tilfeldig n kort fra stokken og returner disse i en Collection. OBS - kortet forsvinner ikke fra stokken
    public Collection<Card> assign(int n){
        // Sjekker at n er et gyldig tall
        if(n <= 0 || n > 52){
            throw new IllegalArgumentException("n må være et tall [1, 52]");
        }
        Collection<Card> someCards = new ArrayList<>(); // Håper det var dette de mente med returne i en Collectioon
        ArrayList<Integer> cardsDrawn = new ArrayList<>();
        boolean ok = false;
        int randomNo = 0;
        for(int i = 0; i < n; i++){
            do { // Denne skal gå til den finner et randomNo som ikke har blitt valgt før
                ok = false;
                randomNo = generator.nextInt(52); // Velge én av 52 kort
                if(cardsDrawn.indexOf(randomNo) < 0){
                    cardsDrawn.add(randomNo);
                    ok = true;
                }
            }while (!ok);
            someCards.add(cards.get(randomNo));
        }
        return someCards;
    }

    // Tilsvarende metode som assign, trekker n tilfeldige kort fra stokken, men denne metoden fjerner kortet fra stokken når det blir trukket
    public Collection<Card> assign2(int n){
        // Sjekker at n er et gyldig tall
        if(n <= 0 || n > cards.size()){ // n > cards.size() fordi bunken inneholder færre kort dersom man allerede har brukt metoden en gang før
            throw new IllegalArgumentException("n må være et tall [1, antall kort i stokken]");
        }

        // Generer et random tall, ta det kortet ut av decket og legg i samlinga
        int randomNo2 = 0;
        Collection<Card> assignedCards = new ArrayList<>();
        for(int i = 0; i < n; i++){
            randomNo2 = generator.nextInt(cards.size()); // cards.size()=52 når decken er urørt
            assignedCards.add(cards.get(randomNo2));
            cards.remove(randomNo2);
        }
        return assignedCards;
    }

    // Get-metode for å hente ut kortstokken
    public ArrayList<Card> getCards() {
        return cards;
    }
}
