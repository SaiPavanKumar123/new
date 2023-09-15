package com.boot1.project1;

public class Employee {
	private Integer empNo;
	private Integer deptNo;

	private String job;
	private Double salary;
	private String eName;

	public Employee(Integer empNo, Integer deptNo, String job, Double salary, String eName) {
		super();
		this.empNo = empNo;
		this.deptNo = deptNo;
		this.job = job;
		this.salary = salary;
		this.eName = eName;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Employee() {

	}

}