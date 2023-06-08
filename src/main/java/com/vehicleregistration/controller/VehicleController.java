package com.vehicleregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vehicleregistration.model.Vehicle;
import com.vehicleregistration.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicle() {
		List<Vehicle> list = vehicleService.getAllVehicle();

		return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
	}

	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) {
		Vehicle vehicle = vehicleService.getVehicleById(id);

		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@PostMapping("/saveVehicle")
	public ResponseEntity<Vehicle> createOrUpdateVehicle(@RequestBody Vehicle vehicle) {

		Vehicle createOrupdated = vehicleService.createOrUpdateVehicle(vehicle);
		return new ResponseEntity<Vehicle>(createOrupdated, HttpStatus.OK);
	}

	@PutMapping("/vehicles/update")
	public ResponseEntity<Vehicle> UpdateVehicleRegistraton(@RequestBody Vehicle vehicle) {

		Vehicle vehicleupdated = vehicleService.UpdateVehicleRegistraton(vehicle);

		return new ResponseEntity<Vehicle>(vehicleupdated, HttpStatus.OK);

	}

	@DeleteMapping("/vehicles/{id}")
	public String deleteVehicle(@PathVariable("id") int id) {
		this.vehicleService.deleteVehicleById(id);
		return " Record Deleted Succefully";

	}

	@GetMapping("/search")
	public ResponseEntity<List<Vehicle>> searchVehicle(@RequestParam(value = "vehicleName") String vehicleName) {

		List<Vehicle> vehicleSearch = vehicleService.searchVehicle(vehicleName);

		return new ResponseEntity<List<Vehicle>>(vehicleSearch, HttpStatus.OK);

	}
}
