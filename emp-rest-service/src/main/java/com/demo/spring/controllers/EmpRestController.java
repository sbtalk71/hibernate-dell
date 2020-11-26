package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	// @RequestMapping(path="/emp/find/{empId}",method = RequestMethod.GET,produces
	// = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/emp/find/{empId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmp(@PathVariable("empId") int id, @RequestHeader("Accept") String header) {
		
		System.out.println(header);
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

	@PostMapping(path = "/emp/save", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e) {

		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp ALready Exists in database");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Emp saved in database");
		}
	}

	@PutMapping(path = "/emp/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateEmp(@RequestBody Emp e) {
		if (!repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp does not Exist in database");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Emp updated in database");
		}
	}
	
	@DeleteMapping(path = "/emp/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmp(@RequestParam("id")int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Emp Removed...");
		} else {
			
			return ResponseEntity.ok("Emp not found...");
		}
	}
}
