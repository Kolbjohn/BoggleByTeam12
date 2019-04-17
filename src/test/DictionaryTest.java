package test;

import Data.Dictionary;
import UI.UI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryTest {
    private Dictionary dictionary = new Dictionary();

    @Nested
    @DisplayName("Checks for the correct words in each language")
    class TestCorrectText{

        @Test
        @DisplayName("Is it a valid English word?")
        void testEnglishWord(){
            UI.isEnglish = true;
            assertTrue(dictionary.checkWord("test"));
        }

        @Test
        @DisplayName("Is it a valid German word?")
        void testGermanWord(){
            UI.isEnglish = false;
            assertTrue(dictionary.checkWord("blutungen"));
        }
    }

    @Nested
    @DisplayName("Checks for the invalid words in each language")
    class TestIncorrectText{

        @Test
        @DisplayName("Does it catch an invalid English word?")
        void testEnglishWord(){
            UI.isEnglish = true;
            assertFalse(dictionary.checkWord("boiii"));
        }

        @Test
        @DisplayName("Does it catch an invalid German word?")
        void testGermanWord(){
            UI.isEnglish = false;
            assertFalse(dictionary.checkWord("book"));
        }
    }

}
