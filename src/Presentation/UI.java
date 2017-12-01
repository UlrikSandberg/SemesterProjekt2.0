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
    
    public IBussiness getBusiness() {
        return business;
    }
}
