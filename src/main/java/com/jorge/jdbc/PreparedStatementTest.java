package com.jorge.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PreparedStatementTest {
	public static void main(String[] args) {
		PreparedStatement ptsmt;
		    ResultSet rs;
		    
		    Connection conn = ConnectionUtils.createConnection();
		    
		    try {
		        String selectCustomers="select * from employee";    
		         ptsmt = conn.prepareStatement(selectCustomers);
		        rs = ptsmt.executeQuery();
		        
		        while(rs.next()) {
		            //System.out.println(rs.getInt("id") +  "  " + rs.getString("name"));
		            System.out.println(rs.getInt(1) +  "  " + rs.getString("employee_name"));
		        }
		        
		        rs.close();
		        ptsmt.close();
		    
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

		}

}
