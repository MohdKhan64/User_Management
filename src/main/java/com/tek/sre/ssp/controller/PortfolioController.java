package com.tek.sre.ssp.controller;

import com.tek.sre.ssp.entity.Portfolio;
import com.tek.sre.ssp.service.PortfolioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Portfolio")
@RequestMapping("/api/v1")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping("/portfolio")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return this.portfolioService.createPortfolio(portfolio);
    }

}
