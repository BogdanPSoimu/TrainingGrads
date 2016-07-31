package LetterMapping;

import java.util.ArrayList;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class LetterMapping {

    char character;
    int number;

    LetterMapping(char character) {
        this.character = character;
        this.number = character - 'a' + 1;
    }

    @Override
    public String toString() {
        return("Character: " + this.character
                + " Number: " + this.number);
    }

}
