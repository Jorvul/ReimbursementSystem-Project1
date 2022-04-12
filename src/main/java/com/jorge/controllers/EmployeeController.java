package com.jorge.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jorge.classes.EmployeeClass;
import com.jorge.classes.ExpenseClass;
import com.jorge.jdbc.ConnectionUtils;

import io.javalin.http.Handler;

public class EmployeeController {
	public static Handler getAllEmployees=ctx->{
		 //1. get connection using coonecUtil Class
		 ResultSet rs;
		 PreparedStatement ptsmt;
		 
		 Connection conn = ConnectionUtils.createConnection();
		 //2. create a PreparedStatement object and execute the query select * from student and fecth in results set
		    
		    
		        String selectEmployees="select * from employee";    
		        ptsmt = conn.prepareStatement(selectEmployees);
		        rs = ptsmt.executeQuery();
		 //3.Student ArrayList
		 ArrayList<EmployeeClass> sList = new ArrayList<EmployeeClass>();
		 EmployeeClass s;
		 while(rs.next()) {
			 int id = rs.getInt("employee_id");
			 String name = rs.getString("employee_name");
			 String title = rs.getString("employee_title");
			 String user = rs.getString("username");
			 String pass = rs.getString("password");
			 s=new EmployeeClass(id, name, title, user, pass);
			 sList.add(s);
		 }
		 rs.close();
	     ptsmt.close();
		 ctx.json(sList);
		    
	 };
	 
	 public static Handler getEmployeeById = ctx -> {
		    int p = Integer.parseInt(ctx.pathParam("employee_id"));
		    Connection conn = ConnectionUtils.createConnection();
		    String selectEmployees = "select * from reimbursements where author_id=?";
		    PreparedStatement ptsmt = conn.prepareStatement(selectEmployees);
		    ptsmt.setInt(1, p);
		    ResultSet rs = ptsmt.executeQuery();
		    ArrayList<ExpenseClass> sList = new ArrayList<ExpenseClass>();
		    ExpenseClass s;
		    while (rs.next()) {
		        int id = rs.getInt("author_id");
		        int id2 = rs.getInt("resolver_id");
		        String name = rs.getString("reimbursement_type");
		        double title = rs.getDouble("amount");
		        String descr= rs.getString("description");
				 String user = rs.getString("submit_date");
				 boolean pass = rs.getBoolean("accepted");
		        s = new ExpenseClass(id, id2, name, title, descr, user, pass);
		        sList.add(s);
		    }

		    ctx.json(sList);
		    rs.close();
		    ptsmt.close();
		};
		
		public static Handler deleteEmployee=ctx->{
			int id = Integer.parseInt(ctx.pathParam("employee_id"));
			Connection conn = ConnectionUtils.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from employee where employee_id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
			ctx.status(200);
		};
}
