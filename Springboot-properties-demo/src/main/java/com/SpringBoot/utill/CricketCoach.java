package com.SpringBoot.utill;

import org.springframework.stereotype.Component;

@Component("cricket")
public class CricketCoach implements Coach {
	

	@Override
	public String getPractiece() {
		
		return "Practiece Cricket 15 min in a day properly.....!!!";
	}

}
