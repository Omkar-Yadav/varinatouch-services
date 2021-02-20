package com.variantouch.vadt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.variantouch.vadt.dto.Test;
import com.variantouch.vadt.model.EnergyConsumption;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.ECService;

@RestController
@RequestMapping("/vtadmin/ec")
public class ECController {

	@Autowired
	private com.variantouch.vadt.dao.EnergyConsumptionRepository energyConsumptionRepository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/", produces = "application/json")
	public Test testmethod() {
		Test t1 = new Test();
		t1.setMessage("my string");
		return t1;

	}

	@Autowired
	private ECService energyConsumptionService;

	@GetMapping(path = "/getAllEc", produces = "application/json")
	public VTResponse<List<EnergyConsumption>> getAllEnergyConsumptions() {
		return energyConsumptionService.getAllEnergyConsumptions();
	}

	@GetMapping(path = "getEc/{energyConsumptionid}", produces = "application/json")
	public VTResponse<EnergyConsumption> getEnergyConsumption(
			@PathVariable(name = "energyConsumptionid", required = true) long id) {
		return energyConsumptionService.getEnergyConsumption(id);
	}

	@PostMapping(path = "/saveEc", produces = "application/json")
	public VTResponse<EnergyConsumption> saveEnergyConsumption(@RequestBody com.variantouch.vadt.dto.EnergyConsumption energyConsumption) {
		return energyConsumptionService.saveEnergyConsumption(energyConsumption);
	}

	@PutMapping(path = "/editEc", produces = "application/json")
	public VTResponse<EnergyConsumption> editEnergyConsumption(@RequestBody com.variantouch.vadt.dto.EnergyConsumption energyConsumption) {
		return energyConsumptionService.editEnergyConsumption(energyConsumption);
	}

	@DeleteMapping(path = "/deleteEc", produces = "application/json")
	public VTResponse<String> deleteEnergyConsumption(@RequestBody EnergyConsumption energyConsumption) {
		return energyConsumptionService.deleteEnergyConsumption(energyConsumption);
	}
}
