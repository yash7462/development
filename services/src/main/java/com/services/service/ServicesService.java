package com.services.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.services.beans.Category;
import com.services.beans.Services;
import com.services.exception.ResourceNotFoundException;

public interface ServicesService {

	public List<Category> readAllCategory();

	public ResponseEntity<Category> updateCategory(long categoryid, Category category) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteCategory(long categoryid) throws Exception;

	public ResponseEntity<Optional<Services>> readAllService(long categoryid);

	public Services addService(@Valid Services services);

	public ResponseEntity<Services> updateService(long serviceid, Services service) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteService(long serviceid) throws Exception;

	public Category addCategory(@Valid String categoryname);

}
