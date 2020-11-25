package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	//@Autowired //(as we are using AOP)
	//private Audience audience;

	@Override
	public void perform() {
		//audience.takeSeat();
		//audience.switchOffMobiles();
		System.out.println("The Singer is now Singing...");
		//audience.applaud();

	}

}
