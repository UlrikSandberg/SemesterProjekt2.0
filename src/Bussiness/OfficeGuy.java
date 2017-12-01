/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author Justus
 */
import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import java.util.ArrayList;
import java.util.Scanner;
public class OfficeGuy extends NPC {
    
    
    public OfficeGuy(String name) {
        super(name);
    }

    

    @Override
    public IDialogueBlock firstContact(Player player) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello mr.");
        System.out.println("You look like a man who wants to help a fella out");
        System.out.println("I got these papers which my boss gave");
        System.out.println("I need them destroyed!");
        System.out.println("Could you help me out?");
        System.out.println("1. Sure thing, office guy! (Accept quest) ");
        System.out.println("2. This seems like something you should figure out for yorself");
        System.out.println("3. What kind of papers are these? ");
        
        switch(input.nextInt()){
        
            
            case 1:
                //Assign quest to user if you have enough inventory for the quest item
                if(player.getInventory().addToInventory(super.getItem()) == true) {
                                    super.getQuest().setInitialized();
                                    player.setQuest(super.getQuest());
                                    System.out.println("You accepted the quest!");
                                    super.changeState();
                                } else {
                                    System.out.println("Not enough space in inventory");
                                }
                        break;
            case 2:
                //Nothing happens (reject quest)
                break;
            case 3:
                System.out.println("Ehhhhrmmm.... I would tell you..");
                System.out.println("But it's confidential");
                System.out.println("Will you help me?");
                System.out.println("1. I could probably help you out ");
                System.out.println("2. Sounds like you've got a problem, guy");
                
                switch(input.nextInt()){
                    case 1: 
                        //Assign quest to user if you have enough inventory for the quest item
                        if(player.getInventory().addToInventory(super.getItem()) == true) {
                                    super.getQuest().setInitialized();
                                    player.setQuest(super.getQuest());
                                    System.out.println("You accepted the quest!");
                                    super.changeState();
                                } else {
                                    System.out.println("Not enough space in inventory");
                                }
                        break;
                    case 2:
                        //Nothing happens
                        break;
                }
                
                
        }
        return new BulterDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        
        if(player.isQuestComplete(super.getQuest()) == true){
            
            System.out.println("Thanks for helping me out with those papers.");
            System.out.println("Not many people know this but there's an archive containing");
            System.out.println("all people's tax-papers i the east end of the building.");
            System.out.println("If yours were to disappear, i guess you technically wouldn't have to ");
            System.out.println("pay your taxes...");
            System.out.println("If anybody asks don't mention my name!");
            System.out.println("Oh wait... You don't know my name. Bye bye");
            super.changeState();
            
        }else if(player.isQuestComplete(super.getQuest()) == false){
            System.out.println("How did it go with those paper? ");
            System.out.println("Complete the quest before returning to officeGuy");
            }
        
        
        return new BulterDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Did you check those archives for your papers? ");
        System.out.println("1. Yeah the door is locked");
        System.out.println("2. No i've just been wandering around...");
        
        switch(input.nextInt()){
            case 1:
                System.out.println("Oh it was locked?! You'll need a keycard then");
                System.out.println("I bet you can find a keycard somewhere around here...");
                //Accept quest to get keyCard
                break;
            case 2: 
                System.out.println("You should definitely go check that out..");
                break;
        }
        
        return new BulterDialogueBlock1(this);
        
    }
    
    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
}
