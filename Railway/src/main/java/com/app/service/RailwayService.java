package com.app.service;

import java.util.List;

import com.app.dto.AddRailwayDto;

public interface RailwayService {
	List<AddRailwayDto> getAllRailway(String cat);
	
	AddRailwayDto addRailway(AddRailwayDto railway);
	String deleteRailway(Long railId);

	
}
