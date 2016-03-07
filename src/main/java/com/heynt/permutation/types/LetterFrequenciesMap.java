package com.heynt.permutation.types;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LetterFrequenciesMap
{
    public static Map<Character, Integer> MAP = new TreeMap<Character, Integer>();

    static
    {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        map.put('a', 8);
        map.put('b', 1);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 13);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 6);
        map.put('i', 7);
        map.put('j', 1);
        map.put('k', 1);
        map.put('l', 4);
        map.put('m', 2);
        map.put('n', 7);
        map.put('o', 8);
        map.put('p', 2);
        map.put('q', 1);
        map.put('r', 6);
        map.put('s', 6);
        map.put('t', 9);
        map.put('u', 3);
        map.put('v', 1);
        map.put('w', 2);
        map.put('x', 1);
        map.put('y', 2);
        map.put('z', 1);
        MAP = Collections.unmodifiableMap(map);
    }
}
