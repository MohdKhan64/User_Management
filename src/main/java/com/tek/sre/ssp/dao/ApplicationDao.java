package com.tek.sre.ssp.dao;

import com.tek.sre.ssp.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDao extends JpaRepository<Application, Integer> {


}
