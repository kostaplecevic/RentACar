/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarnabavkaapp;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class UgovoriFXMLController implements Initializable {

    @FXML
    private TextField kamata;
    @FXML
    private TextField brUgovora;
    @FXML
    private TextField datum;
    @FXML
    private TextField cena;
    @FXML
    private TextField brRata;
    @FXML
    private TextField automobil;
    @FXML
    private TextField dobavljac;
    @FXML
    private TextField radnik;
    @FXML
    private TableView izlistaniUgovori;
    @FXML
    private TableColumn BU;
    @FXML
    private TableColumn CE;
    @FXML
    private TableColumn DA;
    @FXML
    private TableColumn KA;
    @FXML
    private TableColumn BR;
    @FXML
    private TableColumn DO;
    @FXML
    private TableColumn AU;
    @FXML
    private TableColumn RA;
    
    @FXML
    private void dodajUgovor(ActionEvent event) throws SQLException {
        
        int cena1 = Integer.parseInt(cena.getText());
        String datum1 = datum.getText();
        int kamata1 = Integer.parseInt(kamata.getText());
        int brRata1 = Integer.parseInt(brRata.getText());
        int dobavljac1 = Integer.parseInt(dobavljac.getText());
        int automobil1 = Integer.parseInt(automobil.getText());
        int radnik1 = Integer.parseInt(radnik.getText());
        Ugovor u1 = new Ugovor(cena1,datum1,kamata1,brRata1,dobavljac1,automobil1,radnik1);
        UpravljanjeUgovorima.dodajUgovor(u1);
    }
    @FXML
    private void izbrisiUgovor(ActionEvent event) throws SQLException {
        int brUgovora1 = Integer.parseInt(brUgovora.getText());
        UpravljanjeUgovorima.izbrisiUgovor(brUgovora1);
    }
    @FXML
    private void izmeniUgovor(ActionEvent event) throws SQLException {
        int brUgovora1 = Integer.parseInt(brUgovora.getText());
        int cena1 = Integer.parseInt(cena.getText());
        String datum1 = datum.getText();
        int kamata1 = Integer.parseInt(kamata.getText());
        int brRata1 = Integer.parseInt(brRata.getText());
        int dobavljac1 = Integer.parseInt(dobavljac.getText());
        int autombil1 = Integer.parseInt(automobil.getText());
        int radnik1 = Integer.parseInt(radnik.getText());
        Ugovor u1 = new Ugovor(cena1,datum1,kamata1,brRata1,dobavljac1,autombil1,radnik1);
        UpravljanjeUgovorima.izmeniUgovor(u1,brUgovora1);
    }

    @FXML
    private void nadjiUgovor(ActionEvent event) throws SQLException {
        int brUgovora1 = Integer.parseInt(brUgovora.getText());
        Ugovor u1 = UpravljanjeUgovorima.nadjiUgovor(brUgovora1);
        cena.setText(String.valueOf(u1.getCena()));
        datum.setText(u1.getDatum());
        kamata.setText(String.valueOf(u1.getKamata()));
        brRata.setText(String.valueOf(u1.getBrRata()));
        dobavljac.setText(String.valueOf(u1.getIdDobavljaca()));
        automobil.setText(String.valueOf(u1.getIdAutomobila()));
        radnik.setText(String.valueOf(u1.getIdAutomobila()));
    }
    private void izlistajUgovore() throws SQLException {
        ObservableList <Ugovor> lista = UpravljanjeUgovorima.izlistajUgovore();
        ObservableList <TableColumn> kolone = izlistaniUgovori.getColumns();
        kolone.get(0).setCellValueFactory(new PropertyValueFactory("brUgovora"));
        kolone.get(1).setCellValueFactory(new PropertyValueFactory("cena"));
        kolone.get(2).setCellValueFactory(new PropertyValueFactory("datum"));
        kolone.get(3).setCellValueFactory(new PropertyValueFactory("kamata"));
        kolone.get(4).setCellValueFactory(new PropertyValueFactory("brRata"));
        kolone.get(5).setCellValueFactory(new PropertyValueFactory("idDobavljaca"));
        kolone.get(6).setCellValueFactory(new PropertyValueFactory("idAutomobila"));
        kolone.get(7).setCellValueFactory(new PropertyValueFactory("idRadnika"));
        izlistaniUgovori.setItems(lista);
    }
    @FXML
    private void starterRata(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RateFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            izlistajUgovore();
        } catch (SQLException ex) {
            Logger.getLogger(UgovoriFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
