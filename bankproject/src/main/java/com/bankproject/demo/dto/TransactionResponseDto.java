package com.bankproject.demo.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class TransactionResponseDto {

	@NotNull(message = "provide transaction amount")
	private double transactionedAmount;

	@NotNull(message = "provide Account type")
	private String accountType;

	@NotNull(message = "provide from account no")
	private Long accountId;

	@NotNull(message = "provide to available bal")
	private double availableBalance;

	@NotNull(message = "provide transaction date")
	private LocalDate transactionDate;

	@NotNull(message = "provide transaction number ")
	private String transactionNumber;

	@NotNull(message = "provide to account id")
	private Integer formAccountId;

	@NotNull(message = "provide to account id")
	private Integer toAccountId;

	private LocalDate fromDate;

	private LocalDate ToDate;

	public double getTransactionedAmount() {
		return transactionedAmount;
	}

	public void setTransactionedAmount(double transactionedAmount) {
		this.transactionedAmount = transactionedAmount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Integer getFormAccountId() {
		return formAccountId;
	}

	public void setFormAccountId(Integer formAccountId) {
		this.formAccountId = formAccountId;
	}

	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return ToDate;
	}

	public void setToDate(LocalDate toDate) {
		ToDate = toDate;
	}

}
