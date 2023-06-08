package com.vehicleregistration.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vehicleregistration.model.Vehicle;

public interface VehicleService {

	Vehicle getVehicleById(int id);

	public void deleteVehicleById(int id);

	List<Vehicle> getAllVehicle();

	Vehicle createOrUpdateVehicle(Vehicle vehicle);

	Vehicle UpdateVehicleRegistraton(Vehicle vehicle);

	List<Vehicle> searchVehicle(String vehicleName);

}
