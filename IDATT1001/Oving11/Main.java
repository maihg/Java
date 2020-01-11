import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Metode for å skrive ut en meny.
     * @return returnere et nummer mellom 0 og 6 valgt av bruker, hvor 0 er alle ukjente valg
     */
    public int visMeny(){
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("MENY");
        System.out.println("1. Registrer en eiendom");
        System.out.println("2. Finn alle eiendommer som er registrert");
        System.out.println("3. Søk etter eiendom");
        System.out.println("4. Finn gjennomsnittsarealet til eiendommene");
        System.out.println("5. Finn eiendommer med gitt gårdsnummer");
        System.out.println("6. Slett en eiendom");
        System.out.println("7. Finn antall registrerte eiendommer");
        System.out.println("8. Avslutt");
        System.out.println("Skriv inn et tall mellom 1 og 6: ");

        if(in.hasNextInt()){
            int valg = in.nextInt();
            if(valg>=1 && valg<=6){
                return valg;
            }
        }
        return 0;
    }

    /**
     * Klientprogram hvor det printes ut en meny og handling utføres etter valgt handling fra menyen.
     * Menyen ligger i en while-løkke som går så lenge brukeren ikke velger å avslutte.
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main();
        Tomteregister t = new Tomteregister();
        Scanner in = new Scanner(System.in);

        boolean nyRunde = true;
        while(nyRunde){
            int valg = m.visMeny();
            switch (valg){
                case 1:
                    t.registrerEiendom();
                    break;
                case 2:
                    t.alleEiendommer();
                    break;
                case 3:
                    System.out.println("Skriv inn kommunenummer: ");
                    int knr = in.nextInt();
                    System.out.println("Skriv inn gårdsnummer: ");
                    int gnr = in.nextInt();
                    System.out.println("Skriv inn bruksnummer: ");
                    int bnr = in.nextInt();
                    Eiendom e = t.sokEtterEiendom(knr, gnr, bnr);
                    if(e == null){
                        System.out.println("Fant ingen eiendom");
                    }else {
                        System.out.println(e.toString());
                    }
                    break;
                case 4:
                    System.out.printf("Gjennomsnittsarealet er: %.2f\n", t.gjsnittArealTot());
                    break;
                case 5:
                    System.out.println("Skriv inn gårdsnummer: ");
                    gnr = in.nextInt();
                    ArrayList<Eiendom> eiendommer = t.finnEiendomGnr(gnr);
                    if(eiendommer.size() == 0){
                        System.out.println("Fant ingen eiendommer med det gårdsnummeret.");
                    }else {
                        for (Eiendom tomt : eiendommer) {
                            System.out.println(tomt.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Skriv inn kommunenummer: ");
                    knr = in.nextInt();
                    System.out.println("Skriv inn gårdsnummer: ");
                    gnr = in.nextInt();
                    System.out.println("Skriv inn bruksnummer: ");
                    bnr = in.nextInt();
                    t.sletteEiendom(knr, gnr, bnr);
                    break;
                case 7:
                    System.out.println(t.antallEiendommer());
                case 8:
                    nyRunde = false;
                    break;
                default:
                    System.out.println("Ukjent handling");
            }
        }
    }
}
