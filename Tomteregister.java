import java.util.ArrayList;
import java.util.Scanner;

public class Tomteregister {
    /**
     * Oppretter en ArrayList for å holde styr på eiendommene. ArrayList fordi det da er enkelt å legge til eiendommer.
     */
    private ArrayList<Eiendom> tomter;

    /**
     * Konstruktør for klassen.
     */
    public Tomteregister() {
        this.tomter = new ArrayList<Eiendom>();
    }

    /**
     * Registrere/legge til en eiendom. De ulike parametrene som skal inn i Eiendom-objektet leses inn fra bruker.
     * @return
     */
    public boolean registrerEiendom(){
        Scanner in = new Scanner(System.in);
        Scanner textIn = new Scanner(System.in);
        boolean ok = false;
        int knr = 0, gnr = 0, bnr = 0;
        double areal = 0;
        String knavn = "", navn = "", eier = "";
        while(!ok){
            System.out.println("Skriv inn kommunenr: ");
            knr = in.nextInt();
            System.out.println("Skriv inn kommunenavn: ");
            knavn = textIn.nextLine();
            System.out.println("Skriv inn gårdsnummer: ");
            gnr = in.nextInt();
            System.out.println("Skriv inn bruksnummer: ");
            bnr = in.nextInt();
            System.out.println("Skriv inn navn på tomt (space hvis eiendommen ikke har et navn): ");
            navn = textIn.nextLine();
            System.out.println("Skriv inn areal på tomten: ");
            areal = in.nextDouble();
            System.out.println("Skriv inn navn på eier: ");
            eier = textIn.nextLine();

            // Sjekke om input er ok
            if(knr>= 101 && knr<=5054 && knavn.length()>0 && gnr>0 && bnr>0 && areal>0 && eier.length()>0){
                ok = true;
            }
        }
        // Sjekker om eiendommen er registrert fra før av
        if(sokEtterEiendom(knr, gnr, bnr) != null && tomter.size()>0){
            System.out.println("Eiendommen er registrert fra før og det ble derfor ikke registrert noe nå.");
            return false;
        }else{
            Eiendom e = new Eiendom(knr, knavn, gnr, bnr, navn, areal, eier);
            tomter.add(e); // Legger til eiendommen i tomter-lista
            System.out.println("Eiendommen er nå registrert.");
            return true;
        }
    }

    /**
     * Metode for å slette en eiendom fra tomter-lista.
     * @param knr
     * @param gnr
     * @param bnr
     * @return
     */
    public boolean sletteEiendom(int knr, int gnr, int bnr){
        for (Eiendom e: tomter) {
            if(e.getKnr() == knr && e.getGnr() == gnr && e.getBnr() == bnr){
                tomter.remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * Metode for å finne antall eiendommer registrert.
     * @return
     */
    public int antallEiendommer(){
        return tomter.size();
    }

    /**
     * Metode som skriver ut alle eiendommene som er registrert.
     */
    public void alleEiendommer(){
        String eiendommer = "";
        if(tomter.size() == 0){
            eiendommer += "Ingen eiendommer er registrert ennå.";
        }
        for (Eiendom e: tomter) {
            eiendommer += e.toString() + "\n";
        }
        System.out.println(eiendommer);
    }

    /**
     * Metode for å søke etter en eiendom. Returnerer null hvis ingen eiendom blir funnet, ellers returnerer den eiendommen.
     * @param knr
     * @param gnr
     * @param bnr
     * @return
     */
    public Eiendom sokEtterEiendom(int knr, int gnr, int bnr){
        if(tomter.size() == 0){
            return null;
        }
        for (Eiendom e: tomter) {
            if(e.getKnr() == knr && e.getGnr() == gnr && e.getBnr() == bnr){
                return e;
            }
        }
        return null;
    }

    /**
     * Metode for å finne gjennomsnittsarealet til alle tomtene som er registrert (totalt)
     * @return
     */
    public double gjsnittArealTot(){
        if(tomter.size() == 0){
            return 0;
        }
        double gjsnitt = 0;
        for (Eiendom e: tomter) {
            gjsnitt += e.getAreal(); // Summerer alle arealene
        }
        return gjsnitt/tomter.size(); // Deler på størrelsen til tomter-lista for å få gjennomsnittet
    }

    /**
     * Metode for å finne alle eiendommer med gitt gårdsnummer.
     * @param gnr
     */
    public ArrayList<Eiendom> finnEiendomGnr(int gnr){
        boolean funnet = false;
        ArrayList<Eiendom> eiendommer = new ArrayList<Eiendom>();
        for (Eiendom e: tomter) {
            if(e.getGnr() == gnr){
                eiendommer.add(e);
                funnet = true;
            }
        }
        if(!funnet){
            return null; //
        }
        return eiendommer;
    }



}
