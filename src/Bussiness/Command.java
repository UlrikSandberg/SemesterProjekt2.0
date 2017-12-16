package Bussiness;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    private CommandInterface commandWord;
    private String secondWord;

    public Command(CommandInterface commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * 
     * @return the commandword of type commandWords enum from this comman
     */
    public CommandInterface getCommandWord()
    {
        return commandWord;
    }

    /**
     * 
     * @return the commandWord objects secondWrod of type string
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 
     * @return a boolean value indicating if the command word is Unknown
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * 
     * @return a boolean value indicating if the command object has a second word
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

