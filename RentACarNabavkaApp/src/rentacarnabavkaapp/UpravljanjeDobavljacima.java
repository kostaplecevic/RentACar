package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpravljanjeDobavljacima {
    
    
    
    static void dodajDobavljaca(Dobavljac d) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("INSERT INTO Dobavljaci(imeKompanije,kontakt,mesto) VALUES(?,?,?)");
        ps.setString(1, d.getImeKompanije());
        ps.setString(2, d.getKontakt());
        ps.setString(3, d.getMesto());
        ps.execute();
}
    static void izbrisiDobavljaca(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("DELETE FROM Dobavljaci WHERE idDobavljaca=?");
        ps.setInt(1, id);
        ps.execute();
    }
    static void izmeniDobavljaca(Dobavljac d, int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("UPDATE Dobavljaci SET imeKompanije=?,kontakt=?,mesto=? WHERE idDobavljaca=?");
        ps.setString(1, d.getImeKompanije());
        ps.setString(2, d.getKontakt());
        ps.setString(3, d.getMesto());
        ps.setInt(4, id);
        ps.execute();
    }
    static Dobavljac nadjiDobavljaca(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Dobavljaci WHERE idDobavljaca=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Dobavljac d1 = new Dobavljac();
        d1.setImeKompanije(rs.getString("imeKompanije"));
        d1.setKontakt(rs.getString("kontakt"));
        d1.setMesto(rs.getString("mesto"));
        return d1;
    }
    static ObservableList <Dobavljac> izlistajDobavljace() throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Dobavljaci");
        ResultSet rs = ps.executeQuery();
        ObservableList <Dobavljac> lista = FXCollections.observableArrayList();
        while(rs.next()){
            Dobavljac d1 = new Dobavljac();
            d1.setIdDobavljaca(rs.getInt("idDobavljaca"));
            d1.setImeKompanije(rs.getString("imeKompanije"));
            d1.setKontakt(rs.getString("kontakt"));
            d1.setMesto(rs.getString("mesto"));
            lista.add(d1);
        }     
        return lista;
    }
}
