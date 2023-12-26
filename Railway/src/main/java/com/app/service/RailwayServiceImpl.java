package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RailwayDao;
import com.app.dto.AddRailwayDto;
import com.app.pojos.Railway;
import com.app.pojos.TrainType;
@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	@Autowired
	private RailwayDao railDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AddRailwayDto addRailway(AddRailwayDto railway) {
		railDao.save(mapper.map(railway, Railway.class));
		return railway;
	}

	@Override
	public String deleteRailway(Long railId) {
		if(railDao.existsById(railId)) {
			railDao.deleteById(railId);
			return "Railway deleted Successfully..!";
		}
		return "Id Not Found";
	}

	@Override
	public List<AddRailwayDto> getAllRailway(String cat) {
		List<AddRailwayDto> list=railDao.findByTarinType(TrainType.valueOf(cat))
				.stream().map(e->mapper.map(e, AddRailwayDto.class)).collect(Collectors.toList());
		System.out.println(list);
		return list;
	}

}
