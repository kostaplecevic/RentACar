package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpravljanjeUgovorima {
    
    static void dodajUgovor(Ugovor u) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("INSERT INTO Ugovori(cena,datum,kamata,brRata,dobavljac,automobil,radnik)VALUES(?,?,?,?,?,?,?)");
        ps.setInt(1, u.getCena());
        ps.setString(2, u.getDatum());
        ps.setInt(3, u.getKamata());
        ps.setInt(4, u.getBrRata());
        ps.setInt(5, u.getIdDobavljaca());
        ps.setInt(6, u.getIdAutomobila());
        ps.setInt(7, u.getIdRadnika());
        ps.execute();
}
    static void izbrisiUgovor(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("DELETE FROM Ugovori WHERE brUgovora=?");
        ps.setInt(1, id);
        ps.execute();
    }
    static void izmeniUgovor(Ugovor u, int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("UPDATE Ugovori SET cena=?,datum=?,kamata=?,brRata=?,dobavljac=?,automobil=?,radnik=? WHERE brUgovora=?");
        ps.setInt(1, u.getCena());
        ps.setString(2, u.getDatum());
        ps.setInt(3, u.getKamata());
        ps.setInt(4, u.getBrRata());
        ps.setInt(5, u.getIdDobavljaca());
        ps.setInt(6, u.getIdAutomobila());
        ps.setInt(7, u.getIdRadnika());
        ps.setInt(8, id);
        ps.execute();
    }
    static Ugovor nadjiUgovor(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Ugovori WHERE brUgovora=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Ugovor u1 = new Ugovor();
        u1.setCena(rs.getInt("cena"));
        u1.setDatum(rs.getString("datum"));
        u1.setKamata(rs.getInt("kamata"));
        u1.setBrRata(rs.getInt("brRata"));
        u1.setIdDobavljaca(rs.getInt("dobavljac"));
        u1.setIdAutomobila(rs.getInt("automobil"));
        u1.setIdRadnika(rs.getInt("radnik"));
        return u1;
    }
    static ObservableList <Ugovor> izlistajUgovore() throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Ugovori");
        ResultSet rs = ps.executeQuery();
        ObservableList <Ugovor> lista = FXCollections.observableArrayList();
        while(rs.next()){
            Ugovor u1 = new Ugovor();
            u1.setBrUgovora(rs.getInt("brUgovora"));
            u1.setCena(rs.getInt("cena"));
            u1.setDatum(rs.getString("datum"));
            u1.setKamata(rs.getInt("kamata"));
            u1.setBrRata(rs.getInt("brRata"));
            u1.setIdDobavljaca(rs.getInt("dobavljac"));
            u1.setIdAutomobila(rs.getInt("automobil"));
            u1.setIdRadnika(rs.getInt("radnik"));
            lista.add(u1);
            
        }
        return lista;
    }
}
