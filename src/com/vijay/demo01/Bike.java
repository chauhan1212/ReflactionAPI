package com.vijay.demo01;

public class Bike extends Vehicle {
	
	private String idCode = "100";
	
	private String getPrivate() {
		return "How did you get this?";
	}
	
	VehicleFactory vehicleFactory;
	
	private String getOtherPrivate(int thisInt, String str) {
		return "How did you get here " + thisInt + " " + str;
	}
	
	public Bike(VehicleFactory vehicleFactory) {
		this.vehicleFactory = vehicleFactory;
	}
	
	public Bike(int num, String str) {
		System.out.println("You sent : "+ num + " " +  str);
	}

	@Override
	public String toString() {
		return "Bike";
	}
	
	
	

}
