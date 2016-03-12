package com.heynt.permutation.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.heynt.permutation.handler.EncryptionHandler;

public class GoButtonListener implements ActionListener {

	private static final Logger log = LogManager.getLogger(GoButtonListener.class.getName());

	private PermCipherUI cipherUI;

	public GoButtonListener(PermCipherUI ui) {
		Validate.notNull(ui);
		this.cipherUI = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("Initiating Operation");

		Thread initThread = new Thread() {

			@Override
			public void run() {
				try {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							cipherUI.setInProgressState();// Disable start
															// button

						}

					});

					String inText = cipherUI.getInText().getText();
					if (StringUtils.isBlank(inText)) {
						showError("Enter Valid Text Input");
						cipherUI.getInText().grabFocus();
						return;
					}

					String lowerInText = inText.toLowerCase(Locale.getDefault());
					cipherUI.getInText().setText(lowerInText);

					String result = new EncryptionHandler().encrypt(lowerInText,
							((ComboBoxEntry) cipherUI.getKeyAlg().getSelectedItem()).getKey());

					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							cipherUI.getOutText().setText(result);

						}

					});

				} catch (Exception e) {
					log.error("Error Occured", e);
					showError(
							"Unexpected Error Occured processing the request, check the console for more information");
				} finally {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							cipherUI.enableToolButtons();// Disable start button

						}

					});
				}
			}

		};
		initThread.start();

	}

	private void showError(final String text) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(cipherUI.getActivatorFrame(), text, "Error", JOptionPane.ERROR_MESSAGE);

			}
		});

	}

	private void showMessage(final String text) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(cipherUI.getActivatorFrame(), text, "Message",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}

}
