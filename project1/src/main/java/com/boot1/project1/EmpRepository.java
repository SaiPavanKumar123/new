package com.boot1.project1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	private List<Employee> emplist = new ArrayList<Employee>();

	@Override
	public List<Employee> getAllEmployees() {
		if (emplist.size() == 0) {

			// Create some emmployees and add to the list
			emplist.add(new Employee(1001, 10, "Manager", 19000.00, "Mahesh"));
			emplist.add(new Employee(1002, 20, "Developer", 12000.00, "Nareesh"));
			emplist.add(new Employee(1003, 30, "Tester", 10000.00, "Suresh"));
			emplist.add(new Employee(1004, 10, "DBA", 15000.00, "Rajesh"));
			emplist.add(new Employee(1005, 20, "admin", 10000.00, "Sujesh"));
			emplist.add(new Employee(1006, 30, "HR", 7000.00, "Somesh"));
		}
		return emplist;
	}

	public Employee getEmployeeByEmpNo(int eno) {
		for (Employee e : emplist) {
			if (e.getEmpNo() == eno)
				return e;
		}
		return null;
	}

	public void addEmployee(Employee e) {
		emplist.add(e);
	}

	public void deleteEmployee(int empno) {
		Employee emp = getEmployeeByEmpNo(empno);
		emplist.remove(emp);
	}

	public void updateEmployee(Employee emp) {
		deleteEmployee(emp.getEmpNo());
		emplist.add(emp);
	}
}
