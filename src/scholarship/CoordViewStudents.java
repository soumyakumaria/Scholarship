package scholarship;


import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import users.ScholarshipCoordinator;
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
import javax.swing.JTextPane;
/**
 * 
 * @author Soumya, Cam
 *
 */
public class CoordViewStudents {

	private JFrame frame;
	
	public static ScholarshipCoordinator sc;
	public static Scholarship sch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoordViewStudents window = new CoordViewStudents();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void start(ScholarshipCoordinator s, Scholarship schol) {
		sc = s;
		sch = schol;
		String[] args = new String[0];
		main(args);
	}
	
	/**
	 * Create the application.
	 */
	public CoordViewStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 559, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Student[] stArr = Utilities.filterByPending(sch);
		String[] stStringArr = new String[stArr.length];
		for(int i = 0; i < stArr.length; i++) {
			stStringArr[i] = stArr[i].getFirstName() + " " + stArr[i].getLastName();
		}
		
		
		JComboBox studentBox = new JComboBox(stStringArr);
		
		JButton addStudent = new JButton("Accept Application");
		
		JTextPane studentInfo = new JTextPane();
		
		JLabel lblStudentInofrmation = new JLabel("Student Information:");
		
		JButton done = new JButton("Done");
		
		studentBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student st = Utilities.getStudent(stArr, ((String)studentBox.getSelectedItem()).split(" ")[0], ((String)studentBox.getSelectedItem()).split(" ")[1]);
				String text = " First name: " + st.getFirstName() 
				            + "\n Last name: " + st.getLastName()
				            + "\n Date of birth: " + st.dateOfBirth()
				            + "\n School name: " + st.getSchoolName()
				            + "\n School email: " + st.getSchoolEmail()
				            + "\n School ID: " + st.getSchoolID()
				            + "\n Grades: " + st.getGrades()
				            + "\n GPA: " + st.getGPA(); 
				studentInfo.setText(text);
			}
		});
		
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				CoordViewScholarships.start(sc);
			}
		});
		
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilities.removeScholarship("students.txt", 1, sch, Utilities.getStudent(stArr, ((String)studentBox.getSelectedItem()).split(" ")[0], ((String)studentBox.getSelectedItem()).split(" ")[1]));
				Utilities.appendScholarship("students.txt", 2, sch, Utilities.getStudent(stArr, ((String)studentBox.getSelectedItem()).split(" ")[0], ((String)studentBox.getSelectedItem()).split(" ")[1]));
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(studentBox, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(addStudent))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudentInofrmation)
								.addComponent(studentInfo, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(214)
							.addComponent(done, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(addStudent))
					.addGap(62)
					.addComponent(lblStudentInofrmation)
					.addGap(18)
					.addComponent(studentInfo, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(done)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
	
}
