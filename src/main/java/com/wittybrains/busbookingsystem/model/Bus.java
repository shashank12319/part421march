package com.wittybrains.busbookingsystem.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="bus")
public class Bus {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String number;
	    private String type;
        @OneToOne
        private User driver;
        
       // private double seatCost;
        
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bus")
	    private List<Booking> bookings;
//        @OneToMany(mappedBy = "bus")
//	    private List<Seat> seats;
//
//        private int availableSeat;
//        private int numberOfSeats;
//        private int totalSeats;

//		public int getNumberOfSeats() {
//			return numberOfSeats;
//		}
//
//		public void setNumberOfSeats(int numberOfSeats) {
//			this.numberOfSeats = numberOfSeats;
//		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

//		public List<Seat> getSeats() {
//			return seats;
//		}
//
//		public void setSeats(List<Seat> seats) {
//			this.seats = seats;
//		}
//
//		public int getTotalSeats() {
//			return totalSeats;
//		}
//
//		public void setTotalSeats(int totalSeats) {
//			this.totalSeats = totalSeats;
//		}
		

//		    public double getSeatCost() {
//		        return seatCost;
//		    }
//
//		    public void setSeatCost(double seatCost) {
//		        this.seatCost = seatCost;
//		    }
//		    
		 // Calculate the number of available seats 
//			public int getAvailableSeat() {
//				
//				int availableSeat = totalSeats - numberOfSeats;
//				return availableSeat;
//			}
//
//			
//
//			public void setAvailableSeat(int availableSeat) {
//				this.availableSeat = availableSeat;
//			}

	}
