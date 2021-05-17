package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

// http://localhost:8080/api/employee
@RestController
@RequestMapping("/employee/apii")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// http://localhost:8080/api/employee/
	@PostMapping("/")
	public String createEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return "Employee Created!";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id, @RequestBody Employee e) {
		Employee emp = employeeRepository.findById(id).get();
		
		if(emp != null) {
			emp.setEmail(e.getEmail());
			emp.setMobile(e.getMobile());
			employeeRepository.save(emp);
		}
		
		return "updated";
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		
		 employeeRepository.deleteById(id);
		return "deleted";
	}

}
