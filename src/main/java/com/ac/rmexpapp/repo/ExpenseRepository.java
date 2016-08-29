package com.ac.rmexpapp.repo;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ac.rmexpapp.model.Expense;

@Repository
public interface ExpenseRepository extends
		PagingAndSortingRepository<Expense, Serializable> {
	
	
	

}
