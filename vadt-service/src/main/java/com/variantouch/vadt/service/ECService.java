package com.variantouch.vadt.service;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.variantouch.vadt.dao.EnergyConsumptionRepository;
import com.variantouch.vadt.exceptions.BadRequestException;
import com.variantouch.vadt.exceptions.RecordNotFoundException;
import com.variantouch.vadt.model.EnergyConsumption;
import com.variantouch.vadt.response.VTError;
import com.variantouch.vadt.response.VTResponse;

@Service
public class ECService {

	@Autowired
	private EnergyConsumptionRepository energyConsumptionRepository;

	public VTResponse<EnergyConsumption> getEnergyConsumption(Long id) {
		VTResponse<EnergyConsumption> response = new VTResponse<EnergyConsumption>();

		try {
			response.setData(energyConsumptionRepository.findByid(id));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<List<EnergyConsumption>> getAllEnergyConsumptions() {
		VTResponse<List<EnergyConsumption>> response = new VTResponse<List<EnergyConsumption>>();

		try {
			response.setData(energyConsumptionRepository.findAll());
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<EnergyConsumption> saveEnergyConsumption(@RequestBody com.variantouch.vadt.dto.EnergyConsumption eConsumption) {
		VTResponse<EnergyConsumption> response = new VTResponse<EnergyConsumption>();

		try {
			System.out.println("========================================================"+(eConsumption.getUser()));
			EnergyConsumption energyConsumption = new EnergyConsumption();
			energyConsumption.setId(eConsumption.getId());
			energyConsumption.setPower(eConsumption.getPower());
			energyConsumption.setUser(eConsumption.getUser());
			if(energyConsumptionRepository.findByid(energyConsumption.getId()) == null) {
				response.setData(energyConsumptionRepository.save(energyConsumption));
			} else {
				throw new BadRequestException("Record with the provided id is already present");
			}
			
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<EnergyConsumption> editEnergyConsumption(@RequestBody com.variantouch.vadt.dto.EnergyConsumption eConsumption) {
		VTResponse<EnergyConsumption> response = new VTResponse<EnergyConsumption>();

		try {
			EnergyConsumption energyConsumption = new EnergyConsumption();
			energyConsumption.setId(eConsumption.getId());
			energyConsumption.setPower(eConsumption.getPower());
			energyConsumption.setDateTime(eConsumption.getDateTime());
			energyConsumption.setUser(eConsumption.getUser());
			if(energyConsumptionRepository.findByid(energyConsumption.getId()) == null) {
				throw new BadRequestException("The record with provieded is not available");
			}
			response.setData(energyConsumptionRepository.save(energyConsumption));
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public VTResponse<String> deleteEnergyConsumption(@RequestBody EnergyConsumption energyConsumption) {
		VTResponse<String> response = new VTResponse<String>();

		try { 
			if(energyConsumptionRepository.findByid(energyConsumption.getId()) == null) {
				throw new BadRequestException("Record with provied id is not available");
			}else {
				energyConsumptionRepository.delete(energyConsumption);
				response.setData("Deleted the record successfuly");
			}
			
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
