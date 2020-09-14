import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.ScrollPane;
import java.awt.print.PrinterException;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Export extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Export frame = new Export();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	/*
	public Export(String[] header, ResultSet rs)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		/*
		
		Vector<Vector<String>> dataset = new Vector<>();
		try {
		while(rs.next()) {
			Vector<String> data = new Vector<>();
			for(int i = 0 ; i < 10 ; i ++) {
				data.addElement(rs.getString(i+1));
			}
			dataset.addElement(data);
		}
		}
		catch(SQLException e) {}
		
		String[][] tabledata = new String[dataset.size()][10];
		for(int i = 0 ; i < dataset.size() ; i ++) {
			Vector<String> vec = dataset.elementAt(i);
			Object[] d = vec.toArray();
			for(int j = 0 ; j < d.length ; j ++) {
				tabledata[i][j] = d[j].toString();
				System.out.println("Got Data Value = "+d[j].toString());
			}
		}
		
		
		
		table = new JTable( tabledata, (Object[])header);
		//table.setBounds(2, 22, 800, 300);
		table.setBorder(BorderFactory.createEmptyBorder());
		//contentPane.add(table);
		table.setVisible(true);
		JScrollPane jsp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(2, 22, 891, 350);
		jsp.setVisible(true);
		
		contentPane.add(jsp);
		
		*/
	
		
		DatabaseHelper DAH = new DatabaseHelper();
		public Export() {
			
			
			
			

			try{
				Class.forName("org.sqlite.JDBC"); 
				String url = "jdbc:sqlite:C:\\Users\\hp\\Desktop\\mydatabasefile.db";
				con = DriverManager.getConnection(url);
			}
			catch(SQLException e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
			catch(Exception e)
			{
				System.out.println("Global Exception occured. Message = "+e.toString());
			}

			
			
			setResizable(false);
			//Image icon = new ImageIcon(this.getClass().getResource("icon.png")).getImage();
			//this.setIconImage(icon);
			setTitle("Inventory and Purchase Management System");
			//SpecifyDirectory.crdir1();
			//Connection conn=Connectionsqlite.con2();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnNewButton =  new JButton("REPORT OF ITEMS WITH QUANTITY");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try{
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH);
						int date = now.get(Calendar.DATE);
						String s = year+"-"+month;
						String filename="F:\\java\\carrier counsceiling management system\\src\\center.xls" ;
						HSSFWorkbook hwb=new HSSFWorkbook();
						HSSFSheet sheet =  hwb.createSheet("First Report");
						HSSFRow rowhead=   sheet.createRow((short)0);
						
						
						rowhead.createCell((short) 0).setCellValue("ID");
						rowhead.createCell((short) 1).setCellValue("Name");
						rowhead.createCell((short) 2).setCellValue("Address");
						rowhead.createCell((short) 3).setCellValue("Staff_Strength");
						
						rowhead.createCell((short) 4).setCellValue("Incharge_No");
						rowhead.createCell((short) 5).setCellValue("Incharge_Name");
						rowhead.createCell((short) 6).setCellValue("Pincode");
						rowhead.createCell((short) 7).setCellValue("Telephone");
						rowhead.createCell((short) 8).setCellValue("Email");
						rowhead.createCell((short) 9).setCellValue("Mobile_No");
						sheet.setColumnWidth((short)0,(short)7000);
						sheet.setColumnWidth((short)1,(short)7000);
						sheet.setColumnWidth((short)2,(short)7000);
						sheet.setColumnWidth((short)3,(short)7000);
						sheet.setColumnWidth((short)4,(short)7000);
						sheet.setColumnWidth((short)5,(short)7000);
						sheet.setColumnWidth((short)6,(short)7000);
						sheet.setColumnWidth((short)7,(short)7000);
						sheet.setColumnWidth((short)8,(short)7000);
						sheet.setColumnWidth((short)9,(short)7000);
						
						PreparedStatement prs = con.prepareStatement("Select * from Course_Center_Info");
						
						ResultSet rs = prs.executeQuery();
						int i=1;
						int m=0;
						String t = new String();
						while(rs.next())
						{
						HSSFRow row=   sheet.createRow((short)i);
						row.createCell((short) 0).setCellValue(rs.getString("ID"));
						row.createCell((short) 1).setCellValue(rs.getString("Name"));
						row.createCell((short) 2).setCellValue(rs.getString("Address"));
						row.createCell((short) 3).setCellValue(rs.getString("Staff_Strength"));
						row.createCell((short) 4).setCellValue(rs.getString("Incharge_No"));
						row.createCell((short) 5).setCellValue(rs.getString("Incharge_Name"));
						row.createCell((short) 6).setCellValue(rs.getString("Pincode"));
						row.createCell((short) 7).setCellValue(rs.getString("Telephone"));
						row.createCell((short) 8).setCellValue(rs.getString("Email"));
						row.createCell((short) 9).setCellValue(rs.getString("Mobile_No"));
						i++;
						}
						FileOutputStream fileOut =  new FileOutputStream(filename);
						hwb.write(fileOut);
						fileOut.close();
						JOptionPane.showMessageDialog(contentPane,"EXCEL FILE IS GENERATED AT : F:\\\\java\\\\carrier counsceiling management system\\\\src\\\\center.xls");
						}
					    catch ( Exception m ) 
					    {	
						    JOptionPane.showMessageDialog(null,m);
						}			
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewButton.setBounds(10, 67, 414, 39);
			contentPane.add(btnNewButton);
			
		/*	JButton btnReturnItemsReport = new JButton("RETURN ITEMS REPORT");
			btnReturnItemsReport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try{
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH);
						int date = now.get(Calendar.DATE);
						String s = year+"-"+month;
						String filename="C:\\Industrial Project\\Return.xls" ;
						HSSFWorkbook hwb=new HSSFWorkbook();
						HSSFSheet sheet =  hwb.createSheet("Second Report");
						HSSFRow rowhead=   sheet.createRow((short)0);
						rowhead.createCell((short) 0).setCellValue("Return no");
						rowhead.createCell((short) 1).setCellValue("date");
						rowhead.createCell((short) 2).setCellValue("Return Reason");
						rowhead.createCell((short) 3).setCellValue("Issue No");
						rowhead.createCell((short) 4).setCellValue("Return Quantity");
						rowhead.createCell((short) 5).setCellValue("Item No");
						sheet.setColumnWidth((short)0,(short)7000);
						sheet.setColumnWidth((short)1,(short)7000);
						sheet.setColumnWidth((short)2,(short)7000);
						sheet.setColumnWidth((short)3,(short)7000);
						sheet.setColumnWidth((short)4,(short)7000);
						sheet.setColumnWidth((short)5,(short)7000);
						Statement st=conn.createStatement();
						ResultSet rs = st.executeQuery("Select * from return_master");
						int i=1;
						int m=0;
						String t = new String();
						while(rs.next())
						{
						HSSFRow row=   sheet.createRow((short)i);
						row.createCell((short) 0).setCellValue(rs.getString("return_no"));
						row.createCell((short) 1).setCellValue(rs.getString("return_date"));
						row.createCell((short) 2).setCellValue(rs.getString("return_reason"));
						row.createCell((short) 3).setCellValue(rs.getString("issueno"));
						row.createCell((short) 4).setCellValue(rs.getString("return_quantity"));
						row.createCell((short) 5).setCellValue(rs.getString("item_no"));
						i++;
						}
						FileOutputStream fileOut =  new FileOutputStream(filename);
						hwb.write(fileOut);
						fileOut.close();
						JOptionPane.showMessageDialog(contentPane,"EXCEL FILE IS GENERATED AT : C:\\Industrial Project\\Return.xls");
						}
					    catch ( Exception m ) 
					    {	
						    JOptionPane.showMessageDialog(null,m);
						}			

				}
			});
			btnReturnItemsReport.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnReturnItemsReport.setBounds(10, 117, 414, 39);
			contentPane.add(btnReturnItemsReport);
			*/
			JButton btnShowReportOf = new JButton("SHOW REPORT OF ITEMS ");
			btnShowReportOf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
					{
						File file = new File("F:\\java\\carrier counsceiling management system\\src\\center.xls");
				        
				        if(!Desktop.isDesktopSupported()){
				            System.out.println("Desktop is not supported");
				            return;
				        }
				        
				        Desktop desktop = Desktop.getDesktop();
				        if(file.exists()) desktop.open(file);
				        
				        file = new File("F:\\java\\carrier counsceiling management system\\src\\center.xls");
				        if(file.exists()) desktop.open(file);
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(contentPane,e1);
					}
				}
			});
			btnShowReportOf.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnShowReportOf.setBounds(10, 167, 414, 39);
			contentPane.add(btnShowReportOf);
		/*	
			JButton btnShowReportOf_1 = new JButton("SHOW REPORT OF ITEMS WITH QUANTITY");
			btnShowReportOf_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					try
					{
						File file = new File("C:\\Industrial Project\\Return.xls");
				        
				        if(!Desktop.isDesktopSupported()){
				            System.out.println("Desktop is not supported");
				            return;
				        }
				        
				        Desktop desktop = Desktop.getDesktop();
				        if(file.exists()) desktop.open(file);
				        
				        file = new File("C:\\Industrial Project\\Return.xls");
				        if(file.exists()) desktop.open(file);
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(contentPane,e1);
					}
				
				
				}
			});
			btnShowReportOf_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnShowReportOf_1.setBounds(10, 217, 414, 39);
			contentPane.add(btnShowReportOf_1);
			*/
			JLabel lblNewLabel = new JLabel("Report Exportation and View");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(68, 11, 298, 33);
			contentPane.add(lblNewLabel);
			
			
		}
}
		
		
	