package com.TeamX.JavaBeast.Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	
	private LoginDialog self;

	public LoginDialog() {
		setSelf(this);
		setBounds(100, 100, 213, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(layeredPane);
			
			textField = new JTextField();
			textField.setText("127.0.0.1:1997");
			textField.setFont(new Font("Courier New", Font.PLAIN, 11));
			textField.setBounds(10, 32, 108, 20);
			layeredPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Address:");
			lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 11));
			lblNewLabel.setBackground(Color.DARK_GRAY);
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(10, 11, 232, 14);
			layeredPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Username:");
			lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 11));
			lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_1.setBounds(10, 63, 108, 14);
			layeredPane.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(10, 88, 108, 20);
			layeredPane.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Password:");
			lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 11));
			lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_2.setBounds(10, 119, 108, 14);
			layeredPane.add(lblNewLabel_2);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(10, 144, 108, 20);
			layeredPane.add(passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("login");
				okButton.setFont(new Font("Courier New", Font.PLAIN, 11));
				okButton.setForeground(Color.LIGHT_GRAY);
				okButton.setBackground(Color.DARK_GRAY);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
						String[] ip_port_data = textField.getText().split(":");
						String ip = ip_port_data[0];
						int port = Integer.parseInt(ip_port_data[1]);
						
						String username = textField_1.getText();
						String password = new String(passwordField.getPassword());
						
						if(Connection.tryConnect(ip, port, username, password)) {
							Client frame = new Client();
							frame.setVisible(true);
							
							self.setVisible(false);
						}else {
							textField_1.setText("");
							textField.setText("");
							passwordField.setText("");
						}
						
						}catch(Exception exception) {
							textField_1.setText("");
							textField.setText("");
							passwordField.setText("");
						}	
					}
						
				});
			}
		}
	}

	public LoginDialog getSelf() {
		return self;
	}

	public void setSelf(LoginDialog self) {
		this.self = self;
	}
}
