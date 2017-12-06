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
    
    protected NPC(String name) {
        this.name = name;
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
    
    
    public void changeState() {
        this.state += 1;
    }
    
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    public Quest getQuest() {
        return this.quest;
    }
    
    public void setCriteria(Quest quest) {
        this.criteria = quest;
    }
    
    public Quest getCriteria() {
        return this.criteria;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public void setItemCriteria(Item item) {
        this.itemCriteria = item;
    }
    
    public Item getItemCriteria() {
        return this.itemCriteria;
    }
    public Item getItem() {
        return this.item;
    }
}
