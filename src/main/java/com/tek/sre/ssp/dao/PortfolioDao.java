package com.tek.sre.ssp.dao;

import com.tek.sre.ssp.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDao extends JpaRepository<Portfolio, Integer> {
}
