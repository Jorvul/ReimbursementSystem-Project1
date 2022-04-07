package com.jorge.classes;

public class ExpenseClass {
	
	private int expenseId;
	private int authorId;
	private int resolverId;
	private String expenseType;
	private double amount;
	private String description;
	private String submitTime;
	private String resolvedDate;
	private boolean accepted;
	private boolean resolved;
	
	public ExpenseClass() {
		super();
	}

	public ExpenseClass(int expenseId, int authorId, int resolverId,String expenseType, double amount, String description,
			String submitTime, String resolvedDate, boolean accepted, boolean resolved) {
		super();
		this.expenseId = expenseId;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.expenseType = expenseType;
		this.amount = amount;
		this.description = description;
		this.submitTime = submitTime;
		this.resolvedDate = resolvedDate;
		this.accepted = accepted;
		this.resolved = resolved;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
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

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	@Override
	public String toString() {
		return "ExpenseClass [expenseId=" + expenseId + ", authorId=" + authorId + ", resolverId=" + resolverId
				+ ", expenseType=" + expenseType + ", amount=" + amount + ", description=" + description
				+ ", submitTime=" + submitTime + ", resolvedDate=" + resolvedDate + ", accepted=" + accepted
				+ ", resolved=" + resolved + "]";
	}
	
}
