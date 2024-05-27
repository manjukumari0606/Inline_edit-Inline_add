package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.model.Company;

@Repository
public interface CompanyRepo  extends JpaRepository<Company, Integer>{
	
	
}
