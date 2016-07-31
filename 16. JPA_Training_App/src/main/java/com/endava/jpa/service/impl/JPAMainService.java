package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public Department findDepartmentById(int id) {
		Department department = departmentService.find(id);
		return department;
	}

	public void findDepartmentByName() {
		List<Department> departments = departmentService.find("Prj");
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	 public void insertDepartment(String name) {
	 	 Department department = new Department();

		 department.setName(name);
	     departmentService.save(department);
	 }

	 /**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment(int id, String name) {
		 Department department = departmentService.find(id);
		 if(department != null) {
			 department.setName(name);
			 departmentService.update(department);
		 }
		 else System.out.println("The department does not exist!");
	}

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment(int id) {
		Department department = departmentService.find(id);
		if(department != null) {
           /*for(int i = 0; i < department.getEmployees().size(); i++) {
                 department.getEmployees().get(i).setDepartment(null);
            }*/

			departmentService.remove(department);
		}
		else System.out.println("The department does not exist!");
	}

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee(String name, int salary, int deptId, String street, String city, String state, String zipCode, Timestamp birthday) {
		Employee employee = new Employee();

		employee.setName(name);
		employee.setSalary(salary);
		employee.setDepartment(departmentService.find(deptId));
		employee.setStreet(street);
		employee.setCity(city);
		employee.setState(state);
		employee.setZipCode(zipCode);
		employee.setBirthday(birthday);

		employeeService.save(employee);
	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){
		List<Employee> list = employeeService.find("Bucharest");
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){
	}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
