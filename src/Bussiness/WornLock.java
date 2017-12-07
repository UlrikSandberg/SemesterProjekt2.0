/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Bussiness.DialogueBlocks.WornLockDialogueBlock1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author phillip
 */
public class WornLock extends NPC{

    WornLock(String name, String filePath) {
        super(name, filePath);
    }

        
    
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("I'm a lock");
        if (player.getInventory().inventoryDoesContain(super.getItem()) == false) {
            System.out.println("get the key");
        } else {
            
            System.out.println("You have the following options:");
            System.out.println("1. Unlock the door");
            System.out.println("2. Go Another way");
            switch(input.nextInt()) {
                
                case 1:
                    player.getInventory().removeFromInventory(super.getItem());
                    player.getCurrentRoom().removeExitBlock("west");
                    System.out.println("The door is unlocked you can now go through");
                    break;
                
                case 2:
                    System.out.println("You went away");
                    break;
            }
        }
*/
        return new WornLockDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        return null;
        
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        return null;
        
    }

    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
}
