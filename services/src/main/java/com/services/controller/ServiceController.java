package com.services.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.beans.Category;
import com.services.beans.Services;
import com.services.business.ServiceBusiness;
import com.services.exception.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/servicecategory")
public class ServiceController {

	@Autowired
	private ServiceBusiness servicebusiness;

	@GetMapping("/")
	@ApiOperation(value = "", notes = "Get all services category")
	public List<Category> GetAllCategory() {
		// m.addAttribute("list", plantmasterbusiness.readAllPlantMaster());
		return servicebusiness.readAllCategory();
	}
	
	@PostMapping("/")
	@ApiOperation(value = "", notes = "insert category")
	public Category createCategory(@Valid @RequestParam(name = "categoryname") String categoryname) {

		return servicebusiness.addCategory(categoryname);

	}
	
	@PutMapping("/{categoryid}")
	@ApiOperation(value = "", notes = "edit category name")
	public ResponseEntity<Category> editCategory(@PathVariable(value = "categoryid") long categoryid,
			@Valid @RequestBody Category category) throws ResourceNotFoundException {
		return servicebusiness.updateCategory(categoryid, category);
	}

	@DeleteMapping("/{categoryid}")
	@ApiOperation(value = "", notes = "delete whole category column")
	public Map<String, Boolean> deletePlantMaster(@PathVariable(value = "categoryid") long categoryid)
			throws Exception {
		return servicebusiness.deleteCategory(categoryid);
	}

	// services

	@GetMapping("/service/{categoryid}")
	@ApiOperation(value = "", notes = "number of services based on category")
	public ResponseEntity<Optional<Services>> getAllServiceByCategory(@PathVariable(value = "categoryid") long categoryid) {
		// m.addAttribute("list", plantmasterbusiness.readAllPlantMaster());
		return servicebusiness.readAllService(categoryid);
	}

	@PostMapping("/service")
	@ApiOperation(value = "", notes = "insert serviceitem")
	public Services createService(@Valid @RequestBody Services service) {

		return servicebusiness.addService(service);

	}

	@PutMapping("/service/{serviceid}")
	@ApiOperation(value = "", notes = "edit only serviceitem based on its serviceid	")
	public ResponseEntity<Services> editService(@PathVariable(value = "categoryid") long serviceid,
			@Valid @RequestBody Services service) throws ResourceNotFoundException {
		return servicebusiness.updateService(serviceid , service);
	}

	@DeleteMapping("/{serviceid}")
	@ApiOperation(value = "", notes = "delete only serviceitem based on its serviceid")
	public Map<String, Boolean> deleteService(@PathVariable(value = "serviceid") long serviceid) throws Exception {
		return servicebusiness.deleteService(serviceid);
	}

}
