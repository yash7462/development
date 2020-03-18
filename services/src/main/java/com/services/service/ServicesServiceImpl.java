package com.services.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.services.beans.Category;
import com.services.beans.Services;
import com.services.dao.ServiceDao;
import com.services.exception.ResourceNotFoundException;

@Service("ServicesService")
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	public ServiceDao servicedao;

	public List<Category> readAllCategory() {
		return servicedao.readAllCategory();

	}

	public Category addCategory(@Valid String categoryname) {
		return servicedao.addCategory(categoryname);
	}
	


	
	public ResponseEntity<Category> updateCategory(long categoryid, Category category) throws ResourceNotFoundException {
		return servicedao.updateCategory(categoryid, category);

	}

	public Map<String, Boolean> deleteCategory(long categoryid) throws Exception {
		return servicedao.deleteCategory(categoryid);

	}

	public ResponseEntity<Optional<Services>> readAllService(long categoryid) {
		return servicedao.readAllService(categoryid);
	}

	public Services addService(@Valid Services services) {
		return servicedao.addService(services);

	}

	public ResponseEntity<Services> updateService(long serviceid, Services service) throws ResourceNotFoundException {
		return servicedao.updateService(serviceid, service);

	}

	public Map<String, Boolean> deleteService(long serviceid) throws Exception {
		return servicedao.deleteService(serviceid);

	}

	

	
}
