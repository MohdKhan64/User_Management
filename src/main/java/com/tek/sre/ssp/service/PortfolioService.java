package com.tek.sre.ssp.service;

import com.tek.sre.ssp.dao.PortfolioDao;
import com.tek.sre.ssp.entity.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioDao portfolioDao;

    public Portfolio createPortfolio(@NotNull Portfolio portfolio) {
        return portfolioDao.save(portfolio);
    }

}
