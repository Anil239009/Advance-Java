package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="railways")

public class Railway extends BaseEntity{
	
	@Column(length = 30)
	private String trainName;
	
	@Enumerated(value=EnumType.STRING)
	private TrainType tarinType; 
	
	private LocalDate start_time; 
	private LocalDate end_time;
	private String source;
	private String destiation;
	
	@OneToMany(mappedBy = "railway",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Station> station=new ArrayList<>();
	
	public void addStation(Station station) {
		this.station.add(station);
		station.setRailway(this);
	}
	public void removeStation(Station station) {
		this.station.remove(station);
		station.setRailway(null);
	}
	
	
}
