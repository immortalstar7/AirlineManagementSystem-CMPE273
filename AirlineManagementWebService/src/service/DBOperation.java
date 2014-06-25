package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBOperation {
	private static DataSource dataSource;
    private static Connection connection;
    private Statement statement;
	public DBOperation() {
		// TODO Auto-generated constructor stub
		 Context initContext;
		try {
			 initContext = new InitialContext();
			 Context envContext  = (Context)initContext.lookup("java:/comp/env");
	         dataSource = (DataSource)envContext.lookup("jdbc/airline_management");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static Connection getConnection(){
		try {
			connection = dataSource.getConnection();
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public  int executeUpdateQuery(String query) throws Exception{
		Connection conn = null;
		int returnedIndx;
		try {
			conn = getConnection();
			Statement stmt  = conn.createStatement();
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);			
			ResultSet rs = null;
             try {
                 rs = stmt.getGeneratedKeys();
                 if (rs.next()) {
                	 returnedIndx = rs.getInt(1);                    
                 } else {
                     throw new RuntimeException("Can't find most recent insert we just entered");
                 }
                 rs.close();
                 rs = null;
             }  finally {
                 if (rs != null) {
                     try {
                         rs.close();
                     } catch (SQLException ex) {} // ignore
                 }
                 try {
                	 stmt.close();
                 } catch (SQLException ex) {}  // ignore
             }
			
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to execute query : "+query);
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to execute query: "+query);
			throw e;
		} finally {
			closeConnection(conn);
		}
		System.out.println("Returned Index is: "+returnedIndx);
		return returnedIndx;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch(SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}
	public static void executeQuery(String strQuery) throws Exception {
		Connection conn = null;
		
		try {
			conn = getConnection();
			Statement stmt  = conn.createStatement();
			stmt.executeUpdate(strQuery);
			
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to execute query : "+strQuery);
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to execute query: "+strQuery);
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

}
