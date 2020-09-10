package com.stock.companyservice.dto;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyDto {

    private Integer companyId;
    private String companyName;
    private String ceo;

    @ElementCollection
    private List<String> boardOfDirectors;

    @ElementCollection
    private List<String> stockExchanges = new ArrayList<>();
    private Integer sector;
    private String description;
    @ElementCollection
    private List<String> codeInStockExchange=new ArrayList<>();

    public List<String> getStockExchanges() {
        return stockExchanges;
    }

}
