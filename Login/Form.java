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
/**
 * 
 * @author Soumya Kumaria
 * This class takes input from the user to create a new user
 * 
 *
 */
public class Form {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField txtDdmmyyyy;
	private static final String[] args = null;
	private JTextField emailID;
	private JTextField studentID;
	private JPasswordField passwordField;
	private String s;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Form f = new Form();
		
		f.startup();
	
		//f.usingPrintWriter();
		
		
	}
	/**
	 *This method starts the application, makes the form window visible to users. 
	 * 
	 * 
	 * @return 0
	 */
	public int startup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
					//LoginScreen.main(args);
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
	 * Adds the text fields and labels for - first name, last name, date of birth, email address, school id
	 * email id and password.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		firstName = new JTextField();
		firstName.setColumns(10);
	
		lastName = new JTextField();
		lastName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("email address:");
		
		emailID = new JTextField();
		emailID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		
		studentID = new JTextField();
		studentID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		passwordField = new JPasswordField();
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstName.getText().toString();
				lastName.getText().toString();
				txtDdmmyyyy.getText().toString();
				emailID.getText().toString();
				passwordField.getText().toString();
				String filename = "content.txt";
				try {
					FileWriter writer = new FileWriter(filename,true);
					firstName.write(writer);
					writer.append("\n");
					lastName.write(writer);
					writer.append("\n");
					txtDdmmyyyy.write(writer);
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
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel)
							.addComponent(lblEmailAddress)
							.addComponent(lblPassword))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateOfBirth)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblLastName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblFirstName, Alignment.TRAILING)))))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtDdmmyyyy)
						.addComponent(passwordField)
						.addComponent(studentID)
						.addComponent(emailID)
						.addComponent(lastName, 282, 282, Short.MAX_VALUE)
						.addComponent(firstName, 282, 282, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(142))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDdmmyyyy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateOfBirth))
							.addGap(18)
							.addComponent(emailID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEmailAddress, Alignment.TRAILING))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(34)
					.addComponent(btnSubmit)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	/**
	 * 
	 * @return null
	 */
	public static JFrame getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
