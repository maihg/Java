import java.util.Objects;

public class Eiendom {
    /**
     * Attributtene til klassen Eiendom.
     */
    private int knr;
    private String knavn;
    private int gnr;
    private int bnr;
    private String navn;
    private double areal;
    private String eier;

    /**
     * Konstruktør som tar inn følgene parametre:
     * @param knr kommunenummer
     * @param knavn kommunenavn
     * @param gnr gårdsnummer
     * @param bnr bruksnummer
     * @param navn navn på tomt
     * @param areal areal på tomt i kvadratmeter
     * @param eier eier av tomt
     */
    public Eiendom(int knr, String knavn, int gnr, int bnr, String navn, double areal, String eier) {
        this.knr = knr;
        this.knavn = knavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.navn = navn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Lager er string med ID-en til eiendommen
     * @param knr
     * @param gnr
     * @param bnr
     * @return
     */
    public String tomteID(int knr, int gnr, int bnr){
        String ID = "";
        ID += knr + "-" + gnr + "/" + bnr;
        return ID;
    }

    // Get-metoder
    public int getGnr() {
        return gnr;
    }
    public int getKnr() {
        return knr;
    }
    public int getBnr() {
        return bnr;
    }
    public double getAreal() {
        return areal;
    }

    // Set-metoder
    // Når to kommuner slåes sammen f.eks trenger vi å endre kommunenummeret
    public void setKnr(int knr) {
        this.knr = knr;
    }
    // Kommunen kan plutselig endre navn
    public void setKnavn(String knavn) {
        this.knavn = knavn;
    }
    // Nye eiere kan gi tomten et nytt bruksnavn f.eks, eller kommunen kan gjøre om Helsestasjon til Ungdomshus
    public void setNavn(String navn) {
        this.navn = navn;
    }
    // Eiendommer blir solgt stadig vekk og vi må endre eier
    public void setEier(String eier) {
        this.eier = eier;
    }

    // toString
    @Override
    public String toString() {
        return "Eiendom{" + tomteID(knr, gnr, bnr) +
                ", kommune = '" + knavn + '\'' +
                ", navn på eiendom = '" + navn + '\'' +
                ", areal på tomt = " + areal +
                ", eier = '" + eier + '\'' +
                '}';
    }

    // legg til equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eiendom)) return false;
        Eiendom eiendom = (Eiendom) o;
        return knr == eiendom.knr &&
                gnr == eiendom.gnr &&
                bnr == eiendom.bnr;
    }

}
