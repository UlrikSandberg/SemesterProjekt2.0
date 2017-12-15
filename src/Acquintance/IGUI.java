/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

/**
 *
 * @author ulriksandberg
 */
public interface IGUI {
    
    /**
     * Injects the the businessFacade of type IBusiness into the presenation layer to construct
     * and facilitate communication between the presentationLayer and the businessLayer
     *
     * @param dataLayer the IData layer for injection into the businessFacade
     */
    void injectBusiness(IBussiness businessLayer);
    
    
    /**
     * 
     * Once the gluecode has been properly initialized this method starts the userInterface
     * 
     * @param args contain the command line arguments when starting the program
     */
    void startApplication(String[] args);
    
       
}
