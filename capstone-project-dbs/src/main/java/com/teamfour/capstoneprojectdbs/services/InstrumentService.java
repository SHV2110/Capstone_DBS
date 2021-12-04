package com.teamfour.capstoneprojectdbs.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.repositories.InstrumentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InstrumentService {
	@Autowired
    InstrumentRepository instrumentRepository;

    public Instrument findByInstrumentId(String instrumentId) {
        return instrumentRepository.findById(instrumentId).get();
    }

    public List<Instrument> findAll(){
        return instrumentRepository.findAll();
    }
}
