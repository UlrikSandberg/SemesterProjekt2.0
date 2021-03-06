package Bussiness;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;

    public Parser() 
    { 
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 
     * Method initialisez the console line for retreiving a command. Read the two
     * first words and compares them to the registries of commands.
     * 
     * @return a Command object instantiated from
     */
    public Command getCommand() 
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();
        
        
        Scanner tokenizer = new Scanner(inputLine);
        
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        
        //Returns a newly created command object with the argument retrived
        //from calling commands(instance of the class commandWords). in order to create new Command object
        //we call getCommandWord on CommandWords class with argument of the first word from command line received from Game.loop
        //provided by user.
        return new Command(commands.getCommandWord(word1), word2);
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
