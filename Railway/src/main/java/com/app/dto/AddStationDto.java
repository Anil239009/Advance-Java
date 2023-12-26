package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddStationDto {

	private String station_code;
	private String station_Name;
	private int	No_Of_Platforms;
	private Long railway_Id;
	
}
