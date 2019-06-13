package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpravljanjeRatama {
    
    static void dodajRatu(Rate r) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("INSERT INTO Rate(brRate,brUplatnice,iznos,datumPlacanja,ugovorid) VALUES(?,?,?,?,?)");
        ps.setInt(1, r.getBrRate());
        ps.setInt(2, r.getBrUplatnice());
        ps.setDouble(3, r.getIznos());
        ps.setString(4, r.getDatumPlacanja());
        ps.setInt(5, r.getUgovorid());
        ps.execute();
}
    static void izbrisiRatu(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("DELETE FROM Rate WHERE idRate=?");
        ps.setInt(1, id);
        ps.execute();
    }
    static void izmeniRate(Rate r, int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("UPDATE Rate SET brRate=?,brUplatnice=?,iznos=?,datumPlacanja=?,ugovorid=? WHERE idRate=?");
        ps.setInt(1, r.getBrRate());
        ps.setInt(2, r.getBrUplatnice());
        ps.setInt(3, r.getIznos());
        ps.setString(4, r.getDatumPlacanja());
        ps.setInt(5, r.getUgovorid());
        ps.setInt(6, id);
        ps.execute();
    }
//    static Rate nadjiRatu(int id) throws SQLException{
//        Connection kon = Konekcija.vratiKonekciju();
//        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Rate WHERE idRate=?");
//        ps.setInt(1, id);
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        Rate r1 = new Rate();
//        r1.setBrRate(rs.getInt("brRate"));
//        r1.setBrUplatnice(rs.getInt("brUplatnice"));
//        r1.setIznos(rs.getInt("iznos"));
//        r1.setDatumPlacanja(rs.getString("datumPlacanja"));
//        r1.setUgovorid(id);
//        return r1;
//    }
    static ObservableList <Rate> izlistajRate(int id) throws SQLException{
        Connection kon = Konekcija.vratiKonekciju();
        PreparedStatement ps = kon.prepareStatement("SELECT * FROM Rate WHERE ugovorid=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ObservableList <Rate> lista = FXCollections.observableArrayList();
        while(rs.next()){
            Rate r1 = new Rate();
            r1.setIdRate(rs.getInt("idRate"));
            r1.setBrRate(rs.getInt("brRate"));
            r1.setBrUplatnice(rs.getInt("brUplatnice"));
            r1.setIznos(rs.getInt("iznos"));
            r1.setDatumPlacanja(rs.getString("datumPlacanja"));
            r1.setUgovorid(id);
            lista.add(r1);  
        }
        return lista;
    }
}
