package com.SpringBoot.utill;

import org.springframework.stereotype.Component;

@Component("hockey")
public class HockeyCoach implements Coach {

	@Override
	public String getPractiece() {

		
		return "Practiece Hockey 15 min in a day properly.....!!!";

	}

}
