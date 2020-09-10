package com.stock.companyservice.dto;

import lombok.Data;

@Data
public class IpoDto {
    private Integer ipoId;
    private String stockExchange;
    private Float pricePerShare;
    private Integer noOfShares;
    private String openingDate;
    private String openingTime;
    private String companyName;

}
