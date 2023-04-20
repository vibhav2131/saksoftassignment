package in.sacksoft.project.servise;

import java.util.List;
import java.util.Optional;

import in.sacksoft.project.bindings.EmployeeForm;
import in.sacksoft.project.entity.Employees;

public interface EmployeeService {

	public List<Employees> getAllEmployees();

	public Optional<Employees> getEmployee(Integer id);

	public String upsert(EmployeeForm emp);

	public String deleteEmployee(Integer id);

}
