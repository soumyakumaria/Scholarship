package scholarship;


import java.awt.EventQueue;
import users.ScholarshipCoordinator;
import users.Student;
import Login.ScholarshipCoordinatorScreen;
import Login.Utilities;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * @author cam
 * Allows a Coordinator to view different categories of Scholarships.
 */
public class CoordViewScholarships {

	private JFrame frame;
	
	public static ScholarshipCoordinator sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoordViewScholarships window = new CoordViewScholarships();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Start the window.
	 * @param s the Coordinator currently signed in.
	 */
	public static void start(ScholarshipCoordinator s) {
		sc = s;
		String[] args = new String[0];
		main(args);
	}
	
	/**
	 * Create the application.
	 */
	public CoordViewScholarships() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JTextArea infoArea = new JTextArea();
		infoArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAllScholarships = new JLabel("All Scholarships:");
		JLabel lblScolarshipsGPA = new JLabel("My Scholarships:");
		JLabel lblScholarshipYouCan = new JLabel("Pending Scholarships:");
		
		frame.setBounds(100, 100, 559, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Scholarship[] a = Login.Utilities.loadScholarships();
		String scholStr [] = new String [a.length];
		for(int i = 0; i < a.length; i++){
			scholStr[i]= a[i].getName();		
		}
		
		
		String[] myScholStr = new String[sc.getMyScholarships().length];
		for(int i = 0; i < myScholStr.length; i++) 
			myScholStr[i] = sc.getMyScholarships()[i].getName();
		
		String[] pendingStr = new String[a.length];
		String[] awardedStr = new String[a.length];
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].getNumAvailable() == Utilities.filterByAccepted(a[i]).length)
				awardedStr[i] = a[i].getName();
			else if(Utilities.filterByPending(a[i]).length + Utilities.filterByAwaiting(a[i]).length > 0)
				pendingStr[i] = a[i].getName();
		}
		
		pendingStr = trimArray(pendingStr);
		awardedStr = trimArray(awardedStr);
		
		JComboBox allScholarships = new JComboBox(scholStr);
		JComboBox myScholBox = new JComboBox(myScholStr);
		JComboBox awardedBox = new JComboBox(awardedStr);
		JComboBox pendingBox = new JComboBox(pendingStr);
		
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area.
		 */
		myScholBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoArea.setText(Utilities.getScholText((String)myScholBox.getSelectedItem()));
				
			}
		});
		
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area.
		 */
		pendingBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Utilities.getScholText((String)pendingBox.getSelectedItem()) + "\n\n Applicants(not yet approved): ";
				for (Student s : Utilities.filterByPending(Utilities.getScholarship(a, (String)pendingBox.getSelectedItem()))) 
					text += s.getFirstName() + " " + s.getLastName() + ", ";
				text = endList(text);
				
				text += "\n Applicants(approved): ";
				for (Student s : Utilities.filterByAwaiting(Utilities.getScholarship(a, (String)pendingBox.getSelectedItem()))) 
					text += s.getFirstName() + " " + s.getLastName() + ", ";
				text = endList(text);
				
				text += "\n Recipients: ";
				for (Student s : Utilities.filterByAccepted(Utilities.getScholarship(a, (String)pendingBox.getSelectedItem()))) 
					text += s.getFirstName() + " " + s.getLastName() + ", ";
				text = endList(text);
				
				
				
				infoArea.setText(text);
				
			}
		});
		
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area.
		 */
		allScholarships.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoArea.setText(Utilities.getScholText((String)allScholarships.getSelectedItem()));
			}
		});
		
		/**
		 * This action handler finds the all the information about the scholarship selected 
		 * by the user and displays it in the text area.
		 */
		awardedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Utilities.getScholText((String)awardedBox.getSelectedItem()) + "\n\n Recipients: ";
				for (Student s : Utilities.filterByAccepted(Utilities.getScholarship(a, (String)awardedBox.getSelectedItem()))) 
					text += s.getFirstName() + " " + s.getLastName() + ", ";
				text = endList(text);
				infoArea.setText(text);
			}
		});
		
		
		allScholarships.setToolTipText("Select");
		
		JButton viewApplicants = new JButton("View Applicants");
		viewApplicants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CoordViewStudents.start(sc, Utilities.getScholarship(a, (String)allScholarships.getSelectedItem()));
			}
		});
		
		JLabel lblAwardedScholarships = new JLabel("Awarded Scholarships:");
		
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScholarshipCoordinatorScreen.start(sc);
			}
		});
		
		JLabel lblScholarshipInfo = new JLabel("Scholarship Info:");
		lblScholarshipInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblScholarshipInfo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblScholarshipYouCan)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblScolarshipsGPA)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAllScholarships)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblAwardedScholarships, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(awardedBox, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(pendingBox, Alignment.LEADING, 0, 458, Short.MAX_VALUE)
													.addComponent(myScholBox, Alignment.LEADING, 0, 458, Short.MAX_VALUE)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(allScholarships, 0, 333, Short.MAX_VALUE)
														.addGap(18)
														.addComponent(viewApplicants))
													.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
												.addGap(32)))))))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(230, Short.MAX_VALUE)
					.addComponent(done, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(219))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblScolarshipsGPA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myScholBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblAwardedScholarships)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(awardedBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(lblScholarshipYouCan)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pendingBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblAllScholarships)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(allScholarships, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewApplicants))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(lblScholarshipInfo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(done)
					.addGap(23))
		);
		
		scrollPane.setViewportView(infoArea);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * Used to reduce repetition.
	 * @param s string to modify.
	 * @return if s ends with ", ", remove ", " from the end. Otherwise, add "none".
	 */
	private static String endList(String s) {
		if (s.substring(s.length() -2, s.length()).equals(", ")) {
			s = s.substring(0, s.length() - 2);
		} else {
			s += "none";
		}
		return s;
	}
	
	/**
	 * @param a String array to trim.
	 * @return a shorter version of a, with all null values removed.
	 */
	private static String[] trimArray(String[] a) {
		int n = 0;
		for (String s : a) {
			if (s != null)
				n++;
		}
		String[] b = new String[n];
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) 
				b[i - m] = a[i];
			else
				m++;
		}
		return b;
	}
}
