/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public interface IBussiness {
    
    
    
    void injectData(IData dataLayer);
    Boolean goNextRoom(DirectionType direction);
    void startNewGame(String playerName);
    void loadSavedGame();
    void saveGame() throws IOException, FileNotFoundException, ClassNotFoundException;
    IPlayer getPlayer();
    IItem[] getInventory();
    ArrayList<DirectionType> getExists();
    IRoom getCurrentRoom();
    ArrayList<IItem> getRoomItems();
    Boolean takeItem(IItem item);
    void removePlayerItem(IItem item);
    ArrayList<INPC> getRoomNPCS();
    
    
}
