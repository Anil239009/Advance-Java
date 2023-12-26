package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stations")
public class Station extends BaseEntity {
	
	private String station_code;
	private String station_Name;
	private int	No_Of_Platforms;
	
	@ManyToOne
	@JoinColumn(name = "railway_Id", nullable = false)
	@JsonIgnore
	private Railway railway;
//		Railway_Id(FK)

}
