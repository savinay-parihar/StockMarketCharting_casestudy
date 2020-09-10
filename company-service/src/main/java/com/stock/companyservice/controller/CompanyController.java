package com.stock.companyservice.controller;

import com.stock.companyservice.dto.CompanyDto;
import com.stock.companyservice.model.Company;
import com.stock.companyservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService=companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<Iterable<CompanyDto>> getCompanyDetails(){
        return new ResponseEntity<Iterable<CompanyDto>>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping("/companies")
    public  ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
        return new ResponseEntity<CompanyDto>(companyService.addCompany(companyDto),HttpStatus.CREATED);
    }

    @PutMapping("companies/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto,@PathVariable("companyId") Integer companyId)
    {
        return new ResponseEntity<>(companyService.updateCompany(companyDto,companyId),HttpStatus.OK);
    }

    @DeleteMapping("companies/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") Integer companyId)
    {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("companies/findbyPattern/{pattern}")
    public ResponseEntity<List<CompanyDto>> findByPattern(@PathVariable("pattern") String pattern){
        return new ResponseEntity<>(companyService.searchByPattern(pattern),HttpStatus.OK);
    }

}
