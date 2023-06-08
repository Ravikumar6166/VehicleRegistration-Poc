package com.vehicleregistration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.vehicleregistration.model.Vehicle;
import com.vehicleregistration.repository.VehicleRepository;

@Service
public class VehicleServiceimpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle createOrUpdateVehicle(Vehicle vehicle) {

		Vehicle vehicles = new Vehicle();
		vehicles.setId(vehicle.getId());
		vehicles.setVehicleName(vehicle.getVehicleName());
		vehicles.setRegistrationDate(vehicle.getRegistrationDate());
		vehicles.setVehicleNumber(vehicle.getVehicleNumber());

		vehicles = vehicleRepository.save(vehicles);

		return vehicles;

	}

	@Override
	public Vehicle getVehicleById(int id) {
		// TODO Auto-generated method stub
		Optional<Vehicle> vehicleEntity = vehicleRepository.findById(id);

		if (vehicleEntity.isPresent()) {
			return vehicleEntity.get();
		} else
			throw new RuntimeException(" Vehicle not found for " + id);
	}

	@Override
	public void deleteVehicleById(int id) {
		// TODO Auto-generated method stub
		this.vehicleRepository.deleteById(id);
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicleList = vehicleRepository.findAll();

		if (vehicleList.size() > 0) {
			return vehicleList;
		} else {
			return new ArrayList<Vehicle>();
		}
	}

	@Override
	public Vehicle UpdateVehicleRegistraton(Vehicle vehicle) {

		Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicle.getId());
		if (vehicleEntity.isPresent()) {
			Vehicle vehicles = new Vehicle();
			vehicles.setId(vehicle.getId());
			vehicles.setVehicleName(vehicle.getVehicleName());
			vehicles.setRegistrationDate(vehicle.getRegistrationDate());
			vehicles.setVehicleNumber(vehicle.getVehicleNumber());
			vehicleRepository.save(vehicles);
			return vehicles;
		}
		return vehicle;

	}

	@Override
	public List<Vehicle> searchVehicle(String vehicleName) {
		List<Vehicle> vehicles = vehicleRepository.searchVehicle(vehicleName);
		return vehicles;
	}

	/*
	 * @Override public List<Vehicle> getAllVehicle(String keyword) { // TODO
	 * Auto-generated method stub if(keyword != null) { return
	 * vehicleRepository.search(keyword); }else
	 * 
	 * return (List<Vehicle>) vehicleRepository.findAll(); }
	 */

}
