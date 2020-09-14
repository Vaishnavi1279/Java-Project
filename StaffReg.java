import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class StaffReg extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox; 
	final String lastActionCommand[] = {""};
	DatabaseHelper DAH = new DatabaseHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffReg frame = new StaffReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void FieldToggle(boolean option)
	{
		textField_1.setEditable(option);;
		textField_2.setEditable(option);
		textField_3.setEditable(option);
		textField_4.setEditable(option);
		textField_5.setEditable(option);
		comboBox.setEnabled(!option);
	}
	
	void FieldCleaner()
	{
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
	
	public void WindowClose()
	{
		this.setVisible(false);
		
		this.dispose();
	}
	
	/**
	 * Create the frame.
	 */
	public StaffReg() {
		super("Counselling Staff Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffNo = new JLabel("Staff No.");
		lblStaffNo.setBounds(10, 11, 64, 14);
		contentPane.add(lblStaffNo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(100, 7, 124, 22);
		contentPane.add(comboBox);
		
		JButton btnAdd = new JButton("ADD");
		
		comboBox.addItem("---Select---");
		Vector<String> staff_ids = DAH.getStaffIDS_ALL();
		for(int i = 0 ; i < staff_ids.size() ; i++)
		{
			comboBox.addItem(staff_ids.elementAt(i));
		}
		
		comboBox.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent arg0) 
			{
				if(comboBox.getSelectedIndex()>0) 
				{
					if(arg0.getItem().toString().equalsIgnoreCase(comboBox.getSelectedItem().toString()) && !btnAdd.getText().equalsIgnoreCase("CANCEL")) {
						//if(!lastActionCommand[0].equalsIgnoreCase("ADD") && !lastActionCommand[0].equalsIgnoreCase("DELETE")) {
						System.out.println("Entered the IF block of ComboBox itemStateChanged()");
						Vector<String> data = DAH.getStaffInfo_SELECTED(comboBox.getSelectedItem().toString());
						textField_1.setText(data.elementAt(1));
						textField_2.setText(data.elementAt(2));
						textField_3.setText(data.elementAt(3));
						textField_4.setText(data.elementAt(4));
						textField_5.setText(data.elementAt(5));
						//}
					}
				}
				else { FieldCleaner(); }
			}
		});

		
		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setBounds(10, 42, 81, 14);
		contentPane.add(lblStaffName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 39, 272, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 73, 46, 14);
		contentPane.add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 70, 33, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 102, 81, 14);
		contentPane.add(lblDesignation);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 101, 148, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(10, 138, 81, 14);
		contentPane.add(lblMobileNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 135, 124, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 172, 46, 14);
		contentPane.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setBounds(100, 166, 191, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		FieldToggle(false);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(btnAdd.getText().equalsIgnoreCase("ADD")) {
					comboBox.addItem(DAH.getNewStaffNumber());
					btnAdd.setText("CANCEL");
					comboBox.setSelectedIndex(comboBox.getItemCount()-1);
					FieldToggle(true);
					FieldCleaner();
					lastActionCommand[0]="ADD";
				}
				else if(btnAdd.getText().equalsIgnoreCase("CANCEL")) {
					btnAdd.setText("ADD");
					comboBox.removeItemAt(comboBox.getItemCount()-1);;
					comboBox.setSelectedIndex(0);
					FieldToggle(false);
					FieldCleaner();
					
					
				}
			}
		});
		btnAdd.setBounds(31, 209, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] data = new String[6];
				data[0] = new String(comboBox.getSelectedItem().toString());
				data[1] = new String(textField_1.getText());
				data[2] = new String(textField_2.getText());
				data[3] = new String(textField_3.getText());
				data[4] = new String(textField_4.getText());
				data[5] = new String(textField_5.getText());
				if(FieldValidator(data)) 
				 {
						DAH.addStaff(data);
						lastActionCommand[0]="";
						btnAdd.setText("ADD");
					}
					else if(lastActionCommand[0].equalsIgnoreCase("EDIT")) {
						DAH.updateStaffInfo(data);
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
				if(!pat.matcher(data[4]).matches() || data[4].length()<10)
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
				if(!pat.matcher(data[5]).matches())
				{
					JOptionPane.showMessageDialog(null, "Wrong Email Address");
					return false;
				}
				
						
				
				return checker;
			}
		});
		btnSave.setBounds(151, 209, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="EDIT";
				FieldToggle(true);
			}
		});
		btnEdit.setBounds(271, 209, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lastActionCommand[0]="DELETE";
				String ID = comboBox.getSelectedItem().toString();
				if(DAH.deleteStaff(ID)) {
					System.out.println("Deleted Successfully..");
					comboBox.removeItem(ID);
					FieldCleaner();
					comboBox.setSelectedIndex(0);
				}
				else {
					System.out.println("Failed to Delete..");
				}
				lastActionCommand[0]="";
			}
		});
		btnDelete.setBounds(391, 209, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FieldCleaner();
			}
		});
		btnClear.setBounds(61, 253, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder message = new StringBuilder();
				message.append("Here You Have To Register \n");
				message.append("The Information Of Counselling Staff \n");
				message.append("With All Correct Details\n");
				JOptionPane.showMessageDialog(null,message);
			}
		});
		btnHelp.setBounds(211, 253, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WindowClose();
			}
		});
		btnClose.setBounds(361, 253, 89, 23);
		contentPane.add(btnClose);

	}
}
