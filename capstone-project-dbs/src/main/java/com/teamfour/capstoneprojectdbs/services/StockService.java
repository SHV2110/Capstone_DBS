package com.teamfour.capstoneprojectdbs.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfour.capstoneprojectdbs.beans.Client;
import com.teamfour.capstoneprojectdbs.beans.Instrument;
import com.teamfour.capstoneprojectdbs.beans.Stocks;
import com.teamfour.capstoneprojectdbs.exceptions.ValidationException;
import com.teamfour.capstoneprojectdbs.repositories.StocksRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StockService {
	@Autowired
    StocksRepository stocksRepository;

    
    @Transactional
    public Stocks saveStock(Client client, Instrument instrument, Integer quantity) {
        Stocks getOrCreate = stocksRepository.findByClientAndInstrument(client, instrument).orElseGet(() -> {
            Stocks newStock = new Stocks();
            newStock.setStockId(UUID.randomUUID().toString());
            newStock.setClient(client);
            newStock.setInstrument(instrument);
            newStock.setQuantity(0);
            return newStock;
        });
        int finalQuantity = getOrCreate.getQuantity()+quantity;
        if(finalQuantity<0){
            throw new ValidationException("the seller doesn't have the required number of stocks to complete transaction");
        }
       
        getOrCreate.setQuantity(getOrCreate.getQuantity() + quantity);
        System.out.println(getOrCreate);
        stocksRepository.save(getOrCreate);
        return getOrCreate;
    }


    Stocks getStockQuantity(Client client, Instrument instrument) {
        return stocksRepository.findByClientAndInstrument(client, instrument).orElseGet(() -> {
            Stocks newStock = new Stocks();
            newStock.setStockId(UUID.randomUUID().toString());
            newStock.setClient(client);
            newStock.setInstrument(instrument);
            newStock.setQuantity(0);
            return newStock;
        });
    }

    public List<Stocks> getAllStocks(){
        return stocksRepository.findAll();
    }

}

