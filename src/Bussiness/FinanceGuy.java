/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Bussiness.DialogueBlocks.FinanceGuyDialogueBlock1;
import Bussiness.DialogueBlocks.FinanceGuyDialogueBlock2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Markb
 */
public class FinanceGuy extends NPC {

    public FinanceGuy(String name, String filePath) {
        super(name, filePath);
    }

    
    
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("He just keeps starring at the fire.");
        System.out.println("He doesn't seem to be affected by your presence.");
        System.out.println("You see a keycard hanging out of his backpocket");
        System.out.println("1. Steal the keycard");
        System.out.println("2. Leave him alone with his starring");
        switch(input.nextInt()){
            case 1:
                System.out.println("You grab the keycard without him noticing or caring");
                if(player.getInventory().addToInventory(super.getItem())){
                    System.out.println("Key added to inventory");
                    super.changeState();
                }
                else
                    System.out.println("You don't have space for the key");
                break;
            case 2:
                System.out.println("He keeps standing there without a care in the world");
                break;
        }
*/
        return new FinanceGuyDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        System.out.println("He is still just standing there. "
                + "He might be retarded. That would explain a lot");
        return new FinanceGuyDialogueBlock2(this);
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
