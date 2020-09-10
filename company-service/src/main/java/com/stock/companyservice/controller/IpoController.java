package com.stock.companyservice.controller;

import com.stock.companyservice.model.Ipo;
import com.stock.companyservice.service.IpoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IpoController {

    IpoService ipoService;

    public void IpoController(IpoService ipoService)
    {
        this.ipoService=ipoService;
    }

    @GetMapping("/ipo/{companyName}")
    public ResponseEntity<List<Ipo>> getIpo(@PathVariable("companyName") String companyName){
        return new ResponseEntity<List<Ipo>>(ipoService.getIpo(companyName), HttpStatus.OK);
    }

    @PostMapping("/ipoDetails")
    public ResponseEntity<Ipo> addIpo(@RequestBody Ipo ipo){
        return new ResponseEntity<>(ipoService.addIpo(ipo),HttpStatus.CREATED);
    }
}
