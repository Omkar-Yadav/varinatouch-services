package com.variantouch.vadt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.variantouch.vadt.model.Module;
import com.variantouch.vadt.response.VTResponse;
import com.variantouch.vadt.service.ModuleService;

@RestController
@RequestMapping("/vtadmin/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@GetMapping(path = "/getAllModules", produces = "application/json")
	public VTResponse<List<Module>> getAllModules() {
		return moduleService.getAllModules();
	}

	@GetMapping(path = "getModule/{moduleid}", produces = "application/json")
	public VTResponse<Module> getModule(@PathVariable(name = "moduleid", required = true) long id) {
		return moduleService.getModule(id);
	}

	@PostMapping(path = "/saveModule", produces = "application/json")
	public VTResponse<Module> saveModule(@RequestBody Module module) {
		return moduleService.saveModule(module);
	}

	@PutMapping(path = "/editModule", produces = "application/json")
	public VTResponse<Module> editModule(@RequestBody Module module) {
		return moduleService.editModule(module);
	}

	@DeleteMapping(path = "/deleteModule", produces = "application/json")
	public VTResponse<String> deleteModule(@RequestBody Module module) {
		return moduleService.deleteModule(module);
	}

}
