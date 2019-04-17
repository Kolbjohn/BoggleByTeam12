/*
 * This class reads the words from an external dictionary text file and stores them locally
 * Also checks if a given word is a valid word
 */

package Data;

import UI.UI;

import java.io.*;
import java.util.ArrayList;

public class Dictionary {
    // Global arraylist to store all the words
    private static ArrayList<String> wordsInDictionary = new ArrayList<>();

    public Dictionary(){
        generateDictionary();
    }

    // Reads the external dictionary text file and stores them in words list
    private void generateDictionary(){
        InputStream in = UI.isEnglish ? Dictionary.class.getResourceAsStream("dictionary_en.txt") : Dictionary.class.getResourceAsStream("dictionary_de.txt");
        InputStreamReader is = new InputStreamReader(in);
        try{
            BufferedReader br = new BufferedReader(is);
            String currentLine;
            while((currentLine = br.readLine()) != null){
                wordsInDictionary.add(currentLine.trim());
            }
            is.close();
            br.close();
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Checks if the given word is present in the dictionary
    public boolean checkWord(String word){
        int low = 0, mid, high = wordsInDictionary.size() - 1;
        while(low <= high){
            mid = (low + high)/2;
            if(wordsInDictionary.get(mid).toUpperCase().compareTo(word.toUpperCase()) < 0){
                low = mid + 1;
            }
            else if(wordsInDictionary.get(mid).toUpperCase().compareTo(word.toUpperCase()) > 0){
                high = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
