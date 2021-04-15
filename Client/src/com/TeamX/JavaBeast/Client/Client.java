package com.TeamX.JavaBeast.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JTextField;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Client() {
		setResizable(false);
		setTitle("TeamX - v 2.0");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 605);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_1.setBounds(10, 11, 840, 44);
		layeredPane.add(layeredPane_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select server");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Server: main"}));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(10, 11, 128, 22);
		comboBox.setBorder(new LineBorder(new Color(0,0,0)));
		layeredPane_1.add(comboBox);
		
		JButton btnNewButton = new JButton("support");
		btnNewButton.setToolTipText("follow to discord\r\n");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://discord.gg/Wv3kk3BSRM"));
				} catch (IOException | URISyntaxException e1) {
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(741, 11, 89, 23);
		layeredPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reload");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setToolTipText("reload the gui");
		btnNewButton_1.setBorder(new LineBorder(new Color(0,0,0)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(642, 11, 89, 23);
		layeredPane_1.add(btnNewButton_1);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_2.setBounds(10, 66, 840, 479);
		layeredPane.add(layeredPane_2);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_4.setBounds(10, 24, 228, 134);
		layeredPane_2.add(layeredPane_4);
		
		JLabel lblNewLabel_1 = new JLabel("Online:");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 11, 152, 14);
		layeredPane_4.add(lblNewLabel_1);
		
		JLabel online_players = new JLabel("0");
		online_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		online_players.setForeground(Color.LIGHT_GRAY);
		online_players.setBounds(172, 11, 46, 14);
		layeredPane_4.add(online_players);
		
		JLabel lblNewLabel_2 = new JLabel("Registered:");
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 61, 152, 14);
		layeredPane_4.add(lblNewLabel_2);
		
		JLabel registered_players = new JLabel("0");
		registered_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		registered_players.setForeground(Color.LIGHT_GRAY);
		registered_players.setBounds(172, 61, 46, 14);
		layeredPane_4.add(registered_players);
		
		JLabel lblNewLabel_3 = new JLabel("Today joined:");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(10, 86, 152, 14);
		layeredPane_4.add(lblNewLabel_3);
		
		JLabel today_joined = new JLabel("0");
		today_joined.setFont(new Font("Courier New", Font.PLAIN, 11));
		today_joined.setForeground(Color.LIGHT_GRAY);
		today_joined.setBounds(172, 86, 46, 14);
		layeredPane_4.add(today_joined);
		
		JLabel lblNewLabel_4 = new JLabel("Today Registered:");
		lblNewLabel_4.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(10, 111, 152, 14);
		layeredPane_4.add(lblNewLabel_4);
		
		JLabel today_registered_players = new JLabel("0");
		today_registered_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		today_registered_players.setForeground(Color.LIGHT_GRAY);
		today_registered_players.setBounds(172, 111, 46, 14);
		layeredPane_4.add(today_registered_players);
		
		JLabel lblNewLabel_5 = new JLabel("Maximum:");
		lblNewLabel_5.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(10, 36, 152, 14);
		layeredPane_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("0");
		lblNewLabel_6.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setBounds(172, 36, 46, 14);
		layeredPane_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Players:");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(29, 11, 118, 14);
		layeredPane_2.add(lblNewLabel);
		
		JLayeredPane layeredPane_5 = new JLayeredPane();
		layeredPane_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_5.setBounds(10, 194, 291, 134);
		layeredPane_2.add(layeredPane_5);
		
		JLabel lblNewLabel_8 = new JLabel("Network name:");
		lblNewLabel_8.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_8.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8.setBounds(10, 11, 164, 14);
		layeredPane_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("Address:");
		lblNewLabel_10.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_10.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_10.setBounds(10, 36, 164, 14);
		layeredPane_5.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("isSubserver:");
		lblNewLabel_12.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_12.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_12.setBounds(10, 61, 164, 14);
		layeredPane_5.add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("receiveBufferSize:");
		lblNewLabel_14.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_14.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_14.setBounds(10, 86, 164, 14);
		layeredPane_5.add(lblNewLabel_14);
		
		JLabel lblNewLabel_9 = new JLabel("mainServer:");
		lblNewLabel_9.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_9.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_9.setBounds(10, 111, 164, 14);
		layeredPane_5.add(lblNewLabel_9);
		
		JLabel network_name = new JLabel("-");
		network_name.setFont(new Font("Courier New", Font.PLAIN, 11));
		network_name.setForeground(Color.LIGHT_GRAY);
		network_name.setBounds(184, 11, 149, 14);
		layeredPane_5.add(network_name);
		
		JLabel spigot_address = new JLabel("127.0.0.1:1997");
		spigot_address.setFont(new Font("Courier New", Font.PLAIN, 11));
		spigot_address.setForeground(Color.LIGHT_GRAY);
		spigot_address.setBounds(184, 36, 149, 14);
		layeredPane_5.add(spigot_address);
		
		JLabel isSubServer = new JLabel("-");
		isSubServer.setFont(new Font("Courier New", Font.PLAIN, 11));
		isSubServer.setForeground(Color.LIGHT_GRAY);
		isSubServer.setBounds(184, 61, 149, 14);
		layeredPane_5.add(isSubServer);
		
		JLabel receiveBufferSize = new JLabel("-");
		receiveBufferSize.setFont(new Font("Courier New", Font.PLAIN, 11));
		receiveBufferSize.setForeground(Color.LIGHT_GRAY);
		receiveBufferSize.setBounds(184, 86, 149, 14);
		layeredPane_5.add(receiveBufferSize);
		
		JLabel main_Server_address = new JLabel("127.0.0.1:1997");
		main_Server_address.setFont(new Font("Courier New", Font.PLAIN, 11));
		main_Server_address.setForeground(Color.LIGHT_GRAY);
		main_Server_address.setBounds(184, 111, 149, 14);
		layeredPane_5.add(main_Server_address);
		
		JLabel lblNewLabel_7 = new JLabel("Server Info:");
		lblNewLabel_7.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(20, 179, 118, 14);
		layeredPane_2.add(lblNewLabel_7);
		
		JLayeredPane layeredPane_6 = new JLayeredPane();
		layeredPane_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_6.setBounds(311, 24, 519, 444);
		layeredPane_2.add(layeredPane_6);
		
		JLayeredPane layeredPane_7 = new JLayeredPane();
		layeredPane_7.setBackground(Color.DARK_GRAY);
		layeredPane_7.setForeground(Color.LIGHT_GRAY);
		layeredPane_7.setBorder(null);
		layeredPane_7.setBounds(10, 11, 499, 399);
		layeredPane_6.add(layeredPane_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(12, 11, 479, 377);
		layeredPane_7.add(textArea);
		
		JLayeredPane layeredPane_8 = new JLayeredPane();
		layeredPane_8.setBorder(null);
		layeredPane_8.setBounds(10, 409, 499, 24);
		layeredPane_6.add(layeredPane_8);
		
		textField = new JTextField();
		textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Courier New", Font.PLAIN, 11));
		textField.setBounds(0, 0, 499, 24);
		layeredPane_8.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Console:");
		lblNewLabel_11.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_11.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_11.setBounds(322, 11, 148, 14);
		layeredPane_2.add(lblNewLabel_11);
		
		JPanel layeredPane_3 = new JPanel();
		layeredPane_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_3.setLayout(null);
	}
}
