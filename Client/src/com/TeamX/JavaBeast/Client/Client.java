package com.TeamX.JavaBeast.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLayeredPane;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

public class Client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	private JComboBox<?> servers;
	
	private JLabel Online;
	private JLabel Maximum;
	private JLabel Registered;
	private JLabel Today_joined;
	private JLabel Today_registered;
	
	private JLabel Network_name;
	private JLabel Address;
	private JLabel isSubServer;
	private JLabel receiveBufferSize;
	private JLabel mainServer;
	
	private String selectedServer;
	
	private static Client self;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog lDialog = new LoginDialog();
					lDialog.setVisible(true);
					lDialog.setAlwaysOnTop(true);
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
		self = this;
		
		setType(Type.POPUP);
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
		comboBox.setFont(new Font("Courier New", Font.PLAIN, 11));
		comboBox.setToolTipText("Select server");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Server: main"}));
		comboBox.setForeground(Color.LIGHT_GRAY);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(10, 11, 128, 22);
		comboBox.setBorder(new LineBorder(new Color(0,0,0)));
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedServer = (String) comboBox.getSelectedItem();
				loadData(selectedServer);
			}
		});
		layeredPane_1.add(comboBox);
		
		this.servers = comboBox;
		
		JButton btnNewButton = new JButton("support");
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 11));
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
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(741, 11, 89, 23);
		layeredPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reload");
		btnNewButton_1.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
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
		layeredPane_4.setBounds(10, 24, 291, 134);
		layeredPane_2.add(layeredPane_4);
		
		JLabel lblNewLabel_1 = new JLabel("Online:");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 11, 152, 14);
		layeredPane_4.add(lblNewLabel_1);
		
		JLabel online_players = new JLabel("0");
		online_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		online_players.setForeground(Color.LIGHT_GRAY);
		online_players.setBounds(172, 11, 109, 14);
		layeredPane_4.add(online_players);
		this.Online = online_players;
		
		JLabel lblNewLabel_2 = new JLabel("Registered:");
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 61, 152, 14);
		layeredPane_4.add(lblNewLabel_2);
		
		JLabel registered_players = new JLabel("0");
		registered_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		registered_players.setForeground(Color.LIGHT_GRAY);
		registered_players.setBounds(172, 61, 109, 14);
		Registered = registered_players;
		layeredPane_4.add(registered_players);
		
		JLabel lblNewLabel_3 = new JLabel("Today joined:");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(10, 86, 152, 14);
		layeredPane_4.add(lblNewLabel_3);
		
		JLabel today_joined = new JLabel("0");
		today_joined.setFont(new Font("Courier New", Font.PLAIN, 11));
		today_joined.setForeground(Color.LIGHT_GRAY);
		today_joined.setBounds(172, 86, 109, 14);
		Today_joined = today_joined;
		layeredPane_4.add(today_joined);
		
		JLabel lblNewLabel_4 = new JLabel("Today Registered:");
		lblNewLabel_4.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(10, 111, 152, 14);
		layeredPane_4.add(lblNewLabel_4);
		
		JLabel today_registered_players = new JLabel("0");
		today_registered_players.setFont(new Font("Courier New", Font.PLAIN, 11));
		today_registered_players.setForeground(Color.LIGHT_GRAY);
		today_registered_players.setBounds(172, 111, 109, 14);
		Today_registered = today_registered_players;
		layeredPane_4.add(today_registered_players);
		
		JLabel lblNewLabel_5 = new JLabel("Maximum:");
		lblNewLabel_5.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(10, 36, 152, 14);
		layeredPane_4.add(lblNewLabel_5);
		
		JLabel maximum = new JLabel("0");
		maximum.setFont(new Font("Courier New", Font.PLAIN, 11));
		maximum.setForeground(Color.LIGHT_GRAY);
		maximum.setBounds(172, 36, 109, 14);
		this.Maximum = maximum;
		layeredPane_4.add(maximum);
		
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
		network_name.setBounds(142, 11, 149, 14);
		Network_name = network_name;
		layeredPane_5.add(network_name);
		
		JLabel spigot_address = new JLabel("127.0.0.1:1997");
		spigot_address.setFont(new Font("Courier New", Font.PLAIN, 11));
		spigot_address.setForeground(Color.LIGHT_GRAY);
		spigot_address.setBounds(142, 36, 149, 14);
		Address = spigot_address;
		layeredPane_5.add(spigot_address);
		
		JLabel isSubServer = new JLabel("-");
		isSubServer.setFont(new Font("Courier New", Font.PLAIN, 11));
		isSubServer.setForeground(Color.LIGHT_GRAY);
		isSubServer.setBounds(142, 61, 149, 14);
		this.isSubServer = isSubServer;
		layeredPane_5.add(isSubServer);
		
		JLabel receiveBufferSize = new JLabel("-");
		receiveBufferSize.setFont(new Font("Courier New", Font.PLAIN, 11));
		receiveBufferSize.setForeground(Color.LIGHT_GRAY);
		receiveBufferSize.setBounds(142, 86, 149, 14);
		this.receiveBufferSize = receiveBufferSize;
		layeredPane_5.add(receiveBufferSize);
		
		JLabel main_Server_address = new JLabel("127.0.0.1:1997");
		main_Server_address.setFont(new Font("Courier New", Font.PLAIN, 11));
		main_Server_address.setForeground(Color.LIGHT_GRAY);
		main_Server_address.setBounds(142, 111, 149, 14);
		mainServer = main_Server_address;
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
		textArea.setFont(new Font("Courier New", Font.PLAIN, 11));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(50, 11, 479, 377);
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
		
		JLayeredPane layeredPane_9 = new JLayeredPane();
		layeredPane_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_9.setBounds(10, 354, 291, 114);
		layeredPane_2.add(layeredPane_9);
		
		JButton reload_btn = new JButton("reload");
		reload_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		reload_btn.setBackground(Color.DARK_GRAY);
		reload_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
		reload_btn.setForeground(Color.GREEN);
		reload_btn.setBounds(53, 11, 89, 23);
		reload_btn.setBorder(new LineBorder(new Color(0,0,0)));
		layeredPane_9.add(reload_btn);
		
		JButton stop_btn = new JButton("stop");
		stop_btn.setBackground(Color.DARK_GRAY);
		stop_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
		stop_btn.setForeground(Color.RED);
		stop_btn.setBounds(152, 11, 89, 23);
		stop_btn.setBorder(new LineBorder(new Color(0,0,0)));
		layeredPane_9.add(stop_btn);
		
		JButton reload_network_btn = new JButton("reload network");
		reload_network_btn.setBackground(Color.DARK_GRAY);
		reload_network_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
		reload_network_btn.setForeground(Color.GREEN);
		reload_network_btn.setBounds(53, 45, 188, 23);
		reload_network_btn.setBorder(new LineBorder(new Color(0,0,0)));
		layeredPane_9.add(reload_network_btn);
		
		JButton stop_network_btn = new JButton("stop network");
		stop_network_btn.setBackground(Color.DARK_GRAY);
		stop_network_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
		stop_network_btn.setForeground(Color.RED);
		stop_network_btn.setBounds(53, 80, 188, 23);
		stop_network_btn.setBorder(new LineBorder(new Color(0,0,0)));
		layeredPane_9.add(stop_network_btn);
		
		JLabel lblNewLabel_13 = new JLabel("Options:");
		lblNewLabel_13.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_13.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_13.setBounds(20, 339, 127, 14);
		layeredPane_2.add(lblNewLabel_13);
		
		JPanel layeredPane_3 = new JPanel();
		layeredPane_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_3.setLayout(null);
		
		
		onStart();
	}

	private void onStart() {
		/*
		 * TODO:
		 * - load config of active server
		 */
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
				if(strMsg.startsWith("setServers")) {
					String[] args = strMsg.split(" ");
					try {
						String[] servers = args[1].split(";");
						setServers(servers);
					}catch(Exception exception) {
						
					}
				}
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
			
				if(strMsg.startsWith("setPlayerAmount")) {
					String[] args = strMsg.split(" ");
					if(args.length == 2) {
						if(self.selectedServer.equals("all")) {
							try {
								setOnline(Integer.parseInt(args[1]));
							}catch(Exception exception) {
								
							}
						}
					}else if(args.length == 3) {
						if(self.selectedServer.equals(args[1])) {
							try {
								setOnline(Integer.parseInt(args[2]));
							}catch(Exception exception) {
								
							}
						}
					}
					
				}

				System.out.println(strMsg);
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
			
				if(strMsg.startsWith("setMaximum")) {
					String[] args = strMsg.split(" ");
					if(args.length == 2) {
						if(self.selectedServer.equals("all")) {
							try {
								setMaximum(Integer.parseInt(args[1]));
							}catch(Exception exception) {
								
							}
						}
					}else if(args.length == 3) {
						if(self.selectedServer.equals(args[1])) {
							try {
								setMaximum(Integer.parseInt(args[2]));
							}catch(Exception exception) {
								
							}
						}
					}
				}
				
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
		
				if(strMsg.startsWith("setAddress")) {
					String[] args = strMsg.split(" ");
					if(args.length == 3) {
						if(self.selectedServer.equals(args[1])) {
							setAddress(args[2]);
						}
					}else if(args.length == 2) {
						if(self.selectedServer.equals(args[1])||args[1].equals("null")) {
							setAddress("-");
						}
					}
				}
		
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
				if(strMsg.startsWith("setMainServer")) {
					String[] args = strMsg.split(" ");
					if(args.length == 2) {
						setMainServer(args[1]);
					}
				}
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
				if(strMsg.startsWith("setReceiveBufferSize")) {
					String[] args = strMsg.split(" ");
					if(args.length == 2) {
						setReceiveBufferSize(args[1]);
					}
				}
			}
		});
		
		Connection.addHandler(new MessageHandler() {
			
			@Override
			public void handle(String strMsg, byte[] byteMsg) {
				if(strMsg.startsWith("setIsSubServer")) {
					String[] args = strMsg.split(" ");
					
					if(args.length == 3) {
						if(selectedServer.equals(args[1])) {
							setIsSubServer(args[2]);
						}
					}
				}
			}
		});
		
		Connection.sendStr("getServers");
		Connection.sendStr("getPlayerAmount");
		Connection.sendStr("getMaximum");
		Connection.sendStr("getAddress "+selectedServer);
		Connection.sendStr("getMainServer");
		Connection.sendStr("getReceiveBufferSize");
		Connection.sendStr("getIsSubServer "+selectedServer);
	}
	
	public static void loadData(String server) {
		setNetworkName(server);
		
		if(server.equals("all")) {
			Connection.sendStr("getPlayerAmount");
			Connection.sendStr("getMaximum");
		}else {
			Connection.sendStr("getPlayerAmount "+server);
			Connection.sendStr("getMaximum "+server);	
		}
		Connection.sendStr("getAddress "+server);
		Connection.sendStr("getMainServer");
		Connection.sendStr("getReceiveBufferSize");
		Connection.sendStr("getIsSubServer "+server);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setServers(String[] _servers) {
		String[] servers = new String[_servers.length+1];
		
		for(int i = 0; i < _servers.length; i++) {
			servers[i+1] = _servers[i];
		}
		
		servers[0] = "all";
		
		self.servers.setModel(new DefaultComboBoxModel(servers));
		self.selectedServer = "all";
	}
	
	public static void setNetworkName(String name) {
		self.Network_name.setText(name);
	}
	
	public static void setMaximum(int maximum) {
		self.Maximum.setText(maximum+"");
	}
	
	public static void setAddress(String address) {
		self.Address.setText(address);
	}

	public static void setMainServer(String address) {
		self.mainServer.setText(address);
	}
	
	public static void setReceiveBufferSize(String size) {
		self.receiveBufferSize.setText(size);
	}
	
	public static void setIsSubServer(String isSubServer) {
		self.isSubServer.setText(isSubServer);
	}
	
	public static void setOnline(int online) {
		self.Online.setText(online+"");
	}
}
