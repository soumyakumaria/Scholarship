package scholarship;


import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import users.Student;
import Login.Utilities;

import javax.swing.JFrame;


import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Soumya, Cam
 *
 */
public class ViewScholarship {

	private JFrame frame;
	private static final String[] args = null;
	public static Student st;
	public static Scholarship sch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewScholarship window = new ViewScholarship();
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

	public Student getStudent() {
		
		return null;
		
	}
	/**
	 * Create the application.
	 */
	public ViewScholarship() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAllScholarships = new JLabel("All Scholarships");
		JLabel lblScolarshipsGPA = new JLabel("Scholarships you can apply for according to your GPA");
		JLabel lblScholarshipYouCan = new JLabel("Scholarship you can apply for based on your GPA and single letter grade");
		
		frame.setBounds(100, 100, 559, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Scholarship[] a = Login.Utilities.loadScholarships();
		String strArray [] = new String [a.length];
		//Gets the name of all the scholarships from a scholarship array stored and stores it in a string array strArray.
		for(int i=0; i<a.length;i ++){
			strArray[i]= a[i].getName();		
		}
		double GPA = 0.0;
		Student s = Login.LoginScreen.s;
		GPA = s.getGPA();
		
		
		
		//Getting the sorted array of scholarships based on the student's GPA
		Scholarship[] b  = Login.Utilities.sortGPA(a, GPA);
		String sortArray [] = new String [b.length];
		for(int i=0; i<b.length;i ++){
			sortArray[i]= b[i].getName();		
		}
		
		
		//Getting the sorted array of scholarships based on the student's GPA and single letter grade.
		//An array of all scholarships and a student object is passed to the sort legible method.
		Scholarship[] c  = Login.Utilities.sortLegible(a, s);
		String sortLegibleArray [] = new String [c.length];
		for(int i=0; i<c.length;i ++){
			sortLegibleArray[i]= c[i].getName();	
		}
		
		
		
		
		
	
		
		
		JComboBox scholarshipName = new JComboBox(strArray);
		JComboBox gpaScholarshipName = new JComboBox(sortArray);
		JComboBox sortLegibleComboBox = new JComboBox(sortLegibleArray);
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area. The scholarship available in the combo box
		 * is dependent on the GPA of the student. 
		 */
		gpaScholarshipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				temp = (String) gpaScholarshipName.getSelectedItem();
				textArea.setText(Utilities.getScholText(temp));
				
			}
		});
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area. The scholarship available in the combo box
		 * is dependent on the GPA and a single letter grade of the student. 
		 */
		
		sortLegibleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				temp = (String) sortLegibleComboBox.getSelectedItem();
				textArea.setText(Utilities.getScholText(temp));
			
				
			}
		});
		
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area. The scholarship available in the combo box
		 * consists of all the scholarships.
		 */
		scholarshipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = "";
				temp = (String) scholarshipName.getSelectedItem();
				textArea.setText(Utilities.getScholText(temp));
				
				
			}
			
		});
		
		JButton btnApply = new JButton("Apply");
		//action listener for apply
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				String temp = (String)scholarshipName.getSelectedItem();
				Utilities.appendScholarship("students.txt", 1 , Utilities.getScholarship(Utilities.loadScholarships(), temp), st);
				
				AddSupportingDocuments.main(args);
			}
		});
		
		
		
		scholarshipName.setToolTipText("Select");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(227)
					.addComponent(btnApply)
					.addContainerGap(251, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAllScholarships)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblScholarshipYouCan)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblScolarshipsGPA)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(gpaScholarshipName, Alignment.LEADING, 0, 433, Short.MAX_VALUE)
										.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
										.addComponent(sortLegibleComboBox, Alignment.LEADING, 0, 433, Short.MAX_VALUE)
										.addComponent(scholarshipName, Alignment.LEADING, 0, 433, Short.MAX_VALUE))
									.addGap(55))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblScolarshipsGPA)
					.addGap(18)
					.addComponent(gpaScholarshipName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(lblScholarshipYouCan)
					.addGap(18)
					.addComponent(sortLegibleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(lblAllScholarships)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scholarshipName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
	


	
}
