/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness.DialogueBlocks;

import Acquintance.IDialogueBlock;
import Acquintance.INPC;
import Bussiness.NPC;
import Bussiness.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author phillip
 */
public class GuardDialogueBlock2 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private int randomNum;
    private int memNum;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();
    Random rand = new Random();

    public GuardDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("what's your 1'st question", 1);
        caseMapping.put("I'm actually here to tamper with my tax papers. ", 11);
        caseMapping.put("I'm still looking for a toilet. ", 12);
        caseMapping.put("I'm lost, please help me. ", 13);
        caseMapping.put("what's your 2'st question", 2);
        caseMapping.put("Knickers ", 21);
        caseMapping.put("Your mom ", 22);
        caseMapping.put("Get lost, I'm busy ", 23);
        caseMapping.put("what's your 3'st question", 3);
        caseMapping.put("They suck, I'm actually in the middle of tampering with them. ", 31);
        caseMapping.put("I always pay on time, like any decent citizen would! ", 32);
        caseMapping.put("what's your 4'st question", 4);
        caseMapping.put("yeah. ", 41);
        caseMapping.put("My definition of great weather isn't rain ... ", 42);

    }

    public String dialogue(Player player) {
        switch (DialogueBlockState) {

            case 0:
                return this.getIntro();
            case 1:
                return this.case1();
            case 11:
                return this.case11(player);
            case 12:
                return this.case12();
            case 13:
                return this.case13();
            case 2:
                return this.case2();
            case 21:
                return this.case21();
            case 22:
                return this.case22();
            case 23:
                return this.case23(player);
            case 3:
                return this.case3();
            case 31:
                return this.case31(player);
            case 32:
                return this.case32();
            case 33:
//                return this.case33();
            case 4:
                return this.case4();
            case 41:
                return this.case41();
            case 42:
                return this.case42();
            case 43:
//                return this.case43();
        }
        return null;
    }

    public String getIntro() {

        //Info
        String theString = "What are you still doing here? \n"
                + "I'll ask you some questions now. ";

        //Clean up
        this.options.clear();
        randomNum = rand.nextInt() % 3;
        while (randomNum == memNum) {
            randomNum = rand.nextInt() % 3;
        }
        switch (randomNum) {
            case 0:
                this.options.add("what's your 1'st question");
                break;
            case 1:
                this.options.add("what's your 2'st question");
                break;
            case 2:
                this.options.add("what's your 3'st question");
                break;
            case 3:
                this.options.add("what's your 4'st question");
                break;
        }
        memNum = randomNum;

        //Logic
        while (randomNum == rand.nextInt() % 3) {
            owner.changeState();
        }

        return theString;

    }

    private String case1() {

        //Info
        String theString = "what are you still doing here?";

        //Clean up
        this.options.clear();
        this.options.add("I'm actually here to tamper with my tax papers. ");
        this.options.add("I'm still looking for a toilet. ");
        this.options.add("I'm lost, please help me. ");

        return theString;

    }

    private String case11(Player player) {

        //Info
        String theString = "Is that so ... Let's head to the entrance shall we. \n "
                + "GAME OVER";

        //Logic
        player.setLose();

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case12() {

        //Info
        String theString = "Oh, its located at the right side of the building, be sure to leave when you're done. ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case13() {

        //Info
        String theString = "Still lost? As I said last time, its right by the lobby, can't miss it really. ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case2() {

        //Info
        String theString = "Did you see the football game this tuesday, who'd you root for?";

        //Clean up
        this.options.clear();
        this.options.add("Knickers ");
        this.options.add("Your mom ");
        this.options.add("Get lost, I'm busy ");

        return theString;

    }

    private String case21() {

        //Info
        String theString = "yeah, knickers the best aren't they! ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case22() {

        //Info
        String theString = "I was just asking, what a spoilsport ... ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case23(Player player) {

        //Info
        String theString = "Busy with what? things you shouldn't be doing, huh. "
                + "GAME OVER";

        //Logic
        player.setLose();

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case3() {

        //Info
        String theString = "What's your stance on paying taxes";

        //Clean up
        this.options.clear();
        this.options.add("They suck, I'm actually in the middle of tampering with them. ");
        this.options.add("I always pay on time, like any decent citizen would! ");
        this.options.add("Get lost, I'm busy ");

        return theString;

    }

    private String case31(Player player) {

        //Info
        String theString = "Is that so ... Let's head to the entrance shall we. "
                + "GAME OVER";

        //Logic
        player.setLose();

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case32() {

        //Info
        String theString = "What a good man. carry on. ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case4() {

        //Info
        String theString = "What a nice day, huh. ";

        //Clean up
        this.options.clear();
        this.options.add("yeah. ");
        this.options.add("My definition of great weather isn't rain ... ");
        this.options.add("Get lost, I'm busy ");

        return theString;

    }

    private String case41() {

        //Info
        String theString = "Rain really is great. ";

        //Clean up
        this.options.clear();

        return theString;

    }

    private String case42() {

        //Info
        String theString = "Rain's great though! Makes you feel alive ";

        //Clean up
        this.options.clear();

        return theString;

    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void changeState(String i) {
        if (i != null) {
            this.DialogueBlockState = caseMapping.get(i);
        }
    }

}
