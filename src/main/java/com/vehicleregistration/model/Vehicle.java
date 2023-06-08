package com.vehicleregistration.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String vehicleNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;

	private String vehicleName;

//	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER ,targetEntity = VehicleExpense.class)
//	/* @PrimaryKeyJoinColumn */
//	@JoinColumn(name = "expense_id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vehicle")
	@JoinColumn(name = "vehExpense_id")
	private VehicleExpense vehicleExpense;

	public Vehicle(int id, String vehicleNumber, Date registrationDate, String vehicleName,
			VehicleExpense vehicleExpense) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.registrationDate = registrationDate;
		this.vehicleName = vehicleName;
		this.vehicleExpense = vehicleExpense;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleExpense getVehicleExpense() {
		return vehicleExpense;
	}

	public void setVehicleExpense(VehicleExpense vehicleExpense) {
		this.vehicleExpense = vehicleExpense;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
