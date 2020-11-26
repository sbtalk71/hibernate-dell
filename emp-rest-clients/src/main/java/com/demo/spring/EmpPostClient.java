package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class EmpPostClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-Type",MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		
		Emp emp=new Emp(408, "Anjani", "Bangalore", 56000);
		
		HttpEntity req=new HttpEntity<>(emp,headers);
		
		
		
		ResponseEntity<String> resp1=rt.exchange("http://localhost:8181/emp/save", HttpMethod.POST, req, String.class);
	
		System.out.println(resp1.getBody());
	}

}
