package com.heynt.permutation.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableListIterator;

public class Encrypt
{
    public String EncryptString(final String plaintext, Map<Character, List<Integer>> keymap)
    {
        // The ciphertext output
        StringBuilder cipherTextBuilder = new StringBuilder();

        // Walk the plaintext and encode each letter
        ImmutableList<Character> chars = Lists.charactersOf(plaintext);
        UnmodifiableListIterator<Character> iter = chars.listIterator();
        Integer messageIndex = 0;
        while (iter.hasNext())
        {
            Boolean isFirstLetter = true;
            Character letter = iter.next();
            
            if (letter == '\n') // end
            {
                break;
            }
            
            else if (letter == ' ') // space
            {
                cipherTextBuilder.append(' ');
                isFirstLetter = true;
            }
            else // We are continuing a word
            {
                if (messageIndex > 0 && !isFirstLetter)
                {
                    cipherTextBuilder.append(',');
                }
                // Get list of possible numbers from the map
                List<Integer> possibleValuesList = keymap.get(letter);

                // TODO Can extend listPicker to use a different picking algorithm for a value
                String key = schedulingAlgorithm(messageIndex, possibleValuesList);
                cipherTextBuilder.append(key);
            }
            isFirstLetter = false;
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
