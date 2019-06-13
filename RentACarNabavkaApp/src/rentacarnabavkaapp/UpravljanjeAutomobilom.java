package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpravljanjeAutomobilom {
    
    
    
    static void dodajAutomobil(Automobil a) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("INSERT INTO Automobili(marka,tipVozila,tipPotrosnje) VALUES(?,?,?)");
        ps.setString(1, a.getMarka());
        ps.setString(2, a.getTipVozila());
        ps.setString(3, a.getTipPotrosnje());
        ps.execute();
}
    static void izbrisiAutomobil(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("DELETE FROM Automobili WHERE idAutomobila=?");
        ps.setInt(1, id);
        ps.execute();
    }
    static void izmeniAutomobil(Automobil a, int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("UPDATE Automobili SET marka=?,tipVozila=?,tipPotrosnje=? WHERE idAutomobila=?");
        ps.setString(1, a.getMarka());
        ps.setString(2, a.getTipVozila());
        ps.setString(3, a.getTipPotrosnje());
        ps.setInt(4, id);
        ps.execute();
    }
    static Automobil nadjiAutomobil(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Automobili WHERE idAutomobila=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Automobil a1 = new Automobil();
        a1.setMarka(rs.getString("marka"));
        a1.setTipPotrosnje(rs.getString("tipPotrosnje"));
        a1.setTipVozila(rs.getString("tipVozila"));
        return a1;
    }
    static ObservableList <Automobil> izlistajAutomobile() throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Automobili");
        ResultSet rs = ps.executeQuery();
        ObservableList <Automobil> lista = FXCollections.observableArrayList();
        while(rs.next()){
            Automobil a1 = new Automobil();
            a1.setIdAutomobila(rs.getInt("idAutomobila"));
            a1.setMarka(rs.getString("marka"));
            a1.setTipPotrosnje(rs.getString("tipPotrosnje"));
            a1.setTipVozila(rs.getString("tipVozila"));
            lista.add(a1);
        }     
        return lista;
    }
}
