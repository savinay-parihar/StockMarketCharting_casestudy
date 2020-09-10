package com.stock.companyservice.dao;

import com.stock.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDao extends JpaRepository<Company,Integer> {
    Optional<Company> findByCompanyId(Integer companyId);
    List<Company> findByCompanyNameContaining(String pattern);
}
