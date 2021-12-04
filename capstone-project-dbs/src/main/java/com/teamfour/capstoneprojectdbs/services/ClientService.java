package com.teamfour.capstoneprojectdbs.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfour.capstoneprojectdbs.beans.Client;
import com.teamfour.capstoneprojectdbs.beans.Custodian;
import com.teamfour.capstoneprojectdbs.repositories.ClientRepository;
import com.teamfour.capstoneprojectdbs.repositories.CustodianRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
	@Autowired
    ClientRepository clientRepository;
	@Autowired
    CustodianRepository custodianRepository;

    public Client findByClientId(String clientId) {
        return clientRepository.findById(clientId).get();
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public List<Client> findAllByCustodian(String custodianId){
        Custodian custodian = custodianRepository.findById(custodianId).get();
        return clientRepository.findAllByCustodian(custodian);
    }
}
