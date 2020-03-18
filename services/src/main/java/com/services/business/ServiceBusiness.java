package com.services.business;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.services.beans.Category;
import com.services.beans.Services;
import com.services.exception.ResourceNotFoundException;
import com.services.service.ServicesService;
@Component
public class ServiceBusiness {

	@Autowired
	public ServicesService serviceservice;
	
	public List<Category> readAllCategory() {
		return serviceservice.readAllCategory();
	}

	public ResponseEntity<Category> updateCategory(long categoryid, Category category) throws ResourceNotFoundException {
		return serviceservice.updateCategory(categoryid , category);
	}

	public Map<String, Boolean> deleteCategory(long categoryid) throws Exception {
		return serviceservice.deleteCategory(categoryid);

	}

	public ResponseEntity<Optional<Services>> readAllService(long categoryid) {
		return serviceservice.readAllService(categoryid);

	}

	public Services addService(@Valid Services service) {
		return serviceservice.addService(service);

	}

	public ResponseEntity<Services> updateService(long serviceid, Services service) throws ResourceNotFoundException {
		return serviceservice.updateService(serviceid , service);

	}

	public Map<String, Boolean> deleteService(long serviceid) throws Exception {
		return serviceservice.deleteService(serviceid);

	}

	public Category addCategory(@Valid String categoryname) {
		return serviceservice.addCategory(categoryname);
	}

}
