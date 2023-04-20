package in.sacksoft.project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sacksoft.project.bindings.EmployeeForm;
import in.sacksoft.project.entity.Employees;
import in.sacksoft.project.servise.EmployeeService;

@RestController
public class SacksoftController {

	@Autowired
	public EmployeeService service;

	@GetMapping("/Employee")
	public ResponseEntity<List<Employees>> getAllTheEmployees() {
		List<Employees> allEmployees = service.getAllEmployees();
		return new ResponseEntity<List<Employees>>(allEmployees, HttpStatus.OK);
	}

	@GetMapping("Employee/{id}")
	public ResponseEntity<Optional<Employees>> findSpecificEmplyee(@PathVariable Integer id) {
		Optional<Employees> emp = service.getEmployee(id);
		return new ResponseEntity<Optional<Employees>>(emp, HttpStatus.OK);

	}

	@PostMapping("/Employee")
	public ResponseEntity<String> upsert(@RequestBody EmployeeForm emp) {
		String upsert = service.upsert(emp);
		return new ResponseEntity<String>(upsert, HttpStatus.CREATED);
	}

	@DeleteMapping("/Employee/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		String deleteEmployee = service.deleteEmployee(id);
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
	}
}