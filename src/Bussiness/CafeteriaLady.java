/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Bussiness.DialogueBlocks.CafeteriaLadyDialogueBlock1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ulriksandberg
 */
public class CafeteriaLady extends NPC {

    CafeteriaLady(String name) {
        super(name);
    }

    

        
    
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner scan = new Scanner(System.in);
        
        System.out.println("I am the cafeteria lady!");
        if(player.isQuestComplete(super.getCriteria()) == true) {
            System.out.println("What can I help you with?");
            System.out.println("Answer the cafeteriaLady");
            System.out.println("1. The guy in the lobby aksed me to get a sandwich. Do you have one?");
            System.out.println("2. I don't need anything right now.");
            
            switch(scan.nextInt()) {
                case 1:
                    super.changeState();
                    System.out.println("sure! Here you go. I'll jut put it on his tap.");
                    player.getInventory().addToInventory(super.getItem());
                    super.getQuest().setInitialized();
                    player.setQuest(super.getQuest());
                    
                    System.out.println("You just recieved a sandwich.");
                    break;
                case 2:
                    System.out.println("Oh, okay. Then why would you talk to me?");
                    break;
            }
            
        }   
*/
        return new CafeteriaLadyDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        //System.out.println("You allready received my quest! Leave me alone! LOL");
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
