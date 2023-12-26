package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RailwayDao;
import com.app.dao.StationDao;
import com.app.dto.AddStationDto;
import com.app.dto.StationDto;
import com.app.pojos.Railway;
import com.app.pojos.Station;
@Service
@Transactional
public class StationServiceImpl implements StationService {
	@Autowired
	private StationDao sDao;
	@Autowired
	private RailwayDao railDao;
	@Autowired ModelMapper mapper;
	@Override
	public AddStationDto addStation(AddStationDto station) {
		System.out.println(station.getRailway_Id());
		Railway rail=railDao.findById(station.getRailway_Id()).orElseThrow();
		if(rail!=null) {
			Station st=mapper.map(station, Station.class);
			rail.addStation(st);
			return station;
		}
		return null;
	}
	@Override
	public List<StationDto> getAllStation() {
		
		return sDao.findAll().stream().
				map(e->mapper.map(e, StationDto.class)).
				collect(Collectors.toList());
	}

}
