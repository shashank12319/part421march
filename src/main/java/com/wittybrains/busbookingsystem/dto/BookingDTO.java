package com.wittybrains.busbookingsystem.dto;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wittybrains.busbookingsystem.model.Booking;


@JsonInclude(value = Include.NON_NULL)

public class BookingDTO {
    private Long bookingId;

    private TravelScheduleDTO schedule;
    
    private int numberOfSeats;
    private double seatCost;
    private Double totalAmount;
    private BusDTO bus;
    private UserDTO user;
    private String seatStatus;
    private int availableSeat;
    private int totalSeats;
    public BookingDTO() {
        super();
    }

    public UserDTO getUser() {
        return user;
    }

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.schedule = new TravelScheduleDTO(booking.getSchedule());
       
        
        this.numberOfSeats=booking.getNumberOfSeats();
        this.user = new UserDTO(booking.getUser());
        this.seatCost = booking.getSeatCost();
        this.totalSeats = this.bus != null ? this.bus.getTotalSeats() : 0;
        this.setTotalAmount(this.numberOfSeats, this.seatCost);
        if (booking.getBus() != null) {
        this.bus = new BusDTO(booking.getBus());
        }
         
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public TravelScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(TravelScheduleDTO schedule) {
        this.schedule = schedule;
    }

    public BusDTO getBus() {
        return bus;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setUser(UserDTO userDTO) {
        this.user = userDTO;
    }

    

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String bookingStatus) {
        this.seatStatus = bookingStatus;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(double seatCost) {
        this.seatCost = seatCost;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int numSeats, double seatCost) {
        double subtotal = numSeats * seatCost;
        double gst = subtotal * 0.12;
        this.totalAmount = subtotal + gst;
    }

    public int getAvailableSeat() {
		
		int availableSeat = totalSeats - numberOfSeats;
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}
}
