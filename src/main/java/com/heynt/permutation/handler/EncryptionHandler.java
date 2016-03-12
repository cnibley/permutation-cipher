package com.heynt.permutation.handler;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import com.heynt.permutation.utils.Encrypt;
import com.heynt.permutation.utils.Handler;

public class EncryptionHandler {

	private static final Logger log = LogManager.getLogger(EncryptionHandler.class);

	public String encrypt(String input, String algType) {
		log.entry();
		String result = null;

		Handler inputHandler = Handler.getInstance();

		// keyMap defines how plaintext letters map to ciphertext
		// TODO We could add different mappings as case statements in the
		// getKeyMap method
		Map<Character, List<Integer>> keymap = inputHandler.getKeyMap(1);

		Encrypt encryptor = new Encrypt();
		result = encryptor.encryptString(input, keymap, algType);
		log.info("Encryption Result: {}", result);
		// Display the encrypted message

		return log.exit(result);
	}
}
