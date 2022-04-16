package com.jorge.daotests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.jorge.classes.ExpenseClass;
import com.jorge.dao.ExpenseDAO;
import com.jorge.dao.PostgresExpenseDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ExpenseClassDAOTest {
	private ExpenseDAO dao = new PostgresExpenseDAO();
	  private static ExpenseClass expense;
	  
	  @Test
	  void createNewExpenseTest() {
		  ExpenseClass exp = new ExpenseClass(301, 101,"Food",100.00, "frozen foods", "04/14/2022", true, "approved");
		  dao.createExpense(exp);
		  ExpenseClassDAOTest.expense = exp;
		  Assertions.assertEquals(301, exp.getAuthorId());
	  }
	  @Test
	  void getAllExpensesTest() {
		  List<ExpenseClass> allExpenses = new ArrayList<ExpenseClass>();
			List<ExpenseClass> noExpenses = new ArrayList<ExpenseClass>();
			allExpenses = dao.getAllExpenses();
			Assertions.assertNotEquals(noExpenses, allExpenses);
	  }
	  @Test
	  void getExpenseByIdTest() {
		  ExpenseClass exp = new ExpenseClass(301,101,"Food",100.00,"frozen foods", "04/14/2022", true, "approved");
		  dao.getExpensebyId(301);
		  ExpenseClassDAOTest.expense = exp;
		  Assertions.assertEquals(301, exp.getAuthorId());
	  }
	  @Test
	  void approveDenyExpenseTest() {
		  ExpenseClass exp = new ExpenseClass(601,101,"Transportation", 50.00, "bus pass","04/15/2022", true,"approved");
		  dao.approveDenyExpense(exp, 601, exp);
		  ExpenseClassDAOTest.expense = exp;
		  Assertions.assertEquals(601, exp.getAuthorId());
	  }
}
