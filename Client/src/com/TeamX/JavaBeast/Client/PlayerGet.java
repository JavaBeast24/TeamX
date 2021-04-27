package com.TeamX.JavaBeast.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class PlayerGet extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerGet frame = new PlayerGet();
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
	public PlayerGet() {
		setResizable(false);
		setTitle("TeamX - v 2.0 - PLAYERNAME");
		setType(Type.POPUP);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 713);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.DARK_GRAY);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("PLAYERNAME");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 404, 14);
		layeredPane.add(lblNewLabel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_1.setBounds(10, 25, 404, 634);
		layeredPane.add(layeredPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("name:");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 11, 131, 14);
		layeredPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UUID:");
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 36, 131, 14);
		layeredPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("isOnline:");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(10, 61, 131, 14);
		layeredPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("online on:");
		lblNewLabel_4.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(10, 86, 131, 14);
		layeredPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("isBanned:");
		lblNewLabel_5.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(10, 111, 131, 14);
		layeredPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("times Reported:");
		lblNewLabel_6.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setBounds(10, 136, 131, 14);
		layeredPane_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("world:");
		lblNewLabel_7.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(10, 161, 131, 14);
		layeredPane_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("address:");
		lblNewLabel_8.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_8.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8.setBounds(10, 186, 131, 14);
		layeredPane_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("allow Flight:");
		lblNewLabel_9.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_9.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_9.setBounds(10, 211, 131, 14);
		layeredPane_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("DisplayName:");
		lblNewLabel_10.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_10.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_10.setBounds(10, 236, 131, 14);
		layeredPane_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Fly speed:");
		lblNewLabel_11.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_11.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_11.setBounds(10, 261, 131, 14);
		layeredPane_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("FoodLevel");
		lblNewLabel_12.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_12.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_12.setBounds(10, 286, 131, 14);
		layeredPane_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("HealthScale:");
		lblNewLabel_13.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_13.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_13.setBounds(10, 311, 131, 14);
		layeredPane_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Health:");
		lblNewLabel_14.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_14.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_14.setBounds(10, 336, 131, 14);
		layeredPane_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Level:");
		lblNewLabel_15.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_15.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_15.setBounds(10, 361, 131, 14);
		layeredPane_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("ListName:");
		lblNewLabel_16.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_16.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_16.setBounds(10, 386, 131, 14);
		layeredPane_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_18 = new JLabel("Weather:");
		lblNewLabel_18.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_18.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_18.setBounds(10, 411, 131, 14);
		layeredPane_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_17 = new JLabel("Walkspeed:");
		lblNewLabel_17.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_17.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_17.setBounds(10, 436, 131, 14);
		layeredPane_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_19 = new JLabel("isFlying:");
		lblNewLabel_19.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_19.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_19.setBounds(10, 461, 131, 14);
		layeredPane_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("isSleeping:");
		lblNewLabel_20.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_20.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_20.setBounds(10, 486, 131, 14);
		layeredPane_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("isSprinting:");
		lblNewLabel_21.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_21.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_21.setBounds(10, 511, 131, 14);
		layeredPane_1.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("customName:");
		lblNewLabel_22.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_22.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_22.setBounds(10, 536, 131, 14);
		layeredPane_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("EntityID:");
		lblNewLabel_23.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_23.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_23.setBounds(10, 561, 131, 14);
		layeredPane_1.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("gamemode:");
		lblNewLabel_24.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_24.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_24.setBounds(10, 586, 131, 14);
		layeredPane_1.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("maximumHealth:");
		lblNewLabel_25.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblNewLabel_25.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_25.setBounds(10, 611, 131, 14);
		layeredPane_1.add(lblNewLabel_25);
		
		JLabel player_name = new JLabel("-");
		player_name.setForeground(Color.LIGHT_GRAY);
		player_name.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_name.setBounds(151, 11, 243, 14);
		layeredPane_1.add(player_name);
		
		JLabel player_UUID = new JLabel("-");
		player_UUID.setForeground(Color.LIGHT_GRAY);
		player_UUID.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_UUID.setBounds(151, 36, 243, 14);
		layeredPane_1.add(player_UUID);
		
		JLabel player_isOnline = new JLabel("-");
		player_isOnline.setForeground(Color.LIGHT_GRAY);
		player_isOnline.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_isOnline.setBounds(151, 61, 243, 14);
		layeredPane_1.add(player_isOnline);
		
		JLabel player_online_on = new JLabel("-");
		player_online_on.setForeground(Color.LIGHT_GRAY);
		player_online_on.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_online_on.setBounds(151, 86, 243, 14);
		layeredPane_1.add(player_online_on);
		
		JLabel player_isBanned = new JLabel("-");
		player_isBanned.setForeground(Color.LIGHT_GRAY);
		player_isBanned.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_isBanned.setBounds(151, 111, 243, 14);
		layeredPane_1.add(player_isBanned);
		
		JLabel player_times_reported = new JLabel("-");
		player_times_reported.setForeground(Color.LIGHT_GRAY);
		player_times_reported.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_times_reported.setBounds(151, 136, 243, 14);
		layeredPane_1.add(player_times_reported);
		
		JLabel player_world = new JLabel("-");
		player_world.setForeground(Color.LIGHT_GRAY);
		player_world.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_world.setBounds(151, 161, 243, 14);
		layeredPane_1.add(player_world);
		
		JLabel player_address = new JLabel("-");
		player_address.setForeground(Color.LIGHT_GRAY);
		player_address.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_address.setBounds(151, 186, 243, 14);
		layeredPane_1.add(player_address);
		
		JLabel player_allow_flight = new JLabel("-");
		player_allow_flight.setForeground(Color.LIGHT_GRAY);
		player_allow_flight.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_allow_flight.setBounds(151, 211, 243, 14);
		layeredPane_1.add(player_allow_flight);
		
		JLabel player_DisplayName = new JLabel("-");
		player_DisplayName.setForeground(Color.LIGHT_GRAY);
		player_DisplayName.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_DisplayName.setBounds(151, 236, 243, 14);
		layeredPane_1.add(player_DisplayName);
		
		JLabel player_fly_speed = new JLabel("-");
		player_fly_speed.setForeground(Color.LIGHT_GRAY);
		player_fly_speed.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_fly_speed.setBounds(151, 261, 243, 14);
		layeredPane_1.add(player_fly_speed);
		
		JLabel player_foodLevel = new JLabel("-");
		player_foodLevel.setForeground(Color.LIGHT_GRAY);
		player_foodLevel.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_foodLevel.setBounds(151, 286, 243, 14);
		layeredPane_1.add(player_foodLevel);
		
		JLabel player_healthScale = new JLabel("-");
		player_healthScale.setForeground(Color.LIGHT_GRAY);
		player_healthScale.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_healthScale.setBounds(151, 311, 243, 14);
		layeredPane_1.add(player_healthScale);
		
		JLabel player_health = new JLabel("-");
		player_health.setForeground(Color.LIGHT_GRAY);
		player_health.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_health.setBounds(151, 336, 243, 14);
		layeredPane_1.add(player_health);
		
		JLabel player_level = new JLabel("-");
		player_level.setForeground(Color.LIGHT_GRAY);
		player_level.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_level.setBounds(151, 361, 243, 14);
		layeredPane_1.add(player_level);
		
		JLabel player_listName = new JLabel("-");
		player_listName.setForeground(Color.LIGHT_GRAY);
		player_listName.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_listName.setBounds(151, 386, 243, 14);
		layeredPane_1.add(player_listName);
		
		JLabel player_weather = new JLabel("-");
		player_weather.setForeground(Color.LIGHT_GRAY);
		player_weather.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_weather.setBounds(151, 411, 243, 14);
		layeredPane_1.add(player_weather);
		
		JLabel player_walkspeed = new JLabel("-");
		player_walkspeed.setForeground(Color.LIGHT_GRAY);
		player_walkspeed.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_walkspeed.setBounds(151, 436, 243, 14);
		layeredPane_1.add(player_walkspeed);
		
		JLabel player_isFlying = new JLabel("-");
		player_isFlying.setForeground(Color.LIGHT_GRAY);
		player_isFlying.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_isFlying.setBounds(151, 461, 243, 14);
		layeredPane_1.add(player_isFlying);
		
		JLabel player_isSleeping = new JLabel("-");
		player_isSleeping.setForeground(Color.LIGHT_GRAY);
		player_isSleeping.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_isSleeping.setBounds(151, 486, 243, 14);
		layeredPane_1.add(player_isSleeping);
		
		JLabel player_isSprinting = new JLabel("-");
		player_isSprinting.setForeground(Color.LIGHT_GRAY);
		player_isSprinting.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_isSprinting.setBounds(151, 511, 243, 14);
		layeredPane_1.add(player_isSprinting);
		
		JLabel player_customName = new JLabel("-");
		player_customName.setForeground(Color.LIGHT_GRAY);
		player_customName.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_customName.setBounds(151, 536, 243, 14);
		layeredPane_1.add(player_customName);
		
		JLabel player_entityID = new JLabel("-");
		player_entityID.setForeground(Color.LIGHT_GRAY);
		player_entityID.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_entityID.setBounds(151, 561, 243, 14);
		layeredPane_1.add(player_entityID);
		
		JLabel player_gamemode = new JLabel("-");
		player_gamemode.setForeground(Color.LIGHT_GRAY);
		player_gamemode.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_gamemode.setBounds(151, 586, 243, 14);
		layeredPane_1.add(player_gamemode);
		
		JLabel player_maximumHealth = new JLabel("-");
		player_maximumHealth.setForeground(Color.LIGHT_GRAY);
		player_maximumHealth.setFont(new Font("Courier New", Font.PLAIN, 11));
		player_maximumHealth.setBounds(151, 611, 243, 14);
		layeredPane_1.add(player_maximumHealth);
	}

}
