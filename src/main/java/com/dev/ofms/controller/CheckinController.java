package com.dev.ofms.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ofms.model.Checkin;
import com.dev.ofms.repository.CheckinRepository;
import com.dev.ofms.utils.CheckinUtils;


@RestController
@RequestMapping("/api/checkin")
public class CheckinController {
	
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CheckinController.class);
	
	@Autowired
	CheckinRepository checkinRepository;

	@GetMapping("/{checkinId}")
    public Optional<Checkin> getCheckInDetails(@PathVariable String checkinId) {
        return checkinRepository.findById(checkinId);
    }
	
	@PostMapping("/save")
	public Checkin saveCheckinDetails(@RequestBody Checkin checkin) {
		String seatNum = CheckinUtils.generateSessionKey(2,"012345")+CheckinUtils.generateSessionKey(1,"ABCD");
		checkin.setSeatNumber(seatNum);
		return checkinRepository.save(checkin);
	}
}
