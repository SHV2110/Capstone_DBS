package com.teamfour.capstoneprojectdbs.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfour.capstoneprojectdbs.beans.Custodian;
import com.teamfour.capstoneprojectdbs.repositories.CustodianRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustodianService {
	@Autowired
    CustodianRepository custodianRepository;

    public List<Custodian> findAll(){
        return custodianRepository.findAll();
    }
}
