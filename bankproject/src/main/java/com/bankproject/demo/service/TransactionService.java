package com.bankproject.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.bankproject.demo.dto.TransactionDto;
import com.bankproject.demo.dto.TransactionResponseDto;
import com.bankproject.demo.exception.EntryNotFoundException;

public interface TransactionService {

	TransactionResponseDto saveTransactions(@Valid TransactionDto transactionRequestDto) throws EntryNotFoundException;

	//List<TransactionResponseDto> getAllTransactionByAccountId(Integer accountId);


//	void depositOperation(long accountNumber, double balance);
//
//	void debitOperation(long accountNumber, double balance);

}
