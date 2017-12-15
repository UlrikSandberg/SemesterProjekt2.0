/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.IDialogueBlock;
import Acquintance.INPC;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Markb
 */
public abstract class NPC implements IDialogue, IGuard, Serializable, INPC {
    
    private int state = 1;
    private Quest quest;
    private Quest criteria;
    private Item item;
    private Item itemCriteria;
    private String name;
    private transient Image image;
    
    protected NPC(String name, String filePath) {
        this.name = name;
        this.image = this.image = new Image(getClass().getResourceAsStream(filePath));
    }
    
    
    
    @Override
    public IDialogueBlock dialogue(Player player) {
        
        switch (state) {
            
            case 1:
                return firstContact(player);             
            case 2:
                return secondContact(player);             
            case 3:
                return thirdContact(player);         
        }
        return null;
    }
    
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * Increment the current dialogue state, use method when change to next
     * dialogue block is desired.
     * 
     */
    public void changeState() {
        this.state += 1;
    }
    
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    
    /**
     * 
     * Acessor method for the quest which the NPC is able to give away
     * 
     * @return the quest which take the player further in the quest line
     */
    public Quest getQuest() {
        return this.quest;
    }
    
    public void setCriteria(Quest quest) {
        this.criteria = quest;
    }
    
    /**
     * 
     * return the quest which you must have in order to move forward in the questline
     * 
     * 
     * @return the questiCriteria 
     */
    public Quest getCriteria() {
        return this.criteria;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public void setItemCriteria(Item item) {
        this.itemCriteria = item;
    }
    
    /**
     * 
     * @return the item of which has been set as criteria for completion of task
     */
    public Item getItemCriteria() {
        return this.itemCriteria;
    }
    
    /**
     * 
     * @return the item of which is suppost to be passed on after completion of tasks
     * 
     */
    public Item getItem() {
        return this.item;
    }
    
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(String filepath){
        this.image = new Image(getClass().getResourceAsStream(filepath));
    }
}
