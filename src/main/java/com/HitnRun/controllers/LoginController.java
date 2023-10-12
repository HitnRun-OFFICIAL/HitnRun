package com.HitnRun.controllers;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.HitnRun.views.*;
public class LoginController {

	public LoginController() {
		LoginView window = new LoginView();
		window.getFrame().setVisible(true);
	}
	
}
