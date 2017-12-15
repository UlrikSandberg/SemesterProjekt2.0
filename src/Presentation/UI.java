/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquintance.IBussiness;
import Acquintance.IGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ulriksandberg
 */
public class UI extends Application implements IGUI {

    private static UI ui;
    private IBussiness business;
    
    /**
     * 
     * Get an instance of the UI class equivalent to a presentationFacade, use this to
     * distribute the acquintance of the businessFacade to various FXML controller not
     * directly connected to the businessFacade
     * 
     * @return an instance of the instantiate UI object.
     */
    public static UI getInstance() {
        return ui;
    }
    
    Stage window;
    Parent parent1, parent2;
    Scene scene1, scene2;
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;
        
        //Scene1
        parent1 = FXMLLoader.load(getClass().getResource("FXMLTaxFraudMainMenu.fxml"));
        scene1 = new Scene(parent1);
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
    }

    @Override
    public void injectBusiness(IBussiness businessLayer) {
        this.business = businessLayer;
        
    }

    @Override
    public void startApplication(String[] args) {
        System.out.println("UI initializing");
        ui = this;
        launch(args);
    }
    /**
     * 
     * Distribute the businessFacade to other FXMLControllers in order for diferent FXMLScenes
     * to access the businessLayer.
     * 
     * @return an instance of the business facade. See injectBusiness for origins
     */
    public IBussiness getBusiness() {
        return business;
    }
}
