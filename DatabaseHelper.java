import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



import java.awt.print.*;
import net.proteanit.sql.DbUtils;
import xlsgen.XlsEngine;
import xlsgen.XlsWorkbook;
import xlsgen.XlsWorksheet;

public class DatabaseHelper {
	
	Connection con = null;
	
	DatabaseHelper()
	{
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
	}
	
	public void addCourse(String[] data)
	{
		try {
		String query = "insert into Course_Center_Info values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(query);
		prs.setString(1, data[0]);
		prs.setString(2, data[1]);
		prs.setString(3, data[2]);
		prs.setInt(4, Integer.parseInt(data[3]));
		prs.setInt(5, Integer.parseInt(data[4]));
		prs.setString(6, data[5]);
		prs.setInt(7, Integer.parseInt(data[6]));
		prs.setString(8, data[7]);
		prs.setString(9, data[8]);
		prs.setString(10, data[9]);
		prs.executeUpdate();
		JOptionPane.showMessageDialog(null,"Record Saved....");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
	}
	
	public void addStudent(String data[])
	{
		try {
			String query = "insert into Student_Register values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1,data[0]);
			prs.setString(2, data[1]);
			prs.setInt(3, Integer.parseInt(data[2]));
			prs.setString(4, data[3]);
			prs.setString(5, data[4]);
			prs.setInt(6, Integer.parseInt(data[5]));
			prs.setString(7, data[6]);
			prs.setString(8, data[7]);
			prs.setString(9, data[8]);
			prs.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Saved....");
			}
			catch(Exception e)
			{
			System.out.println("Exception occured. Message = "+e.toString());
			}	
	}
	
	public void addStaff(String[] data)
	{
		try {
		String query = "insert into Staff_Info values(?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(query);
		prs.setString(1, data[0]);
		prs.setString(2, data[1]);
		prs.setInt(3, Integer.parseInt(data[2]));
		prs.setString(4, data[3]);
		prs.setString(5, data[4]);
		prs.setString(6, data[5]);
		prs.executeUpdate();
		JOptionPane.showMessageDialog(null,"Record Saved....");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
	}
	
	public void addCareer(String[] data)
	{
		try {
		String query = "insert into Career_Recommendation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(query);
		prs.setString(1, data[0]);
		prs.setString(2, data[1]);
		prs.setString(3, data[2]);
		prs.setString(4,(data[3]));
		prs.setString(5, (data[4]));
		prs.setString(6, data[5]);
		prs.setString(7, (data[6]));
		prs.setString(8, data[7]);
		prs.setString(9, data[8]);
		prs.setString(10, data[9]);
		prs.setString(11, data[10]);
		prs.setString(12, data[11]);
		prs.setString(13, data[12]);
		prs.setString(14, data[13]);
		prs.setString(15, data[14]);
		prs.setString(16, data[15]);
		prs.setString(17, data[16]);
		prs.setString(18, data[17]);
		prs.executeUpdate();
		JOptionPane.showMessageDialog(null,"Record Saved....");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
	}
	
	
	public Vector<String> getCourseIDS_ALL() {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select ID from Course_Center_Info");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				data.add(dataset.getString("ID"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}

	public Vector<String> getStaffIDS_ALL() {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select Staff_No from Staff_Info");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				data.add(dataset.getString("Staff_No"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}

	public Vector<String> getCourseInfo_SELECTED(String Course_ID) {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Center_Info where ID='"+Course_ID+"'");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				for(int i = 1 ; i <= 10 ; i++) {
					data.add(dataset.getString(i));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}
	
	public Vector<String> getEligibilityCourseInfo_SELECTED(String Course_ID) {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Eligibility_1 where Course_No='"+Course_ID+"'");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				for(int i = 1 ; i <= 3 ; i++) {
					data.add(dataset.getString(i));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}
		
	
	
	public Vector<String> getCourseEligibleInfo_SELECTED(String Course_ID) {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Eligibility_1 where Course_No='"+Course_ID+"'");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				for(int i = 2 ; i <= 3 ; i++) {
					data.add(dataset.getString(i));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}
	
	public Vector<String> getStaffInfo_SELECTED(String Staff_ID) {
		Vector<String> data =  new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Staff_Info where Staff_No='"+Staff_ID+"'");
			ResultSet dataset = prs.executeQuery();
			while(dataset.next()) {
				for(int i = 1 ; i <= 6 ; i++) {
					System.out.println("Item Got = "+dataset.getString(i));
					data.add(dataset.getString(i));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return data;
	}
	
	public boolean updateCourseInfo(String[] data)
	{
		int checker = 0;
		try {
			String query = "update Course_Center_Info "
					+ "set Name=? , "
					+ "Address=? , "
					+ "Staff_Strength=? , "
					+ "Incharge_No=? , "
					+ "Incharge_Name=? , "
					+ "Pincode=? , "
					+ "Telephone=? , "
					+ "Email=? , "
					+ "Mobile_no=? "
					+ "where ID=? ";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1, data[1]);
			prs.setString(2, data[2]);
			prs.setInt(3, Integer.parseInt(data[3]));
			prs.setInt(4, Integer.parseInt(data[4]));
			prs.setString(5, data[5]);
			prs.setInt(6, Integer.parseInt(data[6]));
			prs.setString(7, data[7]);
			prs.setString(8, data[8]);
			prs.setString(9, data[9]);
			prs.setString(10, data[0]);
			checker = prs.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Updated....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
		if(checker==1)
			return true;
		else
			return false;
	}

	public boolean updateStaffInfo(String[] data)
	{
		int checker = 0;
		try {
			String query = "update Staff_Info "
					+ "set Name=? , "
					+ "Age=? , "
					+ "Designation=? , "
					+ "Mobile_No=? , "
					+ "Email=? "
					+ "where Staff_No=?";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1, data[1]);
			prs.setInt(2, Integer.parseInt(data[2]));
			prs.setString(3, data[3]);
			prs.setString(4, data[4]);
			prs.setString(5, data[5]);
			prs.setString(6, data[0]);
	
			checker = prs.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Updated....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
		if(checker==1)
			return true;
		else
			return false;
	}
	
	public boolean deleteCourse(String iD) {
		boolean checker=false;
		try {
			PreparedStatement prs = con.prepareStatement("delete from Course_Center_Info where ID='"+iD+"'");
			JOptionPane.showMessageDialog(null,"Record Deleted....");
			if(prs.executeUpdate()==1) {
				checker=true; // IF ROW DELETED
			}
			else {
				checker=false; // IF ROW NOT DELETED
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return checker;
		
	}
	
	public boolean deleteCareer(String iD) {
		boolean checker=false;
		try {
			PreparedStatement prs = con.prepareStatement("delete from Career_Recommendation where Session_No ='"+iD+"'");
			JOptionPane.showMessageDialog(null,"Record Deleted....");
			if(prs.executeUpdate()==1) {
				checker=true; // IF ROW DELETED
			}
			else {
				checker=false; // IF ROW NOT DELETED
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return checker;
		
	}

	public TreeMap<String,Object> getEligibleCourses(String string) {
		// TODO Auto-generated method stub
		
		TreeMap<String,Object> mykeyvaluepair = new TreeMap<String,Object>();
		Vector<String> eligiblecoursenos = new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Eligibility_2 where Course_No='"+string.trim()+"'");
			ResultSet data = prs.executeQuery();
			while(data.next())
			{
				eligiblecoursenos.add(data.getString(2));
				System.out.println(data.getString(2));
			}
			
			for(int i = 0 ; i < eligiblecoursenos.size() ; i++)
			{
				System.out.println("Processing Loop For "+eligiblecoursenos.get(i));
				prs = con.prepareStatement("select * from Course_Eligibility_1 where Course_No='"+eligiblecoursenos.get(i).trim()+"'");
				data = prs.executeQuery();
				while(data.next())
				{
					System.out.println("Got Value = "+data.getString(2));
					mykeyvaluepair.put(data.getString(1), data.getString(2));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		// TODO Auto-generated method stub
		return mykeyvaluepair;
	}


	public String getNewStudentNumber() {
		// TODO Auto-generated method stub
		String student_no="SN00001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(Student_No) AS Student_No from Student_Register");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("Student_No");
				str = str.substring(2);
				str = "SN"+String.format("%05d",Integer.parseInt(str)+1);
				student_no=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return student_no;
	}
	
	public String getNewCenterNumber() {
		
		
		String Center_No="CC00001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(ID) AS ID from Course_Center_Info");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("ID");
				str = str.substring(2);
				str = "CC"+String.format("%05d",Integer.parseInt(str)+1);
				Center_No=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return Center_No;
	}
	
public String getNewSessionNumber() {
		
		
		String session_No="CR00001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(Session_No) AS Session_No from Career_Recommendation");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("Session_No");
				str = str.substring(2);
				str = "CR"+String.format("%05d",Integer.parseInt(str)+1);
				session_No=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return session_No;
	}
	
	public String getNewCourseNumber() {
		
		
		String Course_No="CC0001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(ID) AS ID from Course_Center_Info");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("ID");
				str = str.substring(2);
				str = "CC"+String.format("%05d",Integer.parseInt(str)+1);
				Course_No=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return Course_No;
	}

	public ResultSet getCourses() {
		// TODO Auto-generated method stub
		ResultSet data = null;
		try {
			PreparedStatement prs = con.prepareStatement("select distinct(Current_Qualification) as Current_Qualification from Course_Eligibility");
			data = prs.executeQuery();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return data;
	}

	public Vector getCourseEligibilityNumbers() {
		Vector data = new Vector();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Eligibility_1");
			ResultSet resultSet = prs.executeQuery();
			
			while(resultSet.next()) {
				String str = resultSet.getString("Course_No")+" - "+resultSet.getString("Name");
				data.add(str);
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}	
		return data;
	}
		
	public String getNewCourseEligibilityNumber() {
		String Course_No="CO0001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(Course_No) AS Course_No from Course_Eligibility_1");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("Course_No");
				str = str.substring(2);
				str = "CO"+String.format("%05d",Integer.parseInt(str)+1);
				Course_No=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return Course_No;
	}

	public void addNewCourseEligibility(String courseno, String coursename, String duration, String c1, String c2, String c3) {
		// TODO Auto-generated method stub
		try {
			String query = "insert into Course_Eligibility_1 values(?,?,?)";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1, courseno);
			prs.setString(2, coursename);
			prs.setInt(3, Integer.parseInt(duration.trim()));
			prs.executeUpdate();
			if(!c1.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, c1.split("-")[0]);
				prs.executeUpdate();
			}
			if(!c2.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, c2.split("-")[0]);
				prs.executeUpdate();
			}
			if(!c3.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, c3.split("-")[0]);
				prs.executeUpdate();				
			}
			JOptionPane.showMessageDialog(null,"Record Saved....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}	
	}

	public ArrayList<String> getStudentID_All() {
		// TODO Auto-generated method stub
		ArrayList<String> data = new ArrayList<>();
		try {
			PreparedStatement prs = con.prepareStatement("select Student_No from Student_Register");
			ResultSet resultSet = prs.executeQuery();
			
			while(resultSet.next()) {
				String str = resultSet.getString("Student_No");
				data.add(str);
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}	
		return data;
	}

	public boolean deleteStudent(String iD) {
		// TODO Auto-generated method stub
		boolean checker=false;
		try {
			PreparedStatement prs = con.prepareStatement("delete from Student_Register where Student_No='"+iD+"'");
			JOptionPane.showMessageDialog(null,"Record Deleted....");
			if(prs.executeUpdate()==1) {
				checker=true; // IF ROW DELETED
			}
			else {
				checker=false; // IF ROW NOT DELETED
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return checker;
	}

	public boolean deleteStaff(String iD) {
		boolean checker=false;
		try {
			PreparedStatement prs = con.prepareStatement("delete from Staff_Info where Staff_No='"+iD+"'");
			JOptionPane.showMessageDialog(null,"Record Deleted....");
			if(prs.executeUpdate()==1) {
				checker=true; // IF ROW DELETED
			}
			else {
				checker=false; // IF ROW NOT DELETED
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return checker;
		
	}
	
	public ArrayList<String> getStudentInfo(String iD) {
		// TODO Auto-generated method stub
		ArrayList<String> data = new ArrayList<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Student_Register where Student_No='"+iD+"'");
			ResultSet rs = prs.executeQuery();
			while(rs.next()) {
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				data.add(rs.getString(5));
				data.add(rs.getString(6));
				data.add(rs.getString(7));
				data.add(rs.getString(8));
				data.add(rs.getString(9));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return data;
	}

	public void updateStudentInfo(String[] data) {
		// TODO Auto-generated method stub
		try {
			String query = "update Student_Register "					
					+ "set name=? , "
					+ "age=? , "
					+ "bdate=? , "
					+ "Passed_Q=? , "
					+ "Percentage=? , "
					+ "Email=? , "
					+ "Mobile_No=? "
					+ "where Student_No=? ";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1, data[1]);
			prs.setInt(2, Integer.parseInt(data[2]));
			prs.setString(3, data[3]);
			prs.setString(4, data[4]);
			prs.setString(5, data[5]);
			prs.setString(6, data[6]);
			prs.setString(7, data[7]);
			prs.setString(8, data[0]);
			prs.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Updated....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
	}

	public String getNewStaffNumber() {
		// TODO Auto-generated method stub
		String newnumber = "SF00001";
		try {
			PreparedStatement prs = con.prepareStatement("select MAX(Staff_No) AS Staff_No from Staff_Info");
			ResultSet resultSet = prs.executeQuery();
			while(resultSet.next()) {
				String str = resultSet.getString("Staff_No");
				str = str.substring(2);
				str = "SF"+String.format("%05d",Integer.parseInt(str)+1);
				newnumber=str;
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}

		return newnumber;
	}

	public void deleteCourseEligibility_Selected(String string) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prs = con.prepareStatement("delete from Course_Eligibility_1 where Course_no = '"+string+"'");
			prs.executeUpdate();
			prs = con.prepareStatement("delete from Course_Eligibility_2 where Course_no = '"+string+"'");
			prs.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
	}

	public void updateEligibleCourseInfo(String courseno, String coursename, String duration, String eligible1, String eligible2,
			String eligible3) {
		// TODO Auto-generated method stub
		try {
			
			String query = "update Course_Eligibility_1 set Name=? , Duration=? where Course_No=?";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(3, courseno);
			prs.setString(1, coursename);
			prs.setInt(2, Integer.parseInt(duration.trim()));
			prs.executeUpdate();
			prs = con.prepareStatement("delete from Course_Eligibility_2 where Course_no='"+courseno+"'");
			prs.executeUpdate();
			if(!eligible1.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, eligible1.split("-")[0]);
				prs.executeUpdate();
			}
			if(!eligible2.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, eligible2.split("-")[0]);
				prs.executeUpdate();
			}
			if(!eligible3.equalsIgnoreCase("---Select---")) {
				query = "insert into Course_Eligibility_2 values(?,?)";
				prs = con.prepareStatement(query);
				prs.setString(1, courseno);
				prs.setString(2, eligible3.split("-")[0]);
				prs.executeUpdate();				
			}
			
			JOptionPane.showMessageDialog(null,"Record Saved....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
		
	}

	public Vector<Vector<Object>> getFurtherCoursesInfo_ForSelectedCourse(String courseno) {
		// TODO Auto-generated method stub
		Vector<Vector<Object>> data = new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Eligibility where Current_Qualification = '"+courseno+"'");
			ResultSet rs = prs.executeQuery();
			while(rs.next())
			{
				Vector<Object> currentItem = new Vector<>();
				currentItem.add(rs.getString(2));
				currentItem.add(rs.getString(3));
				currentItem.add(rs.getString(4));
				currentItem.add(false);
				data.add(currentItem);
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return data;
	}

	public Vector<Vector<Object>> getCourseBasedClg(String string) {
		// TODO Auto-generated method stub
		Vector<Vector<Object>> data = new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select * from Course_Based_Clg where Course_No = '"+string+"'");
			ResultSet rs = prs.executeQuery();
			while(rs.next())
			{
				System.out.println("Rows Found");
				Vector<Object> currentItem = new Vector<>();
				currentItem.add(rs.getString(1));
				currentItem.add(rs.getString(2));
				currentItem.add(rs.getString(3));
				currentItem.add(rs.getString(4));
				currentItem.add(rs.getString(5));
				currentItem.add(rs.getString(6));
				currentItem.add(rs.getString(7));
				currentItem.add(rs.getString(8));
				data.add(currentItem);
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return data;
	}

	public Vector<String> getCareerIDS() {
		// TODO Auto-generated method stub
		Vector<String> data = new Vector<>();
		try {
			PreparedStatement prs = con.prepareStatement("select Session_No from Career_Recommendation");
			ResultSet rs = prs.executeQuery();
			while(rs.next())
			{
				data.add(rs.getString(1));
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		return data;
	}

	public String[] getCareerInfo_Selected(String sessionNo) {
		// TODO Auto-generated method stub
		String[] data = new String[18];
		
		try {
			PreparedStatement prs = con.prepareStatement("select * from Career_Recommendation where Session_No='"+sessionNo+"'");
			ResultSet rs = prs.executeQuery();
			while(rs.next())
			{
				for(int i = 0 ; i < 18 ; i++) {
					data[i] = rs.getString(i+1);
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Exception occured. Message = "+e.toString());
		}
		
		return data;
	}

	public void updateCareer(String[] data) {
		// TODO Auto-generated method stub
		try {
			String query = "update table Career_Recommendation "
					+ "set Session_Date=?"
					+ "Center_No=?"
					+ "Center_Name=?"
					+ "Center_Address=?"
					+ "Student_No=?"
					+ "Student_Name=?"
					+ "Student_Mobile=?"
					+ "Student_Address=?"
					+ "Staff_ID=?"
					+ "Staff_Name=?"
					+ "Staff_Designation=?"
					+ "Eligibility_Course_No=?"
					+ "Course_Name=?"
					+ "Duration=?"
					+ "Course_No_Selected=?"
					+ "Institute_Nos=?"
					+ "where Session_No=?";
			PreparedStatement prs = con.prepareStatement(query);
			prs.setString(1, data[1]);
			prs.setString(2, data[2]);
			prs.setString(3, data[3]);
			prs.setString(4,(data[4]));
			prs.setString(5, (data[5]));
			prs.setString(6, data[6]);
			prs.setString(7, (data[7]));
			prs.setString(8, data[8]);
			prs.setString(9, data[9]);
			prs.setString(10, data[10]);
			prs.setString(11, data[11]);
			prs.setString(12, data[12]);
			prs.setString(13, data[13]);
			prs.setString(14, data[14]);
			prs.setString(15, data[15]);
			prs.setString(16, data[16]);
			prs.setString(17, data[17]);
			prs.setString(18, data[0]);
			prs.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record Saved....");
			}
			catch(Exception e)
			{
				System.out.println("Exception occured. Message = "+e.toString());
			}
	}

	 void exportCourseCenterInfoTable() {
		// TODO Auto-generated method stub
		 try {
				String query = "select * from Course_Center_Info";
				PreparedStatement prs = con.prepareStatement(query);
				ResultSet rs = prs.executeQuery();
				
				//t.setModel(DbUtils.resultSetToTableModel(rs));
				
				String[] header = new String[10];
				
				Workbook workbook = new HSSFWorkbook();
                Cell c = null;
                Row row = null;
                CellStyle cs = workbook.createCellStyle();
                cs.setFillBackgroundColor(HSSFColor.LIME.index);
                cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                Sheet sheet1 = workbook.createSheet("MySheet");
                
                row = sheet1.createRow(0);
                c=row.createCell(0);
                c.setCellValue("ID");
                 
                c=row.createCell(1);
                c.setCellValue("Name");
                
                c=row.createCell(2);
                c.setCellValue("Address");
                
                c=row.createCell(3);
                c.setCellValue("Staff_Strength");
                
                
                c=row.createCell(4);
                c.setCellValue("Incharge_No");               
                
                c=row.createCell(5);
                c.setCellValue("Incharge_Name");               
                
                c=row.createCell(6);
                c.setCellValue("Pincode");               
               
                c=row.createCell(7);
                c.setCellValue("Telephone");              
               
                c=row.createCell(8);
                c.setCellValue("Email");
                
                c=row.createCell(9);
                c.setCellValue("Mobile_Number");
               
               
                         
                int n = 1;
                while(rs.next())
                {
                	String[] data = new String[10]; 
                	row = sheet1.createRow(n);
                	for(int j = 0 ; j <10 ; j++ )
                	{
                		data[j] = rs.getString(j+1);
                        c=row.createCell(j);
                        c.setCellValue(rs.getString(j+1).toString());
                	}
                
                	n++;
                	
                }
                
                FileOutputStream os = null;               
                File file = new File("CourseCenterInfo.xls");               
                try {
                    os = new FileOutputStream(file);
                    workbook.write(os);
                    
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Report2.rpt");
                    
                    //XlsEngine engine = new XlsEngine("F:\\java\\carrier counseling management system\\src\\xlsgen.dll");
                    
                    //XlsWorkbook wbk = engine.Open("CourseCenterInfo.xls","");
                    //XlsWorksheet wksht = wbk.getWorksheetByIndex(1);
                    //wksht.PrintWith("PDFPrinter","CourseCenterInfo.pdf");
                } catch (Exception e) {
                	e.printStackTrace();
                } finally {
                    try {
                        if (null != os)
                        os.close();
                    } catch (Exception ex) {
                    }
                }
             
		 		}
				catch(Exception e)
				{
					System.out.println("Exception occured. Message = "+e.toString());
				}
	}
}
