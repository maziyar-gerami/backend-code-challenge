package com.maziyar.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maziyar.services.packing.Commodity;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    
}
