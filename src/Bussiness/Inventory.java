/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author Markb
 */
import Acquintance.IItem;
import java.io.Serializable;
import java.util.ArrayList;
public class Inventory implements Serializable{
   
    ArrayList<IItem> inventory;
    int roomCapacity;
     
    public Inventory(int roomCapacity) {
        
        this.inventory = new ArrayList();
        this.roomCapacity = roomCapacity;
        
    }
    
    
    public ArrayList<IItem> getAllItems() {
        return this.inventory;
    }
    
    public IItem[] getAllItems1() {
        
        IItem[] list = new IItem[this.inventory.size()];
        return this.inventory.toArray(list);
        
    }
    
    public boolean addToInventory(IItem newItem){        // Adds an item to the inventory ArrayList, 
        if(inventory.size() < this.roomCapacity){                      //if the inventory has not met the max capacity.
            inventory.add(newItem);                     //If the max capacity is met the method returns false.
            return true;
            
        } else {
            return false;
        }   
    }
    
    public boolean removeFromInventory(IItem newItem){   //Removes an item from the inventory
        if(inventory.contains(newItem)){                //if the inventory does contain it.
            inventory.remove(newItem);                  //If the inventory does not contain the item the method returns false
            System.out.println("Item was removed from inventory, new size is: " + this.inventory.size());
            
            return true;
        } else {
            System.out.println("Item is not in inventory, the size is: "+ this.inventory.size());
            return false;
        }
    }
    

    
    public boolean inventoryDoesContain(Item newItem){  //Checks if the inventory contains a specific item
        return inventory.contains(newItem);
    }
    
    public void inventoryContents(){                    //Prints out the contents of the inventory
        System.out.println("Inventory contains: ");
        int i = 0;
        for(IItem items: inventory){
            i += 1;
            System.out.println(i+"." + items.getName());
            
        }
    }
    
    //Only call if you are sure that the index exists
    public IItem getItemAtIndex(int index) {
      
        return inventory.get(index - 1);
    }
    
    public boolean hasIndex(int index) {
        
        if(inventory.size() - 1 >= index - 1) {
            
            return true;
        } else {
            return false;
        }    
    }
    
    
    
    
}