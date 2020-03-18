package com.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.services.beans.Category;
import com.services.beans.Services;
import com.services.exception.ResourceNotFoundException;
import com.services.repository.CategoryRepository;
import com.services.repository.ServicesRepository;

@Component
@Qualifier("ServiceDao")
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	public ServicesRepository servicesrepository;

	@Autowired
	public CategoryRepository categoryrepository;

	/**
	 * show all category
	 */
	public List<Category> readAllCategory() {
		
		return categoryrepository.findAll();

	}
	/**
	 * add category
	 */
	public Category addCategory(@Valid @RequestParam(name = "categoryname") String categoryname) {
		return categoryrepository.save(categoryname);
	}

	public ResponseEntity<Category> updateCategory(@PathVariable(value = "categoryid") long categoryid,
			@Valid @RequestBody Category categorydetails) throws ResourceNotFoundException {
		Category cg = categoryrepository.findById(categoryid)
				.orElseThrow(() -> new ResourceNotFoundException("categoryid not found on : " + categoryid));
		cg.setCategoryname(categorydetails.getCategoryname());
		

		final Category updatedCategory = categoryrepository.save(cg);
		return ResponseEntity.ok(updatedCategory);

	}

	public Map<String, Boolean> deleteCategory(@PathVariable(value = "categoryid") long categoryid) throws Exception {
		Category category = categoryrepository.findById(categoryid)
				.orElseThrow(() -> new ResourceNotFoundException(" customer not found  on : " + categoryid));
		categoryrepository.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	public ResponseEntity<Optional<Services>> readAllService(@PathVariable(value = "plantmasterId") long categoryid) {
		Optional<Services> service = servicesrepository.findById(categoryid);
		return ResponseEntity.ok().body(service);
	}

	public Services addService(@Valid @RequestBody Services services) {
		
		return servicesrepository.save(services);
	}

	public ResponseEntity<Services> updateService(@PathVariable(value = "serviceid") long serviceid,
			@Valid @RequestBody Services service) throws ResourceNotFoundException {
		Services sg = servicesrepository.findById(serviceid)
				.orElseThrow(() -> new ResourceNotFoundException("services not found on : " + serviceid));

		
		sg.setServicename(service.getServicename());
		sg.setServicedescription(service.getServicedescription());
		sg.setServiceduration(service.getServiceduration());
		sg.setServicecost(service.getServicecost());
		sg.setComments(service.getComments());

		final Services updatedServices = servicesrepository.save(sg);
		return ResponseEntity.ok(updatedServices);

	}

	public Map<String, Boolean> deleteService(@PathVariable(value = "serviceid") long serviceid) throws Exception {
		Services service = servicesrepository.findById(serviceid)
				.orElseThrow(() -> new ResourceNotFoundException(" service not found  on : " + serviceid));
		servicesrepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
