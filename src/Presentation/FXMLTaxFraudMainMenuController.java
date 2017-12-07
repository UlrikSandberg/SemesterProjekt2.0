/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquintance.IBussiness;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Rol's studie PC
 */
public class FXMLTaxFraudMainMenuController implements Initializable {

    
        @FXML
    private Button StartGameButton;
    
    @FXML
    private Button LoadGameButton;
    
    @FXML
    private Button HighScoreButton;
    
    @FXML
    private Button ExitButton;
    
    private IBussiness business;
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        business = UI.getInstance().getBusiness();
    }    
    
    @FXML
    private void startGame(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLStartGameScreen.fxml"));
                
        Scene newScene = new Scene(adminScene);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
         
    }
    
    @FXML
    private void Exit(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    @FXML
    private void LoadGame(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        business.loadSavedGame();
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLGameScene.fxml"));
                
            Scene newScene = new Scene(adminScene);
        
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            newScene.getRoot().requestFocus();
            appStage.setScene(newScene);
            appStage.show(); 
        
    }
    
    @FXML
    private void HighScore(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
                
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLHighScore.fxml"));
                
        Scene newScene = new Scene(adminScene);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
        
        
    }

}


//private void fadeOut() {
//        FadeTransition fadeOut = new FadeTransition();
//        fadeOut.setDuration(Duration.millis(1500));
//        fadeOut.setNode(anchorPane);
//        fadeOut.setFromValue(1);
//        fadeOut.setToValue(0);
//        
//        fadeOut.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("do something when animation is finished");
//            }
//        });
//        fadeOut.play();
//    }