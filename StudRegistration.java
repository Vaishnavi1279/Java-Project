import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;

public class StudRegistration extends JFrame {

	private JPanel contentPane;
	private JLabel StudentName;
	private JTextField textField_1;
	private JLabel Age;
	private JTextField textField_2;
	private JLabel DateOfBirth;
	private JTextField textField_3;
	private JLabel PassedQualifications;
	private JLabel Percentage;
	private JTextField textField_5;
	private JLabel Email;
	private JTextField textField_6;
	private JLabel MobileNo;
	private JTextField textField_7;
	private String lastActionCommand[]= {""};
	private JComboBox comboBox,comboBox_1;
	private String selecteditem;
	DatabaseHelper DAH = new DatabaseHelper();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudRegistration frame = new StudRegistration();
					frame.setVisible(true);
					frame.setBackground(Color.RED);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void FieldToggle(boolean option)
	{
		comboBox_1.setEnabled(!option);
		textField_1.setEditable(option);
		textField_2.setEditable(option);
		textField_3.setEditable(option);
		comboBox.setEnabled(option);
		textField_5.setEditable(option);
		textField_6.setEditable(option);
		textField_7.setEditable(option);
		textField.setEditable(option);
	}

	void FieldCleaner()
	{
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		comboBox.setSelectedIndex(0);
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField.setText("");
	}

	public void WindowClose()
	{
		this.setVisible(false);
		
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public StudRegistration() {
		super("Student Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Stud_No = new JLabel("Student No.");
		Stud_No.setBounds(10, 21, 65, 14);
		contentPane.add(Stud_No);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(138, 17, 129, 22);
		contentPane.add(comboBox_1);
		ArrayList<String> studentIDS = DAH.getStudentID_All();
		comboBox_1.addItem("---Select---");
		for(String id : studentIDS) { comboBox_1.addItem(id); }
		
		
		
		StudentName = new JLabel("Student Name");
		StudentName.setBounds(10, 55, 86, 14);
		contentPane.add(StudentName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 52, 224, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Age = new JLabel("Age");
		Age.setBounds(10, 92, 46, 14);
		contentPane.add(Age);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 89, 36, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		DateOfBirth = new JLabel("Date of Birth");
		DateOfBirth.setBounds(10, 127, 86, 14);
		contentPane.add(DateOfBirth);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 124, 91, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		PassedQualifications = new JLabel("Passed Qualification");
		PassedQualifications.setBounds(10, 164, 121, 14);
		contentPane.add(PassedQualifications);
		
		Percentage = new JLabel("Percentage");
		Percentage.setBounds(10, 198, 86, 14);
		contentPane.add(Percentage);
		textField_5 = new JTextField();
		textField_5.setBounds(138, 195, 36, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		Email = new JLabel("Email");
		Email.setBounds(10, 234, 46, 14);
		contentPane.add(Email);
		
		textField_6 = new JTextField();
		textField_6.setBounds(138, 231, 187, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		MobileNo = new JLabel("Mobile No.");
		MobileNo.setBounds(10, 272, 93, 14);
		contentPane.add(MobileNo);
		
		textField_7 = new JTextField();
		textField_7.setBounds(138, 269, 110, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				selecteditem=(String)arg0.getItem();
			}
		});
		comboBox.setBounds(138, 160, 90, 22);
		comboBox.addItem("---Select---");
		comboBox.addItem("SSC");
		comboBox.addItem("HSC");
		comboBox.addItem("B.SC");
		comboBox.addItem("Graduation");
		comboBox.addItem("Polytechnic");
		comboBox.addItem("B.E.");
		comboBox.addItem("M.E.");
		comboBox.addItem("MBA");
		comboBox.addItem("B.com");
		comboBox.addItem("BBA");
		contentPane.add(comboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 311, 46, 14);
		contentPane.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(138, 308, 316, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		
		ButtonGroup bg= new ButtonGroup();
		
		comboBox_1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox_1.getSelectedIndex()>0) {
					if(arg0.getItem().toString().equalsIgnoreCase(comboBox_1.getSelectedItem().toString()) && !btnAdd.getText().equalsIgnoreCase("CANCEL")) {
						ArrayList<String> student_info = DAH.getStudentInfo(comboBox_1.getSelectedItem().toString());
						textField_1.setText(student_info.get(1));
						textField_2.setText(student_info.get(2));
						textField_3.setText(student_info.get(3));
						comboBox.setSelectedItem(student_info.get(4));
						textField_5.setText(student_info.get(5));
						textField_6.setText(student_info.get(6));
						textField_7.setText(student_info.get(7));
						textField.setText(student_info.get(8));
						//if(student_info.get(8).isEmpty()) {
							//Code to select any radio button according to database
						//}
					}
				}
			}
			
		});
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnAdd.getText().equalsIgnoreCase("ADD")) {
					comboBox_1.addItem(DAH.getNewStudentNumber());
					btnAdd.setText("CANCEL");
					comboBox_1.setSelectedIndex(comboBox_1.getItemCount()-1);
					FieldCleaner();
					FieldToggle(true);
					//FieldCleaner();
					
					lastActionCommand[0]="ADD";
				}
				else if(btnAdd.getText().equalsIgnoreCase("CANCEL")) {
					btnAdd.setText("ADD");
					comboBox_1.removeItemAt(comboBox_1.getItemCount()-1);;
					comboBox_1.setSelectedIndex(0);
					FieldToggle(false);
					FieldCleaner();
					
					
				}
			}
		});
		btnAdd.setBounds(32, 353, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] data = new String[10];
				data[0] = new String(comboBox_1.getSelectedItem().toString());
				data[1] = new String(textField_1.getText());
				data[2] = new String(textField_2.getText());
				data[3] = new String(textField_3.getText());
				data[4] = new String(comboBox.getSelectedItem().toString());
				data[5] = new String(textField_5.getText());
				data[6] = new String(textField_6.getText());
				data[7] = new String(textField_7.getText());
				data[8] = new String(textField.getText());
				if(FieldValidator(data)) {
					DAH.addStudent(data);
					lastActionCommand[0]="";
					btnAdd.setText("ADD");
				}
				else if(lastActionCommand[0].equalsIgnoreCase("EDIT")){
					DAH.updateStudentInfo(data);
					lastActionCommand[0]="";
				}
				FieldToggle(false);
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
				
				//Age Field Validation
				regex = "^[1-90-9]{1,3}$";
				pat = Pattern.compile(regex);
				if(!pat.matcher(data[2]).matches() || Integer.parseInt(data[2])==0)
				{
					JOptionPane.showMessageDialog(null, "Age should be atleast 1 digit and atmost 3 digits long.");
					return false;
				}
				
				//Mobile No Field Validation
				regex = "^[0-9]{10,10}$";
				pat = Pattern.compile(regex);
				if(!pat.matcher(data[7]).matches() || data[4].length()<10)
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
				if(!pat.matcher(data[6]).matches())
				{
					JOptionPane.showMessageDialog(null, "Wrong Email Address");
					return false;
				}
				
						return checker;
			}
		});
		btnSave.setBounds(153, 353, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("DELETE");
		
		btnDelete.setBounds(395, 353, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete the student?", "Confirmation Please..", dialogButton);
				if(dialogResult == 0) {
				  System.out.println("Yes option");
				  lastActionCommand[0]="DELETE";
				  	String ID = comboBox_1.getSelectedItem().toString();
				  	if(DAH.deleteStudent(ID)) {
					  	System.out.println("Deleted Successfully..");
					  	comboBox_1.removeItem(ID);
					  	comboBox_1.setSelectedIndex(0);
					  	
					  	FieldCleaner();
					  	lastActionCommand[0]="";
				  	}
				  	else {
					  	System.out.println("Failed to Delete..");
				  	}
				} else {
					System.out.println("No Option");	
				} 
				
			}
			
		});
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="EDIT";
				FieldToggle(true);
			}
		});
		btnEdit.setBounds(274, 353, 89, 23);
		contentPane.add(btnEdit);
		
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder message = new StringBuilder();
				message.append("Here You Have To Register\n");
				message.append("The Information Of Student \n");
				message.append("With All Correct Details \n");
				JOptionPane.showMessageDialog(null,message);
			}
		});
		btnHelp.setBounds(59, 407, 99, 23);
		contentPane.add(btnHelp);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WindowClose();
			}
		});
		btnClose.setBounds(365, 407, 93, 23);
		contentPane.add(btnClose);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(217, 407, 89, 23);
		contentPane.add(btnClear);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FieldCleaner();
			}
		});
		
		FieldToggle(false);
		
	}
}
