package Bussiness;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord implements CommandInterface {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), TALK("talk"), SHOW("show"), TAKE("take"), SAVE("save"), LOAD("load") ;
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
