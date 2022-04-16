package com.jorge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jorge.classes.ExpenseClass;
import com.jorge.jdbc.ConnectionUtils;

public class PostgresExpenseDAO implements ExpenseDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	//String selectUserExpenses = "SELECT resolver_id, reimbursement_type, amount, description, submit_date, accepted FROM reimbursements WHERE author_id=?";
	//String selectAllExpenses = "SELECT author_id, reimbursement_type, amount, description, submit_date FROM reimbursements";
	//String selectExpense = "SELECT reimbursement_type, amount, description, submit_date FROM reimbursements WHERE author_id=?";
	//String updateExpense = "UPDATE reimbursement_type SET accepted=? WHERE author_id=?";

@Override
public List<ExpenseClass> getAllExpenses() {
		ArrayList<ExpenseClass> expense = new ArrayList<ExpenseClass>();
		try (Connection conn = ConnectionUtils.createConnection();) {
			String selectAllExpenses = "select * from reimbursements";
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
				String res = rs.getString("result");
				expensesList = new ExpenseClass(id, id1, reim, amt, descript, submittime, bool, res);
				expense.add(expensesList);
			}
			rs.close();pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expense;
		
		
	}

@Override
public boolean createExpense(ExpenseClass newExpense) {
	try(Connection conn = ConnectionUtils.createConnection();) {
	PreparedStatement pstmt = conn.prepareStatement("insert into reimbursements (author_id,resolver_id,reimbursement_type,amount,description,submit_date) values (?,?,?,?,?,?)");
	pstmt.setInt(1,newExpense.getAuthorId());
	pstmt.setInt(2, newExpense.getResolverId());
	pstmt.setString(3, newExpense.getExpenseType());
	pstmt.setDouble(4, newExpense.getAmount());
	pstmt.setString(5,newExpense.getDescription());
	pstmt.setString(6, newExpense.getSubmitTime());
	pstmt.execute();
	} catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

@Override
public List<ExpenseClass> getExpensebyId(int c) {
	ArrayList<ExpenseClass> expense = new ArrayList<ExpenseClass>();
	try {
		Connection conn=ConnectionUtils.createConnection();
		String selectExpense = "select * from reimbursements where author_id=?";
		pstmt = conn.prepareStatement(selectExpense);
		pstmt.setInt(1,c);
		rs = pstmt.executeQuery();
		ExpenseClass c1;
		while(rs.next()) {
			int id1 = rs.getInt("author_id");
			int id2 = rs.getInt("resolver_id");
			String string = rs.getString("reimbursement_type");
			Double id3 = rs.getDouble("amount");
			String id4 = rs.getString("description");
			String id5 = rs.getString("submit_date");
			boolean id8 = rs.getBoolean("accepted");
			String res = rs.getString("result");
			c1 = new ExpenseClass(id1, id2, string, id3, id4, id5, id8, res);
			expense.add(c1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return expense;
}

@Override
public ExpenseClass approveDenyExpense(ExpenseClass expense, int id, ExpenseClass res) {
	Connection conn= ConnectionUtils.createConnection();
	try {
		PreparedStatement pstmt= conn.prepareStatement("update reimbursements set accepted=?, result=? where author_id=?");
		pstmt.setBoolean(1,expense.isAccepted());
		pstmt.setString(2,res.getResult());
		pstmt.setInt(3, id);
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return expense;
};
	
	
	
}