package com.jorge.classes;

public class ExpenseClass {
	
	private int authorId;
	private int resolverId;
	private String expenseType;
	private double amount;
	private String description;
	private String submitTime;
	private boolean accepted;
	
	public ExpenseClass() {
		super();
	}

	public ExpenseClass( int authorId, int resolverId,String expenseType, double amount, String description,
			String submitTime, boolean accepted) {
		super();
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.expenseType = expenseType;
		this.amount = amount;
		this.description = description;
		this.submitTime = submitTime;
		this.accepted = accepted;
	}


	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}


	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "ExpenseClass [authorId=" + authorId + ", resolverId=" + resolverId + ", expenseType=" + expenseType
				+ ", amount=" + amount + ", description=" + description + ", submitTime=" + submitTime + ", accepted="
				+ accepted + "]";
	}
	
}
