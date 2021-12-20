package com.bankproject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankproject.demo.dto.AccountRespClassProjection;
import com.bankproject.demo.dto.AccountResponseProjection;
import com.bankproject.demo.model.Account;

@Repository
public interface AccountDao extends CrudRepository<Account, Integer> {

//	Account findByAccountNumber(long accountNumber);

//	Account saveData(Account account);

	@Query(value = "select new com.bankproject.demo.dto.AccountResponseProjection(a.accountId, a.accountNumber, a.balance) from Account a")
	List<AccountResponseProjection> findAllAccounts();
	
	AccountRespClassProjection findByAccountNumber(Long accountNumber);
}

