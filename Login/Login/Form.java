package Login;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.TextUI;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JPasswordField;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import javax.swing.SwingConstants;
/**
 * @author Soumya Kumaria
 * This class takes input from the user to create a new user and register such that
 * users can access the scholarship system
 */
public class Form {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField birthYear;
	private static final String[] args = null;
	private JTextField emailID;
	private JTextField studentID;
	private JPasswordField passwordField;
	private String s;
	private JTextField birthMonth;
	private JTextField birthDay;
	private JTextField schoolName;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Form f = new Form();
		f.startup();
	}
	/**
	 *This method starts the application, makes the form window visible to users. 
	 * @return 0
	 */
	public int startup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		return 0;
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 * Adds the text fields and labels for - first name, last name, birth year, birth month, birth day
	 * school name, student id, email id and password.
	 */
	private void initialize() {
		frame = new JFrame("Create an account");
		frame.setBounds(100, 100, 486, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		firstName = new JTextField();
		firstName.setColumns(10);
	
		lastName = new JTextField();
		lastName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Birth year:");
		
		birthYear = new JTextField();
		birthYear.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("email address:");
		
		emailID = new JTextField();
		emailID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		
		studentID = new JTextField();
		studentID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		passwordField = new JPasswordField();
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblBirthMonth = new JLabel("Birth month:");
		
		birthMonth = new JTextField();
		birthMonth.setColumns(10);
		
		JLabel lblBirthDay = new JLabel("Birth day:");
		
		birthDay = new JTextField();
		birthDay.setColumns(10);
		
		JLabel lblSchoolsName = new JLabel("School's name:");
		
		schoolName = new JTextField();
		schoolName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		/**
		 * This action listener is used to store the contents of the form window into a file named
		 * "users.txt". The contents are stored onto the file after the submit button is clicked. 
		 */
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filename = "users.txt";
				try {
					FileWriter writer = new FileWriter(filename,true);
					firstName.write(writer);
					writer.append("\n");
					lastName.write(writer);
					writer.append("\n");
					birthYear.write(writer);
					writer.append("\n");
					birthMonth.write(writer);
					writer.append("\n");
					birthDay.write(writer);
					writer.append("\n");
					schoolName.write(writer);
					writer.append("\n");
					emailID.write(writer);
					writer.append("\n");
					studentID.write(writer);
					writer.append("\n");
					passwordField.write(writer);
					writer.append("\n");
					 writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LoginScreen.main(args);
				
			}
			
		});
		
		/**
		 * Sets up the form window by adding the Jlabels, buttons and  Jtextfield created above
		 * Specifies the orientation and spacing 
		 */
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDateOfBirth)
										.addComponent(lblBirthDay)
										.addComponent(lblBirthMonth)
										.addComponent(lblSchoolsName)
										.addComponent(lblEmailAddress))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addComponent(lblFirstName, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(37)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPassword)
										.addComponent(lblNewLabel))
									.addGap(12)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(emailID)
								.addComponent(studentID, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
								.addComponent(schoolName)
								.addComponent(birthYear)
								.addComponent(lastName, 282, 282, Short.MAX_VALUE)
								.addComponent(firstName, 282, 282, Short.MAX_VALUE)
								.addComponent(birthMonth)
								.addComponent(birthDay)
								.addComponent(passwordField))
							.addGap(95))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSubmit)
							.addGap(214))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(birthYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateOfBirth))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(birthMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBirthMonth))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBirthDay)
						.addComponent(birthDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSchoolsName)
						.addComponent(schoolName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailAddress))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(studentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSubmit)
					.addGap(32))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
}
