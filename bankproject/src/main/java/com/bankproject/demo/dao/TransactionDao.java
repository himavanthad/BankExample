package com.bankproject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankproject.demo.model.Account;
import com.bankproject.demo.model.Customer;
import com.bankproject.demo.model.Transaction;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long> {

	@Query("FROM Transaction u ORDER BY u.transactionId DESC")
	Transaction findFirstByOrderByDateDesc();
	
	/*
	 * @Query("FROM Transaction u WHERE u.account_Id = :accountId")
	 * List<Transaction> getAllTransactionByAccountId(Integer accountId);
	 */

	 //	Account findById(long accountNumber);
	//	long getAccountNumber();
	// void save(Transaction transaction);
	// void save(TransactionDao transactionDao);

}
