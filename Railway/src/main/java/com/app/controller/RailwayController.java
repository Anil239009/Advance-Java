package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddRailwayDto;
import com.app.dto.ApiResponse;
import com.app.service.RailwayService;

@RestController
@RequestMapping("/railways")
public class RailwayController {
	@Autowired
	private RailwayService railService;

	@GetMapping
	public List<AddRailwayDto> getAllRailway(@RequestParam String Cat){
		System.out.println(Cat);
		return railService.getAllRailway(Cat.toUpperCase());
	}
	
	@PostMapping
	public AddRailwayDto addRailway(@RequestBody AddRailwayDto railwaydto) {
		return railService.addRailway(railwaydto);
	}

	@DeleteMapping("/{railId}")
	public ResponseEntity<?> deleteRailway(@PathVariable Long railId) {
		try {
			return ResponseEntity.ok(new ApiResponse(railService.deleteRailway(railId)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
