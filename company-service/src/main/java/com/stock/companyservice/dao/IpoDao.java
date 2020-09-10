package com.stock.companyservice.dao;

import com.stock.companyservice.model.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpoDao extends JpaRepository<Ipo,Integer> {
    List<Ipo> findByCompanyName(String companyName);
}
