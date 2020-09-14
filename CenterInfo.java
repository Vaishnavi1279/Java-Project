import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class CenterInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_address;
	private JTextField textField_staff_strength;
	private JTextField textField_incharge_no;
	private JTextField textField_incharge_name;
	private JTextField textField_pincode;
	private JTextField textField_telephone;
	private JTextField textField_email;
	private JTextField textField_mobile_no;
	private JComboBox comboBox_course_center_no;
	DatabaseHelper DAH = new DatabaseHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterInfo frame = new CenterInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void FieldToggle(boolean option)
	{
		textField_name.setEditable(option);;
		textField_address.setEditable(option);
		textField_staff_strength.setEditable(option);
		textField_incharge_no.setEditable(option);
		textField_incharge_name.setEditable(option);
		textField_pincode.setEditable(option);
		textField_telephone.setEditable(option);
		textField_email.setEditable(option);
		textField_mobile_no.setEditable(option);
		comboBox_course_center_no.setEnabled(!option);
	}

	void FieldCleaner()
	{
		textField_name.setText("");
		textField_address.setText("");
		textField_staff_strength.setText("");
		textField_incharge_no.setText("");
		textField_incharge_name.setText("");
		textField_pincode.setText("");
		textField_telephone.setText("");
		textField_email.setText("");
		textField_mobile_no.setText("");
	}
	
	public void WindowClose()
	{
		this.setVisible(false);
		
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public CenterInfo() {
		super("Counselling Center Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 418);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final String lastActionCommand[] = {""};
		
		JLabel lblCourseCenterNo = new JLabel("Course Center No.");
		lblCourseCenterNo.setBounds(10, 11, 116, 24);
		contentPane.add(lblCourseCenterNo);
		
		comboBox_course_center_no = new JComboBox();
		comboBox_course_center_no.setBounds(130, 12, 107, 22);
		contentPane.add(comboBox_course_center_no);
		comboBox_course_center_no.addItem("---Select---");
		Vector<String> course_ids = DAH.getCourseIDS_ALL();
		for(int i = 0 ; i < course_ids.size() ; i++)
		{
			comboBox_course_center_no.addItem(course_ids.elementAt(i));
		}
		
		comboBox_course_center_no.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent arg0) 
			{
				if(!comboBox_course_center_no.getSelectedItem().toString().equalsIgnoreCase("---Select---")) {
					if(!lastActionCommand[0].equalsIgnoreCase("ADD") && !lastActionCommand[0].equalsIgnoreCase("DELETE")) {
					Vector<String> data = DAH.getCourseInfo_SELECTED(comboBox_course_center_no.getSelectedItem().toString());
					textField_name.setText(data.elementAt(1));
					textField_address.setText(data.elementAt(2));
					textField_staff_strength.setText(data.elementAt(3));
					textField_incharge_no.setText(data.elementAt(4));
					textField_incharge_name.setText(data.elementAt(5));
					textField_pincode.setText(data.elementAt(6));
					textField_telephone.setText(data.elementAt(7));
					textField_email.setText(data.elementAt(8));
					textField_mobile_no.setText(data.elementAt(9));
					}
				}
				else { FieldCleaner(); }
				
			}
		});
		
		JLabel lblName = new JLabel("Center Name");
		lblName.setBounds(268, 16, 91, 14);
		contentPane.add(lblName);
		
		textField_name = new JTextField();
		textField_name.setBounds(369, 13, 221, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Center Address");
		lblAddress.setBounds(10, 53, 91, 17);
		contentPane.add(lblAddress);
		
		textField_address = new JTextField();
		textField_address.setBounds(130, 50, 383, 20);
		contentPane.add(textField_address);
		textField_address.setColumns(10);
		
		JLabel lblStaffStrength = new JLabel("Staff Strength");
		lblStaffStrength.setBounds(10, 96, 81, 14);
		contentPane.add(lblStaffStrength);
		
		textField_staff_strength = new JTextField();
		textField_staff_strength.setBounds(130, 93, 230, 20);
		contentPane.add(textField_staff_strength);
		textField_staff_strength.setColumns(10);
		
		JLabel lblInchargeNo = new JLabel("Incharge No.");
		lblInchargeNo.setBounds(10, 135, 81, 14);
		contentPane.add(lblInchargeNo);
		
		textField_incharge_no = new JTextField();
		textField_incharge_no.setBounds(130, 132, 93, 20);
		contentPane.add(textField_incharge_no);
		textField_incharge_no.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Incharge Name");
		lblName_1.setBounds(268, 135, 92, 14);
		contentPane.add(lblName_1);
		
		textField_incharge_name = new JTextField();
		textField_incharge_name.setBounds(369, 132, 221, 20);
		contentPane.add(textField_incharge_name);
		textField_incharge_name.setColumns(10);
		
		JLabel lblPinCode = new JLabel("Pincode");
		lblPinCode.setBounds(10, 172, 46, 14);
		contentPane.add(lblPinCode);
		
		textField_pincode = new JTextField();
		textField_pincode.setBounds(130, 169, 83, 20);
		contentPane.add(textField_pincode);
		textField_pincode.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(10, 209, 70, 14);
		contentPane.add(lblTelephone);
		
		textField_telephone = new JTextField();
		textField_telephone.setBounds(130, 206, 83, 20);
		contentPane.add(textField_telephone);
		textField_telephone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(268, 209, 63, 14);
		contentPane.add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(369, 206, 179, 17);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(10, 244, 70, 14);
		contentPane.add(lblMobileNo);
		
		textField_mobile_no = new JTextField();
		textField_mobile_no.setBounds(130, 241, 83, 20);
		contentPane.add(textField_mobile_no);
		textField_mobile_no.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(48, 290, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				lastActionCommand[0]="ADD";
				comboBox_course_center_no.addItem(DAH.getNewCenterNumber());
				comboBox_course_center_no.setSelectedIndex(comboBox_course_center_no.getItemCount()-1);
				FieldToggle(true);
				FieldCleaner();
			}
		});
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(185, 290, 89, 23);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				lastActionCommand[0]="EDIT";
				FieldToggle(true);
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(322, 290, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="DELETE";
				String ID = comboBox_course_center_no.getSelectedItem().toString();
				if(DAH.deleteCourse(ID)) {
					System.out.println("Deleted Successfully..");
					comboBox_course_center_no.removeItem(ID);
					FieldCleaner();
					comboBox_course_center_no.setSelectedIndex(0);
				}
				else {
					System.out.println("Failed to Delete..");
				}
				lastActionCommand[0]="";
			}
			
		});
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(459, 290, 89, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				String[] data = new String[10];
				data[0] = new String(comboBox_course_center_no.getSelectedItem().toString());
				data[1] = new String(textField_name.getText());
				data[2] = new String(textField_address.getText());
				data[3] = new String(textField_staff_strength.getText());
				data[4] = new String(textField_incharge_no.getText());
				data[5] = new String(textField_incharge_name.getText());
				data[6] = new String(textField_pincode.getText());
				data[7] = new String(textField_telephone.getText());
				data[8] = new String(textField_email.getText());
				data[9] = new String(textField_mobile_no.getText());
				if(FieldValidator(data)) 
				{
					if(lastActionCommand[0].equalsIgnoreCase("ADD")) {
					DAH.addCourse(data);
					lastActionCommand[0]="";
				}
				else if(lastActionCommand[0].equalsIgnoreCase("EDIT")) {
					DAH.updateCourseInfo(data);
					lastActionCommand[0]="";
				}
				FieldToggle(false);
			}
			}
			private boolean FieldValidator(String[] data) {
				// TODO Auto-generated method stub
				boolean checker = true;
				String regex = "";
				
				//Name Field Validation
				regex = "^[a-zA-Z ]{1,50}$";
				Pattern pat = Pattern.compile(regex);
				if(!pat.matcher(data[1]).matches())
				{
					JOptionPane.showMessageDialog(null, "Name should not be empty and can only have characters of lenght 50 max.");
					return false;
				}
				
				// In Name Field Validation
				regex = "^[a-zA-Z ]{1,50}$";
				pat = Pattern.compile(regex);
				if(!pat.matcher(data[5]).matches())
				{
					JOptionPane.showMessageDialog(null, "Name should not be empty and can only have characters of lenght 50 max.");
					return false;
				}
				
				//Staff Strength Field Validation
				regex = "^[1-90-9]{1,3}$";
				pat = Pattern.compile(regex);
				if(!pat.matcher(data[3]).matches() || Integer.parseInt(data[3])==0)
				{
					JOptionPane.showMessageDialog(null, "Staff Strength should be atleast 1 digit and atmost 3 digits long.");
					return false;
				}
				
				//Mobile no Field Validation
				regex = "^[0-9]{10,10}$";
				pat = Pattern.compile(regex);
				if(!pat.matcher(data[9]).matches() || data[9].length()<10)
				{
					JOptionPane.showMessageDialog(null, "Number should be 10 digits long and can only have numbers");
					return false;
				}
				
				//Email Field Validation      
				regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
				pat = Pattern.compile(regex);   
				if(!pat.matcher(data[8]).matches())
				{
					JOptionPane.showMessageDialog(null, "Wrong Email Address");
					return false;
				}
				
						
				
				return checker;
			}
		});
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setBounds(83, 334, 89, 23);
		contentPane.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				StringBuilder message = new StringBuilder();
				message.append("Here You Have To Register \n");
				message.append("The Information Of Counselling Center \n");
				message.append("With All Correct Details \n");
				JOptionPane.showMessageDialog(null,message);
			}
			
		});
		
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBounds(427, 334, 89, 23);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WindowClose();
			}
			
		});
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(255, 334, 89, 23);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FieldCleaner();
			}
			
		});
		
		FieldToggle(false);
		
	}
}
