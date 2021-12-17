package com.bankproject.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankproject.demo.dto.CustomerResponseDto;
import com.bankproject.demo.dto.TransactionDatesDto;
import com.bankproject.demo.dto.TransactionDto;
import com.bankproject.demo.dto.TransactionResponseDto;
import com.bankproject.demo.exception.EntryNotFoundException;
import com.bankproject.demo.model.Account;
import com.bankproject.demo.service.AccountService;
import com.bankproject.demo.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transcService;

	@PostMapping("/transactions/save")
	public ResponseEntity<List<TransactionResponseDto>> saveTransactions(
			@Valid @RequestBody TransactionDto transactionRequestDto) throws EntryNotFoundException {
		List<TransactionResponseDto> saveTransactions = transcService.saveTransactions(transactionRequestDto);
		return new ResponseEntity<List<TransactionResponseDto>>(saveTransactions, HttpStatus.ACCEPTED);
	}

	@PostMapping("/getAllTransactionByAccountIdDates")
	//@GetMapping("/getAllTransactionByAccountIdDates/{AccountId}")
	public List<TransactionResponseDto> getAllTransactionByAccountId(@RequestBody TransactionDatesDto transactionDatesDto) {
		return (List<TransactionResponseDto>) transcService.getAllTransactionByFromAndToDates(transactionDatesDto.getFromDate(), transactionDatesDto.getToDate());
	}

}
