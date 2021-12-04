package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teamfour.capstoneprojectdbs.beans.Client;
import com.teamfour.capstoneprojectdbs.exceptions.ResourceNotFoundException;
import com.teamfour.capstoneprojectdbs.services.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientsController {
	@Autowired
    ClientService clientService;
	private static final Logger LOG = LoggerFactory.getLogger(ClientsController.class);
    @GetMapping(value = "client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
    	LOG.info("Get Client by ID");
        Client client = clientService.findByClientId(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> getAllClients(){
    	LOG.info("Get all clients");
        return new ResponseEntity<>(clientService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "clientsByCustodian/{custodianId}")
    public ResponseEntity<List<Client>> getAllClientsByCustodian(@PathVariable("custodianId") String custodianId){
    	LOG.info("Get All clients by custodian");
    	List<Client> clients =  clientService.findAllByCustodian(custodianId);
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testMethod() {
    	LOG.info("test method called");
        throw new ResourceNotFoundException("something went wrong");
    }
}
