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
    
    public boolean setAmount(int amount){
        this.amount = amount;
        if(this.amount <= 0){
            
            return false;
        }
        else{
            return true;
        }
    }
    
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
