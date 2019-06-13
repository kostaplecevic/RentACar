/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarnabavkaapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class GlavnaFXMLController implements Initializable {
        @FXML
        private void starterAutomobila(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AutomobilFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
         @FXML
        private void starterRadnika(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RadniciFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
         @FXML
        private void starterDobavljaca(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("DobavljacFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
         @FXML
        private void starterUgovora(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("UgovoriFXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
