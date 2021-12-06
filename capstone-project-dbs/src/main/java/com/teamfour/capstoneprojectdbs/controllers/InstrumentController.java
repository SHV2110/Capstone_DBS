package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teamfour.capstoneprojectdbs.beans.Client;
import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.repositories.InstrumentRepository;
import com.teamfour.capstoneprojectdbs.services.InstrumentService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class InstrumentController {
	@Autowired
    InstrumentService instrumentService;
	private static final Logger LOG = LoggerFactory.getLogger(CustodianController.class);
    @GetMapping(value="instrument/{id}")
    public ResponseEntity<Instrument> getInstrument(@PathVariable("id") String id) {
   	LOG.info("get instrument by id");
        Instrument instrument = instrumentService.findByInstrumentId(id);
        return new ResponseEntity<>(instrument, HttpStatus.OK);
    }

    @GetMapping(value="instruments")
    public ResponseEntity<List<Instrument>> getAllInstruments(){
    	LOG.info("get all instruments");
        return new ResponseEntity<>(instrumentService.findAll(),HttpStatus.OK);
    }

}
