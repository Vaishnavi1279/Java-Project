import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SInfo frame = new SInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SInfo() {
		super("Soliciting Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCounscelingCenter = new JButton("1. Counsceling Center Registration");
		btnCounscelingCenter.setBackground(Color.GRAY);
		btnCounscelingCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
				CenterInfo cInfo = new CenterInfo();
				cInfo.setVisible(true);
				cInfo.show();
			}
		});
		btnCounscelingCenter.setBounds(10, 33, 335, 23);
		contentPane.add(btnCounscelingCenter);
		
		JButton btnStudentRegistration = new JButton("2. Student Registration");
		btnStudentRegistration.setBackground(Color.GRAY);
		btnStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
				StudRegistration Stud = new StudRegistration();	
				Stud.setVisible(true);
				Stud.show();
			}
		});
		btnStudentRegistration.setBounds(10, 89, 335, 23);
		contentPane.add(btnStudentRegistration);
		
		JButton btnCoursesEligibility = new JButton("3. Courses Eligibility Registration");
		btnCoursesEligibility.setBackground(Color.GRAY);
		btnCoursesEligibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
				Courses_Eligibility course = new Courses_Eligibility();	
				course.setVisible(true);
				course.show();
				
			}
			
		});
		btnCoursesEligibility.setBounds(10, 145, 335, 23);
		contentPane.add(btnCoursesEligibility);
		
		JButton btnCounscelingStaff = new JButton("4. Counsceling Staff Registration");
		btnCounscelingStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
				StaffReg staff = new StaffReg();	
				staff.setVisible(true);
				staff.show();
			}
		});
		btnCounscelingStaff.setBackground(Color.GRAY);
		btnCounscelingStaff.setBounds(10, 201, 335, 23);
		contentPane.add(btnCounscelingStaff);
	}

}
