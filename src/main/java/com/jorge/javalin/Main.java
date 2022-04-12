package com.jorge.javalin;

import com.jorge.controllers.EmployeeController;
import com.jorge.controllers.ExpenseController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {

		Javalin app = Javalin.create(ctx -> {
			ctx.addStaticFiles("web", Location.CLASSPATH);
			ctx.enableCorsForAllOrigins();
		}).start();
		
		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/employee/{employee_id}", EmployeeController.getEmployeeById);
		app.delete("/employees/{employee_id}", EmployeeController.deleteEmployee);
		app.get("/expenses", ExpenseController.getAllExpenses);
		app.post("/expenses", ExpenseController.createExpense);
		app.get("/expenses/{expenseid}", ExpenseController.getExpenseById);
		app.put("/employee/{author_id}", ExpenseController.ApproveDenyExpense);
	}

}
