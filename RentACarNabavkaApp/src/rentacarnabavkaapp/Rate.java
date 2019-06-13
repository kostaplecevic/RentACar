package rentacarnabavkaapp;

public class Rate {
    private int idRate;
    private int brRate;
    private int brUplatnice;
    private int iznos;
    private String datumPlacanja;
    private int ugovorid;

    public Rate(int brRate, int brUplatnice, int iznos, String datumPlacanja, int ugovorid) {
        this.brRate = brRate;
        this.brUplatnice = brUplatnice;
        this.iznos = iznos;
        this.datumPlacanja = datumPlacanja;
        this.ugovorid = ugovorid;
    }
    
    public Rate(){}

    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }

    public int getBrRate() {
        return brRate;
    }

    public void setBrRate(int brRate) {
        this.brRate = brRate;
    }

    public int getBrUplatnice() {
        return brUplatnice;
    }

    public void setBrUplatnice(int brUplatnice) {
        this.brUplatnice = brUplatnice;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getDatumPlacanja() {
        return datumPlacanja;
    }

    public void setDatumPlacanja(String datumPlacanja) {
        this.datumPlacanja = datumPlacanja;
    }

    public int getUgovorid() {
        return ugovorid;
    }

    public void setUgovorid(int ugovorid) {
        this.ugovorid = ugovorid;
    }
    
    
       
}
