package com.wittybrains.busbookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.model.Bus;
import com.wittybrains.busbookingsystem.repository.BusRepository;

@Service
public class BusService {

	private final BusRepository busRepository;
	private final Logger logger = LoggerFactory.getLogger(BusService.class);

	public BusService(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	public List<BusDTO> createBuses(List<BusDTO> busList) {
		List<BusDTO> createdBuses = new ArrayList<>();

		for (BusDTO busDTO : busList) {


			Bus bus = new Bus();
			
			bus.setType(busDTO.getType());
			

			busRepository.save(bus);

			

			logger.info("New bus created: {}", busDTO);
		}

		return createdBuses;
	}

}
