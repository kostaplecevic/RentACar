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
public class AutomobilFXMLController implements Initializable {
    @FXML
    private TableColumn ID;
    @FXML
    private TextField marka;
    @FXML
    private TextField tipVozila;
    @FXML
    private TextField tipPotrosnje;
    @FXML
    private TextField idAutomobila;
    @FXML
    private TableView IzlistaniAutomobili;
    @FXML
    private TableColumn MA;
    @FXML
    private TableColumn TV;
    @FXML
    private TableColumn TP;
    
    @FXML
    private void dodajAutomobil(ActionEvent event) throws SQLException {
        String marka1 = marka.getText();
        String tipVozila1 = tipVozila.getText();
        String tipPotrosnje1 = tipPotrosnje.getText();
        Automobil a1 = new Automobil(marka1,tipVozila1,tipPotrosnje1);
        UpravljanjeAutomobilom.dodajAutomobil(a1);    
    }

    @FXML
    private void izbrisiAutomobil(ActionEvent event) throws SQLException {
        int idAutomobila1 = Integer.parseInt(idAutomobila.getText());
        UpravljanjeAutomobilom.izbrisiAutomobil(idAutomobila1);
    }

    @FXML
    private void izmeniAutomobil(ActionEvent event) throws SQLException {
        String marka1 = marka.getText();
        String tipVozila1 = tipVozila.getText();
        String tipPotrosnje1 = tipPotrosnje.getText();
        int idAutomobila1 = Integer.parseInt(idAutomobila.getText());
        Automobil a1 = new Automobil(marka1,tipVozila1,tipPotrosnje1);
        UpravljanjeAutomobilom.izmeniAutomobil(a1,idAutomobila1);
    }

    @FXML
    private void nadjiAutomobil(ActionEvent event) throws SQLException {
        int idAutomobila1 = Integer.parseInt(idAutomobila.getText());
        Automobil a1 = UpravljanjeAutomobilom.nadjiAutomobil(idAutomobila1);
        marka.setText(a1.getMarka());
        tipVozila.setText(a1.getTipVozila());
        tipPotrosnje.setText(a1.getTipPotrosnje());
    }
    @FXML
    private void izlistajAutomobile() throws SQLException {
        ObservableList <Automobil> lista = UpravljanjeAutomobilom.izlistajAutomobile();
        ObservableList <TableColumn> kolone = IzlistaniAutomobili.getColumns();
        kolone.get(0).setCellValueFactory(new PropertyValueFactory("idAutomobila"));
        kolone.get(1).setCellValueFactory(new PropertyValueFactory("marka"));
        kolone.get(2).setCellValueFactory(new PropertyValueFactory("tipVozila"));
        kolone.get(3).setCellValueFactory(new PropertyValueFactory("tipPotrosnje"));
        IzlistaniAutomobili.setItems(lista);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            izlistajAutomobile();
        } catch (SQLException ex) {
            Logger.getLogger(DobavljacFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    
}
