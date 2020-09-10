package com.stock.companyservice.service;

import com.stock.companyservice.model.Ipo;

import java.util.List;

public interface IpoService {
    public List<Ipo> getIpo(String companyName);
    public Ipo addIpo(Ipo ipo);
}
