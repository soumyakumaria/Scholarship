package scholarship;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import Login.Utilities;
import users.Student;
import users.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class is used to view previous scholarships - pending, awaiting and accepted scholarships.
 * @author Soumya
 *
 */

public class PreviousScholarship {

	private JFrame frame;
	public static Student st;
	public static Scholarship sch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviousScholarship window = new PreviousScholarship();
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
	public PreviousScholarship() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Previous Scholarships");
		frame.setBounds(100, 100, 489, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Pending Scholarships:");
		lblNewLabel.setBounds(38, 40, 164, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblAwaitingScholarships = new JLabel("Awaiting Scholarships:");
		lblAwaitingScholarships.setBounds(38, 219, 153, 16);
		frame.getContentPane().add(lblAwaitingScholarships);
		
		JLabel lblAcceptedScholarships = new JLabel("Accepted Scholarships:");
		lblAcceptedScholarships.setBounds(38, 130, 314, 16);
		frame.getContentPane().add(lblAcceptedScholarships);
		
		
		
		
		Scholarship[] a = Login.Utilities.loadScholarships();
		String strArray [] = new String [a.length];
		//Gets the name of all the scholarships from a scholarship array stored and stores it in a string array strArray.
		for(int i=0; i<a.length;i ++){
			strArray[i]= a[i].getName();	
		}
		
		Student s = Login.LoginScreen.s;
		
		Scholarship pending []  = s.getPending();
		String[] pendingName = new String[pending.length];
		//Gets the name of all pending scholarships from a scholarship array stored and stores it in a string array pendingName.
		for(int i=0; i<pending.length;i ++){
			pendingName[i]= pending[i].getName();	
		}
		
		Scholarship awaiting []  = s.getAwaiting();
		String[] awaitingName = new String[awaiting.length];
		//Gets the name of all pending scholarships from a scholarship array stored and stores it in a string array awaitingName.
		for(int i=0; i<awaiting.length;i ++){
			awaitingName[i]= awaiting[i].getName();	
		}
		
		Scholarship accepted [] = s.getAccepted();
		String [] acceptedName = new String[accepted.length];
		//Gets the name of all pending scholarships from a scholarship array stored and stores it in a string array acceptedName.
		for(int i=0; i<accepted.length;i ++){
			acceptedName[i]= accepted[i].getName();	
		}
		
		
		JComboBox PendingComboBox = new JComboBox(pendingName);
		PendingComboBox.setBounds(38, 69, 384, 22);
		frame.getContentPane().add(PendingComboBox);
		
		JComboBox AwaitingComboBox = new JComboBox(awaitingName);
		AwaitingComboBox.setBounds(38, 248, 384, 22);
		frame.getContentPane().add(AwaitingComboBox);
		
		JComboBox AcceptedComboBox = new JComboBox(acceptedName);
		AcceptedComboBox.setBounds(38, 159, 384, 22);
		frame.getContentPane().add(AcceptedComboBox);
		//Missing Code
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = (String) AwaitingComboBox.getSelectedItem();
				
				//Utilities.appendScholarship("student.txt", 3 , Utilities.getScholarship(a, temp), st);
				
				
			}
		});
		btnAccept.setBounds(38, 283, 97, 25);
		frame.getContentPane().add(btnAccept);
		//Mising Code
		JButton btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDecline.setBounds(325, 283, 97, 25);
		frame.getContentPane().add(btnDecline);
				
		
	}
}
