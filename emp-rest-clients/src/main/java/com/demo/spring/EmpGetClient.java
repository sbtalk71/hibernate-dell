package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class EmpGetClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		ResponseEntity<String> resp=rt.getForEntity("http://localhost:8181/emp/find/"+107, String.class);
		System.out.println(resp.getBody());
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity req=new HttpEntity<>(headers);
		
		
		ResponseEntity<Emp> resp1=rt.exchange("http://localhost:8181/emp/find/"+107, HttpMethod.GET, req, Emp.class);
	
		System.out.println(resp1.getBody().getEmpName());
	}

}
