package com.boot1.project1;

import java.util.List;

public interface IEmpRepository {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeByEmpNo(int eno);

	public void addEmployee(Employee e);

	public void deleteEmployee(int empno);

	public void updateEmployee(Employee emp);
}
