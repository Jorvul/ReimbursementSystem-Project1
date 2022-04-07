package com.jorge.javalin;

import com.jorge.controllers.EmployeeController;
import com.jorge.controllers.ExpenseController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {

		Javalin app = Javalin.create(ctx -> {
			ctx.addStaticFiles("web", Location.CLASSPATH);
		}).start();
		
		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/employees/{employee_id}", EmployeeController.getEmployeeById);
		app.delete("/employees/{employee_id}", EmployeeController.deleteEmployee);
		app.get("/expenses", ExpenseController.getAllExpenses);
	}

}
