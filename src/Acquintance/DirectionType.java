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
public enum DirectionType {
    
    NORTH("north"), SOUTH("south"), EAST("east"), WEST("west");
    
    
    private String description;
    
    @Override
    public String toString() {
        return this.name();
    }
    
    DirectionType(String description)
    {
        this.description = description;
    }
}
