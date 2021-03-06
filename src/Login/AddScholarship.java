package Login;

/**
 * This class takes inputs from a scholarship coordinator to add a new scholarship to the system. 
 * 
 * @author Tiffany, cam 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import scholarship.Scholarship;
import users.ScholarshipCoordinator;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddScholarship {

	private JFrame frame;
	private JTextField name;
	private JTextField minGPA;
	private JTextField antirequisite;
	private JTextField numAvailable;
	private JTextField nominations;
	private JTextField grant;
	private JTextField description;
	private JTextField money;
	private JTextField frequency;
	private JTextField duration;
	
	public static ScholarshipCoordinator sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScholarship window = new AddScholarship();
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
	public AddScholarship() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Adds the labels: name, minimum GPA, antirequisite, number available, nominations, grant, description, 
	 * money, frequency, and duration to the frame and its corresponding text fields. 
	 */
	private void initialize() {
		frame = new JFrame("Add a scholarship");
		frame.setBounds(100, 100, 486, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scholarship Name:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 20, 120, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Minimum GPA:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(51, 56, 103, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Antirequisite:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(60, 88, 84, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Number Available:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(24, 127, 120, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nominations:");
		lblNewLabel_4.setToolTipText("");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(60, 159, 84, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Grant:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(105, 195, 39, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Description:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(69, 235, 75, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Money:");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(98, 271, 46, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Frequency:");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_8.setBounds(71, 307, 73, 15);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Duration:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_9.setBounds(86, 343, 58, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		name = new JTextField();
		name.setBounds(165, 14, 274, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		minGPA = new JTextField();
		minGPA.setBounds(165, 50, 274, 19);
		frame.getContentPane().add(minGPA);
		minGPA.setColumns(10);
		
		antirequisite = new JTextField();
		antirequisite.setBounds(165, 86, 274, 19);
		frame.getContentPane().add(antirequisite);
		antirequisite.setColumns(10);
		
		numAvailable = new JTextField();
		numAvailable.setBounds(165, 121, 274, 19);
		frame.getContentPane().add(numAvailable);
		numAvailable.setColumns(10);
		
		nominations = new JTextField();
		nominations.setToolTipText("e.g.: nominee1, nominator1/nominee2,nominator2/...");
		nominations.setBounds(165, 157, 274, 19);
		frame.getContentPane().add(nominations);
		nominations.setColumns(10);
		
		grant = new JTextField();
		grant.setBounds(165, 193, 274, 19);
		frame.getContentPane().add(grant);
		grant.setColumns(10);
		
		description = new JTextField();
		description.setBounds(165, 231, 274, 19);
		frame.getContentPane().add(description);
		description.setColumns(10);
		
		money = new JTextField();
		money.setBounds(165, 265, 274, 19);
		frame.getContentPane().add(money);
		money.setColumns(10);
		
		frequency = new JTextField();
		frequency.setBounds(165, 301, 274, 19);
		frame.getContentPane().add(frequency);
		frequency.setColumns(10);
		
		duration = new JTextField();
		duration.setBounds(165, 344, 274, 19);
		frame.getContentPane().add(duration);
		duration.setColumns(10);
		
		String[] days = new String[31];
		for(int i = 1; i < 32; i++)
			days[i - 1] = Integer.toString(i);
		
		String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		String[] years = new String[10];
		for(int i = 2030; i > 2020; i--) {
			years[2030 - i] = Integer.toString(i);
		}
		
		String[] levels = new String[] {"Department", "Faculty", "University", "Province-wide", "Nation-wide"};
		
		String[] types = new String[] {"Undergraduate", "Master's", "PHD", "Post-Graduate", "Open to all"};
		
		JComboBox levelBox = new JComboBox(levels);
		levelBox.setBounds(60, 372, 125, 26);
		frame.getContentPane().add(levelBox);
		
		JComboBox typeBox = new JComboBox(types);
		typeBox.setBounds(298, 374, 144, 26);
		frame.getContentPane().add(typeBox);
		
		JComboBox monthBox = new JComboBox(months);
		monthBox.setBounds(155, 416, 110, 26);
		frame.getContentPane().add(monthBox);
		
		JComboBox dayBox = new JComboBox(days);
		dayBox.setBounds(275, 416, 51, 26);
		frame.getContentPane().add(dayBox);
		
		JComboBox yearBox = new JComboBox(years);
		yearBox.setBounds(336, 416, 103, 26);
		frame.getContentPane().add(yearBox);
		
		JButton btnNewButton_1 = new JButton("Submit");
		/**
		 * This method is an action listener that writes all the input information on the add scholarship page 
		 * into the scholarships.txt file. Every text field except for nominations and grant must be filled out 
		 * for the form to be successfully submitted. Nominations and grant are optional. 
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!name.getText().equals("") && !minGPA.getText().equals("") && !antirequisite.getText().equals("") &&
						!numAvailable.getText().equals("") && !description.getText().equals("") && !money.getText().equals("")
						&& !frequency.getText().equals("") && !duration.getText().equals("")) {
					
					Scholarship sch = new Scholarship();
					sch.setName(name.getText());
					sch.setMinGPA(minGPA.getText());
					sch.setAntirequisite(antirequisite.getText());
					sch.setNumAvailable(Integer.parseInt(numAvailable.getText()));
					if (!nominations.getText().equals("")) {
						sch.setNominations(nominations.getText().split("/")); 
					} else {
						sch.setNominations(new String[0]); 
					}
					sch.setGrant(grant.getText().equalsIgnoreCase("true"));
					sch.setDescription(description.getText());
					sch.setMoney(Double.parseDouble(money.getText()));
					sch.setFrequency(frequency.getText());
					sch.setDuration(duration.getText());
					sch.setAcceptDeclineDate((String)monthBox.getSelectedItem() + " " + (String)dayBox.getSelectedItem() + ", " + (String)yearBox.getSelectedItem());
					sch.setLevel((String)levelBox.getSelectedItem());
					sch.setStudentType((String)typeBox.getSelectedItem());
					Utilities.saveScholarship(sch);
					Utilities.appendScholarship("coordinators.txt", 1, sch, sc);
					sc.addMyScholarship(sch);
					frame.dispose();
					ScholarshipCoordinatorScreen.start(sc);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_1.setBounds(183, 465, 84, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblcanBeLeft = new JLabel("(Can be left blank)");
		lblcanBeLeft.setToolTipText("");
		lblcanBeLeft.setFont(new Font("Arial", Font.ITALIC, 11));
		lblcanBeLeft.setBounds(51, 173, 93, 15);
		frame.getContentPane().add(lblcanBeLeft);
		
		JLabel lbltrueOrFalse = new JLabel("(true or false)");
		lbltrueOrFalse.setToolTipText("");
		lbltrueOrFalse.setFont(new Font("Arial", Font.ITALIC, 11));
		lbltrueOrFalse.setBounds(80, 209, 75, 15);
		frame.getContentPane().add(lbltrueOrFalse);
		
		JLabel lblStudentsCannotHave = new JLabel("(students cannot have ");
		lblStudentsCannotHave.setToolTipText("");
		lblStudentsCannotHave.setFont(new Font("Arial", Font.ITALIC, 11));
		lblStudentsCannotHave.setBounds(45, 101, 120, 15);
		frame.getContentPane().add(lblStudentsCannotHave);
		
		JLabel lblLetterGradesAt = new JLabel("letter grades at or below this)");
		lblLetterGradesAt.setToolTipText("");
		lblLetterGradesAt.setFont(new Font("Arial", Font.ITALIC, 11));
		lblLetterGradesAt.setBounds(10, 111, 144, 15);
		frame.getContentPane().add(lblLetterGradesAt);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Arial", Font.BOLD, 13));
		lblLevel.setBounds(10, 377, 39, 15);
		frame.getContentPane().add(lblLevel);
		
		JLabel lblDeadline = new JLabel("Deadline:");
		lblDeadline.setFont(new Font("Arial", Font.BOLD, 13));
		lblDeadline.setBounds(84, 418, 61, 15);
		frame.getContentPane().add(lblDeadline);
		
		JLabel lblStudentType = new JLabel("Student Type:");
		lblStudentType.setFont(new Font("Arial", Font.BOLD, 13));
		lblStudentType.setBounds(195, 377, 93, 15);
		frame.getContentPane().add(lblStudentType);
		
	}
}
