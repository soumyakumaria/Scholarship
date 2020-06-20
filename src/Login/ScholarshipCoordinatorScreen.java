package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * This is the homepage screen for the scholarship coordinator when they successfully logged in. 
 * @author Tiffany Tang
 *
 */
public class ScholarshipCoordinatorScreen {

	private JFrame frame;
	private static final String[] args = null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScholarshipCoordinatorScreen window = new ScholarshipCoordinatorScreen();
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
	public ScholarshipCoordinatorScreen() {
		initialize();
	}

	//public void setCoordinator(Sc) {
	//	this.sc = sc; 
	//	textField = setText()
	//	id = sc.getSchoolID(); 
	//}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Scholarship Coordinator Homepage");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emerging");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setBounds(21, 10, 131, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("University");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel_1.setBounds(21, 34, 131, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		/**
		 * This button allows for the user to log out of their account and return back to the login page. 
		 */
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); 
				JOptionPane.showMessageDialog(null, "You have successfully logged out.");
				LoginScreen.main(args);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(320, 34, 83, 26);
		frame.getContentPane().add(btnNewButton);
		
		/**
		 * This button allows for the scholarship coordinator to view all the scholarships that are in the 
		 * system. 
		 */
		JButton btnNewButton_1 = new JButton("View Scholarships");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_1.setBounds(133, 168, 154, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		/**
		 * This allows for the user to go to the add scholarship form to create a new scholarship. 
		 */
		JButton btnNewButton_2 = new JButton("Add Scholarship");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddScholarship.main(args);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_2.setBounds(133, 235, 154, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		/**
		 * This label will display the name of the user that logged in. This is from the name variable in 
		 * the LoginScreen class. 
		 */
		JLabel lblNewLabel_2 = new JLabel(LoginScreen.name);
		lblNewLabel_2.setBounds(123, 81, 92, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		/**
		 * This label will display the id of the user that logged in. This is from the id variable in 
		 * the LoginScreen class. 
		 */
		JLabel lblNewLabel_3 = new JLabel(LoginScreen.id);
		lblNewLabel_3.setBounds(123, 111, 92, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Student Name:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 81, 94, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(45, 111, 70, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
}
