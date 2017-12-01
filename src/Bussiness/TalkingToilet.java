/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Justus
 */
public class TalkingToilet extends NPC {

    public TalkingToilet(String name) {
        super(name);
    }
    
    //Initialize first contact with talking toilet
    @Override
    public IDialogueBlock firstContact(Player player) {
        
        Scanner input = new Scanner(System.in);
        
        //Check if your inventory contains respective item
        if(player.getInventory().inventoryDoesContain(super.getItem())== true){
        System.out.println("The toilet flushes, and it smells like flowers...");
        System.out.println("Hello miss. Welcome back to the magical and wonderful realm of women's toilets");
        System.out.println("Would you like a massage for todays treatment?");
        System.out.println("1. Shut that toilet. (Stick a paper down its throat)");
        System.out.println("2. You feel like doing some manly toilet-stuff...");
        
        switch(input.nextInt()){
            case 1:
                //Remove one paper from your inventory
                super.getItem().setAmount(super.getItem().getAmount() - 1);
                System.out.println("*You stick a paper down the toilet*");
                System.out.println("What *mrglmrgllrmgr* are you *rmgrlmg* doing?!");
                System.out.println("You're no *rmglmrmgl* woman! You vile beast!!");
                super.changeState();
                break;
            case 2:
                System.out.println("Phew it smells in here...");
                break;
                
            }
        
        } else{
              System.out.println("Welcome to the magical realm of women's toilets");
              System.out.println("1. Fart");
              System.out.println("1. Burp");
              
              switch(input.nextInt()){
                  case 1:
                      System.out.println("You make a humongous fart. Maybe the biggest of your life");
                      System.out.println("The talking toilet is speechless...");
                      break;
                  case 2:
                      System.out.println("You burp in the womens toilet. Take that, women!");
                      break;
              }
                }
        return new BulterDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        System.out.println("The toilet is all clogged up with your tax-papers.");
        System.out.println("It doesn't seem to wanna talk to you anymore");
        return new BulterDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        return new BulterDialogueBlock1(this);
    }

    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
    
    
    
}
