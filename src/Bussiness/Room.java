package Bussiness;

import Acquintance.DirectionType;
import Acquintance.IItem;
import Acquintance.INPC;
import Acquintance.IRoom;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.io.Serializable;
import javafx.scene.image.Image;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room implements Serializable, IRoom
{
    private String description;
    private HashMap<DirectionType, Room> exits;
    private ArrayList<IItem> roomContentArray;
    private HashMap<String, IItem> roomContent;
    private HashMap<String, INPC> inhabitants;
    private HashMap<DirectionType, INPC> exitBlocks;
    private transient Image image;
    public Room(String description, String filePath) 
    {
        this.description = description;
        this.roomContentArray = new ArrayList<>();
        exits = new HashMap<>();
        this.roomContent = new HashMap<>();
        inhabitants = new HashMap<String, INPC>();
        this.exitBlocks = new HashMap<DirectionType, INPC>();
        this.image = this.image = new Image(getClass().getResourceAsStream(filePath)); 
    }

    public void setExit(DirectionType direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public void setInhabitant(String subjectname, INPC inhabitant) 
    {
        inhabitants.put(subjectname, inhabitant);
    }
    
    public void removeInhabitant(String subjectname) 
    {
        inhabitants.remove(subjectname);
    }
    
    public void setExitBlock(DirectionType direction, INPC exitBlock) 
    {
        exitBlocks.put(direction, exitBlock);
    }
    
    public void removeExitBlock(DirectionType direction) 
    {
        exitBlocks.remove(direction);
    }
    
    public INPC getExitBlock(DirectionType direction) 
    {
        return exitBlocks.get(direction);
    }

    public String getShortDescription()
    {
        return description;
    }

    
    public ArrayList<DirectionType> getExits() {
        
        ArrayList<DirectionType> list = new ArrayList<>();
        
        for(DirectionType exits: exits.keySet()) {
            list.add(exits);
        }
        DirectionType[] data = new DirectionType[list.size()];
        
        
        return list;
        
        
    }
    
    /*
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getInhabitantString() + ".\n" + getRoomContentString();
    }
*/
    /*
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<DirectionType> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    */    
    public String getInhabitantString()
    {
        String returnString = "Inhabitants:";
        Set<String> keys = inhabitants.keySet();
        for(String inhabitant : keys) {
            returnString += " " + inhabitant;
        }
        return returnString;
    }
    
    public String getRoomContentString(){
        String returnString = "Items in room: ";
        Set<String> keys = roomContent.keySet();
        for(String roomContent : keys){
            returnString += " " + roomContent;
        }
        return returnString;
    }
    
    //Acces the hashMap and check if any exits corresponds to the given exit string
    public Room getExit(DirectionType direction) 
    {
        return exits.get(direction);
    }
    
    public INPC getInhabitant(String subjectname) 
    {
        return inhabitants.get(subjectname);
    }
    
    //Only use if safe
    public void removeItemFromRoom(String string) {
        
        this.roomContent.remove(string);
        
    }
    
    public void removeItemFromRoom(IItem item) {
        System.out.println("This is nice");
        this.roomContentArray.remove(item);
        this.roomContent.remove(item.getName());
    }
    
    
    
    public void addItemToRoom(IItem item) {
        
        this.roomContent.put(item.getName(), item);
        this.roomContentArray.add(item);
    }
    
    public IItem getItem(String itemName) {
        
       return this.roomContent.get(itemName);
    }
    
    public void getRoomContennt() {
        
        
        int i = 0;
        
        for(String key: this.roomContent.keySet()) {
            
            i += 1;
            System.out.println(i+". "+key);
            
        }
    }
    
    //public Inventory getRoomContents() {
        
    //}

    @Override
    public ArrayList<IItem> getItems() {
        ArrayList<IItem> list = new ArrayList<>();
        for(IItem item: this.roomContent.values()) {
            list.add(item);   
        }
        return list;
        //return this.roomContentArray;
    }  

    @Override
    public ArrayList<INPC> getRoomNPCS() {
        
        ArrayList<INPC> data = new ArrayList<>();
        for(INPC npc: this.inhabitants.values()) {
            data.add(npc);
        }
        return data;
        
        
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    
    public void setImage(String filepath) {
        this.image = new Image(getClass().getResourceAsStream(filepath));
    }

    
}

