/*
 * This singleton class contains all the hardcoded die letters for each die
 * Also contains a method to randomize the dice
 */

import java.util.HashMap;
import java.util.Map;

public class Die {
    // Initialization of global variables for dice and Die class instance
    private static final Map<Integer,String[]> diceMap = new HashMap<>();
    private static Die instance = null;

    // Default constructor that puts all the hardcoded dice in the map
    private Die(){
        diceMap.put(0, new String[] {"R", "I", "F", "O", "B", "X"});
        diceMap.put(1, new String[] {"H", "M", "S", "R", "A", "O"});
        diceMap.put(2, new String[] {"Qu", "B", "M", "J", "O", "A"});
        diceMap.put(3, new String[] {"E", "Z", "A", "V", "N", "D"});

        diceMap.put(4, new String[] {"I", "F", "E", "H", "E", "Y"});
        diceMap.put(5, new String[] {"L", "U", "P", "E", "T", "S"});
        diceMap.put(6, new String[] {"E", "H", "I", "S", "P", "N"});
        diceMap.put(7, new String[] {"R", "A", "L", "E", "S", "C"});

        diceMap.put(8, new String[] {"D", "E", "N", "O", "W", "S"});
        diceMap.put(9, new String[] {"A", "C", "I", "T", "O", "A"});
        diceMap.put(10, new String[] {"V", "E", "T", "I", "G", "N"});
        diceMap.put(11, new String[] {"U", "W", "I", "L", "R", "G"});

        diceMap.put(12, new String[] {"U", "T", "O", "K", "N", "D"});
        diceMap.put(13, new String[] {"Y", "L", "G", "K", "U", "E"});
        diceMap.put(14, new String[] {"B", "A", "L", "I", "Y", "T"});
        diceMap.put(15, new String[] {"P", "A", "C", "E", "M", "D"});
    }

    // Provides a current instance of the Die class when called
    public static Die getInstance(){
        if(instance == null){
            instance = new Die();
        }
        return instance;
    }
}