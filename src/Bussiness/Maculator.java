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
import Bussiness.DialogueBlocks.MaculatorDialogueBlock1;
import Bussiness.DialogueBlocks.MaculatorDialogueBlock2;
import java.util.ArrayList;
import java.util.Scanner;
public class Maculator extends NPC {

    Maculator(String name) {
        super(name);
    }
    
    
    //Initialize first contact with NPC
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
          //Checks if you have the respective quest criteria
        if(player.getQuest().contains(super.getCriteria()) == true){
            System.out.println("Beep boop beep!");
            System.out.println("1. Maculate papers");
            System.out.println("2. Leave ");
            switch(input.nextInt()){
                case 1:
                    //Removes bossPapers from inventory and completes quest from officeGuy
                    player.getInventory().inventoryDoesContain(super.getItemCriteria());
                    super.getCriteria().setCompleted();
                    System.out.println("The papers are gone.");
                    System.out.println("Magic...");
                    changeState();
                    break;
                case 2: 
                    //Nothing happens
                    break;
            }
        }else { 
            System.out.println("Beep boop beep!");
        }
*/
        return new MaculatorDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        /*
        System.out.println("Beep boop beep!");
        System.out.println("This machine has had enough paper for today...");
*/
        return new MaculatorDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        //System.out.println("Beep boop beep!");
        //System.out.println("This machine has had enough paper for today...");
        return new BulterDialogueBlock1(this);
    }
    
    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom;
    }
}
