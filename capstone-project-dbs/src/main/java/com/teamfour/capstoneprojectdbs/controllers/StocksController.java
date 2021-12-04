package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.beans.Stocks;
import com.teamfour.capstoneprojectdbs.services.StockService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StocksController {

    @Autowired
    StockService stockService;

    @GetMapping(value="stocks")
    public ResponseEntity<List<Stocks>> getAllInstruments(){
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

}
