package Bussiness;
import Acquintance.DirectionType;
import Acquintance.IDataTransfer;
import Acquintance.IHighScore;
import Acquintance.IItem;
import Acquintance.INPC;
import Acquintance.IPlayer;
import Acquintance.IRoom;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

//The public game class constructs the game enviroment, and it's is through this class
//that we acces the other .java files during run time.
public class Game {
    //Private variable to hold the instantiated parser class, instantiated on line ''
    private Parser parser;
    
      
    /* Private Room holds information about which room we are currently in. This is important so
    ** that we may present game options to the userInterface based on respective information
    */
    private Room currentRoom;
    private Room guardRoom;
    private Player player;
    private ArrayList<Room> guardRooms;
    private IHighScore highscore;
    //Rooms
        Room lobby, cafeteria, WestHall, MaleRestroom, FemaleRestroom, EastHall, office, copyRoom, archives, money, utillity;
    
    //NPC's
        INPC steve, cafeteriaLady, officeGuy, maculator, fire, financeGuy, guard, wornLock, talkingToilet, toilet, janitor, taxMan;
        
    //Quest
        Quest steveQuest, cafeteriaLadyQuest, officeGuyQuest, janitorQuest;
        
    //Items
        Item key, paper, drink, food, dress, bossPapers;
        
        
    //
    private CommandWords commandwords;
    
    //
    HashMap<String, IRoom> listOfRooms = new HashMap<>();
    
    
    
    //The constructor of .this(public class Game) - Calling the method createRooms to instantiate
    //the game enviroment and instantiate the parser class
    public Game(String playerName) 
    {
        this.parser = new Parser();
        this.player = new Player(playerName);
        this.guardRooms = new ArrayList();
        this.commandwords = new CommandWords();
        this.highscore = new HighScore();
        createObjects();
        
        
    }

    Game() {
        this.parser = new Parser();
        this.player = new Player();
        this.guardRooms = new ArrayList();
        this.commandwords = new CommandWords();
        this.highscore = new HighScore();
        createObjects();
    }

    //createRoom method creates the game enviroment, which so far is five rooms.
    private void createObjects()
    {
                
        //Create Rooms:
        lobby = new Room("In the main lobby", "/Presentation/AssetsLibrary/Lobby.jpg");
        cafeteria = new Room("in the cafeteria" , "/Presentation/AssetsLibrary/Cafeteria.jpg");
        WestHall = new Room("in the west hallway", "/Presentation/AssetsLibrary/Hallway.jpg");
        EastHall = new Room("in the east hallway", "/Presentation/AssetsLibrary/Hallway.jpg");
        MaleRestroom = new Room("in male restroom", "/Presentation/AssetsLibrary/ToiletMen.jpg");
        FemaleRestroom = new Room ("in the female restroom", "/Presentation/AssetsLibrary/ToiletWomen.jpg");
        office = new Room ("in the office", "/Presentation/AssetsLibrary/officeRoom.jpg"); 
        copyRoom = new Room ("in the copyroom", "/Presentation/AssetsLibrary/Copyroom.jpg");
        archives = new Room ("in the archives", "/Presentation/AssetsLibrary/Archive.jpg");
        money = new Room ("in the financial area", "/Presentation/AssetsLibrary/moneyRoom.jpg");
        utillity = new Room ("in the utillityroom", "/Presentation/AssetsLibrary/Utillity.jpg");
        
        //Create guardRooms: 
        guardRooms.add(lobby);
        guardRooms.add(cafeteria);
        guardRooms.add(WestHall);
        guardRooms.add(EastHall);
        guardRooms.add(MaleRestroom);
        guardRooms.add(FemaleRestroom);
        guardRooms.add(office);
        guardRooms.add(copyRoom);
        guardRooms.add(archives);
        guardRooms.add(money);
        guardRooms.add(utillity);
        
        //Create Room exits
        lobby.setExit(DirectionType.EAST, cafeteria);
        lobby.setExit(DirectionType.WEST, WestHall);

        cafeteria.setExit(DirectionType.WEST, lobby);
        cafeteria.setExit (DirectionType.EAST, EastHall);
        cafeteria.setExit(DirectionType.SOUTH, MaleRestroom);
        cafeteria.setExit(DirectionType.NORTH, FemaleRestroom);

        WestHall.setExit(DirectionType.EAST, lobby);
        WestHall.setExit(DirectionType.NORTH, utillity);
        WestHall.setExit(DirectionType.WEST, archives); //Mulighed for at låse døren op med keycard.
        WestHall.setExit(DirectionType.SOUTH, money);

        EastHall.setExit(DirectionType.WEST, cafeteria);
        EastHall.setExit(DirectionType.NORTH, office);
        EastHall.setExit(DirectionType.EAST, copyRoom);
        
        office.setExit(DirectionType.SOUTH, EastHall);
        
        copyRoom.setExit(DirectionType.WEST, EastHall);
        
        archives.setExit(DirectionType.EAST, WestHall);
        
        money.setExit(DirectionType.NORTH, WestHall);
        
        utillity.setExit(DirectionType.SOUTH, WestHall);
        
        MaleRestroom.setExit(DirectionType.NORTH, cafeteria);
        
        FemaleRestroom.setExit(DirectionType.SOUTH, cafeteria);
        
        //Create items 
        key = new Item("key", "A key to a room");
        paper = new Item("paper", "Your tax papers", 4);
        drink = new Item("drink", "A nice cool beverage");
        food = new Item("food", "A delicious meal");
        dress = new Item("dress", "A very pretty dress");
        bossPapers = new Item("boss' papers", "Some pretty shady papers");
        
        //Create quest
        steveQuest = new Quest(10, "Steve", "Go to the cafeteriaLady");
        cafeteriaLadyQuest = new Quest(10, "cafeteriaLady", "Go back to steve");
        officeGuyQuest = new Quest(10, "officeGuy", "Destroy these papers");
        janitorQuest = new Quest(10, "janitor", "Fetch me piss water");
        
        //Create Inhabitants:
        //Create Inhabitants:
        steve = new Bulter("Bulter", "/Presentation/AssetsLibrary/ButlerSprite4RealMedAnsigt.png");
        cafeteriaLady = new CafeteriaLady("Cafeteria Lady", "/Presentation/AssetsLibrary/CafeteriaLadySprite.jpg");
        officeGuy = new OfficeGuy("Office Guy", "/Presentation/AssetsLibrary/OfficeGuySprite.png");
        maculator = new Maculator("Maculator","/Presentation/AssetsLibrary/Maculator.png");
        fire = new Fire("Fire","/Presentation/AssetsLibrary/Fire.jpg");
        financeGuy = new FinanceGuy("Finance Guy","/Presentation/AssetsLibrary/financeGuy.png");
        guard = new Guard("Guard","/Presentation/AssetsLibrary/Guard.png");
        wornLock = new WornLock("Worn Lock","/Presentation/AssetsLibrary/Lock.png");
        toilet = new Toilet("Toilet","/Presentation/AssetsLibrary/ToiletSprite.gif");
        talkingToilet = new TalkingToilet("Talking Toilet","/Presentation/AssetsLibrary/TalkingToiletSprite.png");
        janitor = new Janitor("Janitor","/Presentation/AssetsLibrary/Janitor.png");
        taxMan = new TaxMan("Tax Man","/Presentation/AssetsLibrary/TaxManSprite2.0.png");
        
        //Set Inhabitants in respective Room:
        lobby.setInhabitant("steve", steve);
        cafeteria.setInhabitant("cafeteriaLady", cafeteriaLady);
        office.setInhabitant("officeGuy", officeGuy);
        copyRoom.setInhabitant("maculator", maculator);
        money.setInhabitant("fire", fire);
        money.setInhabitant("financeGuy", financeGuy);
        MaleRestroom.setInhabitant("guard", guard);
        MaleRestroom.setInhabitant("toilet", toilet);
        FemaleRestroom.setInhabitant("talkingToilet", talkingToilet);
        utillity.setInhabitant("janitor", janitor);
        archives.setInhabitant("taxMan", taxMan);
        
        //Create Room exitBlocks
        WestHall.setExitBlock(DirectionType.WEST, wornLock);
        
        //setQuest
        steve.setQuest(steveQuest);
        cafeteriaLady.setQuest(cafeteriaLadyQuest);
        officeGuy.setQuest(officeGuyQuest);
        janitor.setQuest(janitorQuest);
        
        //setQuestCriteria
        cafeteriaLadyQuest.setCriteria(food);
        janitorQuest.setCriteria(drink);
        
        //set NPC criteria and items
        steve.setItemCriteria(food);
        cafeteriaLady.setCriteria(steveQuest);
        cafeteriaLady.setItem(food);
        steve.setCriteria(cafeteriaLadyQuest);
        officeGuy.setItem(bossPapers);
        fire.setItem(paper);
        financeGuy.setItem(key);
        toilet.setItemCriteria(paper);
        toilet.setItem(drink);
        talkingToilet.setItem(paper);
        taxMan.setItem(paper);
        wornLock.setItem(key);
        
        
        maculator.setCriteria(officeGuyQuest);
        maculator.setItem(bossPapers);
        maculator.setItemCriteria(bossPapers);
        janitor.setItemCriteria(paper);
        janitor.setItem(dress);
        
        //Room for StartGame:
        currentRoom = lobby;
        
        //guard's Room for StartGame:
        guardRoom = MaleRestroom;
       
        //Adds all rooms to collection for saving
        listOfRooms.put("lobby", lobby);
        listOfRooms.put("cafeteria", cafeteria);
        listOfRooms.put("WestHall", WestHall);
        listOfRooms.put("EastHall", EastHall);
        listOfRooms.put("MaleRestroom", MaleRestroom);
        listOfRooms.put("FemaleRestroom", FemaleRestroom);
        listOfRooms.put("office", office);
        listOfRooms.put("copyRoom", copyRoom);
        listOfRooms.put("archives", archives);
        listOfRooms.put("money", money);
        listOfRooms.put("utility", utillity);
        
    }
    
    public IDataTransfer saveObjects() {
        IDataTransfer transfer = new DataTransfer(player, currentRoom, listOfRooms, guardRoom);
                
        System.out.println("Game saved!");
        return transfer;
    }
    
    
    public void loadObjects(IDataTransfer transfer) {
        
        //player.getScore().pauseTimer();
        System.out.println("game.load");        
        HashMap<String, IRoom> rooms = transfer.getRooms();
        
        lobby = (Room) rooms.get("lobby");
        lobby.setImage("/Presentation/AssetsLibrary/Lobby.jpg");
        lobby.getInhabitant("steve").setImage("/Presentation/AssetsLibrary/ButlerSprite4RealMedAnsigt.png");
        cafeteria = (Room) rooms.get("cafeteria");
        cafeteria.getInhabitant("cafeteriaLady").setImage("/Presentation/AssetsLibrary/CafeteriaLadySprite.jpg");
        cafeteria.setImage("/Presentation/AssetsLibrary/Cafeteria.jpg");
        WestHall = (Room) rooms.get("WestHall");
        WestHall.setImage("/Presentation/AssetsLibrary/Hallway.jpg");
        EastHall = (Room) rooms.get("EastHall");
        EastHall.setImage("/Presentation/AssetsLibrary/Hallway.jpg");
        MaleRestroom = (Room) rooms.get("MaleRestroom");
        MaleRestroom.getInhabitant("toilet").setImage("/Presentation/AssetsLibrary/ToiletSprite.gif");
        MaleRestroom.setImage("/Presentation/AssetsLibrary/ToiletMen.jpg");
        FemaleRestroom = (Room) rooms.get("FemaleRestroom");
        FemaleRestroom.getInhabitant("talkingToilet").setImage("/Presentation/AssetsLibrary/TalkingToiletSprite.png");
        FemaleRestroom.setImage("/Presentation/AssetsLibrary/ToiletWomen.jpg");
        office = (Room) rooms.get("office"); 
        office.getInhabitant("officeGuy").setImage("/Presentation/AssetsLibrary/OfficeGuySprite.png");
        office.setImage("/Presentation/AssetsLibrary/officeRoom.jpg");
        copyRoom = (Room) rooms.get("copyRoom");
        copyRoom.getInhabitant("maculator").setImage("/Presentation/AssetsLibrary/Maculator.png");
        copyRoom.setImage("/Presentation/AssetsLibrary/Copyroom.jpg");
        archives = (Room) rooms.get("archives");
        archives.getInhabitant("taxMan").setImage("/Presentation/AssetsLibrary/TaxManSprite2.0.png");
        archives.setImage("/Presentation/AssetsLibrary/Archive.jpg");
        money = (Room) rooms.get("money");
        money.getInhabitant("financeGuy").setImage("/Presentation/AssetsLibrary/financeGuy.png");
        money.getInhabitant("fire").setImage("/Presentation/AssetsLibrary/Fire.jpg");
        money.setImage("/Presentation/AssetsLibrary/moneyRoom.jpg");
        utillity = (Room) rooms.get("utility");
        utillity.getInhabitant("janitor").setImage("/Presentation/AssetsLibrary/Janitor.png");
        utillity.setImage("/Presentation/AssetsLibrary/Utillity.jpg");
       
        guardRoom = (Room) transfer.getGuardRoom();
        guardRoom.getInhabitant("guard").setImage("/Presentation/AssetsLibrary/Guard.png");
        
        player = (Player) transfer.getPlayer();
        
        currentRoom = (Room) transfer.getCurrentRoom();
        
        player.setScore(player.getScore().getElapsedTime(), player.getScore().getScore(), player.getScore().getHintCost());
        
        player.getScore().beginTimer();
        //System.out.println(currentRoom.getLongDescription());
    }

    public INPC getExitBlock(DirectionType direction) {
        
        return currentRoom.getExitBlock(direction);
        
    }
    
    
    IPlayer getPlayer() {
        return this.player;
    }
    
    public Player getPlayerRoot() {
        return this.player;
    }
    
    IRoom getCurrentRoom() {
        return this.currentRoom;
    }
    
    
    //Execute play method - Invoked from StartGame.java
    public void play() 
    {            
                printWelcome();//Execute printWelcome method.
                this.player.getScore().beginTimer();

        //Setting gameState as a boolean value, in can determine game state by true and false
        boolean finished = false; //False game state means the game is running
        //We start the game loop as a while false loop that continues until game state is changed
        //to (finished = true;)
        while (! finished) {
            //Invoke our instantiated parser class to prompt user to enter commands
            //which returns a Command object which we can use to proces the users input.
            Command command = parser.getCommand();
            //Invoke method processCommand by parsing the command object as an argument.
            //this statement expect a boolean in return which will decide whether the game loop
            //should continue.
            finished = processCommand(command);
            if(finished == false){
                finished = player.didLose();
                if(finished == false){
                    finished = player.didWin();
                }
            }
        }
        
        //print final score and time spend.
        player.getScore().pauseTimer();
        if(player.didWin()){
            player.getScore().totalScore();
        }
        System.out.println("Thank you for playing.  Good bye.");
        }

    //this method is called upon game start to welcome the user
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome Tax-Fraud!");
        System.out.println("Tax-Fraud is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Your commands words are:");
        this.parser.showCommands();
        System.out.println();
        //System.out.println(currentRoom.getLongDescription()); //Provide the userInterface with game
        //options depending on the currentRoom - In this case it will allways be the starting room.
    }

    //Method to process the users command - should return a boolean depending
    //on the processed command, if true the game should end if false the game should continue
    private boolean processCommand(Command command) 
    {
        //As default wantToQuit value has been set to false so the game continues if nothing else is declared
        boolean wantToQuit = false;
        //Set a the value commandWord(from public Enum) equal to the commandword from the command object
        //parsed in the method argument, this command object has just been created through parser and we fetch this
        //objets commandword through a getterMethod
        CommandInterface commandWord = command.getCommandWord();

        //We now check for several conditionals
        //Quit if commandWord is equal to UNKNOWN
        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        
        //Print all command words see printHelp method for additional explenation
        if (commandWord == CommandWord.HELP) {
            //printHelp();
        }
        //If the commandword is go then call goRoom method with argument of the command object.
        else if (commandWord == CommandWord.GO) {
            //goRoom(command);
        }
        
        else if (commandWord == CommandWord.SHOW) {
            //showContent(command);
        }
        
        else if (commandWord == CommandWord.TALK) {
            //interact(command);
        }
        //If the commandword is quit then call quit method with argument of the command object.
        else if (commandWord == CommandWord.QUIT) {
            //wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.TAKE) {
            //takeRoomObject(command);
        }
        else if (commandWord == CommandWord.SAVE) {
            saveObjects();
        }
        else if (commandWord == CommandWord.LOAD) {
            //loadObjects(transfer);
        }
        return wantToQuit;
    }

    //Print out all the commands from our CommandWords.java class instance.
    //Loop through the hashMap containing our coomandwords and print them.
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the Tax offices.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println(player.getScore().getElapsedTime());
    }

    //Decide which room we should go to if any at all?
    public Boolean goRoom(DirectionType direction) 
    {
        //Acces the command object and use its hasSecondWord method to received boolean - If true
        //do nothing? else return false and ask "Go where"?
        /*
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        */
        //Acces the command object and extract the second words containing direction with the getter method.
        //String direction = command.getSecondWord();

        //Set$$$$$$$$$ xet nextroom equal to the value received from the getter method which checks the respectives rooms
        //hashmap to acces whether the direction has a corresponding room.
        Room nextRoom = currentRoom.getExit(direction);
        INPC exitBlock = currentRoom.getExitBlock(direction);
        
        System.out.println("So far so good");
        //if nextRoom returned was equal to null since the direction was non existing in the respective rooms hashMap
        //Inform the user that the direction they choose is invalid.
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        
        } else { //Since the chosen direction is valid, this means that nextRoom has been set to a new valid room
                // therefor set currentRoom to the newRoom and run the newRooms, roomDescription 
            if (exitBlock == null) {
                currentRoom = nextRoom;
                this.player.setCurrentRoom(currentRoom);
                INPC currentGuard = guardRoom.getInhabitant("guard");
                guardRoom.removeInhabitant("guard");
                guardRoom = currentGuard.relocateGuard(guardRooms, guardRoom);
                guardRoom.setInhabitant("guard", currentGuard);
                //System.out.println(currentRoom.getLongDescription());
               
                if (guardRoom == currentRoom) {
                    //currentGuard.dialogue(this.player);
                }
                return true;
            } else {
                //exitBlock.dialogue(this.player);
                return false;
            }
        }
        
       return false;
    }
    
    private void showContent(Command command) {
        
        //Acces the command object and use its hasSecondWord method to received boolean - If true
        //do nothing? else return false and ask "Go where"?
        if(!command.hasSecondWord()) {
            System.out.println("Show what?");
            return;
        }
        
        
        //We acces the second word!
        String contentOff = command.getSecondWord();
        Command showCommand = new Command(this.commandwords.getSecondCommandWord(contentOff), null);
        CommandInterface commandWord = showCommand.getCommandWord();
        
        if(commandWord == showCommands.INVENTORY) {
            inventoryContent();
        } else if(commandWord == showCommands.QUEST) {
            questsContent();
        } else if(commandWord == showCommands.ROOM) {
            roomContent();
        }
            
    }
    
    public void inventoryContent() {
        Scanner input = new Scanner(System.in);
        Boolean isChoosing = true;
        while(isChoosing == true) {
        
            Inventory inventory = this.player.getInventory();
            inventory.inventoryContents();
            System.out.println("To inspect an item enter the desired index. Enter 0 to quit:");
            int choice = input.nextInt();
            switch(choice) {
                case 0:
                    isChoosing = false;
                    break;
                
                default:
                    
                    if(this.player.getInventory().hasIndex(choice) == true) {
                        IItem item = this.player.getInventory().getItemAtIndex(choice);
                        Boolean isInspecting = true;
                        while(isInspecting == true) {
                        
                            System.out.println("You have chosen item: "+ item.getName());
                            System.out.println("You have the following options:");
                            System.out.println("0. Go back");
                            System.out.println("1. get description");
                            System.out.println("2. get amount");
                            System.out.println("3. drop");
                            switch(input.nextInt()) {
                                case 0:
                                    isInspecting = false;
                                    break;   
                                case 1:
                                    item.getDescription();
                                    break;
                                case 2:
                                    item.printAmount();
                                    break;
                                case 3:
                                    this.player.getInventory().removeFromInventory(item);
                                    this.currentRoom.addItemToRoom(item);
                                    isInspecting = false;
                                    break;
                            
                            }
                        }
                    } else {
                        System.out.println("There is no items at the desired index");
                    }
                    break;
            }
        }
        input.close();
    }
    
    public void questsContent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Show quests"); 
        Boolean isChoosing = true;
        while(isChoosing == true) {
            
            System.out.println("To inspect an item enter the desired index. Enter 0 to quit:");
            this.player.showQuests();
            int choice = input.nextInt();
            switch(choice) {
                case 0:
                    
                    isChoosing = false;
                    
                    break;
                default:
                    
                    if(this.player.questHasIndex(choice) == true) {
                        
                        Quest quest = this.player.questAtIndex(choice);
                        Boolean isInspecting  = true;
                        while(isInspecting == true) {
                            System.out.println("You have chosen quest: "+ quest.getName());
                            System.out.println("You have the following options:");
                            System.out.println("0. Go back");
                            System.out.println("1. get description");
                            switch(input.nextInt()) {
                                case 0:
                                    isInspecting = false;
                                    break;
                                case 1:
                                    System.out.println(quest.getDescription());
                                    break;
                            }     
                        }
    
                    }
 
                    break;
            }
      
        }
        input.close();
    }
    
    public void roomContent() {
    
        System.out.println("show room content");
        this.currentRoom.getRoomContennt();
        
    }
    
    
    public void takeRoomObject(Command command) {
        
         if(!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        
        
        //We acces the second word!
        String secondWord = command.getSecondWord();
        System.out.println(secondWord);
        IItem item = this.currentRoom.getItem(secondWord);
        System.out.println(item.getName());
        
        
        if(item == null) {
            System.out.println("There are no such items in this room");
        } else {
            
            //Check if the player capacity is exceed if so print not enough space
            if(this.player.getInventory().addToInventory((Item) item) == true) {
                //We added to inventory remove from room
                this.currentRoom.removeItemFromRoom(item.getName());
    
            } else {
                System.out.println("Not enough space in inventory");
            }    
        }    
    }
    
    public IHighScore getHighscore(){
        return highscore;
    }
    
    void loadHighscore(IHighScore loadHighScore) {
        highscore = loadHighScore;
    }
    
    private void interact(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Talk to who?");
            return;
        }
        
        String subjectname = command.getSecondWord();

        INPC currentSubject = currentRoom.getInhabitant(subjectname);
        
        if (currentSubject == null) {
            System.out.println("There is no person!");
        
        } else { 
             currentSubject.dialogue(this.player);
        }
    }
    
    //Check if the game really should end :)
    private boolean quit(Command command) 
    {
        //Reach into the command object and use its hasSecondWord method to received boolean - If true
        //return quit what? else return false and end the game loop
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

}
