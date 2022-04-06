package com.jorge.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jorge.classes.EmployeeClass;
import com.jorge.jdbc.ConnectionUtils;

import io.javalin.http.Handler;

public class EmployeeController {
	public static Handler getAllStudents=ctx->{
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
}
