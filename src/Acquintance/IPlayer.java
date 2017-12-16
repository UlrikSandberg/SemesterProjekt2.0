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
public interface IPlayer {
    
    /**
     * 
     * 
     * @return  the currentPlayer name as string
     */
    String getPlayerName();
    
    /**
     * 
     * Get a list of all the Items contained in the currentPlayer inventory
     * 
     * @return an array of IItems
     */
    IItem[] getInventoryItems();
    
    /**
     * 
     * @return the room respective to the currentPlayers room.
     */
    IRoom getPlayerRoom();
    
    
    
    
}
