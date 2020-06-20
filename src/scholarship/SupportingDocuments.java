package scholarship;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import Login.LoginScreen;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class SupportingDocuments {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupportingDocuments window = new SupportingDocuments();
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
	public SupportingDocuments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Supporting Documents.");
		JTextArea ta = new JTextArea();
		
		frame.setBounds(100, 100, 517, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu File = new JMenu("File");
		File.setForeground(Color.BLACK);
		File.setBackground(Color.MAGENTA);
		menuBar.add(File);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(ta);
		scrollPane.setBounds(20, 54, 459, 286);
		/**
		 * Some of the code for this action listener is taken from:
		 *          //https://www.javatpoint.com/java-jfilechooser
		 */
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();    
			    int i=fc.showOpenDialog(mntmOpen);    
			    if(i==JFileChooser.APPROVE_OPTION){    
			        File f=fc.getSelectedFile();    
			        String filepath=f.getPath();    
			        try{  
			        BufferedReader br=new BufferedReader(new FileReader(filepath));    
			        String s1="",s2="";                         
				        while((s1=br.readLine())!=null){    
				        	s2+=s1+"\n";    
				        }    
			        ta.append(s2);    
			        br.close();    
			        }
			        catch (Exception ex){
			        		ex.printStackTrace();  
			        }                 
			    }    

			}
		});
		
		JMenuItem mntmUpload = new JMenuItem("Upload");
		mntmUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
			        try{  
			        BufferedWriter bw =new BufferedWriter(new FileWriter(LoginScreen.id+"document.txt"));    
			        bw.write(ta.getText());                
			        bw.close();    
			        }
			        catch (Exception ex){
			        		ex.printStackTrace();  
			        }                 
			        frame.dispose();
				
			}
		});
		File.add(mntmOpen);
		
		
		File.add(mntmUpload);
		frame.getContentPane().setLayout(null);
		
		
		frame.getContentPane().add(scrollPane);
		
				
		
		JLabel lblIfYouWant = new JLabel("If you want to add multiple documents you will have to open them individually. ");
		lblIfYouWant.setBounds(20, 0, 467, 34);
		frame.getContentPane().add(lblIfYouWant);
		
		JLabel lblOnlyTextFiles = new JLabel("Only text files are allowed.");
		lblOnlyTextFiles.setBounds(20, 25, 446, 16);
		frame.getContentPane().add(lblOnlyTextFiles);
		
	}

}
