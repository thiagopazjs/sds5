package com.dev.desvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.desvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long> {

}
