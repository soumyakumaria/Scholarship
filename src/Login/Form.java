package Login;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import net.miginfocom.swing.MigLayout;
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
import javax.swing.JList;
import javax.swing.JComboBox;
/**
 * @author Soumya Kumaria
 * This class takes input from the user to create a new user and register such that
 * users can access the scholarship system
 */
public class Form {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private static final String[] args = null;
	private JTextField emailID;
	private JTextField studentID;
	private JPasswordField passwordField;
	private String s;
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
		
		JLabel lblSchoolsName = new JLabel("School's name:");
		
		schoolName = new JTextField();
		schoolName.setColumns(10);
		
		String[] roles = {"student", "scholarship coordinator"};
		JComboBox role = new JComboBox(roles);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		
		JComboBox month = new JComboBox(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
		
		String[] days = new String[31];
		for(int i = 1; i <= 31; i ++) {
			days[i - 1] = Integer.toString(i);
		}
		JComboBox day = new JComboBox(days);
		
		String[] years = new String[120];
		for(int i = 2020; i > 1900; i--) {
			years[2020 - i] = Integer.toString(i);
		}
		JComboBox year = new JComboBox(years);
		
		JLabel lblDateOfBirthmdy = new JLabel("Date of Birth (M/D/Y):");
		
		JButton btnSubmit = new JButton("Submit");
		/**
		 * This action listener is used to store the contents of the form window into either
		 * "students.txt" or "coordinators.txt". The contents are stored onto the file after 
		 * all boxes are filled and the submit button is clicked. 
		 */
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!firstName.getText().equals("") && !lastName.getText().equals("") && !year.getSelectedItem().equals("") && !month.getSelectedItem().equals("")
						&& !day.getSelectedItem().equals("") && !schoolName.getText().equals("") && !emailID.getText().equals("") && !studentID.getText().equals("")
						&& !passwordField.getText().equals("")) {
					
					String filename = role.getSelectedItem().equals("student") ? "students.txt" : "coordinators.txt";
					try {
						FileWriter writer = new FileWriter(filename,true);
						firstName.write(writer);
						writer.append("\n");
						lastName.write(writer);
						writer.append("\n");
						writer.append(year.getSelectedItem() + "\n");
						writer.append(month.getSelectedItem() + "\n");
						writer.append(day.getSelectedItem() + "\n");
						schoolName.write(writer);
						writer.append("\n");
						emailID.write(writer);
						writer.append("\n");
						studentID.write(writer);
						writer.append("\n");
						passwordField.write(writer);
						writer.append("\n\n\n");
						if(filename.equals("coordinators.txt"))
							writer.append("\n");
						writer.close();
						frame.dispose();
						if(filename.equals("students.txt"))
							GradesForm.main(args);
						else
							LoginScreen.main(args);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
				
			}
			
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(207)
					.addComponent(btnSubmit)
					.addContainerGap(198, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSchoolsName)
								.addComponent(lblEmailAddress)
								.addComponent(lblNewLabel)
								.addComponent(lblPassword)))
						.addComponent(lblLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblFirstName)
						.addComponent(lblAccountType)
						.addComponent(lblDateOfBirthmdy))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(emailID, 287, 287, Short.MAX_VALUE)
						.addComponent(studentID, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addComponent(passwordField, 287, 287, Short.MAX_VALUE)
						.addComponent(role, 0, 287, Short.MAX_VALUE)
						.addComponent(schoolName, 287, 287, Short.MAX_VALUE)
						.addComponent(firstName, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(month, 0, 121, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(day, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(year, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(lastName, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
					.addGap(58))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLastName)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(month, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateOfBirthmdy)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(year, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(day, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSchoolsName)
						.addComponent(schoolName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailAddress))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(role, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountType))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
