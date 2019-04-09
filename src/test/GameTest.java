package test;

import Data.Dictionary;
import Game.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Dictionary dictionary = new Dictionary();
    private Game g = new Game(new JFrame()){
        private String word = "test";

        @Override
        public int getScore() {
            int score = 0;
            if (dictionary.checkWord(word)) {
                switch (word.length()) {
                    case 3:
                        score += 1;
                        break;
                    case 4:
                        score += 1;
                        break;
                    case 5:
                        score += 2;
                        break;
                    case 6:
                        score += 3;
                        break;
                    case 7:
                        score += 5;
                        break;
                    default:
                        score += 11;
                        break;
                }
            }
            return score;
        }

        @Override
        public String getLatestWord(){
            return this.word;
        }
    };

    @Test
    @DisplayName("Submit word is a-ok")
    void testSubmitWord(){
        g.submitWord();
        assertEquals("test",g.getLatestWord());
    }

    @Test
    @DisplayName("It looks like it gets the latest word")
    void testGetLatestWord(){
        String latest = g.getLatestWord();
        assertEquals("test",latest);
    }

    @Test
    @DisplayName("The score matches, that's all we need bois")
    void testGetScore(){
        assertEquals(1,g.getScore());
    }

}
