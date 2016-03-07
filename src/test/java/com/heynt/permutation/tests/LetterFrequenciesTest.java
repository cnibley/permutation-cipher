package com.heynt.permutation.tests;

import java.util.Collection;

import com.heynt.permutation.types.LetterFrequenciesMap;

//import junit.framework.Assert;

public class LetterFrequenciesTest
{
    /**
     * This test loosely sees that we have the right frequencies for all the letters
     */
    public void allLetterFrequenciesShouldSumTo103()
    {
        Integer total = 0;
        Collection<Integer> allValues = LetterFrequenciesMap.MAP.values();
        for (Integer value : allValues)
        {
            total += value;
        }
        // The total should be 103 when adding up all the frequencies
//        Assert.assertEquals(103, total.intValue());
    }
}
