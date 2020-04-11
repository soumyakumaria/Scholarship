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
		JButton btnApply = new JButton("Apply");
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAllScholarships = new JLabel("All Scholarships");
		JLabel lblScolarshipsYouCan = new JLabel("Scholarships you can apply for according to your GPA");
		frame.setBounds(100, 100, 538, 623);
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
		String grades = "A,B,C,A";
		s.setGrades(grades);
		
		Scholarship[] b  = Login.Utilities.sortGPA(a, GPA);
		String sortArray [] = new String [b.length];
		for(int i=0; i<b.length;i ++){
			sortArray[i]= b[i].getName();		
		}
		
		
		
		Scholarship[] c  = Login.Utilities.sortLegible(a, s);
		String sortLegibleArray [] = new String [c.length];
		for(int i=0; i<c.length;i ++){
			sortLegibleArray[i]= c[i].getName();	
		}
		
		
		
	
		
		
		JComboBox scholarshipName = new JComboBox(strArray);
		JComboBox gpaScholarshipName = new JComboBox(sortArray);
		JComboBox sortLegibleComboBox = new JComboBox(sortLegibleArray);
		
		/**
		 *This action handler displays 
		 *the information for each scholarship selected in the
		 *JscrollPane.  
		 */
		scholarshipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = "";
				temp = (String) scholarshipName.getSelectedItem();
				File scholarships = new File("scholarships.txt");
				System.out.println(temp);
				String info ="";
				
				
				
				for(int i = 0; i <1; i++) {
					Scanner read = null;
					
					try {
						read = new Scanner(scholarships);
						while(read.hasNextLine()) {
							if(read.nextLine().equals(temp)) {
								for(int j=0; j<9;j++) {
									info = info+read.nextLine()+"\n";
								 
								}
								textArea.setText(info);
								
							}
							
						
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					read.close();
					
				}
				
			}
			
		});
		
		
		scholarshipName.setToolTipText("Select");
		
		
		
		JLabel lblScholarshipYouCan = new JLabel("Scholarship you can apply for based on your GPA and single letter grade");
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(229)
					.addComponent(btnApply)
					.addGap(148))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblScholarshipYouCan)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblScolarshipsYouCan)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAllScholarships)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(scholarshipName, 0, 412, Short.MAX_VALUE)
										.addComponent(gpaScholarshipName, Alignment.LEADING, 0, 412, Short.MAX_VALUE)
										.addComponent(sortLegibleComboBox, Alignment.LEADING, 0, 412, Short.MAX_VALUE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
									.addGap(55))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblScolarshipsYouCan)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gpaScholarshipName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(lblScholarshipYouCan)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sortLegibleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAllScholarships)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scholarshipName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}


	/**
	 * @return a list of all Scholarship objects stored in scholarships.txt.
	 */
	public static Scholarship[] loadScholarships() {
		try {
			File file = new File("scholarships.txt");
			Scanner in = new Scanner(file);
			int n = 0;
			while(in.hasNextLine()) {
				n++;
				in.nextLine();
			}
			in = new Scanner(file);
			Scholarship[] a = new Scholarship[n / 10];
			
			int i = 0;
			while (i < (n / 10)) {
				Scholarship s = new Scholarship();
				s.setName(in.nextLine());
				s.setMinGPA(in.nextLine());
				s.setAntirequisite(in.nextLine());
				s.setNumAvailable(Integer.parseInt(in.nextLine()));
				s.setNominations(in.nextLine().split("/"));
				s.setGrant(in.nextLine().equals("true"));
				s.setDescription(in.nextLine());
				s.setMoney(Double.parseDouble(in.nextLine()));
				s.setFrequency(in.nextLine());
				s.setDuration(in.nextLine());
				a[i] = s;
				i++;
			}
			
			in.close();
			return a;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
