import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class Courses_Eligibility extends JFrame {

	String[] lastActionCommand = new String[]{""};
	private JPanel contentPane;
	private JComboBox comboBox_courseno = new JComboBox();
	private JTextField textField_duration;
	private JTextField textField_coursename;
	private JComboBox comboBox_eligible_course1;
	private JComboBox comboBox_eligible_course2;
	private JComboBox comboBox_eligible_course3;
	private JLabel lblNewLabel_previous1;
	private JLabel lblNewLabel_previous2;
	private JLabel lblNewLabel_previous3; 
	DatabaseHelper DAH=new DatabaseHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses_Eligibility frame = new Courses_Eligibility();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void WindowClose()
	{
		this.setVisible(false);
		
		this.dispose();
	}
	/**
	 * Create the frame.
	}
	 */
	
	public void FieldToggle(boolean toggle) 
	{
		comboBox_courseno.setEnabled(!toggle);
		//textField_duration.setEnabled(toggle);
		textField_duration.setEditable(toggle);
		//textField_coursename.setEnabled(toggle);
		textField_coursename.setEditable(toggle);
		comboBox_eligible_course1.setEnabled(toggle);
		comboBox_eligible_course2.setEnabled(toggle);
		comboBox_eligible_course3.setEnabled(toggle);
	}
	
	public void FieldCleaner() 
	{
		textField_duration.setText("");
		textField_coursename.setText("");
		comboBox_eligible_course1.setSelectedIndex(0);
		comboBox_eligible_course2.setSelectedIndex(0);
		comboBox_eligible_course3.setSelectedIndex(0);
		
	}
	
	public Courses_Eligibility() {
		super("Courses Eligibility Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseNo = new JLabel("Course No.");
		lblCourseNo.setBounds(10, 11, 82, 14);
		contentPane.add(lblCourseNo);
		
		comboBox_courseno = new JComboBox();
		comboBox_courseno.setBounds(161, 7, 181, 22);
		contentPane.add(comboBox_courseno);
		comboBox_courseno.addItem("---Select---");
		Vector<String> course_ids = DAH.getCourseEligibilityNumbers();
		for(int i = 0 ; i < course_ids.size() ; i++)
		{
			comboBox_courseno.addItem(course_ids.elementAt(i));
		}
		
		comboBox_eligible_course1 = new JComboBox();
		comboBox_eligible_course1.setBounds(161, 94, 98, 22);
		contentPane.add(comboBox_eligible_course1);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 39, 82, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblDurationInYears = new JLabel("Duration in Years.");
		lblDurationInYears.setBounds(10, 69, 108, 14);
		contentPane.add(lblDurationInYears);
		
		JLabel lblEligibilityCourseNo = new JLabel("Eligibility Course No.");
		lblEligibilityCourseNo.setBounds(10, 98, 133, 14);
		contentPane.add(lblEligibilityCourseNo);
		
		
		JLabel lblName = new JLabel("Eligibility Course No.");
		lblName.setBounds(10, 137, 133, 14);
		contentPane.add(lblName);
		
		JLabel lblEligibilityCourseNo_1 = new JLabel("Eligibility Course No.");
		lblEligibilityCourseNo_1.setBounds(10, 174, 133, 14);
		contentPane.add(lblEligibilityCourseNo_1);
		
		comboBox_eligible_course2 = new JComboBox();
		comboBox_eligible_course2.setBounds(161, 133, 98, 22);
		contentPane.add(comboBox_eligible_course2);
		
		comboBox_eligible_course3 = new JComboBox();
		comboBox_eligible_course3.setBounds(161, 170, 98, 22);
		contentPane.add(comboBox_eligible_course3);
		
		lblNewLabel_previous3 = new JLabel("");
		lblNewLabel_previous3.setBounds(317, 151, 259, 22);
		contentPane.add(lblNewLabel_previous3);
		
		lblNewLabel_previous2 = new JLabel("");
		lblNewLabel_previous2.setBounds(317, 113, 259, 22);
		contentPane.add(lblNewLabel_previous2);
		
		lblNewLabel_previous1 = new JLabel("");
		lblNewLabel_previous1.setBounds(317, 75, 259, 22);
		contentPane.add(lblNewLabel_previous1);
		
		textField_duration = new JTextField();
		textField_duration.setBounds(161, 66, 62, 20);
		contentPane.add(textField_duration);
		textField_duration.setColumns(10);
		
		textField_coursename = new JTextField();
		textField_coursename.setBounds(161, 36, 215, 20);
		contentPane.add(textField_coursename);
		textField_coursename.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(280, 98, 62, 14);
		contentPane.add(lblName_1);
		
		JLabel lblNewLabel = new JLabel("Select an Option first");
		lblNewLabel.setBounds(364, 98, 212, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(280, 137, 62, 14);
		contentPane.add(lblName_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select an Option first");
		lblNewLabel_1.setBounds(364, 137, 212, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setBounds(280, 174, 62, 14);
		contentPane.add(lblName_3);
		
		JLabel lblNewLabel_2 = new JLabel("Select an Option first");
		lblNewLabel_2.setBounds(364, 174, 212, 14);
		contentPane.add(lblNewLabel_2);
		textField_coursename.setEditable(false);
		textField_duration.setEditable(false);
		
		JButton btnAdd = new JButton("ADD");
		
		Vector<String> courseinfo  = new Vector<>();
		final TreeMap<String,Object> courseeligible[] = new TreeMap[]{new TreeMap<String,Object>()};
		comboBox_courseno.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged (ItemEvent arg0) 
				{
					
				if(comboBox_eligible_course1.getItemListeners().length>0)
				{
					comboBox_eligible_course1.removeItemListener(comboBox_eligible_course1.getItemListeners()[0]);
					comboBox_eligible_course2.removeItemListener(comboBox_eligible_course2.getItemListeners()[0]);
					comboBox_eligible_course3.removeItemListener(comboBox_eligible_course3.getItemListeners()[0]);
				}
					comboBox_eligible_course1.removeAllItems();
					comboBox_eligible_course2.removeAllItems();
					comboBox_eligible_course3.removeAllItems();
					courseinfo.clear();
				
					if(btnAdd.getText().toString().equalsIgnoreCase("CANCEL")) {
						comboBox_eligible_course1.addItem("---Select---");
						comboBox_eligible_course2.addItem("---Select---");
						comboBox_eligible_course3.addItem("---Select---");
						Vector<String> v = DAH.getCourseEligibilityNumbers();
						for(int i = 0 ; i < v.size() ; i++)
						{
							comboBox_eligible_course1.addItem(v.elementAt(i));
							comboBox_eligible_course2.addItem(v.elementAt(i));
							comboBox_eligible_course3.addItem(v.elementAt(i));
						}
						lblNewLabel.setText("Please select an eligible course no first");
						lblNewLabel_1.setText("Please select an eligible course no first");
						lblNewLabel_2.setText("Please select an eligible course no first");
						
						comboBox_eligible_course1.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course1.getSelectedIndex()>0)
									lblNewLabel.setText((comboBox_eligible_course1.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel.setText("Please select an eligible course no first");
							}
							
						});
						comboBox_eligible_course2.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course2.getSelectedIndex()>0)
									lblNewLabel_1.setText((comboBox_eligible_course2.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel_1.setText("Please select an eligible course no first");
							}
							
						});
						comboBox_eligible_course3.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course3.getSelectedIndex()>0)
									lblNewLabel_2.setText((comboBox_eligible_course3.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel_2.setText("Please select an eligible course no first");
							}
						
							
						});
					}
					else {
					if(comboBox_courseno.getSelectedItem().toString().equalsIgnoreCase("---Select---")) {
						textField_coursename.setText("");
						textField_duration.setText("");
					}
					else {
						if(arg0.getItem().toString().equalsIgnoreCase(comboBox_courseno.getSelectedItem().toString())) {
							
							Vector<String> info = DAH.getCourseEligibleInfo_SELECTED((comboBox_courseno.getSelectedItem().toString().split("-"))[0].trim());
							textField_coursename.setText(info.elementAt(0));
							textField_duration.setText(info.elementAt(1));
							courseeligible[0] = DAH.getEligibleCourses(comboBox_courseno.getSelectedItem().toString().split("-")[0].trim());

							comboBox_eligible_course1.addItem("---Select---");
							comboBox_eligible_course2.addItem("---Select---");
							comboBox_eligible_course3.addItem("---Select---");
							
							for(Map.Entry<String, Object> item : courseeligible[0].entrySet()) {
								comboBox_eligible_course1.addItem(item.getKey());
								comboBox_eligible_course2.addItem(item.getKey());
								comboBox_eligible_course3.addItem(item.getKey());
							}
							comboBox_eligible_course1.addItemListener(new ItemListener() {

								@Override
								public void itemStateChanged(ItemEvent arg0) {
									// TODO Auto-generated method stub
									if(comboBox_eligible_course1.getSelectedIndex()>0) 
										lblNewLabel.setText(courseeligible[0].get(comboBox_eligible_course1.getSelectedItem().toString()).toString());
									else
										lblNewLabel.setText("Select an Option first");
								}
							
							});
							comboBox_eligible_course2.addItemListener(new ItemListener() {

								@Override
								public void itemStateChanged(ItemEvent arg0) {
									// TODO Auto-generated method stub
									if(comboBox_eligible_course2.getSelectedIndex()>0) 
										lblNewLabel_1.setText(courseeligible[0].get(comboBox_eligible_course2.getSelectedItem().toString()).toString());
									else
										lblNewLabel_1.setText("Select an Option first");
								}
							
							});
							comboBox_eligible_course3.addItemListener(new ItemListener() {

								@Override
								public void itemStateChanged(ItemEvent arg0) {
									// TODO Auto-generated method stub
									if(comboBox_eligible_course3.getSelectedIndex()>0) 
										lblNewLabel_2.setText(courseeligible[0].get(comboBox_eligible_course3.getSelectedItem().toString()).toString());
									else
										lblNewLabel_2.setText("Select an Option first");
								}
							
							});
							
						}
					}
					}
				}
		});
			
		btnAdd.setBounds(25, 217, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lastActionCommand = null;
				//TODO
				
				switch(arg0.getActionCommand().toString())
				{
				case "ADD":
						String newNumber = DAH.getNewCourseEligibilityNumber();
						btnAdd.setText("CANCEL");
						comboBox_courseno.addItem(newNumber);
						comboBox_courseno.setSelectedIndex(comboBox_courseno.getItemCount()-1);
						comboBox_courseno.setEnabled(false);
						textField_coursename.setText("");
						textField_duration.setText("");
						textField_coursename.setEditable(true);
						textField_duration.setEditable(true);
						
						break;
				case "CANCEL":
						comboBox_courseno.removeItemAt(comboBox_courseno.getItemCount()-1);
						btnAdd.setText("ADD");
						comboBox_courseno.setSelectedIndex(0);
						comboBox_courseno.setEnabled(true);
						btnAdd.setText("ADD");
						textField_coursename.setEditable(false);
						textField_duration.setEditable(false);
				}
			}	
		});
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(139, 217, 89, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				// Database Methods to add the new entry in CourseEligibilityTable
				if(btnAdd.getText().toString().equalsIgnoreCase("CANCEL")) 
				{
					DAH.addNewCourseEligibility(comboBox_courseno.getSelectedItem().toString(), textField_coursename.getText(),
							textField_duration.getText(),comboBox_eligible_course1.getSelectedItem().toString(),
							comboBox_eligible_course2.getSelectedItem().toString(),comboBox_eligible_course3.getSelectedItem().toString());
					btnAdd.setText("ADD");
					String temp = comboBox_courseno.getSelectedItem().toString()+" - "+textField_coursename.getText().toString();
					comboBox_courseno.removeItemAt(comboBox_courseno.getItemCount()-1);
					comboBox_courseno.addItem(temp);
					comboBox_courseno.setSelectedIndex(comboBox_courseno.getItemCount()-1);
					comboBox_courseno.setEnabled(true);
					textField_coursename.setText("");
					textField_coursename.setEditable(false);
					textField_duration.setText("");
					textField_duration.setEditable(false);
				}
				if(lastActionCommand[0].equalsIgnoreCase("EDIT"))
				{
					System.out.println("Entered Edit block of Save button");
					DAH.updateEligibleCourseInfo(comboBox_courseno.getSelectedItem().toString().split("-")[0].trim()
							,textField_coursename.getText().toString().trim(),textField_duration.getText().toString().trim()
							,comboBox_eligible_course1.getSelectedItem().toString(),comboBox_eligible_course2.getSelectedItem().toString()
							,comboBox_eligible_course3.getSelectedItem().toString());
					lastActionCommand[0]="";
					String name = comboBox_courseno.getSelectedItem().toString().trim().split("-")[0].trim()+" - "+textField_coursename.getText().toString();
					int index = comboBox_courseno.getSelectedIndex();
					comboBox_courseno.setSelectedIndex(0);
					comboBox_courseno.removeItem(index);
					comboBox_courseno.removeItemAt(index);
					comboBox_courseno.insertItemAt(name, index);
					comboBox_courseno.setSelectedIndex(index);
					lblNewLabel_previous1.setText("");
					lblNewLabel_previous2.setText("");
					lblNewLabel_previous3.setText("");
					FieldToggle(false);
					comboBox_eligible_course1.setEnabled(true);
					comboBox_eligible_course2.setEnabled(true);
					comboBox_eligible_course3.setEnabled(true);
					
				}
			}
			
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(253, 217, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int option =  JOptionPane.showConfirmDialog(null,"Do you realy want to delete this course?","Sure?",JOptionPane.YES_NO_OPTION);
				if(option==0)
				{
					DAH.deleteCourseEligibility_Selected(comboBox_courseno.getSelectedItem().toString().split("-")[0].trim());
					comboBox_courseno.removeItem(comboBox_courseno.getSelectedItem().toString());
					comboBox_courseno.setSelectedIndex(0);
				}
			}
			
		});
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(367, 217, 89, 23);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox_courseno.getSelectedIndex()>0)
				{
					lastActionCommand[0]="EDIT";
					FieldToggle(true);
					TreeMap<String,Object> map = DAH.getEligibleCourses(comboBox_courseno.getSelectedItem().toString().split("-")[0].trim());
					ArrayList<String> items = new ArrayList<>();
					for(Map.Entry<String, Object> item : map.entrySet()) {
						items.add(item.getKey()+" - "+item.getValue().toString());
					}
					if(items.size()>=1) {
						lblNewLabel_previous1.setText("Previous Selection = "+items.get(0));
					}
					if(items.size()>=2) {
						lblNewLabel_previous2.setText("Previous Selection = "+items.get(1));
					}
					if(items.size()>=3) {
						lblNewLabel_previous3.setText("Previous Selection = "+items.get(2));
					}
					FieldToggle(true);
					if(comboBox_eligible_course1.getItemListeners().length>0)
					{
						comboBox_eligible_course1.removeItemListener(comboBox_eligible_course1.getItemListeners()[0]);
						comboBox_eligible_course2.removeItemListener(comboBox_eligible_course2.getItemListeners()[0]);
						comboBox_eligible_course3.removeItemListener(comboBox_eligible_course3.getItemListeners()[0]);
					}
						comboBox_eligible_course1.removeAllItems();
						comboBox_eligible_course2.removeAllItems();
						comboBox_eligible_course3.removeAllItems();
						
					
						comboBox_eligible_course1.addItem("---Select---");
						comboBox_eligible_course2.addItem("---Select---");
						comboBox_eligible_course3.addItem("---Select---");
						Vector<String> v = DAH.getCourseEligibilityNumbers();
						for(int i = 0 ; i < v.size() ; i++)
						{
							if(!comboBox_courseno.getSelectedItem().toString().equalsIgnoreCase(v.elementAt(i))) {
								comboBox_eligible_course1.addItem(v.elementAt(i));
								comboBox_eligible_course2.addItem(v.elementAt(i));
								comboBox_eligible_course3.addItem(v.elementAt(i));
							}
						}
						lblNewLabel.setText("Please select an eligible course no first");
						lblNewLabel_1.setText("Please select an eligible course no first");
						lblNewLabel_2.setText("Please select an eligible course no first");
							
						comboBox_eligible_course1.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course1.getSelectedIndex()>0)
									lblNewLabel.setText((comboBox_eligible_course1.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel.setText("Please select an eligible course no first");
							}
								
						});
						comboBox_eligible_course2.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course2.getSelectedIndex()>0)
									lblNewLabel_1.setText((comboBox_eligible_course2.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel_1.setText("Please select an eligible course no first");
							}
								
						});
						comboBox_eligible_course3.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent arg0) {
								// TODO Auto-generated method stub
								if(comboBox_eligible_course3.getSelectedIndex()>0)
									lblNewLabel_2.setText((comboBox_eligible_course3.getSelectedItem().toString().split("-"))[1].trim());
								else
									lblNewLabel_2.setText("Please select an eligible course no first");
							}
							
								
						});
						
					if(!lblNewLabel_previous1.getText().equalsIgnoreCase("")) {	
						comboBox_eligible_course1.setSelectedItem(lblNewLabel_previous1.getText().split("-")[1].trim());
					}
					if(!lblNewLabel_previous2.getText().equalsIgnoreCase("")) {
						comboBox_eligible_course2.setSelectedItem(lblNewLabel_previous2.getText().split("-")[1].trim());
					}
					if(!lblNewLabel_previous3.getText().equalsIgnoreCase("")) {
						comboBox_eligible_course3.setSelectedItem(lblNewLabel_previous3.getText().split("-")[1].trim());
					}
				}
			}
		});
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FieldCleaner();	
			}
		});
		btnClear.setBounds(54, 251, 89, 23);
		contentPane.add(btnClear);
		
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
		btnHelp.setBounds(197, 251, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WindowClose();	
			}
		});
		btnClose.setBounds(340, 251, 89, 23);
		contentPane.add(btnClose);
		
		
	}
}
