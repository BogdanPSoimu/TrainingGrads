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
		Department department = jpaMainService.findDepartmentById(1);
//		jpaMainService.findDepartmentByName();

		Timestamp timestamp = new Timestamp(94, 7, 15, 1, 1,1, 1);
		System.out.println(timestamp.toString());

//		jpaMainService.insertDepartment("IT");
//		jpaMainService.updateDepartment(1, "HR1");
//		jpaMainService.deleteDepartment(1);
//		jpaMainService.insertEmployee("Mircea", 99999, 2, "frunzei", "Bucharest", "Romania", "800111", timestamp);
//		jpaMainService.getEmployeesFromBucharest();
//		jpaMainService.giveSalaryRaise();
//		jpaMainService.removeEmployee();


	}
}
