package payroll;

import java.util.List;

//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// https://stackoverflow.com/questions/25855698/how-can-i-retrieve-basic-authentication-credentials-from-the-header

@RestController
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/employees")
	List<Employee> all() {
		System.out.println(("[EmployeeController.all"));
		return repository.findAll();
	}

	@PostMapping("/employees")
//	@Secured("ROLE_ADMIN")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}