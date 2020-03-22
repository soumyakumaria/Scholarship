package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LoginScreen {

	private static final String[] args = null;
	private JFrame frame;
	private JLabel lblEmergingUniversity;
	private JTextField textField;
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
		//Form.main(args); ---------works
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		JFrame secondFrame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 128));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		lblEmergingUniversity = new JLabel("Emerging University");
		lblEmergingUniversity.setForeground(new Color(0, 0, 128));
		lblEmergingUniversity.setFont(new Font("Sitka Text", Font.PLAIN, 28));
		lblEmergingUniversity.setBounds(81, 13, 302, 58);
		frame.getContentPane().add(lblEmergingUniversity);
		
		textField = new JTextField();
		textField.setBounds(91, 84, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 87, 92, 16);
		frame.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 117, 116, 22);
		frame.getContentPane().add(passwordField);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 120, 77, 16);
		frame.getContentPane().add(lblPassword);
		
		btnLogin = new JButton("Login");
		JButton btnCreateAUser = new JButton("Create a user ");
		
		
			
		
		
	
		btnLogin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String realUsr = "Soumya";
				String realPass="Seng2020";
				String inputUsr = textField.getText();
				String inputPss =  	passwordField.getText();
				if(login(inputUsr, inputPss)) {
					JOptionPane.showMessageDialog(null, "the username and password are valid");
					
				}
				else {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "the username and password are invalid");
					
				}
				
			}
		});
		btnLogin.setBounds(91, 158, 116, 25);
		frame.getContentPane().add(btnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(235, 61, 185, 179);
		frame.getContentPane().add(lblNewLabel);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/da58fd2d-2682-456a-a827-54e4b2dea8bd_200x200.png").getFile());
		lblNewLabel.setIcon(img);
		
		
		
		btnCreateAUser.setBounds(89, 196, 118, 25);
		frame.getContentPane().add(btnCreateAUser);
		btnCreateAUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				try {
					Form.main(args);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
				
			}
		});
	}
	/**
	 * This method checks if the email
	 * and password input are valid
	 * @param email
	 * @param password
	 * @return
	 */
	
	public static boolean login(String email, String password) {
		File users = new File("users.txt");
		System.out.println(email + "   " + password);
		try {
			Scanner read = new Scanner(users);
			String temp = "";
			while(!temp.equals(email) && read.hasNextLine())
				temp = read.nextLine();
			
			if(read.hasNextLine()) {
				read.nextLine();
				temp = read.nextLine();
			} else {
				return false;
			}
			read.close();
			if(!temp.equals(password)) {
				return false;
			}
			
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
