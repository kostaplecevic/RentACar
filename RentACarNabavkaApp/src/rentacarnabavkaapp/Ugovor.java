package rentacarnabavkaapp;

public class Ugovor {
    private int brUgovora;
    private int cena;
    private String datum;
    private int kamata;
    private int brRata;
    private int idDobavljaca;
    private int idAutomobila;
    private int idRadnika;

    public Ugovor(int cena, String datum, int kamata, int brRata, int idDobavljaca, int idAutomobila, int idRadnika) {
        this.cena = cena;
        this.datum = datum;
        this.kamata = kamata;
        this.brRata = brRata;
        this.idDobavljaca = idDobavljaca;
        this.idAutomobila = idAutomobila;
        this.idRadnika = idRadnika;
    }
    
    public Ugovor(){}
    
    public int getBrUgovora() {
        return brUgovora;
    }

    public void setBrUgovora(int brUgovora) {
        this.brUgovora = brUgovora;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getIdDobavljaca() {
        return idDobavljaca;
    }

    public void setIdDobavljaca(int idDobavljaca) {
        this.idDobavljaca = idDobavljaca;
    }

    public int getIdAutomobila() {
        return idAutomobila;
    }

    public void setIdAutomobila(int idAutomobila) {
        this.idAutomobila = idAutomobila;
    }

    public int getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(int idRadnika) {
        this.idRadnika = idRadnika;
    }

    public int getKamata() {
        return kamata;
    }

    public void setKamata(int kamata) {
        this.kamata = kamata;
    }

    public int getBrRata() {
        return brRata;
    }

    public void setBrRata(int brRata) {
        this.brRata = brRata;
    }
    
}
