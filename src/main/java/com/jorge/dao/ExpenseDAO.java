package com.jorge.dao;


import java.util.List;

import com.jorge.classes.ExpenseClass;

public interface ExpenseDAO {
	List<ExpenseClass> getAllExpenses();
	boolean createExpense(ExpenseClass newExpense);
	List<ExpenseClass>getExpensebyId(int c);
	ExpenseClass approveDenyExpense(ExpenseClass expense, int id, ExpenseClass res);
}
