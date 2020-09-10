package com.stock.companyservice.service;

import com.stock.companyservice.dao.IpoDao;
import com.stock.companyservice.model.Ipo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IpoServiceImpl implements IpoService{

    private IpoDao ipoDetailDao;


    public IpoServiceImpl(IpoDao ipoDetailDao) {
        this.ipoDetailDao = ipoDetailDao;
    }


    @Override
    public List<Ipo> getIpo(String companyName) {
        return ipoDetailDao.findByCompanyName(companyName);
    }

    @Override
    public Ipo addIpo(Ipo ipo) {
        return ipoDetailDao.save(ipo);
    }
}
