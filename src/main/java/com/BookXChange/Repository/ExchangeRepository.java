package com.BookXChange.Repository;

import com.BookXChange.Model.ExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeModel, Long> {
}
