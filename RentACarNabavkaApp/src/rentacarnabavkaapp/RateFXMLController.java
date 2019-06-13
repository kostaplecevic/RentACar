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
public class RateFXMLController implements Initializable {

    @FXML
    private TextField iznos;
    @FXML
    private TextField idRate;
    @FXML
    private TextField BrUplatnice;
    @FXML
    private TextField brRate;
    @FXML
    private TableView izlistaneRate;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn BR;
    @FXML
    private TableColumn BU;
    @FXML
    private TableColumn IZ;
    @FXML
    private TableColumn DP;
    @FXML
    private TableColumn IDU;
    @FXML
    private TextField datumPlacanja;
    @FXML
    private TextField ugovorid;
    
    @FXML
    private void dodajRatu(ActionEvent event) throws SQLException {
        int brRate1 = Integer.parseInt(brRate.getText());
        int BrUplatnice1 = Integer.parseInt(BrUplatnice.getText());
        int iznos1 = Integer.parseInt(iznos.getText());
        String datumPlacanja1 = datumPlacanja.getText();
        int ugovorid1 = Integer.parseInt(ugovorid.getText());
        Ugovor u = UpravljanjeUgovorima.nadjiUgovor(ugovorid1);
        System.out.println(u.getBrUgovora());
        if(u.getBrRata()>0){
        Rate r1 = new Rate(brRate1,BrUplatnice1,iznos1,datumPlacanja1,ugovorid1);
        UpravljanjeRatama.dodajRatu(r1);}
        else{
            izlistaneRate.setAccessibleText("Ne mozete da unesete rate za auto koji se ne placa na rate");
        }
    }

    @FXML
    private void izbrisiRatu(ActionEvent event) throws SQLException {
        int idRate1 = Integer.parseInt(idRate.getText());
        UpravljanjeRatama.izbrisiRatu(idRate1);
    }

    @FXML
    private void izmeniRatu(ActionEvent event) throws SQLException {
        int idRate1 = Integer.parseInt(idRate.getText());
        int brRate1 = Integer.parseInt(brRate.getText());
        int BrUplatnice1 = Integer.parseInt(BrUplatnice.getText());
        int iznos1 = Integer.parseInt(iznos.getText());
        String datumPlacanja1 = datumPlacanja.getText();
        int ugovorid1 = Integer.parseInt(ugovorid.getText());
        Rate r1 = new Rate(brRate1,BrUplatnice1,iznos1,datumPlacanja1,ugovorid1);
        UpravljanjeRatama.izmeniRate(r1, idRate1);
    }

    @FXML
    private void nadjiRatu(ActionEvent event) throws SQLException {
        int idUgovora = Integer.parseInt(ugovorid.getText());
        izlistajRate(idUgovora);
    }
    @FXML
    private void izlistajRate(int id) throws SQLException {
        ObservableList <Rate> lista = UpravljanjeRatama.izlistajRate(id);
        ObservableList <TableColumn> kolone = izlistaneRate.getColumns();
        kolone.get(0).setCellValueFactory(new PropertyValueFactory("idRate"));
        kolone.get(1).setCellValueFactory(new PropertyValueFactory("brRate"));
        kolone.get(2).setCellValueFactory(new PropertyValueFactory("BrUplatnice"));
        kolone.get(3).setCellValueFactory(new PropertyValueFactory("iznos"));
        kolone.get(4).setCellValueFactory(new PropertyValueFactory("datumPlacanja"));
        kolone.get(5).setCellValueFactory(new PropertyValueFactory("ugovorid"));
        izlistaneRate.setItems(lista);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    
    
}
