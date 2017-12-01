/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author Rol's studie PC
 */
import Acquintance.IItem;
import Acquintance.IPlayer;
import Acquintance.IRoom;
import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable, IPlayer{
    
    
    
    private Inventory inventory;
    private ArrayList<Quest> quest;
    private Score score;
    private boolean didWin;
    private boolean didLose;
    private Room playerRoom;
    private String name;
    
    public Player() {
        this.quest = new ArrayList<>();
        this.inventory = new Inventory(10);
        this.score = new Score();
        this.didWin = false;
        this.didLose = false;
        this.name = null;
    }
    
    public Player(String playerName) {
        this.quest = new ArrayList<>();
        this.inventory = new Inventory(10);
        this.score = new Score();
        this.didWin = false;
        this.didLose = false;
        this.name = playerName;
    }

    public void setQuest(Quest quest) {
        this.quest.add(quest);
        
    }

    public Inventory getInventory() {
        return inventory;
    }

    public IItem[] getInventoryItems() {
        
        return this.inventory.getAllItems1();
    }
    
    
    public ArrayList<Quest> getQuest() {
        return quest;
    }

    public void showQuests() {
        
        int i = 0 ;
        for(Quest quest: this.quest) {
            i += 1;
            System.out.println(i+". "+ quest.getName());
        }
        
    }
    
   public boolean questHasIndex(int index) {
       
       if(index - 1 <= index - 1) {
           return true;
       } else {
           return false;
       }
   }
    
   public Quest questAtIndex(int index) {
       return this.quest.get(index - 1);
   }
    
    public Boolean hasQuest(Quest quest) {
        
        return this.quest.contains(quest);
    
    }
    
    public Boolean completeQuest(Quest quest) {
        
        if(this.quest.contains(quest) == true) {
            
            score.incrementScore(quest.turnQuest());
            return true;
        } else {
            return false;
        }
    }
    
    
    public Boolean isQuestComplete(Quest quest) {
        if(this.quest.contains(quest)) {
            if(quest.isCompleted() == true) {
                return true;
            }
        }
        return false;
    }
    
    public Score getScore() {
        return score;
    }
    
    public void setScore(int seconds,int points,int hintCost){
        this.score = new Score(seconds, points, hintCost);
    }
    
    public void setCurrentRoom(Room currentRoom) {
        playerRoom = currentRoom;
    }
    
    public Room getCurrentRoom() {
        return this.playerRoom;
    }
    
    public void setWin(){
        didWin = true;
    }
    
    public void setLose(){
        didLose = true;
    }
    
    public boolean didWin(){
        return didWin;
    }
    
    public boolean didLose(){
        return didLose;
    }
    
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }

    @Override
    public IRoom getPlayerRoom() {
        return this.playerRoom;
    }
    
}
