package com.jorge.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jorge.classes.EmployeeClass;
import com.jorge.classes.ExpenseClass;
import com.jorge.jdbc.ConnectionUtils;

import io.javalin.http.Handler;

public class ExpenseController {
	public static Handler getAllExpenses=ctx->{
		 //1. get connection using coonecUtil Class
		 ResultSet rs;
		 PreparedStatement ptsmt;
		 
		 Connection conn = ConnectionUtils.createConnection();
		 //2. create a PreparedStatement object and execute the query select * from student and fecth in results set
		    
		    
		        String selectEmployees="select * from reimbursements";    
		        ptsmt = conn.prepareStatement(selectEmployees);
		        rs = ptsmt.executeQuery();
		 //3.Student ArrayList
		 ArrayList<ExpenseClass> sList = new ArrayList<ExpenseClass>();
		 ExpenseClass s;
		 while(rs.next()) {
			 int expid = rs.getInt("id");
			 int id = rs.getInt("author_id");
			 int resolve = rs.getInt("resolver_id");
			 String type = rs.getString("reimbursement_type");
			 double amount = rs.getDouble("amount");
			 String description = rs.getString("description");
			 String date = rs.getString("submit_date");
			 String sdate = rs.getString("resolved_date");
			 boolean resolved = rs.getBoolean("resolved");
			 boolean accept = rs.getBoolean("accepted");
			 s=new ExpenseClass(expid, id, resolve, type, amount, description, date, sdate, resolved, accept);
			 sList.add(s);
		 }
		 rs.close();
	     ptsmt.close();
		 ctx.json(sList);
		    
	 };
	 
	 public static Handler getEmployeeById = ctx -> {
		    int p = Integer.parseInt(ctx.pathParam("employee_id"));
		    Connection conn = ConnectionUtils.createConnection();
		    String selectEmployees = "select * from employee where employee_id=?";
		    PreparedStatement ptsmt = conn.prepareStatement(selectEmployees);
		    ptsmt.setInt(1, p);
		    ResultSet rs = ptsmt.executeQuery();
		    ArrayList<EmployeeClass> sList = new ArrayList<EmployeeClass>();
		    EmployeeClass s;
		    while (rs.next()) {
		        int id = rs.getInt("employee_id");
		        String name = rs.getString("employee_name");
		        String title = rs.getString("employee_title");
				 String user = rs.getString("username");
				 String pass = rs.getString("password");
		        s = new EmployeeClass(id, name, title, user, pass);
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
		
		public static Handler createExpenxe=ctx->{
			ExpenseClass newExpense = ctx.bodyAsClass(ExpenseClass.class);
			Connection conn = ConnectionUtils.createConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into reimbursements (author_id,reimbursement_type,amount,description,submit_date) values (?,?,?,?,?)");
			pstmt.setInt(1,newExpense.getAuthorId());
			pstmt.setString(2, newExpense.getExpenseType());
			pstmt.setDouble(3, newExpense.getAmount());
			pstmt.setString(4,newExpense.getDescription());
			pstmt.setString(5, newExpense.getSubmitTime());
			pstmt.execute();
			ctx.status(200);
			
		};
		
		public static Handler getExpenseById=ctx->{
			ResultSet rs;
			PreparedStatement ptsmt;
			int c = Integer.parseInt(ctx.pathParam("expenseid"));
			ArrayList<ExpenseClass> expense = new ArrayList<ExpenseClass>();
			Connection conn=ConnectionUtils.createConnection();
				String selectExpense = "select * from reimbursements where author_id=?";
				ptsmt = conn.prepareStatement(selectExpense);
				ptsmt.setInt(1,c);
				rs = ptsmt.executeQuery();
				ExpenseClass c1;
				while(rs.next()) {
					int id = rs.getInt("id");
					int id1 = rs.getInt("author_id");
					int id2 = rs.getInt("resolver_id");
					String string = rs.getString("reimbursement_type");
					Double id3 = rs.getDouble("amount");
					String id4 = rs.getString("description");
					String id5 = rs.getString("submit_date");
					String id6 = rs.getString("resolved_date");
					boolean id7 = rs.getBoolean("resolved");
					boolean id8 = rs.getBoolean("accepted");
					c1 = new ExpenseClass(id,id1, id2, string, id3, id4, id5, id6, id7, id8);
					//ExpenseClass.add(c1);
				}
		};
	
}
