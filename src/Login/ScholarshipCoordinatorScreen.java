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

import scholarship.CoordViewScholarships;
import users.ScholarshipCoordinator;

/**
 * This is the homepage screen for the scholarship coordinator when they successfully logged in. 
 * @author Tiffany Tang
 *
 */
public class ScholarshipCoordinatorScreen {

	private JFrame frame;
	private static final String[] args = null;
	public static ScholarshipCoordinator sc;

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
	
	public static void start(ScholarshipCoordinator s) {
		sc = s;
		String[] args = new String[0];
		main(args);
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				CoordViewScholarships.start((sc));
			}
		});
		
		
		/**
		 * This allows for the user to go to the add scholarship form to create a new scholarship. 
		 */
		JButton btnNewButton_2 = new JButton("Add Scholarship");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddScholarship.start(sc);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_2.setBounds(133, 235, 154, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		/**
		 * This label will display the name of the user that logged in. This is from the name variable in 
		 * the LoginScreen class. 
		 */
		JLabel lblNewLabel_2 = new JLabel(sc.getFirstName() + " " + sc.getLastName()/*LoginScreen.name*/);
		lblNewLabel_2.setBounds(173, 81, 92, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		/**
		 * This label will display the id of the user that logged in. This is from the id variable in 
		 * the LoginScreen class. 
		 */
		JLabel lblNewLabel_3 = new JLabel(sc.getSchoolID()/*LoginScreen.id*/);
		lblNewLabel_3.setBounds(173, 111, 92, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Coordinator Name:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 81, 131, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("School ID:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(82, 111, 70, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
}
