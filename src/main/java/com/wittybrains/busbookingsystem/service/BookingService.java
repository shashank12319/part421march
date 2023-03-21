
package com.wittybrains.busbookingsystem.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wittybrains.busbookingsystem.dto.BookingDTO;
import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.dto.UserDTO;
import com.wittybrains.busbookingsystem.exception.TravelScheduleNotFoundException;
import com.wittybrains.busbookingsystem.exception.UserNotFoundException;
import com.wittybrains.busbookingsystem.model.Booking;
import com.wittybrains.busbookingsystem.model.Bus;
import com.wittybrains.busbookingsystem.model.TravelSchedule;
import com.wittybrains.busbookingsystem.model.User;
import com.wittybrains.busbookingsystem.repository.BookingRepository;
import com.wittybrains.busbookingsystem.repository.BusRepository;
import com.wittybrains.busbookingsystem.repository.TravelScheduleRepository;
import com.wittybrains.busbookingsystem.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;
	private final UserRepository userRepository;
	private final TravelScheduleRepository travelScheduleRepository;
	private final BusRepository busRepository;
	private final Logger logger = LoggerFactory.getLogger(BookingService.class);

	public BookingService(BookingRepository bookingRepository, BusRepository busRepository,
			TravelScheduleRepository travelScheduleRepository, UserRepository userRepository) {
		this.bookingRepository = bookingRepository;
		this.userRepository = userRepository;
		this.travelScheduleRepository = travelScheduleRepository;
		this.busRepository=busRepository;

	}

	public BookingDTO createBooking(BookingDTO bookingDTO) {
		logger.info("Creating booking with bookingDTO: {}", bookingDTO);

		
		
		if (bookingDTO.getSchedule() == null || bookingDTO.getSchedule().getId() == null) {
			throw new IllegalArgumentException("Schedule ID cannot be null");
		}
		if (bookingDTO.getUser() == null || bookingDTO.getUser().getId() == null) {
			throw new IllegalArgumentException("User ID cannot be null");
		}
		     Booking booking = new Booking();

		    UserDTO userDTO = bookingDTO.getUser();
		    Optional<User> optionalUser = userRepository.findById(userDTO.getId());
		    User user = optionalUser.orElseThrow(() -> new UserNotFoundException("User not found for id: " + userDTO.getId()));
		    booking.setUser(user);

		    Optional<TravelSchedule> optionalTravelSchedule = travelScheduleRepository.findById(bookingDTO.getSchedule().getId());
		    TravelSchedule travelSchedule = optionalTravelSchedule.orElseThrow(() -> new TravelScheduleNotFoundException("Travel schedule not found for id: " + bookingDTO.getSchedule().getId()));
		    booking.setSchedule(travelSchedule);

//		    BusDTO busDTO = bookingDTO.getBus();
//		    Optional<Bus> optionalBus = busRepository.findById(busDTO.getId());
//		    Bus bus = optionalBus.orElseThrow();
//		    booking.setBus(bus);
		    
           
          
		    int numberOfSeats = bookingDTO.getNumberOfSeats();
		    booking.setNumberOfSeats(numberOfSeats);

		    double seatCost = bookingDTO.getSeatCost();
		    booking.setSeatCost(seatCost);
		    
      
		    double totalAmount = numberOfSeats * seatCost;
		    booking.setTotalAmount(totalAmount);

		     
		    Booking savedBooking = bookingRepository.save(booking);
		    logger.info("Booking created with savedBooking: {}", savedBooking);

		    return new BookingDTO(savedBooking);
		}
	}
