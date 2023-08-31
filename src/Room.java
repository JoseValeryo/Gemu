import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    private HashSet Items;

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }

    public void addItem(String description, double weight){
        Items.add(new Item(description, weight));
    }

    public void removeItem(Item newItem){
        Items.remove(newItem);
    }

    public String getItemString(){
        String returnSting = "Items";
        Item item;
        Iterator it = Items.iterator();
        while (it.hasNext()){
            item =(Item)it.next();
            returnSting += " " + item.getItemDescription();
        }
        return returnSting;
    }

}
