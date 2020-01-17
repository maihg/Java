import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Oppretter en ny kortstokk
        Deck deck = new Deck();
        ArrayList<Card> cards = deck.getCards();

        // Trekker n tilfeldige tall som vi så skriver ut
        Collection<Card> cardsAssigned = deck.assign2(10);
        cardsAssigned.forEach(System.out::println);
        System.out.println(); // Linjeskift

        // Uttrykk med filter og forEach som skriver ut alle kortene - suit = 'S'
        // Merk: når vi plukker ut deler av kortene fra stokken først, vil ikke denne lista inneholde ALLE kortene av typen spar
        cards.stream().filter(p -> p.getSUIT()=='S').forEach(System.out::println);

        // Uttrykk med med filter og collect som samler alle suit = 'H'
        List<Card> hearts = cards.stream().filter(p -> p.getSUIT() == 'H').collect(Collectors.toList());

        // Uttrykk med map som gir ny liste med kortenes farge
        List<Character> colors = cards.stream().map(Card::getSUIT).collect(Collectors.toList()); // Det de som lagde oppgaven tenkte på
        List<String> colors2 = cards.stream().map(Card::getColor).collect(Collectors.toList()); // Det jeg tenkte de mente

        // Uttrykk med reduce som gir summen av kortverdiene (face)
        int sum = cards.stream().map(Card::getFACE).reduce(Integer::sum).get(); // Er mulig med ...reduce(Integer::sum).get() også

        // Uttrykk med anyMatch som sier om spar dame finnes i lista
        boolean spadeQueen = cards.stream().anyMatch(p-> (p.getSUIT()=='S') && p.getFACE()==12);

        // Uttrykk som sier om lista er en poker-flush, dvs. har fem kort hvor alle har samme kortfarge(type: S, H, D, C)
        Map<Character, Long> color = cards.stream().collect(Collectors.groupingBy(Card::getSUIT, Collectors.counting()));
        boolean flush = color.values().stream().anyMatch(p -> p>=5);

    }
}



