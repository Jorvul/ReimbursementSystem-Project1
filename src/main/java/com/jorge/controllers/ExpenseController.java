package com.jorge.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jorge.classes.EmployeeClass;
import com.jorge.classes.ExpenseClass;
import com.jorge.dao.ExpenseDAO;
import com.jorge.dao.PostgresExpenseDAO;
import com.jorge.jdbc.ConnectionUtils;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ExpenseController {
	private ExpenseDAO dao = new PostgresExpenseDAO();
	  public ExpenseController(ExpenseDAO dao) {
		  this.dao = dao;
	  }
	
	public  Handler getAllExpenses=ctx->{
		 //1. get connection using coonecUtil Class
//		 ResultSet rs;
//		 PreparedStatement ptsmt;
//		 
//		 Connection conn = ConnectionUtils.createConnection();
//		 //2. create a PreparedStatement object and execute the query select * from student and fecth in results set
//		    
//		    
//		        String selectEmployees="select * from reimbursements";    
//		        ptsmt = conn.prepareStatement(selectEmployees);
//		        rs = ptsmt.executeQuery();
//		 //3.Student ArrayList
//		 ArrayList<ExpenseClass> sList = new ArrayList<ExpenseClass>();
//		 ExpenseClass s;
//		 while(rs.next()) {
//			 int expid = rs.getInt("author_id");
//			 int id = rs.getInt("resolver_id");
//			 String type = rs.getString("reimbursement_type");
//			 double amount = rs.getDouble("amount");
//			 String description = rs.getString("description");
//			 String date = rs.getString("submit_date");
//			 boolean accept = rs.getBoolean("accepted");
//			 String res = rs.getString("result");
//			 s=new ExpenseClass(expid, id, type, amount, description, date, accept, res);
//			 sList.add(s);
//		 }
//		 rs.close();
//	     ptsmt.close();
		List<ExpenseClass> expense = this.dao.getAllExpenses();
		ctx.json(expense);
		 //ctx.json(sList);
		    
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
		
		public  Handler createExpense=ctx->{
			ExpenseClass newExpense = ctx.bodyAsClass(ExpenseClass.class);
//			Connection conn = ConnectionUtils.createConnection();
//			PreparedStatement pstmt = conn.prepareStatement("insert into reimbursements (author_id,resolver_id,reimbursement_type,amount,description,submit_date) values (?,?,?,?,?,?)");
//			pstmt.setInt(1,newExpense.getAuthorId());
//			pstmt.setInt(2, newExpense.getResolverId());
//			pstmt.setString(3, newExpense.getExpenseType());
//			pstmt.setDouble(4, newExpense.getAmount());
//			pstmt.setString(5,newExpense.getDescription());
//			pstmt.setString(6, newExpense.getSubmitTime());
//			pstmt.execute();
			this.dao.createExpense(newExpense);
			ctx.status(200);
			
		};
		
//		public static Handler createApproveOrDenyExpense= ctx-> {
//			ExpenseClass exp = ctx.bodyAsClass(ExpenseClass.class);
//			Connection conn = ConnectionUtils.createConnection();
//			PreparedStatement pstmt = conn.prepareStatement("insert into reimbursements (accepted) values (?)");
//			pstmt.setBoolean(1, exp.isAccepted());
//			pstmt.execute();
//			ctx.status(200);
//		};
		
		public Handler getExpenseById=ctx->{
			//ResultSet rs;
			//PreparedStatement ptsmt;
			int c = Integer.parseInt(ctx.pathParam("expenseid"));
//			Connection conn=ConnectionUtils.createConnection();
//				String selectExpense = "select * from reimbursements where author_id=?";
//				ptsmt = conn.prepareStatement(selectExpense);
//				ptsmt.setInt(1,c);
//				rs = ptsmt.executeQuery();
				List<ExpenseClass> expense = this.dao.getExpensebyId(c);
//				ExpenseClass c1;
//				while(rs.next()) {
//					int id1 = rs.getInt("author_id");
//					int id2 = rs.getInt("resolver_id");
//					String string = rs.getString("reimbursement_type");
//					Double id3 = rs.getDouble("amount");
//					String id4 = rs.getString("description");
//					String id5 = rs.getString("submit_date");
//					boolean id8 = rs.getBoolean("accepted");
//					String res = rs.getString("result");
//					c1 = new ExpenseClass(id1, id2, string, id3, id4, id5, id8, res);
//					expense.add(c1);
//				}
				ctx.json(expense);
				ctx.status(201);
//			    rs.close();
//			    ptsmt.close();
		};
		
		public Handler ApproveDenyExpense=ctx->{
			 int id =Integer.parseInt(ctx.pathParam("author_id"));
			 ExpenseClass s1=ctx.bodyAsClass(ExpenseClass.class);
			 ExpenseClass s2=ctx.bodyAsClass(ExpenseClass.class);
				//List<ExpenseClass> daoUpdate = dao.approveDenyExpense(id, id, id);
//			 Connection conn= ConnectionUtils.createConnection();
//				PreparedStatement pstmt= conn.prepareStatement("update reimbursements set accepted=?, result=? where author_id=?");
//				pstmt.setBoolean(1,s1.isAccepted());
//				pstmt.setString(2, s1.getResult());
//				pstmt.setInt(3, id);
//				pstmt.execute();
			 this.dao.approveDenyExpense(s1, id, s2);
				//ctx.status(200);
		 };
	
}
