/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.GuardDialogueBlock1;
import Bussiness.DialogueBlocks.GuardDialogueBlock2;
import Bussiness.DialogueBlocks.GuardDialogueBlock3;
import Acquintance.IDialogueBlock;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phillipgeisler
 */
public class Guard extends NPC implements IGuard {

    private boolean justTalkedTo;
    private Room guardRoom;
    private int randomNum;
    private int memNum;
    private int i;
    private ArrayList<Room> guardRoomList;
    Random rand = new Random();

    Guard(String name, String filePath) {
        super(name, filePath);
    }

    @Override
    public IDialogueBlock firstContact(Player player) {
//        System.out.println("Hi, I'm the guard here. ");
//        System.out.println("I see you've lost your way, if you want out, it's by the lobby");
//        System.out.println("If I see you again there'll be consequences ... ");
//        
//        super.changeState();
        return new GuardDialogueBlock1(this);
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("What are you still doing here? ");
//        System.out.println("I'll ask you some questions now. ");
//        i = 0;
//        while (i <= 2) {
//            i++;
//            randomNum = rand.nextInt()%3;
//            while (randomNum == memNum) {
//                randomNum = rand.nextInt()%3;
//            }
//            memNum = randomNum;
//            switch(randomNum) {
//                case 0:
//                    System.out.println("what are you still doing here?");
//                    System.out.println("1. I'm actually here to tamper with my tax papers. ");
//                    System.out.println("2. I'm still looking for a toilet. ");
//                    System.out.println("3. I'm lost, please help me. ");
//                    switch(input.nextInt()) {
//                        case 1:
//                            System.out.println("Is that so ... Let's head to the entrance shall we. ");
//                            System.out.println("GAME OVER");
//                            player.setLose();
//                            break;
//                        
//                        case 2:
//                            System.out.println("Oh, its located at the right side of the building, be sure to leave when you're done. ");
//                            break;
//                            
//                        case 3:
//                            System.out.println("Still lost? As I said last time, its right by the lobby, can't miss it really. ");
//                            break;
//                    }
//                    break;
//                
//                case 1:
//                    System.out.println("Did you see the football game this tuesday, who'd you root for?");
//                    System.out.println("1. Knickers ");
//                    System.out.println("2. Your mom ");
//                    System.out.println("3. Get lost, I'm busy ");
//                    switch(input.nextInt()) {
//                        case 1:
//                            System.out.println("yeah, knickers the best aren't they! ");
//                            break;
//                            
//                        case 2:
//                            System.out.println("I was just asking, what a spoilsport ... ");
//                            break;
//                            
//                        case 3:
//                            System.out.println("Busy with what? things you shouldn't be doing, huh. ");
//                            System.out.println("GAME OVER");
//                            player.setLose();
//                            break;
//                    }
//                    break;
//                    
//                case 2:
//                    System.out.println("What's your stance on paying taxes");
//                    System.out.println("1. They suck, I'm actually in the middle of tampering with them. ");
//                    System.out.println("2. I always pay on time, like any decent citizen would! ");
//                    System.out.println("3. Get lost, I'm busy ");
//                    switch(input.nextInt()) {
//                        case 1:
//                            System.out.println("Is that so ... Let's head to the entrance shall we. ");
//                            System.out.println("GAME OVER");
//                            player.setLose();
//                            break;
//                        
//                        case 2:
//                            System.out.println("What a good man. carry on. ");
//                            break;
//                        
//                        case 3:
//                            System.out.println("Busy with what? things you shouldn't be doing, huh. ");
//                            System.out.println("GAME OVER");
//                            player.setLose();
//                            break;
//                    }
//                    break;
//                
//                case 3:
//                    System.out.println("What a nice day, huh. ");
//                    System.out.println("1. yeah. ");
//                    System.out.println("2. My definition of great weather isn't rain ... ");
//                    System.out.println("3. Get lost, I'm busy ");
//                    switch(input.nextInt()) {
//                        case 1:
//                            System.out.println("Rain really is great. ");
//                            break;
//                        
//                        case 2:
//                            System.out.println("Rain's great though! Makes you feel alive ");
//                            break;
//                            
//                        case 3:
//                            System.out.println("Busy with what? things you shouldn't be doing, huh. ");
//                            System.out.println("GAME OVER");
//                            player.setLose();
//                            break;
//                    }
//                    break;
//                
//            }
//        }
//        while (randomNum == rand.nextInt()%3) {
//            super.changeState();
//        }
        return new GuardDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
//        System.out.println("He ponders whether it's worthwhile asking questions ... ");
        return new GuardDialogueBlock3(this);
    }

    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        guardRoomList = new ArrayList();
        for (Room room : guardRooms) {
            guardRoomList.add(room);
        }
        guardRoomList.remove(5);
        guardRoomList.remove(8 - 1);
        guardRoomList.remove(10 - 2);
        randomNum = rand.nextInt(((guardRoomList.size() - 1) - 0) + 1) + 0;
        guardRoom = guardRoomList.get(randomNum);
        return guardRoom;
    }
}
