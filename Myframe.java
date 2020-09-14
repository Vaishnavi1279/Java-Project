import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Myframe extends JFrame {

	private JPanel contentPane;
	DatabaseHelper DAH = new DatabaseHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myframe frame = new Myframe();
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
	public Myframe() {
		super("Carrier Counselling Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSolicitingInformation = new JButton("SOLICITING INFORMATION");
		btnSolicitingInformation.setBounds(69, 48, 254, 23);
		btnSolicitingInformation.setBackground(Color.GRAY);
		btnSolicitingInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
					SInfo sInfo = new SInfo();
					sInfo.setVisible(true);
					sInfo.show();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSolicitingInformation);
		
		JButton btnCareerRecommendation = new JButton("CAREER RECOMMENDATION");
		btnCareerRecommendation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();
				CareerRecommendation cr = new CareerRecommendation();
				cr.setVisible(true);
				cr.show();
			}
		});
		btnCareerRecommendation.setBounds(69, 119, 254, 23);
		btnCareerRecommendation.setBackground(Color.GRAY);
		contentPane.add(btnCareerRecommendation);
		
		JButton btnReportsPrinting = new JButton("REPORTS PRINTING");
		btnReportsPrinting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAH.exportCourseCenterInfoTable();
				
					
			}
		});
		btnReportsPrinting.setBounds(69, 190, 254, 23);
		btnReportsPrinting.setBackground(Color.GRAY);
		contentPane.add(btnReportsPrinting);
	}
}
