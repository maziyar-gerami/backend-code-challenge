package com.maziyar.services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.maziyar.packing.Commodity;

@Service
public interface Repository extends JpaRepository <Commodity, Integer> {
    
}
