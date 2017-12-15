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
    
    /**
     * 
     * Returns the NPC of type INPC who is currently blocking the path.
     * This should only be used after goRoom returns false
     * 
     * @param direction the direction respective to the way the road was blocked.
     * @return The NPC of type INPC which is currently blocking the path
     */
    INPC getExitNPC(DirectionType direction);
    
    /**
     * Injects the the dataFacade of type IData into the businessFacade to construct
     * and facilitate communication between the businessLayer and the persistenceLayer
     *
     * @param dataLayer the IData layer for injection into the businessFacade
     */
    void injectData(IData dataLayer);
    
    /**
     * Moves the player from one room to another based on DirectionType(east, west, north, south)
     * 
     * 
     * @param direction the direction of type DirectionType, which indicate 
     * which direction the player wants to go.
     * @return a boolean value indicating weather the player was successful at switching rooms
     */
    
    Boolean goNextRoom(DirectionType direction);
    /**
     * 
     * Instantiate a new Game object and pass the string to the game constructor
     * here by assigning the value of the string to the new games player
     * 
     * 
     * @param playerName sets the property of the string as the players avatar name
     */
    void startNewGame(String playerName);
    
    /**
     * Mark burde skrive her
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    void loadSavedGame()throws IOException, FileNotFoundException, ClassNotFoundException;
    
    /**
     * Mark burde skrive her
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    void saveGame() throws IOException, FileNotFoundException, ClassNotFoundException;
    
    /**
     * 
     * Returns the current player object, instantiated on either startNewGame() or loadSavedGame()
     * hence this method should not be used if no game has been started nor loaded.
     * 
     * @return a object of type IPlayer, if no game has been instantiated this returns null instead
     */
    IPlayer getPlayer();
    
    /**
     * 
     * Used to retrieve all items currently represented in the players inventory,
     * happens by iterating the players inventory.
     * 
     * @return an array of type IItem consisting of all the items currently represented in the 
     * players inventory
     */
    IItem[] getInventory();
    
    /**
     * 
     * Used to get information about in which directions the user can go, this is indicated
     * by the DirectionTypes (east, west, south, north) contained in the arrayList.
     * 
     * @return an arrayList of DirectionType
     */
    ArrayList<DirectionType> getExists();
    
    /**
     * 
     * Get the room of which the player is currently residing.
     * 
     * @return a room of type IRoom respective the room which the player is currently residing
     */
    IRoom getCurrentRoom();
    
    /**
     * 
     * Returns a list of type IItem contained within the room respective to
     * the players current room.
     * 
     * @return a ArrayList containing all the items in the room
     */
    ArrayList<IItem> getRoomItems();
    
    /**
     * 
     * Picks up a room item.
     * 
     * @param item the item which the user would like to pick up.
     * @return a boolean value indicate if the player was successful retrieving the room item
     */
    Boolean takeItem(IItem item);
    
    /**
     * 
     * Removes an item from the players inventory
     * 
     * @param item specify which item should be removed from the players inventory
     */
    void removePlayerItem(IItem item);
    
    /**
     * 
     * Get a list of all the NPCS currently residing within the room respective to the
     * players currentRoom
     * 
     * @return a ArrayList of type INPC of all the current room NPCS
     */
    ArrayList<INPC> getRoomNPCS();
    
    /**
     * Mark burde skrive
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    IHighScore getHighscore()throws IOException, FileNotFoundException, ClassNotFoundException;
    
    /**
     * Mark burde skrive
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    void saveHighscore()throws IOException, FileNotFoundException, ClassNotFoundException;
    /**
     * Mark burde skrive
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    void loadHighscore()throws IOException, FileNotFoundException, ClassNotFoundException;
    /**
     * Mark burde skrive
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    void checkHighscore()throws IOException, FileNotFoundException, ClassNotFoundException;
    
    
}
