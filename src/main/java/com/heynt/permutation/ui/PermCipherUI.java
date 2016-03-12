package com.heynt.permutation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PermCipherUI {

	private static final Logger log = LogManager.getLogger(PermCipherUI.class.getName());

	private JFrame activatorFrame;
	private JComboBox<ComboBoxEntry> action;
	private MessageConsole messageConsole;
	private JButton btnGo;
	private JTextArea inText;
	private JTextArea outText;

	private JComboBox<ComboBoxEntry> keyAlg;

	private static final String KEY_DECRYPT = "D";
	private static final String KEY_ENCRYPT = "E";
	private static final String KEY_ATTACK = "A";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PermCipherUI() throws Exception {
		initialize();
		log.info("Completed UI initialization");
		activatorFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws Exception {
		activatorFrame = new JFrame();
		activatorFrame.setResizable(false);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		activatorFrame.setTitle("Permutation Cipher");
		activatorFrame.setBounds(100, 100, 1052, 748);
		activatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		activatorFrame.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		activatorFrame.getContentPane().add(panel, gbc_panel);

		JLabel lblChooseEnvironment = new JLabel("Choose Action:");
		lblChooseEnvironment.setBounds(23, 8, 103, 14);
		lblChooseEnvironment.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblChooseEnvironment);

		action = new JComboBox<ComboBoxEntry>();
		DefaultComboBoxModel<ComboBoxEntry> model = new DefaultComboBoxModel<ComboBoxEntry>();
		model.addElement(new ComboBoxEntry("E", "Encrypt (Enc)"));
		model.addElement(new ComboBoxEntry("D", "Decrypt (Dec)"));
		model.addElement(new ComboBoxEntry("A", "Attack (Att)"));

		action.setModel(model);
		action.setBounds(169, 5, 100, 20);
		panel.add(action);

		JLabel inputLabel = new JLabel("Enter Plain Text(M):");
		inputLabel.setBounds(22, 54, 136, 14);
		panel.add(inputLabel);

		action.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				String key = ((ComboBoxEntry) ((JComboBox<ComboBoxEntry>) e.getSource()).getSelectedItem()).getKey();
				log.info("Selected Operation: {}", key);
				if (KEY_DECRYPT.equals(key)) {
					inputLabel.setText("Enter Cipher Text(C):");
					keyAlg.setEnabled(true);
				} else if (KEY_ENCRYPT.equals(key)) {
					inputLabel.setText("Enter Plain Text(M):");
					keyAlg.setEnabled(true);
				} else if (KEY_ATTACK.equals(key)) {
					inputLabel.setText("Enter Cipher Text(C):");
					keyAlg.setEnabled(false);
				}
			}
		});
		JLabel lblKeySelectionAlgorithm = new JLabel("Key Scheduling Algorithm:");
		lblKeySelectionAlgorithm.setBounds(23, 161, 136, 14);
		panel.add(lblKeySelectionAlgorithm);
		keyAlg = new JComboBox<ComboBoxEntry>();
		keyAlg.setBounds(169, 158, 290, 20);
		panel.add(keyAlg);
		DefaultComboBoxModel<ComboBoxEntry> algModel = new DefaultComboBoxModel<ComboBoxEntry>();
		algModel.addElement(new ComboBoxEntry("1", "j mod length(list)"));
		keyAlg.setModel(algModel);

		btnGo = new JButton("Start");
		// btnStartPlanActivator.addActionListener(new
		// StartActivatorListener(this));
		btnGo.setBounds(169, 201, 103, 23);
		panel.add(btnGo);
		btnGo.addActionListener(new GoButtonListener(this));

		JTextPane consolePane = new JTextPane();
		consolePane.setContentType("text/html");
		consolePane.setFont(new Font("Consolas", Font.PLAIN, 11));
		consolePane.setEditable(false);
		JScrollPane messagesPane = new JScrollPane(consolePane);
		messagesPane.setBounds(23, 359, 900, 350);
		panel.add(messagesPane);
		messageConsole = new MessageConsole(consolePane, true);

		inText = new JTextArea();
		inText.setWrapStyleWord(true);
		inText.setRows(5);
		inText.setColumns(5);
		inText.setLineWrap(true);
		JScrollPane inTextPane = new JScrollPane(inText);
		inTextPane.setBounds(169, 49, 586, 82);
		inTextPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(inTextPane);

		outText = new JTextArea();
		outText.setWrapStyleWord(true);
		outText.setEditable(false);
		outText.setRows(5);
		outText.setColumns(5);
		outText.setLineWrap(true);
		JScrollPane outTextPane = new JScrollPane(outText);
		outTextPane.setBounds(169, 251, 586, 82);
		outTextPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(outTextPane);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(23, 256, 136, 14);
		panel.add(lblResult);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(23, 342, 46, 14);
		panel.add(lblConsole);

		messageConsole.redirectOut();
		messageConsole.redirectErr(Color.RED, null);
		messageConsole.setMessageLines(100);

		// mConsole = new MessageConsole();
		// dbPassword.setBounds(169, 130, 86, 20);
		// panel.add(dbPassword);
	}

	public MessageConsole getMessageConsole() {
		return messageConsole;
	}

	public void setMessageConsole(MessageConsole mc) {
		this.messageConsole = mc;
	}

	public JFrame getActivatorFrame() {
		return activatorFrame;
	}

	public void setActivatorFrame(JFrame frmAhctPlanManagement) {
		this.activatorFrame = frmAhctPlanManagement;
	}

	public void setInProgressState() {
		btnGo.setEnabled(false);

	}

	public void enableToolButtons() {
		btnGo.setEnabled(true);

	}

	JComboBox<ComboBoxEntry> getAction() {
		return action;
	}

	void setAction(JComboBox<ComboBoxEntry> action) {
		this.action = action;
	}

	JTextArea getInText() {
		return inText;
	}

	void setInText(JTextArea inText) {
		this.inText = inText;
	}

	JTextArea getOutText() {
		return outText;
	}

	void setOutText(JTextArea outText) {
		this.outText = outText;
	}

	JComboBox<ComboBoxEntry> getKeyAlg() {
		return keyAlg;
	}

	void setKeyAlg(JComboBox<ComboBoxEntry> keyAlg) {
		this.keyAlg = keyAlg;
	}
}
