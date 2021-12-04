package com.teamfour.capstoneprojectdbs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamfour.capstoneprojectdbs.beans.OrderBook;
import com.teamfour.capstoneprojectdbs.models.ClientWiseStats;
import com.teamfour.capstoneprojectdbs.models.CustodianWiseStats;
import com.teamfour.capstoneprojectdbs.models.OrderBookRequest;
import com.teamfour.capstoneprojectdbs.repositories.OrderBookRepository;
import com.teamfour.capstoneprojectdbs.services.DashboardService;
import com.teamfour.capstoneprojectdbs.services.TransactionService;

import jdk.internal.org.jline.utils.Log;

import java.util.List;

@RestController
public class TransactionController {
	private static final Logger LOG = LoggerFactory.getLogger(StocksController.class);
    @Autowired
    TransactionService transactionService;

    @Autowired
    DashboardService dashboardService;

    @Autowired
    OrderBookRepository orderBookRepository;

    @GetMapping("orderBook")
    public List<OrderBook> getAllOrders() {
    	LOG.info("get all orders");
        return orderBookRepository.findAll();
    }

    @PostMapping("transaction")
    public ResponseEntity<OrderBook> transaction(@RequestBody OrderBookRequest orderBookRequest) {
    	Log.info("transaction intiated");
        OrderBook orderBook = transactionService.processTransaction(orderBookRequest);
        return new ResponseEntity<>(orderBook, HttpStatus.OK);
    }

    @GetMapping("custodianWiseStats")
    public ResponseEntity<List<CustodianWiseStats>> getCustodianWiseStats() {
    	LOG.info("Custodian Stats");
        List<CustodianWiseStats> stats = dashboardService.getCustodianWiseStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping("clientWiseStats")
    public ResponseEntity<List<ClientWiseStats>> getClientWiseStats() {
    	Log.info("Clients stats");
        List<ClientWiseStats> stats = dashboardService.getClientWiseStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}
