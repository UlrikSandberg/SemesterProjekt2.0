/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

/**
 *
 * @author ulriksandberg
 */
public interface IItem {
 
    /**
     * 
     * @return A string representation of the item object, describing its name
     */
    String toString();
    
    /**
     * 
     * accesor method to get the name of the object
     * 
     * @return the name of the object as string
     */
    String getName();
    
    /**
     * 
     * The item description based on the respective item
     * 
     * @return the description of the current object
     */
    String getDescription();
    
    /**
     * 
     * @return the amount of items currently left in this object
     */
    int getAmount();
    
    /**
     * 
     * indicates the number of items currently on the object in the println
     * 
     */
    void printAmount();
    
    
}
