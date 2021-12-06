package com.teamfour.capstoneprojectdbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teamfour.capstoneprojectdbs.beans.Client;
import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.beans.Stocks;
import com.teamfour.capstoneprojectdbs.repositories.StocksRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class TestController {
	@Autowired
        StocksRepository stocksRepository;

        @GetMapping(value="stocks/{id}")
        public ResponseEntity<List<Stocks>> getStocksByClientId(@PathVariable("id") Client id) {
                List<Stocks> stocks = stocksRepository.findAllByClient(id);
                return new ResponseEntity<List<Stocks>>(stocks, HttpStatus.OK);
        }

        @GetMapping(value="stocks/{clientId,instrumentId}")
        public ResponseEntity<Optional<Stocks>> getStocksByClientAndInstrument(@PathVariable("clientId") Client clientId,
                                                        @PathVariable("instrumentId") Instrument instrumentId) {
                Optional<Stocks> stocks = stocksRepository.findByClientAndInstrument(clientId, instrumentId);
                return new ResponseEntity<Optional<Stocks>>(stocks, HttpStatus.OK);
        }
}
