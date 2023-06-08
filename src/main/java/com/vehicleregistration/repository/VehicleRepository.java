package com.vehicleregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicleregistration.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Query("SELECT vehicle  FROM Vehicle  vehicle where vehicle.vehicleName=:vehicleName")
	public List<Vehicle> searchVehicle(@Param("vehicleName") String vehicleName);

	// public Vehicle findByVehicleName(String vehicleName);
}
