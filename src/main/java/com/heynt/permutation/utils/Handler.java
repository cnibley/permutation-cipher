/**
 * 
 */
package com.heynt.permutation.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableListIterator;
import com.heynt.permutation.types.LetterFrequenciesMap;

/**
 * This class handles getting user input as well as returning key mappings for generating ciphertext
 * 
 * @author cnibley
 *
 */
public class Handler
{
    private static final Logger LOGGER = Logger.getLogger(Handler.class.getName());
    private Handler()
    {
        // Lazy Singleton
    }
    
    private static class App
    {
        private static final Handler INSTANCE = new Handler();
    }
    
    public static Handler getInstance() {
        return App.INSTANCE;
    }
    
    public String getNewInputFromStdin()
    {
        System.out.println("Enter plaintext to encrypt as a space seperated message of English words: ");
        String returnString;
        Scanner c = new Scanner(System.in);
        returnString = c.nextLine();
        c.close();
        return returnString;
    }
    
    /**
     * Generate a key map used in the encryption process
     * Letters are mapped to lists of possible ciphertext numbers
     * Map<k,v> where k = char, v = a list of possible ciphertext values
     * 
     * @param mapMethod which keymap permutation to return
     * 
     * @return a map of all English lowercase letters to corresponding to their 
     * list of possible values 0 to 103. 
     * The number of items in the list is determined by the frequency of occurrence in the English language 
     * (see handout for the table)
     */
    public Map<Character, List<Integer>> getKeyMap(Integer mapMethod)
    {
        /* Holds the map of each character in the alphabet to its ciphertext list */
        Map<Character, List<Integer>> keyMapReturn = new HashMap<>();
        switch(mapMethod)
        {
            case 1:
                LOGGER.info("Using default encryption method");
                
                Integer cipherText = 0;
                
                // For each letter in the alphabet
                for (Character letter : LetterFrequenciesMap.MAP.keySet())
                {
                    List<Integer> keyValuesList = new ArrayList<>();
                    for (int j=0; j<getFrequency(letter); j++)
                    {
                        keyValuesList.add(cipherText);
                        ++cipherText;
                    }
                    keyMapReturn.put(letter, keyValuesList);
                }
                break;
                
                // TODO Add more cases to test

            default:
                LOGGER.warning("Key mapping method " + mapMethod + " is not supported");
        }
        return keyMapReturn;
    }

    private Integer getFrequency(Character letter)
    {
        return LetterFrequenciesMap.MAP.get(letter);
    }
    
    /**
     * User input can only be lowercase English letters and spaces. If any of it is not we exit.
     * 
     * @param str
     */
    public String validateUserInput(String str)
    {
        if (str == null)
        {
            LOGGER.warning("User input is null!");
            return "Empty Input";
        }

        // Test for lowerCase letters
        boolean isLowerCase = str.equals(str.toLowerCase());
        if (!isLowerCase)
        {
            LOGGER.warning("User input is not all lowerCase!");
            return "User input is not all lowercase!";
        }
        // Could also check for special chars with regex
        
        return null;
    }
    
    public void printFormattedMessage(String str)
    {
        // The ciphertext output
        StringBuilder sb = new StringBuilder();
        ImmutableList<Character> chars = Lists.charactersOf(str);
        UnmodifiableListIterator<Character> iter = chars.listIterator();

        //TODO
    }
}
