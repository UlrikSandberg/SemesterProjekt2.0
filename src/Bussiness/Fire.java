/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Acquintance.IRoom;
import Bussiness.DialogueBlocks.FireDialogueBlock1;
import Bussiness.DialogueBlocks.FireDialogueBlock2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Markb
 */
public class Fire extends NPC{

    public Fire(String name, String filePath) {
        super(name, filePath);
    }
    
    
    
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        if(player.getInventory().inventoryDoesContain(super.getItem())){
            System.out.println("The pile of money is ablaze");
            System.out.println("1. Throw a paper into the flames");
            System.out.println("2. Do nothing");
            switch(input.nextInt()){
                case 1:
                    System.out.println("The paper goes up into flames"
                            + ", and the fire burns out");
                    super.getItem().decrementAmount(player);
                    super.changeState();
                    break;
                case 2:
                    System.out.println("The fire keeps burning");
            }
        }
*/
        return new FireDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        //System.out.println("The fire is only ashes, and you leave it be");
        return new FireDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        return new BulterDialogueBlock1(this);
    }

    @Override
    public Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
    
}
