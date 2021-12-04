package com.teamfour.capstoneprojectdbs.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfour.capstoneprojectdbs.models.ClientWiseStats;
import com.teamfour.capstoneprojectdbs.models.CustodianWiseStats;
import com.teamfour.capstoneprojectdbs.repositories.OrderBookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DashboardService {
	@Autowired
    OrderBookRepository orderBookRepository;

    public List<CustodianWiseStats> getCustodianWiseStats() {
        return orderBookRepository.getCustodianWiseStats();
    }

    public List<ClientWiseStats> getClientWiseStats() {
        return orderBookRepository.getClientWiseStats();
    }


}
