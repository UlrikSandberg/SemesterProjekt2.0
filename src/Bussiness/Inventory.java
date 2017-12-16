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
    
    /**
     * 
     * @return a ArrayList of type IItem with all the item currently presented by the inventory
     */
    public ArrayList<IItem> getAllItems() {
        return this.inventory;
    }
    
    /**
     * 
     * @return an array of type Iitem with all the items currently presented by the inventory
     */
    public IItem[] getAllItems1() {
        
        IItem[] list = new IItem[this.inventory.size()];
        return this.inventory.toArray(list);
        
    }
    
    /**
     * 
     * add a item to the inventory. Some inventory have a max capacity. Returns a
     * boolean value to indicate if the capacity has been reached and thereby fail
     * completing the operation
     * 
     * @param newItem the item to be added to the inventory
     * @return a boolean value indicating if the operation was succesfull
     */
    public boolean addToInventory(IItem newItem){        // Adds an item to the inventory ArrayList, 
        if(inventory.size() < this.roomCapacity){                      //if the inventory has not met the max capacity.
            inventory.add(newItem);                     //If the max capacity is met the method returns false.
            return true;
            
        } else {
            return false;
        }   
    }
    
    /**
     * 
     * remove a item from the inventory. If the method is used to remove an item
     * which is not currently presentd in the inventory return false
     * 
     * @param newItem item to remove from inventory
     * @return a boolean value indicating wether the operation was succesfull
     */
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
    

    /**
     * 
     * @param newItem item to check if contained in the inventory
     * @return a boolean value indicating whether the item is contained with in or not
     */
    public boolean inventoryDoesContain(Item newItem){  //Checks if the inventory contains a specific item
        System.out.println("does contained was called");
        System.out.println(newItem.getName());
        /*
        for(IItem item: this.inventory) {
            System.out.println(newItem.getName());
            if(item == newItem) {
                System.out.println("Den er her altså!");
            }
        }
        */
        
        
        if(inventory.contains(newItem)) {
            System.out.println("Den er her");
        } else {
            System.out.println("Den er her ikke?");
        }
        
        return inventory.contains(newItem);
    }
    /**
     * System.out.print the contents of the inventory by each items.getName().
     */
    public void inventoryContents(){                    //Prints out the contents of the inventory
        System.out.println("Inventory contains: ");
        int i = 0;
        for(IItem items: inventory){
            i += 1;
            System.out.println(i+"." + items.getName());
            
        }
    }
    
    //Only call if you are sure that the index exists
    /**
     * 
     * Returns and item at specified index + 1. Should only be used if we have first
     * confirmed the presence of an item on the desired index, else the method throws
     * and exception
     * 
     * @param index index of a particular item in the inventory arraylist
     * @return an IItem if such exits on the specified index
     */
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