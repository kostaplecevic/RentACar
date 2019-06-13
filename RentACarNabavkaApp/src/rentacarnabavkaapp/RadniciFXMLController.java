/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarnabavkaapp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class RadniciFXMLController implements Initializable {

    @FXML
    private TextField potpisaniUgovori;
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField idRadnika;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn MA;
    @FXML
    private TableColumn TV;
    @FXML
    private TableColumn TP;
    @FXML
    private TableView izlistaniRadnici;
    
    @FXML
    private void dodajRadnika(ActionEvent event) throws SQLException {
        String ime1 = ime.getText();
        String prezime1 = prezime.getText();
        int potpisaniUgovori1 = Integer.parseInt(potpisaniUgovori.getText());
        Radnik r1 = new Radnik(ime1,prezime1,potpisaniUgovori1);
        UpravljanjeRadnicima.dodajRadnika(r1);
    }

    @FXML
    private void izbrisiRadnika(ActionEvent event) throws SQLException {
        int idRadnika1 = Integer.parseInt(idRadnika.getText());
        UpravljanjeRadnicima.izbrisiRadnika(idRadnika1);
    }

    @FXML
    private void izmeniRadnika(ActionEvent event) throws SQLException {
        String ime1 = ime.getText();
        String prezime1 = prezime.getText();
        int potpisaniUgovori1 = Integer.parseInt(potpisaniUgovori.getText());
        int idRadnika1 = Integer.parseInt(idRadnika.getText());
        Radnik r1 = new Radnik(ime1,prezime1,potpisaniUgovori1);
        UpravljanjeRadnicima.izmeniRadnika(r1,idRadnika1);
    }

    @FXML
    private void nadjiRadnika(ActionEvent event) throws SQLException {
        int idRadnika1 = Integer.parseInt(idRadnika.getText());
        Radnik r1 = UpravljanjeRadnicima.nadjiRadnika(idRadnika1);
        ime.setText(r1.getIme());
        prezime.setText(r1.getPrezime());
        String potpisaniUgovori1 = String.valueOf(r1.getPotpisaniUgovori());
        potpisaniUgovori.setText(potpisaniUgovori1);
    }
    @FXML
    private void izlistajRadnike() throws SQLException {
        ObservableList <Radnik> lista = UpravljanjeRadnicima.izlistajRadnike();
        ObservableList <TableColumn> kolone = izlistaniRadnici.getColumns();
        kolone.get(0).setCellValueFactory(new PropertyValueFactory("idRadnika"));
        kolone.get(1).setCellValueFactory(new PropertyValueFactory("ime"));
        kolone.get(2).setCellValueFactory(new PropertyValueFactory("prezime"));
        kolone.get(3).setCellValueFactory(new PropertyValueFactory("potpisaniUgovori"));
        izlistaniRadnici.setItems(lista);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            izlistajRadnike();
        } catch (SQLException ex) {
            Logger.getLogger(DobavljacFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    
}
