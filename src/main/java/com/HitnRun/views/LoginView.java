package com.HitnRun.views;


import java.awt.EventQueue;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


//import com.HitnRun.controllers.Login;

public class LoginView extends JFrame {

		/*	public void run() {
				try {
					LoginController window = new LoginController();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			*/
	

	private JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	
	public LoginView() {
		initialize();
	}



	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Cascadia Code", Font.BOLD, 25));
		lblLogIn.setBounds(20, 16, 102, 30);
		frame.getContentPane().add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		lblUsername.setBounds(56, 81, 66, 13);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cascadia Code", Font.BOLD, 11));
		lblPassword.setBounds(56, 120, 54, 13);
		frame.getContentPane().add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(132, 79, 239, 19);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 117, 239, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Cascadia Code", Font.BOLD, 11));
		btnLogIn.setBounds(182, 157, 85, 21);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnForgot = new JButton("Forgot Password?");
		btnForgot.setFont(new Font("Cascadia Code", Font.PLAIN, 10));
		btnForgot.setBounds(20, 219, 141, 21);
		frame.getContentPane().add(btnForgot);
		
		JButton btnCreate = new JButton("Create an Account");
		btnCreate.setFont(new Font("Cascadia Code", Font.PLAIN, 10));
		btnCreate.setBounds(263, 219, 148, 21);
		frame.getContentPane().add(btnCreate);
		
		/*
		 btnCreate.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            // Create and display the second JFrame when the button is clicked
		        	LoginCreate LCreate = new LoginCreate();
		        	
		          //  SecondFrame secondFrame = new SecondFrame();
		          //  secondFrame.setVisible(true);
		      //  }
		        }
		*/
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and display the second JFrame when the button is clicked
                LoginCreate LCreate = new LoginCreate();
                LCreate.setVisible(true);
            }
        });
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	//Reminder to add a thread to submit 
	
	//Move to create Login
	//Add another thread to check for Password validity
	//Better create this in our side for Create Login
}



