package Data;
/*
 * This class reads the words from an external dictionary text file and stores them locally
 * Also checks if a given word is a valid word
 */

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Dictionary {
    // Global arraylist to store all the words
    private static ArrayList<String> wordsInDictionary = new ArrayList<>();

    // Reads the external dictionary text file and stores them in words list
    public static void generateDictionary(){
        InputStream in = Dictionary.class.getResourceAsStream("dictionary.txt");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String currentLine;
            while((currentLine = br.readLine()) != null){
                wordsInDictionary.add(currentLine.trim());
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(wordsInDictionary.size());
    }

    // Checks if the given word is present in the dictionary
    public static boolean checkWord(String word){
        return wordsInDictionary.contains(word.toUpperCase());
    }
}
