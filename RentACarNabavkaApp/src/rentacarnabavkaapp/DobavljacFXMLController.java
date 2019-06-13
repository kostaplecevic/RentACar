package rentacarnabavkaapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class DobavljacFXMLController implements Initializable {

    @FXML
    private TextField mesto;
    @FXML
    private TextField imeKompanije;
    @FXML
    private TextField kontakt;
    @FXML
    private TextField idDobavljaca;
    @FXML
    private TableView izlistaniDobavljaci;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn IK;
    @FXML
    private TableColumn KO;
    @FXML
    private TableColumn ME;
    
    @FXML
    private void dodajDobavljaca(ActionEvent event) throws SQLException {
        String imeKompanije1 = imeKompanije.getText();
        String kontakt1 = kontakt.getText();
        String mesto1 = mesto.getText();
        Dobavljac d1 = new Dobavljac(imeKompanije1,kontakt1,mesto1);
        UpravljanjeDobavljacima.dodajDobavljaca(d1);
    }

    @FXML
    private void izbrisiDobavljaca(ActionEvent event) throws SQLException {
        int idDobavljaca1 = Integer.parseInt(idDobavljaca.getText());
        UpravljanjeDobavljacima.izbrisiDobavljaca(idDobavljaca1);
    }

    @FXML
    private void izmeniDobavljaca(ActionEvent event) throws SQLException {
        String imeKompanije1 = imeKompanije.getText();
        String kontakt1 = kontakt.getText();
        String mesto1 = mesto.getText();
        int idDobavljaca1 = Integer.parseInt(idDobavljaca.getText());
        Dobavljac d1 = new Dobavljac(imeKompanije1,kontakt1,mesto1);
        UpravljanjeDobavljacima.izmeniDobavljaca(d1,idDobavljaca1);
    }

    @FXML
    private void nadjiDobavljaca(ActionEvent event) throws SQLException {
        int idDobavljaca1 = Integer.parseInt(idDobavljaca.getText());
        Dobavljac d1 = UpravljanjeDobavljacima.nadjiDobavljaca(idDobavljaca1);
        imeKompanije.setText(d1.getImeKompanije());
        kontakt.setText(d1.getKontakt());
        mesto.setText(d1.getMesto());
    }

    @FXML
    private void izlistajDobavljace() throws SQLException {
        ObservableList <Dobavljac> lista = UpravljanjeDobavljacima.izlistajDobavljace();
        ObservableList <TableColumn> kolone = izlistaniDobavljaci.getColumns();
        kolone.get(0).setCellValueFactory(new PropertyValueFactory("idDobavljaca"));
        kolone.get(1).setCellValueFactory(new PropertyValueFactory("imeKompanije"));
        kolone.get(2).setCellValueFactory(new PropertyValueFactory("kontakt"));
        kolone.get(3).setCellValueFactory(new PropertyValueFactory("mesto"));
        izlistaniDobavljaci.setItems(lista);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            izlistajDobavljace();
        } catch (SQLException ex) {
            Logger.getLogger(DobavljacFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    

    
}
