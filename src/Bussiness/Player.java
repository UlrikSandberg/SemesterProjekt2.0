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

    /**
     * 
     * Assign a quest to the currentPlayer
     * 
     * @param quest 
     */
    public void setQuest(Quest quest) {
        this.quest.add(quest);
        
    }

    /**
     * 
     * @return the inventory object for the current Player
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * 
     * @return an array of IItem respective to the content of the player inventory
     */
    public IItem[] getInventoryItems() {
        
        return this.inventory.getAllItems1();
    }
    
    /**
     * 
     * @return ArrayList of the players current quests
     */
    public ArrayList<Quest> getQuest() {
        return quest;
    }

    /**
     * 
     * Show which quest the user is currently in posesion of in the console.
     * 
     * 
     */
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
    
    /**
     * 
     * Indicate if the user has a certain quest
     * 
     * @param quest the quest which we want to check for
     * @return boolean value indicating if the currentPlayer has the quest
     */
    public Boolean hasQuest(Quest quest) {
        
        return this.quest.contains(quest);
    
    }
    
    /**
     * 
     * Complete a specific quest. The method returns true if the user has the quest
     * and is capable of completing it. False if the current player dont have the quest
     * 
     * @param quest the quest which the user completed
     * @return boolean value indicating if the user is capable of completing the quest
     */
    public Boolean completeQuest(Quest quest) {
        
        if(this.quest.contains(quest) == true) {
            
            score.incrementScore(quest.turnQuest());
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * Check if a certain quest has been completed
     * 
     * @param quest the quest to check for completion
     * @return a boolean value indicating if the player completed the quest or not
     */
    public Boolean isQuestComplete(Quest quest) {
        if(this.quest.contains(quest)) {
            if(quest.isCompleted() == true) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @return the current players score
     */
    public Score getScore() {
        return score;
    }
    
    /**
     * 
     * Mark burde nok skrive i den her?
     * 
     * @param seconds
     * @param points
     * @param hintCost 
     */
    public void setScore(int seconds,int points,int hintCost){
        this.score = new Score(seconds, points, hintCost);
    }
    
    /**
     * 
     * Move currentPlayer from one room to another
     * 
     * @param currentRoom the room which the player should move to
     */
    public void setCurrentRoom(Room currentRoom) {
        playerRoom = currentRoom;
    }
    
    /**
     * 
     * @return the room which the currentPlayer is residing in;
     */
    public Room getCurrentRoom() {
        return this.playerRoom;
    }
    
    /**
     * 
     * Mutator method to change the boolean value of the player win status to true
     * 
     */
    public void setWin(){
        didWin = true;
    }
    
    /**
     * 
     *  Mutator method to change the boolean value of the player loose status to true
     * 
     */
    public void setLose(){
        didLose = true;
    }
    
    /**
     * 
     * @return the current players win status
     */
    public boolean didWin(){
        return didWin;
    }
    
    /**
     * 
     * @return the players loose status
     */
    public boolean didLose(){
        return didLose;
    }
    
    /**
     * 
     * Set the name of the current player
     * 
     * @param name string representation of the name
     */
    public void setName(String name){
        this.name = name;
    }

    
    /**
     * 
     * 
     * 
     * @return the current players name as string
     */
    @Override
    public String getPlayerName() {
        return this.name;
    }

    /**
     * 
     * 
     * 
     * @return the room of which the player is currently residing
     */
    @Override
    public IRoom getPlayerRoom() {
        return this.playerRoom;
    }
    
}
