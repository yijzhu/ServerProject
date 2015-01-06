package DAO;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	 public Employee findByEmployeeID(String id);
	 
	 public List<Employee> getAllEmployee();
	 
	 public int updateEmployee(Employee employee);
	 
	 public int insertEmployee(Employee employee);
	 
	 public int deleteEmployee(int id);
}

