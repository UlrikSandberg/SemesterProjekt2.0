/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author ulriksandberg
 */
public enum showCommands implements CommandInterface {
    
    INVENTORY("inventory"), QUEST("quest"), ROOM("room"), UNKNOWN("?");
    
    private String commandString;
    
    showCommands(String commandString)
    {
        this.commandString = commandString;
    }
    
    
    @Override
    public String toString()
    {
        return commandString;
    }
}
