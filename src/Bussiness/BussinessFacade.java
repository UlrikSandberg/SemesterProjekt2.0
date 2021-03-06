/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.DirectionType;
import Acquintance.IBussiness;
import Acquintance.IData;
import Acquintance.IHighScore;
import Acquintance.IItem;
import Acquintance.INPC;
import Acquintance.IPlayer;
import Acquintance.IRoom;
import Acquintance.IScore;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public class BussinessFacade implements IBussiness {

    private IData dataFacade;
    private Game game = new Game();

    @Override
    public void injectData(IData dataLayer) {
        this.dataFacade = dataLayer;
    }

    @Override
    public Boolean goNextRoom(DirectionType direction) {

        if (direction == DirectionType.NORTH) {
            return game.goRoom(direction);
        }
        if (direction == DirectionType.SOUTH) {
            return game.goRoom(direction);
        }
        if (direction == DirectionType.EAST) {
            return game.goRoom(direction);
        }
        if (direction == DirectionType.WEST) {
            return game.goRoom(direction);
        }
        return false;
    }

    @Override
    public void startNewGame(String playerName) {
        game = new Game(playerName);
    }

    @Override
    public void loadSavedGame() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            game = new Game();
            game.loadObjects(dataFacade.loadGame());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveGame() throws IOException, FileNotFoundException, ClassNotFoundException {
        dataFacade.saveGame(game.saveObjects());
    }

    @Override
    public IPlayer getPlayer() {

        return game.getPlayer();
    }

    @Override
    public IItem[] getInventory() {
        return game.getPlayer().getInventoryItems();
    }

    @Override
    public ArrayList<DirectionType> getExists() {

        return game.getCurrentRoom().getExits();

    }

    @Override
    public IRoom getCurrentRoom() {
        return game.getCurrentRoom();
    }

    @Override
    public ArrayList<IItem> getRoomItems() {

        return game.getCurrentRoom().getItems();

    }

    @Override
    public Boolean takeItem(IItem item) {

        if (game.getPlayerRoot().getInventory().addToInventory((Item) item)) {

            //Since item as added to the inventory remove from the room
            Room currentRoom = (Room) game.getCurrentRoom();
            currentRoom.removeItemFromRoom(item);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removePlayerItem(IItem item) {

        this.game.getPlayerRoot().getInventory().removeFromInventory(item);

    }

    @Override
    public ArrayList<INPC> getRoomNPCS() {

        return game.getCurrentRoom().getRoomNPCS();

    }

    @Override
    public IHighScore getHighscore() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        loadHighscore();

        return game.getHighscore();
    }

    @Override
    public void saveHighscore() throws IOException, FileNotFoundException, ClassNotFoundException {
        dataFacade.saveHighScore(game.getHighscore());
        System.out.println("BF save HS");
    }

    @Override
    public void loadHighscore() throws IOException, FileNotFoundException, ClassNotFoundException {
//        game.loadHighscore(dataFacade.loadHighScore());
        
        IHighScore score = dataFacade.loadHighScore();
        
        if (score != null) {
            game.loadHighscore(score);
        }
    }

    @Override
    public INPC getExitNPC(DirectionType direction) {

        //Get exitBlock for chosen direction
        return game.getExitBlock(direction);

    }
    
    @Override
    public void checkHighscore() throws IOException, FileNotFoundException, ClassNotFoundException {
        loadHighscore();
        PlayerScore playerscore = new PlayerScore(game.getPlayerRoot().getPlayerName(), game.getPlayerRoot().getScore().getTotalScore());
        game.getHighscore().viableForHighScore(playerscore);
    }

    @Override
    public INPC getGuard() {
        return game.getGuard();
    }
   
}
