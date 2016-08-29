package com.ac.rmexpapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7597984417157900779L;

	public Expense() {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(),
				LocalTime.now());
		String formattedDateTime = dateTime.format(formatter);
		this.spentDate = formattedDateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String owner;
	private String spentDate;
	private BigDecimal cost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSpentDate() {
		return spentDate;
	}

	public void setSpentDate(String spentDate) {
		this.spentDate = spentDate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
