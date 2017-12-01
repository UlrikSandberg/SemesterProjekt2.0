/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquintance.IBussiness;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLStartGameScreenController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button beginGameButton;
    
    private IBussiness business;
    @FXML
    private Label warningLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        business = UI.getInstance().getBusiness();
        warningLabel.setVisible(false);
        
    }    

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        
        if(nameTextField.getCharacters().length() > 0) {
        
            String playerName = nameTextField.getCharacters().toString();
            
            business.startNewGame(playerName);
            
            Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLGameScene.fxml"));
                
            Scene newScene = new Scene(adminScene);
        
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            newScene.getRoot().requestFocus();
            appStage.setScene(newScene);
            appStage.show(); 
        } else {
            warningLabel.setVisible(true);
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLTaxFraudMainMenu.fxml"));
                
        Scene newScene = new Scene(adminScene);
        
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
        
     
    } 
}
