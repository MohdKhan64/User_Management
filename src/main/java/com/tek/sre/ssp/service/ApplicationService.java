package com.tek.sre.ssp.service;

import com.tek.sre.ssp.dao.ApplicationDao;
import com.tek.sre.ssp.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;

    public Application createApplication(@NotNull Application application) {
        return applicationDao.save(application);
    }

}
