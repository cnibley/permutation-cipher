package com.heynt.permutation.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class takes the parsed ciphertext and counts the occurances
 * @author cnibley
 *
 */
public class FrequencyOfOccurance
{

    public static Map<Character, Integer> OCCURANCE_MAP = new HashMap<>();
    static 
    {
        Map<Character, Integer> map = new HashMap<>();
        // TODO make this class into a usable utility for counting the times something occurs.
        OCCURANCE_MAP = Collections.unmodifiableMap(map);
    }
    
    public FrequencyOfOccurance()
    {
        // yeah
    }
    
    
}
