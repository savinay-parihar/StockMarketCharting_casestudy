package com.stock.companyservice.service;

import com.stock.companyservice.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    public Iterable<CompanyDto> getAllCompanies();
    public CompanyDto addCompany(CompanyDto companyDto);
    public void deleteCompany(Integer companyId);
    public CompanyDto updateCompany(CompanyDto companyDto, Integer companyId);
    public List<CompanyDto> searchByPattern(String pattern);

}
