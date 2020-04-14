package Login;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import scholarship.PreviousScholarship;
import scholarship.ViewScholarship;
import users.Student;

public class StudentWindow {
	/**
	 * 
	 * @author Shamim Khalili, Tiffany Tang
	 * This class is the window for when a student
	 * successfully logs in
	 *
	 */
	private static final String[] args = null;
	private JFrame frame;
	public static Student st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWindow window = new StudentWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void start(Student s) {
        st = s;
        String[] args = new String[0];
        main(args);
    }
	/**
	 * Create the application.
	 */
	public StudentWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student Homepage");
		frame.setBounds(100, 100, 553, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emerging");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setBounds(21, 10, 131, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("University");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel_1.setBounds(21, 36, 131, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		/**
		 * This button takes the user out of this window
		 * back to the initial log in screen
		 */
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 
				JOptionPane.showMessageDialog(null, "You have successfully logged out.");
				LoginScreen.main(args);

			}
		});
		btnNewButton.setBounds(417, 36, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Apply for Scholarships");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewScholarship.main(args);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_1.setBounds(188, 191, 198, 29);
		frame.getContentPane().add(btnNewButton_1);
		
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
		
		JButton btnPreviousScholarships = new JButton("Previous Scholarships");
		btnPreviousScholarships.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousScholarship.main(args);
				
			}
		});
		btnPreviousScholarships.setFont(new Font("Arial", Font.BOLD, 13));
		btnPreviousScholarships.setBounds(186, 227, 200, 25);
		frame.getContentPane().add(btnPreviousScholarships);
	}
}
