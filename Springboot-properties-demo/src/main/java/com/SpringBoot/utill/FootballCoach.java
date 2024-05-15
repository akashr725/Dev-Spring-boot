package com.SpringBoot.utill;

import org.springframework.stereotype.Component;

@Component("football")
public class FootballCoach implements Coach {

	@Override
	public String getPractiece() {
		
		return "Practiece Football 15 min in a day properly.....!!!";
	}

}
