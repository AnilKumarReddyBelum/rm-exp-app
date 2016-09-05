package com.ac.rmexpapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ac.rmexpapp.model.DeleteStaus;
import com.ac.rmexpapp.model.Expense;
import com.ac.rmexpapp.repo.ExpenseRepository;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseRepository repository;

	@RequestMapping(value = "/getExpenseRecords")
	public List<Expense> getExpenseRecords() {
		return (List<Expense>) repository.findAll();
	}

	@RequestMapping(value = "/createExpense", method = RequestMethod.POST)
	public Expense createExpense(@RequestBody Expense expense) {
		return repository.save(expense);
	}

	@RequestMapping(value = "/resetDB", produces = MediaType.APPLICATION_JSON_VALUE)
	public DeleteStaus resetDB() {
		try {
			repository.deleteAll();
			DeleteStaus deleteStaus = DeleteStaus.SUCCESSFULLY_RESETTED;
			return deleteStaus;
		} catch (Exception exception) {
			DeleteStaus deleteStaus = DeleteStaus.ERROR_WHILE_RESETTING;
			return deleteStaus;
		}

	}
}
