package com.heynt.permutation.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.heynt.permutation.ui.PermCipherUI;

public class Main {

	private static final Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("Starting Perm-Cipher Tool");
		if ("true".equalsIgnoreCase(System.getProperty("use-ui"))) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new PermCipherUI();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Unexpected Error Occurred: " + ExceptionUtils.getStackTrace(e));
						e.printStackTrace(System.err);
					}
				}
			});
		}
	}
}
