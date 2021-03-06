/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquintance.DirectionType;
import Acquintance.IBussiness;
import Acquintance.IDialogueBlock;
import Acquintance.IItem;
import Acquintance.INPC;
import Acquintance.IPlayer;
import Bussiness.Player;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLGameSceneController implements Initializable {

    private IBussiness business;
    private IItem[] listOfItems;
    private ArrayList<IItem> roomItems;
    private HashMap<IItem, ImageView> itemNodes;
    private ArrayList<INPC> roomNPCS;
    private HashMap<INPC, ImageView> NPCNodes;
    private IItem selectedItem = null;
    private IDialogueBlock currentDialogue = null;
    private ArrayList<String> answerOptions;
    private String selectedAnswer = null;
    private Boolean dialogueIsActive = true;

    @FXML
    private AnchorPane gameAnchor;
    @FXML
    private AnchorPane hudAnchor;
    @FXML
    private ImageView player;
    @FXML
    private ImageView westDoor;
    @FXML
    private ImageView southDoor;
    @FXML
    private ImageView northDoor;
    @FXML
    private ImageView eastDoor;
    @FXML
    private Label playerName;
    @FXML
    private ListView<String> inventoryList;
    @FXML
    private Label inventoryLabel;
    @FXML
    private Label currentRoom;
    @FXML
    private TextFlow DialogueTextFlow;
    @FXML
    private Label DialogueLabel;
    @FXML
    private MenuItem SaveAndExit;
    @FXML
    private MenuItem ExitWithoutSaving;
    @FXML
    private MenuButton OptionsButtonMenu;
    @FXML
    private Button dropItemBtn;
    @FXML
    private AnchorPane dialogueScene;
    @FXML
    private ImageView NPCCloseUpImg;
    @FXML
    private TextArea dialogueTextArea;
    @FXML
    private Label NPCName;
    @FXML
    private Button answerBtn;
    @FXML
    private ListView<String> answersListView;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private AnchorPane winScene;
    @FXML
    private ImageView winSceneImage;
    @FXML
    private Button highScore;
    @FXML
    private Button restart;
    @FXML
    private Button exitToMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Hide all exits!
        this.itemNodes = new HashMap<IItem, ImageView>();
        this.roomItems = new ArrayList<>();
        this.NPCNodes = new HashMap<INPC, ImageView>();
        this.roomNPCS = new ArrayList<>();
        this.answerOptions = new ArrayList<>();
        westDoor.setVisible(false);
        eastDoor.setVisible(false);
        northDoor.setVisible(false);
        southDoor.setVisible(false);

        business = UI.getInstance().getBusiness();
        playerName.setText(business.getPlayer().getPlayerName());
        gameAnchor.setStyle("-fx-background-color: red;");
        hudAnchor.setStyle("-fx-background-color: white;");
        dialogueScene.setStyle("-fx-background-color: gray;");
        dialogueScene.setVisible(false);

        winScene.setVisible(false);
        setInventoryList();
        setExits();

    }

    //Player movement controlls
    @FXML
    private void keyPressed(KeyEvent event) {

        switch (event.getCode()) {
            case UP:
                this.goUp();
                break;
            case DOWN:
                this.goDown();
                break;
            case RIGHT:
                this.goRight();
                break;
            case LEFT:
                this.goLeft();
                break;
        }

    }

    //Loads Player inventory to listview
    /**
     * 
     * Display the current players inventory content and displays toString method in a listview
     * 
     */
    private void setInventoryList() {

        //Fetch current buildings
        listOfItems = business.getInventory();

        //Convert objects to string for insertion in listview
        ObservableList<String> data = FXCollections.observableArrayList();
        for (IItem name : listOfItems) {
            data.add(name.toString());
        }

        //Set converted toString object into listView
        this.inventoryList.setItems(data);

        if (listOfItems.length == 0) {
            inventoryLabel.setText("There are currently no items in your inventory");
        }
    }

    //Player movement in GUI
    /**
     * 
     * goRight is one of 4 go methods which all moves the player 20 pixels in 
     * the respective direction. Go right allocate player + 20 pixels on the x-axis.
     * 
     */
    private void goRight() {

        double newY = this.player.getBoundsInParent().getMinY();
        double newX = this.player.getBoundsInParent().getMinX() + 20;
        if (newX > gameAnchor.getWidth() - 20 - this.player.getBoundsInParent().getWidth()) {
            newX = gameAnchor.getWidth() - 20 - this.player.getBoundsInParent().getWidth();
        }
        this.player.relocate(newX, newY);
        this.detectCollision();

    }

    //Player movement in GUI
    private void goLeft() {

        double newY = this.player.getBoundsInParent().getMinY();
        double newX = this.player.getBoundsInParent().getMinX() - 20;
        if (newX < gameAnchor.getBoundsInParent().getMinX() + 20) {
            newX = gameAnchor.getBoundsInParent().getMinX() + 20;
        }
        this.player.relocate(newX, newY);
        this.detectCollision();

    }

    //Player movement in GUI
    private void goUp() {

        double newY = this.player.getBoundsInParent().getMinY() - 20;
        double newX = this.player.getBoundsInParent().getMinX();
        if (newY < 20) {
            newY = 20;
        }
        this.player.relocate(newX, newY);
        this.detectCollision();
    }

    //Player movement in GUI
    private void goDown() {

        double newY = this.player.getBoundsInParent().getMinY() + 20;
        double newX = this.player.getBoundsInParent().getMinX();
        if (newY > this.gameAnchor.getBoundsInParent().getHeight() - 20 - this.hudAnchor.getBoundsInParent().getHeight() - this.player.getBoundsInParent().getHeight()) {
            newY = this.gameAnchor.getBoundsInParent().getHeight() - 20 - this.hudAnchor.getBoundsInParent().getHeight() - this.player.getBoundsInParent().getHeight();
        }
        this.player.relocate(newX, newY);
        this.detectCollision();

    }

    //Collition detection to activate NPC interaction with Player
    /**
     * 
     * Detects if the currentPlayers ImageView node collides with either
     * doors, items or NPC. If Collision is true with exits -> goNextRoom is called.
     * If collision with NPC is true -> dialogueScene is called
     * If Collision with items -> takeItem is called
     * 
     */
    private void detectCollision() {

        if (player.getBoundsInParent().intersects(eastDoor.getBoundsInParent())) {

            if (this.eastDoor.isVisible() != false) {
                if (business.goNextRoom(DirectionType.EAST)) {
                    setExits();
                } else { //There is an exit blocking the way
                    INPC lock = business.getExitNPC(DirectionType.EAST);
                    dialogueScene(lock, business.getPlayer());
                }
            }
        } else if (player.getBoundsInParent().intersects(westDoor.getBoundsInParent())) {
            if (this.westDoor.isVisible() != false) {
                if (business.goNextRoom(DirectionType.WEST)) {
                    setExits();
                } else { //There is an exit blocking the way
                    INPC lock = business.getExitNPC(DirectionType.WEST);
                    dialogueScene(lock, business.getPlayer());
                }
            }
        } else if (player.getBoundsInParent().intersects(northDoor.getBoundsInParent())) {
            if (this.northDoor.isVisible() != false) {
                if (business.goNextRoom(DirectionType.NORTH)) {
                    setExits();
                } else { //There is an exit blocking the way
                    INPC lock = business.getExitNPC(DirectionType.NORTH);
                    dialogueScene(lock, business.getPlayer());
                }
            }
        } else if (player.getBoundsInParent().intersects(southDoor.getBoundsInParent())) {
            if (this.southDoor.isVisible() != false) {
                if (business.goNextRoom(DirectionType.SOUTH)) {
                    setExits();
                } else { //There is an exit blocking the way
                    INPC lock = business.getExitNPC(DirectionType.SOUTH);
                    dialogueScene(lock, business.getPlayer());
                }
            }
        }

        //Detect collision if items exist in rooms
        if (roomItems.size() > 0) {

            for (IItem item : roomItems) {
                if (this.itemNodes.get(item) != null) {
                    ImageView itemNode = this.itemNodes.get(item);
                    if (player.getBoundsInParent().intersects(itemNode.getBoundsInParent())) {
                        System.out.println("Should pickup: " + item.toString());
                        if (UI.getInstance().getBusiness().takeItem(item)) {
                            this.removeItemFromScene(item);
                            this.setInventoryList();
                            this.itemNodes.remove(item);
                        }
                    }
                }
            }
        }

        if (roomNPCS.size() > 0) {

            for (INPC npc : roomNPCS) {
                if (this.NPCNodes.get(npc) != null) {
                    ImageView npcNode = this.NPCNodes.get(npc);
                    if (player.getBoundsInParent().intersects(npcNode.getBoundsInParent())) {
                        System.out.println("Should begin dialog with: " + npc.getName());
                        //npc.dialogue((Player) UI.getInstance().getBusiness().getPlayer());
                        this.dialogueScene(npc, UI.getInstance().getBusiness().getPlayer());

                    }
                }
            }
        }
    }

    //Dialogue-popup scene
    /**
     * 
     * When engaging a NPC, this start the dialogueScene and begin the dialogue loop
     * 
     * @param npc the NPC which we are about to start dialogue with
     * @param player the current player
     */
    private void dialogueScene(INPC npc, IPlayer player) {

        System.out.println("Should open dialogue box for npc: " + npc.getName());
        dialogueScene.setVisible(true);
        answerBtn.setText("Answer");
        //Set image and npc name!
        this.dialogueIsActive = true;
        NPCCloseUpImg.setImage(npc.getImage());
        NPCName.setText(npc.getName());
        dialogueTextArea.setText("Hello");
        //npc.dialogue((Player)player);
        this.currentDialogue = npc.dialogue((Player) player);
        this.DialogueLoop(currentDialogue, null, (Player) player);
        this.dialogueScene.toFront();
        

    }

    //Dialogue between NPC and Player + Win/Lose-scene
    /**
     * 
     * Controller of the dialogue loop, each time we call this method it as an answer to
     * the current dialogue, and we call this method with an answer to the previous loop
     * 
     * 
     * @param currentDialogue the current dialogue block fetched from businessLayer
     * respective to the NPC current dialogueBlockState
     * @param answer the answer the player has given the current active dialogue
     * @param player the current player.
     */
    private void DialogueLoop(IDialogueBlock currentDialogue, String answer, Player player) {

        //Change state according to the given answer
        currentDialogue.changeState(answer);
        dialogueTextArea.setText(currentDialogue.dialogue((Player) player));
        answerOptions = currentDialogue.getOptions();
        ObservableList<String> data = FXCollections.observableArrayList();
        System.out.println(answerOptions.size());
        if (answerOptions.size() == 0) {
            this.dialogueIsActive = false;
            answerBtn.setText("Leave conversation");
        }
        //Populate dropdown with answer options
        for (String answers : answerOptions) {
            String newString = answers;
            data.add(newString);
        }
        //Set converted toString object into listView
        this.answersListView.setItems(data);
        this.setInventoryList();
        
        
        if(player.didWin()) {
            try {
                business.checkHighscore();
            } catch (IOException ex) {
                System.out.println("checkHS IOExeption");
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("checkHS ClassNotFoundExeption");
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());
            }
            try {
                business.saveHighscore();
            } catch (IOException ex) {
                System.out.println("saveHS IOExeption");
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());            
            } catch (ClassNotFoundException ex) {
                System.out.println("saveHS IOExeption");
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());            
            }
            
            System.out.println("The player won the game how awesome!");
            winScene.setVisible(true);
        }
        //Game Lost
        if (player.didLose()) {
            System.out.println("The palyer lost the game how awesome!");
            winScene.setVisible(true);

        }

    }

    //Marks the inventory item clicked on by Player
    @FXML
    private void setFocusForGameScene(MouseEvent event) {
        ObservableList<String> selected;
        selected = inventoryList.getSelectionModel().getSelectedItems();
        int IP = inventoryList.getSelectionModel().getSelectedIndex();
        this.selectedItem = this.listOfItems[IP];

        System.out.println("We selected item: " + this.selectedItem.getName());

    }

    //Options for leaving current room
    
    
    /**
     * 
     * Render the current view, by downloading list of NPC, Exits, Items.
     * Rendering the different objects require calls to spawn NPC, spawn items
     * 
     * 
     */
    private void setExits() {

        System.out.println("Setting exits");

        //Clear room contet
        westDoor.setVisible(false);
        eastDoor.setVisible(false);
        northDoor.setVisible(false);
        southDoor.setVisible(false);

        for (IItem item : roomItems) {
            this.removeItemFromScene(item);
        }
        if (itemNodes.isEmpty() == false) {
            this.itemNodes.clear();
        }
        if (roomItems.isEmpty() == false) {
            this.roomItems.clear();
        }

        for (INPC npc : roomNPCS) {
            this.removeNPCFromScene(npc);
        }

        if (NPCNodes.isEmpty() == false) {
            this.NPCNodes.clear();
        }
        if (roomNPCS.isEmpty() == false) {
            this.roomNPCS.clear();
        }

        currentRoom.setText(business.getCurrentRoom().getShortDescription());

        backgroundImage.setImage(business.getCurrentRoom().getImage());

        //Fetch exits for currentRoom
        ArrayList<DirectionType> list = business.getExists();
        System.out.println(list.size());
        for (DirectionType type : list) {
            System.out.println(type.toString());
        }

        if (list.contains(DirectionType.EAST)) {
            eastDoor.setVisible(true);
        }
        if (list.contains(DirectionType.WEST)) {
            westDoor.setVisible(true);
        }
        if (list.contains(DirectionType.SOUTH)) {
            southDoor.setVisible(true);
        }
        if (list.contains(DirectionType.NORTH)) {
            northDoor.setVisible(true);
        }

        //Fetch items from the current room
        roomItems = business.getRoomItems();
        System.out.println(roomItems.size());
        //Spawn a random imageView on the field for each item currently in the room
        for (IItem item : roomItems) {
            this.spawnItemOnScene(item);
        }

        //Spawn NPC on scene relative to the
        //Fetch NPCs to spawn
        ArrayList<INPC> listOfNPCS = UI.getInstance().getBusiness().getRoomNPCS();
        System.out.println("In this room there is: " + listOfNPCS.size() + " NPCs, they are!");
        int numberOfNPCS = 0;
        for (INPC npc : listOfNPCS) {
            numberOfNPCS += 1;
            System.out.println(npc.getName());
            this.roomNPCS.add(npc);
            this.spawnNPCOnScene(npc, numberOfNPCS);
        }
        
        this.setInventoryList();

        //Set player in the middle of the screen!
        player.relocate(500, 200);

        if(listOfNPCS.contains(business.getGuard())) {
            dialogueScene(business.getGuard(), business.getPlayer());
        }
    }

    //Spawns respective NPC('s) when entering a new room
    /**
     * 
     * Spawns and NPC on the anchorScene. It offsets the next NPC by amount * the
     * NPC number. As far as possible the NPC is spawned at the side with no doors.
     * 
     * @param npc the npc which we want spawned on the scene
     * @param number the number of the particular NPC
     */
    private void spawnNPCOnScene(INPC npc, int number) {

        ImageView newImage = new ImageView(npc.getImage());

        this.NPCNodes.put(npc, newImage);

        gameAnchor.getChildren().add(newImage);
        newImage.relocate(newImage.getBoundsInParent().getMinX() + (number * 300), 0);

        if (eastDoor.isVisible() && !westDoor.isVisible()) { //Check if opposite is visible if not 
            System.out.println("Should spawn NPC left");
        } else if (westDoor.isVisible() && !eastDoor.isVisible()) { //Check if opposite is visible if not 
            System.out.println("Should spawn NPC right");
        } else if (southDoor.isVisible() && !northDoor.isVisible()) { //Check if opposite is visible if not 
            System.out.println("Should spawn NPC up");
        } else if (northDoor.isVisible() && !southDoor.isVisible()) { //Check if opposite is visible if not 
            System.out.println("Should spawn NPC down");
        } else if (northDoor.isVisible() && southDoor.isVisible()) { //Check if npc should be spawned on the sides!
            System.out.println("Should spawn npc at the sides!");
        } else if (eastDoor.isVisible() && westDoor.isVisible()) { //Check if npc should be spawned up or down
            System.out.println("Should spawn npc at bot or top");
        }

    }

    //Despawns the Items from current room when going to a new room
    /**
     * 
     * Find the corresponding ImageView to the respective item and removes the node
     * from the gameAnchor scene.
     * 
     * @param item Item to remove from scene
     */
    private void removeItemFromScene(IItem item) {

        ImageView itemToRemove = this.itemNodes.get(item);
        gameAnchor.getChildren().remove(itemToRemove);
    }

    //Despawns the NPC when going to new scene
    /**
     * 
     * Finds the corresponding ImageView to the respective NPC and removes the node
     * from the gameAnchor scene.
     * 
     * @param npc NPC to remove from scene
     * 
     */
    private void removeNPCFromScene(INPC npc) {

        ImageView itemToRemove = this.NPCNodes.get(npc);
        gameAnchor.getChildren().remove(itemToRemove);

    }

    private void selectItem() {

    }

    //Spawn Items in current room
    /**
     * 
     * Spawn the desired item on the scene. The item will be spawned randomly
     * within bounds of the screen matching the inner rectangle of the exit doors.
     * 
     * 
     * @param item the items whitch we desire to spawn on the scene
     */
    private void spawnItemOnScene(IItem item) {

        ImageView newImage = new ImageView(new Image(getClass().getResourceAsStream("/Presentation/AssetsLibrary/Key-PNG-Image.png")));
        gameAnchor.getChildren().add(newImage);

        //Create game bounds for creation of objects! 
        int leftBounds = (int) this.westDoor.getBoundsInParent().getMaxX() + 10;
        int rightBounds = (int) ((int) this.eastDoor.getBoundsInParent().getMinX() - 10 - newImage.getBoundsInParent().getWidth());
        int upperBounds = (int) this.northDoor.getBoundsInParent().getMaxY() + 10;
        int lowerBounds = (int) this.southDoor.getBoundsInParent().getMinY() - 10;

        int xRange = (int) (Math.random() * ((rightBounds - leftBounds) + 1) + leftBounds);
        int yRange = (int) (Math.random() * ((upperBounds - lowerBounds) + 1) + lowerBounds);

        newImage.relocate(xRange, yRange);
        this.itemNodes.put(item, newImage);

    }

    //Save the game and exit to main menu
    @FXML
    private void saveAndExit(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        business.saveGame();

        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLTaxFraudMainMenu.fxml"));

        Scene newScene = new Scene(adminScene);
        Stage appStage = (Stage) ((Node) southDoor).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();

    }
    
    //Exit game to main menu without saving
    @FXML
    private void exitNoSave(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {

        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLTaxFraudMainMenu.fxml"));

        Scene newScene = new Scene(adminScene);
        Stage appStage = (Stage) ((Node) southDoor).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();

    }

    //Drop marked Item
    @FXML
    private void dropItemAction(ActionEvent event) {

        if (this.selectedItem != null) {

            UI.getInstance().getBusiness().getCurrentRoom().addItemToRoom(selectedItem);
            UI.getInstance().getBusiness().removePlayerItem(selectedItem);
            this.spawnItemOnScene(selectedItem);
            this.roomItems.add(selectedItem);
            this.setInventoryList();
            this.selectedItem = null;

        }
    }

    //Possible answer list
    @FXML
    private void answerAction(ActionEvent event) {

        if (dialogueIsActive == true) {
            if (selectedAnswer != null) {
                this.DialogueLoop(currentDialogue, selectedAnswer, (Player) UI.getInstance().getBusiness().getPlayer());
            }
        } else {
            dialogueScene.setVisible(false);
            selectedAnswer = null;
            dialogueIsActive = true;
        }
    }

    //Dialogue option selection
    @FXML
    private void selectAnswer(MouseEvent event) {

        ObservableList<String> selected;
        selected = answersListView.getSelectionModel().getSelectedItems();
        int IP = answersListView.getSelectionModel().getSelectedIndex();
        this.selectedAnswer = this.answerOptions.get(IP);

        System.out.println("We selected item: " + this.selectedAnswer);

    }

    //EndScreen Lests player see ScoreBoard of top 4 ranking players
    @FXML
    private void HighScore(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {

        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLHighScore.fxml"));

        Scene newScene = new Scene(adminScene);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();

    }

    //EndScreen restart (New game same player)
    @FXML
    private void restart(ActionEvent event) throws IOException {

        business.startNewGame(business.getPlayer().getPlayerName());

        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLGameScene.fxml"));

        Scene newScene = new Scene(adminScene);

        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newScene.getRoot().requestFocus();
        appStage.setScene(newScene);
        appStage.show();
    }

}
