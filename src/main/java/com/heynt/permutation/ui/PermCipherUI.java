package com.heynt.permutation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Logger;

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

public class PermCipherUI {
	
	private static final Logger log = Logger.getLogger(PermCipherUI.class.getName());

	private JFrame activatorFrame;
	private JComboBox<ComboBoxEntry> action;
	private MessageConsole messageConsole;
	private JButton btnGo;
	private JTextArea inText;
	private JTextArea outText;

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

		JLabel lblDbUser = new JLabel("Enter Plaintext (M):");
		lblDbUser.setBounds(23, 70, 136, 14);
		panel.add(lblDbUser);

		btnGo = new JButton("Go");
		//btnStartPlanActivator.addActionListener(new StartActivatorListener(this));
		btnGo.setBounds(169, 186, 103, 23);
		panel.add(btnGo);

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
		inTextPane.setBounds(170, 65, 586, 82);
		inTextPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(inTextPane);
		
		outText = new JTextArea();
		outText.setWrapStyleWord(true);
		outText.setEditable(false);
		outText.setRows(5);
		outText.setColumns(5);
		outText.setBounds(169, 251, 586, 82);
		panel.add(outText);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(23, 256, 136, 14);
		panel.add(lblResult);
		messageConsole.redirectOut();
		messageConsole.redirectErr(Color.RED, null);
		messageConsole.setMessageLines(100);

		//		mConsole = new MessageConsole();
		//		dbPassword.setBounds(169, 130, 86, 20);
		//		panel.add(dbPassword);
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

	public JComboBox getAction() {
		return action;
	}

	public void setAction(JComboBox env) {
		this.action = env;
	}

	public void setInProgressState() {
		btnGo.setEnabled(false);
		

	}

	

	public void enableToolButtons() {
		btnGo.setEnabled(true);
		
		
	}
}
