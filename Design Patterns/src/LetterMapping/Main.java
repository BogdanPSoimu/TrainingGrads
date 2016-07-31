package LetterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class Main {

    public static void main(String[] args) {


        List<LetterMapping> alphabetMapping = new ArrayList<>();

        for(char c = 'a'; c <= 'z'; c++) {
            LetterMapping letterMapping = new LetterMapping(c);
            alphabetMapping.add(letterMapping);
//          System.out.println(letterMapping);
        }

        for(LetterMapping letterMapping : alphabetMapping)
            System.out.println(letterMapping);

    }
}