package com.wittybrains.busbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wittybrains.busbookingsystem.model.Bus;
@JsonInclude(value = Include.NON_NULL)
public class BusDTO {
	private String number;
    private String type;
    private Long id;
    //private int availableSeat;
//    
//
	private int totalSeats;
   

    public BusDTO() {
    }
    public BusDTO(Bus busDTO) {
		super();
		
		this.setNumber(busDTO.getNumber());
		this.type = busDTO.getType();
		//this.setAvailableSeat(busDTO.getAvailableSeat());
		//this.totalSeats=busDTO.getTotalSeats();
		
    }


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
//	public int getAvailableSeat() {
//		return availableSeat;
//	}
//	public void setAvailableSeat(int availableSeat) {
//		this.availableSeat = availableSeat;
//	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
//	public int getAvailableSeat() {
//		
//		int availableSeat = totalSeats - numberOfSeats;
//		return availableSeat;
//	}
//	public void setAvailableSeat(int availableSeat) {
//		this.availableSeat = availableSeat;
//	}
	
}