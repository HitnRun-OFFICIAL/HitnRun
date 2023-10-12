package com.HitnRun.views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class LoginCreate extends JFrame {

	private JFrame frame;
	private JTextField textFieldFirstName;
	private JPasswordField passwordField;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldContact;
	private JTextField textFieldUsername;
	
	
	public LoginCreate() {
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreate = new JLabel("Create an Account");
		lblCreate.setFont(new Font("Cascadia Code", Font.BOLD, 25));
		lblCreate.setBounds(20, 16, 280, 30);
		frame.getContentPane().add(lblCreate);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblUsername.setBounds(56, 238, 66, 13);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cascadia Code", Font.BOLD, 11));
		lblPassword.setBounds(68, 279, 54, 13);
		frame.getContentPane().add(lblPassword);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(132, 79, 239, 19);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 276, 239, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Already have an account?");
		btnLogIn.setFont(new Font("Cascadia Code", Font.PLAIN, 10));
		btnLogIn.setBounds(127, 409, 195, 21);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setFont(new Font("Cascadia Code", Font.BOLD, 11));
		btnCreate.setBounds(148, 333, 148, 21);
		frame.getContentPane().add(btnCreate);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(132, 117, 239, 19);
		frame.getContentPane().add(textFieldLastName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(132, 155, 239, 19);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldContact = new JTextField();
		textFieldContact.setColumns(10);
		textFieldContact.setBounds(132, 195, 239, 19);
		frame.getContentPane().add(textFieldContact);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(132, 236, 239, 19);
		frame.getContentPane().add(textFieldUsername);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblFirstName.setBounds(47, 82, 75, 13);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblLastName.setBounds(47, 119, 75, 13);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblEmail.setBounds(24, 157, 98, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact Number");
		lblContact.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblContact.setBounds(16, 197, 106, 13);
		frame.getContentPane().add(lblContact);
	}

}
