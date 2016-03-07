package com.heynt.permutation.main;

import java.util.List;
import java.util.Map;

import com.heynt.permutation.utils.Encrypt;
import com.heynt.permutation.utils.Handler;

public class Main
{
    public static void main( String[] args )
    {
        Handler inputHandler = Handler.getInstance();

        String plaintext = inputHandler.getNewInputFromStdin();
        inputHandler.validateUserInput(plaintext);

        // keyMap defines how plaintext letters map to ciphertext
        // TODO We could add different mappings as case statements in the getKeyMap method
        Map<Character, List<Integer>> keymap = inputHandler.getKeyMap(1);

        Encrypt encryptor = new Encrypt();
        String cipherText = encryptor.EncryptString(plaintext, keymap);

        // Display the encrypted message
        if (cipherText != null)
        {
            System.out.println("The encrypted message is: ");
            System.out.println(cipherText);
        }

        System.exit(0);
    }
}
