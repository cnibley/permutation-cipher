package com.heynt.permutation.tests;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

/**
 * Can be used to perform tests on the dictionary
 * 
 * @author cnibley
 *
 */
public class EnglishWordsTest
{
    private static final String DICTIONARY_FILE = "dict/english_words.txt";

    public static void main(String[] args)
    {
        EnglishWordsTest test = new EnglishWordsTest();
        String dict = test.getFile(DICTIONARY_FILE);

        test.printDictionary(dict);
    }

    private void printDictionary(String dict)
    {
        String[] separated = dict.split("\n");

        for (String word : Arrays.asList(separated))
        {
            System.out.println(word);
        }
    }

    private String getFile(String fileName)
    {
        String result = "";
        final ClassLoader classLoader = getClass().getClassLoader();
        try
        {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}
