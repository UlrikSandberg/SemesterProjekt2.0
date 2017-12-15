/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.Item;
import Bussiness.Player;
import Bussiness.Quest;
import Bussiness.Room;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author ulriksandberg
 */
public interface INPC {
    
    /**
     * 
     * 
     * @return the name of the respective NPC
     */
    public String getName();
    
    /**
     * 
     * Set the quest which the respective NPC then can hand over to the player
     * in order with the story quest-line
     * 
     * @param quest set quest, to be given to a player
     */
    public void setQuest(Quest quest);
    
    /**
     * 
     * Set a quest criteria, for the current NPC, this can be used to check if the player
     * has reached the desired progress by containing another NPC quest
     * 
     * @param quest set quest, so we may check if player contain the criteria.
     */
    public void setCriteria(Quest quest);
    
    /**
     * 
     * Set the item to a NPC so we may hand over the item to a player after or
     * before quest completion
     * 
     * 
     * @param item set item, to be handed over to a player.
     */
    public void setItem(Item item);
    
    /**
     * 
     * Set an item so it is possible to check if a given player has the required item
     * to proceed with something
     * 
     * 
     * @param item set item, so we may check if player contains the item
     */
    public void setItemCriteria(Item item);
    
    /**
     * 
     * Returns a Dialogue of type IDialogueBlock see more information about dialogueblocks
     * in the designated documentation. IDialogue
     * 
     * @param player take player in order to edit the player respectively to progress
     * in the dialogue block
     * @return a IDialogue block depending on respective NPCs current dialogue state
     */
    public IDialogueBlock dialogue(Player player);
    
    /**
     * 
     * Acessor for the image of the respective NPC
     * 
     * @return an image of type Image
     */
    public Image getImage();
    
    /**
     * 
     * Mutator method to assign an image to the respective NPC
     * 
     * @param filepath the filePath of the given image fx /Presentation/AssetsLibrary/myImage.png
     */
    public void setImage(String filepath);
    public Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom);
    
}
