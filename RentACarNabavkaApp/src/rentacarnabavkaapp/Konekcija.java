package rentacarnabavkaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Konekcija {
    
    private static Connection conn = null;
    Konekcija(){}
    public static Connection vratiKonekciju() throws SQLException{
    if(conn==null){
    String konekcija = "jdbc:sqlite:C:\\Users\\Korisnik\\Desktop\\Projektni iz Baza\\sqlite\\baza.db";
    conn = (Connection) DriverManager.getConnection(konekcija);
    }
    return conn;
    }
    
       
}
