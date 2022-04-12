package com.jorge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jorge.classes.ExpenseClass;
import com.jorge.jdbc.ConnectionUtils;

public class PostgresExpenseDAO implements ExpenseDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	String selectUserExpenses = "SELECT resolver_id, reimbursement_type, amount, description, submit_date, accepted FROM reimbursements WHERE author_id=?";
	String selectAllExpenses = "SELECT author_id, reimbursement_type, amount, description, submit_date FROM reimbursements";
	String selectExpense = "SELECT reimbursement_type, amount, description, submit_date FROM reimbursements WHERE author_id=?";
	String updateExpense = "UPDATE reimbursement_type SET accepted=? WHERE author_id=?";

@Override
public ArrayList<ExpenseClass> getAllexpenses() {
		ArrayList<ExpenseClass> expense = new ArrayList<ExpenseClass>();
		try (Connection conn = ConnectionUtils.createConnection();) {
			pstmt = conn.prepareStatement(selectAllExpenses);
			rs = pstmt.executeQuery();
			ExpenseClass expensesList;
			while (rs.next()) {
				int id = rs.getInt("author_id");
				int id1 = rs.getInt("resolver_id");
				String reim = rs.getString("reimbursement_type");
				double amt = rs.getDouble("amount");
				String descript = rs.getString("description");
				String submittime = rs.getString("submit_date");
				boolean bool = rs.getBoolean("accepted");
				expensesList = new ExpenseClass(id, id1, reim, amt, descript, submittime, bool);
				expense.add(expensesList);
			}
			rs.close();pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expense;
		
		
	};
	
	
	
}