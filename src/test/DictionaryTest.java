package test;

import Data.Dictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryTest {
    private Dictionary dictionary = new Dictionary();

    @Test
    @DisplayName("It checks if it's a word!")
    void testCheckWord(){
        assertTrue(dictionary.checkWord("true"));
    }
}
