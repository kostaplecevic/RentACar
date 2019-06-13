package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpravljanjeRadnicima {
    
    static void dodajRadnika(Radnik r) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("INSERT INTO Radnici(ime,prezime,potpisaniUgovori) VALUES(?,?,?)");
        ps.setString(1, r.getIme());
        ps.setString(2, r.getPrezime());
        ps.setInt(3, r.getPotpisaniUgovori());
        ps.execute();
}
    static void izbrisiRadnika(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("DELETE FROM Radnici WHERE idRadnika=?");
        ps.setInt(1, id);
        ps.execute();
    }
    static void izmeniRadnika(Radnik r, int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("UPDATE Radnici SET ime=?,prezime=?,potpisaniUgovori=? WHERE idRadnika=?");
        ps.setString(1, r.getIme());
        ps.setString(2, r.getPrezime());
        ps.setInt(3, r.getPotpisaniUgovori());
        ps.setInt(4, id);
        ps.execute();
    }
    static Radnik nadjiRadnika(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Radnici WHERE idRadnika=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Radnik r1 = new Radnik();
        r1.setIme(rs.getString("ime"));
        r1.setPrezime(rs.getString("prezime"));
        r1.setPotpisaniUgovori(rs.getInt("potpisaniUgovori"));
        return r1;
    }
    static ObservableList <Radnik> izlistajRadnike() throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Radnici");
        ResultSet rs = ps.executeQuery();
        ObservableList <Radnik> lista = FXCollections.observableArrayList();
        while(rs.next()){
            Radnik r1 = new Radnik();
            r1.setIdRadnika(rs.getInt("idRadnika"));
            r1.setIme(rs.getString("ime"));
            r1.setPrezime(rs.getString("prezime"));
            r1.setPotpisaniUgovori(rs.getInt("potpisaniUgovori"));
            lista.add(r1);
        }     
        return lista;
    }
}
