package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddStationDto;
import com.app.dto.StationDto;
import com.app.service.StationService;

@RestController
@RequestMapping("/stations")
public class StationController {
	@Autowired
	private StationService stationService;
	@GetMapping
	public List<StationDto>getAllStations(){
		return stationService.getAllStation();
	}
	
	@PostMapping
	public AddStationDto addStation(@RequestBody AddStationDto dto) {
		System.out.println(dto);
		return stationService.addStation(dto);
	}
}
