package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Company;
import com.ex.repository.CompanyRepo;

@Service
public class CompanyService
{
	@Autowired
	private CompanyRepo companyRepo;
	
	public List<Company> getCompanyList() {
		return companyRepo.findAll();
	}

	public Company getCompanyById(Integer id) {
		return companyRepo.findById(id).get();
	}

	public void saveOrUpdateCompany(Company company) {
		companyRepo.save(company);
	}
	
	public void deleteCompany(Integer id) {
		companyRepo.deleteById(id);
	}
	
	

}
