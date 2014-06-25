package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Staff;
import model.StaffMessageBean;
import model.Utility;



public class StaffService {
	DBOperation dbOperation;
	Utility utility = new Utility();
	private static final String INSERT_USER_QUERY = "insert into user (f_name,l_name,password,email,address,city,state," +
													"zipcode,dob,type) values ('";
	
	private static final String INSERT_STAFF_QUERY = "insert into staff (user_id,staff_ssn,work_desc,position,hire_date) values ('";
	private static final String RETRIEVE_ALL_STAFF_QUERY = "SELECT 	u.user_id, u.f_name, u.l_name, u.password, u.email, u.address, u.city, u.state, u.zipcode, u.dob, s.staff_ssn, s.work_desc, s.position, s.hire_date from user u, staff s where u.user_id = s.user_id"; 
	
	public StaffService() {
		// TODO Auto-generated constructor stub
		dbOperation = new DBOperation();
	}
	
	public StaffMessageBean addStaff(Staff staff){
		StaffMessageBean staffMessageBean = new StaffMessageBean();
		String insertUserQuery = generateUserInsertQuery(staff);
		try {
				//insert into User Table
				int user_id = dbOperation.executeUpdateQuery(insertUserQuery);
				System.out.println("User Id of newly added staff:: "+user_id);
				//insert into Staff Table
				insertIntoStaffTable(user_id,staff);
				//Set the return values
				staffMessageBean.setUser_id(user_id);
				staffMessageBean.setStaff(staff);
				staffMessageBean.setMessage("New Staff "+staff.getF_name()+" "+staff.getL_name()+" Added Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			staffMessageBean.setMessage("Error in adding New Staff!! ");
			e.printStackTrace();
		}
		
		return staffMessageBean;
		
	}
	
public String generateUserInsertQuery(Staff staff){

	
		StringBuffer strQuery = new StringBuffer(INSERT_USER_QUERY);
		strQuery.append(staff.getF_name());
		strQuery.append("', '");
		strQuery.append(staff.getL_name());
		strQuery.append("', '");		
		strQuery.append(staff.getPassword());
		strQuery.append("', '");
		strQuery.append(staff.getEmail());
		strQuery.append("', '");
		strQuery.append(staff.getAddress());
		strQuery.append("', '");
		strQuery.append(staff.getCity());
		strQuery.append("', '");
		strQuery.append(staff.getState());
		strQuery.append("', '");
		strQuery.append(staff.getZipcode());
		strQuery.append("', '");
		strQuery.append(utility.convertStringToDate(staff.getDob()));
		strQuery.append("', '");		
		strQuery.append(staff.getType());
		strQuery.append("')");
		
		System.out.println("Insert User query : "+strQuery.toString());
		
		return strQuery.toString();

	}

	public void insertIntoStaffTable(int user_id,Staff staff){
		
		StringBuffer strQuery = new StringBuffer(INSERT_STAFF_QUERY);
		strQuery.append(user_id);
		strQuery.append("', '");
		strQuery.append(staff.getStaff_ssn());
		strQuery.append("', '");		
		strQuery.append(staff.getWork_desc());
		strQuery.append("', '");
		strQuery.append(staff.getPosition());
		strQuery.append("', '");
		strQuery.append(utility.convertStringToDate(staff.getHire_date()));
		strQuery.append("')");
		System.out.println("Insert Staff query : "+strQuery.toString());
		
		try {
			DBOperation.executeQuery(strQuery.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Staff> getStaffDetails(){
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			//insert into User Table
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 1");
			String staffdetailsQuery = RETRIEVE_ALL_STAFF_QUERY;
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 2");
			staffList = executestaffdetailsQuery(staffdetailsQuery);
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 3");
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//customeressageBean.setMessage("Error in adding New Customer!! ");
		e.printStackTrace();
	}
	
	return staffList;
		
	}
	
public static List<Staff> executestaffdetailsQuery(String querystr) throws Exception{
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs;
		List<Staff> staffList = new ArrayList<Staff>();
		try{
			conn = DBOperation.getConnection();
			stmt = conn.createStatement();
			//System.out.println("before execute");
			rs = stmt.executeQuery(querystr);
			//System.out.println("after execute");
			//stmt  = conn.createStatement();
			//rs.absolute(2);
			while(rs.next())
	        {
				System.out.println("before query");
	            Staff staff = new Staff();
				staff.setUser_id(rs.getInt("user_id"));
				System.out.println("after query"+rs.getInt("user_id"));
				staff.setF_name(rs.getString("f_name"));
				staff.setL_name(rs.getString("l_name")); 
	            staff.setPassword(rs.getString("password"));
	            staff.setEmail(rs.getString("email"));
	            staff.setAddress(rs.getString("address"));
	            staff.setCity(rs.getString("city"));
	            staff.setState(rs.getString("state"));
	            staff.setZipcode(rs.getString("zipcode"));
	            staff.setDob(rs.getString("dob"));
	            staff.setStaff_ssn(rs.getInt("staff_ssn"));
	            staff.setWork_desc(rs.getString("work_desc"));
	            staff.setPosition(rs.getString("position"));
	            staff.setHire_date(rs.getString("hire_date"));
	            //staff.setWork_desc(rs.getString("work_desc"));

	            staffList.add(staff);
			}
		}catch (Exception e){
			System.out.println("unable to execute customer details query" + querystr);
		}
		System.out.println("List length:: "+staffList.size());
		return staffList;
	}


	
	
}
