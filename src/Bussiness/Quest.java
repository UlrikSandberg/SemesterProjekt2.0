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
          
    public void setInitialized(){
        initialized = true;
    }
    
    public boolean getInitialized(){
        return initialized;
    }
    
    public void setCompleted(){
        completed = true;   
        
    }
    
    public int turnQuest() {
        return this.points;
    } 
    
    public Boolean isCompleted() {
        if (this.completed == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setCriteria(Item criteria) {
        
        this.criteria = criteria;
    }
    
    public Item getCriteria() {
        return this.criteria;
    }
    
    public Boolean questCriteriaIsMet(Player player) {
        
        if(player.getInventory().inventoryDoesContain(this.criteria) == true) {
            //The player does contain the item which this quest need!
            //return true to indicate that the user meets the criteria!
            return true;
        } else {
            return false;
        }   
    }
    public boolean getCompleted(){
        return completed;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }

    
}
