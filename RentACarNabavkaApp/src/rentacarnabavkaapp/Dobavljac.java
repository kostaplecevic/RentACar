package rentacarnabavkaapp;

public class Dobavljac {
    private int idDobavljaca;
    private String imeKompanije;
    private String kontakt;
    private String mesto;

    Dobavljac(String imeKompanije, String kontakt, String mesto) {
        this.imeKompanije = imeKompanije;
        this.kontakt = kontakt;
        this.mesto = mesto;
    }
    
    Dobavljac(){}
    
    public int getIdDobavljaca() {
        return idDobavljaca;
    }

    public void setIdDobavljaca(int idDobavljaca) {
        this.idDobavljaca = idDobavljaca;
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    
    
}
