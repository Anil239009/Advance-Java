package com.app.service;

import java.util.List;

import com.app.dto.AddStationDto;
import com.app.dto.StationDto;

public interface StationService {
	List<StationDto>getAllStation();
	AddStationDto addStation(AddStationDto station);
}
