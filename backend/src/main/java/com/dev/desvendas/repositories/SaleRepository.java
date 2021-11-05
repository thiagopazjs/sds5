package com.dev.desvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.desvendas.dto.SaleSuccessDTO;
import com.dev.desvendas.dto.SaleSumDTO;
import com.dev.desvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.dev.desvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+"FROM Sale AS obj GROUP BY obj.seller")	
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.dev.desvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+"FROM Sale AS obj GROUP BY obj.seller")	
	List<SaleSuccessDTO> successGroupedBySeller();

}
