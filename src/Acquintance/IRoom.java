/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.NPC;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author ulriksandberg
 */
public interface IRoom {
    
    /**
     * gets the directions that have neighbors. 
     * @return an ArrayList with DirectionType's. 
     */
    ArrayList<DirectionType> getExits();
    
    /**
     * gets a short description that the room has. 
     * @return a string that is the description. 
     */
    String getShortDescription();
    
    /**
     * gets an image that the room has. 
     * @return an image that represents the room. 
     */
    public Image getImage();
    
    /**
     * gets a list of items that this room contains. 
     * @return a list of the items. 
     */
    public ArrayList<IItem> getItems();
    
    /**
     * adds an item to a rooms list of items. 
     * @param item an item. 
     */
    public void addItemToRoom(IItem item);
    
    /**
     * gets a list of the NPC's that inhabits this room. 
     * @return a list of the NPC's. 
     */
    public ArrayList<INPC> getRoomNPCS();
    
    /**
     * maps an NPC to a room. 
     * @param subjectname a string that refers to an NPC. 
     * @param npc an NPC. 
     */
    public void setInhabitant(String subjectname, INPC npc);
    
    /**
     * gets an NPC that corresponds to the given string. 
     * @param subjectname a string that refers to an NPC. 
     * @return an NPC. 
     */
    public INPC getInhabitant(String subjectname);
    
    /**
     * maps an NPC to serve as an obstacle in a given direction. 
     * @param direction a direction that determines which way out of the room. 
     * @param exitBlock refers to an NPC that serves as an obstacle 
     * that bars the way in a specific direction typically. 
     */
    public void setExitBlock(DirectionType direction, INPC exitBlock);     
    
    
}
