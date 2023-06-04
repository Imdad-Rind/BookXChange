package com.BookXChange.Services;

import com.BookXChange.Model.ExchangeModel;
import com.BookXChange.Repository.ExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServices {

    ExchangeRepository exchangeRepository;

    public ExchangeServices(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

  public void addNewExchangeEntity(ExchangeModel exchangeModel){
        exchangeRepository.save(exchangeModel);
  }

  public ExchangeModel getExchangeEntityById(Long id){
        return exchangeRepository.findById(id).get();
  }

  public void deleteExchangeById(Long id){
        exchangeRepository.deleteById(getExchangeEntityById(id).getID());
  }

}
