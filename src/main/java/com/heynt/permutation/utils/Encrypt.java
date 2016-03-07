package com.heynt.permutation.utils;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableListIterator;

public class Encrypt
{
    private static final Logger LOGGER = Logger.getLogger(Encrypt.class.getName());

    public String EncryptString(final String plaintext, Map<Character, List<Integer>> keymap)
    {
        // The ciphertext output
        StringBuilder cipherTextBuilder = new StringBuilder();

        // Walk the plaintext and encode each letter
        ImmutableList<Character> chars = Lists.charactersOf(plaintext);
        UnmodifiableListIterator<Character> iter = chars.listIterator();

        if (chars.get(0) == ' ')
        {
            LOGGER.warning("Cant start the plaintext message with a space. Exiting.");
            System.exit(1);
        }

        /* keeps track of the index into the entire message */
        Integer messageIndex = 0;
        while (iter.hasNext())
        {
            Character prevChar = new Character(' ');
            if (iter.hasPrevious())
            {
                prevChar = iter.previous();
                iter.next();
            }
            Character currentChar = iter.next();

            if (currentChar == '\n') // end
            {
                break;
            }
            else if (currentChar == ' ') // space
            {
                cipherTextBuilder.append(' ');
            }
            else // We are continuing a word
            {
                // Suppress printing an extra comma at very beginning or start of a new word
                if (!prevChar.equals(' '))
                {
                    cipherTextBuilder.append(',');
                }
                // Get list of possible numbers from the map
                List<Integer> possibleValuesList = keymap.get(currentChar);

                // TODO Can extend listPicker to use a different picking algorithm for a value
                String key = schedulingAlgorithm(messageIndex, possibleValuesList);

                // key values less than 10 need a zero prepended (for example, 7 becomes 07)
                if (Integer.valueOf(key) < 10)
                {
                    key = '0' + key;
                }
                cipherTextBuilder.append(key);
            }
            ++messageIndex;
        }

        return cipherTextBuilder.toString();
    }
    
    /**
     * This method defines how the encryption algorithm picks a ciphertext from a list of possible values
     * 
     */
    private String schedulingAlgorithm(Integer messageIndex, List<Integer> possibleValuesList)
    {
        // TODO Extend this so that different picking algorithms can be used

        // “j mod length(list)” where j = index in the plaintext message
        Integer j = messageIndex;
        Integer lengthList = possibleValuesList.size();
        return possibleValuesList.get( j % lengthList ).toString();
    }

}
