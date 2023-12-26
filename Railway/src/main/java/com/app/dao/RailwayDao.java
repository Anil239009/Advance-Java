package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Railway;
import com.app.pojos.TrainType;

public interface RailwayDao extends JpaRepository<Railway, Long> {
	public List<Railway> findByTarinType(TrainType trainType);
}
