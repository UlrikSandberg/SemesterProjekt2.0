/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquintance.IBussiness;
import Acquintance.IData;
import Acquintance.IGUI;
import Bussiness.BussinessFacade;
import Data.DataFacade;
import Presentation.UI;

/**
 *
 * @author ulriksandberg
 */
public class starter {


    public static void main(String[] args) {
        
        
        IData data = new DataFacade();
        IBussiness business = new BussinessFacade();
        business.injectData(data);
        IGUI ui = new UI();
        ui.injectBusiness(business);
        
        
        System.out.println("Ready to launch system");
        ui.startApplication(args);
         
        
    }   
}

