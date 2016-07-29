package com.endava.jpa.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private int id;

	private String name;

	//OneToMany relation with employee
	@OneToMany(targetEntity=Employee.class, mappedBy="department", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Department() {}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
