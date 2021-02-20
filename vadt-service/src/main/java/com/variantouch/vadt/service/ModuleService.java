package com.variantouch.vadt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.ModuleRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.model.Module;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;

@Service
public class ModuleService {

	@Autowired
	ModuleRepository moduleRepository;

	public VTResponse<Module> getModule(Long id) {
		VTResponse<Module> response = new VTResponse<Module>();

		try {
			response.setData(moduleRepository.findByid(id));
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	public VTResponse<List<Module>> getAllModules() {
		VTResponse<List<Module>> response = new VTResponse<List<Module>>();

		try {
			response.setData(moduleRepository.findAll());
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Module> saveModule(@RequestBody Module module) {
		VTResponse<Module> response = new VTResponse<Module>();

		try {
			if(moduleRepository.findByid(module.getModuleId()) == null)
			response.setData(moduleRepository.save(module));
			else {
				throw new BadRequestException("provided module is already available in the records ");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<Module> editModule(@RequestBody Module module) {
		VTResponse<Module> response = new VTResponse<Module>();

		try {
			
			if(moduleRepository.findByid(module.getModuleId()) == null)
				throw new BadRequestException("provided module is not available in the records ");
			else {
				response.setData(moduleRepository.save(module));
			}
			response.setData(moduleRepository.save(module));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteModule(@RequestBody Module module) {
		VTResponse<String> response = new VTResponse<String>();

		try {
			if(moduleRepository.findByid(module.getModuleId()) == null)
				throw new BadRequestException("provided module is not available in the records ");
			else {
				moduleRepository.delete(module);
				response.setData("Deleted the record successfully");
			}
			
		} catch (Exception e) {
			throw e;
		}
		return response;
	}
}
