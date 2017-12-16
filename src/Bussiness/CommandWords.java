package Bussiness;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords
{
    //HashMap a key - value paired storage type - keeps link between command string and its corresponding command
    private HashMap<String, CommandWord> validCommands;
    private HashMap<String, showCommands> secondCommands;

    //Constructor for the CommandWords
    public CommandWords()
    {
        //Declares the private value as a hashmap
        validCommands = new HashMap<String, CommandWord>();
        secondCommands = new HashMap<String, showCommands>();
       
        //Iterate through the public enum CommandWord look at each value inside the enum
        //if the CommandWord.value != (is not equal to) CommandWord.UNKNOWN then append it to the hashMap
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                //When appending the commands to the hashMap it is worth mentioning that we set value of the command
                //to it's corresponding string allso fetched from the public enum "CommandWord" through the public toString method
                //which returns the respective commands string, which we then set inside the hashMap.
                validCommands.put(command.toString(), command);
            }
        }
        
        //Iterate through the public enum showCoomands look at each value inside the enum
        for(showCommands command: showCommands.values()) {
            if(command != showCommands.UNKNOWN) {
                secondCommands.put(command.toString(), command);
            }
        }
    }

    //This method returns a commandWord if such exists in the class's constructed hashMap of valid commands
    //if no such exists return the command word UNKNOWN.
    /**
     * 
     * @param commandWord a string representation of the commandword
     * @return the commandword respective to the param commandWord String
     */
    public CommandWord getCommandWord(String commandWord)
    {
        //Set command equal to the command inside the hashMap which corrosponds to the received commandWord.
        CommandWord command = validCommands.get(commandWord);
        if(command != null) { //If the value of command is anything else than nothing return this commandWord
            return command;
        }
        else { //If the value is null (Nothing) - Return UNKNOWN since we do not recognize the commandWord
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * 
     * 
     * 
     * @param commandWord a string representation of the showCommands word
     * @return the showCommand respective to the param commandWord String
     */
    public showCommands getSecondCommandWord(String commandWord) {
        
        showCommands command = secondCommands.get(commandWord);
        if(command != null) {
            return command;
        } else {
            return showCommands.UNKNOWN;
        }
        
    }
    
    
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * System.out.print all of valid commands
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
