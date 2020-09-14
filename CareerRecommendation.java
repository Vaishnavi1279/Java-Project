import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class CareerRecommendation extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	final String lastActionCommand[] = {""};
	DatabaseHelper DAH = new DatabaseHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CareerRecommendation frame = new CareerRecommendation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void FieldToggle(boolean option)
	{
		comboBox_1.setEditable(option);
		textField_1.setEditable(option);
		textField_2.setEditable(option);
		comboBox_2.setEditable(option);
		textField_3.setEditable(option);
		textField_4.setEditable(option);
		textField_5.setEditable(option);
		comboBox_3.setEditable(option);
		textField_6.setEditable(option);
		textField_7.setEditable(option);
		textField_8.setEditable(option);
		comboBox_4.setEditable(option);
		textField_9.setEditable(option);
		textField_10.setEditable(option);
		comboBox.setEnabled(!option);
		comboBox_1.setEnabled(option);
		comboBox_2.setEnabled(option);
		comboBox_3.setEnabled(option);
		comboBox_4.setEnabled(option);
	}

	void FieldCleaner()
	{
		//comboBox_1.setSelectedIndex(0);
		textField_1.setText("");
		textField_2.setText("");
		//comboBox_2.setSelectedIndex(0);
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		//comboBox_3.setSelectedIndex(0);
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		//comboBox_4.setSelectedIndex(0);
		textField_9.setText("");
		textField_10.setText("");
	}
	
	public void WindowClose()
	{
		this.setVisible(false);
		
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public CareerRecommendation() {
		super("CAREER RECOMMENDATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCounsellingSessionNo = new JLabel("Counselling Session No.");
		lblCounsellingSessionNo.setBounds(10, 11, 147, 14);
		contentPane.add(lblCounsellingSessionNo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(150, 7, 106, 22);
		contentPane.add(comboBox);
		comboBox.addItem("---Select---");
		
		Vector<String> csIDS = DAH.getCareerIDS();
		for(String id : csIDS) {
			comboBox.addItem(id);
		}
		
		JLabel lblSessiondate = new JLabel("Session-Date");
		lblSessiondate.setBounds(303, 11, 106, 14);
		contentPane.add(lblSessiondate);
		
		JLabel lblCounsellingCenterNo = new JLabel("Counselling Center No.");
		lblCounsellingCenterNo.setBounds(10, 46, 147, 14);
		contentPane.add(lblCounsellingCenterNo);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(150, 42, 106, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("---Select---");
		Vector<String> course_ids = DAH.getCourseIDS_ALL();
		for(int i = 0 ; i < course_ids.size() ; i++)
		{
			comboBox_1.addItem(course_ids.elementAt(i));
		}
		comboBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) 
				{
					if(!comboBox_1.getSelectedItem().toString().equalsIgnoreCase("---Select---")) {
						Vector<String> data = DAH.getCourseInfo_SELECTED(comboBox_1.getSelectedItem().toString());
						textField_1.setText(data.elementAt(1));
						textField_2.setText(data.elementAt(2));
						}
					
					else { FieldCleaner(); }
					
				}
			});
			
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(303, 46, 80, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(408, 43, 214, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddresss = new JLabel("Addresss");
		lblAddresss.setBounds(10, 82, 90, 14);
		contentPane.add(lblAddresss);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 79, 387, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student No.");
		lblNewLabel.setBounds(10, 116, 106, 14);
		contentPane.add(lblNewLabel);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(150, 112, 106, 22);
		contentPane.add(comboBox_2);
		ArrayList<String> studentIDS = DAH.getStudentID_All();
		comboBox_2.addItem("---Select---");
		for(String id : studentIDS) { comboBox_2.addItem(id); }
		
		comboBox_2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox_2.getSelectedIndex()>0) {
					//if(arg0.getItem().toString().equalsIgnoreCase(comboBox_1.getSelectedItem().toString()) && !btnAdd.getText().equalsIgnoreCase("CANCEL")) {
						ArrayList<String> student_info = DAH.getStudentInfo(comboBox_2.getSelectedItem().toString());
						textField_3.setText(student_info.get(1));
						textField_4.setText(student_info.get(8));
						textField_5.setText(student_info.get(7));
					}
				}
			
		});
		
		JLabel lblName_1 = new JLabel("Student Name");
		lblName_1.setBounds(303, 116, 106, 14);
		contentPane.add(lblName_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(408, 113, 143, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(303, 154, 80, 14);
		contentPane.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setBounds(408, 151, 326, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(10, 154, 106, 14);
		contentPane.add(lblMobileNo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(150, 151, 140, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCounsellerId = new JLabel("Counseller ID");
		lblCounsellerId.setBounds(10, 192, 106, 14);
		contentPane.add(lblCounsellerId);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(150, 188, 106, 22);
		contentPane.add(comboBox_3);
		
		comboBox_3.addItem("---Select---");
		Vector<String> staff_ids = DAH.getStaffIDS_ALL();
		for(int i = 0 ; i < staff_ids.size() ; i++)
		{
			comboBox_3.addItem(staff_ids.elementAt(i));
		}
		
		comboBox_3.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent arg0) 
			{
				if(comboBox_3.getSelectedIndex()>0) 
				{
						Vector<String> data = DAH.getStaffInfo_SELECTED(comboBox_3.getSelectedItem().toString());
						textField_6.setText(data.elementAt(1));
						textField_7.setText(data.elementAt(3));
						textField_8.setText(data.elementAt(4));
				}
		
				else { FieldCleaner(); }
			}
		});
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(303, 192, 46, 14);
		contentPane.add(lblName_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(408, 189, 271, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 234, 80, 14);
		contentPane.add(lblDesignation);
		
		textField_7 = new JTextField();
		textField_7.setBounds(150, 228, 132, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMobileNo_1 = new JLabel("Mobile No.");
		lblMobileNo_1.setBounds(303, 234, 80, 14);
		contentPane.add(lblMobileNo_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(408, 231, 140, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setBounds(303, 271, 80, 14);
		contentPane.add(lblName_3);
		
		JLabel lblEligibilityCourseNo = new JLabel("Eligibility Course No.");
		lblEligibilityCourseNo.setBounds(10, 271, 132, 14);
		contentPane.add(lblEligibilityCourseNo);
		
		textField_9 = new JTextField();
		textField_9.setBounds(408, 268, 271, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(150, 304, 46, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(150, 267, 106, 22);
		contentPane.add(comboBox_4);
		

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new Object[] {"Course_No", "Name", "Duration", "Select Your Interest"});
        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;
            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(24, 340, 809, 116);
		contentPane.add(scrollPane);
		
		
		DefaultTableModel model1 = new DefaultTableModel(new Object[][] {}, new Object[] {"Institute No.","Name","Address","Telephone No","Website","Email","Mobile No","Course No"});
        JTable table1 = new JTable(model1) {
            private static final long serialVersionUID = 1L;
            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {                 
                    default:
                        return String.class;
                }
            }
        };
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane_1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(24, 481, 978, 116);
		contentPane.add(scrollPane_1);
		
		comboBox_4.addItem("---Select---");
		Vector<String> course_id = DAH.getCourseEligibilityNumbers();
		for(int i = 0 ; i < course_id.size() ; i++)
		{
			comboBox_4.addItem(course_id.elementAt(i));
		}
		comboBox_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox_4.getSelectedIndex()>0) 
				{
					if(arg0.getItem().toString().equalsIgnoreCase(comboBox_4.getSelectedItem().toString()))
					{
						Vector<String> data = DAH.getEligibilityCourseInfo_SELECTED(comboBox_4.getSelectedItem().toString().split("-")[0].trim());
						System.out.println("Selected Item Name = "+comboBox_4.getSelectedItem().toString().split("-")[0].trim());
						System.out.println("Vector Size = "+data.size());
						textField_9.setText(data.elementAt(1));
						textField_10.setText(data.elementAt(2));	
						//table.removeAll();
						Vector<Vector<Object>> data1 = DAH.getFurtherCoursesInfo_ForSelectedCourse(comboBox_4.getSelectedItem().toString().split("-")[1].trim());
						while(((DefaultTableModel)table.getModel()).getRowCount()!=0)
						{
							((DefaultTableModel)table.getModel()).removeRow(0);
						}
						for(Vector<Object> item : data1) {
							((DefaultTableModel)table.getModel()).addRow(item);
						}
						//try {
							//table.print(JTable.PrintMode.FIT_WIDTH, null, null);
						//} catch (PrinterException e) {
							// TODO Auto-generated catch block
						//	e.printStackTrace();
						//}
					}
				}
			}
		});
		
		int lastSelectedRowNumber[] = {-1,0};
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(lastSelectedRowNumber[1]==1) {
					// TODO Auto-generated method stub
					if(lastSelectedRowNumber[0]==-1) {
						lastSelectedRowNumber[0] = table.getSelectedRow();
					}
					else {
						
						System.out.println("Last Row Selected Index = "+lastSelectedRowNumber[0]);
					}
				
					try {
						
					Vector<Vector<Object>> data1 = DAH.getCourseBasedClg(table.getValueAt(table.getSelectedRow(), 0).toString());
					//while(((DefaultTableModel)table1.getModel()).getRowCount()!=0)
					{
						table1.removeAll();
						
					}
					for(Vector<Object> item : data1) {
						((DefaultTableModel)table1.getModel()).addRow(item);
					}
					lastSelectedRowNumber[1]=0;
					}
					catch(Exception e) {
						System.out.println("Done Loading");
					}
				}
				else {
					lastSelectedRowNumber[1]=1;
				}
			}
		});
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(10, 307, 80, 14);
		contentPane.add(lblDuration);
		
		
		JLabel lblSession = new JLabel("New label");
		lblSession.setBounds(408, 11, 171, 14);
		contentPane.add(lblSession);
		
		String lastActionCommand[] = new String[] {""};
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="ADD";
				comboBox.addItem(DAH.getNewSessionNumber());
				btnAdd.setText("CANCEL");
				lastActionCommand[0]="ADD";
				comboBox.setSelectedIndex(comboBox.getItemCount()-1);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				lblSession.setText(dateFormat.format(date).toString());
				FieldToggle(true);
				FieldCleaner();
				
			}
		});
		btnAdd.setBounds(100, 628, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="EDIT";
				btnEdit.setText("CANCEL");
				table.setEnabled(true);
				FieldToggle(true);
				
			}
		});
		btnEdit.setBounds(478, 628, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnAdd.getText().equalsIgnoreCase("CANCEL")) 
				{
					String[] data = new String[30];
					data[0] = new String(comboBox.getSelectedItem().toString());
					data[1] = new String(lblSession.getText());
					data[2] = new String(comboBox_1.getSelectedItem().toString());
					data[3] = new String(textField_1.getText());
					data[4] = new String(textField_2.getText());
					data[5] = new String(comboBox_2.getSelectedItem().toString());
					data[6] = new String(textField_3.getText());
					data[7] = new String(textField_4.getText());
					data[8] = new String(textField_5.getText());
					data[9] = new String(comboBox_3.getSelectedItem().toString());
					data[10]= new String(textField_6.getText());
					data[11]= new String(textField_7.getText());
					data[12]= new String(textField_8.getText());
					data[13] = new String(comboBox_4.getSelectedItem().toString());
					data[14]= new String(textField_9.getText());
					data[15]= new String(textField_10.getText());
					data[16] = table.getValueAt(table.getSelectedRow(), 0).toString();
					data[17] = ""; 
					for(int i  = 0 ; i < table1.getRowCount() ; i++) {
					 	data[17] = data[17]+table1.getValueAt(i, 0).toString();
					 	if(i!=table1.getRowCount()-1) {
						 	data[17] = data[17]+",";
					 	}
					}				
					DAH.addCareer(data);
				}
				if(btnEdit.getText().equalsIgnoreCase("CANCEL")) 
				{
					String[] data = new String[30];
					data[0] = new String(comboBox.getSelectedItem().toString());
					data[1] = new String(lblSession.getText());
					data[2] = new String(comboBox_1.getSelectedItem().toString());
					data[3] = new String(textField_1.getText());
					data[4] = new String(textField_2.getText());
					data[5] = new String(comboBox_2.getSelectedItem().toString());
					data[6] = new String(textField_3.getText());
					data[7] = new String(textField_4.getText());
					data[8] = new String(textField_5.getText());
					data[9] = new String(comboBox_3.getSelectedItem().toString());
					data[10]= new String(textField_6.getText());
					data[11]= new String(textField_7.getText());
					data[12]= new String(textField_8.getText());
					data[13] = new String(comboBox_4.getSelectedItem().toString());
					data[14]= new String(textField_9.getText());
					data[15]= new String(textField_10.getText());
					data[16] = table.getValueAt(table.getSelectedRow(), 0).toString();
					data[17] = ""; 
					for(int i  = 0 ; i < table1.getRowCount() ; i++) {
					 	data[17] = data[17]+table1.getValueAt(i, 0).toString();
					 	if(i!=table1.getRowCount()-1) {
						 	data[17] = data[17]+",";
					 	}
					}				
					DAH.updateCareer(data);
				}
				
			}
		});
		btnSave.setBounds(289, 628, 89, 23);
		contentPane.add(btnSave);
		
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastActionCommand[0]="DELETE";
				String ID = comboBox.getSelectedItem().toString();
				if(DAH.deleteCareer(ID)) {
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
		btnDelete.setBounds(667, 628, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			FieldCleaner();
			}
		});
		btnClear.setBounds(148, 673, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setBounds(385, 673, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			WindowClose();
			}
		});
		btnClose.setBounds(622, 673, 89, 23);
		contentPane.add(btnClose);
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(!btnAdd.getText().toString().equalsIgnoreCase("CANCEL")) {
					if(comboBox.getSelectedItem().toString().equalsIgnoreCase(arg0.getItem().toString())) 
					{
						String data[] = DAH.getCareerInfo_Selected(comboBox.getSelectedItem().toString());
						comboBox_1.setSelectedItem(data[2]);
						comboBox_2.setSelectedItem(data[5]);
						comboBox_3.setSelectedItem(data[9]);
						comboBox_4.setSelectedItem(data[13]);
						for(int i  = 0 ; i < table.getRowCount() ; i++) {
							if(table.getValueAt(i, 0).toString().equals(data[16])) {
								table.changeSelection(i, 3, false, false);
								table.setEnabled(false);
								Vector<Vector<Object>> data1 = DAH.getCourseBasedClg(table.getValueAt(table.getSelectedRow(), 0).toString());
								while(((DefaultTableModel)table1.getModel()).getRowCount()!=0)
								{
									((DefaultTableModel)table1.getModel()).removeRow(0);
								}
								for(Vector<Object> item : data1) {
									((DefaultTableModel)table1.getModel()).addRow(item);
								}
							}
						}
					}
				}
			}
		});
		
		FieldToggle(false);
		
	}
}
