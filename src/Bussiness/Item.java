/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import Acquintance.IItem;
import java.io.Serializable;

/**
 *
 * @author Justus
 */
public class Item implements Serializable, IItem{
    
    private String name;
    private int amount;
    private String description;
    
    Item(String newName, String description){
        this.name = newName;
        this.description = description;
        this.amount = 1;
    }
    
    Item(String newName, String description, int amount){
        this.name = newName;
        this.amount = amount;
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString() {
        return name;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    /**
     * 
     * Choose the amount for the current item 
     * 
     * @param amount the amount you want to set on the current object 
     * @return a boolean value indicating if the amount of an item reaches 0
     */
    public boolean setAmount(int amount){
        this.amount = amount;
        if(this.amount <= 0){
            
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * 
     * Lower the amount of the item by one. If the item such as a paper goes
     * below 1 or equal 0 setWin() for currentPlayer
     * 
     * @param player the currentPlayer
     */
    public void decrementAmount(Player player){
        this.amount -= 1;
        if(this.amount <= 0){
            player.setWin();
        }
    }
    
    public void printAmount(){
        System.out.println("You have: " + this.amount);
    }
    
    public String getDescription() {
        System.out.println(this.description);
        return this.description;
    }
}
