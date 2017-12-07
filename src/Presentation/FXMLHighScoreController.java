/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquintance.IBussiness;
import Acquintance.IHighScore;
import java.io.FileNotFoundException;
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
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rol's studie PC
 */
public class FXMLHighScoreController implements Initializable {

    IBussiness bussinesFacade;

    @FXML
    private Button backButton;
    @FXML
    private TextField FirstPlaceName;
    @FXML
    private TextField FirstPlaceScore;
    @FXML
    private TextField SecondPlaceName;
    @FXML
    private TextField SecondPlaceScore;
    @FXML
    private TextField ThirdPlaceName;
    @FXML
    private TextField ThirdPlaceScore;
    @FXML
    private TextField FourthPlaceName;
    @FXML
    private TextField FourthPlaceScore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bussinesFacade = UI.getInstance().getBusiness();
        // TODO
        //For-loop
        
       
        System.out.println("John");
        try {
            something();
        } catch (IOException ex) {
            ex.getCause();
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getCause();
            ex.getMessage();
        }
        System.out.println("Matt");
    }

    public void something() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("hello");
        //       System.out.println(highScore.getScores().size());
        System.out.println("b" + bussinesFacade + "\th");
        System.out.println("c" + bussinesFacade.getHighscore() + "\tj");
        System.out.println(bussinesFacade.getHighscore().getScores().get(0).getName());

        FirstPlaceName.setText(bussinesFacade.getHighscore().getScores().get(0).getName());
        FirstPlaceName.setText(bussinesFacade.getHighscore().getScores().get(0).getName());
        FirstPlaceScore.setText(bussinesFacade.getHighscore().getScores().get(0).getScore() + "");
        SecondPlaceName.setText(bussinesFacade.getHighscore().getScores().get(1).getName());
        SecondPlaceScore.setText(bussinesFacade.getHighscore().getScores().get(1).getScore() + "");
        ThirdPlaceName.setText(bussinesFacade.getHighscore().getScores().get(2).getName());
        ThirdPlaceScore.setText(bussinesFacade.getHighscore().getScores().get(2).getScore() + "");
        FourthPlaceName.setText(bussinesFacade.getHighscore().getScores().get(3).getName());
        FourthPlaceScore.setText(bussinesFacade.getHighscore().getScores().get(3).getScore() + "");
    }

    @FXML
    private void back(ActionEvent event) throws IOException {

        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLTaxFraudMainMenu.fxml"));

        Scene newScene = new Scene(adminScene);

        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();

    }

    @FXML
    private void ScorboardInitiated(ContextMenuEvent event) {

    }
}
