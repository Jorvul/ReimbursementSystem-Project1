package com.jorge.javalin;

import com.jorge.controllers.EmployeeController;
import com.jorge.controllers.ExpenseController;
import com.jorge.dao.ExpenseDAO;
import com.jorge.dao.PostgresExpenseDAO;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {

		Javalin app = Javalin.create(ctx -> {
			ctx.addStaticFiles("web", Location.CLASSPATH);
			ctx.enableCorsForAllOrigins();
		}).start();
		ExpenseDAO dao = new PostgresExpenseDAO();
		ExpenseController hc = new ExpenseController(dao);
		
		//app.get("/employees", EmployeeController.getAllEmployees);
		//app.get("/employee/{employee_id}", EmployeeController.getEmployeeById);
		//app.delete("/employees/{employee_id}", EmployeeController.deleteEmployee);
		app.get("/expenses", hc.getAllExpenses);
		app.post("/expenses", hc.createExpense);
		app.get("/expenses/{expenseid}", hc.getExpenseById);
		//app.post("/employee", ExpenseController.createApproveOrDenyExpense);
		app.post("/employee/{author_id}", hc.ApproveDenyExpense);
	}

}
