/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.IDialogueBlock;

/**
 *
 * @author ulriksandberg
 */
public interface IDialogue {
    
    /**
     * Represents the first dialogue phase of an NPC. 
     * @param player the player currently playing the game, important because 
     * player has some information that needs to be checked or manipulated in 
     * the method. 
     * @return a DialogueBlock is returned upon call
     */
    IDialogueBlock firstContact(Player player);
    
    /**
     * Represents the second dialogue phase of an NPC. 
     * @param player the player currently playing the game, important because 
     * player has some information that needs to be checked or manipulated in 
     * the method. 
     * @return a DialogueBlock is returned upon call
     */
    IDialogueBlock secondContact(Player player);
    
    /**
     * Represents the third dialogue phase of an NPC. 
     * @param player the player currently playing the game, important because 
     * player has some information that needs to be checked or manipulated in 
     * the method. 
     * @return a DialogueBlock is returned upon call
     */
    IDialogueBlock thirdContact(Player player);
}
