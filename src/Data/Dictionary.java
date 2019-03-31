package Data;
/*
 * This class reads the words from an external dictionary text file and stores them locally
 * Also checks if a given word is a valid word
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Dictionary {
    // Global arraylist to store all the words
    private static ArrayList<String> wordsInDictionary = new ArrayList<>();

    // Reads the external dictionary text file and stores them in words list
    public static void generateDictionary(){
        Path workingDir = Paths.get(System.getProperty("user.dir"));
        File dictDir = new File(workingDir.resolve("dictionary").toUri());
        if(!dictDir.exists()){
            System.out.println("No directory called " + dictDir.getName() + " is present.");
            return;
        }
        File dictionaryFile = new File(dictDir, "dictionary.txt");
        if(!dictionaryFile.exists()){
            System.out.println("No file called " + dictionaryFile.getName() + " is present.");
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
            String currentLine;
            while((currentLine = br.readLine()) != null){
                wordsInDictionary.add(currentLine.trim());
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Checks if the given word is present in the dictionary
    public static boolean checkWord(String word){
        return wordsInDictionary.contains(word.toUpperCase());
    }
}
