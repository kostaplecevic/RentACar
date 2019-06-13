package rentacarnabavkaapp;

public class Automobil {
    private int idAutomobila;
    private String marka;
    private String tipVozila;
    private String tipPotrosnje;
    
    Automobil(String marka,String tipVozila,String tipPotrosnje){
        this.marka = marka;
        this.tipPotrosnje = tipPotrosnje;
        this.tipVozila = tipVozila;
    }
    Automobil(){}
    
    public int getIdAutomobila() {
        return idAutomobila;
    }

    public void setIdAutomobila(int idAutomobila) {
        this.idAutomobila = idAutomobila;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public String getTipPotrosnje() {
        return tipPotrosnje;
    }

    public void setTipPotrosnje(String tipPotrosnje) {
        this.tipPotrosnje = tipPotrosnje;
    }
    
    
}
