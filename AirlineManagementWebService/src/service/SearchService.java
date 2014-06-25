package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Flight;
import model.FlightDetails;
import model.Staff;
import model.Utility;

public class SearchService 
{
	
	Utility utility = new Utility();
	
	
	
	public List<Staff> searchStaff(Staff staff)
	{
		Connection conn = DBOperation.getConnection();
		Statement stmt= null;
		List<Staff> stafflist = new ArrayList<Staff>();
				
		
		try {
				stmt = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int count=0;
			System.out.println("in side search");
			
			try {
				stmt = conn.createStatement();
					StringBuffer stringBuffer=new StringBuffer("SELECT u.user_id, u.f_name, u.l_name,u.email, u.address,u.city, u.state, u.zipcode, u.dob," +
							" s.staff_ssn, s.work_desc, s.position, s.hire_date from airline_management.user u, airline_management.staff s where u.user_id=s.user_id");
					
					if(!staff.getF_name().isEmpty())
					{  
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.f_name='"+staff.getF_name()+"'");
					}
					if(!staff.getL_name().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.l_name='"+staff.getL_name()+"'");	
					}
					if(!staff.getEmail().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.email='"+staff.getEmail()+"'");
					}
					if(!staff.getAddress().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.address='"+staff.getAddress()+"'");
					}
					if(!staff.getCity().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.city='"+staff.getCity()+"'");
					}
					if(!staff.getState().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.state='"+staff.getState()+"'");
					}
					if(!staff.getZipcode().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.zipcode='"+staff.getZipcode()+"'");	
					}
					if(!staff.getDob().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.dob='"+utility.convertStringToDate(staff.getDob())+"'");
					}					
										
					if(staff.getStaff_ssn() != 0){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("s.staff_ssn='"+staff.getStaff_ssn()+ "'");	
					}	
					if(!staff.getPosition().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("s.position='"+staff.getPosition()+ "'");	
					}
					if(!staff.getWork_desc().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("s.work_desc='"+staff.getWork_desc()+"'");	
					}
					if(!staff.getHire_date().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("s.hire_date='"+utility.convertStringToDate(staff.getHire_date())+"'");						
					}				
					
					System.out.println("Final Staff Search Query:: "+stringBuffer.toString());
					String searchStaffQuery = stringBuffer.toString();
					
					
					try {
						ResultSet rs=stmt.executeQuery(searchStaffQuery);
						while(rs.next())
						{
							Staff s=new Staff();
							s.setUser_id(rs.getInt("user_id"));
							System.out.println("after query"+rs.getInt("user_id"));
							s.setF_name(rs.getString("f_name"));
							s.setL_name(rs.getString("l_name")); 
							s.setEmail(rs.getString("email"));
							s.setAddress(rs.getString("address"));
							s.setCity(rs.getString("city"));
							s.setState(rs.getString("state"));
							s.setZipcode(rs.getString("zipcode"));
							s.setDob(rs.getString("dob"));
							s.setStaff_ssn(rs.getInt("staff_ssn"));
							s.setPosition(rs.getString("position"));
							s.setHire_date(rs.getString("hire_date"));
							s.setWork_desc(rs.getString("work_desc"));
				            stafflist.add(s);
						}
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return stafflist;
			
	}
	
	
	public List<Customer> searchCustomer(Customer customer)
	{
		Connection conn = DBOperation.getConnection();
		Statement stmt= null;
		List<Customer> customerlist = new ArrayList<Customer>();
				
		
		try {
				stmt = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int count=0;
			System.out.println("in side search");
			
			try {
				stmt = conn.createStatement();
					 
					StringBuffer stringBuffer=new StringBuffer("SELECT u.user_id, u.f_name, u.l_name,u.email, u.address,u.city, u.state, u.zipcode, u.dob," +
							" c.nationality, c.customer_ssn, c.passport_no from airline_management.user u, airline_management.customer c where u.user_id=c.user_id");
					
					if(!customer.getF_name().isEmpty())
					{  
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.f_name='"+customer.getF_name()+"'");
					}
					if(!customer.getL_name().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.l_name='"+customer.getL_name()+"'");	
					}
					if(!customer.getEmail().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.email='"+customer.getEmail()+"'");
					}
					if(!customer.getAddress().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.address='"+customer.getAddress()+"'");
					}
					if(!customer.getCity().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.city='"+customer.getCity()+"'");
					}
					if(!customer.getState().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.state='"+customer.getState()+"'");
					}
					if(!customer.getZipcode().isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("u.zipcode='"+customer.getZipcode()+"'");	
					}
					if(!customer.getDob().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("u.dob='"+utility.convertStringToDate(customer.getDob())+"'");
					}					
										
					if(!customer.getPassport_no().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("c.passport_no='"+customer.getPassport_no()+"'");	
					}						
					if(!customer.getNationality().isEmpty()){
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("c.nationality='"+customer.getNationality()+"'");	
					}
					if(customer.getCustomer_ssn() != 0){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("c.customer_ssn='"+customer.getCustomer_ssn()+"'");						
					}				
					
					System.out.println("Final Customer Search Query:: "+stringBuffer.toString());
					String searchCustomerQuery = stringBuffer.toString();
					
					
					try {
						ResultSet rs=stmt.executeQuery(searchCustomerQuery);
						while(rs.next())
						{
							Customer c=new Customer();
							c.setUser_id(rs.getInt("user_id"));
							System.out.println("after query"+rs.getInt("user_id"));
							c.setF_name(rs.getString("f_name"));
							c.setL_name(rs.getString("l_name")); 
							c.setEmail(rs.getString("email"));
							c.setAddress(rs.getString("address"));
							c.setCity(rs.getString("city"));
							c.setState(rs.getString("state"));
							c.setZipcode(rs.getString("zipcode"));
							c.setDob(rs.getString("dob"));
							c.setNationality(rs.getString("nationality"));
							c.setCustomer_ssn(rs.getInt("customer_ssn"));
							c.setPassport_no(rs.getString("passport_no"));
				            customerlist.add(c);
						}
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return customerlist;
			
	}
	
	/*public List<Flight> searchFlight(String source,String destination,String flight_date)
	{
		Date date = utility.convertStringToDate(flight_date);
		Connection conn = DBOperation.getConnection();
		List<Flight> flightlist = new ArrayList<Flight>();
		
		Statement stmt= null;
		System.out.println("Inside search flight funcation");
				
		
		
		
		try {
			stmt = conn.createStatement();
				 
				StringBuffer stringBuffer=new StringBuffer("SELECT u.user_id, u.f_name, u.l_name,u.email, u.address,u.city, u.state, u.zipcode, u.dob," +
						" c.nationality, c.customer_ssn, c.passport_no from airline_management.user u, airline_management.customer c where u.user_id=c.user_id");
				
				if(!customer.getF_name().isEmpty())
				{  
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("u.f_name='"+customer.getF_name()+"'");
				}
				if(!customer.getL_name().isEmpty()){
					stringBuffer.append(" and ");
					count++;
					stringBuffer.append("u.l_name='"+customer.getL_name()+"'");	
				}
				if(!customer.getEmail().isEmpty()){
					stringBuffer.append(" and ");
					count++;
					stringBuffer.append("u.email='"+customer.getEmail()+"'");
				}
				if(!customer.getAddress().isEmpty()){
					stringBuffer.append(" and ");
					count++;
					stringBuffer.append("u.address='"+customer.getAddress()+"'");
				}
				if(!customer.getCity().isEmpty()){
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("u.city='"+customer.getCity()+"'");
				}
				if(!customer.getState().isEmpty()){
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("u.state='"+customer.getState()+"'");
				}
				if(!customer.getZipcode().isEmpty()){
					stringBuffer.append(" and ");
					count++;
					stringBuffer.append("u.zipcode='"+customer.getZipcode()+"'");	
				}
				if(!customer.getDob().isEmpty()){
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("u.dob='"+utility.convertStringToDate(customer.getDob())+"'");
				}					
									
				if(!customer.getPassport_no().isEmpty()){
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("c.passport_no='"+customer.getPassport_no()+"'");	
				}						
				if(!customer.getNationality().isEmpty()){
					stringBuffer.append(" and ");						
					count++;
					stringBuffer.append("c.nationality='"+customer.getNationality()+"'");	
				}
				if(customer.getCustomer_ssn() != 0){
					stringBuffer.append(" and ");
					count++;
					stringBuffer.append("c.customer_ssn='"+customer.getCustomer_ssn()+"'");						
				}				
				
				System.out.println("Final Customer Search Query:: "+stringBuffer.toString());
				String searchCustomerQuery = stringBuffer.toString();
				
				
				try {
					ResultSet rs=stmt.executeQuery(searchCustomerQuery);
					while(rs.next())
					{
						Customer c=new Customer();
						c.setUser_id(rs.getInt("user_id"));
						System.out.println("after query"+rs.getInt("user_id"));
						c.setF_name(rs.getString("f_name"));
						c.setL_name(rs.getString("l_name")); 
						c.setEmail(rs.getString("email"));
						c.setAddress(rs.getString("address"));
						c.setCity(rs.getString("city"));
						c.setState(rs.getString("state"));
						c.setZipcode(rs.getString("zipcode"));
						c.setDob(rs.getString("dob"));
						c.setNationality(rs.getString("nationality"));
						c.setCustomer_ssn(rs.getInt("customer_ssn"));
						c.setPassport_no(rs.getString("passport_no"));
			            customerlist.add(c);
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		try {
			stmt = conn.createStatement();

			String query="SELECT f.flight_no,f.flight_name,f.no_of_seats from flight f,schedule_flight sf where f.flight_no=sf.flight_no and (sf.source='"+source+"' and sf.destination='"+destination+"' and sf.flight_date='"+date+"')";
			
			System.out.println("Search Flight Query is:: "+query);
			int count=0;
			//String allstaff="SELECT s.user_id from staff s where s.user_id="+staff.getUser_id()+"||s.work_desc="+staff.getWork_desc()+"||s.position="+staff.getPosition()+"||s.hire_date="+staff.getHire_date()+"";
			try {
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					Flight f=new Flight();
					f.setFlight_name(rs.getString("flight_name"));
					f.setFlight_no(rs.getString("flight_no"));
					f.setNo_of_seats(rs.getInt("no_of_seats"));
					flightlist.add(f);
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	return flightlist;

	}*/
	
	
	public List<Flight> searchFlight(String source,String destination,String flight_date)
	{
		Connection conn = DBOperation.getConnection();
		Statement stmt= null;
		List<Flight> flightlist = new ArrayList<Flight>();
		Date date = utility.convertStringToDate(flight_date);		
		
		CachingService cachingService = new CachingService() ;
		List<Flight> cachedFlightList = cachingService.lookUp(source, destination, flight_date);
		if(cachedFlightList != null){
			System.out.println("got data from cache");
			return cachedFlightList;
		}
		
		
		try {
				stmt = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int count=0;
			System.out.println("in side search");
			
			try {
				stmt = conn.createStatement();
					 
					StringBuffer stringBuffer=new StringBuffer("SELECT f.flight_name, f.flight_no, sf.avail_seat from airline_management.flight f, airline_management.schedule_flight sf where f.flight_no=sf.flight_no");
					
					if(!source.isEmpty())
					{  
						stringBuffer.append(" and ");						
						count++;
						stringBuffer.append("sf.source='"+source+"'");
					}
					if(!destination.isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("sf.destination='"+destination+"'");	
					}
					if(!flight_date.isEmpty()){
						stringBuffer.append(" and ");
						count++;
						stringBuffer.append("sf.flight_date='"+date+"'");
					}
								
					
					System.out.println("Final Customer Search Query:: "+stringBuffer.toString());
					String searchFlightQuery = stringBuffer.toString();
					
					
					try {
						ResultSet rs=stmt.executeQuery(searchFlightQuery);
						while(rs.next())
						{Flight f=new Flight();
						f.setFlight_name(rs.getString("flight_name"));
						f.setFlight_no(rs.getString("flight_no"));
						f.setNo_of_seats(rs.getInt("avail_seat"));
						flightlist.add(f);
						}
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
					cachingService.addToCache(source, destination, flight_date, flightlist);			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return flightlist;
			
	}
	
	
	
	
	
	

}
