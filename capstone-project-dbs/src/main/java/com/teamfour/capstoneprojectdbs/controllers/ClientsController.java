package com.teamfour.capstoneprojectdbs.controllers;

import lombok.AllArgsConstructor;

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

    @GetMapping(value = "client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
        Client client = clientService.findByClientId(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>(clientService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "clientsByCustodian/{custodianId}")
    public ResponseEntity<List<Client>> getAllClientsByCustodian(@PathVariable("custodianId") String custodianId){
        List<Client> clients =  clientService.findAllByCustodian(custodianId);
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testMethod() {
        throw new ResourceNotFoundException("something went wrong");
    }
}
