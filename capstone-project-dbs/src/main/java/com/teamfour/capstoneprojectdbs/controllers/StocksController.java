package com.teamfour.capstoneprojectdbs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfour.capstoneprojectdbs.beans.Stocks;
import com.teamfour.capstoneprojectdbs.services.StockService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class StocksController {

    @Autowired
    StockService stockService;
    private static final Logger LOG = LoggerFactory.getLogger(StocksController.class);
    @GetMapping(value="stocks")
    public ResponseEntity<List<Stocks>> getAllStocks(){
    	LOG.info("get all stocks");
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

}
