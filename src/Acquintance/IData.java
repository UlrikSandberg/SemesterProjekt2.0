/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ulriksandberg
 */
public interface IData {
    
    
    IDataTransfer loadGame() throws FileNotFoundException, IOException, ClassNotFoundException;
    void saveGame(IDataTransfer transfer) throws FileNotFoundException, IOException, ClassNotFoundException;
    
          
}
