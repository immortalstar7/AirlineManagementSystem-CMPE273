package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Flight;
import model.FlightCustomerBean;
import model.FlightDetails;
import model.Staff;
import model.Utility;



public class ManagementService {
	Utility utility = new Utility();
	
	public String updateCustomerInfo(Customer customer ) 
	{
		Connection conn = DBOperation.getConnection();
		
			java.sql.PreparedStatement ps=null;	
			
				int count=0;
				StringBuffer stringBuffer = new StringBuffer("Update airline_management.customer c,airline_management.user u set ");
				
				if( customer.getF_name() != null)
				{  
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.f_name='"+customer.getF_name());
					stringBuffer.append("'");
				}
				if( customer.getL_name() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.l_name='"+customer.getL_name());	
					stringBuffer.append("'");
				}
				if( customer.getEmail() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.email='"+customer.getEmail());
					stringBuffer.append("'");
				}
				if( customer.getAddress() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.address='"+customer.getAddress());
					stringBuffer.append("'");
				}
				if( customer.getCity() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.city='"+customer.getCity());
					stringBuffer.append("'");
				}
				if( customer.getState() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.state='"+customer.getState());
					stringBuffer.append("'");
				}
				if( customer.getZipcode() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.zipcode='"+customer.getZipcode());	
					stringBuffer.append("'");
				}
				if( customer.getDob() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("u.dob='"+utility.convertStringToDate(customer.getDob()));
					stringBuffer.append("'");
				}
				if( customer.getNationality() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("c.nationality='"+customer.getNationality());
					stringBuffer.append("'");
				}
				if( customer.getPassport_no() != null){
					if(count > 0){
						stringBuffer.append(",");
					}
					count++;
					stringBuffer.append("c.passport_no='"+customer.getPassport_no());
					stringBuffer.append("'");
				}
				
				System.out.println("Update Customer query without where clause:: "+stringBuffer.toString());
				stringBuffer.append(" where u.user_id="+customer.getUser_id());
				stringBuffer.append(" and c.user_id="+customer.getUser_id());
				
				System.out.println("Final Update Customer Query:: "+stringBuffer.toString());
				String updateCustomerQuery = stringBuffer.toString();
				try {
					ps = conn.prepareStatement(updateCustomerQuery);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "Customer Information Updated Successfully";
			
			
		
	}
	public String deleteCustomer(int cust_Id )
	{
		Connection conn = DBOperation.getConnection();
		java.sql.PreparedStatement ps=null;		
		int a=0;
		try {
			ps = conn.prepareStatement("Delete from customer WHERE  user_id = ?");
		    ps.setInt(1,cust_Id);
			a=ps.executeUpdate();
			System.out.println("customer removed  "+a);	
			return "Customer Deleted Successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: Customer deletion unsuccessfull";
		}	
		
		
	}
	
	public Customer getCustomerInfo(int user_id )
	{
		Connection conn = DBOperation.getConnection();
		Statement stmt= null;
		Customer cust=new Customer();

		try {
			stmt = conn.createStatement();

			if(user_id != 0)
			{
				 
				String querry="SELECT u.user_id, u.f_name, u.l_name, u.password, u.email, u.address,u.city, u.state, u.zipcode, u.dob," +
						" c.nationality, c.customer_ssn, c.passport_no from user u, customer c where u.user_id=c.user_id and u.user_id="+user_id;
				try {
					ResultSet rs=stmt.executeQuery(querry);
					while(rs.next())
					{
						
						cust.setUser_id(rs.getInt("user_id"));
						System.out.println("after query"+rs.getInt("user_id"));
						cust.setF_name(rs.getString("f_name"));
						cust.setL_name(rs.getString("l_name")); 
			            cust.setPassword(rs.getString("password"));
			            cust.setEmail(rs.getString("email"));
			            cust.setAddress(rs.getString("address"));
			            cust.setCity(rs.getString("city"));
			            cust.setState(rs.getString("state"));
			            cust.setZipcode(rs.getString("zipcode"));
			            cust.setDob(rs.getString("dob"));
			            cust.setNationality(rs.getString("nationality"));
			            cust.setCustomer_ssn(rs.getInt("customer_ssn"));
			            cust.setPassport_no(rs.getString("passport_no"));
			            
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return cust;
			
	}
	
	
	public String updateFlightInfo( Flight flight ) 
	{
		
		Connection conn = DBOperation.getConnection();
			java.sql.PreparedStatement ps=null;	
			try
			{
				ps = conn.prepareStatement("UPDATE flight SET  flight_name = ?,no_of_seats=? WHERE flight_no = ?");
				ps.setString(1,flight.getFlight_name());
				ps.setInt(2,flight.getNo_of_seats());
				ps.setString(3,flight.getFlight_no());
				int a=ps.executeUpdate();
				System.out.println("updatted the flight information "+a);
				return "Flight Updated Successfully";
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Error: Flight updation unsuccessfull";
			}
	}
	
	public String deleteFlight(String flight_Num )
	{
		Connection conn = DBOperation.getConnection();
		java.sql.PreparedStatement ps=null;		
		int a=0;
		try {
			ps = conn.prepareStatement("Delete from flight WHERE  flight_no = ?");
		    ps.setString(1,flight_Num);
			a=ps.executeUpdate();
			System.out.println("Flight removed  "+a);
			return "Flight Deleted Successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: Flight deletion unsuccessfull";
		}
		
	}
	
	
	public FlightDetails getFlightInfo(String flight_Num )
	{	
		 FlightDetails flightDetails = new FlightDetails();
		try {
			Connection conn = DBOperation.getConnection();
			Statement stmt= conn.createStatement();
			if(!flight_Num.isEmpty())
			{
				String querry="Select f.flight_no, f.flight_name, f.no_of_seats, sf.flight_date, sf.source, sf.destination, sf.avail_seats, sf.crew_id from flight f, schedule_flight sf where f.flight_no = sf.fight_no and flight_no LIKE '"+flight_Num+"' )";
			
				ResultSet rs=stmt.executeQuery(querry);
				while(rs.next())
				{
					flightDetails.setFlight_no(rs.getString("flight_no"));
					flightDetails.setFlight_name(rs.getString("flight_name"));
					flightDetails.setNo_of_seats(rs.getInt("no_of_seats")); 
			        flightDetails.setFlight_date(rs.getString("flight_date"));
			        flightDetails.setSource(rs.getString("source"));
			        flightDetails.setDestination(rs.getString("destination"));
			        flightDetails.setAvail_seats(rs.getString("avail_seats"));
			        flightDetails.setCrew_id(rs.getInt("crew_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightDetails;
		
	}
	
	
	public String updateStaffInfo(Staff staff)
	{
		Connection conn = DBOperation.getConnection();
		System.out.println("Inside");
		java.sql.PreparedStatement ps=null;	
		
			int count=0;
			StringBuffer stringBuffer = new StringBuffer("Update airline_management.staff s,airline_management.user u set ");
			
			if( staff.getF_name() != null)
			{  
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.f_name='"+staff.getF_name());
				stringBuffer.append("'");
			}
			if( staff.getL_name() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.l_name='"+staff.getL_name());	
				stringBuffer.append("'");
			}
			if( staff.getEmail() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.email='"+staff.getEmail());
				stringBuffer.append("'");
			}
			if( staff.getAddress() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.address='"+staff.getAddress());
				stringBuffer.append("'");
			}
			if( staff.getCity() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.city='"+staff.getCity());
				stringBuffer.append("'");
			}
			if( staff.getState() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.state='"+staff.getState());
				stringBuffer.append("'");
			}
			if( staff.getZipcode() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.zipcode='"+staff.getZipcode());	
				stringBuffer.append("'");
			}
			if( staff.getDob() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("u.dob='"+utility.convertStringToDate(staff.getDob()));
				stringBuffer.append("'");
			}
			if( staff.getWork_desc() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("s.work_desc='"+staff.getWork_desc());
				stringBuffer.append("'");
			}
			if( staff.getPosition() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("s.position='"+ staff.getPosition());
				stringBuffer.append("'");
			}
			if( staff.getHire_date() != null){
				if(count > 0){
					stringBuffer.append(",");
				}
				count++;
				stringBuffer.append("s.hire_date='"+ utility.convertStringToDate((staff.getHire_date())));
				stringBuffer.append("'");
			}
			
			System.out.println("Update Staff query without where clause:: "+stringBuffer.toString());
			stringBuffer.append(" where u.user_id="+staff.getUser_id());
			stringBuffer.append(" and s.user_id="+staff.getUser_id());
			
			System.out.println("Final Update Staff Query:: "+stringBuffer.toString());
			String updateStaffQuery = stringBuffer.toString();
			try {
				ps = conn.prepareStatement(updateStaffQuery);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "Staff Information Updated Successfully";
		
		
	}
	
	
	public String deleteStaff(int staff_Id )
	{
		Connection conn = DBOperation.getConnection();
		java.sql.PreparedStatement ps=null;		
		int a=0;
		try {
			ps = conn.prepareStatement("Delete from staff WHERE  user_id = ?");
		    ps.setInt(1,staff_Id);
			a=ps.executeUpdate();
			System.out.println("staff removed  "+a);	
			return "Staff Deleted Successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: Staff deletion unsuccessfull";
		}	
		
	}
	
	
	public Staff getStaffInfo(int user_id ) 
	{
		Connection conn = DBOperation.getConnection();
		Statement stmt= null;
		Staff staff = new Staff();

		try {
			stmt = conn.createStatement();

			if(user_id != 0)
			{
				 
				String querry="SELECT u.user_id, u.f_name, u.l_name, u.password, u.email, u.address,u.city, u.state, u.zipcode, u.dob," +
						" s.work_desc, s.staff_ssn, s.position,s.hire_date from user u, staff s where u.user_id=s.user_id and u.user_id="+user_id;
				try {
					ResultSet rs=stmt.executeQuery(querry);
					while(rs.next())
					{
						
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
						staff.setWork_desc(rs.getString("work_desc"));
						staff.setStaff_ssn(rs.getInt("staff_ssn"));
						staff.setPosition(rs.getString("position"));
						staff.setHire_date(rs.getString("hire_date"));
			            
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return staff;
		
	}
	

	public List<FlightCustomerBean>  listFlightAndCustomer(String flight_Num )
	{
		List<FlightCustomerBean> flightCustomerList = new ArrayList<FlightCustomerBean>();
		try {
			System.out.println("Inside function : "+flight_Num);
			Connection conn = DBOperation.getConnection();
			Statement stmt = conn.createStatement();
			if (!flight_Num.isEmpty()) {
				String query = "Select b.flight_no, u.l_name, u.f_name from booking b, user u where b.user_id = u.user_id and b.flight_no ='"
						+ flight_Num + "' ";
                System.out.println("Query: " +query);
				ResultSet rs = stmt.executeQuery(query);
						
				while (rs.next()) {
					FlightCustomerBean flightCustomerBean = new FlightCustomerBean(); 
					flightCustomerBean.setFlight_no(rs.getString("flight_no"));
					flightCustomerBean.setF_name(rs.getString("f_name"));
					flightCustomerBean.setL_name(rs.getString("l_name"));
					flightCustomerList.add(flightCustomerBean);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightCustomerList;
	}
}
