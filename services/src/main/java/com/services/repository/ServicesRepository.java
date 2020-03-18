package com.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.beans.Services;

@Repository
public interface ServicesRepository 
extends JpaRepository<Services, Long>{

}
