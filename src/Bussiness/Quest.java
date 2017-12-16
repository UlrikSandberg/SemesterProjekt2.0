/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import java.io.Serializable;

/**
 *
 * @author Markb
 */
public class Quest implements Serializable{
    
    private boolean initialized, completed;
    private int points;
    private Item criteria;
    private String name;
    private String description;
    
    Quest(int points, String name, String description){
        this.points = points;
        this.initialized = false;
        this.completed = false;
        this.name = name;
        this.description = description;
                
    }
    
    Quest(int points, Item criteria, String name, String description) {
        this.points = points;
        this.initialized = false;
        this.completed = false;
        this.criteria = criteria;
        this.name = name;
        this.description = description;
    }
     
    Quest(int points, boolean initialized){
        this.points = points;
        this.initialized = initialized;
        this.completed = false;
    }
         
    /**
     * Set this quest progress state as initialized
     */
    public void setInitialized(){
        initialized = true;
    }
    
    /**
     * 
     * @return a boolean value indicating whether this quest is initialized
     */
    public boolean getInitialized(){
        return initialized;
    }
    
    /**
     * Set this quest progress state as completed
     */
    public void setCompleted(){
        completed = true;   
        
    }
    
    /**
     * 
     * Hand the quest an receive the points awarded for completion
     * 
     * @return the number of points awarded by the quest
     */
    public int turnQuest() {
        return this.points;
    } 
    
    /**
     * 
     * @return boolean value indicating if the quest is completed or not
     */
    public Boolean isCompleted() {
        if (this.completed == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param criteria an item which is needed to complete the quest
     */
    public void setCriteria(Item criteria) {
        
        this.criteria = criteria;
    }
    
    /**
     * 
     * @return the item which is this quest completion criteria
     */
    public Item getCriteria() {
        return this.criteria;
    }
    
    /**
     * 
     * Check if the player got the items need to complete the quest
     * 
     * @param player the current player 
     * @return a boolean value indicating if the player meets the criteria of the quest
     */
    public Boolean questCriteriaIsMet(Player player) {
        
        if(player.getInventory().inventoryDoesContain(this.criteria) == true) {
            //The player does contain the item which this quest need!
            //return true to indicate that the user meets the criteria!
            return true;
        } else {
            return false;
        }   
    }
    
    /**
     * 
     * @return a boolean value of completed boolean
     */
    public boolean getCompleted(){
        return completed;
    }
    
    /**
     * 
     * @return a question string name 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * @return a description of the quest as a string.
     */
    public String getDescription() {
        return this.description;
    }

    
}
