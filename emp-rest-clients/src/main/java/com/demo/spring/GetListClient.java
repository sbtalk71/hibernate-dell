package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetListClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity req=new HttpEntity<>(headers);
		
		
		ResponseEntity<List<Emp>> resp1=rt.exchange("http://localhost:8181/emp/", HttpMethod.GET, req, 
				new ParameterizedTypeReference<List<Emp>>() {});
		
		resp1.getBody().forEach(e->System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getSalary()));
	
		
	}

}
