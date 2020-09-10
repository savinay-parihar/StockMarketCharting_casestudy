package com.stock.companyservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer companyId;
    private String companyName;
    private String ceo;

    @ElementCollection
    private List<String> boardOfDirectors;

    @ElementCollection
    private List<String> stockExchanges = new ArrayList<String>();
    private Integer sector;
    private String description;

    @ElementCollection
    private List<String> codeInStockExchange=new ArrayList<>();


    public List<String> getStockExchanges() {
        return stockExchanges;
    }



}
