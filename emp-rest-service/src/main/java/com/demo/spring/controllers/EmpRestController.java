package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	// @RequestMapping(path="/emp/find/{empId}",method = RequestMethod.GET,produces
	// = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/emp/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmp(@PathVariable("empId") int id) {
		Optional<Emp> empOp = repo.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.ok("{\"status\":\"emp not found with id " + id + "\"}");
		}
	}

	@GetMapping(path = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> listAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping(path = "/emp/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e,HttpServletRequest req) {
		//System.out.println(req.getParameterMap());
		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp ALready Exists in database");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Emp saved in database");
		}
	}
}
