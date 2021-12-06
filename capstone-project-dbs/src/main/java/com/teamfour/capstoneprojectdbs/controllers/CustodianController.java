package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfour.capstoneprojectdbs.beans.Custodian;
import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.services.CustodianService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustodianController {

    @Autowired
    CustodianService custodianService;

    @GetMapping(value="custodians")
    public ResponseEntity<List<Custodian>> getAllCustodians(){
        return new ResponseEntity<>(custodianService.findAll(), HttpStatus.OK);
    }
}
