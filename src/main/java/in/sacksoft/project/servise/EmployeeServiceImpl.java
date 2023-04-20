package in.sacksoft.project.servise;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sacksoft.project.Repository.EmployeeRepository;
import in.sacksoft.project.bindings.EmployeeForm;
import in.sacksoft.project.entity.Employees;
import in.sacksoft.project.exception.SacksoftException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	public static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	@Autowired
	public EmployeeRepository repo;

	@Override
	public List<Employees> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Optional<Employees> getEmployee(Integer id) {
		if (id < 100) {
			throw new SacksoftException();
		}
		Optional<Employees> findById = repo.findById(id);
		return findById;
	}

	@Override
	public String deleteEmployee(Integer id) {
		repo.deleteById(id);
		return "Successfully delete";
	}

	@Override
	public String upsert(EmployeeForm emp) {
		Employees entity = new Employees();
		BeanUtils.copyProperties(emp, entity);
		repo.save(entity);
		return "Successfully saved";
	}

}
