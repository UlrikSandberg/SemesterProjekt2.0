/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Acquintance.IRoom;
import Bussiness.DialogueBlocks.ToiletDialogueBlock1;
import Bussiness.DialogueBlocks.ToiletDialogueBlock2;
import Bussiness.DialogueBlocks.ToiletDialogueBlock3;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Markb
 */
public class Toilet extends NPC{

    Toilet(String name, String filePath) {
        super(name, filePath);
    }

        
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("This toilet seems like it would have great flushing");
        System.out.println("1. Flush a paper down the toilet");
        System.out.println("2. Use the toilet like it was ment to be used");
        System.out.println("3. Leave the toilet");
        switch(input.nextInt()){
            case 1:
                System.out.println("You flush a paper, but the toilet is not as good as you thought");
                System.out.println("The toilet is now clogged");
                super.getItem().setAmount(super.getItem().getAmount() - 1);
                super.changeState();
        }
*/
        return new ToiletDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("The toilet is clogged");
        System.out.println("Do you want to take water from the toilet?");
        System.out.println("1. Take water");
        System.out.println("2. Eeehw NO!");
        switch(input.nextInt()){
            case 1:
                player.getInventory().addToInventory(super.getItem());
                System.out.println("You took water from the toilet");
                super.changeState();
                break;
            
            case 2:
                System.out.println("No water taken from the toilet");
                break;
        }
*/
        return new ToiletDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        //System.out.println("The toilet is clogged");
        return new ToiletDialogueBlock3(this);
    }
    
    @Override
    public Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
    
}
