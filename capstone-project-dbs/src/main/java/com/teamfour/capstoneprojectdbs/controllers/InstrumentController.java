package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;

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
public class InstrumentController {
	@Autowired
    InstrumentService instrumentService;
    
    @GetMapping(value="instrument/{id}")
    public ResponseEntity<Instrument> getClient(@PathVariable("id") String id) {
        Instrument instrument = instrumentService.findByInstrumentId(id);
        return new ResponseEntity<>(instrument, HttpStatus.OK);
    }

    @GetMapping(value="instruments")
    public ResponseEntity<List<Instrument>> getAllInstruments(){
        return new ResponseEntity<>(instrumentService.findAll(),HttpStatus.OK);
    }

}
