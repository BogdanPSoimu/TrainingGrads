package com.endava.jpa.main;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.impl.JPAMainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		JPAMainService jpaMainService = (JPAMainService)context.getBean("JPAMainService");

		/**
		 * Comment unneeded method invocations.
		 */
		jpaMainService.findDepartment();
		jpaMainService.findDepartmentByName();

		Department department = new Department(7, "ITS");
		Timestamp timestamp = new Timestamp(1994, 7, 15, 1, 1,1, 1);
		Employee employee = new Employee(7, "Mircea", 99999, department, "frunzei", "bucharest", "romania", "800", timestamp);

//		jpaMainService.insertDepartment("IT");
//		jpaMainService.updateDepartment(1, "HR1");
//		jpaMainService.deleteDepartment(1);
		jpaMainService.insertEmployee(employee);
//		jpaMainService.getEmployeesFromBucharest();
//		jpaMainService.giveSalaryRaise();
//		jpaMainService.removeEmployee();


	}
}
