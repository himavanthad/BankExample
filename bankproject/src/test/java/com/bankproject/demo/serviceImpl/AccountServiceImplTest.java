package com.bankproject.demo.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bankproject.demo.dao.AccountDao;
import com.bankproject.demo.dao.CustomerDao;
import com.bankproject.demo.dto.AccountDto;
import com.bankproject.demo.dto.AccountRespClassProjection;
import com.bankproject.demo.dto.AccountResponseDto;
import com.bankproject.demo.dto.AccountResponseProjection;
import com.bankproject.demo.exception.CustomerNotFoundException;
import com.bankproject.demo.model.Account;
import com.bankproject.demo.model.Customer;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	@Mock
	private AccountDao accountDao;

	@Mock
	private CustomerDao customerDao;

	private AccountDto accountDto;
	private AccountResponseDto accountResponseDto;
	private Customer customer;
	private Account account;

	@BeforeEach
	public void setUp() {
		accountDto = new AccountDto();
		accountDto.setAccountNumber(2323);
		accountDto.setAccountType("saving");
		accountDto.setBalance(1000);
		accountDto.setCustId(1);
		accountDto.setTransaction(null);

		customer = new Customer();
		customer.setCustName("Rama");
		customer.setEmail("rama@gmail.com");

		account = new Account();
		account.setAccountNumber(2323l);
		account.setAccountType("saving");
		account.setBalance(1000);
		account.setCustomer(customer);

	}

	// @Test(expected = CustomerNotFoundException.class)
	void testSaveData() {

		/*
		 * when(customerDao.findById(Mockito.anyInt())).thenAnswer(i ->{ Customer
		 * customer = new Customer(); customer.setCustName("Rama");
		 * customer.setEmail("rama@gmail.com"); Optional<Customer> optional =
		 * Optional.of(customer); return optional.get(); });
		 */
		when(accountDao.save(Mockito.any(Account.class))).thenAnswer(i -> {
			Account account = new Account();
			account.setAccountNumber(2323l);
			account.setAccountType("saving");
			account.setBalance(1000);
			account.setCustomer(customer);
			return account;
		});

		AccountResponseDto saveData = accountServiceImpl.saveData(accountDto);

		assertNotNull(saveData);
		assertEquals(2323l, saveData.getAccountNumber());

	}

	//@Test
	void testGetAccountById() {

		when(accountDao.findById(Mockito.anyInt())).thenAnswer(i -> {
			Account account = new Account();
			account.setAccountNumber(2323l);
			account.setAccountType("saving");
			account.setBalance(1000);
			account.setCustomer(customer);
			Optional<Account> optional = Optional.of(account);
			return optional.get();
		});

		AccountResponseDto accountById = accountServiceImpl.getAccountById(1);

		assertNotNull(accountById);
	}

	@Test
	void testGetAllAccounts() {
		List<AccountResponseProjection> accountResponseProjections = new ArrayList<AccountResponseProjection>();
		AccountResponseProjection account = new AccountResponseProjection();
		account.setAccountId(1);
		account.setAccountNumber(2323l);
		account.setBalance(1000);
		accountResponseProjections.add(account);
		//((Mockito) accountResponseProjections).
		when(accountDao.findAllAccounts()).thenReturn(accountResponseProjections);
				
				
			/*	.thenAnswer(i -> {
			//List<AccountResponseProjection> accountResponseProjections = new ArrayList<AccountResponseProjection>();
			Account account = new Account();
			account.setAccountNumber(2323l);
			account.setAccountType("saving");
			account.setBalance(1000);
			account.setCustomer(customer);
			accountResponseProjections.
			return accountResponseProjections;
		});*/
		List<AccountResponseProjection> allAccounts = accountServiceImpl.getAllAccounts();
		
		assertNotNull(allAccounts);
		assertTrue(allAccounts.size()>0);
	
	}

	@Test
	void testGetAccountByAccountNumber() {
		AccountRespClassProjection account = new AccountRespClassProjection(2323l, 1000, null, null, "saving");
		when(accountDao.findByAccountNumber(2323l)).thenReturn(account);
		AccountRespClassProjection accounts = accountServiceImpl.getAccountByAccountNumber(2323l);
		assertNotNull(accounts);
	}

}
