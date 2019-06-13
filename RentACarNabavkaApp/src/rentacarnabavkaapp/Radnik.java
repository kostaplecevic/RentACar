package rentacarnabavkaapp;

public class Radnik {
    private int idRadnika;
    private String ime;
    private String prezime;
    private int potpisaniUgovori;

    public Radnik(String ime, String prezime, int potpisaniUgovori) {
        this.idRadnika = idRadnika;
        this.ime = ime;
        this.prezime = prezime;
        this.potpisaniUgovori = potpisaniUgovori;
    }
    
    public Radnik(){}

    public int getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(int idRadnika) {
        this.idRadnika = idRadnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getPotpisaniUgovori() {
        return potpisaniUgovori;
    }

    public void setPotpisaniUgovori(int potpisaniUgovori) {
        this.potpisaniUgovori = potpisaniUgovori;
    }
    
    
}
