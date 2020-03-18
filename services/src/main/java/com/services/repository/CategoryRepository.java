package com.services.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.beans.Category;

@Repository
public interface CategoryRepository 
extends JpaRepository<Category, Long>{

	Category save(@Valid String categoryname);

}
