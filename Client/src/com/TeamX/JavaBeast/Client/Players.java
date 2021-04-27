package com.TeamX.JavaBeast.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Players extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField player_search_bar;
	
	private JPanel playerList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Players frame = new Players();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static List<String> players = new ArrayList<>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Players() {
		setResizable(false);
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setBackground(Color.DARK_GRAY);
		setTitle("TeamX - v 2.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
        
		
		JPanel panel = new JPanel(new GridLayout(100, 1, 10, 10));
		panel.setBackground(Color.DARK_GRAY);
		this.playerList = panel;
        
        for(int i = 0; i < 2500; i++) {
        	players.add("test "+i);
        }
        
        setPlayers(players);
        
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10, 40, 200, 500);
        
        scrollPane.setSize(200, 500);
        layeredPane.add(scrollPane);
        
        player_search_bar = new JTextField();
        player_search_bar.setToolTipText("Search player");
        player_search_bar.setBounds(10, 11, 200, 20);
        layeredPane.add(player_search_bar);
        player_search_bar.setColumns(10);
        
        JComboBox online_offline_box = new JComboBox();
        online_offline_box.setModel(new DefaultComboBoxModel(new String[] {"all", "online", "offline"}));
        online_offline_box.setBounds(220, 10, 98, 22);
        layeredPane.add(online_offline_box);
        
        JComboBox server_box = new JComboBox();
        server_box.setModel(new DefaultComboBoxModel(new String[] {"Server: all"}));
        server_box.setBounds(328, 10, 98, 22);
        layeredPane.add(server_box);
        
        JLayeredPane layeredPane_1 = new JLayeredPane();
        layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        layeredPane_1.setBounds(220, 40, 305, 227);
        layeredPane.add(layeredPane_1);
        
        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(10, 11, 120, 14);
        layeredPane_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("UUID:");
        lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_1.setBounds(10, 36, 120, 14);
        layeredPane_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("isOnline:");
        lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_2.setBounds(10, 61, 120, 14);
        layeredPane_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("online on:");
        lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_3.setBounds(10, 86, 120, 14);
        layeredPane_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("is Banned:");
        lblNewLabel_4.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_4.setBounds(10, 111, 120, 14);
        layeredPane_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("times reported:");
        lblNewLabel_5.setFont(new Font("Courier New", Font.PLAIN, 11));
        lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_5.setBounds(10, 136, 120, 14);
        layeredPane_1.add(lblNewLabel_5);
        
        JButton more_options_btn = new JButton("more options");
        more_options_btn.setBorder(new LineBorder(new Color(0, 0, 0)));
        more_options_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        more_options_btn.setBackground(Color.DARK_GRAY);
        more_options_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        more_options_btn.setForeground(Color.LIGHT_GRAY);
        more_options_btn.setBounds(10, 193, 285, 23);
        layeredPane_1.add(more_options_btn);
        
        JLabel player_name = new JLabel("-");
        player_name.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_name.setForeground(Color.LIGHT_GRAY);
        player_name.setBounds(140, 10, 155, 14);
        layeredPane_1.add(player_name);
        
        JLabel player_UUID = new JLabel("-");
        player_UUID.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_UUID.setForeground(Color.LIGHT_GRAY);
        player_UUID.setBounds(140, 35, 155, 14);
        layeredPane_1.add(player_UUID);
        
        JLabel player_isOnline = new JLabel("-");
        player_isOnline.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_isOnline.setForeground(Color.LIGHT_GRAY);
        player_isOnline.setBounds(140, 60, 155, 14);
        layeredPane_1.add(player_isOnline);
        
        JLabel player_online_on = new JLabel("-");
        player_online_on.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_online_on.setForeground(Color.LIGHT_GRAY);
        player_online_on.setBounds(140, 85, 155, 14);
        layeredPane_1.add(player_online_on);
        
        JLabel player_isBanned = new JLabel("-");
        player_isBanned.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_isBanned.setForeground(Color.LIGHT_GRAY);
        player_isBanned.setBounds(140, 110, 155, 14);
        layeredPane_1.add(player_isBanned);
        
        JLabel player_times_reported = new JLabel("-");
        player_times_reported.setFont(new Font("Courier New", Font.PLAIN, 11));
        player_times_reported.setForeground(Color.LIGHT_GRAY);
        player_times_reported.setBounds(140, 135, 155, 14);
        layeredPane_1.add(player_times_reported);
        
        JLayeredPane layeredPane_2 = new JLayeredPane();
        layeredPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        layeredPane_2.setBounds(220, 278, 305, 262);
        layeredPane.add(layeredPane_2);
        
        JButton teleport_btn = new JButton("Teleport");
        teleport_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        teleport_btn.setBackground(Color.DARK_GRAY);
        teleport_btn.setForeground(Color.LIGHT_GRAY);
        teleport_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        teleport_btn.setBounds(10, 11, 89, 23);
        teleport_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(teleport_btn);
        
        JButton kick_btn = new JButton("Kick");
        kick_btn.setBackground(Color.DARK_GRAY);
        kick_btn.setForeground(Color.LIGHT_GRAY);
        kick_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        kick_btn.setBounds(10, 45, 89, 23);
        kick_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(kick_btn);
        
        kick_input = new JTextField();
        kick_input.setForeground(Color.DARK_GRAY);
        kick_input.setFont(new Font("Courier New", Font.PLAIN, 11));
        kick_input.setBounds(109, 46, 186, 20);
        layeredPane_2.add(kick_input);
        kick_input.setColumns(10);
        
        JButton ban_btn = new JButton("Ban");
        ban_btn.setBackground(Color.DARK_GRAY);
        ban_btn.setForeground(Color.LIGHT_GRAY);
        ban_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        ban_btn.setBounds(10, 79, 89, 23);
        ban_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(ban_btn);
        
        ban_input = new JTextField();
        ban_input.setForeground(Color.DARK_GRAY);
        ban_input.setFont(new Font("Courier New", Font.PLAIN, 11));
        ban_input.setBounds(109, 80, 186, 20);
        layeredPane_2.add(ban_input);
        ban_input.setColumns(10);
        
        JButton send_msg_btn = new JButton("send Messsage");
        send_msg_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        send_msg_btn.setBackground(Color.DARK_GRAY);
        send_msg_btn.setForeground(Color.LIGHT_GRAY);
        send_msg_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        send_msg_btn.setBounds(10, 113, 285, 23);
        send_msg_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(send_msg_btn);
        
        send_msg_input = new JTextField();
        send_msg_input.setForeground(Color.DARK_GRAY);
        send_msg_input.setFont(new Font("Courier New", Font.PLAIN, 11));
        send_msg_input.setBounds(10, 147, 285, 20);
        layeredPane_2.add(send_msg_input);
        send_msg_input.setColumns(10);
        
        JButton allow_flight_btn = new JButton("allow flight");
        allow_flight_btn.setBackground(Color.DARK_GRAY);
        allow_flight_btn.setForeground(Color.LIGHT_GRAY);
        allow_flight_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        allow_flight_btn.setBounds(10, 212, 285, 23);
        allow_flight_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(allow_flight_btn);
        
        JButton teleport_here_btn = new JButton("Teleport here");
        teleport_here_btn.setBackground(Color.DARK_GRAY);
        teleport_here_btn.setForeground(Color.LIGHT_GRAY);
        teleport_here_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        teleport_here_btn.setBounds(109, 11, 186, 23);
        teleport_here_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(teleport_here_btn);
        
        JButton disallow_flight_btn = new JButton("disallow flight");
        disallow_flight_btn.setBackground(Color.DARK_GRAY);
        disallow_flight_btn.setForeground(Color.LIGHT_GRAY);
        disallow_flight_btn.setFont(new Font("Courier New", Font.PLAIN, 11));
        disallow_flight_btn.setBounds(10, 178, 285, 23);
        disallow_flight_btn.setBorder(new LineBorder(new Color(0,0,0)));
        layeredPane_2.add(disallow_flight_btn);
        player_search_bar.addKeyListener(this);
	}
	
	private JLabel player;
	private JPanel _player;
	private JTextField kick_input;
	private JTextField ban_input;
	private JTextField send_msg_input;
	
	public void setPlayers(List<String> players) {

		playerList.setLayout(new GridLayout(players.size(), 1));
		
        for (int i = 0; i < players.size(); i++) {
        	JPanel btn = new JPanel();
        	btn.setBorder(new LineBorder(new Color(0, 0, 0)));
        	JLabel label = new JLabel(players.get(i));
        	label.setForeground(Color.LIGHT_GRAY);
        	btn.add(label);
        	btn.setLocation(10, 10 + i*(btn.getHeight()+10));
        	btn.setBackground(Color.DARK_GRAY);
        	btn.setForeground(Color.LIGHT_GRAY);
        	btn.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(_player!=null) {
						_player.setBorder(new LineBorder(new Color(0, 0, 0)));
					}
					player = label;
					_player = btn;
					btn.setBorder(new LineBorder(Color.CYAN));
				}
			});
            playerList.add(btn);
        }
       
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	    List<String> setPlayers = new ArrayList<>();
	    
	    for(String s:players) {
	    	if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
		    	if(s.contains(player_search_bar.getText()+e.getKeyChar())) {
		    		setPlayers.add(s);
		    	}
	    	}else {
		    	if(s.contains(player_search_bar.getText())) {
		    		setPlayers.add(s);
		    	}
	    	}
	    }

		playerList.removeAll();
		
	    setPlayers(setPlayers);
	    
	    
		playerList.revalidate();
		playerList.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}
}
