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
/**
 * 
 * @author Soumya Kumaria, Cam Hermann
 * This class creates the login screen for
 * the user.
 *
 */
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Central Authentication Service");
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
		
		btnLogin = new JButton("Log In");
		JButton btnCreateAUser = new JButton("Sign Up");
		
		
			
		
		/**
		 * This action listener displays a dialog
		 * box to let the user know if the username and password input is valid.
		 * The action listener starts listening only after the Log In button 
		 * is pressed.
		 */
	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputUsr = textField.getText();
				String inputPss =  	passwordField.getText();
				String userType = login(inputUsr, inputPss);
				
				/**
				 * If the user type that logs in is student, then StudentWindow is opened
				 */
				if(userType.equals("student")) {
					frame.dispose();
					StudentWindow.main(args);
				} else if(userType.equals("scholarship coordinator")) {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "the user is a scholarship coordinator");
				} else {
					JOptionPane.showMessageDialog(null, "the username and password are invalid");
				}
				
			}
		});
		btnLogin.setBounds(91, 158, 116, 25);
		frame.getContentPane().add(btnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(235, 61, 185, 179);
		frame.getContentPane().add(lblNewLabel);
		//ImageIcon img =new ImageIcon(this.getClass().getResource("/da58fd2d-2682-456a-a827-54e4b2dea8bd_200x200.png").getFile());
		//lblNewLabel.setIcon(img);
		
		
		
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
	 * @return true if login is successful, false otherwise.
	 */
	public static String login(String email, String password) {
		File users = new File("students.txt");
		for(int i = 0; i <= 1; i++) {
			try {
				Scanner read = new Scanner(users);
				String temp = " ";
				while(!temp.equals(email) && read.hasNextLine())
					temp = read.nextLine();
				
				if(read.hasNextLine()) {
					read.nextLine();
					temp = read.nextLine();
				}
				read.close();
				if(temp.equals(password)) 
					return i == 0 ? "student" : "scholarship coordinator";
				
				users = new File("coordinators.txt");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "";
			}
		}
		
		return "";
		
	}
}
