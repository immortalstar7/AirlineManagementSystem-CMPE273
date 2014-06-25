package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.CustomerMessageBean;
import model.Utility;



public class CustomerService {
	DBOperation dbOperation;
	Utility utility = new Utility();
	private static final String INSERT_USER_QUERY = "insert into user (f_name,l_name,password,email,address,city,state," +
													"zipcode,dob,type) values ('";
	
	private static final String INSERT_CUSTOMER_QUERY = "insert into customer (user_id,customer_ssn,nationality,passport_no) values ('";
	private static final String RETRIEVE_ALL_CUSTOMERS_QUERY = "SELECT u.user_id, u.f_name, u.l_name, u.password, u.email, u.address," +
			" u.city, u.state, u.zipcode, u.dob, c.nationality, c.customer_ssn, c.passport_no from user u, customer c where u.user_id=c.user_id";
	public CustomerService() {
		// TODO Auto-generated constructor stub
		dbOperation = new DBOperation();
	}
	
	public CustomerMessageBean addCustomer(Customer customer){
		CustomerMessageBean customerMessageBean = new CustomerMessageBean();
		String insertUserQuery = generateUserInsertQuery(customer);
		try {
				//insert into User Table
				int user_id = dbOperation.executeUpdateQuery(insertUserQuery);
				System.out.println("User Id of newly added customer:: "+user_id);
				//insert into Customer Table
				insertIntoCustomerTable(user_id,customer);
				//Set the return values
				customerMessageBean.setUser_id(user_id);
				customerMessageBean.setCustomer(customer);
				customerMessageBean.setMessage("New Customer "+customer.getF_name()+" "+customer.getL_name()+" Added Successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			customerMessageBean.setMessage("Error in adding New Customer!! ");
			e.printStackTrace();
		}
		
		return customerMessageBean;
		
	}
	
public String generateUserInsertQuery(Customer customer){
	
		StringBuffer strQuery = new StringBuffer(INSERT_USER_QUERY);
		strQuery.append(customer.getF_name());
		strQuery.append("', '");
		strQuery.append(customer.getL_name());
		strQuery.append("', '");		
		strQuery.append(customer.getPassword());
		strQuery.append("', '");
		strQuery.append(customer.getEmail());
		strQuery.append("', '");
		strQuery.append(customer.getAddress());
		strQuery.append("', '");
		strQuery.append(customer.getCity());
		strQuery.append("', '");
		strQuery.append(customer.getState());
		strQuery.append("', '");
		strQuery.append(customer.getZipcode());
		strQuery.append("', '");
		strQuery.append(utility.convertStringToDate(customer.getDob()));
		strQuery.append("', '");		
		strQuery.append(customer.getType());
		strQuery.append("')");
		
		System.out.println("Insert User query : "+strQuery.toString());
		
		return strQuery.toString();

	}

	public void insertIntoCustomerTable(int user_id,Customer customer){
		
		StringBuffer strQuery = new StringBuffer(INSERT_CUSTOMER_QUERY);
		strQuery.append(user_id);
		strQuery.append("', '");
		strQuery.append(customer.getCustomer_ssn());
		strQuery.append("', '");		
		strQuery.append(customer.getNationality());
		strQuery.append("', '");
		strQuery.append(customer.getPassport_no());
		strQuery.append("')");
		System.out.println("Insert Customer query : "+strQuery.toString());
		
		try {
			DBOperation.executeQuery(strQuery.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getCustomerDetails(){
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			//insert into User Table
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 1");
			String customerdetailsQuery = RETRIEVE_ALL_CUSTOMERS_QUERY;
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 2");
			customerList = executecustomerdetailsQuery(customerdetailsQuery);
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 3");
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//customeressageBean.setMessage("Error in adding New Customer!! ");
		e.printStackTrace();
	}
	System.out.println("total customers" + customerList.size());
	return customerList;
		
	}

	public static List<Customer> executecustomerdetailsQuery(String querystr) throws Exception{
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs;
		List<Customer> customerList = new ArrayList<Customer>();
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
	            Customer cust = new Customer();
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
	            customerList.add(cust);
			}
		}catch (Exception e){
			System.out.println("unable to execute customer details query" + querystr);
		}
		System.out.println("List length:: "+customerList.size());
		return customerList;
	}
	
}
