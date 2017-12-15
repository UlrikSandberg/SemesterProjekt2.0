/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.Player;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public interface IDialogueBlock {
    
    /**
     * Represents a line of dialogue in-game, during this line, certain logic 
     * is run depending on the block gotten as well as returning 
     * the line of dialogue. 
     * @param player the player currently playing the game, important because 
     * player has some information that needs to be checked or manipulated in 
     * the method. 
     * @return a string gotten from the block determined by the switch. 
     */
    public String dialogue(Player player);
    
    /**
     * gets player's options that has been updated during logic elsewhere. 
     * @return a list of strings, your options so to speak as the player, 
     * in accordance with the current line. 
     */
    public ArrayList<String> getOptions();
    
    /**
     * Changes the state which determines which block you end up with 
     * from the current phase, it does this 
     * by evaluating "answer" toward a hashmap which sets it to a number 
     * to be used by a switch in dialogue. 
     * @param answer is the answer chosen by the player 
     * from an amount of options given in a line of dialogue. 
     */
    public void changeState(String answer);
    
    
    
}
