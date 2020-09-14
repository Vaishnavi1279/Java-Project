import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CollegeInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollegeInfo frame = new CollegeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void WindowClose() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public CollegeInfo() {
		super("College/Institute Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCollegeNo = new JLabel("College No.");
		lblCollegeNo.setBounds(10, 11, 73, 14);
		contentPane.add(lblCollegeNo);
		
		textField = new JTextField();
		textField.setBounds(101, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCollegeName = new JLabel("College Name");
		lblCollegeName.setBounds(10, 46, 86, 14);
		contentPane.add(lblCollegeName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 43, 354, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 80, 73, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 77, 400, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelephoneNo = new JLabel("Telephone No.");
		lblTelephoneNo.setBounds(10, 120, 86, 14);
		contentPane.add(lblTelephoneNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(101, 117, 108, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblWebsite = new JLabel("Website");
		lblWebsite.setBounds(10, 158, 46, 14);
		contentPane.add(lblWebsite);
		
		textField_4 = new JTextField();
		textField_4.setBounds(101, 155, 213, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCourseNo = new JLabel("Course No.");
		lblCourseNo.setBounds(10, 195, 73, 14);
		contentPane.add(lblCourseNo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 192, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 228, 86, 14);
		contentPane.add(lblCourseName);
		
		textField_6 = new JTextField();
		textField_6.setBounds(101, 225, 283, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder message = new StringBuilder();
				message.append("Type Message Part1 Here \n");
				message.append("Type Message Part2 Here \n");
				message.append("Type Message Part3 Here \n");
				JOptionPane.showMessageDialog(null,message);
			}
		});
		btnHelp.setBounds(122, 278, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WindowClose();
			}

			
		});
		btnClose.setBounds(333, 278, 89, 23);
		contentPane.add(btnClose);
	}
}
