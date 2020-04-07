package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

import users.ScholarshipCoordinator;
import users.Student;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Application window for taking Student grades upon account creation.
 * @author cam
 */
public class GradesForm {

	private JFrame frame;
	private JTextField textField;
	
	private String grades;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradesForm window = new GradesForm();
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
	public GradesForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] gradeArr = new String[] {"F", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A", "A+", "W"};
		JComboBox GradeBox = new JComboBox(gradeArr);
		GradeBox.setBounds(129, 137, 146, 22);
		frame.getContentPane().add(GradeBox);
		
		JTextArea txtrPleaseEnterYour = new JTextArea();
		txtrPleaseEnterYour.setEditable(false);
		txtrPleaseEnterYour.setBackground(SystemColor.menu);
		txtrPleaseEnterYour.setText("Please enter your grades.");
		txtrPleaseEnterYour.setBounds(139, 11, 209, 22);
		frame.getContentPane().add(txtrPleaseEnterYour);
		
		JTextArea txtrPressDoneWhen = new JTextArea();
		txtrPressDoneWhen.setEditable(false);
		txtrPressDoneWhen.setBackground(SystemColor.menu);
		txtrPressDoneWhen.setText("Click done when all grades are entered.");
		txtrPressDoneWhen.setBounds(105, 37, 319, 22);
		frame.getContentPane().add(txtrPressDoneWhen);
		
		JButton btnAddGrade = new JButton("Add Grade");
		btnAddGrade.setBounds(82, 192, 112, 23);
		frame.getContentPane().add(btnAddGrade);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(204, 192, 112, 23);
		frame.getContentPane().add(btnDone);
		
		textField = new JTextField("Added grades will appear here.");
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 85, 414, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		grades = "";
		
		btnAddGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!grades.equals(""))
					grades += ",";
				grades += GradeBox.getSelectedItem();
				textField.setText(grades);
			}
		});
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!grades.equals("")) {
					try {
						FileWriter writer = new FileWriter("students.txt",true);
						writer.write("\n" + grades + "\n");
						writer.close();
						frame.dispose();
						LoginScreen.main(new String[] {});
					} catch(IOException err) {
						err.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter atleast one grade.");
				}
				
			}
		});
	}
}
